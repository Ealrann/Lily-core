package org.sheepy.lily.core.api.notification.observatory.internal.notifier;

import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.observatory.IAdapterObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;

import java.util.ArrayList;
import java.util.List;

public final class AdapterObservatory<Type extends IFeature<?, ?>> implements IObservatory.IAdapterObservatory<Type>
{
	private final List<INotifierPOI<Type>> observationPoints;
	private final Class<? extends INotifierAdapter<Type>> notifierClass;

	public AdapterObservatory(Class<? extends INotifierAdapter<Type>> notifierClass,
							  List<INotifierPOI<Type>> observationPoints)
	{
		this.notifierClass = notifierClass;
		this.observationPoints = List.copyOf(observationPoints);
	}

	@Override
	public void observe(ILilyEObject object)
	{
		final var adapter = object.adapt(notifierClass);
		if (adapter != null)
		{
			for (final var point : observationPoints)
			{
				point.listen(adapter);
			}
		}
	}

	@Override
	public void shut(ILilyEObject object)
	{
		final var adapter = object.adapt(notifierClass);
		if (adapter != null)
		{
			for (final var point : observationPoints)
			{
				point.sulk(adapter);
			}
		}
	}

	public static final class Builder<Type extends IFeature<?, ?>> implements IAdapterObservatoryBuilder<Type>
	{
		private final Class<? extends INotifierAdapter<Type>> notifierClass;
		private final List<INotifierPOI<Type>> observationPoints = new ArrayList<>();

		public Builder(Class<? extends INotifierAdapter<Type>> notifierClass)
		{
			this.notifierClass = notifierClass;
		}

		@Override
		public <Listener> IAdapterObservatoryBuilder<Type> listen(Listener listener,
																  IFeature<? super Listener, Type> feature)
		{
			observationPoints.add(new NotifierPOI<>(listener, feature));
			return this;
		}

		@Override
		public IAdapterObservatoryBuilder<Type> listenNoParam(final Runnable listener, final IFeature<?, Type> feature)
		{
			observationPoints.add(new NoParamNotifierPOI<>(listener, feature));
			return this;
		}

		@Override
		public IObservatory build()
		{
			return new AdapterObservatory<>(notifierClass, observationPoints);
		}
	}
}
