package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;

import java.util.function.Consumer;

/**
 * Generic content adapter. deploy itself on all ILilyEObject children.
 * <p>
 * Need to be overriden to do something usefull.
 */
public final class ContentAdapter
{
	private final Consumer<Notification> contentListener = this::notifyChanged;
	private final Consumer<ILilyEObject> install;
	private final Consumer<ILilyEObject> uninstall;

	public ContentAdapter(Consumer<ILilyEObject> install, Consumer<ILilyEObject> uninstall)
	{
		this.install = install;
		this.uninstall = uninstall;
	}

	public void install(ILilyEObject root)
	{
		root.streamTree().forEach(this::add);
	}

	public void uninstall(ILilyEObject root)
	{
		root.streamTree().forEach(this::remove);
	}

	private void add(ILilyEObject added)
	{
		final var collectContainmentFeatures = collectContainmentFeatures(added);
		added.listen(contentListener, collectContainmentFeatures);
		install.accept(added);
	}

	private void remove(ILilyEObject removed)
	{
		final var collectContainmentFeatures = collectContainmentFeatures(removed);
		removed.sulk(contentListener, collectContainmentFeatures);
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
			res[i] = classifier.getFeatureID(list.get(i));
		}
		return res;
	}
}
