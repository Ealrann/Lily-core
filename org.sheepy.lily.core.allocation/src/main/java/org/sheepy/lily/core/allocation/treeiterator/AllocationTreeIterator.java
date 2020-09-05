package org.sheepy.lily.core.allocation.treeiterator;

import org.sheepy.lily.core.allocation.children.instance.ChildDescriptorAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildHandleAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildrenSupervisor;
import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.operation.IOperation;

import java.util.List;
import java.util.Optional;

public abstract class AllocationTreeIterator<T extends AllocationTreeIterator<T>>
{
	private final boolean reverse;
	private final boolean iterateRemovedHandleAllocators;

	private boolean iteratingRemovedElements = false;
	private AllocationChildrenManager childrenManager;

	private int supervisorIndex = 0;
	private ChildrenSupervisor currentSupervisor = null;

	private int descriptorAllocatorIndex = 0;
	private ChildDescriptorAllocator currentDescriptorAllocator = null;

	protected int handleAllocatorIndex = 0;
	protected ChildHandleAllocator<?> currentHandleAllocator = null;

	public AllocationTreeIterator(final boolean reverse, final boolean iterateRemovedHandleAllocators)
	{
		this.reverse = reverse;
		this.iterateRemovedHandleAllocators = iterateRemovedHandleAllocators;
	}

	public void load(final AllocationChildrenManager childrenManager)
	{
		this.childrenManager = childrenManager;
		supervisorIndex = reverse ? childrenManager.getSupervisors().size() - 1 : 0;
		currentSupervisor = null;
		currentDescriptorAllocator = null;
		currentHandleAllocator = null;
	}

	public void loadEmpty()
	{
		this.childrenManager = null;
		supervisorIndex = 0;
		currentSupervisor = null;
		currentDescriptorAllocator = null;
		currentHandleAllocator = null;
	}

	private boolean tryAdvanceSupervisor()
	{
		if (childrenManager == null) return false;

		final var supervisors = childrenManager.getSupervisors();
		if (!checkSupervisorIndex(supervisors))
		{
			return false;
		}
		currentSupervisor = supervisors.get(supervisorIndex);
		supervisorIndex += reverse ? -1 : 1;
		descriptorAllocatorIndex = reverse ? currentSupervisor.getDescriptorAllocators().size() - 1 : 0;

		updateSupervisor(currentSupervisor);

		return true;
	}

	private boolean checkSupervisorIndex(final List<ChildrenSupervisor> supervisors)
	{
		return reverse ? supervisorIndex >= 0 : supervisorIndex < supervisors.size();
	}

	private boolean tryAdvanceDescriptorAllocator()
	{
		if (currentDescriptorAllocator != null)
		{
			postUpdateDescriptorAllocator(currentDescriptorAllocator);
		}

		while (currentSupervisor == null || !checkDescriptorAllocatorIndex())
		{
			if (tryAdvanceSupervisor() == false) return false;
		}

		currentDescriptorAllocator = currentSupervisor.getDescriptorAllocators().get(descriptorAllocatorIndex);
		descriptorAllocatorIndex += reverse ? -1 : 1;
		handleAllocatorIndex = reverse ? currentHandleAllocatorSize() - 1 : 0;

		return true;
	}

	private boolean checkDescriptorAllocatorIndex()
	{
		return reverse ? descriptorAllocatorIndex >= 0 : descriptorAllocatorIndex < currentSupervisor.getDescriptorAllocators()
																									 .size();
	}

	protected ChildHandleAllocator<?> tryAdvanceHandleAllocator()
	{
		do
		{
			while (currentDescriptorAllocator == null || !checkHandleAllocatorIndex())
			{
				if (tryAdvanceDescriptorAllocator() == false) return null;
			}

			currentHandleAllocator = retrieveHandleAllocator();
			handleAllocatorIndex += reverse ? -1 : 1;
		} while (operatesOnHandleAllocator(currentHandleAllocator) == false);

		return currentHandleAllocator;
	}

	private boolean checkHandleAllocatorIndex()
	{
		return reverse ? handleAllocatorIndex >= 0 : handleAllocatorIndex < currentHandleAllocatorSize();
	}

	private ChildHandleAllocator<?> retrieveHandleAllocator()
	{
		if (iterateRemovedHandleAllocators)
		{
			final var removedHandles = currentDescriptorAllocator.getRemovedHandles();
			final int removedSize = removedHandles.size();
			if (handleAllocatorIndex >= removedSize)
			{
				iteratingRemovedElements = false;
				return currentDescriptorAllocator.getHandles().get(handleAllocatorIndex - removedSize);
			}
			else
			{
				iteratingRemovedElements = true;
				return removedHandles.get(handleAllocatorIndex);
			}
		}
		else
		{
			iteratingRemovedElements = false;
			return currentDescriptorAllocator.getHandles().get(handleAllocatorIndex);
		}
	}

	private int currentHandleAllocatorSize()
	{
		if (iterateRemovedHandleAllocators)
		{
			return currentDescriptorAllocator.getHandles().size() + currentDescriptorAllocator.getRemovedHandles()
																							  .size();
		}
		else
		{
			return currentDescriptorAllocator.getHandles().size();
		}
	}

	protected boolean isIteratingRemovedElements()
	{
		return iteratingRemovedElements;
	}

	protected abstract void updateSupervisor(final ChildrenSupervisor supervisor);
	protected abstract void postUpdateDescriptorAllocator(final ChildDescriptorAllocator descriptorAllocator);
	protected abstract boolean operatesOnHandleAllocator(final ChildHandleAllocator<?> handleAllocator);

	public abstract Optional<? extends IOperation<T>> tryAdvance();
}
