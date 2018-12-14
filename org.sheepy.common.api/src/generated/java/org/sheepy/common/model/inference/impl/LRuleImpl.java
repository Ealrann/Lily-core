/**
 */
package org.sheepy.common.model.inference.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.common.model.action.Action;

import org.sheepy.common.model.inference.AbstractNotification;
import org.sheepy.common.model.inference.Condition;
import org.sheepy.common.model.inference.InferencePackage;
import org.sheepy.common.model.inference.LRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LRule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.inference.impl.LRuleImpl#getNotification <em>Notification</em>}</li>
 *   <li>{@link org.sheepy.common.model.inference.impl.LRuleImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.sheepy.common.model.inference.impl.LRuleImpl#getConditions <em>Conditions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LRuleImpl extends MinimalEObjectImpl.Container implements LRule
{
	/**
	 * The cached value of the '{@link #getNotification() <em>Notification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotification()
	 * @generated
	 * @ordered
	 */
	protected AbstractNotification notification;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

	/**
	 * The cached value of the '{@link #getConditions() <em>Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<Condition<?>> conditions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LRuleImpl()
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
		return InferencePackage.Literals.LRULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNotification getNotification()
	{
		return notification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNotification(AbstractNotification newNotification, NotificationChain msgs)
	{
		AbstractNotification oldNotification = notification;
		notification = newNotification;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InferencePackage.LRULE__NOTIFICATION, oldNotification, newNotification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotification(AbstractNotification newNotification)
	{
		if (newNotification != notification)
		{
			NotificationChain msgs = null;
			if (notification != null)
				msgs = ((InternalEObject)notification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InferencePackage.LRULE__NOTIFICATION, null, msgs);
			if (newNotification != null)
				msgs = ((InternalEObject)newNotification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InferencePackage.LRULE__NOTIFICATION, null, msgs);
			msgs = basicSetNotification(newNotification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InferencePackage.LRULE__NOTIFICATION, newNotification, newNotification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction()
	{
		if (action != null && action.eIsProxy())
		{
			InternalEObject oldAction = (InternalEObject)action;
			action = (Action)eResolveProxy(oldAction);
			if (action != oldAction)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InferencePackage.LRULE__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetAction()
	{
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction)
	{
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InferencePackage.LRULE__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Condition<?>> getConditions()
	{
		if (conditions == null)
		{
			conditions = new EObjectContainmentEList<Condition<?>>(Condition.class, this, InferencePackage.LRULE__CONDITIONS);
		}
		return conditions;
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
			case InferencePackage.LRULE__NOTIFICATION:
				return basicSetNotification(null, msgs);
			case InferencePackage.LRULE__CONDITIONS:
				return ((InternalEList<?>)getConditions()).basicRemove(otherEnd, msgs);
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
			case InferencePackage.LRULE__NOTIFICATION:
				return getNotification();
			case InferencePackage.LRULE__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case InferencePackage.LRULE__CONDITIONS:
				return getConditions();
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
			case InferencePackage.LRULE__NOTIFICATION:
				setNotification((AbstractNotification)newValue);
				return;
			case InferencePackage.LRULE__ACTION:
				setAction((Action)newValue);
				return;
			case InferencePackage.LRULE__CONDITIONS:
				getConditions().clear();
				getConditions().addAll((Collection<? extends Condition<?>>)newValue);
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
			case InferencePackage.LRULE__NOTIFICATION:
				setNotification((AbstractNotification)null);
				return;
			case InferencePackage.LRULE__ACTION:
				setAction((Action)null);
				return;
			case InferencePackage.LRULE__CONDITIONS:
				getConditions().clear();
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
			case InferencePackage.LRULE__NOTIFICATION:
				return notification != null;
			case InferencePackage.LRULE__ACTION:
				return action != null;
			case InferencePackage.LRULE__CONDITIONS:
				return conditions != null && !conditions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LRuleImpl
