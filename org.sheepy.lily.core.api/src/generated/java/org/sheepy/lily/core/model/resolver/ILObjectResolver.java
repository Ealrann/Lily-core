/**
 */
package org.sheepy.lily.core.model.resolver;

import java.util.Collection;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.model.root.LObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IL Object Resolver</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sheepy.lily.core.model.resolver.ResolverPackage#getILObjectResolver()
 * @model interface="true" abstract="true"
 * @extends ILilyEObject
 * @generated
 */
public interface ILObjectResolver extends ILilyEObject
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sourceUnique="false" collectedDataType="org.sheepy.lily.core.model.root.LCollection" collectedUnique="false"
	 * @generated
	 */
	void collectUnits(LObject source, Collection<LObject> collected);

} // ILObjectResolver
