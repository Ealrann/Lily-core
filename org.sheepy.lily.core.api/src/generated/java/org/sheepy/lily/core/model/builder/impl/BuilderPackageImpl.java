/**
 */
package org.sheepy.lily.core.model.builder.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.builder.Buildable;
import org.sheepy.lily.core.model.builder.Builder;
import org.sheepy.lily.core.model.builder.BuilderFactory;
import org.sheepy.lily.core.model.builder.BuilderPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuilderPackageImpl extends EPackageImpl implements BuilderPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builderEClass = null;

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
	 * @see org.sheepy.lily.core.model.builder.BuilderPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BuilderPackageImpl()
	{
		super(eNS_URI, BuilderFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BuilderPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BuilderPackage init()
	{
		if (isInited) return (BuilderPackage)EPackage.Registry.INSTANCE.getEPackage(BuilderPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBuilderPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BuilderPackageImpl theBuilderPackage = registeredBuilderPackage instanceof BuilderPackageImpl ? (BuilderPackageImpl)registeredBuilderPackage : new BuilderPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theBuilderPackage.createPackageContents();

		// Initialize created meta-data
		theBuilderPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBuilderPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BuilderPackage.eNS_URI, theBuilderPackage);
		return theBuilderPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBuildable()
	{
		return buildableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBuildable_Builder()
	{
		return (EReference)buildableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBuilder()
	{
		return builderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BuilderFactory getBuilderFactory()
	{
		return (BuilderFactory)getEFactoryInstance();
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
		buildableEClass = createEClass(BUILDABLE);
		createEReference(buildableEClass, BUILDABLE__BUILDER);

		builderEClass = createEClass(BUILDER);
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
		ETypeParameter buildableEClass_T = addETypeParameter(buildableEClass, "T");
		ETypeParameter builderEClass_T = addETypeParameter(builderEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getBuildable());
		EGenericType g2 = createEGenericType(buildableEClass_T);
		g1.getETypeArguments().add(g2);
		buildableEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getBuildable());
		g2 = createEGenericType(builderEClass_T);
		g1.getETypeArguments().add(g2);
		builderEClass_T.getEBounds().add(g1);

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(buildableEClass, Buildable.class, "Buildable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getBuilder());
		g2 = createEGenericType(buildableEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getBuildable_Builder(), g1, null, "builder", null, 0, 1, Buildable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(builderEClass, Builder.class, "Builder", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //BuilderPackageImpl
