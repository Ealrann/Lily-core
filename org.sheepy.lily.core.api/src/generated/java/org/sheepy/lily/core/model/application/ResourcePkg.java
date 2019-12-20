/**
 */
package org.sheepy.lily.core.model.application;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.ResourcePkg#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getResourcePkg()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface ResourcePkg extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.application.IResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getResourcePkg_Resources()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IResource> getResources();

} // ResourcePkg
