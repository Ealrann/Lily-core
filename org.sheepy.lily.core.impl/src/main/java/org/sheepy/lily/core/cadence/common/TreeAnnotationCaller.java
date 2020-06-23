package org.sheepy.lily.core.cadence.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderDescriptorRegistry;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class TreeAnnotationCaller extends EContentAdapter
{
	private final List<IExtenderDescriptor<?>> annotatedDescriptors;
	private final Class<? extends Annotation> annotationType;
	private final List<Caller> callers = new ArrayList<>();
	private final ILilyEObject root;

	public TreeAnnotationCaller(ILilyEObject root, Class<? extends Annotation> annotationType)
	{
		this.root = root;
		annotatedDescriptors = collectDescriptors(annotationType);
		this.annotationType = annotationType;
		root.eAdapters().add(this);
	}

	public void free()
	{
		root.eAdapters().remove(this);
	}

	public void call()
	{
		for (final var caller : callers)
		{
			caller.call(annotationType);
		}
	}

	@Override
	protected void setTarget(EObject target)
	{
		final var lilyObject = (ILilyEObject) target;
		annotatedDescriptors.stream()
							.filter(descriptor -> descriptor.isApplicable(lilyObject))
							.forEach(descriptor -> newCaller(descriptor, lilyObject));
		super.setTarget(target);
	}

	@Override
	protected void unsetTarget(EObject target)
	{
		final var lilyObject = (ILilyEObject) target;

		final var targetCallers = lilyObject.storage()
											.stream()
											.filter(Caller.class::isInstance)
											.map(Caller.class::cast)
											.collect(Collectors.toUnmodifiableList());

		for (final var targetCaller : targetCallers)
		{
			callers.remove(targetCaller);
		}

		callers.removeAll(targetCallers);
	}

	private void newCaller(IExtenderDescriptor<?> descriptor, ILilyEObject target)
	{
		final var caller = new Caller(descriptor, target);
		callers.add(caller);
		target.storage().add(caller);
	}

	private static List<IExtenderDescriptor<?>> collectDescriptors(Class<? extends Annotation> annotationType)
	{
		return IExtenderDescriptorRegistry.INSTANCE.streamDescriptors()
												   .filter(de -> de.containsMethodAnnotation(annotationType))
												   .collect(Collectors.toUnmodifiableList());
	}

	private static record Caller(IExtenderDescriptor<?>descriptor, ILilyEObject target)
	{
		public void call(Class<? extends Annotation> annotationType)
		{
			target.adapters()
				  .adaptHandleFromDescriptor(descriptor)
				  .allAnnotatedHandles(annotationType)
				  .forEach(a -> ((ConsumerHandle) a.executionHandle()).invoke());
		}
	}
}
