package org.sheepy.lily.core.extender.util;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.reflect.ConstructorHandle;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.extender.ExtenderDescriptor;
import org.sheepy.lily.core.reflect.constructor.ConstructorHandleBuilder;

import java.lang.reflect.Constructor;

public final class ExtenderDescriptorBuilder
{
	public static <Extender extends IExtender> ExtenderDescriptor<Extender> build(Class<Extender> type) throws ReflectiveOperationException
	{
		final ModelExtender modelExtenderAnnotation = getModelAnnotation(type);
		final var constructorHandle = buildConstructorHandle(type);

		final var targetClass = modelExtenderAnnotation.scope();
		final var targetEClass = ModelUtil.resolveEClass(targetClass);
		final boolean inheritance = modelExtenderAnnotation.inherited();
		final String targetName = modelExtenderAnnotation.name();

		return new ExtenderDescriptor<>(constructorHandle, type, targetEClass, inheritance, targetName);
	}

	private static <Extender> ConstructorHandle<Extender> buildConstructorHandle(final Class<Extender> type) throws ReflectiveOperationException
	{
		final var constructor = gatherConstructor(type);
		return ConstructorHandleBuilder.fromMethod(constructor).build();
	}

	private static <Extender> ModelExtender getModelAnnotation(final Class<Extender> type)
	{
		final var adapterAnnotation = type.getAnnotation(ModelExtender.class);
		if (adapterAnnotation == null) throwNoPluginAnnotationError(type);
		return adapterAnnotation;
	}

	private static <Extender> Constructor<Extender> gatherConstructor(Class<Extender> type)
	{
		@SuppressWarnings("unchecked") final var constructors = (Constructor<Extender>[]) type.getDeclaredConstructors();
		if (constructors.length != 1)
		{
			throw new AssertionError("IAdapter [" + type.getSimpleName() + "] must have one and only one constructor.");
		}

		final Constructor<Extender> res = constructors[0];
		res.setAccessible(true);
		return res;
	}

	private static void throwNoPluginAnnotationError(Class<?> type) throws IllegalStateException
	{
		final String adapterName = type.getSimpleName();
		final String annotationName = ModelExtender.class.getSimpleName();
		final String message = "The class [%s] is not annoted with @%s";
		final String errorMessage = String.format(message, adapterName, annotationName);
		throw new IllegalStateException(errorMessage);
	}
}
