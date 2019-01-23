package org.sheepy.common.inference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.model.inference.AbstractNotification;
import org.sheepy.common.model.inference.Inferer;
import org.sheepy.common.model.inference.LRule;

/**
 * @author ealrann
 *
 */
public class InferenceGraph
{
	private final Map<EClass, List<LRule>> graph = new HashMap<>();

	public void registerUnit(Inferer inferer)
	{

		// Compute rules graph for the new unit
		if (inferer.getRules().isEmpty() == false)
		{
			updateRules(inferer);
		}
	}

	private void updateRules(Inferer inferer)
	{
		for (LRule rule : inferer.getRules())
		{
			var eClass = rule.getNotification().eClass();
			List<LRule> rules = graph.get(eClass);

			if (rules == null)
			{
				rules = new ArrayList<>();
				graph.put(eClass, rules);
			}

			rules.add(rule);
		}
	}

	public void unregisterUnit(Inferer unit)
	{
		for (List<LRule> list : graph.values())
		{
			list.removeAll(unit.getRules());
		}
	}

	public List<LRule> getLinkedRules(AbstractNotification notification)
	{
		return graph.get(notification.eClass());
	}
}
