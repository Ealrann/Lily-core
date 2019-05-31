/**
 */
package org.sheepy.lily.core.model.maintainer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.maintainer.MaintainerFactory;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MaintainerPackageImpl extends EPackageImpl implements MaintainerPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass maintainableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass maintainerEClass = null;

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
	 * @see org.sheepy.lily.core.model.maintainer.MaintainerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MaintainerPackageImpl()
	{
		super(eNS_URI, MaintainerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MaintainerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MaintainerPackage init()
	{
		if (isInited) return (MaintainerPackage)EPackage.Registry.INSTANCE.getEPackage(MaintainerPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMaintainerPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MaintainerPackageImpl theMaintainerPackage = registeredMaintainerPackage instanceof MaintainerPackageImpl ? (MaintainerPackageImpl)registeredMaintainerPackage : new MaintainerPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theMaintainerPackage.createPackageContents();

		// Initialize created meta-data
		theMaintainerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMaintainerPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MaintainerPackage.eNS_URI, theMaintainerPackage);
		return theMaintainerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMaintainable()
	{
		return maintainableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMaintainable_Builder()
	{
		return (EReference)maintainableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMaintainer()
	{
		return maintainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MaintainerFactory getMaintainerFactory()
	{
		return (MaintainerFactory)getEFactoryInstance();
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
		maintainableEClass = createEClass(MAINTAINABLE);
		createEReference(maintainableEClass, MAINTAINABLE__BUILDER);

		maintainerEClass = createEClass(MAINTAINER);
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

		// Create type parameters
		ETypeParameter maintainableEClass_T = addETypeParameter(maintainableEClass, "T");
		ETypeParameter maintainerEClass_T = addETypeParameter(maintainerEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getMaintainable());
		EGenericType g2 = createEGenericType(maintainableEClass_T);
		g1.getETypeArguments().add(g2);
		maintainableEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getMaintainable());
		g2 = createEGenericType(maintainerEClass_T);
		g1.getETypeArguments().add(g2);
		maintainerEClass_T.getEBounds().add(g1);

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(maintainableEClass, Maintainable.class, "Maintainable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getMaintainer());
		g2 = createEGenericType(maintainableEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getMaintainable_Builder(), g1, null, "builder", null, 0, 1, Maintainable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(maintainerEClass, Maintainer.class, "Maintainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //MaintainerPackageImpl
