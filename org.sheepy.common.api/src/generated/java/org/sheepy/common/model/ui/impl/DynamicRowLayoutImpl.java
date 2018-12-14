/**
 */
package org.sheepy.common.model.ui.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.common.model.presentation.impl.ControlImpl;

import org.sheepy.common.model.ui.DynamicRowLayout;
import org.sheepy.common.model.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Row Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.ui.impl.DynamicRowLayoutImpl#getColumnCount <em>Column Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DynamicRowLayoutImpl extends ControlImpl implements DynamicRowLayout
{
	/**
	 * The default value of the '{@link #getColumnCount() <em>Column Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnCount()
	 * @generated
	 * @ordered
	 */
	protected static final int COLUMN_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColumnCount() <em>Column Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnCount()
	 * @generated
	 * @ordered
	 */
	protected int columnCount = COLUMN_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicRowLayoutImpl()
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
		return UiPackage.Literals.DYNAMIC_ROW_LAYOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColumnCount()
	{
		return columnCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumnCount(int newColumnCount)
	{
		int oldColumnCount = columnCount;
		columnCount = newColumnCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DYNAMIC_ROW_LAYOUT__COLUMN_COUNT, oldColumnCount, columnCount));
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
			case UiPackage.DYNAMIC_ROW_LAYOUT__COLUMN_COUNT:
				return getColumnCount();
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
			case UiPackage.DYNAMIC_ROW_LAYOUT__COLUMN_COUNT:
				setColumnCount((Integer)newValue);
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
			case UiPackage.DYNAMIC_ROW_LAYOUT__COLUMN_COUNT:
				setColumnCount(COLUMN_COUNT_EDEFAULT);
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
			case UiPackage.DYNAMIC_ROW_LAYOUT__COLUMN_COUNT:
				return columnCount != COLUMN_COUNT_EDEFAULT;
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
		result.append(" (columnCount: ");
		result.append(columnCount);
		result.append(')');
		return result.toString();
	}

} //DynamicRowLayoutImpl
