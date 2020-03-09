/**
 */
package org.sheepy.lily.core.model.variable;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Variable Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.ModelVariablePkg#getVariables <em>Variables</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.variable.VariablePackage#getModelVariablePkg()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface ModelVariablePkg extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.variable.IModelVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#getModelVariablePkg_Variables()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IModelVariable> getVariables();

} // ModelVariablePkg
