/**
 */
package org.sheepy.lily.core.allocation.test.testallocation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage;

import org.sheepy.lily.core.api.model.LilyEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Allocation Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.impl.AllocationObjectImpl#getCurrentAllocationCount <em>Current Allocation Count</em>}</li>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.impl.AllocationObjectImpl#getTotalAllocationCount <em>Total Allocation Count</em>}</li>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.impl.AllocationObjectImpl#getDependencyUpdateCount <em>Dependency Update Count</em>}</li>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.impl.AllocationObjectImpl#isActivated <em>Activated</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AllocationObjectImpl extends LilyEObject implements AllocationObject
{
	/**
	 * The default value of the '{@link #getCurrentAllocationCount() <em>Current Allocation Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentAllocationCount()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_ALLOCATION_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentAllocationCount() <em>Current Allocation Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentAllocationCount()
	 * @generated
	 * @ordered
	 */
	protected int currentAllocationCount = CURRENT_ALLOCATION_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalAllocationCount() <em>Total Allocation Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalAllocationCount()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_ALLOCATION_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTotalAllocationCount() <em>Total Allocation Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalAllocationCount()
	 * @generated
	 * @ordered
	 */
	protected int totalAllocationCount = TOTAL_ALLOCATION_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDependencyUpdateCount() <em>Dependency Update Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyUpdateCount()
	 * @generated
	 * @ordered
	 */
	protected static final int DEPENDENCY_UPDATE_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDependencyUpdateCount() <em>Dependency Update Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyUpdateCount()
	 * @generated
	 * @ordered
	 */
	protected int dependencyUpdateCount = DEPENDENCY_UPDATE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isActivated() <em>Activated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActivated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVATED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isActivated() <em>Activated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActivated()
	 * @generated
	 * @ordered
	 */
	protected boolean activated = ACTIVATED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocationObjectImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return TestallocationPackage.Literals.ALLOCATION_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCurrentAllocationCount()
	{
		return currentAllocationCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentAllocationCount(int newCurrentAllocationCount)
	{
		int oldCurrentAllocationCount = currentAllocationCount;
		currentAllocationCount = newCurrentAllocationCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestallocationPackage.ALLOCATION_OBJECT__CURRENT_ALLOCATION_COUNT, oldCurrentAllocationCount, currentAllocationCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTotalAllocationCount()
	{
		return totalAllocationCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalAllocationCount(int newTotalAllocationCount)
	{
		int oldTotalAllocationCount = totalAllocationCount;
		totalAllocationCount = newTotalAllocationCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestallocationPackage.ALLOCATION_OBJECT__TOTAL_ALLOCATION_COUNT, oldTotalAllocationCount, totalAllocationCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDependencyUpdateCount()
	{
		return dependencyUpdateCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDependencyUpdateCount(int newDependencyUpdateCount)
	{
		int oldDependencyUpdateCount = dependencyUpdateCount;
		dependencyUpdateCount = newDependencyUpdateCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestallocationPackage.ALLOCATION_OBJECT__DEPENDENCY_UPDATE_COUNT, oldDependencyUpdateCount, dependencyUpdateCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isActivated()
	{
		return activated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActivated(boolean newActivated)
	{
		boolean oldActivated = activated;
		activated = newActivated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestallocationPackage.ALLOCATION_OBJECT__ACTIVATED, oldActivated, activated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case TestallocationPackage.ALLOCATION_OBJECT__CURRENT_ALLOCATION_COUNT:
				return getCurrentAllocationCount();
			case TestallocationPackage.ALLOCATION_OBJECT__TOTAL_ALLOCATION_COUNT:
				return getTotalAllocationCount();
			case TestallocationPackage.ALLOCATION_OBJECT__DEPENDENCY_UPDATE_COUNT:
				return getDependencyUpdateCount();
			case TestallocationPackage.ALLOCATION_OBJECT__ACTIVATED:
				return isActivated();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case TestallocationPackage.ALLOCATION_OBJECT__CURRENT_ALLOCATION_COUNT:
				setCurrentAllocationCount((Integer)newValue);
				return;
			case TestallocationPackage.ALLOCATION_OBJECT__TOTAL_ALLOCATION_COUNT:
				setTotalAllocationCount((Integer)newValue);
				return;
			case TestallocationPackage.ALLOCATION_OBJECT__DEPENDENCY_UPDATE_COUNT:
				setDependencyUpdateCount((Integer)newValue);
				return;
			case TestallocationPackage.ALLOCATION_OBJECT__ACTIVATED:
				setActivated((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case TestallocationPackage.ALLOCATION_OBJECT__CURRENT_ALLOCATION_COUNT:
				setCurrentAllocationCount(CURRENT_ALLOCATION_COUNT_EDEFAULT);
				return;
			case TestallocationPackage.ALLOCATION_OBJECT__TOTAL_ALLOCATION_COUNT:
				setTotalAllocationCount(TOTAL_ALLOCATION_COUNT_EDEFAULT);
				return;
			case TestallocationPackage.ALLOCATION_OBJECT__DEPENDENCY_UPDATE_COUNT:
				setDependencyUpdateCount(DEPENDENCY_UPDATE_COUNT_EDEFAULT);
				return;
			case TestallocationPackage.ALLOCATION_OBJECT__ACTIVATED:
				setActivated(ACTIVATED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case TestallocationPackage.ALLOCATION_OBJECT__CURRENT_ALLOCATION_COUNT:
				return currentAllocationCount != CURRENT_ALLOCATION_COUNT_EDEFAULT;
			case TestallocationPackage.ALLOCATION_OBJECT__TOTAL_ALLOCATION_COUNT:
				return totalAllocationCount != TOTAL_ALLOCATION_COUNT_EDEFAULT;
			case TestallocationPackage.ALLOCATION_OBJECT__DEPENDENCY_UPDATE_COUNT:
				return dependencyUpdateCount != DEPENDENCY_UPDATE_COUNT_EDEFAULT;
			case TestallocationPackage.ALLOCATION_OBJECT__ACTIVATED:
				return activated != ACTIVATED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (currentAllocationCount: ");
		result.append(currentAllocationCount);
		result.append(", totalAllocationCount: ");
		result.append(totalAllocationCount);
		result.append(", dependencyUpdateCount: ");
		result.append(dependencyUpdateCount);
		result.append(", activated: ");
		result.append(activated);
		result.append(')');
		return result.toString();
	}

} //AllocationObjectImpl
