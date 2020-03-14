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
import org.sheepy.lily.core.api.notification.util.ModelStructureObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class EObjectObservatory<T extends ILilyEObject> implements IObservatory
{
	private final ModelStructureObserver structureObserver;

	private final Class<T> cast;
	private final List<IObservatory> children;
	private final List<IEObjectPOI> pois;
	private final List<Consumer<T>> addListeners;
	private final List<Consumer<T>> removeListeners;

	public EObjectObservatory(EReference reference,
							  Class<T> cast,
							  List<IObservatory> children,
							  List<IEObjectPOI> pois,
							  List<Consumer<T>> addListeners,
							  List<Consumer<T>> removeListeners)
	{
		structureObserver = new ModelStructureObserver(reference, this::startObserve, this::stopObserve);
		this.cast = cast;
		this.children = List.copyOf(children);
		this.pois = List.copyOf(pois);
		this.addListeners = List.copyOf(addListeners);
		this.removeListeners = List.copyOf(removeListeners);
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

	private void startObserve(ILilyEObject object)
	{
		for (var listener : addListeners)
		{
			listener.accept(cast.cast(object));
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

	private void stopObserve(ILilyEObject object)
	{
		for (var child : children)
		{
			child.shut(object);
		}

		for (var poi : pois)
		{
			poi.sulk(object);
		}

		for (var listener : removeListeners)
		{
			listener.accept(cast.cast(object));
		}
	}

	public static final class Builder<T extends ILilyEObject> implements IEObjectObservatoryBuilder<T>
	{
		private final EReference reference;
		private final Class<T> cast;
		private final List<IObservatory.IBuilder> children = new ArrayList<>();
		private final List<IEObjectPOI> pois = new ArrayList<>();
		private final List<Consumer<T>> addListeners = new ArrayList<>();
		private final List<Consumer<T>> removeListeners = new ArrayList<>();

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
		public IEObjectObservatoryBuilder<T> listenAdd(final Consumer<T> onAddedObject)
		{
			addListeners.add(onAddedObject);
			return this;
		}

		@Override
		public IEObjectObservatoryBuilder<T> listenRemove(final Consumer<T> onRemovedObject)
		{
			removeListeners.add(onRemovedObject);
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
			return new EObjectObservatory<>(reference, cast, builtChildren, pois, addListeners, removeListeners);
		}
	}
}
