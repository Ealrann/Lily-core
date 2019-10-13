/**
 */
package org.sheepy.lily.core.model.cadence.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CadencePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cadence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.cadence.impl.CadenceImpl#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.cadence.impl.CadenceImpl#isPrintUPS <em>Print UPS</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CadenceImpl extends CadenceTaskPkgImpl implements Cadence
{
	/**
	 * The default value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrequency()
	 * @generated
	 * @ordered
	 */
	protected static final int FREQUENCY_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrequency()
	 * @generated
	 * @ordered
	 */
	protected int frequency = FREQUENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #isPrintUPS() <em>Print UPS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrintUPS()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRINT_UPS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrintUPS() <em>Print UPS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrintUPS()
	 * @generated
	 * @ordered
	 */
	protected boolean printUPS = PRINT_UPS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CadenceImpl()
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
		return CadencePackage.Literals.CADENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFrequency()
	{
		return frequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrequency(int newFrequency)
	{
		int oldFrequency = frequency;
		frequency = newFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CadencePackage.CADENCE__FREQUENCY, oldFrequency, frequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPrintUPS()
	{
		return printUPS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrintUPS(boolean newPrintUPS)
	{
		boolean oldPrintUPS = printUPS;
		printUPS = newPrintUPS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CadencePackage.CADENCE__PRINT_UPS, oldPrintUPS, printUPS));
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
			case CadencePackage.CADENCE__FREQUENCY:
				return getFrequency();
			case CadencePackage.CADENCE__PRINT_UPS:
				return isPrintUPS();
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
			case CadencePackage.CADENCE__FREQUENCY:
				setFrequency((Integer)newValue);
				return;
			case CadencePackage.CADENCE__PRINT_UPS:
				setPrintUPS((Boolean)newValue);
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
			case CadencePackage.CADENCE__FREQUENCY:
				setFrequency(FREQUENCY_EDEFAULT);
				return;
			case CadencePackage.CADENCE__PRINT_UPS:
				setPrintUPS(PRINT_UPS_EDEFAULT);
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
			case CadencePackage.CADENCE__FREQUENCY:
				return frequency != FREQUENCY_EDEFAULT;
			case CadencePackage.CADENCE__PRINT_UPS:
				return printUPS != PRINT_UPS_EDEFAULT;
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
		result.append(" (frequency: ");
		result.append(frequency);
		result.append(", printUPS: ");
		result.append(printUPS);
		result.append(')');
		return result.toString();
	}

} //CadenceImpl
