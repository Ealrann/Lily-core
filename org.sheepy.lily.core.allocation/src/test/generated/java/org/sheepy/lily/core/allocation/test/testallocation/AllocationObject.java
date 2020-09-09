/**
 */
package org.sheepy.lily.core.allocation.test.testallocation;

import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Allocation Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#getCurrentAllocationCount <em>Current Allocation Count</em>}</li>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#getTotalAllocationCount <em>Total Allocation Count</em>}</li>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#getDependencyUpdateCount <em>Dependency Update Count</em>}</li>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#isActivated <em>Activated</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getAllocationObject()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface AllocationObject extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Current Allocation Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Allocation Count</em>' attribute.
	 * @see #setCurrentAllocationCount(int)
	 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getAllocationObject_CurrentAllocationCount()
	 * @model default="0"
	 * @generated
	 */
	int getCurrentAllocationCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#getCurrentAllocationCount <em>Current Allocation Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Allocation Count</em>' attribute.
	 * @see #getCurrentAllocationCount()
	 * @generated
	 */
	void setCurrentAllocationCount(int value);

	/**
	 * Returns the value of the '<em><b>Total Allocation Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Allocation Count</em>' attribute.
	 * @see #setTotalAllocationCount(int)
	 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getAllocationObject_TotalAllocationCount()
	 * @model default="0"
	 * @generated
	 */
	int getTotalAllocationCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#getTotalAllocationCount <em>Total Allocation Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Allocation Count</em>' attribute.
	 * @see #getTotalAllocationCount()
	 * @generated
	 */
	void setTotalAllocationCount(int value);

	/**
	 * Returns the value of the '<em><b>Dependency Update Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency Update Count</em>' attribute.
	 * @see #setDependencyUpdateCount(int)
	 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getAllocationObject_DependencyUpdateCount()
	 * @model default="0"
	 * @generated
	 */
	int getDependencyUpdateCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#getDependencyUpdateCount <em>Dependency Update Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependency Update Count</em>' attribute.
	 * @see #getDependencyUpdateCount()
	 * @generated
	 */
	void setDependencyUpdateCount(int value);

	/**
	 * Returns the value of the '<em><b>Activated</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activated</em>' attribute.
	 * @see #setActivated(boolean)
	 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage#getAllocationObject_Activated()
	 * @model default="true"
	 * @generated
	 */
	boolean isActivated();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#isActivated <em>Activated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activated</em>' attribute.
	 * @see #isActivated()
	 * @generated
	 */
	void setActivated(boolean value);

} // AllocationObject
