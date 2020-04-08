package org.sheepy.lily.core.api.notification.observatory.internal.eobject;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.core.api.notification.observatory.*;
import org.sheepy.lily.core.api.notification.observatory.internal.notifier.AdapterObservatory;
import org.sheepy.lily.core.api.notification.observatory.internal.notifier.NotifierAdapterObservatory;
import org.sheepy.lily.core.api.notification.observatory.internal.notifier.NotifierObservatory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class FocusedObservatory implements IObservatory
{
	private final ILilyEObject root;
	private final List<IObservatory> children;
	private final List<IEObjectPOI> pois;
	private boolean observing = false;

	private FocusedObservatory(ILilyEObject root, List<IObservatory> children, List<IEObjectPOI> pois)
	{
		this.root = root;
		this.children = List.copyOf(children);
		this.pois = List.copyOf(pois);
	}

	@Override
	public void observe(final ILilyEObject parent)
	{
		assert !observing;

		for (var poi : pois)
		{
			poi.listen(root);
		}

		for (var child : children)
		{
			child.observe(root);
		}
		observing = true;
	}

	@Override
	public void shut(final ILilyEObject parent)
	{
		assert observing;
		for (var child : children)
		{
			child.shut(root);
		}

		for (var poi : pois)
		{
			poi.sulk(root);
		}

		observing = false;
	}

	public static final class Builder implements IObservatoryBuilder
	{
		private final ILilyEObject root;
		private final List<IBuilder> children = new ArrayList<>();
		private final List<IEObjectPOI> pois = new ArrayList<>();

		public Builder(ILilyEObject root)
		{
			this.root = root;
		}

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
		public IEObjectObservatoryBuilder<ILilyEObject> explore(final EReference reference)
		{
			final var child = new EObjectObservatory.Builder<>(reference, ILilyEObject.class);
			children.add(child);
			return child;
		}

		@Override
		public <T extends ILilyEObject> IEObjectObservatoryBuilder<T> explore(final EReference reference,
																			  final Class<T> cast)
		{
			final var child = new EObjectObservatory.Builder<>(reference, cast);
			children.add(child);
			return child;
		}

		@Override
		public <T extends IAdapter> IAdapterObservatoryBuilder<T> adapt(final Class<T> classifier)
		{
			final var child = new AdapterObservatory.Builder<>(classifier);
			children.add(child);
			return child;
		}

		@Override
		public <F extends IFeatures<F>> INotifierAdapterObservatoryBuilder<F, ? extends INotifierAdapter<F>> adaptNotifier(
				final Class<? extends INotifierAdapter<F>> classifier)
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

		@Override
		public FocusedObservatory build()
		{
			final List<IObservatory> builtChildren = new ArrayList<>();
			for (var child : children)
			{
				builtChildren.add(child.build());
			}
			return new FocusedObservatory(root, builtChildren, pois);
		}
	}
}
