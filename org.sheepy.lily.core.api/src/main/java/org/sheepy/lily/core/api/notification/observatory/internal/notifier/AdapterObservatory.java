package org.sheepy.lily.core.api.notification.observatory.internal.notifier;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IAdapterObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class AdapterObservatory<Type extends IAdapter> implements IObservatory
{
	private final Class<Type> adapterClass;
	private final List<Consumer<Type>> addListeners;
	private final List<Consumer<Type>> removeListeners;

	public AdapterObservatory(Class<Type> adapterClass,
							  List<Consumer<Type>> addListeners,
							  List<Consumer<Type>> removeListeners)
	{
		this.adapterClass = adapterClass;
		this.addListeners = List.copyOf(addListeners);
		this.removeListeners = List.copyOf(removeListeners);
	}

	@Override
	public void observe(ILilyEObject object)
	{
		final var adapter = object.adapt(adapterClass);
		if (adapter != null)
		{
			for (final var listener : addListeners)
			{
				listener.accept(adapter);
			}
		}
	}

	@Override
	public void shut(ILilyEObject object)
	{
		final var adapter = object.adapt(adapterClass);
		if (adapter != null)
		{
			for (final var listener : removeListeners)
			{
				listener.accept(adapter);
			}
		}
	}

	public static final class Builder<Type extends IAdapter> implements IAdapterObservatoryBuilder<Type>
	{
		private final Class<Type> adapterClass;
		private final List<Consumer<Type>> addListeners = new ArrayList<>();
		private final List<Consumer<Type>> removeListeners = new ArrayList<>();

		public Builder(Class<Type> adapterClass)
		{
			this.adapterClass = adapterClass;
		}

		@Override
		public IAdapterObservatoryBuilder<Type> gather(Consumer<Type> onAddedObject, Consumer<Type> onRemovedObject)
		{
			addListeners.add(onAddedObject);
			removeListeners.add(onRemovedObject);
			return this;
		}

		@Override
		public IObservatory build()
		{
			return new AdapterObservatory<>(adapterClass, addListeners, removeListeners);
		}
	}
}
