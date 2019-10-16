/**
 */
package org.sheepy.lily.core.model.cadence;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execute While</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.cadence.ExecuteWhile#getConditions <em>Conditions</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getExecuteWhile()
 * @model
 * @generated
 */
public interface ExecuteWhile extends CadenceTaskPkg
{
	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.cadence.ICadenceCondition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getExecuteWhile_Conditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ICadenceCondition> getConditions();

} // ExecuteWhile
