package org.sheepy.lily.core.api.notification.observatory.internal.eobject.poi;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.model.ILilyEObject;

public final class EObjectStructureNoParamPOI implements IEObjectPOI
{
	private final Runnable listener;

	public EObjectStructureNoParamPOI(Runnable listener)
	{
		this.listener = listener;
	}

	@Override
	public void listen(final ILilyEObject object)
	{
		final var containmentFeatures = object.eClass()
											  .getEAllContainments()
											  .stream()
											  .mapToInt(EStructuralFeature::getFeatureID)
											  .toArray();
		object.listenNoParam(listener, containmentFeatures);
	}

	@Override
	public void sulk(final ILilyEObject object)
	{
		final var containmentFeatures = object.eClass()
											  .getEAllContainments()
											  .stream()
											  .mapToInt(EStructuralFeature::getFeatureID)
											  .toArray();
		object.sulkNoParam(listener, containmentFeatures);
	}
}
