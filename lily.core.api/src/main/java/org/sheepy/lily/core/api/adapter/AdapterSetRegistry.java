package org.sheepy.lily.core.api.adapter;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.api.notification.util.ModelStructureObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AdapterSetRegistry<Adapter extends IAdapter>
{
	private final Class<Adapter> adapterType;
	private final List<LMObject> objects = new ArrayList<>();
	private final List<Adapter> adapters = new ArrayList<>();
	private final ModelStructureObserver structureObserver;

	public AdapterSetRegistry(final Class<Adapter> adapterType, final int[] features)
	{
		structureObserver = new ModelStructureObserver(features, this::add, this::remove);
		this.adapterType = adapterType;
	}

	public List<Adapter> getAdapters()
	{
		return Collections.unmodifiableList(adapters);
	}

	public List<LMObject> getObjects()
	{
		return Collections.unmodifiableList(objects);
	}

	public void startRegister(final LMObject root)
	{
		structureObserver.startObserve(root);
	}

	public void stopRegister(final LMObject root)
	{
		structureObserver.stopObserve(root);
	}

	private void add(final LMObject newValue)
	{
		objects.add(newValue);
		adapters.add(newValue.adapt(adapterType));
	}

	private void remove(final LMObject oldValue)
	{
		objects.remove(oldValue);
		adapters.remove(oldValue.adapt(adapterType));
	}

	public int size()
	{
		return objects.size();
	}
}

