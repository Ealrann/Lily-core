/**
 */
package org.sheepy.lily.core.model.resource.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.action.impl.ActionPackageImpl;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl;
import org.sheepy.lily.core.model.cadence.CadencePackage;

import org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl;

import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.inference.impl.InferencePackageImpl;

import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

import org.sheepy.lily.core.model.maintainer.impl.MaintainerPackageImpl;

import org.sheepy.lily.core.model.presentation.PresentationPackage;

import org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl;

import org.sheepy.lily.core.model.resource.AbstractModuleResource;
import org.sheepy.lily.core.model.resource.ESampling;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.resource.IResource;
import org.sheepy.lily.core.model.resource.LocalResource;
import org.sheepy.lily.core.model.resource.ModuleResource;
import org.sheepy.lily.core.model.resource.Music;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.core.model.resource.ResourcePkg;
import org.sheepy.lily.core.model.resource.Sound;

import org.sheepy.lily.core.model.resource.SoundContinuous;
import org.sheepy.lily.core.model.resource.StringModuleResource;
import org.sheepy.lily.core.model.resource.VirtualResource;
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
public class ResourcePackageImpl extends EPackageImpl implements ResourcePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass soundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass musicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass soundContinuousEClass = null;

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
	private EClass iImageEClass = null;

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
	 * @see org.sheepy.lily.core.model.resource.ResourcePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ResourcePackageImpl()
	{
		super(eNS_URI, ResourceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ResourcePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ResourcePackage init()
	{
		if (isInited) return (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredResourcePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ResourcePackageImpl theResourcePackage = registeredResourcePackage instanceof ResourcePackageImpl ? (ResourcePackageImpl)registeredResourcePackage : new ResourcePackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);
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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);
		ApplicationPackageImpl theApplicationPackage = (ApplicationPackageImpl)(registeredPackage instanceof ApplicationPackageImpl ? registeredPackage : ApplicationPackage.eINSTANCE);

		// Create package meta-data objects
		theResourcePackage.createPackageContents();
		theUiPackage.createPackageContents();
		theVariablePackage.createPackageContents();
		theTypesPackage.createPackageContents();
		thePresentationPackage.createPackageContents();
		theMaintainerPackage.createPackageContents();
		theInferencePackage.createPackageContents();
		theCadencePackage.createPackageContents();
		theActionPackage.createPackageContents();
		theApplicationPackage.createPackageContents();

		// Initialize created meta-data
		theResourcePackage.initializePackageContents();
		theUiPackage.initializePackageContents();
		theVariablePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		thePresentationPackage.initializePackageContents();
		theMaintainerPackage.initializePackageContents();
		theInferencePackage.initializePackageContents();
		theCadencePackage.initializePackageContents();
		theActionPackage.initializePackageContents();
		theApplicationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theResourcePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ResourcePackage.eNS_URI, theResourcePackage);
		return theResourcePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSound()
	{
		return soundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSound_File()
	{
		return (EReference)soundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMusic()
	{
		return musicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMusic_File()
	{
		return (EReference)musicEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSoundContinuous()
	{
		return soundContinuousEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSoundContinuous_AttackMs()
	{
		return (EAttribute)soundContinuousEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSoundContinuous_DecayMs()
	{
		return (EAttribute)soundContinuousEClass.getEStructuralFeatures().get(1);
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
	public EClass getIImage()
	{
		return iImageEClass;
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
	public ResourceFactory getResourceFactory()
	{
		return (ResourceFactory)getEFactoryInstance();
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
		soundEClass = createEClass(SOUND);
		createEReference(soundEClass, SOUND__FILE);

		musicEClass = createEClass(MUSIC);
		createEReference(musicEClass, MUSIC__FILE);

		soundContinuousEClass = createEClass(SOUND_CONTINUOUS);
		createEAttribute(soundContinuousEClass, SOUND_CONTINUOUS__ATTACK_MS);
		createEAttribute(soundContinuousEClass, SOUND_CONTINUOUS__DECAY_MS);

		resourcePkgEClass = createEClass(RESOURCE_PKG);
		createEReference(resourcePkgEClass, RESOURCE_PKG__RESOURCES);

		iResourceEClass = createEClass(IRESOURCE);

		iImageEClass = createEClass(IIMAGE);

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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		soundEClass.getESuperTypes().add(this.getIResource());
		musicEClass.getESuperTypes().add(this.getIResource());
		soundContinuousEClass.getESuperTypes().add(this.getSound());
		iResourceEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		iImageEClass.getESuperTypes().add(this.getIResource());
		virtualResourceEClass.getESuperTypes().add(this.getIResource());
		fileResourceEClass.getESuperTypes().add(this.getIResource());
		localResourceEClass.getESuperTypes().add(this.getFileResource());
		abstractModuleResourceEClass.getESuperTypes().add(this.getFileResource());
		moduleResourceEClass.getESuperTypes().add(this.getAbstractModuleResource());
		stringModuleResourceEClass.getESuperTypes().add(this.getAbstractModuleResource());

		// Initialize classes, features, and operations; add parameters
		initEClass(soundEClass, Sound.class, "Sound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSound_File(), this.getFileResource(), null, "file", null, 1, 1, Sound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(musicEClass, Music.class, "Music", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMusic_File(), this.getFileResource(), null, "file", null, 1, 1, Music.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(soundContinuousEClass, SoundContinuous.class, "SoundContinuous", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSoundContinuous_AttackMs(), ecorePackage.getEInt(), "attackMs", null, 1, 1, SoundContinuous.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSoundContinuous_DecayMs(), ecorePackage.getEInt(), "decayMs", null, 1, 1, SoundContinuous.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourcePkgEClass, ResourcePkg.class, "ResourcePkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourcePkg_Resources(), this.getIResource(), null, "resources", null, 0, -1, ResourcePkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iResourceEClass, IResource.class, "IResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iImageEClass, IImage.class, "IImage", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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

} //ResourcePackageImpl
