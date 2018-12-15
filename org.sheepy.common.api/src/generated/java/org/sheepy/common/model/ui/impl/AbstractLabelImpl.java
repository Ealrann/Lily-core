/**
 */
package org.sheepy.common.model.ui.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.common.model.presentation.impl.ControlImpl;

import org.sheepy.common.model.ui.AbstractLabel;
import org.sheepy.common.model.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.ui.impl.AbstractLabelImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.impl.AbstractLabelImpl#getFontScale <em>Font Scale</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractLabelImpl extends ControlImpl implements AbstractLabel
{
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFontScale() <em>Font Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontScale()
	 * @generated
	 * @ordered
	 */
	protected static final float FONT_SCALE_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getFontScale() <em>Font Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontScale()
	 * @generated
	 * @ordered
	 */
	protected float fontScale = FONT_SCALE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractLabelImpl()
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
		return UiPackage.Literals.ABSTRACT_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText)
	{
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.ABSTRACT_LABEL__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFontScale()
	{
		return fontScale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontScale(float newFontScale)
	{
		float oldFontScale = fontScale;
		fontScale = newFontScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.ABSTRACT_LABEL__FONT_SCALE, oldFontScale, fontScale));
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
			case UiPackage.ABSTRACT_LABEL__TEXT:
				return getText();
			case UiPackage.ABSTRACT_LABEL__FONT_SCALE:
				return getFontScale();
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
			case UiPackage.ABSTRACT_LABEL__TEXT:
				setText((String)newValue);
				return;
			case UiPackage.ABSTRACT_LABEL__FONT_SCALE:
				setFontScale((Float)newValue);
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
			case UiPackage.ABSTRACT_LABEL__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case UiPackage.ABSTRACT_LABEL__FONT_SCALE:
				setFontScale(FONT_SCALE_EDEFAULT);
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
			case UiPackage.ABSTRACT_LABEL__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case UiPackage.ABSTRACT_LABEL__FONT_SCALE:
				return fontScale != FONT_SCALE_EDEFAULT;
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
		result.append(" (text: ");
		result.append(text);
		result.append(", fontScale: ");
		result.append(fontScale);
		result.append(')');
		return result.toString();
	}

} //AbstractLabelImpl
