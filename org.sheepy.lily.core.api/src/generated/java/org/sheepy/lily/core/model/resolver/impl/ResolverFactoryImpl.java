/**
 */
package org.sheepy.lily.core.model.resolver.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.core.model.resolver.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResolverFactoryImpl extends EFactoryImpl implements ResolverFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResolverFactory init()
	{
		try
		{
			ResolverFactory theResolverFactory = (ResolverFactory) EPackage.Registry.INSTANCE
					.getEFactory(ResolverPackage.eNS_URI);
			if (theResolverFactory != null)
			{
				return theResolverFactory;
			}
		} catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResolverFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolverFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
		case ResolverPackage.EREFERENCE_RESOLVER:
			return createEReferenceResolver();
		case ResolverPackage.CHAIN_RESOLVER:
			return createChainResolver();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReferenceResolver createEReferenceResolver()
	{
		EReferenceResolverImpl eReferenceResolver = new EReferenceResolverImpl();
		return eReferenceResolver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ChainResolver createChainResolver()
	{
		ChainResolverImpl chainResolver = new ChainResolverImpl();
		return chainResolver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResolverPackage getResolverPackage()
	{
		return (ResolverPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResolverPackage getPackage()
	{
		return ResolverPackage.eINSTANCE;
	}

} //ResolverFactoryImpl
