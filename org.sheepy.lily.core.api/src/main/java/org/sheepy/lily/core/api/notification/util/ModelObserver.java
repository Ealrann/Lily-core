package org.sheepy.lily.core.api.notification.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.INotificationListener;

import java.util.List;
import java.util.function.Consumer;

public class ModelObserver
{
	private final List<EStructuralFeature> features;
	private final HierarchyNotificationListener rootListener;
	private final INotificationListener listener;

	private boolean deliver = true;

	public ModelObserver(INotificationListener listener, List<? extends EStructuralFeature> structuralFeatures)
	{
		this.listener = listener;
		this.features = List.copyOf(structuralFeatures);
		rootListener = new HierarchyNotificationListener(0);
	}

	/**
	 * @param deliver Enable or disable the notifications.
	 */
	public void setDeliver(boolean deliver)
	{
		this.deliver = deliver;
	}

	public void startObserve(ILilyEObject root)
	{
		rootListener.setTarget(root);
		root.addListener(rootListener, features.get(0).getFeatureID());
	}

	public void stopObserve(ILilyEObject root)
	{
		root.removeListener(rootListener, features.get(0).getFeatureID());
		rootListener.unsetTarget(root);
	}

	private final class HierarchyNotificationListener implements INotificationListener
	{
		private final int depth;
		private final int subFeatureId;
		private final HierarchyNotificationListener childListener;

		public HierarchyNotificationListener(int depth)
		{
			this.depth = depth;
			this.subFeatureId = computeSubFeatureId();
			if (depth != features.size() - 1)
			{
				childListener = new HierarchyNotificationListener(depth + 1);
			}
			else
			{
				childListener = null;
			}
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

		private void setTarget(ILilyEObject target)
		{
			final var feature = features.get(depth);
			final var value = getValue(target, feature);
			if (value == null) return;

			if (isFinalDepth())
			{
				if (deliver)
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
				actOnChildren(feature, value, this::addChild);
			}
		}

		private void unsetTarget(ILilyEObject target)
		{
			final var feature = features.get(depth);
			final var value = getValue(target, feature);
			if (value == null) return;

			if (isFinalDepth())
			{
				if (deliver)
				{
					final int type = feature.isMany() ? Notification.REMOVE_MANY : Notification.REMOVE;
					ModelObserver.this.listener.notifyChanged(new ENotificationImpl(target,
																					type,
																					feature.getFeatureID(),
																					value,
																					null));
				}
			}
			else
			{
				actOnChildren(feature, value, this::removeChild);
			}
		}

		@SuppressWarnings("unchecked")
		private void actOnChildren(EStructuralFeature feature, Object value, Consumer<ILilyEObject> action)
		{
			if (feature.isMany() == false)
			{
				action.accept((ILilyEObject) value);
			}
			else
			{
				final var list = (List<ILilyEObject>) value;
				for (int i = 0; i < list.size(); i++)
				{
					action.accept(list.get(i));
				}
			}
		}

		private Object getValue(ILilyEObject target, final EStructuralFeature feature)
		{
			if (target.eClass().getEAllStructuralFeatures().contains(feature))
			{
				return target.eGet(feature);
			}
			else
			{
				return null;
			}
		}

		@Override
		public void notifyChanged(Notification notification)
		{
			if (isFinalDepth())
			{
				if (deliver)
				{
					ModelObserver.this.listener.notifyChanged(notification);
				}
			}
			else
			{
				NotificationUnifier.unify(notification, this::addChild, this::removeChild);
			}
		}

		private boolean isFinalDepth()
		{
			return depth == features.size() - 1;
		}

		private void addChild(final ILilyEObject child)
		{
			child.addListener(childListener, subFeatureId);
			childListener.setTarget(child);
		}

		private void removeChild(final ILilyEObject child)
		{
			childListener.unsetTarget(child);
			child.removeListener(childListener, subFeatureId);
		}
	}
}
