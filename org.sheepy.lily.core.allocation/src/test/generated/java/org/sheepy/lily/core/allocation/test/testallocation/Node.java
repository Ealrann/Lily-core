/**
 */
package org.sheepy.lily.core.allocation.test.testallocation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.Node#getLeaves <em>Leaves</em>}</li>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.Node#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends AllocationObject
{
	/**
	 * Returns the value of the '<em><b>Leaves</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.allocation.test.testallocation.Leaf}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaves</em>' containment reference list.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getNode_Leaves()
	 * @model containment="true"
	 * @generated
	 */
	EList<Leaf> getLeaves();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(Container)
	 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getNode_Container()
	 * @model
	 * @generated
	 */
	Container getContainer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.allocation.test.testallocation.Node#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Container value);

} // Node
