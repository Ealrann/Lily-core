package org.sheepy.lily.core.api.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

public final class ModelExplorer
{
	private final List<EStructuralFeature> features;

	public ModelExplorer(List<EStructuralFeature> features)
	{
		this.features = List.copyOf(features);
	}

	public <T extends ILilyEObject> List<T> explore(ILilyEObject root, Class<T> targetClass)
	{
		return stream(root, targetClass).collect(Collectors.toUnmodifiableList());
	}

	public <T extends ILilyEObject> Stream<T> stream(ILilyEObject root, Class<T> targetClass)
	{
		return stream(root).map(targetClass::cast);
	}

	public <T extends IAdapter> List<T> exploreAdapt(ILilyEObject root, Class<T> adapterType)
	{
		return streamAdapt(root, adapterType).collect(Collectors.toUnmodifiableList());
	}

	public <T extends IAdapter> Stream<T> streamAdapt(ILilyEObject root, Class<T> adapterType)
	{
		return stream(root).map(e -> e.adapt(adapterType)).filter(Objects::nonNull);
	}

	public <T extends IAdapter> List<T> exploreAdaptNotNull(ILilyEObject root, Class<T> adapterType)
	{
		return streamAdaptNotNull(root, adapterType).collect(Collectors.toUnmodifiableList());
	}

	public <T extends IAdapter> Stream<T> streamAdaptNotNull(	ILilyEObject root,
																Class<T> adapterType)
	{
		return stream(root).map(e -> e.adaptNotNull(adapterType));
	}

	private Stream<ILilyEObject> stream(ILilyEObject root)
	{
		final var list = List.of(root);
		var stream = list.stream();
		for (final var feature : features)
		{
			stream = stream.flatMap(e -> extractList(e, feature));
		}
		return stream;
	}

	@SuppressWarnings("unchecked")
	private static Stream<ILilyEObject> extractList(ILilyEObject object, EStructuralFeature feature)
	{
		final var val = object.eGet(feature);
		if (feature.isMany() == false)
		{
			if (val != null)
			{
				return List.of((ILilyEObject) val).stream();
			}
			else
			{
				return Stream.empty();
			}
		}
		else
		{
			return ((List<ILilyEObject>) val).stream();
		}
	}
}
