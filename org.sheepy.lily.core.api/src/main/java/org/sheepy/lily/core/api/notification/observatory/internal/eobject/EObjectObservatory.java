package org.sheepy.lily.core.api.notification.observatory.internal.eobject;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.observatory.IAdapterObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IEObjectObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.INotifierAdapterObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.internal.notifier.AdapterObservatory;
import org.sheepy.lily.core.api.notification.observatory.internal.notifier.NotifierAdapterObservatory;
import org.sheepy.lily.core.api.notification.util.ModelStructureBulkObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class EObjectObservatory<T extends ILilyEObject> implements IObservatory
{
	private final ModelStructureBulkObserver structureObserver;

	private final Class<T> cast;
	private final List<IObservatory> children;
	private final List<IEObjectPOI> pois;
	private final List<GatherListener<T>> gatherListeners;
	private final List<GatherBulkListener<T>> gatherBulkListeners;

	public EObjectObservatory(EReference reference,
							  Class<T> cast,
							  List<IObservatory> children,
							  List<IEObjectPOI> pois,
							  List<GatherListener<T>> gatherListeners,
							  List<GatherBulkListener<T>> gatherBulkListeners)
	{
		structureObserver = new ModelStructureBulkObserver(reference, this::startObserve, this::stopObserve);
		this.cast = cast;
		this.children = List.copyOf(children);
		this.pois = List.copyOf(pois);
		this.gatherListeners = List.copyOf(gatherListeners);
		this.gatherBulkListeners = List.copyOf(gatherBulkListeners);
	}

	@Override
	public void observe(final ILilyEObject parent)
	{
		structureObserver.startObserve(parent);
	}

	@Override
	public void shut(final ILilyEObject parent)
	{
		structureObserver.stopObserve(parent);
	}

	@SuppressWarnings("unchecked")
	private void startObserve(List<? extends ILilyEObject> objects)
	{
		for (var listener : gatherBulkListeners)
		{
			listener.discoverObjects.accept((List<T>) objects);
		}

		for (var object : objects)
		{
			for (var listener : gatherListeners)
			{
				listener.discoverObject.accept(cast.cast(object));
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
	private void stopObserve(List<? extends ILilyEObject> objects)
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
				listener.removedObject.accept(cast.cast(object));
			}
		}

		for (var listener : gatherBulkListeners)
		{
			listener.removedObjects.accept((List<T>) objects);
		}
	}

	public static final class Builder<T extends ILilyEObject> implements IEObjectObservatoryBuilder<T>
	{
		private final EReference reference;
		private final Class<T> cast;
		private final List<IObservatory.IBuilder> children = new ArrayList<>();
		private final List<IEObjectPOI> pois = new ArrayList<>();
		private final List<GatherListener<T>> gatherListeners = new ArrayList<>();
		private final List<GatherBulkListener<T>> gatherBulkListeners = new ArrayList<>();

		public Builder(EReference reference, Class<T> cast)
		{
			this.reference = reference;
			this.cast = cast;
		}

		@Override
		public IEObjectObservatoryBuilder<ILilyEObject> explore(final EReference reference)
		{
			final var child = new EObjectObservatory.Builder<>(reference, ILilyEObject.class);
			children.add(child);
			return child;
		}

		@Override
		public <Y extends ILilyEObject> IEObjectObservatoryBuilder<Y> explore(final EReference reference,
																			  final Class<Y> cast)
		{
			final var child = new EObjectObservatory.Builder<>(reference, cast);
			children.add(child);
			return child;
		}

		@Override
		public <L extends IAdapter> IAdapterObservatoryBuilder<L> adapt(final Class<L> classifier)
		{
			final var child = new AdapterObservatory.Builder<>(classifier);
			children.add(child);
			return child;
		}

		@Override
		public <F extends IFeature<?, ?>> INotifierAdapterObservatoryBuilder<F, ? extends INotifierAdapter<F>> adaptNotifier(
				final Class<? extends INotifierAdapter<F>> classifier)
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

		@Override
		public IObservatory build()
		{
			final List<IObservatory> builtChildren = new ArrayList<>();
			for (var child : children)
			{
				builtChildren.add(child.build());
			}
			return new EObjectObservatory<>(reference, cast, builtChildren, pois, gatherListeners, gatherBulkListeners);
		}
	}

	private static final class GatherListener<T extends ILilyEObject>
	{
		final Consumer<T> discoverObject;
		final Consumer<T> removedObject;

		GatherListener(Consumer<T> discoverObject, Consumer<T> removedObject)
		{
			this.discoverObject = discoverObject;
			this.removedObject = removedObject;
		}
	}

	private static final class GatherBulkListener<T extends ILilyEObject>
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
