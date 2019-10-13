/**
 */
package org.sheepy.lily.core.model.cadence;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execute If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.cadence.ExecuteIf#getConditions <em>Conditions</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getExecuteIf()
 * @model
 * @generated
 */
public interface ExecuteIf extends CadenceTaskPkg
{
	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.cadence.ICadenceCondition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getExecuteIf_Conditions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ICadenceCondition> getConditions();

} // ExecuteIf
