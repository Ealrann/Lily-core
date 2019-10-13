/**
 */
package org.sheepy.lily.core.model.cadence;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.cadence.CadenceTaskPkg#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getCadenceTaskPkg()
 * @model abstract="true"
 * @generated
 */
public interface CadenceTaskPkg extends ICadenceTask
{
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.cadence.ICadenceTask}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getCadenceTaskPkg_Tasks()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ICadenceTask> getTasks();

} // CadenceTaskPkg
