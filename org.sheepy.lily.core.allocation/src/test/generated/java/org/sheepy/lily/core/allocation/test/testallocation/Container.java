/**
 */
package org.sheepy.lily.core.allocation.test.testallocation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.Container#getBoxes <em>Boxes</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends AllocationObject
{
	/**
	 * Returns the value of the '<em><b>Boxes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.allocation.test.testallocation.Box}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boxes</em>' containment reference list.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getContainer_Boxes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Box> getBoxes();

} // Container
