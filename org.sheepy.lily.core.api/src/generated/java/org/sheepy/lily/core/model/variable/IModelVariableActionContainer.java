/**
 */
package org.sheepy.lily.core.model.variable;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IModel Variable Action Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.IModelVariableActionContainer#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.variable.VariablePackage#getIModelVariableActionContainer()
 * @model interface="true" abstract="true"
 * @extends ILilyEObject
 * @generated
 */
public interface IModelVariableActionContainer extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.variable.IModelVariableAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#getIModelVariableActionContainer_Actions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IModelVariableAction> getActions();

} // IModelVariableActionContainer
