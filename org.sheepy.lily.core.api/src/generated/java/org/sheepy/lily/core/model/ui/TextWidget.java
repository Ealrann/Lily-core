/**
 */
package org.sheepy.lily.core.model.ui;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Widget</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.TextWidget#getFont <em>Font</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getTextWidget()
 * @model abstract="true"
 * @generated
 */
public interface TextWidget extends Widget
{
	/**
	 * Returns the value of the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font</em>' reference.
	 * @see #setFont(Font)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getTextWidget_Font()
	 * @model
	 * @generated
	 */
	Font getFont();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.TextWidget#getFont <em>Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font</em>' reference.
	 * @see #getFont()
	 * @generated
	 */
	void setFont(Font value);

} // TextWidget
