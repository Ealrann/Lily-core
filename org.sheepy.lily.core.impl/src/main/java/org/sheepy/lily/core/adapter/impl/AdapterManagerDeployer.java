package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.impl.AdapterRegistry.AdapterDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterRegistry;
import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.api.util.ListenerNotificationMap;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.api.util.TinyEContentAdapter;

public final class AdapterManagerDeployer extends TinyEContentAdapter
{
	public static final AdapterRegistry REGISTRY = (AdapterRegistry) IAdapterRegistry.INSTANCE;
	private static final String ADAPTER_CREATION_LOOP = "Adapter creation loop.";

	private final Deque<AdapterDescriptor<?>> constructingAdapters = new ArrayDeque<>();
	private final ListenerNotificationMap notificationMap;

	private boolean constructing = false;
	private boolean autoLoad = false;

	public AdapterManagerDeployer(EObject target)
	{
		setTarget(target);

		final int featureCount = target.eClass().getEAllStructuralFeatures().size();
		notificationMap = new ListenerNotificationMap(featureCount);

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
		if (autoAdapters != null)
		{
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
	}

	private <T extends IAdapter> AdapterHandle<T> createAdapter(final AdapterDescriptor<T> descriptor)
	{
		if (constructing && constructingAdapters.contains(descriptor))
		{
			throw new AssertionError(ADAPTER_CREATION_LOOP);
		}

		final var eTarget = (EObject) target;
		constructing = true;
		constructingAdapters.addLast(descriptor);

		final var res = new AdapterHandle<>(descriptor, eTarget);

		if (constructingAdapters.removeLast() != descriptor) throwBadError();
		constructing = !constructingAdapters.isEmpty();

		return res;
	}

	public void addListener(INotificationListener listener, int... features)
	{
		notificationMap.addListener(listener, features);
	}

	public void removeListener(INotificationListener listener, int... features)
	{
		notificationMap.removeListener(listener, features);
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		super.notifyChanged(notification);
		notificationMap.notifyChanged(notification);
	}

	@Override
	protected void setupChild(Notifier notifier)
	{
		final var child = (LilyEObject) notifier;
		child.setupAdapterManager();

		if (autoLoad)
		{
			child.loadAdapterManager();
		}
	}

	@Override
	protected void disposeChild(Notifier notifier)
	{
		if (autoLoad)
		{
			final var child = (LilyEObject) notifier;
			child.disposeAdapterManager();
		}
	}

	public void foreachChild(Consumer<LilyEObject> consumer)
	{
		ModelUtil	.streamChildren((EObject) target)
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