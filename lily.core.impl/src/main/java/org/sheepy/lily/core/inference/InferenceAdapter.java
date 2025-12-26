package org.sheepy.lily.core.inference;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.IAdaptable;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.core.api.inference.IInferenceAdapter;
import org.sheepy.lily.core.model.inference.*;
import org.sheepy.lily.core.model.types.Parameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ModelExtender(scope = IAdaptable.class, inherited = true)
@Adapter
public class InferenceAdapter implements IInferenceAdapter
{
	public final InferenceGraph ruleGraph = new InferenceGraph();
	private final Map<Group<?>, List<IInferenceListener>> listeners = new HashMap<>();

	@Override
	public void addInferer(Inferer inferer)
	{
		ruleGraph.registerUnit(inferer);
	}

	@Override
	public void removeInferer(Inferer inferer)
	{
		ruleGraph.unregisterUnit(inferer);
	}

	@Override
	public void postNotification(final LMObject unit, final LNotification notification)
	{
		postNotificationInternal(notification, null);

		final var group = notification.lmGroup();
		if (listeners.containsKey(group))
		{
			for (final var listener : listeners.get(group))
			{
				listener.onNotification(unit, notification);
			}
		}
	}

	@Override
	public <T extends Parameter> void postNotification(final LMObject unit,
													   final ParameteredNotification<T> notification,
													   final T parameter)
	{
		postNotificationInternal(notification, parameter);

		final var group = notification.lmGroup();
		if (listeners.containsKey(group))
		{
			for (final var listener : listeners.get(group))
			{
				listener.onNotification(unit, notification, parameter);
			}
		}
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void postNotificationInternal(AbstractNotification notification, Parameter parameter)
	{
		for (final LRule rule : ruleGraph.getLinkedRules(notification))
		{
			if (rule.notification()
					.match(notification))
			{
				boolean match = true;

				for (final Condition c : rule.conditions())
				{
					if (c.getType()
						 .isInstance(parameter) == false || c.match(parameter) == false)
					{
						match = false;
						break;
					}
				}

				if (match)
				{
//					final ActionExecutionContext ec = new ActionExecutionContext(	((Inferer) rule.eContainer()).lExecutor(),
//																					rule.getAction(),
//																					parameter);
//
//					// TO-DO si actionDispatcher est null, il faut mettre de coté
//					// les notif pour
//					// les executer plus tard
//
//					final var application = (Application) EcoreUtil.getRootContainer(adaptedEntity);
//					final var adapter = application.adaptNotNull(IApplicationAdapter.class);
//					adapter.getCadencer().postAction(ec);
				}
			}
		}
	}

	@Override
	public void addNotificationListener(final Group<?> listenedGroup, final IInferenceListener listener)
	{
		final var list = listeners.computeIfAbsent(listenedGroup, k -> new ArrayList<>());
		list.add(listener);
	}

	@Override
	public void removeNotificationListener(final Group<?> listenedGroup, final IInferenceListener listener)
	{
		listeners.remove(listenedGroup, listener);
	}
}
