/**
 */
package org.sheepy.lily.core.model.application;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.ApplicationExtensionPackage#getExtensions <em>Extensions</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplicationExtensionPackage()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface ApplicationExtensionPackage extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.application.IApplicationExtension}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplicationExtensionPackage_Extensions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IApplicationExtension> getExtensions();

} // ApplicationExtensionPackage
