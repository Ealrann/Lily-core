package org.sheepy.lily.core.api.notification.util;

import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelSetRegistry<T extends ILilyEObject>
{
	private final Class<T> classCast;
	private final List<T> list = new ArrayList<>();
	private final ModelStructureObserver structureObserver;

	public ModelSetRegistry(Class<T> classCast, int[] features)
	{
		structureObserver = new ModelStructureObserver(features, this::add, this::remove);
		this.classCast = classCast;
	}

	public void startRegister(ILilyEObject root)
	{
		structureObserver.startObserve(root);
	}

	public void stopRegister(ILilyEObject root)
	{
		structureObserver.stopObserve(root);
	}

	public List<T> getElements()
	{
		return Collections.unmodifiableList(list);
	}

	private void add(ILilyEObject newValue)
	{
		list.add(classCast.cast(newValue));
	}

	private void remove(ILilyEObject oldValue)
	{
		list.remove(classCast.cast(oldValue));
	}
}
