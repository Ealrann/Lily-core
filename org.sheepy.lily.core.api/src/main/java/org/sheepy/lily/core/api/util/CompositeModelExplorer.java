package org.sheepy.lily.core.api.util;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.extender.IExtender;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CompositeModelExplorer
{
	private final List<ModelExplorer> explorers;

	public CompositeModelExplorer(List<List<EReference>> featureLists)
	{
		this.explorers = List.copyOf(buildExplorers(featureLists));
	}

	private static List<ModelExplorer> buildExplorers(List<List<EReference>> featureLists)
	{
		final List<ModelExplorer> explorers = new ArrayList<>();
		for (final var features : featureLists)
		{
			explorers.add(new ModelExplorer(features));
		}
		return explorers;
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

	public <T extends IExtender> Stream<T> streamAdapt(ILilyEObject root, Class<T> adapterType)
	{
		return stream(root).map(e -> e.adapt(adapterType))
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

	private Stream<ILilyEObject> stream(ILilyEObject root)
	{
		Stream<ILilyEObject> res = Stream.empty();
		for (final var explorer : explorers)
		{
			res = Stream.concat(res, explorer.stream(root));
		}

		return res;
	}
}
