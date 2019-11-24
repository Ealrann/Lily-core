package org.sheepy.lily.core.api.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

public class AdapterSetRegistry<T extends IAdapter> extends AbstractModelSetRegistry
{
	private final Class<T> adapterType;
	private final List<T> list = new ArrayList<>();

	public AdapterSetRegistry(Class<T> adapterType, List<EStructuralFeature> features)
	{
		super(features);
		this.adapterType = adapterType;
	}

	public List<T> getAdapters()
	{
		return Collections.unmodifiableList(list);
	}

	@Override
	protected void add(ILilyEObject newValue)
	{
		list.add(newValue.adapt(adapterType));
	}

	@Override
	protected void remove(ILilyEObject oldValue)
	{
		list.remove(oldValue.adapt(adapterType));
	}
}
