package org.sheepy.common.action;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.sheepy.common.api.action.IActionHandler;
import org.sheepy.common.api.action.context.ExecutionContext;
import org.sheepy.common.api.cadence.EditingCommand;
import org.sheepy.common.api.cadence.ICadencer;
import org.sheepy.common.api.cadence.ITicker;
import org.sheepy.common.model.action.Action;
import org.sheepy.common.model.action.TypeInjectorAction;
import org.sheepy.common.model.action.XAction;

public class ActionDispatcherThread implements ITicker
{
	private final ConcurrentLinkedDeque<ExecutionContext> externalActions = new ConcurrentLinkedDeque<>();

	private final ICadencer cadencer;
	private final ActionHandlerRegistry registry;

	public ActionDispatcherThread(ICadencer cadencer, ActionHandlerRegistry registry)
	{
		this.cadencer = cadencer;
		this.registry = registry;

		cadencer.addTicker(this, -1);
	}

	public void dispose()
	{
		cadencer.removeTicker(this, -1);
	}

	public void postAction(ExecutionContext action)
	{
		if (cadencer.getThreadId() == (Thread.currentThread().getId()))
		{
			run(action);
		}
		else
		{
			// If not a CadencerThread
			externalActions.add(action);
		}
	}

	// public void postActions(Collection<IExecutionContext> actions)
	// {
	// if
	// (cadencer.getCadencedThreadsId().contains(Thread.currentThread().getId()))
	// {
	// run(actions, false);
	// }
	// else
	// {
	// // If not a CadencerThread
	// externalActions.addAll(actions);
	// }
	// }

	@Override
	public void tick(long stepNano)
	{
		Iterator<ExecutionContext> it = externalActions.iterator();
		while (it.hasNext())
		{
			ExecutionContext context = it.next();
			run(context);
			it.remove();
		}
	}

	public void run(ExecutionContext context)
	{

		if (context.getAction() != null)
		{
			Action action = context.getAction();

			// Injector redirection
			if (action instanceof TypeInjectorAction<?>)
			{
				action = ((TypeInjectorAction<?>) action).getAction();

				context = new ExecutionContext(context.getLUnit(), action,
						((TypeInjectorAction<?>) action).getInjectedValue());
			}

			if (action instanceof XAction)
			{
				final ExecutionContext _context = context;
				final XAction xAction = (XAction) action;
				cadencer.getCommandStack().add(new EditingCommand()
				{
					@Override
					public void execute()
					{
						try
						{
							xAction.execute(_context.getLUnit());
						} catch (Exception e)
						{
							e.printStackTrace();
						}
					}
				});
			}
			else
			{
				IActionHandler handler = registry.getHandler(action);

				if (handler != null)
				{
					try
					{
						handler.handle(context);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.err.println(
							"Handler not found for " + context.getAction().eClass().getName());
				}
			}
		}
	}

	@Override
	public String getLabel()
	{
		return getClass().getSimpleName();
	}
}
