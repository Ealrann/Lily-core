/**
 */
package org.sheepy.lily.core.model.variable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Int Change Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.IntChangeAction#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.variable.VariablePackage#getIntChangeAction()
 * @model
 * @generated
 */
public interface IntChangeAction extends VarChangeAction
{

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#getIntChangeAction_Value()
	 * @model required="true"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.variable.IntChangeAction#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);
} // IntChangeAction
