package org.sheepy.lily.core.api.notification.observatory.internal.eobject;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.internal.eobject.poi.IEObjectPOI;

import java.util.ArrayList;
import java.util.List;

public final class FocusedObservatory extends AbstractRootObservatory
{
	private final ILilyEObject root;

	private FocusedObservatory(ILilyEObject root, List<IObservatory> children, List<IEObjectPOI> pois)
	{
		super(children, pois);
		this.root = root;
	}

	@Override
	public void observe(final ILilyEObject parent)
	{
		register(root);
	}

	@Override
	public void shut(final ILilyEObject parent)
	{
		unregister(root);
	}

	public static final class Builder extends AbstractRootObservatory.Builder
	{
		private final ILilyEObject root;

		public Builder(ILilyEObject root)
		{
			super();
			this.root = root;
		}

		@Override
		public FocusedObservatory build()
		{
			final List<IObservatory> builtChildren = new ArrayList<>();
			for (var child : children)
			{
				builtChildren.add(child.build());
			}
			return new FocusedObservatory(root, builtChildren, pois);
		}
	}
}
