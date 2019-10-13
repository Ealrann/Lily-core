/**
 */
package org.sheepy.lily.core.model.cadence.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.cadence.CountUntil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Count Until</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.cadence.impl.CountUntilImpl#getTotalCount <em>Total Count</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.cadence.impl.CountUntilImpl#getCurrentCount <em>Current Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CountUntilImpl extends LilyEObject implements CountUntil
{
	/**
	 * The default value of the '{@link #getTotalCount() <em>Total Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalCount()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getTotalCount() <em>Total Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalCount()
	 * @generated
	 * @ordered
	 */
	protected int totalCount = TOTAL_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentCount() <em>Current Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentCount()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentCount() <em>Current Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentCount()
	 * @generated
	 * @ordered
	 */
	protected int currentCount = CURRENT_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CountUntilImpl()
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
		return CadencePackage.Literals.COUNT_UNTIL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTotalCount()
	{
		return totalCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalCount(int newTotalCount)
	{
		int oldTotalCount = totalCount;
		totalCount = newTotalCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CadencePackage.COUNT_UNTIL__TOTAL_COUNT, oldTotalCount, totalCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCurrentCount()
	{
		return currentCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentCount(int newCurrentCount)
	{
		int oldCurrentCount = currentCount;
		currentCount = newCurrentCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CadencePackage.COUNT_UNTIL__CURRENT_COUNT, oldCurrentCount, currentCount));
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
			case CadencePackage.COUNT_UNTIL__TOTAL_COUNT:
				return getTotalCount();
			case CadencePackage.COUNT_UNTIL__CURRENT_COUNT:
				return getCurrentCount();
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
			case CadencePackage.COUNT_UNTIL__TOTAL_COUNT:
				setTotalCount((Integer)newValue);
				return;
			case CadencePackage.COUNT_UNTIL__CURRENT_COUNT:
				setCurrentCount((Integer)newValue);
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
			case CadencePackage.COUNT_UNTIL__TOTAL_COUNT:
				setTotalCount(TOTAL_COUNT_EDEFAULT);
				return;
			case CadencePackage.COUNT_UNTIL__CURRENT_COUNT:
				setCurrentCount(CURRENT_COUNT_EDEFAULT);
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
			case CadencePackage.COUNT_UNTIL__TOTAL_COUNT:
				return totalCount != TOTAL_COUNT_EDEFAULT;
			case CadencePackage.COUNT_UNTIL__CURRENT_COUNT:
				return currentCount != CURRENT_COUNT_EDEFAULT;
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
		result.append(" (totalCount: ");
		result.append(totalCount);
		result.append(", currentCount: ");
		result.append(currentCount);
		result.append(')');
		return result.toString();
	}

} //CountUntilImpl
