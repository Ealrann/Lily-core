package org.sheepy.lily.core.api.notification.observatory.internal.eobject;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IEObjectObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.internal.InternalObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.internal.eobject.poi.IEObjectPOI;

import java.util.ArrayList;
import java.util.List;

public final class ParentObservatory<T extends ILilyEObject> extends AbstractEObjectObservatory<T> implements
																								   IObservatory
{
	private ParentObservatory(Class<T> cast,
							  List<IObservatory> children,
							  List<IEObjectPOI> pois,
							  List<GatherListener<T>> gatherListeners,
							  List<GatherBulkListener<T>> gatherBulkListeners)
	{
		super(cast, children, pois, gatherListeners, gatherBulkListeners);
	}

	@Override
	public void observe(final ILilyEObject source)
	{
		final var parent = (ILilyEObject) source.eContainer();
		register(List.of(parent));
	}

	@Override
	public void shut(final ILilyEObject source)
	{
		final var parent = (ILilyEObject) source.eContainer();
		unregister(List.of(parent));
	}

	public static final class Builder<T extends ILilyEObject> extends AbstractEObjectObservatory.Builder<T> implements
																											IEObjectObservatoryBuilder<T>,
																											InternalObservatoryBuilder
	{
		public Builder(Class<T> cast)
		{
			super(cast);
		}

		@Override
		public ParentObservatory<T> build()
		{
			final List<IObservatory> builtChildren = new ArrayList<>();
			for (var child : children)
			{
				builtChildren.add(child.build());
			}
			return new ParentObservatory<>(cast, builtChildren, pois, gatherListeners, gatherBulkListeners);
		}
	}
}
