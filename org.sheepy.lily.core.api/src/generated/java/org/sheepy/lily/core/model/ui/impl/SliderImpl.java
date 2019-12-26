/**
 */
package org.sheepy.lily.core.model.ui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.model.ui.Slider;
import org.sheepy.lily.core.model.ui.UiPackage;

import org.sheepy.lily.core.model.variable.IVariableResolver;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getStep <em>Step</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getVariableResolver <em>Variable Resolver</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SliderImpl extends TextWidgetImpl implements Slider
{
	/**
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected int minValue = MIN_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_VALUE_EDEFAULT = 10;

	/**
	 * The cached value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected int maxValue = MAX_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected int step = STEP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariableResolver() <em>Variable Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableResolver()
	 * @generated
	 * @ordered
	 */
	protected IVariableResolver variableResolver;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SliderImpl()
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
		return UiPackage.Literals.SLIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMinValue()
	{
		return minValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinValue(int newMinValue)
	{
		int oldMinValue = minValue;
		minValue = newMinValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.SLIDER__MIN_VALUE, oldMinValue, minValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMaxValue()
	{
		return maxValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxValue(int newMaxValue)
	{
		int oldMaxValue = maxValue;
		maxValue = newMaxValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.SLIDER__MAX_VALUE, oldMaxValue, maxValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getStep()
	{
		return step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStep(int newStep)
	{
		int oldStep = step;
		step = newStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.SLIDER__STEP, oldStep, step));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IVariableResolver getVariableResolver()
	{
		return variableResolver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableResolver(IVariableResolver newVariableResolver, NotificationChain msgs)
	{
		IVariableResolver oldVariableResolver = variableResolver;
		variableResolver = newVariableResolver;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.SLIDER__VARIABLE_RESOLVER, oldVariableResolver, newVariableResolver);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariableResolver(IVariableResolver newVariableResolver)
	{
		if (newVariableResolver != variableResolver)
		{
			NotificationChain msgs = null;
			if (variableResolver != null)
				msgs = ((InternalEObject)variableResolver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.SLIDER__VARIABLE_RESOLVER, null, msgs);
			if (newVariableResolver != null)
				msgs = ((InternalEObject)newVariableResolver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.SLIDER__VARIABLE_RESOLVER, null, msgs);
			msgs = basicSetVariableResolver(newVariableResolver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.SLIDER__VARIABLE_RESOLVER, newVariableResolver, newVariableResolver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case UiPackage.SLIDER__VARIABLE_RESOLVER:
				return basicSetVariableResolver(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case UiPackage.SLIDER__MIN_VALUE:
				return getMinValue();
			case UiPackage.SLIDER__MAX_VALUE:
				return getMaxValue();
			case UiPackage.SLIDER__STEP:
				return getStep();
			case UiPackage.SLIDER__VARIABLE_RESOLVER:
				return getVariableResolver();
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
			case UiPackage.SLIDER__MIN_VALUE:
				setMinValue((Integer)newValue);
				return;
			case UiPackage.SLIDER__MAX_VALUE:
				setMaxValue((Integer)newValue);
				return;
			case UiPackage.SLIDER__STEP:
				setStep((Integer)newValue);
				return;
			case UiPackage.SLIDER__VARIABLE_RESOLVER:
				setVariableResolver((IVariableResolver)newValue);
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
			case UiPackage.SLIDER__MIN_VALUE:
				setMinValue(MIN_VALUE_EDEFAULT);
				return;
			case UiPackage.SLIDER__MAX_VALUE:
				setMaxValue(MAX_VALUE_EDEFAULT);
				return;
			case UiPackage.SLIDER__STEP:
				setStep(STEP_EDEFAULT);
				return;
			case UiPackage.SLIDER__VARIABLE_RESOLVER:
				setVariableResolver((IVariableResolver)null);
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
			case UiPackage.SLIDER__MIN_VALUE:
				return minValue != MIN_VALUE_EDEFAULT;
			case UiPackage.SLIDER__MAX_VALUE:
				return maxValue != MAX_VALUE_EDEFAULT;
			case UiPackage.SLIDER__STEP:
				return step != STEP_EDEFAULT;
			case UiPackage.SLIDER__VARIABLE_RESOLVER:
				return variableResolver != null;
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
		result.append(" (minValue: ");
		result.append(minValue);
		result.append(", maxValue: ");
		result.append(maxValue);
		result.append(", step: ");
		result.append(step);
		result.append(')');
		return result.toString();
	}

} //SliderImpl
