package org.sheepy.lily.core.api.notification.util;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.api.notification.INotificationListener;

public class ModelObserver
{
	private final List<EStructuralFeature> features;
	private final HierarchyNotificationListener rootListener;
	private final INotificationListener listener;

	public ModelObserver(	INotificationListener listener,
							List<EStructuralFeature> structuralFeatures)
	{
		this.listener = listener;
		this.features = List.copyOf(structuralFeatures);

		rootListener = new HierarchyNotificationListener(0);
	}

	public void startObserve(ILilyEObject root)
	{
		rootListener.setTarget((LilyEObject) root);
		root.addListener(rootListener, features.get(0).getFeatureID());
	}

	public void stopObserve(ILilyEObject root)
	{
		root.removeListener(rootListener, features.get(0).getFeatureID());
		rootListener.unsetTarget((LilyEObject) root);
	}

	private final class HierarchyNotificationListener implements INotificationListener
	{
		private final int depth;
		private final int subFeatureId;

		private HierarchyNotificationListener childListener;

		public HierarchyNotificationListener(int depth)
		{
			this.depth = depth;
			this.subFeatureId = computeSubFeatureId();
		}

		private int computeSubFeatureId()
		{
			if (depth == features.size() - 1)
			{
				return -1;
			}
			else
			{
				return features.get(depth + 1).getFeatureID();
			}
		}

		private void setTarget(LilyEObject target)
		{
			final var feature = features.get(depth);
			final var value = target.eGet(feature);

			if (depth == features.size() - 1)
			{
				if (value != null)
				{
					if (feature.isMany() == false)
					{
						ModelObserver.this.listener.notifyChanged(new ENotificationImpl(target,
																						Notification.ADD,
																						feature.getFeatureID(),
																						null,
																						value));
					}
					else
					{
						ModelObserver.this.listener.notifyChanged(new ENotificationImpl(target,
																						Notification.ADD_MANY,
																						feature.getFeatureID(),
																						null,
																						value));
					}
				}
			}
			else
			{
				childListener = new HierarchyNotificationListener(depth + 1);

				if (value != null)
				{
					if (feature.isMany() == false)
					{
						final var child = (LilyEObject) value;
						addChild(child);
					}
					else
					{
						@SuppressWarnings("unchecked")
						final var list = (List<LilyEObject>) value;
						for (int i = 0; i < list.size(); i++)
						{
							final var child = list.get(i);
							addChild(child);
						}
					}
				}
			}
		}

		private void unsetTarget(LilyEObject target)
		{
			final var feature = features.get(depth);
			final var value = target.eGet(feature);

			if (depth == features.size() - 1)
			{
				if (value != null)
				{
					final int type = feature.isMany()
							? Notification.REMOVE_MANY
							: Notification.REMOVE;
					ModelObserver.this.listener.notifyChanged(new ENotificationImpl(target,
																					type,
																					feature.getFeatureID(),
																					value,
																					null));
				}
			}
			else
			{
				if (value != null)
				{
					if (feature.isMany() == false)
					{
						final var child = (LilyEObject) value;
						removeChild(child);
					}
					else
					{
						@SuppressWarnings("unchecked")
						final var list = (List<LilyEObject>) value;
						for (int i = 0; i < list.size(); i++)
						{
							final var child = list.get(i);
							removeChild(child);
						}
					}
				}
			}
		}

		@Override
		public void notifyChanged(Notification notification)
		{

			if (depth == features.size() - 1)
			{
				ModelObserver.this.listener.notifyChanged(notification);
			}
			else
			{
				NotificationUnifier.unify(notification, this::addChild, this::removeChild);
			}
		}

		private void addChild(final ILilyEObject child)
		{
			final var lilyChild = (LilyEObject) child;
			lilyChild.addListener(childListener, subFeatureId);
			childListener.setTarget(lilyChild);
		}

		private void removeChild(final ILilyEObject child)
		{
			final var lilyChild = (LilyEObject) child;
			childListener.unsetTarget(lilyChild);
			lilyChild.removeListener(childListener, subFeatureId);
		}
	}
}
