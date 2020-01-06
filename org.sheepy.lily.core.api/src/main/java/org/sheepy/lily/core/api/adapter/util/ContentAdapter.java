package org.sheepy.lily.core.api.adapter.util;

import java.util.function.Consumer;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;

/**
 * Generic content adapter. deploy itself on all ILilyEObject children.
 * 
 * Need to be overriden to do something usefull.
 */
public final class ContentAdapter
{
	private final INotificationListener contentListener = this::notifyChanged;
	private final Consumer<ILilyEObject> install;
	private final Consumer<ILilyEObject> uninstall;

	public ContentAdapter(Consumer<ILilyEObject> install, Consumer<ILilyEObject> uninstall)
	{
		this.install = install;
		this.uninstall = uninstall;
	}

	public final void install(ILilyEObject root)
	{
		root.streamAllChildren().forEach(this::add);
	}

	public final void uninstall(ILilyEObject root)
	{
		root.streamAllChildren().forEach(this::remove);
	}

	private void add(ILilyEObject added)
	{
		final var collectContainmentFeatures = collectContainmentFeatures(added);
		added.addListener(contentListener, collectContainmentFeatures);
		install.accept(added);
	}

	private void remove(ILilyEObject removed)
	{
		final var collectContainmentFeatures = collectContainmentFeatures(removed);
		removed.removeListener(contentListener, collectContainmentFeatures);
		uninstall.accept(removed);
	}

	private void notifyChanged(Notification notification)
	{
		NotificationUnifier.unify(notification, this::add, this::remove);
	}

	private static int[] collectContainmentFeatures(ILilyEObject object)
	{
		final var classifier = object.eClass();
		final var list = classifier.getEAllContainments();
		final int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
		{
			res[i] = list.get(i).getFeatureID();
		}
		return res;
	}
}
