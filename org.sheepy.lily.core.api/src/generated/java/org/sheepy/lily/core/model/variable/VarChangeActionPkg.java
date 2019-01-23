/**
 */
package org.sheepy.lily.core.model.variable;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Change Action Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.VarChangeActionPkg#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.variable.VariablePackage#getVarChangeActionPkg()
 * @model
 * @generated
 */
public interface VarChangeActionPkg extends EObject
{
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.variable.VarChangeAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#getVarChangeActionPkg_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<VarChangeAction> getActions();

} // VarChangeActionPkg
