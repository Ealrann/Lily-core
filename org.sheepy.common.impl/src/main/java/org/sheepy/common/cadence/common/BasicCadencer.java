package org.sheepy.common.cadence.common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.cadence.ICadencer;
import org.sheepy.common.api.cadence.IStatistics;
import org.sheepy.common.api.cadence.ITicker;
import org.sheepy.common.api.resource.IResourceManager;
import org.sheepy.common.api.service.ServiceManager;
import org.sheepy.common.api.util.LContentAdapter;
import org.sheepy.common.model.root.LObject;

public class BasicCadencer implements ICadencer
{
	protected Deque<Resource> resources = new ArrayDeque<>();

	protected List<TickerWrapper> tickers = new ArrayList<>();
//	protected List<ProcessorTickerWrapper> cadencedProcessors = new ArrayList<>();

	private final List<Long> threadsId = new ArrayList<>();
	private final List<Resource> cadencedResources = new ArrayList<>();

	protected IResourceManager resourceManager = IResourceManager.getService();
	protected CommandStack commandStack = new CommandStack();
	protected IServiceAdapterFactory adapterFactory = IServiceAdapterFactory.INSTANCE;
	protected ECrossReferenceAdapter crossReferencer = new ECrossReferenceAdapter();

	private final IStatistics statistics = ServiceManager.getService(IStatistics.class);

	private final List<IUnitListener> listeners = new ArrayList<>();

	private final LContentAdapter unitContentAdapter = new CadencedUnitContentAdater(this);

	@Override
	@SuppressWarnings("unchecked")
	public void deleteObject(EObject eo)
	{
		for (Setting seting : crossReferencer.getInverseReferences(eo))
		{
			EObject referencer = seting.getEObject();
			EStructuralFeature feature = seting.getEStructuralFeature();

			if (feature.isMany())
			{
				List<EObject> list = (List<EObject>) referencer.eGet(feature);
				list.remove(eo);
			}
			else
			{
				referencer.eSet(feature, null);
			}
		}

		EcoreUtil.remove(eo);
	}

	private class CadencedUnitContentAdater extends LContentAdapter
	{
		private final ICadencer cadencer;

		public CadencedUnitContentAdater(ICadencer cadencer)
		{
			super();
			this.cadencer = cadencer;
		}

		@Override
		protected void setTarget(EObject target)
		{
			super.setTarget(target);

			if (target instanceof Resource)
			{
				// Scanning the resource for Processor, Cores, AutoAdapted ...
				Resource resource = (Resource) target;
				for (EObject content : resource.getContents())
				{
					if (content instanceof LObject)
					{
						TreeIterator<LObject> it = ((LObject) content).lAllUnits();

						while (it.hasNext())
						{
							LObject currentUnit = it.next();
							unitAdded(currentUnit);
						}
					}
				}
			}
		};

		@Override
		protected void unitAdded(LObject unit)
		{
//			if (unit instanceof Processor)
//			{
//				ProcessorTickerWrapper wrapper = new ProcessorTickerWrapper(cadencer,
//						(Processor) unit, adapterFactory);
//
//				cadencedProcessors.add(wrapper);
//			}

			fireAddUnit(unit);
		}

		@Override
		protected void unitRemoved(Object oldContainer, LObject unit)
		{
			fireRemoveUnit(unit);

//			if (unit instanceof Processor)
//			{
//				removeProcessorWrapper((Processor) unit);
//			}
		}
	};

//	private void removeProcessorWrapper(Processor proc)
//	{
//		for (int i = 0; i < cadencedProcessors.size(); i++)
//		{
//			ProcessorTickerWrapper wrapper = cadencedProcessors.get(i);
//			if (wrapper.getProcessor() == proc)
//			{
//				// If found, put the last here and remove the last
//				cadencedProcessors.set(i, cadencedProcessors.get(cadencedProcessors.size() - 1));
//				cadencedProcessors.remove(cadencedProcessors.size() - 1);
//
//				break;
//			}
//		}
//	}

	private Deque<AbstractCadencedWrapper> course = new ArrayDeque<>();
	private Deque<AbstractCadencedWrapper> nextCourse = new ArrayDeque<>();
	private Long mainThread = null;

	@Override
	public void stop()
	{
		statistics.printTickersTime();
		getCommandStack().printStats();

		threadsId.remove(mainThread);
		mainThread = null;
	}

