package org.sheepy.lily.core.adapter.util;

import org.sheepy.lily.core.api.extender.IAdaptable;
import org.sheepy.lily.core.api.extender.IAdapterExtension;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;

import java.lang.annotation.Annotation;
import java.util.Optional;

public class ObservatoryManager implements IAdapterExtension
{
	private final IObservatory observatory;

	public ObservatoryManager(final IObservatory observatory)
	{
		this.observatory = observatory;
	}

	@Override
	public void load(final IAdaptable target)
	{
		if (observatory != null)
		{
			observatory.observe((ILilyEObject) target);
		}
	}

	@Override
	public void dispose(final IAdaptable target)
	{
		if (observatory != null)
		{
			observatory.shut((ILilyEObject) target);
		}
	}

	@Override
	public boolean isEmpty()
	{
		return observatory == null;
	}

	public static final class Builder implements IAdapterExtension.Builder
	{
		private final IObservatoryBuilder observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();

		@Override
		public IAdapterExtension build(final IExtenderDescriptor.ExtenderContext<?> context)
		{
			final var observatory = observatoryBuilder.isEmpty() ? null : observatoryBuilder.build();
			return new ObservatoryManager(observatory);
		}

		@Override
		public Optional<IParameterResolver> parameterResolver()
		{
			return Optional.of(buildParameterResolver());
		}

		private IParameterResolver buildParameterResolver()
		{
			return new IParameterResolver()
			{
				@Override
				public boolean isApplicable(final Class<?> parameterClass, final Annotation parameterAnnotation)
				{
					return parameterClass == IObservatoryBuilder.class;
				}

				@Override
				public Object resolve(final IAdaptable target, final Class<?> parameterClass)
				{
					return observatoryBuilder;
				}
			};
		}
	}
}
