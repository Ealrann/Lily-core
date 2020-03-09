package org.sheepy.lily.core.api.util;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.notification.util.ModelStructureObserver;

import java.util.List;

public class AllocationChildrenRegistry
{
	private final ModelStructureObserver structureObserver;
	private final boolean dirtyOnChange;

	private IAllocationConfigurator config;

	public AllocationChildrenRegistry(List<EStructuralFeature> features, boolean dirtyOnChange)
	{
		structureObserver = new ModelStructureObserver(features, this::add, this::remove);
		this.dirtyOnChange = dirtyOnChange;
	}

	public void startRegister(ILilyEObject root, IAllocationConfigurator config)
	{
		this.config = config;
		structureObserver.startObserve(root);
	}

	public void stopRegister(ILilyEObject root)
	{
		structureObserver.stopObserve(root);
		config = null;
	}

	private void add(ILilyEObject newValue)
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

	private void remove(ILilyEObject oldValue)
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
