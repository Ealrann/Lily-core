/**
 */
package org.sheepy.lily.core.model.resolver.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.model.resolver.ChainResolver;
import org.sheepy.lily.core.model.resolver.ILObjectResolver;
import org.sheepy.lily.core.model.resolver.ResolverPackage;

import org.sheepy.lily.core.model.root.LObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Chain Resolver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.resolver.impl.ChainResolverImpl#getResolvers <em>Resolvers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChainResolverImpl extends MinimalEObjectImpl.Container implements ChainResolver
{
	/**
	 * The cached value of the '{@link #getResolvers() <em>Resolvers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvers()
	 * @generated
	 * @ordered
	 */
	protected EList<ILObjectResolver> resolvers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChainResolverImpl()
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
		return ResolverPackage.Literals.CHAIN_RESOLVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ILObjectResolver> getResolvers()
	{
		if (resolvers == null)
		{
			resolvers = new EObjectContainmentEList<ILObjectResolver>(ILObjectResolver.class, this, ResolverPackage.CHAIN_RESOLVER__RESOLVERS);
		}
		return resolvers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void collectUnits(final LObject source, final Collection<LObject> collected)
	{
		Deque<LObject> course = new ArrayDeque<LObject>();
		Deque<LObject> next = new ArrayDeque<LObject>();
		Deque<LObject> temp = null;
		next.add(source);
		EList<ILObjectResolver> _resolvers = this.getResolvers();
		for (final ILObjectResolver resolver : _resolvers)
		{
			{
				temp = course;
				course = next;
				next = temp;
				while ((course.isEmpty() == false))
				{
					{
						final LObject object = course.poll();
						resolver.collectUnits(object, next);
					}
				}
			}
		}
		collected.addAll(next);
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
			case ResolverPackage.CHAIN_RESOLVER__RESOLVERS:
				return ((InternalEList<?>)getResolvers()).basicRemove(otherEnd, msgs);
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
			case ResolverPackage.CHAIN_RESOLVER__RESOLVERS:
				return getResolvers();
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
			case ResolverPackage.CHAIN_RESOLVER__RESOLVERS:
				getResolvers().clear();
				getResolvers().addAll((Collection<? extends ILObjectResolver>)newValue);
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
			case ResolverPackage.CHAIN_RESOLVER__RESOLVERS:
				getResolvers().clear();
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
			case ResolverPackage.CHAIN_RESOLVER__RESOLVERS:
				return resolvers != null && !resolvers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case ResolverPackage.CHAIN_RESOLVER___COLLECT_UNITS__LOBJECT_COLLECTION:
				collectUnits((LObject)arguments.get(0), (Collection<LObject>)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //ChainResolverImpl
