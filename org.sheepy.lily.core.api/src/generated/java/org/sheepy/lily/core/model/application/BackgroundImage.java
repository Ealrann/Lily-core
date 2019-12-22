/**
 */
package org.sheepy.lily.core.model.application;

import org.joml.Vector3ic;
import org.sheepy.lily.core.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Background Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.BackgroundImage#getResource <em>Resource</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.BackgroundImage#getClearColor <em>Clear Color</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.BackgroundImage#getSampling <em>Sampling</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getBackgroundImage()
 * @model
 * @generated
 */
public interface BackgroundImage extends LNamedElement, IScenePart
{

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(IResource)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getBackgroundImage_Resource()
	 * @model
	 * @generated
	 */
	IResource getResource();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.BackgroundImage#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(IResource value);

	/**
	 * Returns the value of the '<em><b>Clear Color</b></em>' attribute.
	 * The default value is <code>"0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Color</em>' attribute.
	 * @see #setClearColor(Vector3ic)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getBackgroundImage_ClearColor()
	 * @model default="0;0;0" dataType="org.sheepy.lily.core.model.types.Vector3i" required="true"
	 * @generated
	 */
	Vector3ic getClearColor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.BackgroundImage#getClearColor <em>Clear Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Color</em>' attribute.
	 * @see #getClearColor()
	 * @generated
	 */
	void setClearColor(Vector3ic value);

	/**
	 * Returns the value of the '<em><b>Sampling</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.core.model.application.ESampling}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sampling</em>' attribute.
	 * @see org.sheepy.lily.core.model.application.ESampling
	 * @see #setSampling(ESampling)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getBackgroundImage_Sampling()
	 * @model required="true"
	 * @generated
	 */
	ESampling getSampling();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.BackgroundImage#getSampling <em>Sampling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sampling</em>' attribute.
	 * @see org.sheepy.lily.core.model.application.ESampling
	 * @see #getSampling()
	 * @generated
	 */
	void setSampling(ESampling value);
} // BackgroundImage
