/**
 */
package org.sheepy.lily.core.model.presentation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ISized Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.presentation.ISizedElement#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.presentation.ISizedElement#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getISizedElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ISizedElement extends IPositionElement
{
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
	 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getISizedElement_Width()
	 * @model unique="false"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.presentation.ISizedElement#getWidth <em>Width</em>}' attribute.
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
	 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getISizedElement_Height()
	 * @model unique="false"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.presentation.ISizedElement#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

} // ISizedElement
