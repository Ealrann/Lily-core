package org.sheepy.lily.core.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.IModelAdapter;

@Statefull
@Adapter(scope = EObject.class, scopeInheritance = true)
public class ModelAdapter implements IModelAdapter
{
	private final List<ModelListenerWrapper<?>> listeners = new ArrayList<>();
	private final EObject modelObject;

	private final EContentAdapter modelListener = new EContentAdapter()
	{
		@Override
		public void setTarget(EObject target)
		{
			checkObjectAdd(target);
			super.setTarget(target);
		}

		@Override
		protected void unsetTarget(EObject target)
		{
			super.setTarget(target);
			checkObjectRemove(target);
		}
	};

	public ModelAdapter(EObject modelObject)
	{
		this.modelObject = modelObject;
	}

	private void checkObjectAdd(EObject target)
	{
		for (final ModelListenerWrapper<?> wrapper : listeners)
		{
			if (wrapper.classifier.isInstance(target))
			{
				wrapper.notifyObjectAdded(target);
			}
		}
	}

	private void checkObjectRemove(EObject target)
	{
		for (final ModelListenerWrapper<?> wrapper : listeners)
		{
			if (wrapper.classifier.isInstance(target))
			{
				wrapper.notifyObjectRemoved(target);
			}
		}
	}

	@Override
	public <T extends EObject> void addListener(Class<T> classifier, IModelListener<T> listener)
	{
		if (listeners.isEmpty())
		{
			modelObject.eAdapters().add(modelListener);
		}

		final ModelListenerWrapper<T> wrapper = new ModelListenerWrapper<>();
		wrapper.classifier = classifier;
		wrapper.listener = listener;

		listeners.add(wrapper);
	}

	@Override
	public <T extends EObject> void removeListener(Class<T> classifier, IModelListener<T> listener)
	{
		final var it = listeners.iterator();
		while (it.hasNext())
		{
			final var wrapper = it.next();

			if (wrapper.classifier == classifier && wrapper.listener == listener)
			{
				it.remove();
			}
		}

		if (listeners.isEmpty())
		{
			modelObject.eAdapters().remove(modelListener);
		}
	}

	class ModelListenerWrapper<T extends EObject>
	{
		IModelListener<T> listener;
		Class<T> classifier;

		public void notifyObjectAdded(EObject target)
		{
			listener.onObjectAdded(classifier.cast(target));
		}

		public void notifyObjectRemoved(EObject target)
		{
			listener.onObjectRemoved(classifier.cast(target));
		}
	}
}
