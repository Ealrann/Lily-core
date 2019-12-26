/**
 */
package org.sheepy.lily.core.model.application.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.action.impl.ActionPackageImpl;

import org.sheepy.lily.core.model.application.AbstractModuleResource;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationExtensionPackage;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.application.ESampling;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.core.model.application.GenericScenePart;
import org.sheepy.lily.core.model.application.IApplicationExtension;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.application.IResource;
import org.sheepy.lily.core.model.application.IScenePart;
import org.sheepy.lily.core.model.application.LocalResource;
import org.sheepy.lily.core.model.application.ModuleResource;
import org.sheepy.lily.core.model.application.ResourcePkg;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.core.model.application.StringModuleResource;
import org.sheepy.lily.core.model.application.TimeConfiguration;
import org.sheepy.lily.core.model.application.VirtualResource;
import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl;
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
public class ApplicationPackageImpl extends EPackageImpl implements ApplicationPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iApplicationExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationExtensionPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEngineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iScenePartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCadenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sceneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericScenePartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass backgroundImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourcePkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractModuleResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringModuleResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eSamplingEEnum = null;

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
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ApplicationPackageImpl()
	{
		super(eNS_URI, ApplicationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ApplicationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ApplicationPackage init()
	{
		if (isInited) return (ApplicationPackage)EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredApplicationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ApplicationPackageImpl theApplicationPackage = registeredApplicationPackage instanceof ApplicationPackageImpl ? (ApplicationPackageImpl)registeredApplicationPackage : new ApplicationPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);
		UiPackageImpl theUiPackage = (UiPackageImpl)(registeredPackage instanceof UiPackageImpl ? registeredPackage : UiPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI);
		PresentationPackageImpl thePresentationPackage = (PresentationPackageImpl)(registeredPackage instanceof PresentationPackageImpl ? registeredPackage : PresentationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);
		VariablePackageImpl theVariablePackage = (VariablePackageImpl)(registeredPackage instanceof VariablePackageImpl ? registeredPackage : VariablePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(registeredPackage instanceof TypesPackageImpl ? registeredPackage : TypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InferencePackage.eNS_URI);
		InferencePackageImpl theInferencePackage = (InferencePackageImpl)(registeredPackage instanceof InferencePackageImpl ? registeredPackage : InferencePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MaintainerPackage.eNS_URI);
		MaintainerPackageImpl theMaintainerPackage = (MaintainerPackageImpl)(registeredPackage instanceof MaintainerPackageImpl ? registeredPackage : MaintainerPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CadencePackage.eNS_URI);
		CadencePackageImpl theCadencePackage = (CadencePackageImpl)(registeredPackage instanceof CadencePackageImpl ? registeredPackage : CadencePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);
		ActionPackageImpl theActionPackage = (ActionPackageImpl)(registeredPackage instanceof ActionPackageImpl ? registeredPackage : ActionPackage.eINSTANCE);

		// Create package meta-data objects
		theApplicationPackage.createPackageContents();
		theUiPackage.createPackageContents();
		thePresentationPackage.createPackageContents();
		theVariablePackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theInferencePackage.createPackageContents();
		theMaintainerPackage.createPackageContents();
		theCadencePackage.createPackageContents();
		theActionPackage.createPackageContents();

		// Initialize created meta-data
		theApplicationPackage.initializePackageContents();
		theUiPackage.initializePackageContents();
		thePresentationPackage.initializePackageContents();
		theVariablePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theInferencePackage.initializePackageContents();
		theMaintainerPackage.initializePackageContents();
		theCadencePackage.initializePackageContents();
		theActionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theApplicationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ApplicationPackage.eNS_URI, theApplicationPackage);
		return theApplicationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getApplication()
	{
		return applicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplication_Engines()
	{
		return (EReference)applicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApplication_Run()
	{
		return (EAttribute)applicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApplication_Title()
	{
		return (EAttribute)applicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplication_Scene()
	{
		return (EReference)applicationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplication_TimeConfiguration()
	{
		return (EReference)applicationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplication_ExtensionPkg()
	{
		return (EReference)applicationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIApplicationExtension()
	{
		return iApplicationExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getApplicationExtensionPackage()
	{
		return applicationExtensionPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationExtensionPackage_Extensions()
	{
		return (EReference)applicationExtensionPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTimeConfiguration()
	{
		return timeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTimeConfiguration_TimeStep()
	{
		return (EAttribute)timeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTimeConfiguration_Unit()
	{
		return (EAttribute)timeConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTimeConfiguration_TimeFactor()
	{
		return (EAttribute)timeConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIEngine()
	{
		return iEngineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIScenePart()
	{
		return iScenePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getICadence()
	{
		return iCadenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScene()
	{
		return sceneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScene_Parts()
	{
		return (EReference)sceneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScene_Fullscreen()
	{
		return (EAttribute)sceneEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScene_Resizeable()
	{
		return (EAttribute)sceneEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScene_Size()
	{
		return (EAttribute)sceneEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenericScenePart()
	{
		return genericScenePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBackgroundImage()
	{
		return backgroundImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBackgroundImage_Resource()
	{
		return (EReference)backgroundImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBackgroundImage_ClearColor()
	{
		return (EAttribute)backgroundImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBackgroundImage_Sampling()
	{
		return (EAttribute)backgroundImageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResourcePkg()
	{
		return resourcePkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getResourcePkg_Resources()
	{
		return (EReference)resourcePkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIResource()
	{
		return iResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVirtualResource()
	{
		return virtualResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFileResource()
	{
		return fileResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFileResource_Path()
	{
		return (EAttribute)fileResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLocalResource()
	{
		return localResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractModuleResource()
	{
		return abstractModuleResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModuleResource()
	{
		return moduleResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModuleResource_Module()
	{
		return (EAttribute)moduleResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringModuleResource()
	{
		return stringModuleResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringModuleResource_ModuleName()
	{
		return (EAttribute)stringModuleResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getESampling()
	{
		return eSamplingEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApplicationFactory getApplicationFactory()
	{
		return (ApplicationFactory)getEFactoryInstance();
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
		applicationEClass = createEClass(APPLICATION);
		createEReference(applicationEClass, APPLICATION__ENGINES);
		createEAttribute(applicationEClass, APPLICATION__RUN);
		createEAttribute(applicationEClass, APPLICATION__TITLE);
		createEReference(applicationEClass, APPLICATION__SCENE);
		createEReference(applicationEClass, APPLICATION__TIME_CONFIGURATION);
		createEReference(applicationEClass, APPLICATION__EXTENSION_PKG);

		iApplicationExtensionEClass = createEClass(IAPPLICATION_EXTENSION);

		applicationExtensionPackageEClass = createEClass(APPLICATION_EXTENSION_PACKAGE);
		createEReference(applicationExtensionPackageEClass, APPLICATION_EXTENSION_PACKAGE__EXTENSIONS);

		timeConfigurationEClass = createEClass(TIME_CONFIGURATION);
		createEAttribute(timeConfigurationEClass, TIME_CONFIGURATION__TIME_STEP);
		createEAttribute(timeConfigurationEClass, TIME_CONFIGURATION__UNIT);
		createEAttribute(timeConfigurationEClass, TIME_CONFIGURATION__TIME_FACTOR);

		iEngineEClass = createEClass(IENGINE);

		iScenePartEClass = createEClass(ISCENE_PART);

		iCadenceEClass = createEClass(ICADENCE);

		sceneEClass = createEClass(SCENE);
		createEReference(sceneEClass, SCENE__PARTS);
		createEAttribute(sceneEClass, SCENE__FULLSCREEN);
		createEAttribute(sceneEClass, SCENE__RESIZEABLE);
		createEAttribute(sceneEClass, SCENE__SIZE);

		genericScenePartEClass = createEClass(GENERIC_SCENE_PART);

		backgroundImageEClass = createEClass(BACKGROUND_IMAGE);
		createEReference(backgroundImageEClass, BACKGROUND_IMAGE__RESOURCE);
		createEAttribute(backgroundImageEClass, BACKGROUND_IMAGE__CLEAR_COLOR);
		createEAttribute(backgroundImageEClass, BACKGROUND_IMAGE__SAMPLING);

		resourcePkgEClass = createEClass(RESOURCE_PKG);
		createEReference(resourcePkgEClass, RESOURCE_PKG__RESOURCES);

		iResourceEClass = createEClass(IRESOURCE);

		virtualResourceEClass = createEClass(VIRTUAL_RESOURCE);

		fileResourceEClass = createEClass(FILE_RESOURCE);
		createEAttribute(fileResourceEClass, FILE_RESOURCE__PATH);

		localResourceEClass = createEClass(LOCAL_RESOURCE);

		abstractModuleResourceEClass = createEClass(ABSTRACT_MODULE_RESOURCE);

		moduleResourceEClass = createEClass(MODULE_RESOURCE);
		createEAttribute(moduleResourceEClass, MODULE_RESOURCE__MODULE);

		stringModuleResourceEClass = createEClass(STRING_MODULE_RESOURCE);
		createEAttribute(stringModuleResourceEClass, STRING_MODULE_RESOURCE__MODULE_NAME);

		// Create enums
		eSamplingEEnum = createEEnum(ESAMPLING);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		InferencePackage theInferencePackage = (InferencePackage)EPackage.Registry.INSTANCE.getEPackage(InferencePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		iApplicationExtensionEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		iScenePartEClass.getESuperTypes().add(theInferencePackage.getIInferenceObject());
		genericScenePartEClass.getESuperTypes().add(this.getIScenePart());
		genericScenePartEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		backgroundImageEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		backgroundImageEClass.getESuperTypes().add(this.getIScenePart());
		iResourceEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		virtualResourceEClass.getESuperTypes().add(this.getIResource());
		fileResourceEClass.getESuperTypes().add(this.getIResource());
		localResourceEClass.getESuperTypes().add(this.getFileResource());
		abstractModuleResourceEClass.getESuperTypes().add(this.getFileResource());
		moduleResourceEClass.getESuperTypes().add(this.getAbstractModuleResource());
		stringModuleResourceEClass.getESuperTypes().add(this.getAbstractModuleResource());

		// Initialize classes, features, and operations; add parameters
		initEClass(applicationEClass, Application.class, "Application", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplication_Engines(), this.getIEngine(), null, "engines", null, 0, -1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplication_Run(), ecorePackage.getEBoolean(), "run", "true", 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplication_Title(), ecorePackage.getEString(), "title", "Vulkan Application", 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplication_Scene(), this.getScene(), null, "scene", null, 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplication_TimeConfiguration(), this.getTimeConfiguration(), null, "timeConfiguration", null, 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplication_ExtensionPkg(), this.getApplicationExtensionPackage(), null, "extensionPkg", null, 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iApplicationExtensionEClass, IApplicationExtension.class, "IApplicationExtension", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(applicationExtensionPackageEClass, ApplicationExtensionPackage.class, "ApplicationExtensionPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplicationExtensionPackage_Extensions(), this.getIApplicationExtension(), null, "extensions", null, 0, -1, ApplicationExtensionPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeConfigurationEClass, TimeConfiguration.class, "TimeConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeConfiguration_TimeStep(), ecorePackage.getELong(), "timeStep", "1", 1, 1, TimeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeConfiguration_Unit(), theTypesPackage.getETimeUnit(), "unit", "SECONDS", 1, 1, TimeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeConfiguration_TimeFactor(), ecorePackage.getEDouble(), "timeFactor", "1", 1, 1, TimeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iEngineEClass, IEngine.class, "IEngine", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iScenePartEClass, IScenePart.class, "IScenePart", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iCadenceEClass, ICadence.class, "ICadence", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sceneEClass, Scene.class, "Scene", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScene_Parts(), this.getIScenePart(), null, "parts", null, 0, -1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScene_Fullscreen(), ecorePackage.getEBoolean(), "fullscreen", "false", 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScene_Resizeable(), ecorePackage.getEBoolean(), "resizeable", "false", 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScene_Size(), theTypesPackage.getVector2i(), "size", "400,400", 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genericScenePartEClass, GenericScenePart.class, "GenericScenePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(backgroundImageEClass, BackgroundImage.class, "BackgroundImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBackgroundImage_Resource(), this.getIResource(), null, "resource", null, 0, 1, BackgroundImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBackgroundImage_ClearColor(), theTypesPackage.getVector3i(), "clearColor", "0;0;0", 1, 1, BackgroundImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBackgroundImage_Sampling(), this.getESampling(), "sampling", null, 1, 1, BackgroundImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourcePkgEClass, ResourcePkg.class, "ResourcePkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourcePkg_Resources(), this.getIResource(), null, "resources", null, 0, -1, ResourcePkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iResourceEClass, IResource.class, "IResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(virtualResourceEClass, VirtualResource.class, "VirtualResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fileResourceEClass, FileResource.class, "FileResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileResource_Path(), ecorePackage.getEString(), "path", null, 1, 1, FileResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localResourceEClass, LocalResource.class, "LocalResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractModuleResourceEClass, AbstractModuleResource.class, "AbstractModuleResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moduleResourceEClass, ModuleResource.class, "ModuleResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModuleResource_Module(), theTypesPackage.getJavaModule(), "module", null, 1, 1, ModuleResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringModuleResourceEClass, StringModuleResource.class, "StringModuleResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringModuleResource_ModuleName(), ecorePackage.getEString(), "moduleName", null, 1, 1, StringModuleResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eSamplingEEnum, ESampling.class, "ESampling");
		addEEnumLiteral(eSamplingEEnum, ESampling.LINEAR);
		addEEnumLiteral(eSamplingEEnum, ESampling.NEAREST);

		// Create resource
		createResource(eNS_URI);
	}

} //ApplicationPackageImpl
