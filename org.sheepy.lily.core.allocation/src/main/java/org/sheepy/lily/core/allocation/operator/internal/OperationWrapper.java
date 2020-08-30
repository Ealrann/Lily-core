package org.sheepy.lily.core.allocation.operator.internal;

import org.sheepy.lily.core.allocation.operation.IOperationNode;

public final class OperationWrapper
{
	public enum EOperationPhase
	{
		PreChildren,
		Main,
		PostChildren
	}

	private final IOperationNode node;
	private final boolean reverse;

	private EOperationPhase phase;

	public OperationWrapper(final IOperationNode node, final boolean reverse)
	{
		this.node = node;
		this.reverse = reverse;

		phase = reverse ? EOperationPhase.PostChildren : EOperationPhase.PreChildren;
	}

	public boolean hasNextPhase()
	{
		return reverse ? phase != EOperationPhase.PreChildren : phase != EOperationPhase.PostChildren;
	}

	public void nextPhase()
	{
		phase = reverse ? switch (phase)
				{
					case PostChildren -> EOperationPhase.Main;
					case Main -> EOperationPhase.PreChildren;
					case PreChildren -> throw new AssertionError();
				} : switch (phase)
				{
					case PreChildren -> EOperationPhase.Main;
					case Main -> EOperationPhase.PostChildren;
					case PostChildren -> throw new AssertionError();
				};
	}

	public IOperationNode node()
	{
		return node;
	}

	public EOperationPhase phase()
	{
		return phase;
	}
}
