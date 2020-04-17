package org.sheepy.lily.core.api.notification.observatory.internal.eobject;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.core.api.notification.observatory.IAdapterObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IEObjectObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.INotifierAdapterObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.internal.InternalObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.internal.allocation.AdapterObservatory;
import org.sheepy.lily.core.api.notification.observatory.internal.notifier.NotifierAdapterObservatory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractEObjectObservatory<T extends ILilyEObject> implements IObservatory
{
	private final Class<T> cast;
	private final List<IObservatory> children;
	private final List<IEObjectPOI> pois;
	private final List<GatherListener<T>> gatherListeners;
	private final List<GatherBulkListener<T>> gatherBulkListeners;

	public AbstractEObjectObservatory(Class<T> cast,
									  List<IObservatory> children,
									  List<IEObjectPOI> pois,
									  List<GatherListener<T>> gatherListeners,
									  List<GatherBulkListener<T>> gatherBulkListeners)
	{
		this.cast = cast;
		this.children = List.copyOf(children);
		this.pois = List.copyOf(pois);
		this.gatherListeners = List.copyOf(gatherListeners);
		this.gatherBulkListeners = List.copyOf(gatherBulkListeners);
	}

	@SuppressWarnings("unchecked")
	protected void register(List<? extends ILilyEObject> objects)
	{
		for (var listener : gatherBulkListeners)
		{
			listener.discoverObjects.accept((List<T>) objects);
		}

		for (var object : objects)
		{
			for (var listener : gatherListeners)
			{
				if (cast.isInstance(object))
				{
					listener.discoverObject.accept(cast.cast(object));
				}
			}

			for (var poi : pois)
			{
				poi.listen(object);
			}

			for (var childObservatory : children)
			{
				childObservatory.observe(object);
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void unregister(List<? extends ILilyEObject> objects)
	{
		for (var object : objects)
		{
			for (var child : children)
			{
				child.shut(object);
			}

			for (var poi : pois)
			{
				poi.sulk(object);
			}

			for (var listener : gatherListeners)
			{
				if (cast.isInstance(object))
				{
					listener.removedObject.accept(cast.cast(object));
				}
			}
		}

		for (var listener : gatherBulkListeners)
		{
			listener.removedObjects.accept((List<T>) objects);
		}
	}

	protected static abstract class Builder<T extends ILilyEObject> implements IEObjectObservatoryBuilder<T>
	{
		protected final Class<T> cast;
		protected final List<InternalObservatoryBuilder> children = new ArrayList<>();
		protected final List<IEObjectPOI> pois = new ArrayList<>();
		protected final List<GatherListener<T>> gatherListeners = new ArrayList<>();
		protected final List<GatherBulkListener<T>> gatherBulkListeners = new ArrayList<>();

		public Builder(Class<T> cast)
		{
			this.cast = cast;
		}

		@Override
		public IEObjectObservatoryBuilder<ILilyEObject> explore(final int referenceId)
		{
			final var child = new EObjectObservatory.Builder<>(referenceId, ILilyEObject.class);
			children.add(child);
			return child;
		}

		@Override
		public <Y extends ILilyEObject> IEObjectObservatoryBuilder<Y> explore(final int referenceId,
																			  final Class<Y> cast)
		{
			final var child = new EObjectObservatory.Builder<>(referenceId, cast);
			children.add(child);
			return child;
		}

		@Override
		public IEObjectObservatoryBuilder<ILilyEObject> exploreParent()
		{
			final var child = new ParentObservatory.Builder<>(ILilyEObject.class);
			children.add(child);
			return child;
		}

		@Override
		public <Y extends ILilyEObject> IEObjectObservatoryBuilder<Y> exploreParent(final Class<Y> cast)
		{
			final var child = new ParentObservatory.Builder<>(cast);
			children.add(child);
			return child;
		}

		@Override
		public <L extends IExtender> IAdapterObservatoryBuilder<L> adapt(final Class<L> classifier)
		{
			final var child = new AdapterObservatory.Builder<>(classifier);
			children.add(child);
			return child;
		}

		@Override
		public <F extends IFeatures<F>, N extends IExtender & INotifier<F>> INotifierAdapterObservatoryBuilder<F, N> adaptNotifier(
				final Class<N> classifier)
		{
			final var child = new NotifierAdapterObservatory.Builder<>(classifier);
			children.add(child);
			return child;
		}

		@Override
		public IEObjectObservatoryBuilder<T> listen(final Consumer<Notification> listener, final int... features)
		{
			pois.add(new EObjectPOI(listener, features));
			return this;
		}

		@Override
		public IEObjectObservatoryBuilder<T> listenNoParam(final Runnable listener, final int... features)
		{
			pois.add(new EObjectNoParamPOI(listener, features));
			return this;
		}

		@Override
		public IEObjectObservatoryBuilder<T> gather(Consumer<T> discoverObject, Consumer<T> removedObject)
		{
			gatherListeners.add(new GatherListener<>(discoverObject, removedObject));
			return this;
		}

		@Override
		public IEObjectObservatoryBuilder<T> gatherBulk(Consumer<List<T>> discoverObjects,
														Consumer<List<T>> removedObjects)
		{
			gatherBulkListeners.add(new GatherBulkListener<>(discoverObjects, removedObjects));
			return this;
		}
	}

	protected static final class GatherListener<T extends ILilyEObject>
	{
		final Consumer<T> discoverObject;
		final Consumer<T> removedObject;

		GatherListener(Consumer<T> discoverObject, Consumer<T> removedObject)
		{
			this.discoverObject = discoverObject;
			this.removedObject = removedObject;
		}
	}

	protected static final class GatherBulkListener<T extends ILilyEObject>
	{
		final Consumer<List<T>> discoverObjects;
		final Consumer<List<T>> removedObjects;

		GatherBulkListener(Consumer<List<T>> discoverObjects, Consumer<List<T>> removedObjects)
		{
			this.discoverObjects = discoverObjects;
			this.removedObjects = removedObjects;
		}
	}
}
