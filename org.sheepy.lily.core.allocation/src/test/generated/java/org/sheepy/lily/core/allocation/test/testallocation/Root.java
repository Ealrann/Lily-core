/**
 */
package org.sheepy.lily.core.allocation.test.testallocation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.Root#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.Root#getContainers <em>Containers</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends AllocationObject
{
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.allocation.test.testallocation.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getRoot_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Containers</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.allocation.test.testallocation.Container}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containers</em>' containment reference list.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getRoot_Containers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Container> getContainers();

} // Root
