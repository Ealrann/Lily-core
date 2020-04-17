/**
 */
package org.sheepy.lily.core.model.application.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.TimeConfiguration;

import org.sheepy.lily.core.model.types.ETimeUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.TimeConfigurationImpl#getTimeStep <em>Time Step</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.TimeConfigurationImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.TimeConfigurationImpl#getTimeFactor <em>Time Factor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeConfigurationImpl extends LilyEObject implements TimeConfiguration
{
	/**
	 * The default value of the '{@link #getTimeStep() <em>Time Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeStep()
	 * @generated
	 * @ordered
	 */
	protected static final long TIME_STEP_EDEFAULT = 1L;

	/**
	 * The cached value of the '{@link #getTimeStep() <em>Time Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeStep()
	 * @generated
	 * @ordered
	 */
	protected long timeStep = TIME_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected static final ETimeUnit UNIT_EDEFAULT = ETimeUnit.SECONDS;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected ETimeUnit unit = UNIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeFactor() <em>Time Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeFactor()
	 * @generated
	 * @ordered
	 */
	protected static final double TIME_FACTOR_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getTimeFactor() <em>Time Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeFactor()
	 * @generated
	 * @ordered
	 */
	protected double timeFactor = TIME_FACTOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeConfigurationImpl()
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
		return ApplicationPackage.Literals.TIME_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getTimeStep()
	{
		return timeStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeStep(long newTimeStep)
	{
		long oldTimeStep = timeStep;
		timeStep = newTimeStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.TIME_CONFIGURATION__TIME_STEP, oldTimeStep, timeStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ETimeUnit getUnit()
	{
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnit(ETimeUnit newUnit)
	{
		ETimeUnit oldUnit = unit;
		unit = newUnit == null ? UNIT_EDEFAULT : newUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.TIME_CONFIGURATION__UNIT, oldUnit, unit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTimeFactor()
	{
		return timeFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeFactor(double newTimeFactor)
	{
		double oldTimeFactor = timeFactor;
		timeFactor = newTimeFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.TIME_CONFIGURATION__TIME_FACTOR, oldTimeFactor, timeFactor));
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
			case ApplicationPackage.TIME_CONFIGURATION__TIME_STEP:
				return getTimeStep();
			case ApplicationPackage.TIME_CONFIGURATION__UNIT:
				return getUnit();
			case ApplicationPackage.TIME_CONFIGURATION__TIME_FACTOR:
				return getTimeFactor();
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
			case ApplicationPackage.TIME_CONFIGURATION__TIME_STEP:
				setTimeStep((Long)newValue);
				return;
			case ApplicationPackage.TIME_CONFIGURATION__UNIT:
				setUnit((ETimeUnit)newValue);
				return;
			case ApplicationPackage.TIME_CONFIGURATION__TIME_FACTOR:
				setTimeFactor((Double)newValue);
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
			case ApplicationPackage.TIME_CONFIGURATION__TIME_STEP:
				setTimeStep(TIME_STEP_EDEFAULT);
				return;
			case ApplicationPackage.TIME_CONFIGURATION__UNIT:
				setUnit(UNIT_EDEFAULT);
				return;
			case ApplicationPackage.TIME_CONFIGURATION__TIME_FACTOR:
				setTimeFactor(TIME_FACTOR_EDEFAULT);
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
			case ApplicationPackage.TIME_CONFIGURATION__TIME_STEP:
				return timeStep != TIME_STEP_EDEFAULT;
			case ApplicationPackage.TIME_CONFIGURATION__UNIT:
				return unit != UNIT_EDEFAULT;
			case ApplicationPackage.TIME_CONFIGURATION__TIME_FACTOR:
				return timeFactor != TIME_FACTOR_EDEFAULT;
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
		result.append(" (timeStep: ");
		result.append(timeStep);
		result.append(", unit: ");
		result.append(unit);
		result.append(", timeFactor: ");
		result.append(timeFactor);
		result.append(')');
		return result.toString();
	}

} //TimeConfigurationImpl
