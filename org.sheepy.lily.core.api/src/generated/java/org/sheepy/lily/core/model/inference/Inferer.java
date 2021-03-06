/**
 */
package org.sheepy.lily.core.model.inference;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inferer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * An Inferer takes "decisions" regarding its rules, and launch Actions on the executor.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.inference.Inferer#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.inference.InferencePackage#getInferer()
 * @model abstract="true"
 * @generated
 */
public interface Inferer extends IInferenceObject
{
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.inference.LRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.inference.InferencePackage#getInferer_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<LRule> getRules();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	IInferenceObject lExecutor();

} // Inferer
