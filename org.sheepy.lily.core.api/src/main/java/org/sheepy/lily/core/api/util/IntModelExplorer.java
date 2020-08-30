package org.sheepy.lily.core.api.util;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class IntModelExplorer implements IModelExplorer
{
	private final Class<? extends ILilyEObject> parentClass;
	private final int[] references;

	public IntModelExplorer(int[] references)
	{
		this(ILilyEObject.class, references);
	}

	public IntModelExplorer(Class<? extends ILilyEObject> parentClass, int[] references)
	{
		this.parentClass = parentClass;
		this.references = Arrays.copyOf(references, references.length);
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
		var stream = Stream.of(root);
		for (final var reference : references)
		{
			stream = stream.flatMap(e -> stream(e, reference));
		}
		return stream;
	}

	private ILilyEObject parent(ILilyEObject source)
	{
		while (parentClass.isInstance(source) == false)
		{
			source = (ILilyEObject) source.eContainer();
		}
		return source;
	}

	@SuppressWarnings("unchecked")
	private static Stream<ILilyEObject> stream(ILilyEObject object, int reference)
	{
		final var val = getValue(object, reference);
		if (val instanceof List)
		{
			return ((List<ILilyEObject>) val).stream();
		}
		else
		{
			return Stream.ofNullable((ILilyEObject) val);
		}
	}

	private static Object getValue(ILilyEObject target, final int reference)
	{
		return target.eGet(reference, true, true);
	}
}
