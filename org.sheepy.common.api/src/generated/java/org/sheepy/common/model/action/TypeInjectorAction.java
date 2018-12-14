/**
 */
package org.sheepy.common.model.action;

import org.sheepy.common.model.types.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Injector Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.action.TypeInjectorAction#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.action.ActionPackage#getTypeInjectorAction()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface TypeInjectorAction<T extends Parameter> extends Action
{
	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference.
	 * @see #setAction(ParameteredAction)
	 * @see org.sheepy.common.model.action.ActionPackage#getTypeInjectorAction_Action()
	 * @model containment="true"
	 * @generated
	 */
	ParameteredAction<T> getAction();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.action.TypeInjectorAction#getAction <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' containment reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(ParameteredAction<T> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	T getInjectedValue();

} // TypeInjectorAction