	@Override
	public void tick(long stepNano)
	{
		long duration = System.nanoTime();

		// =========
		// Compute tickers to execute
		// =========
		for (int i = 0; i < tickers.size(); i++)
		{
			AbstractCadencedWrapper ticker = tickers.get(i);
			ticker.accumulate(stepNano);

			if (ticker.shouldTick())
			{
				nextCourse.add(ticker);
			}
		}

		// =========
		// Compute processors to execute
		// =========

//		for (int i = 0; i < cadencedProcessors.size(); i++)
//		{
//			ProcessorTickerWrapper wrapper = cadencedProcessors.get(i);
//			wrapper.accumulate(stepNano);
//
//			if (wrapper.shouldTick())
//			{
//				nextCourse.add(wrapper);
//			}
//		}

		long blockingDuration = System.nanoTime();
		commandStack.execute();
		blockingDuration = System.nanoTime() - blockingDuration;

		statistics.addAccumulatedDuration("Model Commands", blockingDuration);

		// =========
		// Execute tickers
		// =========
		while (nextCourse.isEmpty() == false)
		{
			Deque<AbstractCadencedWrapper> temp = course;
			course = nextCourse;
			nextCourse = temp;

			while (course.isEmpty() == false)
			{
				AbstractCadencedWrapper ticker = course.poll();

				try
				{
					if (ticker.stop.get())
					{
						tickers.remove(ticker);
					}
					else
					{
						long d = System.nanoTime();

						ticker.tick();

						statistics.addTickerTime(ticker.getLabel(), System.nanoTime() - d);
					}

				} catch (Exception e)
				{
					e.printStackTrace();
				}

				if (ticker.shouldTick())
				{
					nextCourse.add(ticker);
				}
			}

			// =========
			// Execute Models Commands
			// =========

			blockingDuration = System.nanoTime();
			commandStack.execute();
			blockingDuration = System.nanoTime() - blockingDuration;

			statistics.addAccumulatedDuration("Model Commands", blockingDuration);
		}

		statistics.addAccumulatedDuration("Cadencer Tick", System.nanoTime() - duration);
		statistics.update();
	}

	@Override
	public void addTicker(ITicker ticker, int frequency)
	{
		TickerWrapper tw = new TickerWrapper(ticker, frequency);

		tickers.add(tw);
	}

	@Override
	public void removeTicker(ITicker ticker, int frequency)
	{
		for (TickerWrapper tickerWrapper : tickers)
		{
			if (tickerWrapper.getFrequency() == frequency && tickerWrapper.ticker == ticker)
			{
				tickerWrapper.stop.set(true);
			}
		}
	}

	@Override
	public CommandStack getCommandStack()
	{
		return commandStack;
	}

	@Override
	public ResourceSet getResourceSet()
	{
		return resourceManager.getResourceSet();
	}

	@Override
	public void addResource(Resource resource)
	{
		addResourceInternal(resource);

		for (EObject eo : resource.getContents())
		{
			if (eo instanceof LObject)
			{
				fireAddUnit((LObject) eo);
				TreeIterator<LObject> it = ((LObject) eo).lAllUnits();
				while (it.hasNext())
				{
					fireAddUnit(it.next());
				}
			}
		}

		cadencedResources.add(resource);
		resource.eAdapters().add(unitContentAdapter);
		resource.eAdapters().add(crossReferencer);
	}

	private void addResourceInternal(Resource resource)
	{
		if (resourceManager.getResourceSet().getResources().contains(resource) == false)
			resourceManager.getResourceSet().getResources().add(resource);

		resources.add(resource);
	}

	public IResourceManager getResourceManager()
	{
		return resourceManager;
	}

	@Override
	public void removeResource(Resource resource)
	{
		if (cadencedResources.remove(resource))
		{
			for (EObject eo : resource.getContents())
			{
				if (eo instanceof LObject)
				{
					fireRemoveUnit((LObject) eo);
					TreeIterator<LObject> it = ((LObject) eo).lAllUnits();
					while (it.hasNext())
					{
						fireRemoveUnit(it.next());
					}
				}
			}
		}

		resources.remove(resource);
		resourceManager.removeResource(resource);

//		List<Processor> toRemove = new ArrayList<>();
//		for (ProcessorTickerWrapper wrapper : cadencedProcessors)
//		{
//			Processor processor = wrapper.getProcessor();
//			if (processor.eResource() == resource)
//			{
//				toRemove.add(processor);
//			}
//		}
//
//		for (Processor processor : toRemove)
//		{
//			removeProcessorWrapper(processor);
//		}

		resource.unload();
	}

	@Override
	public void dispose()
	{
		Collection<Resource> resources = new ArrayList<>(getResourceSet().getResources());

		for (Resource resource : resources)
		{
			removeResource(resource);
		}
	}

	@Override
	public Collection<Long> getCadencedThreadsId()
	{
		return threadsId;
	}

	@Override
	public Collection<Resource> getCadencedResources()
	{
		return cadencedResources;
	}

	@Override
	public void addListener(IUnitListener listener)
	{
		listeners.add(listener);
	}

	@Override
	public void removeListener(IUnitListener listener)
	{
		listeners.remove(listener);
	}

	private void fireAddUnit(LObject unit)
	{
		for (IUnitListener listener : listeners)
		{
			listener.onUnitAdd(unit);
		}
	}

	private void fireRemoveUnit(LObject unit)
	{
		for (IUnitListener listener : listeners)
		{
			listener.onUnitRemove(unit);
		}
	}
}
