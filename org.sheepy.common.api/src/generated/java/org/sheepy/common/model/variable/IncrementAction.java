/**
 */
package org.sheepy.common.model.variable;

import org.sheepy.common.model.action.ParameteredAction;

import org.sheepy.common.model.types.FloatParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Increment Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.variable.IncrementAction#getIncrement <em>Increment</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.variable.VariablePackage#getIncrementAction()
 * @model
 * @generated
 */
public interface IncrementAction extends ParameteredAction<FloatParameter>, VarChangeAction
{
	/**
	 * Returns the value of the '<em><b>Increment</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Increment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Increment</em>' attribute.
	 * @see #setIncrement(int)
	 * @see org.sheepy.common.model.variable.VariablePackage#getIncrementAction_Increment()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getIncrement();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.variable.IncrementAction#getIncrement <em>Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Increment</em>' attribute.
	 * @see #getIncrement()
	 * @generated
	 */
	void setIncrement(int value);

} // IncrementAction
