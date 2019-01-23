/**
 */
package org.sheepy.lily.core.model.variable.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.core.model.variable.VariablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Direct Variable Resolver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.impl.DirectVariableResolverImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DirectVariableResolverImpl extends AbstractVariableResolverImpl implements DirectVariableResolver
{
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EObject target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectVariableResolverImpl()
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
		return VariablePackage.Literals.DIRECT_VARIABLE_RESOLVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getTarget()
	{
		if (target != null && target.eIsProxy())
		{
			InternalEObject oldTarget = (InternalEObject)target;
			target = eResolveProxy(oldTarget);
			if (target != oldTarget)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariablePackage.DIRECT_VARIABLE_RESOLVER__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTarget()
	{
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(EObject newTarget)
	{
		EObject oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariablePackage.DIRECT_VARIABLE_RESOLVER__TARGET, oldTarget, target));
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
			case VariablePackage.DIRECT_VARIABLE_RESOLVER__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case VariablePackage.DIRECT_VARIABLE_RESOLVER__TARGET:
				setTarget((EObject)newValue);
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
			case VariablePackage.DIRECT_VARIABLE_RESOLVER__TARGET:
				setTarget((EObject)null);
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
			case VariablePackage.DIRECT_VARIABLE_RESOLVER__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

} //DirectVariableResolverImpl
