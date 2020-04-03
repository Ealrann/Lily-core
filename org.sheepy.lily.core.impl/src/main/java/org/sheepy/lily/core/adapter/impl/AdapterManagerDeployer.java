package org.sheepy.lily.core.adapter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.adapter.impl.AdapterRegistry.AdapterDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterRegistry;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.api.notification.util.EMFListenerMap;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class AdapterManagerDeployer extends AdapterImpl
{
	public static final AdapterRegistry REGISTRY = (AdapterRegistry) IAdapterRegistry.INSTANCE;
	private static final String ADAPTER_CREATION_LOOP = "Adapter creation loop: ";

	private final Deque<AdapterDescriptor<?>> constructingAdapters = new ArrayDeque<>();
	private final EMFListenerMap listenerMap;

	private boolean constructing = false;
	private boolean autoLoad = false;

	public AdapterManagerDeployer(EObject target)
	{
		setTarget(target);

		final int featureCount = target.eClass().getEAllStructuralFeatures().size();
		listenerMap = new EMFListenerMap(featureCount);

		target.eAdapters().add(this);
	}

	public <T extends IAdapter> AdapterHandle<T> createAdapter(Class<T> type)
	{
		final var descriptor = REGISTRY.getDescriptorFor((EObject) target, type);
		return descriptor != null ? createAdapter(descriptor) : null;
	}

	public void buildAutoAdapters(List<AdapterHandle<?>> gatherIn)
	{
		final var autoAdapters = getDefinitions();
		for (int i = 0; i < autoAdapters.size(); i++)
		{
			final var descriptor = autoAdapters.get(i);
			if (descriptor.info.isAutoAdapter())
			{
				final var handle = createAdapter(descriptor);
				gatherIn.add(handle);
			}
		}
	}

	private <T extends IAdapter> AdapterHandle<T> createAdapter(final AdapterDescriptor<T> descriptor)
	{
		if (constructing && constructingAdapters.contains(descriptor))
		{
			throwAdapterCreationLoopException();
		}

		final var eTarget = (ILilyEObject) target;
		constructing = true;
		constructingAdapters.addLast(descriptor);

		final var res = new AdapterHandle<>(descriptor, eTarget);

		if (constructingAdapters.removeLast() != descriptor) throwBadError();
		constructing = !constructingAdapters.isEmpty();

		return res;
	}

	private void throwAdapterCreationLoopException() throws AssertionError
	{
		final var classLoop = constructingAdapters.stream()
												  .map(n -> n.domain.type.getSimpleName())
												  .collect(Collectors.joining(", "));

		throw new AssertionError(ADAPTER_CREATION_LOOP + classLoop);
	}

	public void listen(Consumer<Notification> listener, int... features)
	{
		listenerMap.listen(listener, features);
	}

	public void sulk(Consumer<Notification> listener, int... features)
	{
		listenerMap.sulk(listener, features);
	}

	public void listenNoParam(Runnable listener, int... features)
	{
		listenerMap.listenNoParam(listener, features);
	}

	public void sulkNoParam(Runnable listener, int... features)
	{
		listenerMap.sulkNoParam(listener, features);
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		final var feature = notification.getFeature();
		if (feature instanceof EReference && ((EReference) feature).isContainment() == true)
		{
			NotificationUnifier.unify(notification, this::setupChild, this::disposeChild);
		}

		listenerMap.notify(notification);
	}

	private void setupChild(ILilyEObject notifier)
	{
		final var child = (LilyEObject) notifier;
		child.setupAdapterManager();

		if (autoLoad)
		{
			child.loadAdapterManager();
		}
	}

	private void disposeChild(ILilyEObject notifier)
	{
		if (autoLoad)
		{
			final var child = (LilyEObject) notifier;
			child.disposeAdapterManager();
		}
	}

	public void foreachChild(Consumer<LilyEObject> consumer)
	{
		ModelUtil.streamChildren((EObject) target)
				 .map(LilyEObject.class::cast)
				 .collect(Collectors.toList())
				 .forEach(consumer);
	}

	public List<AdapterDescriptor<?>> getDefinitions()
	{
		final var eTarget = (EObject) target;
		return AdapterManagerDeployer.REGISTRY.getDefinitionsFor(eTarget);
	}

	public void setAutoLoad(boolean autoLoad)
	{
		this.autoLoad = autoLoad;
	}

	private static void throwBadError() throws AssertionError
	{
		throw new AssertionError("Something went really wrong");
	}

}
