package org.sheepy.lily.core.cadence.common;

import org.sheepy.lily.core.api.allocation.IAllocationInstance;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.cadence.ICadenceManager;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.engine.IEngineAllocation;
import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.TimeUtil;
import org.sheepy.lily.core.cadence.execution.CommandStack;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.IEngine;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class CadenceManager implements ICadenceManager
{
	private static final String MAIN_LOOP = "Main Loop";
	private static final String CADENCE = "Cadence";
	private static final String MODEL_COMMANDS = "Model Commands";

	private final Application application;
	private final Runnable stepper;
	private final CommandStack commandStack = new CommandStack();
	private final IStatistics statistics = IStatistics.INSTANCE;
	private final AtomicBoolean stop = new AtomicBoolean(false);
	private final Cadencer cadencer;

	private IInputManager inputManager = null;
	private Long mainThread = null;
	private List<IAllocationInstance<IEngineAllocation>> engineAllocations;

	public CadenceManager(Application application)
	{
		this(application, null);
	}

	public CadenceManager(Application application, Runnable stepper)
	{
		this.application = application;
		this.stepper = stepper;
		this.cadencer = new Cadencer(application);
	}

	public void load()
	{
		stop.set(false);
		mainThread = Thread.currentThread().getId();

		((LilyEObject) application).loadAdapterManager();

		engineAllocations = application.getEngines()
									   .stream()
									   .map(CadenceManager::allocateEngine)
									   .collect(Collectors.toUnmodifiableList());

		inputManager = application.adapt(IInputManager.class);
	}

	public void run()
	{
		long lastUpdate = System.nanoTime();

		while (stop.get() == false)
		{
			final long start = System.nanoTime();
			inputManager.pollInputs();

			final long stepNs = System.nanoTime() - lastUpdate;
			lastUpdate = System.nanoTime();
			tick(stepNs);

			final long d = System.nanoTime();
			for (final var engine : application.getEngines())
			{
				final var engineAdapter = engine.adapt(IEngineAllocation.class);
				if (engineAdapter != null) engineAdapter.step();
			}

			if (stepper != null)
			{
				stepper.run();
			}

			statistics.addTime(CADENCE, MAIN_LOOP, System.nanoTime() - d);
			statistics.addTime(CADENCE, System.nanoTime() - start);
		}

		dispose();
	}

	private void dispose()
	{
		cadencer.free();

		for (final var engineAllocation : engineAllocations)
		{
			engineAllocation.getAllocation().waitIdle();
			engineAllocation.free(null);
		}

		((LilyEObject) application).disposeAdapterManager();

		if (DebugUtil.DEBUG_ENABLED)
		{
			statistics.printTimes();
		}
		statistics.clear();

		mainThread = null;
	}

	private static IAllocationInstance<IEngineAllocation> allocateEngine(final IEngine engine)
	{
		return IAllocationService.INSTANCE.allocate(engine, null, IEngineAllocation.class);
	}

	public void stop()
	{
		stop.set(true);
	}

	public void tick(long stepNs)
	{
		final long appStepNs = computeStepNs();
		long blockingDuration = System.nanoTime();

		// =========
		// Execute Models Commands
		// =========

		commandStack.execute();
		blockingDuration = System.nanoTime() - blockingDuration;
		statistics.addTime(CADENCE, MODEL_COMMANDS, blockingDuration);

		// =========
		// Execute tickers
		// =========

		cadencer.tick(stepNs, appStepNs);

		// =========
		// Execute Models Commands Again
		// =========

		blockingDuration = System.nanoTime();
		commandStack.execute();
		blockingDuration = System.nanoTime() - blockingDuration;
		statistics.addTime(CADENCE, MODEL_COMMANDS, blockingDuration);
	}

	private long computeStepNs()
	{
		final var timeConfig = application.getTimeConfiguration();
		if (timeConfig != null)
		{
			final var unit = TimeUtil.resolveUnit(timeConfig.getUnit());
			final long step = (long) (timeConfig.getTimeStep() * timeConfig.getTimeFactor());
			assert unit != null;
			return unit.toNanos(step);
		}
		else
		{
			return TimeUnit.SECONDS.toNanos(1);
		}
	}

	@Override
	public CommandStack getCommandStack()
	{
		return commandStack;
	}

	@Override
	public long getThreadId()
	{
		return mainThread;
	}

	@Override
	public IInputManager getInputManager()
	{
		return inputManager;
	}
}
