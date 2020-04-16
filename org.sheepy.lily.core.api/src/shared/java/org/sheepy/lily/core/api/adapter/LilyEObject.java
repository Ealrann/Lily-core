package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LilyEObject extends EObjectImpl implements ILilyEObject
{
	private static final String CANNOT_FIND_ADAPTER_S_FOR_CLASS_S = "Cannot find adapter [%s] for class [%s]";

	private IAdapterManager adapterManager = null;

	@Override
	public final void listen(Consumer<Notification> listener, int... features)
	{
		setupAdapterManager();
		adapterManager.listen(listener, features);
	}

	@Override
	public final void sulk(Consumer<Notification> listener, int... features)
	{
		setupAdapterManager();
		adapterManager.sulk(listener, features);
	}

	@Override
	public final void listenNoParam(Runnable listener, int... features)
	{
		setupAdapterManager();
		adapterManager.listenNoParam(listener, features);
	}

	@Override
	public final void sulkNoParam(Runnable listener, int... features)
	{
		setupAdapterManager();
		adapterManager.sulkNoParam(listener, features);
	}

	@SuppressWarnings("unchecked")
	@Override
	public final <T extends IAdapter> T adaptGeneric(Class<? extends IAdapter> type)
	{
		return (T) adapt(type);
	}

	@Override
	public <T extends IAdapter> T adapt(Class<T> type)
	{
		setupAdapterManager();
		return adapterManager.adapt(type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public final <T extends IAdapter> T adaptNotNullGeneric(Class<? extends IAdapter> type)
	{
		return (T) adaptNotNull(type);
	}

	@Override
	public final <T extends IAdapter> T adaptNotNull(Class<T> type)
	{
		final T adapt = adapt(type);
		if (adapt == null)
		{
			final var message = String.format(CANNOT_FIND_ADAPTER_S_FOR_CLASS_S,
											  type.getSimpleName(),
											  eClass().getName());
			throw new NullPointerException(message);
		}
		return adapt;
	}

	@Override
	public final <T extends IAdapterAnnotationHandle> List<T> annotationHandlers(Class<T> type)
	{
		setupAdapterManager();
		return adapterManager.annotationHandles(type);
	}

	public final IAdapterManager getAdapterManager()
	{
		setupAdapterManager();
		return adapterManager;
	}

	public final void setupAdapterManager()
	{
		if (adapterManager == null)
		{
			adapterManager = IAdapterFactoryService.INSTANCE.createAdapterManager(this);
		}
	}

	public final void loadAdapterManager()
	{
		setupAdapterManager();
		adapterManager.load();
	}

	public final void disposeAdapterManager()
	{
		if (adapterManager != null)
		{
			adapterManager.dispose();
		}
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
