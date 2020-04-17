package org.sheepy.lily.core.adapter.observation;

import org.sheepy.lily.core.adapter.annotation.AnnotationHandles;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;

public final class AdapterObservatory
{
	private final IObservatory observatory;

	public AdapterObservatory(AnnotationHandles<AdapterObserveHandle> handles)
	{
		this.observatory = prepareObservatory(handles);
	}

	public void observe(final ILilyEObject target)
	{
		observatory.observe(target);
	}

	public void shut(final ILilyEObject target)
	{
		observatory.shut(target);
	}

	private static IObservatory prepareObservatory(AnnotationHandles<AdapterObserveHandle> handles)
	{
		final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
		handles.call(o -> o.buildObservatory(observatoryBuilder));
		return observatoryBuilder.build();
	}
}
