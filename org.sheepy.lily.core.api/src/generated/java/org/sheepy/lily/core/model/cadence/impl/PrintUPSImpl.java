/**
 */
package org.sheepy.lily.core.model.cadence.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.cadence.PrintUPS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Print UPS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.cadence.impl.PrintUPSImpl#getPrintEveryMs <em>Print Every Ms</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrintUPSImpl extends LilyEObject implements PrintUPS
{
	/**
	 * The default value of the '{@link #getPrintEveryMs() <em>Print Every Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrintEveryMs()
	 * @generated
	 * @ordered
	 */
	protected static final int PRINT_EVERY_MS_EDEFAULT = 2000;
	/**
	 * The cached value of the '{@link #getPrintEveryMs() <em>Print Every Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrintEveryMs()
	 * @generated
	 * @ordered
	 */
	protected int printEveryMs = PRINT_EVERY_MS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrintUPSImpl()
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
		return CadencePackage.Literals.PRINT_UPS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPrintEveryMs()
	{
		return printEveryMs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrintEveryMs(int newPrintEveryMs)
	{
		int oldPrintEveryMs = printEveryMs;
		printEveryMs = newPrintEveryMs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CadencePackage.PRINT_UPS__PRINT_EVERY_MS, oldPrintEveryMs, printEveryMs));
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
			case CadencePackage.PRINT_UPS__PRINT_EVERY_MS:
				return getPrintEveryMs();
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
			case CadencePackage.PRINT_UPS__PRINT_EVERY_MS:
				setPrintEveryMs((Integer)newValue);
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
			case CadencePackage.PRINT_UPS__PRINT_EVERY_MS:
				setPrintEveryMs(PRINT_EVERY_MS_EDEFAULT);
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
			case CadencePackage.PRINT_UPS__PRINT_EVERY_MS:
				return printEveryMs != PRINT_EVERY_MS_EDEFAULT;
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
		result.append(" (printEveryMs: ");
		result.append(printEveryMs);
		result.append(')');
		return result.toString();
	}

} //PrintUPSImpl
