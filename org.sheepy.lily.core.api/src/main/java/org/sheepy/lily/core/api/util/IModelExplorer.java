package org.sheepy.lily.core.api.util;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.stream.Stream;

public interface IModelExplorer
{
	<T extends ILilyEObject> List<T> explore(ILilyEObject root, Class<T> targetClass);
	<T extends ILilyEObject> Stream<T> stream(ILilyEObject root, Class<T> targetClass);
	<T extends IExtender> List<T> exploreAdapt(ILilyEObject root, Class<T> adapterType);
	<T extends IExtender> List<T> exploreAdaptGeneric(ILilyEObject root, Class<? extends IExtender> adapterType);
	<T extends IExtender> Stream<T> streamAdapt(ILilyEObject root, Class<T> adapterType);
	<T extends IExtender> Stream<T> streamAdaptGeneric(ILilyEObject root, Class<? extends IExtender> adapterType);
	<T extends IExtender> List<T> exploreAdaptNotNull(ILilyEObject root, Class<T> adapterType);
	<T extends IExtender> Stream<T> streamAdaptNotNull(ILilyEObject root, Class<T> adapterType);
}
