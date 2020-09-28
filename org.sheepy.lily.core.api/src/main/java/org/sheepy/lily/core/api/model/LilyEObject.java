package org.sheepy.lily.core.api.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderManager;
import org.sheepy.lily.core.api.extender.IExtenderManagerFactory;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;
import org.sheepy.lily.core.model.types.LNamedElement;

import java.util.List;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
	public final void eNotify(final Notification notification)
	{
		final var feature = notification.getFeature();
		final boolean isContainment = feature instanceof EReference reference && reference.isContainment();
		if (isContainment) NotificationUnifier.unifyAdded(notification, this::setupChild);
		super.eNotify(notification);
		if (isContainment) NotificationUnifier.unifyRemoved(notification, this::disposeChild);
	}

	@Override
	public final boolean eNotificationRequired()
	{
		return true;
	}

	private void setupChild(ILilyEObject notifier)
	{
		if (loaded && notifier instanceof LilyEObject child)
		{
			child.deployExtenerManager();
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
	public final <T extends IExtender> T adaptGeneric(final Class<? extends IExtender> type)
	{
		@SuppressWarnings("unchecked") final var adapt = (T) adapt(type);
		return adapt;
	}

	@Override
	public final <T extends IExtender> T adapt(final Class<T> type)
	{
		return extenderManager.adapt(type).findAny().orElse(null);
	}

	@Override
	public final <T extends IExtender> T adapt(final Class<T> type, final String identifier)
	{
		return extenderManager.adapt(type, identifier).findAny().orElse(null);
	}

	@Override
	public final <T extends IExtender> T adaptNotNullGeneric(final Class<? extends IExtender> type)
	{
		@SuppressWarnings("unchecked") final var adapt = (T) adaptNotNull(type);
		return adapt;
	}

	@Override
	public final <T extends IExtender> T adaptNotNull(final Class<T> type)
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

	public final void deployExtenerManager()
	{
		streamTreeConcurrent().iterator().forEachRemaining(LilyEObject::deploy);
	}

	public final void loadExtenderManager()
	{
		streamTreeConcurrent().iterator().forEachRemaining(LilyEObject::load);
	}

	public final void disposeExtenderManager()
	{
		streamTree().map(LilyEObject.class::cast).forEach(LilyEObject::dispose);
	}

	private void deploy()
	{
		extenderManager.deploy();
	}

	private void load()
	{
		if (!loaded)
		{
			loaded = true;
			extenderManager.load();
		}
	}

	private void dispose()
	{
		if (loaded)
		{
			extenderManager.dispose();
			loaded = false;
		}
	}

	@Override
	public final Stream<ILilyEObject> streamChildren()
	{
		return eClass().getEAllContainments().stream().flatMap(this::streamReference);
	}

	private Stream<LilyEObject> streamChildrenConcurrent()
	{
		final var containmentFeatures = eClass().getEAllContainments().toArray(EReference[]::new);
		// This iterator supports insertion while iterating
		final var it = new EContentsEList.FeatureIteratorImpl<LilyEObject>(this, containmentFeatures);
		final var spliterator = Spliterators.spliteratorUnknownSize(it, 0);
		return StreamSupport.stream(spliterator, false);
	}

	@Override
	public final Stream<ILilyEObject> streamTree()
	{
		return Stream.of(Stream.of(this), streamChildren().flatMap(ILilyEObject::streamTree)).flatMap(t -> t);
	}

	private Stream<LilyEObject> streamTreeConcurrent()
	{
		return Stream.of(Stream.of(this), streamChildrenConcurrent().flatMap(LilyEObject::streamTreeConcurrent))
					 .flatMap(t -> t);
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
