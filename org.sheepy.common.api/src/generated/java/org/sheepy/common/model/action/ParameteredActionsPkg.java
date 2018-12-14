/**
 */
package org.sheepy.common.model.action;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.sheepy.common.model.types.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parametered Actions Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 *  The parameter is only used on the edit class :
 * we only want ParameteredAction that can run with this parameter
 * (and not actions that need this specific parameter).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.action.ParameteredActionsPkg#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.action.ActionPackage#getParameteredActionsPkg()
 * @model
 * @generated
 */
public interface ParameteredActionsPkg<T extends Parameter> extends EObject
{
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.common.model.action.ParameteredAction}<code>&lt;?&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.sheepy.common.model.action.ActionPackage#getParameteredActionsPkg_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameteredAction<?>> getActions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EClass getParameterClassifier();

} // ParameteredActionsPkg
