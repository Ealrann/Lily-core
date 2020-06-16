package org.sheepy.lily.core.api.util;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ModelExplorer implements IModelExplorer
{
	private final int parentHeight;
	private final List<EReference> references;

	public ModelExplorer(List<EReference> references)
	{
		this(0, references);
	}

	public ModelExplorer(int parentHeight, List<EReference> references)
	{
		this.parentHeight = parentHeight;
		this.references = List.copyOf(references);
	}

	@Override
	public <T extends ILilyEObject> List<T> explore(ILilyEObject root, Class<T> targetClass)
	{
		return stream(root, targetClass).collect(Collectors.toUnmodifiableList());
	}

	@Override
	public List<ILilyEObject> explore(ILilyEObject root)
	{
		return stream(root).collect(Collectors.toUnmodifiableList());
	}

	@Override
	public <T extends ILilyEObject> Stream<T> stream(ILilyEObject root, Class<T> targetClass)
	{
		return stream(root).map(targetClass::cast);
	}

	@Override
	public <T extends IExtender> List<T> exploreAdapt(ILilyEObject root, Class<T> adapterType)
	{
		return streamAdapt(root, adapterType).collect(Collectors.toUnmodifiableList());
	}

	@Override
	public <T extends IExtender> List<T> exploreAdaptGeneric(ILilyEObject root, Class<? extends IExtender> adapterType)
	{
		return this.<T>streamAdaptGeneric(root, adapterType).collect(Collectors.toUnmodifiableList());
	}

	@Override
	public <T extends IExtender> Stream<T> streamAdapt(ILilyEObject root, Class<T> adapterType)
	{
		return stream(root).map(e -> e.adapt(adapterType)).filter(Objects::nonNull);
	}

	@Override
	public <T extends IExtender> Stream<T> streamAdaptGeneric(ILilyEObject root, Class<? extends IExtender> adapterType)
	{
		return stream(root).map(e -> e.<T>adaptGeneric(adapterType)).filter(Objects::nonNull);
	}

	@Override
	public <T extends IExtender> List<T> exploreAdaptNotNull(ILilyEObject root, Class<T> adapterType)
	{
		return streamAdaptNotNull(root, adapterType).collect(Collectors.toUnmodifiableList());
	}

	@Override
	public <T extends IExtender> Stream<T> streamAdaptNotNull(ILilyEObject root, Class<T> adapterType)
	{
		return stream(root).map(e -> e.adaptNotNull(adapterType));
	}

	@Override
	public Stream<ILilyEObject> stream(ILilyEObject source)
	{
		final var root = parent(source);
		final var list = List.of(root);
		var stream = list.stream();
		for (final var feature : references)
		{
			stream = stream.flatMap(e -> extractList(e, feature));
		}
		return stream;
	}

	private ILilyEObject parent(ILilyEObject source)
	{
		for (int i = 0; i < parentHeight; i++)
		{
			source = (ILilyEObject) source.eContainer();
		}
		return source;
	}

	@SuppressWarnings("unchecked")
	private static Stream<ILilyEObject> extractList(ILilyEObject object, EReference reference)
	{
		final var val = getValue(object, reference);
		if (val != null)
		{
			if (val instanceof List)
			{
				return ((List<ILilyEObject>) val).stream();
			}
			else
			{
				return Stream.of((ILilyEObject) val);
			}
		}
		else
		{
			return Stream.empty();
		}
	}

	private static Object getValue(ILilyEObject target, final EReference reference)
	{
		if (target.eClass().getEAllStructuralFeatures().contains(reference))
		{
			return target.eGet(reference);
		}
		else
		{
			return null;
		}
	}
}
