package org.sheepy.lily.core.api.notification.observatory.internal.notifier;

import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.observatory.IAdapterObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.INotifierAdapterObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class NotifierAdapterObservatory<Type extends IFeatures<Type>, Notifier extends INotifierAdapter<Type>> implements
																													 IObservatory
{
	private final Class<Notifier> notifierAdapterClass;
	private final List<INotifierPOI<Type>> observationPoints;
	private final List<Consumer<Notifier>> addListeners;
	private final List<Consumer<Notifier>> removeListeners;

	public NotifierAdapterObservatory(Class<Notifier> notifierAdapterClass,
									  List<INotifierPOI<Type>> observationPoints,
									  List<Consumer<Notifier>> addListeners,
									  List<Consumer<Notifier>> removeListeners)
	{
		this.notifierAdapterClass = notifierAdapterClass;
		this.observationPoints = List.copyOf(observationPoints);
		this.addListeners = List.copyOf(addListeners);
		this.removeListeners = List.copyOf(removeListeners);
	}

	@Override
	public void observe(ILilyEObject object)
	{
		final var adapter = object.adapt(notifierAdapterClass);
		if (adapter != null)
		{
			for (final var listener : addListeners)
			{
				listener.accept(adapter);
			}

			for (final var point : observationPoints)
			{
				point.listen(adapter);
			}
		}
	}

	@Override
	public void shut(ILilyEObject object)
	{
		final var adapter = object.adapt(notifierAdapterClass);
		if (adapter != null)
		{
			for (final var point : observationPoints)
			{
				point.sulk(adapter);
			}

			for (final var listener : removeListeners)
			{
				listener.accept(adapter);
			}
		}
	}

	public static final class Builder<Type extends IFeatures<Type>, Notifier extends INotifierAdapter<Type>> implements
																											 INotifierAdapterObservatoryBuilder<Type, Notifier>
	{
		private final Class<Notifier> notifierAdapterClass;
		private final List<INotifierPOI<Type>> observationPoints = new ArrayList<>();
		private final List<Consumer<Notifier>> addListeners = new ArrayList<>();
		private final List<Consumer<Notifier>> removeListeners = new ArrayList<>();

		public Builder(Class<Notifier> notifierAdapterClass)
		{
			this.notifierAdapterClass = notifierAdapterClass;
		}

		@Override
		public <Listener> INotifierAdapterObservatoryBuilder<Type, Notifier> listen(Listener listener,
																					Feature<? super Listener, Type> feature)
		{
			observationPoints.add(new NotifierPOI<>(listener, feature));
			return this;
		}

		@Override
		public INotifierAdapterObservatoryBuilder<Type, Notifier> listenNoParam(final Runnable listener,
																				final Feature<?, Type> feature)
		{
			observationPoints.add(new NoParamNotifierPOI<>(listener, feature));
			return this;
		}

		@Override
		public IAdapterObservatoryBuilder<Notifier> gather(Consumer<Notifier> onAddedObject,
														   Consumer<Notifier> onRemovedObject)
		{
			addListeners.add(onAddedObject);
			removeListeners.add(onRemovedObject);
			return this;
		}

		@Override
		public IObservatory build()
		{
			return new NotifierAdapterObservatory<>(notifierAdapterClass,
													observationPoints,
													addListeners,
													removeListeners);
		}
	}
}
