package org.sheepy.lily.core.api.notification.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ModelObserver
{
	private final int[] features;
	private final HierarchyNotificationListener rootListener;
	private final Consumer<Notification> listener;

	private boolean deliver = true;

	public ModelObserver(Consumer<Notification> listener, int structuralFeatureId)
	{
		this(listener, new int[]{structuralFeatureId});
	}

	public ModelObserver(Consumer<Notification> listener, int[] structuralFeatureIds)
	{
		this.listener = listener;
		this.features = Arrays.copyOf(structuralFeatureIds, structuralFeatureIds.length);
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
		root.listen(rootListener, features[0]);
	}

	public void stopObserve(ILilyEObject root)
	{
		root.sulk(rootListener, features[0]);
		rootListener.unsetTarget(root);
	}

	private final class HierarchyNotificationListener implements Consumer<Notification>
	{
		private final int depth;
		private final int subFeatureId;
		private final HierarchyNotificationListener childListener;

		public HierarchyNotificationListener(int depth)
		{
			this.depth = depth;
			this.subFeatureId = computeSubFeatureId();
			if (depth != features.length - 1)
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
			if (depth == features.length - 1)
			{
				return -1;
			}
			else
			{
				return features[depth + 1];
			}
		}

		private void setTarget(ILilyEObject target)
		{
			final var featureId = features[depth];
			final var feature = target.eClass().getEStructuralFeature(featureId);
			final var value = getValue(target, featureId);
			if (value == null) return;

			if (isFinalDepth())
			{
				if (deliver)
				{
					if (feature.isMany() == false)
					{
						ModelObserver.this.listener.accept(new ENotificationImpl(target,
																				 Notification.ADD,
																				 featureId,
																				 null,
																				 value));
					}
					else
					{
						ModelObserver.this.listener.accept(new ENotificationImpl(target,
																				 Notification.ADD_MANY,
																				 featureId,
																				 null,
																				 value));
					}
				}
			}
			else if (feature instanceof EReference)
			{
				try
				{
					actOnChildren(feature, value, this::addChild);
				}
				catch (IllegalArgumentException e)
				{
					throw new AssertionError("Error when exploring feature " + feature.getName() + " on " + target.eClass()
																												  .getName(),
											 e);
				}
			}
			else
			{
				throw new IllegalArgumentException("Observation failed, Feature Id " + featureId + " on class " + target
						.eClass()
						.getName() + " is not a EReference.");
			}
		}

		private void unsetTarget(ILilyEObject target)
		{
			final var featureId = features[depth];
			final var feature = target.eClass().getEStructuralFeature(featureId);
			final var value = getValue(target, featureId);
			if (value == null) return;

			if (isFinalDepth())
			{
				if (deliver)
				{
					final int type = feature.isMany() ? Notification.REMOVE_MANY : Notification.REMOVE;
					ModelObserver.this.listener.accept(new ENotificationImpl(target, type, featureId, value, null));
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

		private Object getValue(ILilyEObject target, final int featureId)
		{
			return target.eGet(featureId, true, true);
		}

		@Override
		public void accept(Notification notification)
		{
			if (isFinalDepth())
			{
				if (deliver)
				{
					ModelObserver.this.listener.accept(notification);
				}
			}
			else
			{
				NotificationUnifier.unify(notification, this::addChild, this::removeChild);
			}
		}

		private boolean isFinalDepth()
		{
			return depth == features.length - 1;
		}

		private void addChild(final ILilyEObject child)
		{
			child.listen(childListener, subFeatureId);
			childListener.setTarget(child);
		}

		private void removeChild(final ILilyEObject child)
		{
			childListener.unsetTarget(child);
			child.sulk(childListener, subFeatureId);
		}
	}
}
