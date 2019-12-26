/**
 */
package org.sheepy.lily.core.model.cadence.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.core.model.cadence.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CadenceFactoryImpl extends EFactoryImpl implements CadenceFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CadenceFactory init()
	{
		try
		{
			CadenceFactory theCadenceFactory = (CadenceFactory)EPackage.Registry.INSTANCE.getEFactory(CadencePackage.eNS_URI);
			if (theCadenceFactory != null)
			{
				return theCadenceFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CadenceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CadenceFactoryImpl()
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
			case CadencePackage.CADENCE: return (EObject)createCadence();
			case CadencePackage.EXECUTE_WHILE: return (EObject)createExecuteWhile();
			case CadencePackage.EXECUTE_IF: return (EObject)createExecuteIf();
			case CadencePackage.PRINT_UPS: return (EObject)createPrintUPS();
			case CadencePackage.HAVE_TIME: return (EObject)createHaveTime();
			case CadencePackage.COUNT_UNTIL: return (EObject)createCountUntil();
			case CadencePackage.CLOSE_APPLICATION: return (EObject)createCloseApplication();
			case CadencePackage.GENERIC_CADENCE: return (EObject)createGenericCadence();
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
	public Cadence createCadence()
	{
		CadenceImpl cadence = new CadenceImpl();
		return cadence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecuteWhile createExecuteWhile()
	{
		ExecuteWhileImpl executeWhile = new ExecuteWhileImpl();
		return executeWhile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecuteIf createExecuteIf()
	{
		ExecuteIfImpl executeIf = new ExecuteIfImpl();
		return executeIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrintUPS createPrintUPS()
	{
		PrintUPSImpl printUPS = new PrintUPSImpl();
		return printUPS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HaveTime createHaveTime()
	{
		HaveTimeImpl haveTime = new HaveTimeImpl();
		return haveTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CountUntil createCountUntil()
	{
		CountUntilImpl countUntil = new CountUntilImpl();
		return countUntil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CloseApplication createCloseApplication()
	{
		CloseApplicationImpl closeApplication = new CloseApplicationImpl();
		return closeApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenericCadence createGenericCadence()
	{
		GenericCadenceImpl genericCadence = new GenericCadenceImpl();
		return genericCadence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CadencePackage getCadencePackage()
	{
		return (CadencePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CadencePackage getPackage()
	{
		return CadencePackage.eINSTANCE;
	}

} //CadenceFactoryImpl
