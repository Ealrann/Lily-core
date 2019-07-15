/**
 */
package org.sheepy.lily.core.model.variable.impl;

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

import org.sheepy.lily.core.model.variable.ChainResolver;
import org.sheepy.lily.core.model.variable.ChainVariableResolver;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.core.model.variable.VariablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Chain Variable Resolver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.impl.ChainVariableResolverImpl#getFirstResolver <em>First Resolver</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.variable.impl.ChainVariableResolverImpl#getSubResolvers <em>Sub Resolvers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChainVariableResolverImpl extends MinimalEObjectImpl.Container
		implements ChainVariableResolver
{
	/**
	 * The cached value of the '{@link #getFirstResolver() <em>First Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstResolver()
	 * @generated
	 * @ordered
	 */
	protected IVariableResolver firstResolver;

	/**
	 * The cached value of the '{@link #getSubResolvers() <em>Sub Resolvers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubResolvers()
	 * @generated
	 * @ordered
	 */
	protected EList<ChainResolver> subResolvers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChainVariableResolverImpl()
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
		return VariablePackage.Literals.CHAIN_VARIABLE_RESOLVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IVariableResolver getFirstResolver()
	{
		return firstResolver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstResolver(	IVariableResolver newFirstResolver,
													NotificationChain msgs)
	{
		IVariableResolver oldFirstResolver = firstResolver;
		firstResolver = newFirstResolver;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					VariablePackage.CHAIN_VARIABLE_RESOLVER__FIRST_RESOLVER, oldFirstResolver,
					newFirstResolver);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstResolver(IVariableResolver newFirstResolver)
	{
		if (newFirstResolver != firstResolver)
		{
			NotificationChain msgs = null;
			if (firstResolver != null)
				msgs = ((InternalEObject) firstResolver).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- VariablePackage.CHAIN_VARIABLE_RESOLVER__FIRST_RESOLVER,
						null, msgs);
			if (newFirstResolver != null)
				msgs = ((InternalEObject) newFirstResolver).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- VariablePackage.CHAIN_VARIABLE_RESOLVER__FIRST_RESOLVER,
						null, msgs);
			msgs = basicSetFirstResolver(newFirstResolver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				VariablePackage.CHAIN_VARIABLE_RESOLVER__FIRST_RESOLVER, newFirstResolver,
				newFirstResolver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ChainResolver> getSubResolvers()
	{
		if (subResolvers == null)
		{
			subResolvers = new EObjectContainmentEList<ChainResolver>(ChainResolver.class, this,
					VariablePackage.CHAIN_VARIABLE_RESOLVER__SUB_RESOLVERS);
		}
		return subResolvers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case VariablePackage.CHAIN_VARIABLE_RESOLVER__FIRST_RESOLVER:
			return basicSetFirstResolver(null, msgs);
		case VariablePackage.CHAIN_VARIABLE_RESOLVER__SUB_RESOLVERS:
			return ((InternalEList<?>) getSubResolvers()).basicRemove(otherEnd, msgs);
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
		case VariablePackage.CHAIN_VARIABLE_RESOLVER__FIRST_RESOLVER:
			return getFirstResolver();
		case VariablePackage.CHAIN_VARIABLE_RESOLVER__SUB_RESOLVERS:
			return getSubResolvers();
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
		case VariablePackage.CHAIN_VARIABLE_RESOLVER__FIRST_RESOLVER:
			setFirstResolver((IVariableResolver) newValue);
			return;
		case VariablePackage.CHAIN_VARIABLE_RESOLVER__SUB_RESOLVERS:
			getSubResolvers().clear();
			getSubResolvers().addAll((Collection<? extends ChainResolver>) newValue);
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
		case VariablePackage.CHAIN_VARIABLE_RESOLVER__FIRST_RESOLVER:
			setFirstResolver((IVariableResolver) null);
			return;
		case VariablePackage.CHAIN_VARIABLE_RESOLVER__SUB_RESOLVERS:
			getSubResolvers().clear();
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
		case VariablePackage.CHAIN_VARIABLE_RESOLVER__FIRST_RESOLVER:
			return firstResolver != null;
		case VariablePackage.CHAIN_VARIABLE_RESOLVER__SUB_RESOLVERS:
			return subResolvers != null && !subResolvers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ChainVariableResolverImpl
