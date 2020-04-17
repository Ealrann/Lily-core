package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.Dirty;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.reflect.SupplierHandle;
import org.sheepy.lily.core.api.util.AnnotationHandles;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AllocationExtenderContainer<Allocation extends IExtender>
{
	public final Allocation extender;
	private final IObservatory observatory;
	private final List<? extends AnnotationHandles<?>> annotationHandles;
	private final boolean hasDirtyMethod;

	public AllocationExtenderContainer(IExtenderDescriptor.ExtenderContext<Allocation> extenderContext,
									   final IObservatory observatory,
									   boolean hasDirtyMethod)
	{
		this.extender = extenderContext.extender();
		this.annotationHandles = extenderContext.annotationHandles();
		this.observatory = observatory;
		this.hasDirtyMethod = hasDirtyMethod;
	}

	public void load(ILilyEObject target)
	{
		if (observatory != null) observatory.observe(target);
	}

	public void dispose(ILilyEObject target)
	{
		if (observatory != null) observatory.shut(target);
	}

	public void update(DependencyResolver resolver)
	{
		streamUpdateHandles(resolver.getIndex()).forEach(updateHandle -> update(updateHandle, resolver));
	}

	private static void update(IExtenderHandle.AnnotatedHandle<UpdateDependency> annotationHandle,
							   DependencyResolver resolver)
	{
		final var stream = resolver.streamDependencies();
		final var executionHandle = (ConsumerHandle) annotationHandle.executionHandle;
		final var parameterClass = annotationHandle.method.getParameterTypes()[0];

		if (parameterClass == List.class)
		{
			executionHandle.invoke(stream.collect(Collectors.toUnmodifiableList()));
		}
		else
		{
			executionHandle.invoke(stream.findAny().orElse(null));
		}
	}

	private Stream<IExtenderHandle.AnnotatedHandle<UpdateDependency>> streamUpdateHandles(int index)
	{
		return annotatedHandles(UpdateDependency.class).filter(handle -> handle.getAnnotation().index() == index);
	}

	public boolean isDirty()
	{
		return hasDirtyMethod && annotatedHandles(Dirty.class).anyMatch(AllocationExtenderContainer::isDeprecated);
	}

	public void free(IAllocationContext context)
	{
		annotatedHandles(Free.class).forEach(freeHandle -> ((ConsumerHandle) freeHandle.executionHandle).invoke(context));
	}

	@SuppressWarnings("unchecked")
	public <A extends Annotation> Stream<IExtenderHandle.AnnotatedHandle<A>> annotatedHandles(Class<A> annotationClass)
	{
		return annotationHandles.stream()
								.filter(h -> h.annotationClass().equals(annotationClass))
								.flatMap(h -> ((AnnotationHandles<A>) h).handles().stream());
	}

	private static boolean isDeprecated(final IExtenderHandle.AnnotatedHandle<Dirty> handle)
	{
		final var lambda = (BooleanSupplier) ((SupplierHandle) handle.executionHandle).getLambdaFunction();
		return lambda.getAsBoolean();
	}

	public Allocation getAllocation()
	{
		return extender;
	}
}
