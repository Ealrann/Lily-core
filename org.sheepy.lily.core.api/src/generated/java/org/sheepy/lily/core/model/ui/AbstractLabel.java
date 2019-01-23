/**
 */
package org.sheepy.lily.core.model.ui;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.AbstractLabel#getText <em>Text</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.AbstractLabel#getFontScale <em>Font Scale</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getAbstractLabel()
 * @model abstract="true"
 * @generated
 */
public interface AbstractLabel extends Widget
{
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getAbstractLabel_Text()
	 * @model default="" unique="false"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.AbstractLabel#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

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
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getAbstractLabel_FontScale()
	 * @model default="1" unique="false"
	 * @generated
	 */
	float getFontScale();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.AbstractLabel#getFontScale <em>Font Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Scale</em>' attribute.
	 * @see #getFontScale()
	 * @generated
	 */
	void setFontScale(float value);

} // AbstractLabel
