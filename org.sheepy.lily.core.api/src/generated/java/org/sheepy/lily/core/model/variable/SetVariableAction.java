/**
 */
package org.sheepy.lily.core.model.variable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Variable Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.SetVariableAction#getValue <em>Value</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.variable.SetVariableAction#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.variable.VariablePackage#getSetVariableAction()
 * @model
 * @generated
 */
public interface SetVariableAction extends IModelVariableAction
{
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#getSetVariableAction_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.variable.SetVariableAction#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(IModelVariable)
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#getSetVariableAction_Variable()
	 * @model required="true"
	 * @generated
	 */
	IModelVariable getVariable();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.variable.SetVariableAction#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(IModelVariable value);

} // SetVariableAction
