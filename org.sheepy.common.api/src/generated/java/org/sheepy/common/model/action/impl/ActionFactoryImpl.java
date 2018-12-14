/**
 */
package org.sheepy.common.model.action.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.common.model.action.*;

import org.sheepy.common.model.types.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionFactoryImpl extends EFactoryImpl implements ActionFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActionFactory init()
	{
		try
		{
			ActionFactory theActionFactory = (ActionFactory)EPackage.Registry.INSTANCE.getEFactory(ActionPackage.eNS_URI);
			if (theActionFactory != null)
			{
				return theActionFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionFactoryImpl()
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
			case ActionPackage.STRING_INJECTOR: return createStringInjector();
			case ActionPackage.NUMBER_INJECTOR: return createNumberInjector();
			case ActionPackage.PARAMETERED_ACTIONS_PKG: return createParameteredActionsPkg();
			case ActionPackage.ACTIONS_PKG: return createActionsPkg();
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
			case ActionPackage.ACTION_LIST:
				return createActionListFromString(eDataType, initialValue);
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
			case ActionPackage.ACTION_LIST:
				return convertActionListToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringInjector createStringInjector()
	{
		StringInjectorImpl stringInjector = new StringInjectorImpl();
		return stringInjector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberInjector createNumberInjector()
	{
		NumberInjectorImpl numberInjector = new NumberInjectorImpl();
		return numberInjector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends Parameter> ParameteredActionsPkg<T> createParameteredActionsPkg()
	{
		ParameteredActionsPkgImpl<T> parameteredActionsPkg = new ParameteredActionsPkgImpl<T>();
		return parameteredActionsPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionsPkg createActionsPkg()
	{
		ActionsPkgImpl actionsPkg = new ActionsPkgImpl();
		return actionsPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<? extends Action> createActionListFromString(EDataType eDataType, String initialValue)
	{
		return (List<? extends Action>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionListToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionPackage getActionPackage()
	{
		return (ActionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActionPackage getPackage()
	{
		return ActionPackage.eINSTANCE;
	}

} //ActionFactoryImpl
