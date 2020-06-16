package org.sheepy.lily.core.api.notification.util;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class ParentObserver
{
	private final ParentListener listener;
	private final List<DedicatedListener> installedListeners = new ArrayList<>(1);

	public ParentObserver(ParentListener listener)
	{
		this.listener = listener;
	}

	public void startObserve(ILilyEObject source)
	{
		final var listener = new DedicatedListener(source);
		listener.install(source);
		installedListeners.add(listener);
	}

	public void stopObserve(ILilyEObject source)
	{
		final var installedListener = installedListeners.stream()
														.filter(listener -> listener.source == source)
														.findAny();
		assert installedListener.isPresent();
		final var listener = installedListener.get();
		listener.uninstall();
		installedListeners.remove(listener);
	}

	private final class DedicatedListener
	{
		private final ILilyEObject source;
		private final Consumer<Notification> containerListener = this::containerChange;

		private DedicatedListener(ILilyEObject source)
		{
			this.source = source;
		}

		public void install(ILilyEObject source)
		{
			final var container = (ILilyEObject) source.eContainer();
			assert container != null; // cannot deal with this case. Please stop listen parent before removing an object.
			final int containingFeature = source.eContainingFeature().getFeatureID();
			container.listen(containerListener, containingFeature);
		}

		public void uninstall()
		{
			final var container = (ILilyEObject) source.eContainer();
			if (container != null)
			{
				final int containingFeature = source.eContainingFeature().getFeatureID();
				container.sulk(containerListener, containingFeature);
			}
		}

		private void containerChange(Notification notification)
		{
			final var oldParent = (ILilyEObject) notification.getNotifier();
			final var newParent = (ILilyEObject) source.eContainer();

			if (oldParent != newParent)
			{
				final int oldContainingFeature = notification.getFeatureID(oldParent.getClass());
				oldParent.sulk(containerListener, oldContainingFeature);
				if (newParent != null)
				{
					final int containingFeature = source.eContainingFeature().getFeatureID();
					newParent.listen(containerListener, containingFeature);
				}
				listener.accept(oldParent, newParent);
			}
		}
	}

	@FunctionalInterface
	public interface ParentListener extends BiConsumer<ILilyEObject, ILilyEObject>
	{
		void parentChanged(ILilyEObject oldParent, ILilyEObject newParent);

		@Override
		default void accept(ILilyEObject oldParent, ILilyEObject newParent)
		{
			parentChanged(oldParent, newParent);
		}
	}
}
