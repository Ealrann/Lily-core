package org.sheepy.lily.core.api.maintainer;

import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.api.util.ModelCopier;
import org.logoce.lmf.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.maintainer.MaintainerModelDefinition;

import java.util.List;

public final class MaintainerUtil
{
	private MaintainerUtil()
	{
	}

	@SuppressWarnings("unchecked")
	public static <T extends Maintainable<T>> T instanciateMaintainer(final Maintainer<T> maintainer,
																	  final boolean resolve)
	{
		final var maintainerObject = (LMObject) maintainer;
		final var genericType = ModelUtil.resolveGenericType(maintainerObject,
															 MaintainerModelDefinition.Groups.MAINTAINER);
		if (genericType == null)
		{
			throw new IllegalStateException("Cannot resolve generic type for Maintainer");
		}
		if ((genericType instanceof Group<?>) == false)
		{
			throw new IllegalStateException("Maintainer generic type must resolve to a Group, got " +
											genericType.getClass().getSimpleName());
		}

		@SuppressWarnings("unchecked")
		final var maintainedGroup = (Group<LMObject>) genericType;
		final var builderSupplier = maintainedGroup.lmBuilder();
		if (builderSupplier == null)
		{
			throw new IllegalStateException(
					"No lmBuilder available for group '%s'".formatted(maintainedGroup.name()));
		}

		final var builder = builderSupplier.newBuilder();
		final var maintainedObject = (LMObject) builder.build();
		final var features = ModelUtil.streamAllFeatures(maintainedGroup).toList();

		copyFeatures(maintainerObject, maintainedObject, features, resolve);

		final var result = (T) maintainedObject;
		maintainer.maintained().add(result);

		return result;
	}

	private static void copyFeatures(final LMObject src,
									 final LMObject trg,
									 final List<Feature<?, ?, ?, ?>> features,
									 final boolean resolve)
	{
		for (final var feature : features)
		{
			if (feature instanceof Relation<?, ?, ?, ?> relation && relation.contains())
			{
				copyContainmentRelation(src, trg, relation);
			}
		}

		for (final var feature : features)
		{
			if (feature instanceof Relation<?, ?, ?, ?> relation)
			{
				if (relation.contains() == false)
				{
					copyNonContainmentRelation(src, trg, relation, resolve);
				}
			}
			else if (feature instanceof Attribute<?, ?, ?, ?> attribute)
			{
				copyAttribute(src, trg, attribute);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void copyAttribute(final LMObject src,
									  final LMObject trg,
									  final Attribute<?, ?, ?, ?> attribute)
	{
		final var typedAttribute = (Attribute<Object, ?, ?, ?>) attribute;
		final var value = src.get(typedAttribute);

		if (value == null)
		{
			return;
		}

		if (attribute.many())
		{
			final var srcList = (List<Object>) value;
			final var trgList = (List<Object>) trg.get(typedAttribute);
			trgList.clear();
			trgList.addAll(srcList);
		}
		else
		{
			trg.set(typedAttribute, value);
		}
	}

	@SuppressWarnings("unchecked")
	private static void copyContainmentRelation(final LMObject src,
												final LMObject trg,
												final Relation<?, ?, ?, ?> relation)
	{
		final var typedRelation = (Relation<LMObject, ?, ?, ?>) relation;
		final var value = src.get(typedRelation);

		if (value == null)
		{
			return;
		}

		final var copier = new ModelCopier();

		if (typedRelation.many())
		{
			final var srcList = (List<LMObject>) value;
			final var trgList = (List<LMObject>) trg.get(typedRelation);

			for (final var child : srcList)
			{
				final var childCopy = copier.copyTree(child);
				trgList.add(childCopy);
			}
		}
		else
		{
			final var child = (LMObject) value;
			final var childCopy = copier.copyTree(child);
			trg.set(typedRelation, childCopy);
		}
	}

	@SuppressWarnings("unchecked")
	private static void copyNonContainmentRelation(final LMObject src,
												   final LMObject trg,
												   final Relation<?, ?, ?, ?> relation,
												   final boolean resolve)
	{
		final var typedRelation = (Relation<LMObject, ?, ?, ?>) relation;
		final var value = src.get(typedRelation);

		if (value == null)
		{
			return;
		}

		if (typedRelation.many())
		{
			final var srcList = (List<LMObject>) value;
			final var trgList = (List<LMObject>) trg.get(typedRelation);

			for (final var srcValue : srcList)
			{
				final var trgValue = resolve ? resolveTarget(src, trg, srcValue) : srcValue;
				trgList.add(trgValue);
			}
		}
		else
		{
			final var srcValue = (LMObject) value;
			final var trgValue = resolve ? resolveTarget(src, trg, srcValue) : srcValue;
			trg.set(typedRelation, trgValue);
		}
	}

	private static LMObject resolveTarget(final LMObject srcRoot,
										  final LMObject trgRoot,
										  final LMObject srcValue)
	{
		return ModelUtil.containmentPath(srcRoot, srcValue)
						.map(path -> path.eGet(trgRoot))
						.orElse(srcValue);
	}
}
