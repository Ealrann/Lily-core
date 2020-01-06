package org.sheepy.lily.core.api.adapter.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.util.AbstractModelSetRegistry;

public class AdapterSetRegistry<T extends IAdapter> extends AbstractModelSetRegistry
{
	private final Class<T> adapterType;
	private final List<ILilyEObject> objects = new ArrayList<>();
	private final List<T> adapters = new ArrayList<>();

	public AdapterSetRegistry(Class<T> adapterType, List<EStructuralFeature> features)
	{
		super(features);
		this.adapterType = adapterType;
	}

	public List<T> getAdapters()
	{
		return Collections.unmodifiableList(adapters);
	}

	public List<ILilyEObject> getObjects()
	{
		return Collections.unmodifiableList(objects);
	}

	@Override
	protected void add(ILilyEObject newValue)
	{
		objects.add(newValue);
		adapters.add(newValue.adapt(adapterType));
	}

	@Override
	protected void remove(ILilyEObject oldValue)
	{
		objects.remove(oldValue);
		adapters.remove(oldValue.adapt(adapterType));
	}
}
