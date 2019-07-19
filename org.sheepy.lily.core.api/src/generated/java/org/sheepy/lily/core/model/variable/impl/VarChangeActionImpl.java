/**
 */
package org.sheepy.lily.core.model.variable.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.model.action.impl.ActionImpl;

import org.sheepy.lily.core.model.variable.AbstractVariableResolver;
import org.sheepy.lily.core.model.variable.VarChangeAction;
import org.sheepy.lily.core.model.variable.VariablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Change Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.impl.VarChangeActionImpl#getVariableResolver <em>Variable Resolver</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class VarChangeActionImpl extends ActionImpl implements VarChangeAction
{
	/**
	 * The cached value of the '{@link #getVariableResolver() <em>Variable Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableResolver()
	 * @generated
	 * @ordered
	 */
	protected AbstractVariableResolver variableResolver;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VarChangeActionImpl()
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
		return VariablePackage.Literals.VAR_CHANGE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractVariableResolver getVariableResolver()
	{
		return variableResolver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableResolver(	AbstractVariableResolver newVariableResolver,
														NotificationChain msgs)
	{
		AbstractVariableResolver oldVariableResolver = variableResolver;
		variableResolver = newVariableResolver;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VariablePackage.VAR_CHANGE_ACTION__VARIABLE_RESOLVER, oldVariableResolver, newVariableResolver);
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
	public void setVariableResolver(AbstractVariableResolver newVariableResolver)
	{
		if (newVariableResolver != variableResolver)
		{
			NotificationChain msgs = null;
			if (variableResolver != null)
				msgs = ((InternalEObject)variableResolver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VariablePackage.VAR_CHANGE_ACTION__VARIABLE_RESOLVER, null, msgs);
			if (newVariableResolver != null)
				msgs = ((InternalEObject)newVariableResolver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VariablePackage.VAR_CHANGE_ACTION__VARIABLE_RESOLVER, null, msgs);
			msgs = basicSetVariableResolver(newVariableResolver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariablePackage.VAR_CHANGE_ACTION__VARIABLE_RESOLVER, newVariableResolver, newVariableResolver));
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
			case VariablePackage.VAR_CHANGE_ACTION__VARIABLE_RESOLVER:
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
			case VariablePackage.VAR_CHANGE_ACTION__VARIABLE_RESOLVER:
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
			case VariablePackage.VAR_CHANGE_ACTION__VARIABLE_RESOLVER:
				setVariableResolver((AbstractVariableResolver)newValue);
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
			case VariablePackage.VAR_CHANGE_ACTION__VARIABLE_RESOLVER:
				setVariableResolver((AbstractVariableResolver)null);
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
			case VariablePackage.VAR_CHANGE_ACTION__VARIABLE_RESOLVER:
				return variableResolver != null;
		}
		return super.eIsSet(featureID);
	}

} //VarChangeActionImpl
