/**
 */
package org.sheepy.lily.core.model.ui;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.Label#isWrap <em>Wrap</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getLabel()
 * @model
 * @generated
 */
public interface Label extends AbstractLabel
{

	/**
	 * Returns the value of the '<em><b>Wrap</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wrap</em>' attribute.
	 * @see #setWrap(boolean)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getLabel_Wrap()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isWrap();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Label#isWrap <em>Wrap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wrap</em>' attribute.
	 * @see #isWrap()
	 * @generated
	 */
	void setWrap(boolean value);} // Label
