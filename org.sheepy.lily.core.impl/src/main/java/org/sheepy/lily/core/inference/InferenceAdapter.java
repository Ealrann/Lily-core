package org.sheepy.lily.core.inference;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.logoce.extender.api.IAdaptable;
import org.logoce.extender.api.ModelExtender;
import org.logoce.adapter.api.Adapter;
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
	private final Map<EClass, List<IInferenceListener>> listeners = new HashMap<>();

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
	public void postNotification(EObject adaptedEntity, LNotification notification)
	{
		postNotificationInternal(notification, null);

		if (listeners.containsKey(notification.eClass()))
		{
			for (final var listener : listeners.get(notification.eClass()))
			{
				listener.onNotification(adaptedEntity, notification);
			}
		}
	}

	@Override
	public <T extends Parameter> void postNotification(EObject adaptedEntity,
													   ParameteredNotification<T> notification,
													   T parameter)
	{
		postNotificationInternal(notification, parameter);

		if (listeners.containsKey(notification.eClass()))
		{
			for (final var listener : listeners.get(notification.eClass()))
			{
				listener.onNotification(adaptedEntity, notification, parameter);
			}
		}
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void postNotificationInternal(AbstractNotification notification, Parameter parameter)
	{
		for (final LRule rule : ruleGraph.getLinkedRules(notification))
		{
			if (rule.getNotification()
					.match(notification))
			{
				boolean match = true;

				for (final Condition c : rule.getConditions())
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
	public void addNotificationListener(EClass listenedEclass, IInferenceListener listener)
	{
		final var list = listeners.computeIfAbsent(listenedEclass, k -> new ArrayList<>());
		list.add(listener);
	}

	@Override
	public void removeNotificationListener(EClass clazz, IInferenceListener listener)
	{
		listeners.remove(clazz, listener);
	}
}
