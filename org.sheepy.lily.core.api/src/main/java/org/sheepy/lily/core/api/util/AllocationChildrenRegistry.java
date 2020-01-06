package org.sheepy.lily.core.api.util;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.notification.util.AbstractModelSetRegistry;

public class AllocationChildrenRegistry
{
	private final InternalObserver observer;
	private final boolean dirtyOnChange;

	private IAllocationConfigurator config;

	public AllocationChildrenRegistry(List<EStructuralFeature> features, boolean dirtyOnChange)
	{
		observer = new InternalObserver(features);
		this.dirtyOnChange = dirtyOnChange;
	}

	public void startRegister(ILilyEObject root, IAllocationConfigurator config)
	{
		this.config = config;
		observer.startRegister(root);
	}

	public void stopRegister(ILilyEObject root)
	{
		observer.stopRegister(root);
		config = null;
	}

	private final class InternalObserver extends AbstractModelSetRegistry
	{
		public InternalObserver(List<EStructuralFeature> features)
		{
			super(features);
		}

		@Override
		protected void add(ILilyEObject newValue)
		{
			final IAllocableAdapter<?> adapter = newValue.adapt(IAllocableAdapter.class);
			if (adapter != null)
			{
				config.addChildren(List.of(adapter));
				if (dirtyOnChange)
				{
					config.setDirty();
				}
			}
		}

		@Override
		protected void remove(ILilyEObject oldValue)
		{
			final IAllocableAdapter<?> adapter = oldValue.adapt(IAllocableAdapter.class);
			if (adapter != null)
			{
				config.removeChildren(List.of(adapter));
				if (dirtyOnChange)
				{
					config.setDirty();
				}
			}
		}
	}
}
