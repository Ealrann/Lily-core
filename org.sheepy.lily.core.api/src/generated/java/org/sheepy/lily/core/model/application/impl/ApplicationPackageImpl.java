/**
 */
package org.sheepy.lily.core.model.application.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.sheepy.lily.core.model.action.ActionPackage;
import org.sheepy.lily.core.model.action.impl.ActionPackageImpl;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationExtensionPkg;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.GenericScenePart;
import org.sheepy.lily.core.model.application.IApplicationExtension;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.application.ICompositorExtension;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.application.IModel;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.core.model.application.ScreenEffect;
import org.sheepy.lily.core.model.application.SpecialEffect;
import org.sheepy.lily.core.model.application.TimeConfiguration;
import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl;
import org.sheepy.lily.core.model.inference.InferencePackage;
import org.sheepy.lily.core.model.inference.impl.InferencePackageImpl;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;
import org.sheepy.lily.core.model.maintainer.impl.MaintainerPackageImpl;
import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl;
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
	private EClass applicationExtensionPkgEClass = null;

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
	private EClass iModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCompositorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositorExtensionPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCompositorExtensionEClass = null;

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
	private EClass screenEffectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specialEffectEClass = null;

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
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);
		ResourcePackageImpl theResourcePackage = (ResourcePackageImpl)(registeredPackage instanceof ResourcePackageImpl ? registeredPackage : ResourcePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);
		UiPackageImpl theUiPackage = (UiPackageImpl)(registeredPackage instanceof UiPackageImpl ? registeredPackage : UiPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);
		VariablePackageImpl theVariablePackage = (VariablePackageImpl)(registeredPackage instanceof VariablePackageImpl ? registeredPackage : VariablePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(registeredPackage instanceof TypesPackageImpl ? registeredPackage : TypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI);
		PresentationPackageImpl thePresentationPackage = (PresentationPackageImpl)(registeredPackage instanceof PresentationPackageImpl ? registeredPackage : PresentationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MaintainerPackage.eNS_URI);
		MaintainerPackageImpl theMaintainerPackage = (MaintainerPackageImpl)(registeredPackage instanceof MaintainerPackageImpl ? registeredPackage : MaintainerPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InferencePackage.eNS_URI);
		InferencePackageImpl theInferencePackage = (InferencePackageImpl)(registeredPackage instanceof InferencePackageImpl ? registeredPackage : InferencePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CadencePackage.eNS_URI);
		CadencePackageImpl theCadencePackage = (CadencePackageImpl)(registeredPackage instanceof CadencePackageImpl ? registeredPackage : CadencePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);
		ActionPackageImpl theActionPackage = (ActionPackageImpl)(registeredPackage instanceof ActionPackageImpl ? registeredPackage : ActionPackage.eINSTANCE);

		// Create package meta-data objects
		theApplicationPackage.createPackageContents();
		theResourcePackage.createPackageContents();
		theUiPackage.createPackageContents();
		theVariablePackage.createPackageContents();
		theTypesPackage.createPackageContents();
		thePresentationPackage.createPackageContents();
		theMaintainerPackage.createPackageContents();
		theInferencePackage.createPackageContents();
		theCadencePackage.createPackageContents();
		theActionPackage.createPackageContents();

		// Initialize created meta-data
		theApplicationPackage.initializePackageContents();
		theResourcePackage.initializePackageContents();
		theUiPackage.initializePackageContents();
		theVariablePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		thePresentationPackage.initializePackageContents();
		theMaintainerPackage.initializePackageContents();
		theInferencePackage.initializePackageContents();
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
	public EReference getApplication_Models()
	{
		return (EReference)applicationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplication_ResourcePkg()
	{
		return (EReference)applicationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApplication_Version()
	{
		return (EAttribute)applicationEClass.getEStructuralFeatures().get(8);
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
	public EClass getApplicationExtensionPkg()
	{
		return applicationExtensionPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationExtensionPkg_Extensions()
	{
		return (EReference)applicationExtensionPkgEClass.getEStructuralFeatures().get(0);
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
	public EClass getIModel()
	{
		return iModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getICompositor()
	{
		return iCompositorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getICompositor_ExtensionPkg()
	{
		return (EReference)iCompositorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getICompositor_Enabled()
	{
		return (EAttribute)iCompositorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositorExtensionPkg()
	{
		return compositorExtensionPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositorExtensionPkg_Extensions()
	{
		return (EReference)compositorExtensionPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getICompositorExtension()
	{
		return iCompositorExtensionEClass;
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
	public EReference getScene_Compositors()
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
	public EReference getScene_ResourcePkg()
	{
		return (EReference)sceneEClass.getEStructuralFeatures().get(4);
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
	public EAttribute getBackgroundImage_ClearColor()
	{
		return (EAttribute)backgroundImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBackgroundImage_Sampling()
	{
		return (EAttribute)backgroundImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBackgroundImage_SrcImage()
	{
		return (EReference)backgroundImageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBackgroundImage_DstImage()
	{
		return (EReference)backgroundImageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScreenEffect()
	{
		return screenEffectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScreenEffect_SrcImage()
	{
		return (EReference)screenEffectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScreenEffect_DstImage()
	{
		return (EReference)screenEffectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScreenEffect_Effect()
	{
		return (EReference)screenEffectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpecialEffect()
	{
		return specialEffectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecialEffect_Shader()
	{
		return (EReference)specialEffectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecialEffect_Inputs()
	{
		return (EReference)specialEffectEClass.getEStructuralFeatures().get(1);
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
		createEReference(applicationEClass, APPLICATION__MODELS);
		createEReference(applicationEClass, APPLICATION__RESOURCE_PKG);
		createEAttribute(applicationEClass, APPLICATION__VERSION);

		iApplicationExtensionEClass = createEClass(IAPPLICATION_EXTENSION);

		applicationExtensionPkgEClass = createEClass(APPLICATION_EXTENSION_PKG);
		createEReference(applicationExtensionPkgEClass, APPLICATION_EXTENSION_PKG__EXTENSIONS);

		timeConfigurationEClass = createEClass(TIME_CONFIGURATION);
		createEAttribute(timeConfigurationEClass, TIME_CONFIGURATION__TIME_STEP);
		createEAttribute(timeConfigurationEClass, TIME_CONFIGURATION__UNIT);
		createEAttribute(timeConfigurationEClass, TIME_CONFIGURATION__TIME_FACTOR);

		iEngineEClass = createEClass(IENGINE);

		iModelEClass = createEClass(IMODEL);

		iCompositorEClass = createEClass(ICOMPOSITOR);
		createEReference(iCompositorEClass, ICOMPOSITOR__EXTENSION_PKG);
		createEAttribute(iCompositorEClass, ICOMPOSITOR__ENABLED);

		compositorExtensionPkgEClass = createEClass(COMPOSITOR_EXTENSION_PKG);
		createEReference(compositorExtensionPkgEClass, COMPOSITOR_EXTENSION_PKG__EXTENSIONS);

		iCompositorExtensionEClass = createEClass(ICOMPOSITOR_EXTENSION);

		iCadenceEClass = createEClass(ICADENCE);

		sceneEClass = createEClass(SCENE);
		createEReference(sceneEClass, SCENE__COMPOSITORS);
		createEAttribute(sceneEClass, SCENE__FULLSCREEN);
		createEAttribute(sceneEClass, SCENE__RESIZEABLE);
		createEAttribute(sceneEClass, SCENE__SIZE);
		createEReference(sceneEClass, SCENE__RESOURCE_PKG);

		genericScenePartEClass = createEClass(GENERIC_SCENE_PART);

		backgroundImageEClass = createEClass(BACKGROUND_IMAGE);
		createEAttribute(backgroundImageEClass, BACKGROUND_IMAGE__CLEAR_COLOR);
		createEAttribute(backgroundImageEClass, BACKGROUND_IMAGE__SAMPLING);
		createEReference(backgroundImageEClass, BACKGROUND_IMAGE__SRC_IMAGE);
		createEReference(backgroundImageEClass, BACKGROUND_IMAGE__DST_IMAGE);

		screenEffectEClass = createEClass(SCREEN_EFFECT);
		createEReference(screenEffectEClass, SCREEN_EFFECT__SRC_IMAGE);
		createEReference(screenEffectEClass, SCREEN_EFFECT__DST_IMAGE);
		createEReference(screenEffectEClass, SCREEN_EFFECT__EFFECT);

		specialEffectEClass = createEClass(SPECIAL_EFFECT);
		createEReference(specialEffectEClass, SPECIAL_EFFECT__SHADER);
		createEReference(specialEffectEClass, SPECIAL_EFFECT__INPUTS);
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
		ResourcePackage theResourcePackage = (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		InferencePackage theInferencePackage = (InferencePackage)EPackage.Registry.INSTANCE.getEPackage(InferencePackage.eNS_URI);
		VariablePackage theVariablePackage = (VariablePackage)EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		iApplicationExtensionEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		iCompositorEClass.getESuperTypes().add(theInferencePackage.getIInferenceObject());
		genericScenePartEClass.getESuperTypes().add(this.getICompositor());
		genericScenePartEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		backgroundImageEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		backgroundImageEClass.getESuperTypes().add(this.getICompositor());
		screenEffectEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		screenEffectEClass.getESuperTypes().add(this.getICompositor());
		specialEffectEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		specialEffectEClass.getESuperTypes().add(theResourcePackage.getIRootResource());

		// Initialize classes, features, and operations; add parameters
		initEClass(applicationEClass, Application.class, "Application", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplication_Engines(), this.getIEngine(), null, "engines", null, 0, -1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplication_Run(), ecorePackage.getEBoolean(), "run", "true", 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplication_Title(), ecorePackage.getEString(), "title", "Vulkan Application", 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplication_Scene(), this.getScene(), null, "scene", null, 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplication_TimeConfiguration(), this.getTimeConfiguration(), null, "timeConfiguration", null, 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplication_ExtensionPkg(), this.getApplicationExtensionPkg(), null, "extensionPkg", null, 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplication_Models(), this.getIModel(), null, "models", null, 0, -1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplication_ResourcePkg(), theResourcePackage.getResourcePkg(), null, "resourcePkg", null, 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplication_Version(), ecorePackage.getEString(), "version", "0.0.0", 1, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iApplicationExtensionEClass, IApplicationExtension.class, "IApplicationExtension", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(applicationExtensionPkgEClass, ApplicationExtensionPkg.class, "ApplicationExtensionPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplicationExtensionPkg_Extensions(), this.getIApplicationExtension(), null, "extensions", null, 0, -1, ApplicationExtensionPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeConfigurationEClass, TimeConfiguration.class, "TimeConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeConfiguration_TimeStep(), ecorePackage.getELong(), "timeStep", "1", 1, 1, TimeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeConfiguration_Unit(), theTypesPackage.getETimeUnit(), "unit", "SECONDS", 1, 1, TimeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeConfiguration_TimeFactor(), ecorePackage.getEDouble(), "timeFactor", "1", 1, 1, TimeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iEngineEClass, IEngine.class, "IEngine", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iModelEClass, IModel.class, "IModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iCompositorEClass, ICompositor.class, "ICompositor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getICompositor_ExtensionPkg(), this.getCompositorExtensionPkg(), null, "extensionPkg", null, 0, 1, ICompositor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getICompositor_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 1, 1, ICompositor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositorExtensionPkgEClass, CompositorExtensionPkg.class, "CompositorExtensionPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositorExtensionPkg_Extensions(), this.getICompositorExtension(), null, "extensions", null, 0, -1, CompositorExtensionPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iCompositorExtensionEClass, ICompositorExtension.class, "ICompositorExtension", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iCadenceEClass, ICadence.class, "ICadence", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sceneEClass, Scene.class, "Scene", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScene_Compositors(), this.getICompositor(), null, "compositors", null, 0, -1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScene_Fullscreen(), ecorePackage.getEBoolean(), "fullscreen", "false", 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScene_Resizeable(), ecorePackage.getEBoolean(), "resizeable", "false", 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScene_Size(), theTypesPackage.getVector2i(), "size", "400,400", 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScene_ResourcePkg(), theResourcePackage.getResourcePkg(), null, "resourcePkg", null, 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genericScenePartEClass, GenericScenePart.class, "GenericScenePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(backgroundImageEClass, BackgroundImage.class, "BackgroundImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBackgroundImage_ClearColor(), theTypesPackage.getVector3i(), "clearColor", "0;0;0", 1, 1, BackgroundImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBackgroundImage_Sampling(), theResourcePackage.getESampling(), "sampling", null, 1, 1, BackgroundImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBackgroundImage_SrcImage(), theResourcePackage.getIImage(), null, "srcImage", null, 0, 1, BackgroundImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBackgroundImage_DstImage(), theResourcePackage.getIImage(), null, "dstImage", null, 0, 1, BackgroundImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(screenEffectEClass, ScreenEffect.class, "ScreenEffect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScreenEffect_SrcImage(), theResourcePackage.getIImage(), null, "srcImage", null, 0, 1, ScreenEffect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScreenEffect_DstImage(), theResourcePackage.getIImage(), null, "dstImage", null, 1, 1, ScreenEffect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScreenEffect_Effect(), this.getSpecialEffect(), null, "effect", null, 0, 1, ScreenEffect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specialEffectEClass, SpecialEffect.class, "SpecialEffect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecialEffect_Shader(), theResourcePackage.getFileResource(), null, "shader", null, 0, 1, SpecialEffect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecialEffect_Inputs(), theVariablePackage.getIModelVariable(), null, "inputs", null, 0, -1, SpecialEffect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ApplicationPackageImpl
