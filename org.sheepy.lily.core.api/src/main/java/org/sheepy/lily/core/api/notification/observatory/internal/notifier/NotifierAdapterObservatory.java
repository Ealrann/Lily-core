package org.sheepy.lily.core.api.notification.observatory.internal.notifier;

import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.observatory.IAdapterObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.INotifierAdapterObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class NotifierAdapterObservatory<Feature extends IFeature<?, ?>, Type extends INotifierAdapter<Feature>> implements
																													  IObservatory
{
	private final Class<Type> notifierAdapterClass;
	private final List<INotifierPOI<Feature>> observationPoints;
	private final List<Consumer<Type>> addListeners;
	private final List<Consumer<Type>> removeListeners;

	public NotifierAdapterObservatory(Class<Type> notifierAdapterClass,
									  List<INotifierPOI<Feature>> observationPoints,
									  List<Consumer<Type>> addListeners,
									  List<Consumer<Type>> removeListeners)
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

	public static final class Builder<Feature extends IFeature<?, ?>, Type extends INotifierAdapter<Feature>> implements
																											  INotifierAdapterObservatoryBuilder<Feature, Type>
	{
		private final Class<Type> notifierAdapterClass;
		private final List<INotifierPOI<Feature>> observationPoints = new ArrayList<>();
		private final List<Consumer<Type>> addListeners = new ArrayList<>();
		private final List<Consumer<Type>> removeListeners = new ArrayList<>();

		public Builder(Class<Type> notifierAdapterClass)
		{
			this.notifierAdapterClass = notifierAdapterClass;
		}

		@Override
		public <Listener> INotifierAdapterObservatoryBuilder<Feature, Type> listen(Listener listener,
																				   IFeature<? super Listener, Feature> feature)
		{
			observationPoints.add(new NotifierPOI<>(listener, feature));
			return this;
		}

		@Override
		public INotifierAdapterObservatoryBuilder<Feature, Type> listenNoParam(final Runnable listener,
																			   final IFeature<?, Feature> feature)
		{
			observationPoints.add(new NoParamNotifierPOI<>(listener, feature));
			return this;
		}

		@Override
		public IAdapterObservatoryBuilder<Type> listenAdd(Consumer<Type> onAddedObject)
		{
			addListeners.add(onAddedObject);
			return this;
		}

		@Override
		public IAdapterObservatoryBuilder<Type> listenRemove(Consumer<Type> onRemovedObject)
		{
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
