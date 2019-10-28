package org.sheepy.lily.core.api.util;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.LilyEObject;

public class ModelSetObserver
{
	private final List<EStructuralFeature> features;
	private final HierarchyNotificationListener rootListener;
	private final INotificationListener listener;

	public ModelSetObserver(INotificationListener listener, List<EStructuralFeature> features)
	{
		this.listener = listener;
		this.features = List.copyOf(features);

		rootListener = new HierarchyNotificationListener(0);
	}

	public void startObserve(ILilyEObject root)
	{
		rootListener.setTarget((LilyEObject) root);
	}

	public void stopObserve(ILilyEObject root)
	{
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
						ModelSetObserver.this.listener.notifyChanged(new ENotificationImpl(	target,
																							Notification.ADD,
																							feature.getFeatureID(),
																							null,
																							value));
					}
					else
					{
						ModelSetObserver.this.listener.notifyChanged(new ENotificationImpl(	target,
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
					if (feature.isMany() == false)
					{
						ModelSetObserver.this.listener.notifyChanged(new ENotificationImpl(	target,
																							Notification.REMOVE_MANY,
																							feature.getFeatureID(),
																							value,
																							null));
					}
					else
					{
						ModelSetObserver.this.listener.notifyChanged(new ENotificationImpl(	target,
																							Notification.REMOVE,
																							feature.getFeatureID(),
																							value,
																							null));
					}
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
				ModelSetObserver.this.listener.notifyChanged(notification);
			}
			else
			{
				switch (notification.getEventType())
				{
				case Notification.ADD:
					addChild((LilyEObject) notification.getNewValue());
					break;
				case Notification.ADD_MANY:
					@SuppressWarnings("unchecked")
					final var newList = (List<LilyEObject>) notification.getNewValue();
					for (int i = 0; i < newList.size(); i++)
					{
						final var child = newList.get(i);
						addChild(child);
					}
					break;
				case Notification.SET:

					if (notification.getOldValue() != null)
						removeChild((LilyEObject) notification.getOldValue());
					if (notification.getNewValue() != null)
						addChild((LilyEObject) notification.getNewValue());
					break;
				case Notification.REMOVE:
					removeChild((LilyEObject) notification.getOldValue());
					break;
				case Notification.REMOVE_MANY:
					@SuppressWarnings("unchecked")
					final var oldList = (List<LilyEObject>) notification.getOldValue();
					for (int i = 0; i < oldList.size(); i++)
					{
						final var child = oldList.get(i);
						removeChild(child);
					}
					break;
				}
			}
		}

		private void addChild(final LilyEObject child)
		{
			child.addListener(childListener, subFeatureId);
			childListener.setTarget(child);
		}

		private void removeChild(final LilyEObject child)
		{
			childListener.unsetTarget(child);
			child.removeListener(childListener, subFeatureId);
		}
	}
}
