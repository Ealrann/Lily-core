package org.sheepy.lily.core.api.adapter.util;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.util.ModelStructureObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AdapterSetRegistry<Adapter extends IExtender>
{
	private final Class<Adapter> adapterType;
	private final List<ILilyEObject> objects = new ArrayList<>();
	private final List<Adapter> adapters = new ArrayList<>();
	private final ModelStructureObserver structureObserver;

	public AdapterSetRegistry(Class<Adapter> adapterType, int[] features)
	{
		structureObserver = new ModelStructureObserver(features, this::add, this::remove);
		this.adapterType = adapterType;
	}

	public List<Adapter> getAdapters()
	{
		return Collections.unmodifiableList(adapters);
	}

	public List<ILilyEObject> getObjects()
	{
		return Collections.unmodifiableList(objects);
	}

	public void startRegister(ILilyEObject root)
	{
		structureObserver.startObserve(root);
	}

	public void stopRegister(ILilyEObject root)
	{
		structureObserver.stopObserve(root);
	}

	private void add(ILilyEObject newValue)
	{
		objects.add(newValue);
		adapters.add(newValue.adapt(adapterType));
	}

	private void remove(ILilyEObject oldValue)
	{
		objects.remove(oldValue);
		adapters.remove(oldValue.adapt(adapterType));
	}

	public int size()
	{
		return objects.size();
	}
}
