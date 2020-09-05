package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.dependency.container.DependencyContainer;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.Deque;
import java.util.LinkedList;

public final class DependencyResolutionManager
{
	private final DependencyResolver resolver;
	private final Runnable onResolutionObsolete;
	private final LinkedList<DependencyContainer> currentAllocations = new LinkedList<>();

	public DependencyResolutionManager(final DependencyResolver resolver, final Runnable onResolutionObsolete)
	{
		this.resolver = resolver;
		this.onResolutionObsolete = onResolutionObsolete;
	}

	public void resolve(ILilyEObject target)
	{
		final var modelIterator = resolver.getModelExplorer().stream(target).iterator();
		final var resolutionsIterator = currentAllocations.listIterator();

		while (modelIterator.hasNext())
		{
			final var modelElement = modelIterator.next();

			if (resolutionsIterator.hasNext())
			{
				final var resolution = resolutionsIterator.next();
				final var handle = resolver.resolve(modelElement);
				if (resolution.handle() != handle)
				{
					final boolean existsLater = searchHandleFromIndex(resolutionsIterator.nextIndex(), handle);
					if (existsLater)
					{
						resolution.free();
						resolutionsIterator.remove();
					}
					else
					{
						resolutionsIterator.previous();
						resolutionsIterator.add(resolver.buildContainer(modelElement, onResolutionObsolete));
					}
				}
				else if (resolution.isDirty())
				{
					resolution.update();
				}
			}
			else
			{
				resolutionsIterator.add(resolver.buildContainer(modelElement, onResolutionObsolete));
			}
		}

		while (resolutionsIterator.hasNext())
		{
			final var resolution = resolutionsIterator.next();
			resolution.free();
			resolutionsIterator.remove();
		}
	}

	private boolean searchHandleFromIndex(final int index, final IExtenderHandle<?> handle)
	{
		final var subIterator = currentAllocations.listIterator(index);
		while (subIterator.hasNext())
		{
			if (subIterator.next().handle() == handle)
			{
				return true;
			}
		}
		return false;
	}

	public boolean isDirty()
	{
		return currentAllocations.stream().anyMatch(DependencyContainer::isDirty);
	}

	public void free()
	{
		currentAllocations.forEach(DependencyContainer::free);
	}

	public Deque<DependencyContainer> getResolutions()
	{
		return currentAllocations;
	}
}
