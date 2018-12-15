/**
 */
package org.sheepy.common.model.variable.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.common.api.util.ResolvedVariableFeature;

import org.sheepy.common.model.variable.*;

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
			VariableFactory theVariableFactory = (VariableFactory)EPackage.Registry.INSTANCE.getEFactory(VariablePackage.eNS_URI);
			if (theVariableFactory != null)
			{
				return theVariableFactory;
			}
		}
		catch (Exception exception)
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
			case VariablePackage.DIRECT_VARIABLE_RESOLVER: return createDirectVariableResolver();
			case VariablePackage.BOOLEAN_CHANGE_ACTION: return createBooleanChangeAction();
			case VariablePackage.VAR_CHANGE_ACTION_PKG: return createVarChangeActionPkg();
			case VariablePackage.INCREMENT_ACTION: return createIncrementAction();
			case VariablePackage.SET_STRING: return createSetString();
			case VariablePackage.SET_BOOLEAN: return createSetBoolean();
			case VariablePackage.SET_NUMBER: return createSetNumber();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public IncrementAction createIncrementAction()
	{
		IncrementActionImpl incrementAction = new IncrementActionImpl();
		return incrementAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetString createSetString()
	{
		SetStringImpl setString = new SetStringImpl();
		return setString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetBoolean createSetBoolean()
	{
		SetBooleanImpl setBoolean = new SetBooleanImpl();
		return setBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetNumber createSetNumber()
	{
		SetNumberImpl setNumber = new SetNumberImpl();
		return setNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolvedVariableFeature createLResolvedVariableFeatureFromString(EDataType eDataType, String initialValue)
	{
		return (ResolvedVariableFeature)super.createFromString(eDataType, initialValue);
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
		return (String)super.createFromString(eDataType, initialValue);
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
	public VariablePackage getVariablePackage()
	{
		return (VariablePackage)getEPackage();
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
