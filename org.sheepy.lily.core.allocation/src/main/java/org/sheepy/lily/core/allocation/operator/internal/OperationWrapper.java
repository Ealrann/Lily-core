package org.sheepy.lily.core.allocation.operator.internal;

import org.sheepy.lily.core.allocation.operation.IOperation;
import org.sheepy.lily.core.allocation.spliterator.AllocationTreeIterator;

public final class OperationWrapper<T extends AllocationTreeIterator<T>>
{
	public enum EOperationPhase
	{
		PreChildren,
		Main,
		PostChildren
	}

	private final boolean reverse;

	private IOperation<T> operation;
	private EOperationPhase phase;

	public OperationWrapper(final boolean reverse)
	{
		this.reverse = reverse;
	}

	public void load(final IOperation<T> operation)
	{
		this.operation = operation;
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

	public IOperation<T> operation()
	{
		return operation;
	}

	public EOperationPhase phase()
	{
		return phase;
	}
}
