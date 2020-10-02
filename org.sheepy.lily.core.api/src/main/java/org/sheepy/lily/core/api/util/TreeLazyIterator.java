package org.sheepy.lily.core.api.util;

import org.eclipse.emf.ecore.util.EContentsEList;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class TreeLazyIterator implements Iterator<ILilyEObject>
{
	private final Deque<IterationNode> iteratorStack = new ArrayDeque<>();
	private final ContainmentFeatureMap featureMap = new ContainmentFeatureMap();

	public TreeLazyIterator(final ILilyEObject root)
	{
		final var node = newNode(root);
		iteratorStack.add(node);
	}

	private IterationNode newNode(final ILilyEObject root)
	{
		final var containmentFeatures = featureMap.features(root.eClass());
		final var it = new EContentsEList.FeatureIteratorImpl<ILilyEObject>(root, containmentFeatures);
		return new IterationNode(root, it);
	}

	@Override
	public boolean hasNext()
	{
		return iteratorStack.isEmpty() == false;
	}

	@Override
	public ILilyEObject next()
	{
		final var currentNode = iteratorStack.getLast();

		final ILilyEObject res;
		if (currentNode.step == IterationNode.EStep.Element)
		{
			res = currentNode.element;
			currentNode.step = IterationNode.EStep.Iterator;
		}
		else
		{
			res = currentNode.iterator.next();
			final var childNode = newNode(res);
			childNode.step = IterationNode.EStep.Iterator;
			iteratorStack.add(childNode);
		}

		progress();

		return res;
	}

	private void progress()
	{
		if (iteratorStack.isEmpty() == false)
		{
			final var currentNode = iteratorStack.getLast();
			if (currentNode.iterator.hasNext() == false)
			{
				iteratorStack.removeLast();
				progress();
			}
		}
	}

	private static final class IterationNode
	{
		private final ILilyEObject element;
		private final Iterator<ILilyEObject> iterator;

		private enum EStep
		{
			Element,
			Iterator
		}

		private EStep step = EStep.Element;

		public IterationNode(final ILilyEObject element, final Iterator<ILilyEObject> iterator)
		{
			this.element = element;
			this.iterator = iterator;
		}
	}
}
