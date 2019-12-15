/**
 */
package org.sheepy.lily.core.model.application;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEngine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.IEngine#getCadence <em>Cadence</em>}</li>
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
	 * Returns the value of the '<em><b>Cadence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cadence</em>' containment reference.
	 * @see #setCadence(ICadence)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getIEngine_Cadence()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	ICadence getCadence();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.IEngine#getCadence <em>Cadence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cadence</em>' containment reference.
	 * @see #getCadence()
	 * @generated
	 */
	void setCadence(ICadence value);} // IEngine
