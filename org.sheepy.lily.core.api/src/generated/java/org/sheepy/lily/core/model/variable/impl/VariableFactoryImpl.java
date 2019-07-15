/**
 */
package org.sheepy.lily.core.model.variable.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.core.api.util.FeatureDefinition;

import org.sheepy.lily.core.model.variable.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VariableFactoryImpl extends EFactoryImpl implements VariableFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableFactory init()
	{
		try
		{
			VariableFactory theVariableFactory = (VariableFactory) EPackage.Registry.INSTANCE
					.getEFactory(VariablePackage.eNS_URI);
			if (theVariableFactory != null)
			{
				return theVariableFactory;
			}
		} catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VariableFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableFactoryImpl()
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
		case VariablePackage.CHAIN_VARIABLE_RESOLVER:
			return createChainVariableResolver();
		case VariablePackage.CHAIN_RESOLVER:
			return createChainResolver();
		case VariablePackage.DIRECT_VARIABLE_RESOLVER:
			return createDirectVariableResolver();
		case VariablePackage.BOOLEAN_CHANGE_ACTION:
			return createBooleanChangeAction();
		case VariablePackage.VAR_CHANGE_ACTION_PKG:
			return createVarChangeActionPkg();
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
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
		case VariablePackage.LRESOLVED_VARIABLE_FEATURE:
			return createLResolvedVariableFeatureFromString(eDataType, initialValue);
		case VariablePackage.VARIABLE_DEFINITION:
			return createVariableDefinitionFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
		case VariablePackage.LRESOLVED_VARIABLE_FEATURE:
			return convertLResolvedVariableFeatureToString(eDataType, instanceValue);
		case VariablePackage.VARIABLE_DEFINITION:
			return convertVariableDefinitionToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ChainVariableResolver createChainVariableResolver()
	{
		ChainVariableResolverImpl chainVariableResolver = new ChainVariableResolverImpl();
		return chainVariableResolver;
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
	public DirectVariableResolver createDirectVariableResolver()
	{
		DirectVariableResolverImpl directVariableResolver = new DirectVariableResolverImpl();
		return directVariableResolver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanChangeAction createBooleanChangeAction()
	{
		BooleanChangeActionImpl booleanChangeAction = new BooleanChangeActionImpl();
		return booleanChangeAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VarChangeActionPkg createVarChangeActionPkg()
	{
		VarChangeActionPkgImpl varChangeActionPkg = new VarChangeActionPkgImpl();
		return varChangeActionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureDefinition createLResolvedVariableFeatureFromString(	EDataType eDataType,
																		String initialValue)
	{
		return (FeatureDefinition) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLResolvedVariableFeatureToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createVariableDefinitionFromString(EDataType eDataType, String initialValue)
	{
		return (String) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariableDefinitionToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariablePackage getVariablePackage()
	{
		return (VariablePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VariablePackage getPackage()
	{
		return VariablePackage.eINSTANCE;
	}

} //VariableFactoryImpl
