package org.sheepy.lily.core.api.notification.observatory.internal.eobject;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.internal.eobject.poi.IEObjectPOI;

import java.util.ArrayList;
import java.util.List;

public final class RootObservatory extends AbstractRootObservatory
{
	private RootObservatory(List<IObservatory> children, List<IEObjectPOI> pois)
	{
		super(children, pois);
	}

	@Override
	public void observe(final ILilyEObject parent)
	{
		register(parent);
	}

	@Override
	public void shut(final ILilyEObject parent)
	{
		unregister(parent);
	}

	public static final class Builder extends AbstractRootObservatory.Builder
	{
		@Override
		public IObservatory build()
		{
			final List<IObservatory> builtChildren = new ArrayList<>();
			for (var child : children)
			{
				builtChildren.add(child.build());
			}
			return new RootObservatory(builtChildren, pois);
		}
	}
}
