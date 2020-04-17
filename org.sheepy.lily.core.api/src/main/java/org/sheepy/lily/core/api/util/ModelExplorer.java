package org.sheepy.lily.core.api.util;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.extender.IExtender;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ModelExplorer
{
	private final List<EReference> references;

	public ModelExplorer(List<EReference> references)
	{
		this.references = List.copyOf(references);
	}

	public <T extends ILilyEObject> List<T> explore(ILilyEObject root, Class<T> targetClass)
	{
		return stream(root, targetClass).collect(Collectors.toUnmodifiableList());
	}

	public <T extends ILilyEObject> Stream<T> stream(ILilyEObject root, Class<T> targetClass)
	{
		return stream(root).map(targetClass::cast);
	}

	public <T extends IExtender> List<T> exploreAdapt(ILilyEObject root, Class<T> adapterType)
	{
		return streamAdapt(root, adapterType).collect(Collectors.toUnmodifiableList());
	}

	public <T extends IExtender> List<T> exploreAdaptGeneric(ILilyEObject root,
															 Class<? extends IExtender> adapterType)
	{
		return this.<T>streamAdaptGeneric(root, adapterType)
				.collect(Collectors.toUnmodifiableList());
	}

	public <T extends IExtender> Stream<T> streamAdapt(ILilyEObject root, Class<T> adapterType)
	{
		return stream(root).map(e -> e.adapt(adapterType))
						   .filter(Objects::nonNull);
	}

	public <T extends IExtender> Stream<T> streamAdaptGeneric(ILilyEObject root,
															  Class<? extends IExtender> adapterType)
	{
		return stream(root).map(e -> e.<T>adaptGeneric(adapterType))
						   .filter(Objects::nonNull);
	}

	public <T extends IExtender> List<T> exploreAdaptNotNull(ILilyEObject root, Class<T> adapterType)
	{
		return streamAdaptNotNull(root, adapterType).collect(Collectors.toUnmodifiableList());
	}

	public <T extends IExtender> Stream<T> streamAdaptNotNull(ILilyEObject root,
															  Class<T> adapterType)
	{
		return stream(root).map(e -> e.adaptNotNull(adapterType));
	}

	Stream<ILilyEObject> stream(ILilyEObject root)
	{
		final var list = List.of(root);
		var stream = list.stream();
		for (final var feature : references)
		{
			stream = stream.flatMap(e -> extractList(e, feature));
		}
		return stream;
	}

	@SuppressWarnings("unchecked")
	private static Stream<ILilyEObject> extractList(ILilyEObject object, EReference reference)
	{
		final var val = getValue(object, reference);
		if (val != null)
		{
			if (reference.isMany() == false)
			{
				return Stream.of((ILilyEObject) val);
			}
			else
			{
				return ((List<ILilyEObject>) val).stream();
			}
		}
		else
		{
			return Stream.empty();
		}
	}

	private static Object getValue(ILilyEObject target, final EReference reference)
	{
		if (target.eClass()
				  .getEAllStructuralFeatures()
				  .contains(reference))
		{
			return target.eGet(reference);
		}
		else
		{
			return null;
		}
	}
}
