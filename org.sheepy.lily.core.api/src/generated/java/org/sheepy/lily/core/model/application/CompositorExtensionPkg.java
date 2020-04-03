/**
 */
package org.sheepy.lily.core.model.application;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compositor Extension Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.CompositorExtensionPkg#getExtensions <em>Extensions</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getCompositorExtensionPkg()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface CompositorExtensionPkg extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.application.ICompositorExtension}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getCompositorExtensionPkg_Extensions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ICompositorExtension> getExtensions();

} // CompositorExtensionPkg
