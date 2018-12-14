/**
 */
package org.sheepy.common.model.ui;

import org.sheepy.common.model.presentation.Control;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.ui.AbstractLabel#getLabel <em>Label</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.AbstractLabel#getFontScale <em>Font Scale</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.ui.UiPackage#getAbstractLabel()
 * @model abstract="true"
 * @generated
 */
public interface AbstractLabel extends Control
{
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.sheepy.common.model.ui.UiPackage#getAbstractLabel_Label()
	 * @model default="" unique="false"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.ui.AbstractLabel#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Font Scale</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Scale</em>' attribute.
	 * @see #setFontScale(float)
	 * @see org.sheepy.common.model.ui.UiPackage#getAbstractLabel_FontScale()
	 * @model default="1" unique="false"
	 * @generated
	 */
	float getFontScale();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.ui.AbstractLabel#getFontScale <em>Font Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Scale</em>' attribute.
	 * @see #getFontScale()
	 * @generated
	 */
	void setFontScale(float value);

} // AbstractLabel
