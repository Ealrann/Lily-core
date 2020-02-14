package org.sheepy.lily.core.api.adapter.util;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;

import java.util.ArrayList;
import java.util.List;

public final class ModelDependencyInjector
{
	private final List<AdapterObserver<IAllocableAdapter<?>>> observers = new ArrayList<>();
	private final ILilyEObject object;
	private final List<List<EReference>> referenceLists;

	private boolean started = false;

	public ModelDependencyInjector(ILilyEObject object, EReference reference)
	{
		this(object, List.of(List.of(reference)));
	}

	public ModelDependencyInjector(ILilyEObject object, List<List<EReference>> referenceLists)
	{
		this.object = object;
		this.referenceLists = List.copyOf(referenceLists);
	}

	public void start(IAllocationConfigurator configurator)
	{
		assert !started;

		for (var references : referenceLists)
		{
			final var observer = new AdapterObserver<IAllocableAdapter<?>>(IAllocableAdapter.class,
																		   references,
																		   configurator::addDependency,
																		   configurator::removeDependency);
			observer.startObserve(object);
			observers.add(observer);
		}
		started = true;
	}

	public void stop()
	{
		if (started)
		{
			for (var observer : observers)
			{
				observer.setDeliver(false);
				observer.stopObserve(object);
			}
			observers.clear();
			started = false;
		}
	}
}
