package org.sheepy.lily.core.api.notification.observatory.internal.eobject.poi;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.function.Consumer;

public final class EObjectStructurePOI implements IEObjectPOI
{
	private final Consumer<Notification> structureChanged;

	public EObjectStructurePOI(final Consumer<Notification> structureChanged)
	{
		this.structureChanged = structureChanged;
	}

	@Override
	public void listen(final ILilyEObject object)
	{
		final var containmentFeatures = object.eClass()
											  .getEAllContainments()
											  .stream()
											  .mapToInt(EStructuralFeature::getFeatureID)
											  .toArray();
		object.listen(structureChanged, containmentFeatures);
	}

	@Override
	public void sulk(final ILilyEObject object)
	{
		final var containmentFeatures = object.eClass()
											  .getEAllContainments()
											  .stream()
											  .mapToInt(EStructuralFeature::getFeatureID)
											  .toArray();
		object.sulk(structureChanged, containmentFeatures);
	}
}
