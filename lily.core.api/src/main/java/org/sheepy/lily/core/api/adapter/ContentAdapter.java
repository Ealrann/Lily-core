package org.sheepy.lily.core.api.adapter;

import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.api.notification.util.NotificationUnifier;

import java.util.function.Consumer;

/**
 * Generic content adapter. deploy itself on all LMObject children.
 * <p>
 * Need to be overriden to do something usefull.
 */
public final class ContentAdapter
{
	private final Consumer<Notification> contentListener = this::notifyChanged;
	private final Consumer<LMObject> install;
	private final Consumer<LMObject> uninstall;

	public ContentAdapter(final Consumer<LMObject> install, final Consumer<LMObject> uninstall)
	{
		this.install = install;
		this.uninstall = uninstall;
	}

	public void install(final LMObject root)
	{
		root.streamTree().forEach(this::add);
	}

	public void uninstall(final LMObject root)
	{
		root.streamTree().forEach(this::remove);
	}

	private void add(final LMObject added)
	{
		added.notifier().listenStructure(contentListener);
		install.accept(added);
	}

	private void remove(final LMObject removed)
	{
		removed.notifier().sulkStructure(contentListener);
		uninstall.accept(removed);
	}

	private void notifyChanged(final Notification notification)
	{
		NotificationUnifier.unify(notification, this::add, this::remove);
	}
}
