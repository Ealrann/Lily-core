package org.sheepy.lily.core.inference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.inference.AbstractNotification;
import org.sheepy.lily.core.model.inference.Inferer;
import org.sheepy.lily.core.model.inference.LRule;

/**
 * @author ealrann
 *
 */
public class InferenceGraph
{
	private final Map<Group<?>, List<LRule>> graph = new HashMap<>();

	public void registerUnit(Inferer inferer)
	{

		// Compute rules graph for the new unit
		if (inferer.rules().isEmpty() == false)
		{
			updateRules(inferer);
		}
	}

	private void updateRules(Inferer inferer)
	{
		for (LRule rule : inferer.rules())
		{
			final var group = rule.notification().lmGroup();
			final var rules = graph.computeIfAbsent(group, k -> new ArrayList<>());

			rules.add(rule);
		}
	}

	public void unregisterUnit(Inferer unit)
	{
		for (List<LRule> list : graph.values())
		{
			list.removeAll(unit.rules());
		}
	}

	public List<LRule> getLinkedRules(AbstractNotification notification)
	{
		return graph.get(notification.lmGroup());
	}
}
