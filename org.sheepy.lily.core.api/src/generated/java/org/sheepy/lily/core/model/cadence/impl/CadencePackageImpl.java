/**
 */
package org.sheepy.lily.core.model.cadence.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.action.impl.ActionPackageImpl;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl;

import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.cadence.CadenceTaskPkg;
import org.sheepy.lily.core.model.cadence.CloseApplication;
import org.sheepy.lily.core.model.cadence.CountUntil;
import org.sheepy.lily.core.model.cadence.ExecuteIf;
import org.sheepy.lily.core.model.cadence.ExecuteWhile;
import org.sheepy.lily.core.model.cadence.HaveTime;
import org.sheepy.lily.core.model.cadence.ICadenceCondition;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.core.model.cadence.PrintUPS;
import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.inference.impl.InferencePackageImpl;

import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

import org.sheepy.lily.core.model.maintainer.impl.MaintainerPackageImpl;

import org.sheepy.lily.core.model.presentation.PresentationPackage;

import org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.types.impl.TypesPackageImpl;

import org.sheepy.lily.core.model.ui.UiPackage;

import org.sheepy.lily.core.model.ui.impl.UiPackageImpl;

import org.sheepy.lily.core.model.variable.VariablePackage;

import org.sheepy.lily.core.model.variable.impl.VariablePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CadencePackageImpl extends EPackageImpl implements CadencePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cadenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCadenceTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cadenceTaskPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executeWhileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executeIfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass printUPSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCadenceConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass haveTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countUntilEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass closeApplicationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.sheepy.lily.core.model.cadence.CadencePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CadencePackageImpl()
	{
		super(eNS_URI, CadenceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link CadencePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CadencePackage init()
	{
		if (isInited) return (CadencePackage)EPackage.Registry.INSTANCE.getEPackage(CadencePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCadencePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CadencePackageImpl theCadencePackage = registeredCadencePackage instanceof CadencePackageImpl ? (CadencePackageImpl)registeredCadencePackage : new CadencePackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);
		UiPackageImpl theUiPackage = (UiPackageImpl)(registeredPackage instanceof UiPackageImpl ? registeredPackage : UiPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI);
		PresentationPackageImpl thePresentationPackage = (PresentationPackageImpl)(registeredPackage instanceof PresentationPackageImpl ? registeredPackage : PresentationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);
		ApplicationPackageImpl theApplicationPackage = (ApplicationPackageImpl)(registeredPackage instanceof ApplicationPackageImpl ? registeredPackage : ApplicationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);
		VariablePackageImpl theVariablePackage = (VariablePackageImpl)(registeredPackage instanceof VariablePackageImpl ? registeredPackage : VariablePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(registeredPackage instanceof TypesPackageImpl ? registeredPackage : TypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InferencePackage.eNS_URI);
		InferencePackageImpl theInferencePackage = (InferencePackageImpl)(registeredPackage instanceof InferencePackageImpl ? registeredPackage : InferencePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MaintainerPackage.eNS_URI);
		MaintainerPackageImpl theMaintainerPackage = (MaintainerPackageImpl)(registeredPackage instanceof MaintainerPackageImpl ? registeredPackage : MaintainerPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);
		ActionPackageImpl theActionPackage = (ActionPackageImpl)(registeredPackage instanceof ActionPackageImpl ? registeredPackage : ActionPackage.eINSTANCE);

		// Create package meta-data objects
		theCadencePackage.createPackageContents();
		theUiPackage.createPackageContents();
		thePresentationPackage.createPackageContents();
		theApplicationPackage.createPackageContents();
		theVariablePackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theInferencePackage.createPackageContents();
		theMaintainerPackage.createPackageContents();
		theActionPackage.createPackageContents();

		// Initialize created meta-data
		theCadencePackage.initializePackageContents();
		theUiPackage.initializePackageContents();
		thePresentationPackage.initializePackageContents();
		theApplicationPackage.initializePackageContents();
		theVariablePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theInferencePackage.initializePackageContents();
		theMaintainerPackage.initializePackageContents();
		theActionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCadencePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CadencePackage.eNS_URI, theCadencePackage);
		return theCadencePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCadence()
	{
		return cadenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCadence_Frequency()
	{
		return (EAttribute)cadenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCadence_PrintUPS()
	{
		return (EAttribute)cadenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getICadenceTask()
	{
		return iCadenceTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCadenceTaskPkg()
	{
		return cadenceTaskPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCadenceTaskPkg_Tasks()
	{
		return (EReference)cadenceTaskPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExecuteWhile()
	{
		return executeWhileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExecuteWhile_Conditions()
	{
		return (EReference)executeWhileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExecuteIf()
	{
		return executeIfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExecuteIf_Conditions()
	{
		return (EReference)executeIfEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrintUPS()
	{
		return printUPSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPrintUPS_PrintEveryMs()
	{
		return (EAttribute)printUPSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getICadenceCondition()
	{
		return iCadenceConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHaveTime()
	{
		return haveTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCountUntil()
	{
		return countUntilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCountUntil_TotalCount()
	{
		return (EAttribute)countUntilEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCountUntil_CurrentCount()
	{
		return (EAttribute)countUntilEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCloseApplication()
	{
		return closeApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CadenceFactory getCadenceFactory()
	{
		return (CadenceFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		cadenceEClass = createEClass(CADENCE);
		createEAttribute(cadenceEClass, CADENCE__FREQUENCY);
		createEAttribute(cadenceEClass, CADENCE__PRINT_UPS);

		iCadenceTaskEClass = createEClass(ICADENCE_TASK);

		cadenceTaskPkgEClass = createEClass(CADENCE_TASK_PKG);
		createEReference(cadenceTaskPkgEClass, CADENCE_TASK_PKG__TASKS);

		executeWhileEClass = createEClass(EXECUTE_WHILE);
		createEReference(executeWhileEClass, EXECUTE_WHILE__CONDITIONS);

		executeIfEClass = createEClass(EXECUTE_IF);
		createEReference(executeIfEClass, EXECUTE_IF__CONDITIONS);

		printUPSEClass = createEClass(PRINT_UPS);
		createEAttribute(printUPSEClass, PRINT_UPS__PRINT_EVERY_MS);

		iCadenceConditionEClass = createEClass(ICADENCE_CONDITION);

		haveTimeEClass = createEClass(HAVE_TIME);

		countUntilEClass = createEClass(COUNT_UNTIL);
		createEAttribute(countUntilEClass, COUNT_UNTIL__TOTAL_COUNT);
		createEAttribute(countUntilEClass, COUNT_UNTIL__CURRENT_COUNT);

		closeApplicationEClass = createEClass(CLOSE_APPLICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ApplicationPackage theApplicationPackage = (ApplicationPackage)EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cadenceEClass.getESuperTypes().add(this.getCadenceTaskPkg());
		cadenceEClass.getESuperTypes().add(theApplicationPackage.getICadence());
		cadenceTaskPkgEClass.getESuperTypes().add(this.getICadenceTask());
		executeWhileEClass.getESuperTypes().add(this.getCadenceTaskPkg());
		executeIfEClass.getESuperTypes().add(this.getCadenceTaskPkg());
		printUPSEClass.getESuperTypes().add(this.getICadenceTask());
		haveTimeEClass.getESuperTypes().add(this.getICadenceCondition());
		countUntilEClass.getESuperTypes().add(this.getICadenceCondition());
		closeApplicationEClass.getESuperTypes().add(this.getICadenceTask());

		// Initialize classes, features, and operations; add parameters
		initEClass(cadenceEClass, Cadence.class, "Cadence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCadence_Frequency(), ecorePackage.getEInt(), "frequency", "-1", 1, 1, Cadence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCadence_PrintUPS(), ecorePackage.getEBoolean(), "printUPS", "false", 1, 1, Cadence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iCadenceTaskEClass, ICadenceTask.class, "ICadenceTask", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cadenceTaskPkgEClass, CadenceTaskPkg.class, "CadenceTaskPkg", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCadenceTaskPkg_Tasks(), this.getICadenceTask(), null, "tasks", null, 0, -1, CadenceTaskPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executeWhileEClass, ExecuteWhile.class, "ExecuteWhile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecuteWhile_Conditions(), this.getICadenceCondition(), null, "conditions", null, 0, -1, ExecuteWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executeIfEClass, ExecuteIf.class, "ExecuteIf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecuteIf_Conditions(), this.getICadenceCondition(), null, "conditions", null, 0, -1, ExecuteIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(printUPSEClass, PrintUPS.class, "PrintUPS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrintUPS_PrintEveryMs(), ecorePackage.getEInt(), "printEveryMs", "2000", 1, 1, PrintUPS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iCadenceConditionEClass, ICadenceCondition.class, "ICadenceCondition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(haveTimeEClass, HaveTime.class, "HaveTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(countUntilEClass, CountUntil.class, "CountUntil", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCountUntil_TotalCount(), ecorePackage.getEInt(), "totalCount", "1", 1, 1, CountUntil.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCountUntil_CurrentCount(), ecorePackage.getEInt(), "currentCount", "0", 1, 1, CountUntil.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(closeApplicationEClass, CloseApplication.class, "CloseApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CadencePackageImpl
