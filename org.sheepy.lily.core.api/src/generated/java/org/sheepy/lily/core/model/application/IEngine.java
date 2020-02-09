/**
 */
package org.sheepy.lily.core.model.application;

import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.model.resource.ResourcePkg;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEngine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.IEngine#getResourcePkg <em>Resource Pkg</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getIEngine()
 * @model interface="true" abstract="true"
 * @extends ILilyEObject
 * @generated
 */
public interface IEngine extends ILilyEObject
{

	/**
	 * Returns the value of the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Pkg</em>' containment reference.
	 * @see #setResourcePkg(ResourcePkg)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getIEngine_ResourcePkg()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ResourcePkg getResourcePkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.IEngine#getResourcePkg <em>Resource Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Pkg</em>' containment reference.
	 * @see #getResourcePkg()
	 * @generated
	 */
	void setResourcePkg(ResourcePkg value);} // IEngine
