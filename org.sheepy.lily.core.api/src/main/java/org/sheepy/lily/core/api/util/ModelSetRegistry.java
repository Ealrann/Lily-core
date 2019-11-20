package org.sheepy.lily.core.api.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.LilyEObject;

public class ModelSetRegistry<T extends ILilyEObject> extends AbstractModelSetRegistry
{
	private final Class<T> classCast;
	private final List<T> list = new ArrayList<>();

	public ModelSetRegistry(Class<T> classCast, List<EStructuralFeature> features)
	{
		super(features);
		this.classCast = classCast;
	}

	public List<T> getElements()
	{
		return Collections.unmodifiableList(list);
	}

	@Override
	protected void add(LilyEObject newValue)
	{
		list.add(classCast.cast(newValue));
	}

	@Override
	protected void remove(LilyEObject oldValue)
	{
		list.remove(oldValue);
	}
}