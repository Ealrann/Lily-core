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
 *   <li>{@link org.sheepy.lily.core.model.ui.Label#isNarrator <em>Narrator</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.Label#getNarrationSpeed <em>Narration Speed</em>}</li>
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
	void setWrap(boolean value);

	/**
	 * Returns the value of the '<em><b>Narrator</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Narrator</em>' attribute.
	 * @see #setNarrator(boolean)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getLabel_Narrator()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isNarrator();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Label#isNarrator <em>Narrator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Narrator</em>' attribute.
	 * @see #isNarrator()
	 * @generated
	 */
	void setNarrator(boolean value);

	/**
	 * Returns the value of the '<em><b>Narration Speed</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Narration Speed</em>' attribute.
	 * @see #setNarrationSpeed(int)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getLabel_NarrationSpeed()
	 * @model default="100"
	 * @generated
	 */
	int getNarrationSpeed();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Label#getNarrationSpeed <em>Narration Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Narration Speed</em>' attribute.
	 * @see #getNarrationSpeed()
	 * @generated
	 */
	void setNarrationSpeed(int value);} // Label
