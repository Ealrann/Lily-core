/**
 */
package org.sheepy.common.model.ui;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Boolean Button</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.ui.AbstractBooleanButton#getTextWhenTrue <em>Text When True</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.AbstractBooleanButton#getTextWhenFalse <em>Text When False</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.ui.UiPackage#getAbstractBooleanButton()
 * @model abstract="true"
 * @generated
 */
public interface AbstractBooleanButton extends AbstractButton
{
	/**
	 * Returns the value of the '<em><b>Text When True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text When True</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text When True</em>' attribute.
	 * @see #setTextWhenTrue(String)
	 * @see org.sheepy.common.model.ui.UiPackage#getAbstractBooleanButton_TextWhenTrue()
	 * @model unique="false"
	 * @generated
	 */
	String getTextWhenTrue();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.ui.AbstractBooleanButton#getTextWhenTrue <em>Text When True</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text When True</em>' attribute.
	 * @see #getTextWhenTrue()
	 * @generated
	 */
	void setTextWhenTrue(String value);

	/**
	 * Returns the value of the '<em><b>Text When False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text When False</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text When False</em>' attribute.
	 * @see #setTextWhenFalse(String)
	 * @see org.sheepy.common.model.ui.UiPackage#getAbstractBooleanButton_TextWhenFalse()
	 * @model unique="false"
	 * @generated
	 */
	String getTextWhenFalse();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.ui.AbstractBooleanButton#getTextWhenFalse <em>Text When False</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text When False</em>' attribute.
	 * @see #getTextWhenFalse()
	 * @generated
	 */
	void setTextWhenFalse(String value);

} // AbstractBooleanButton
