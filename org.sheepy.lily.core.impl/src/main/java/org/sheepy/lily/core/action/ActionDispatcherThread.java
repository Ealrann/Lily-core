package org.sheepy.lily.core.action;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.sheepy.lily.core.api.action.IActionHandler;
import org.sheepy.lily.core.api.action.context.ExecutionContext;
import org.sheepy.lily.core.api.cadence.EditingCommand;
import org.sheepy.lily.core.api.cadence.ITicker;
import org.sheepy.lily.core.cadence.execution.CommandStack;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.root.XAction;

public class ActionDispatcherThread implements ITicker
{
	private final ConcurrentLinkedDeque<ExecutionContext> externalActions = new ConcurrentLinkedDeque<>();

	private final ActionHandlerRegistry registry = new ActionHandlerRegistry();

	private final CommandStack commandStack;
	private final long threadId;

	public ActionDispatcherThread(CommandStack commandStack, long threadId)
	{
		this.commandStack = commandStack;
		this.threadId = threadId;
	}

	public void postAction(ExecutionContext action)
	{
		if (threadId == (Thread.currentThread().getId()))
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
			// wait for https://bugs.eclipse.org/bugs/show_bug.cgi?id=542872
			// if (action instanceof TypeInjectorAction<?>)
			// {
			// action = ((TypeInjectorAction<?>) action).getAction();
			//
			// context = new ExecutionContext(context.getLUnit(), action,
			// ((TypeInjectorAction<?>) action).getInjectedValue());
			// }

			if (action instanceof XAction)
			{
				final ExecutionContext _context = context;
				final XAction xAction = (XAction) action;
				commandStack.add(new EditingCommand()
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
