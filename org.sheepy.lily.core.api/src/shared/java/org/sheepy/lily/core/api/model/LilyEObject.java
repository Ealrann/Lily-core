package org.sheepy.lily.core.api.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderManager;
import org.sheepy.lily.core.api.extender.IExtenderManagerFactory;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;
import org.sheepy.lily.core.model.types.LNamedElement;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

public abstract class LilyEObject extends LilyBasicNotifier implements ILilyEObject
{
	private static final String CANNOT_FIND_ADAPTER_S_FOR_CLASS_S = "Cannot find adapter [%s] for class [%s]";
	private static final IExtenderManagerFactory ADAPTER_FACTORY = IExtenderManagerFactory.INSTANCE;

	private final IExtenderManager.Internal extenderManager;

	private boolean loaded = false;

	public LilyEObject()
	{
		super();
		extenderManager = ADAPTER_FACTORY != null ? ADAPTER_FACTORY.createExtenderManager(this) : null;
	}

	@Override
	public void eNotify(final Notification notification)
	{
		final var feature = notification.getFeature();
		final boolean isContainment = feature instanceof EReference reference && reference.isContainment();
		if (isContainment) NotificationUnifier.unifyAdded(notification, this::setupChild);
		super.eNotify(notification);
		if (isContainment) NotificationUnifier.unifyRemoved(notification, this::disposeChild);
	}

	@Override
	public boolean eNotificationRequired()
	{
		return true;
	}

	private void setupChild(ILilyEObject notifier)
	{
		if (loaded && notifier instanceof LilyEObject child)
		{
			child.loadExtenderManager();
		}
	}

	private void disposeChild(ILilyEObject notifier)
	{
		if (loaded && notifier instanceof LilyEObject child)
		{
			child.disposeExtenderManager();
		}
	}

	@Override
	public final <T extends IExtender> T adaptGeneric(Class<? extends IExtender> type)
	{
		@SuppressWarnings("unchecked") final var adapt = (T) adapt(type);
		return adapt;
	}

	@Override
	public <T extends IExtender> T adapt(Class<T> type)
	{
		return extenderManager.adapt(type).findAny().orElse(null);
	}

	@Override
	public final <T extends IExtender> T adaptNotNullGeneric(Class<? extends IExtender> type)
	{
		@SuppressWarnings("unchecked") final var adapt = (T) adaptNotNull(type);
		return adapt;
	}

	@Override
	public final <T extends IExtender> T adaptNotNull(Class<T> type)
	{
		final T adapt = adapt(type);
		if (adapt == null)
		{
			var message = String.format(CANNOT_FIND_ADAPTER_S_FOR_CLASS_S, type.getSimpleName(), eClass().getName());
			if (this instanceof LNamedElement)
			{
				message += ": " + ((LNamedElement) this).getName();
			}
			throw new NullPointerException(message);
		}
		return adapt;
	}

	@Override
	public final IExtenderManager extenders()
	{
		return extenderManager;
	}

	public final void loadExtenderManager()
	{
		if (!loaded)
		{
			loaded = true;
			extenderManager.load();
		}
		foreachChild(LilyEObject::loadExtenderManager);
	}

	public final void disposeExtenderManager()
	{
		foreachChild(LilyEObject::disposeExtenderManager);
		if (loaded)
		{
			extenderManager.dispose();
			loaded = false;
		}
	}

	private void foreachChild(Consumer<LilyEObject> consumer)
	{
		streamChildren().map(LilyEObject.class::cast).forEach(consumer);
	}

	@Override
	public final Stream<ILilyEObject> streamChildren()
	{
		return eClass().getEAllContainments().stream().flatMap(this::streamReference).filter(Objects::nonNull);
	}

	@Override
	public final Stream<ILilyEObject> streamTree()
	{
		return Stream.concat(Stream.of(this), streamChildren().flatMap(ILilyEObject::streamTree));
	}

	@SuppressWarnings("unchecked")
	private Stream<ILilyEObject> streamReference(EReference ref)
	{
		if (ref.isMany())
		{
			return ((List<ILilyEObject>) eGet(ref)).stream();
		}
		else
		{
			return Stream.ofNullable((ILilyEObject) eGet(ref));
		}
	}
}
