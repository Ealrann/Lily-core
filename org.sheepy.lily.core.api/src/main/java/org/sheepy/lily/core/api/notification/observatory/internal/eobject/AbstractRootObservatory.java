package org.sheepy.lily.core.api.notification.observatory.internal.eobject;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.core.api.notification.observatory.*;
import org.sheepy.lily.core.api.notification.observatory.internal.InternalObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.internal.allocation.AdapterObservatory;
import org.sheepy.lily.core.api.notification.observatory.internal.notifier.NotifierAdapterObservatory;
import org.sheepy.lily.core.api.notification.observatory.internal.notifier.NotifierObservatory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractRootObservatory implements IObservatory
{
	private final List<IObservatory> children;
	private final List<IEObjectPOI> pois;

	protected AbstractRootObservatory(List<IObservatory> children, List<IEObjectPOI> pois)
	{
		this.children = List.copyOf(children);
		this.pois = List.copyOf(pois);
	}

	protected void register(final ILilyEObject target)
	{
		for (var poi : pois)
		{
			poi.listen(target);
		}

		for (var child : children)
		{
			child.observe(target);
		}
	}

	protected void unregister(final ILilyEObject parent)
	{
		for (var child : children)
		{
			child.shut(parent);
		}

		for (var poi : pois)
		{
			poi.sulk(parent);
		}
	}

	public static abstract class Builder implements IObservatoryBuilder, InternalObservatoryBuilder
	{
		protected final List<InternalObservatoryBuilder> children = new ArrayList<>();
		protected final List<IEObjectPOI> pois = new ArrayList<>();

		@Override
		public IObservatoryBuilder focus(ILilyEObject object)
		{
			final var child = new FocusedObservatory.Builder(object);
			children.add(child);
			return child;
		}

		@Override
		public <F extends IFeatures<F>> INotifierObservatoryBuilder<F> focus(INotifier<F> notifier)
		{
			final var child = new NotifierObservatory.Builder<>(notifier);
			children.add(child);
			return child;
		}

		@Override
		public IEObjectObservatoryBuilder<ILilyEObject> explore(final int referenceId)
		{
			final var child = new EObjectObservatory.Builder<>(referenceId, ILilyEObject.class);
			children.add(child);
			return child;
		}

		@Override
		public <T extends ILilyEObject> IEObjectObservatoryBuilder<T> explore(final int referenceId,
																			  final Class<T> cast)
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
		public <T extends IExtender> IAdapterObservatoryBuilder<T> adapt(final Class<T> classifier)
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
		public IObservatoryBuilder listen(final Consumer<Notification> listener, final int... features)
		{
			pois.add(new EObjectPOI(listener, features));
			return this;
		}

		@Override
		public IObservatoryBuilder listenNoParam(final Runnable listener, final int... features)
		{
			pois.add(new EObjectNoParamPOI(listener, features));
			return this;
		}

		@Override
		public boolean isEmpty()
		{
			return pois.isEmpty() && children.isEmpty();
		}
	}
}
