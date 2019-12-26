/**
 */
package org.sheepy.lily.core.model.ui.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.model.action.Action;

import org.sheepy.lily.core.model.application.IScenePart;
import org.sheepy.lily.core.model.inference.IInferenceObject;

import org.sheepy.lily.core.model.types.EKeyState;

import org.sheepy.lily.core.model.ui.Button;
import org.sheepy.lily.core.model.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Button</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.ButtonImpl#getShortcut <em>Shortcut</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.ButtonImpl#getState <em>State</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.ButtonImpl#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ButtonImpl extends AbstractButtonImpl implements Button
{
	/**
	 * The default value of the '{@link #getShortcut() <em>Shortcut</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortcut()
	 * @generated
	 * @ordered
	 */
	protected static final int SHORTCUT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getShortcut() <em>Shortcut</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortcut()
	 * @generated
	 * @ordered
	 */
	protected int shortcut = SHORTCUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final EKeyState STATE_EDEFAULT = EKeyState.RELEASED;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected EKeyState state = STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ButtonImpl()
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
		return UiPackage.Literals.BUTTON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getShortcut()
	{
		return shortcut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShortcut(int newShortcut)
	{
		int oldShortcut = shortcut;
		shortcut = newShortcut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.BUTTON__SHORTCUT, oldShortcut, shortcut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EKeyState getState()
	{
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setState(EKeyState newState)
	{
		EKeyState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.BUTTON__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Action> getActions()
	{
		if (actions == null)
		{
			actions = new EObjectContainmentEList<Action>(Action.class, this, UiPackage.BUTTON__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<? extends Action> lActions()
	{
		return this.getActions();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IInferenceObject getExecutor()
	{
		EObject unit = this;
		while (((unit instanceof IScenePart) == false))
		{
			unit = unit.eContainer();
		}
		return (org.sheepy.lily.core.model.ui.UI) unit;
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
			case UiPackage.BUTTON__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
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
			case UiPackage.BUTTON__SHORTCUT:
				return getShortcut();
			case UiPackage.BUTTON__STATE:
				return getState();
			case UiPackage.BUTTON__ACTIONS:
				return getActions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case UiPackage.BUTTON__SHORTCUT:
				setShortcut((Integer)newValue);
				return;
			case UiPackage.BUTTON__STATE:
				setState((EKeyState)newValue);
				return;
			case UiPackage.BUTTON__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
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
			case UiPackage.BUTTON__SHORTCUT:
				setShortcut(SHORTCUT_EDEFAULT);
				return;
			case UiPackage.BUTTON__STATE:
				setState(STATE_EDEFAULT);
				return;
			case UiPackage.BUTTON__ACTIONS:
				getActions().clear();
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
			case UiPackage.BUTTON__SHORTCUT:
				return shortcut != SHORTCUT_EDEFAULT;
			case UiPackage.BUTTON__STATE:
				return state != STATE_EDEFAULT;
			case UiPackage.BUTTON__ACTIONS:
				return actions != null && !actions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case UiPackage.BUTTON___LACTIONS:
				return lActions();
			case UiPackage.BUTTON___GET_EXECUTOR:
				return getExecutor();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (shortcut: ");
		result.append(shortcut);
		result.append(", state: ");
		result.append(state);
		result.append(')');
		return result.toString();
	}

} //ButtonImpl
