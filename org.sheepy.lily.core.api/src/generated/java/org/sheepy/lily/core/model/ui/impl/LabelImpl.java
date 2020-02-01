/**
 */
package org.sheepy.lily.core.model.ui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.model.ui.Label;
import org.sheepy.lily.core.model.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.LabelImpl#isWrap <em>Wrap</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.LabelImpl#isNarrator <em>Narrator</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.LabelImpl#getNarrationSpeed <em>Narration Speed</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LabelImpl extends AbstractLabelImpl implements Label
{
	/**
	 * The default value of the '{@link #isWrap() <em>Wrap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWrap()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WRAP_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isWrap() <em>Wrap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWrap()
	 * @generated
	 * @ordered
	 */
	protected boolean wrap = WRAP_EDEFAULT;

	/**
	 * The default value of the '{@link #isNarrator() <em>Narrator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNarrator()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NARRATOR_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isNarrator() <em>Narrator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNarrator()
	 * @generated
	 * @ordered
	 */
	protected boolean narrator = NARRATOR_EDEFAULT;
	/**
	 * The default value of the '{@link #getNarrationSpeed() <em>Narration Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNarrationSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final int NARRATION_SPEED_EDEFAULT = 100;
	/**
	 * The cached value of the '{@link #getNarrationSpeed() <em>Narration Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNarrationSpeed()
	 * @generated
	 * @ordered
	 */
	protected int narrationSpeed = NARRATION_SPEED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabelImpl()
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
		return UiPackage.Literals.LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isWrap()
	{
		return wrap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWrap(boolean newWrap)
	{
		boolean oldWrap = wrap;
		wrap = newWrap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.LABEL__WRAP, oldWrap, wrap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNarrator()
	{
		return narrator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNarrator(boolean newNarrator)
	{
		boolean oldNarrator = narrator;
		narrator = newNarrator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.LABEL__NARRATOR, oldNarrator, narrator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNarrationSpeed()
	{
		return narrationSpeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNarrationSpeed(int newNarrationSpeed)
	{
		int oldNarrationSpeed = narrationSpeed;
		narrationSpeed = newNarrationSpeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.LABEL__NARRATION_SPEED, oldNarrationSpeed, narrationSpeed));
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
			case UiPackage.LABEL__WRAP:
				return isWrap();
			case UiPackage.LABEL__NARRATOR:
				return isNarrator();
			case UiPackage.LABEL__NARRATION_SPEED:
				return getNarrationSpeed();
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
			case UiPackage.LABEL__WRAP:
				setWrap((Boolean)newValue);
				return;
			case UiPackage.LABEL__NARRATOR:
				setNarrator((Boolean)newValue);
				return;
			case UiPackage.LABEL__NARRATION_SPEED:
				setNarrationSpeed((Integer)newValue);
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
			case UiPackage.LABEL__WRAP:
				setWrap(WRAP_EDEFAULT);
				return;
			case UiPackage.LABEL__NARRATOR:
				setNarrator(NARRATOR_EDEFAULT);
				return;
			case UiPackage.LABEL__NARRATION_SPEED:
				setNarrationSpeed(NARRATION_SPEED_EDEFAULT);
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
			case UiPackage.LABEL__WRAP:
				return wrap != WRAP_EDEFAULT;
			case UiPackage.LABEL__NARRATOR:
				return narrator != NARRATOR_EDEFAULT;
			case UiPackage.LABEL__NARRATION_SPEED:
				return narrationSpeed != NARRATION_SPEED_EDEFAULT;
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
		result.append(" (wrap: ");
		result.append(wrap);
		result.append(", narrator: ");
		result.append(narrator);
		result.append(", narrationSpeed: ");
		result.append(narrationSpeed);
		result.append(')');
		return result.toString();
	}

} //LabelImpl
