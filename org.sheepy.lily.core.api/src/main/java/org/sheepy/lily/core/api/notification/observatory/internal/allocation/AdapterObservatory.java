package org.sheepy.lily.core.api.notification.observatory.internal.allocation;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IAdapterObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.internal.InternalObservatoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AdapterObservatory<Type extends IExtender> implements IObservatory
{
	private final Class<Type> adapterClass;
	private final List<IAdapterPOI<Type>> listeners;
	private final List<Consumer<Type>> gatherAdd;
	private final List<Consumer<Type>> gatherRemove;
	private final IExtenderHandle.ExtenderListener<Type> onAdapterUpdate = this::onAdapterUpdate;

	public AdapterObservatory(Class<Type> adapterClass,
							  List<IAdapterPOI<Type>> listeners,
							  List<Consumer<Type>> gatherAdd,
							  List<Consumer<Type>> gatherRemove)
	{
		this.adapterClass = adapterClass;
		this.listeners = List.copyOf(listeners);
		this.gatherAdd = List.copyOf(gatherAdd);
		this.gatherRemove = List.copyOf(gatherRemove);
	}

	@Override
	public void observe(ILilyEObject object)
	{
		object.adapterManager()
			  .adaptHandles(adapterClass)
			  .forEach(this::observeHandle);
	}

	@Override
	public void shut(ILilyEObject object)
	{
		object.adapterManager()
			  .adaptHandles(adapterClass)
			  .forEach(this::sulkHandle);
	}

	protected void observeHandle(final IExtenderHandle<Type> handle)
	{
		final var adapter = handle.getExtender();
		if (adapter != null)
		{
			gatherAdd(adapter);
		}

		handle.listen(onAdapterUpdate);
		for (final var listener : listeners)
		{
			listener.listen(handle);
		}
	}

	protected void sulkHandle(final IExtenderHandle<Type> handle)
	{
		final var adapter = handle.getExtender();
		if (adapter != null)
		{
			gatherRemove(adapter);
		}

		for (final var listener : listeners)
		{
			listener.sulk(handle);
		}
		handle.sulk(onAdapterUpdate);
	}

	protected void onAdapterUpdate(Type oldAdapter, Type newAdapter)
	{
		if (oldAdapter != null) gatherRemove(oldAdapter);
		if (newAdapter != null) gatherAdd(newAdapter);
	}

	protected void gatherAdd(final Type adapter)
	{
		for (final var listener : gatherAdd)
		{
			listener.accept(adapter);
		}
	}

	protected void gatherRemove(final Type adapter)
	{
		for (final var listener : gatherRemove)
		{
			listener.accept(adapter);
		}
	}

	public static class Builder<Type extends IExtender> implements IAdapterObservatoryBuilder<Type>,
																   InternalObservatoryBuilder
	{
		protected final Class<Type> adapterClass;
		protected final List<IAdapterPOI<Type>> listeners = new ArrayList<>();
		protected final List<Consumer<Type>> addListeners = new ArrayList<>();
		protected final List<Consumer<Type>> removeListeners = new ArrayList<>();

		public Builder(Class<Type> adapterClass)
		{
			this.adapterClass = adapterClass;
		}

		@Override
		public IAdapterObservatoryBuilder<Type> listenAdaptation(IExtenderHandle.ExtenderListener<Type> onNewAllocation)
		{
			listeners.add(new AdapterPOI<>(onNewAllocation));
			return this;
		}

		@Override
		public IAdapterObservatoryBuilder<Type> listenAdaptationNoParam(Runnable onNewAllocation)
		{
			listeners.add(new AdapterNoParamPOI<>(onNewAllocation));
			return this;
		}

		@Override
		public IAdapterObservatoryBuilder<Type> gatherAdaptation(Consumer<Type> onAddedObject,
																 Consumer<Type> onRemovedObject)
		{
			if (onAddedObject != null) addListeners.add(onAddedObject);
			if (onRemovedObject != null) removeListeners.add(onRemovedObject);
			return this;
		}

		@Override
		public IObservatory build()
		{
			return new AdapterObservatory<>(adapterClass, listeners, addListeners, removeListeners);
		}
	}
}
