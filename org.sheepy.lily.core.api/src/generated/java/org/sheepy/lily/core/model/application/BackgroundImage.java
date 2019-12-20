/**
 */
package org.sheepy.lily.core.model.application;

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
} // BackgroundImage
