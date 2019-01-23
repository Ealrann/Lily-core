//package org.sheepy.common.cadence.common;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicBoolean;
//
//import org.eclipse.emf.ecore.resource.Resource;
//import org.sheepy.common.api.adapter.IServiceAdapterFactory;
//import org.sheepy.common.api.cadence.ICadencer;
//import org.sheepy.common.api.resource.IConfigurationService;
//import org.sheepy.common.api.resource.IResourceManager;
//
//public class CadencerImpl extends AbstractBasicCadencer implements ICadencer
//{
//	private final AtomicBoolean stop = new AtomicBoolean(false);
//	private ExecutorService mainExecutor = null;
//
//	private final long stepNano;
//	private long lastTick;
//	private WriteKeeper wKeep = null;
//
//	private final IConfigurationService config;
//
//	public CadencerImpl(float frequency, IServiceAdapterFactory adapterFactory,
//			IResourceManager resourceManager, IConfigurationService config)
//	{
//		super(adapterFactory, resourceManager);
//		stepNano = (long) (1_000_000_000f / frequency);
//		this.config = config;
//	}
//
//	@Override
//	public void start()
//	{
//		try
//		{
//			mainExecutor = Executors.newSingleThreadExecutor();
//			mainExecutor.submit(new Runnable()
//			{
//				@Override
//				public void run()
//				{
//					lastTick = System.nanoTime();
//					loop();
//				}
//			});
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//
//		System.out.println("[Cadencer] start");
//	}
//
//	@Override
//	public void stop()
//	{
//		stop.set(true);
//
//		if (mainExecutor != null)
//		{
//			try
//			{
//				mainExecutor.shutdown();
//				mainExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
//			} catch (InterruptedException e1)
//			{
//				e1.printStackTrace();
//			} finally
//			{
//				if (!mainExecutor.isTerminated())
//				{
//					System.err.println("cancel non-finished tasks");
//				}
//				mainExecutor.shutdownNow();
//			}
//
//			mainExecutor = null;
//		}
//
//		super.stop();
//
//		System.out.println("[Cadencer] stop");
//	}
//
//	@Override
//	public void addResource(Resource resource)
//	{
//		super.addResource(resource);
//
//		if (config.isDebug())
//		{
//			if (wKeep == null)
//				wKeep = new WriteKeeper(getCommandStack());
//
//			resource.eAdapters().add(wKeep);
//		}
//	}
//
//	@Override
//	public void removeResource(Resource resource)
//	{
//		if (config.isDebug())
//		{
//			wKeep.setEnabled(false);
//			resource.eAdapters().remove(wKeep);
//			wKeep.setEnabled(true);
//		}
//
//		super.removeResource(resource);
//	}
//
//	public void loop()
//	{
//		while (stop.get() == false)
//		{
//			long current = System.nanoTime();
//
//			if (current - lastTick > stepNano)
//			{
//				tick(stepNano);
//				lastTick += stepNano;
//			}
//
//			try
//			{
//				TimeUnit.NANOSECONDS.sleep(stepNano);
//
//			} catch (InterruptedException e)
//			{
//				// e.printStackTrace();
//			}
//		}
//	}
//}
