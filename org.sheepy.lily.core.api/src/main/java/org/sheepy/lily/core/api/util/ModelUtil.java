package org.sheepy.lily.core.api.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;

public final class ModelUtil
{
	private static final EClass APPLICATION_ECLASS = ApplicationPackage.Literals.APPLICATION;

	private ModelUtil()
	{}

	public static final Application getApplication(EObject eObject)
	{
		while (eObject != null && APPLICATION_ECLASS.isInstance(eObject) == false)
		{
			eObject = eObject.eContainer();
		}

		return (Application) eObject;
	}

	@SuppressWarnings("unchecked")
	public static <T extends EObject> List<T> gatherAllChildren(EObject root, Class<T> type)
	{
		final List<T> res = new ArrayList<>();
		final Deque<EObject> course = new ArrayDeque<>();

		course.add(root);

		while (course.isEmpty() == false)
		{
			final var currentEObject = course.pop();

			if (type.isInstance(currentEObject))
			{
				res.add((T) currentEObject);
			}

			gatherChildren(currentEObject, course);
		}

		return res;
	}

	public static final <T> T findParent(EObject eo, Class<T> classifier)
	{
		while (classifier.isInstance(eo) == false && eo != null)
		{
			eo = eo.eContainer();
		}

		return classifier.cast(eo);
	}

	public static final EClassifier resolveGenericType(EObject object, EClass genericHolder)
	{
		return resolveGenericType(object.eClass(), genericHolder);
	}

	private static EClassifier resolveGenericType(EClass eClass, EClass genericHolder)
	{
		EClassifier res = null;
		final var eGenericSuperTypes = eClass.getEGenericSuperTypes();

		for (int i = 0; i < eGenericSuperTypes.size(); i++)
		{
			final var gType = eGenericSuperTypes.get(i);
			final var classifier = gType.getEClassifier();
			if (genericHolder == classifier)
			{
				res = gType.getETypeArguments().get(0).getERawType();
				break;
			}
		}

		if (res == null)
		{
			for (final EClass superType : eClass.getESuperTypes())
			{
				res = resolveGenericType(superType, genericHolder);
				if (res != null)
				{
					break;
				}
			}
		}

		return res;
	}

	public static void gatherChildren(EObject eo, Collection<EObject> gatherIn)
	{
		gatherChildren(eo, EObject.class, gatherIn);
	}

	@SuppressWarnings("unchecked")
	public static <T extends EObject> void gatherChildren(	EObject eo,
															Class<T> type,
															Collection<T> gatherIn)
	{
		final var containments = eo.eClass().getEAllContainments();
		for (int i = 0; i < containments.size(); i++)
		{
			final var eReference = containments.get(i);

			if (type == null
					|| type == EObject.class
					|| eReference.getEReferenceType().getInstanceClass().isAssignableFrom(type))
			{
				if (eReference.isMany())
				{
					final var values = (List<EObject>) eo.eGet(eReference);
					for (int j = 0; j < values.size(); j++)
					{
						final EObject value = values.get(j);
						if (value != null)
						{
							gatherIn.add((T) value);
						}
					}
				}
				else
				{
					final var value = (EObject) eo.eGet(eReference);
					if (value != null)
					{
						gatherIn.add((T) value);
					}
				}
			}
		}
	}

	public static Stream<EObject> streamChildren(EObject eo)
	{
		return eo	.eClass()
					.getEAllContainments()
					.stream()
					.flatMap(ref -> streamReference(eo, ref))
					.filter(Objects::nonNull);
	}

	@SuppressWarnings("unchecked")
	private static Stream<EObject> streamReference(EObject eo, EReference ref)
	{
		if (ref.isMany())
		{
			return ((List<EObject>) eo.eGet(ref)).stream();
		}
		else
		{
			final var value = (EObject) eo.eGet(ref);
			if (value != null)
			{
				return Stream.of(value);
			}
		}
		return Stream.empty();
	}

	@SuppressWarnings("unchecked")
	public static void copyFeatures(EObject src,
									final EObject trg,
									final List<EStructuralFeature> features)
	{
		for (final var feature : features)
		{
			final boolean isNonContainment = feature instanceof EAttribute
					|| (feature instanceof EReference
							&& ((EReference) feature).isContainment() == false);

			if (isNonContainment)
			{
				if (feature.isMany() == false)
				{
					trg.eSet(feature, src.eGet(feature));
				}
				else
				{
					final var listSrc = (EList<Object>) src.eGet(feature);
					final var listTrg = (EList<Object>) trg.eGet(feature);

					listTrg.addAll(listSrc);
				}
			}
			else
			{
				if (feature.isMany() == false)
				{
					trg.eSet(feature, EcoreUtil.copy((EObject) src.eGet(feature)));
				}
				else
				{
					final var listSrc = (EList<EObject>) src.eGet(feature);
					final var listTrg = (EList<EObject>) trg.eGet(feature);

					for (final EObject element : listSrc)
					{
						listTrg.add(EcoreUtil.copy(element));
					}
				}

			}
		}
	}
}
