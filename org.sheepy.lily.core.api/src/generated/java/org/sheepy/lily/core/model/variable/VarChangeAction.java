/**
 */
package org.sheepy.lily.core.model.variable;

import org.sheepy.lily.core.model.action.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Change Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.VarChangeAction#getVariableResolver <em>Variable Resolver</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.variable.VariablePackage#getVarChangeAction()
 * @model abstract="true"
 * @generated
 */
public interface VarChangeAction extends Action
{
	/**
	 * Returns the value of the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Resolver</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #setVariableResolver(AbstractVariableResolver)
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#getVarChangeAction_VariableResolver()
	 * @model containment="true"
	 * @generated
	 */
	AbstractVariableResolver getVariableResolver();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.variable.VarChangeAction#getVariableResolver <em>Variable Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #getVariableResolver()
	 * @generated
	 */
	void setVariableResolver(AbstractVariableResolver value);

} // VarChangeAction