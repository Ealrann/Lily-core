/**
 */
package org.sheepy.lily.core.model.resource;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.resource.ResourcePkg#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.resource.ResourcePackage#getResourcePkg()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface ResourcePkg extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.resource.IRootResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.resource.ResourcePackage#getResourcePkg_Resources()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IRootResource> getResources();

} // ResourcePkg
