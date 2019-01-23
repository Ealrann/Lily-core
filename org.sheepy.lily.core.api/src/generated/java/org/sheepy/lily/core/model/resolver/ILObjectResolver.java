/**
 */
package org.sheepy.common.model.resolver;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.common.model.root.LObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IL Object Resolver</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sheepy.common.model.resolver.ResolverPackage#getILObjectResolver()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ILObjectResolver extends EObject
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sourceUnique="false" collectedDataType="org.sheepy.common.model.root.LCollection" collectedUnique="false"
	 * @generated
	 */
	void collectUnits(LObject source, Collection<LObject> collected);

} // ILObjectResolver
