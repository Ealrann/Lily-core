package org.sheepy.lily.core.api.util;

import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.MetaModel;
import org.logoce.lmf.core.api.util.ModelUtil;
import org.sheepy.lily.core.api.resource.IModelExtension;

/**
 * LMF-based counterpart of the legacy EMF {@code FeatureDefinition}.
 * <p>
 * It keeps the same string representation
 * {@code "<model>#<class>#<feature>"} but resolves against LMCore
 * meta-data instead of EMF {@code EPackage}/{@code EClass}.
 */
public final class FeatureDefinition extends FeatureData
{
	public MetaModel metaModel;
	public Group<?> eClass;
	public Feature<?, ?, ?, ?> feature;

	public FeatureDefinition(final String def)
	{
		super(def);

		try
		{
			metaModel = resolveMetaModel(nsURI);
			eClass = resolveGroup(metaModel, className);
			feature = resolveFeature(eClass, featureName);

			if (feature == null)
			{
				logError(def);
			}
		}
		catch (final Exception e)
		{
			logError(def);
			e.printStackTrace();
		}
	}

	/**
	 * Build a {@link FeatureData} descriptor from a concrete LMCore feature.
	 */
	public static FeatureData fromFeature(final Feature<?, ?, ?, ?> feature)
	{
		if (feature == null) throw new IllegalArgumentException("feature cannot be null");

		final var group = findOwningGroup(feature);
		final var metaModel = findOwningMetaModel(group);

		final var nsUri = metaModel.domain() + "." + metaModel.name();
		final var className = group.name();
		final var featureName = feature.name();

		return new FeatureData(nsUri, className, featureName);
	}

	/**
	 * Check whether this definition matches the feature carried by the given
	 * LMF {@link Notification}.
	 */
	public boolean match(final Notification notification)
	{
		return notification != null && feature != null && notification.featureId() == feature.id();
	}

	private static MetaModel resolveMetaModel(final String qualifiedName)
	{
		for (final var extension : IModelExtension.EXTENSIONS)
		{
			for (final var pkg : extension.getEPackages())
			{
				final var model = pkg.model();
				if (model instanceof MetaModel metaModel && qualifiedName(metaModel).equals(qualifiedName))
				{
					return metaModel;
				}
			}
		}

		throw new IllegalStateException("Cannot resolve MetaModel: " + qualifiedName);
	}

	private static Group<?> resolveGroup(final MetaModel metaModel, final String groupName)
	{
		return metaModel.groups()
						.stream()
						.filter(g -> groupName.equals(g.name()))
						.findFirst()
						.orElseThrow(() -> new IllegalStateException(
								"Cannot resolve Group '" + groupName + "' in model " + qualifiedName(metaModel)));
	}

	private static Feature<?, ?, ?, ?> resolveFeature(final Group<?> group, final String featureName)
	{
		return ModelUtil.streamAllFeatures(group)
						.filter(f -> featureName.equals(f.name()))
						.findFirst()
						.orElse(null);
	}

	private static String qualifiedName(final MetaModel metaModel)
	{
		final var domain = metaModel.domain();
		final var name = metaModel.name();
		if (domain == null || domain.isBlank()) return name;
		return domain + "." + name;
	}

	private static void logError(final String def)
	{
		System.err.println("Cannot resolve the feature ref [" + def + "]");
	}

	private static Group<?> findOwningGroup(final Feature<?, ?, ?, ?> feature)
	{
		LMObject current = feature.lmContainer();
		while (current != null)
		{
			if (current instanceof Group<?> group) return group;
			current = current.lmContainer();
		}
		throw new IllegalStateException("Cannot find owning Group for feature '%s'".formatted(feature.name()));
	}

	private static MetaModel findOwningMetaModel(final Group<?> group)
	{
		LMObject current = group;
		while (current != null)
		{
			if (current instanceof MetaModel metaModel) return metaModel;
			current = current.lmContainer();
		}
		throw new IllegalStateException("Cannot find owning MetaModel for group '%s'".formatted(group.name()));
	}
}
