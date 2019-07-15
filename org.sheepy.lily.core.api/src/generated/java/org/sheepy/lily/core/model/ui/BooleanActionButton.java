/**
 */
package org.sheepy.lily.core.model.ui;

import org.sheepy.lily.core.model.action.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Action Button</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.BooleanActionButton#getActionWhenTrue <em>Action When True</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.BooleanActionButton#getActionWhenFalse <em>Action When False</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getBooleanActionButton()
 * @model
 * @generated
 */
public interface BooleanActionButton extends AbstractBooleanButton
{
	/**
	 * Returns the value of the '<em><b>Action When True</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action When True</em>' containment reference.
	 * @see #setActionWhenTrue(Action)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getBooleanActionButton_ActionWhenTrue()
	 * @model containment="true"
	 * @generated
	 */
	Action getActionWhenTrue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.BooleanActionButton#getActionWhenTrue <em>Action When True</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action When True</em>' containment reference.
	 * @see #getActionWhenTrue()
	 * @generated
	 */
	void setActionWhenTrue(Action value);

	/**
	 * Returns the value of the '<em><b>Action When False</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action When False</em>' containment reference.
	 * @see #setActionWhenFalse(Action)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getBooleanActionButton_ActionWhenFalse()
	 * @model containment="true"
	 * @generated
	 */
	Action getActionWhenFalse();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.BooleanActionButton#getActionWhenFalse <em>Action When False</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action When False</em>' containment reference.
	 * @see #getActionWhenFalse()
	 * @generated
	 */
	void setActionWhenFalse(Action value);

} // BooleanActionButton
