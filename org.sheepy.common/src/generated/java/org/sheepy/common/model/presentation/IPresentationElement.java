/**
 */
package org.sheepy.common.model.presentation;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.common.api.types.SVector2i;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IPresentation Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.presentation.IPresentationElement#getPosition <em>Position</em>}</li>
 *   <li>{@link org.sheepy.common.model.presentation.IPresentationElement#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.common.model.presentation.IPresentationElement#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.presentation.PresentationPackage#getIPresentationElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IPresentationElement extends EObject
{
	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * The default value is <code>"0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(SVector2i)
	 * @see org.sheepy.common.model.presentation.PresentationPackage#getIPresentationElement_Position()
	 * @model default="0;0" unique="false" dataType="org.sheepy.common.model.types.SVector2i"
	 * @generated
	 */
	SVector2i getPosition();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.presentation.IPresentationElement#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(SVector2i value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.sheepy.common.model.presentation.PresentationPackage#getIPresentationElement_Width()
	 * @model unique="false"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.presentation.IPresentationElement#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.sheepy.common.model.presentation.PresentationPackage#getIPresentationElement_Height()
	 * @model unique="false"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.presentation.IPresentationElement#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

} // IPresentationElement
