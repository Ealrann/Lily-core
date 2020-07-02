/**
 */
package org.sheepy.lily.core.allocation.test.testallocation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Leaf</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.Leaf#getBoxes <em>Boxes</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getLeaf()
 * @model
 * @generated
 */
public interface Leaf extends AllocationObject
{
	/**
	 * Returns the value of the '<em><b>Boxes</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.allocation.test.testallocation.Box}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boxes</em>' reference list.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getLeaf_Boxes()
	 * @model
	 * @generated
	 */
	EList<Box> getBoxes();

} // Leaf
