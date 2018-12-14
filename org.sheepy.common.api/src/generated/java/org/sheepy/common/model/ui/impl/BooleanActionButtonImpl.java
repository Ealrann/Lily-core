/**
 */
package org.sheepy.common.model.ui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.common.model.action.Action;

import org.sheepy.common.model.ui.BooleanActionButton;
import org.sheepy.common.model.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Action Button</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.ui.impl.BooleanActionButtonImpl#getActionWhenTrue <em>Action When True</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.impl.BooleanActionButtonImpl#getActionWhenFalse <em>Action When False</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanActionButtonImpl extends AbstractBooleanButtonImpl implements BooleanActionButton
{
	/**
	 * The cached value of the '{@link #getActionWhenTrue() <em>Action When True</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionWhenTrue()
	 * @generated
	 * @ordered
	 */
	protected Action actionWhenTrue;

	/**
	 * The cached value of the '{@link #getActionWhenFalse() <em>Action When False</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionWhenFalse()
	 * @generated
	 * @ordered
	 */
	protected Action actionWhenFalse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanActionButtonImpl()
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
		return UiPackage.Literals.BOOLEAN_ACTION_BUTTON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getActionWhenTrue()
	{
		return actionWhenTrue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActionWhenTrue(Action newActionWhenTrue, NotificationChain msgs)
	{
		Action oldActionWhenTrue = actionWhenTrue;
		actionWhenTrue = newActionWhenTrue;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_TRUE, oldActionWhenTrue, newActionWhenTrue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionWhenTrue(Action newActionWhenTrue)
	{
		if (newActionWhenTrue != actionWhenTrue)
		{
			NotificationChain msgs = null;
			if (actionWhenTrue != null)
				msgs = ((InternalEObject)actionWhenTrue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_TRUE, null, msgs);
			if (newActionWhenTrue != null)
				msgs = ((InternalEObject)newActionWhenTrue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_TRUE, null, msgs);
			msgs = basicSetActionWhenTrue(newActionWhenTrue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_TRUE, newActionWhenTrue, newActionWhenTrue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getActionWhenFalse()
	{
		return actionWhenFalse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActionWhenFalse(Action newActionWhenFalse, NotificationChain msgs)
	{
		Action oldActionWhenFalse = actionWhenFalse;
		actionWhenFalse = newActionWhenFalse;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_FALSE, oldActionWhenFalse, newActionWhenFalse);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionWhenFalse(Action newActionWhenFalse)
	{
		if (newActionWhenFalse != actionWhenFalse)
		{
			NotificationChain msgs = null;
			if (actionWhenFalse != null)
				msgs = ((InternalEObject)actionWhenFalse).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_FALSE, null, msgs);
			if (newActionWhenFalse != null)
				msgs = ((InternalEObject)newActionWhenFalse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_FALSE, null, msgs);
			msgs = basicSetActionWhenFalse(newActionWhenFalse, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_FALSE, newActionWhenFalse, newActionWhenFalse));
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
			case UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_TRUE:
				return basicSetActionWhenTrue(null, msgs);
			case UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_FALSE:
				return basicSetActionWhenFalse(null, msgs);
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
			case UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_TRUE:
				return getActionWhenTrue();
			case UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_FALSE:
				return getActionWhenFalse();
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
			case UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_TRUE:
				setActionWhenTrue((Action)newValue);
				return;
			case UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_FALSE:
				setActionWhenFalse((Action)newValue);
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
			case UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_TRUE:
				setActionWhenTrue((Action)null);
				return;
			case UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_FALSE:
				setActionWhenFalse((Action)null);
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
			case UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_TRUE:
				return actionWhenTrue != null;
			case UiPackage.BOOLEAN_ACTION_BUTTON__ACTION_WHEN_FALSE:
				return actionWhenFalse != null;
		}
		return super.eIsSet(featureID);
	}

} //BooleanActionButtonImpl
