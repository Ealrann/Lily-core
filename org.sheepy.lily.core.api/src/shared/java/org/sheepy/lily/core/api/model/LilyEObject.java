package org.sheepy.lily.core.api.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderManager;
import org.sheepy.lily.core.api.extender.IExtenderManagerFactory;
import org.sheepy.lily.core.model.types.LNamedElement;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

public abstract class LilyEObject extends EObjectImpl implements ILilyEObject
{
	private static final String CANNOT_FIND_ADAPTER_S_FOR_CLASS_S = "Cannot find adapter [%s] for class [%s]";
	private static final IExtenderManagerFactory ADAPTER_FACTORY = IExtenderManagerFactory.INSTANCE;

	private final IExtenderManager.Internal extenderManager;

	public LilyEObject()
	{
		extenderManager = ADAPTER_FACTORY != null ? ADAPTER_FACTORY.createExtenderManager(this) : null;
	}

	@Override
	public final void listen(Consumer<Notification> listener, int... features)
	{
		extenderManager.listen(listener, features);
	}

	@Override
	public final void sulk(Consumer<Notification> listener, int... features)
	{
		extenderManager.sulk(listener, features);
	}

	@Override
	public final void listenNoParam(Runnable listener, int... features)
	{
		extenderManager.listenNoParam(listener, features);
	}

	@Override
	public final void sulkNoParam(Runnable listener, int... features)
	{
		extenderManager.sulkNoParam(listener, features);
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
	public final IExtenderManager adapters()
	{
		return extenderManager;
	}

	public final void loadAdapterManager()
	{
		extenderManager.load();
	}

	public final void disposeAdapterManager()
	{
		extenderManager.dispose();
	}

	@Override
	public final Stream<ILilyEObject> streamChildren()
	{
		return eClass().getEAllContainments().stream().flatMap(this::streamReference).filter(Objects::nonNull);
	}

	@Override
	public final Stream<ILilyEObject> streamAllChildren()
	{
		return Stream.concat(Stream.of(this), streamChildren().flatMap(ILilyEObject::streamAllChildren));
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
			final var value = (ILilyEObject) eGet(ref);
			if (value != null)
			{
				return Stream.of(value);
			}
		}
		return Stream.empty();
	}
}
