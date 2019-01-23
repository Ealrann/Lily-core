/**
 */
package org.sheepy.lily.core.model.ui.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.model.ui.AbstractBooleanButton;
import org.sheepy.lily.core.model.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Boolean Button</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.AbstractBooleanButtonImpl#getTextWhenTrue <em>Text When True</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.AbstractBooleanButtonImpl#getTextWhenFalse <em>Text When False</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractBooleanButtonImpl extends AbstractButtonImpl implements AbstractBooleanButton
{
	/**
	 * The default value of the '{@link #getTextWhenTrue() <em>Text When True</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextWhenTrue()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_WHEN_TRUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextWhenTrue() <em>Text When True</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextWhenTrue()
	 * @generated
	 * @ordered
	 */
	protected String textWhenTrue = TEXT_WHEN_TRUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTextWhenFalse() <em>Text When False</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextWhenFalse()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_WHEN_FALSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextWhenFalse() <em>Text When False</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextWhenFalse()
	 * @generated
	 * @ordered
	 */
	protected String textWhenFalse = TEXT_WHEN_FALSE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractBooleanButtonImpl()
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
		return UiPackage.Literals.ABSTRACT_BOOLEAN_BUTTON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTextWhenTrue()
	{
		return textWhenTrue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTextWhenTrue(String newTextWhenTrue)
	{
		String oldTextWhenTrue = textWhenTrue;
		textWhenTrue = newTextWhenTrue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_TRUE, oldTextWhenTrue, textWhenTrue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTextWhenFalse()
	{
		return textWhenFalse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTextWhenFalse(String newTextWhenFalse)
	{
		String oldTextWhenFalse = textWhenFalse;
		textWhenFalse = newTextWhenFalse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_FALSE, oldTextWhenFalse, textWhenFalse));
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
			case UiPackage.ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_TRUE:
				return getTextWhenTrue();
			case UiPackage.ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_FALSE:
				return getTextWhenFalse();
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
			case UiPackage.ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_TRUE:
				setTextWhenTrue((String)newValue);
				return;
			case UiPackage.ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_FALSE:
				setTextWhenFalse((String)newValue);
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
			case UiPackage.ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_TRUE:
				setTextWhenTrue(TEXT_WHEN_TRUE_EDEFAULT);
				return;
			case UiPackage.ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_FALSE:
				setTextWhenFalse(TEXT_WHEN_FALSE_EDEFAULT);
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
			case UiPackage.ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_TRUE:
				return TEXT_WHEN_TRUE_EDEFAULT == null ? textWhenTrue != null : !TEXT_WHEN_TRUE_EDEFAULT.equals(textWhenTrue);
			case UiPackage.ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_FALSE:
				return TEXT_WHEN_FALSE_EDEFAULT == null ? textWhenFalse != null : !TEXT_WHEN_FALSE_EDEFAULT.equals(textWhenFalse);
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
		result.append(" (textWhenTrue: ");
		result.append(textWhenTrue);
		result.append(", textWhenFalse: ");
		result.append(textWhenFalse);
		result.append(')');
		return result.toString();
	}

} //AbstractBooleanButtonImpl
