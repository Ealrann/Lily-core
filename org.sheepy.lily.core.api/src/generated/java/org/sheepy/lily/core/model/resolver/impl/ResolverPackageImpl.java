/**
 */
package org.sheepy.lily.core.model.resolver.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.resolver.ChainResolver;
import org.sheepy.lily.core.model.resolver.EReferenceResolver;
import org.sheepy.lily.core.model.resolver.ILObjectResolver;
import org.sheepy.lily.core.model.resolver.ResolverFactory;
import org.sheepy.lily.core.model.resolver.ResolverPackage;

import org.sheepy.lily.core.model.root.RootPackage;

import org.sheepy.lily.core.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResolverPackageImpl extends EPackageImpl implements ResolverPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ilObjectResolverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eReferenceResolverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass chainResolverEClass = null;

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
	 * @see org.sheepy.lily.core.model.resolver.ResolverPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ResolverPackageImpl()
	{
		super(eNS_URI, ResolverFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ResolverPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ResolverPackage init()
	{
		if (isInited) return (ResolverPackage)EPackage.Registry.INSTANCE.getEPackage(ResolverPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredResolverPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ResolverPackageImpl theResolverPackage = registeredResolverPackage instanceof ResolverPackageImpl ? (ResolverPackageImpl)registeredResolverPackage : new ResolverPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		RootPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theResolverPackage.createPackageContents();

		// Initialize created meta-data
		theResolverPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theResolverPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ResolverPackage.eNS_URI, theResolverPackage);
		return theResolverPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getILObjectResolver()
	{
		return ilObjectResolverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getILObjectResolver__CollectUnits__LObject_Collection()
	{
		return ilObjectResolverEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEReferenceResolver()
	{
		return eReferenceResolverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEReferenceResolver_ReferenceName()
	{
		return (EAttribute)eReferenceResolverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEReferenceResolver_ClassName()
	{
		return (EAttribute)eReferenceResolverEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEReferenceResolver_InternalReference()
	{
		return (EReference)eReferenceResolverEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEReferenceResolver__CollectUnits__LObject_Collection()
	{
		return eReferenceResolverEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getChainResolver()
	{
		return chainResolverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getChainResolver_Resolvers()
	{
		return (EReference)chainResolverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getChainResolver__CollectUnits__LObject_Collection()
	{
		return chainResolverEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResolverFactory getResolverFactory()
	{
		return (ResolverFactory)getEFactoryInstance();
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
		ilObjectResolverEClass = createEClass(IL_OBJECT_RESOLVER);
		createEOperation(ilObjectResolverEClass, IL_OBJECT_RESOLVER___COLLECT_UNITS__LOBJECT_COLLECTION);

		eReferenceResolverEClass = createEClass(EREFERENCE_RESOLVER);
		createEAttribute(eReferenceResolverEClass, EREFERENCE_RESOLVER__REFERENCE_NAME);
		createEAttribute(eReferenceResolverEClass, EREFERENCE_RESOLVER__CLASS_NAME);
		createEReference(eReferenceResolverEClass, EREFERENCE_RESOLVER__INTERNAL_REFERENCE);
		createEOperation(eReferenceResolverEClass, EREFERENCE_RESOLVER___COLLECT_UNITS__LOBJECT_COLLECTION);

		chainResolverEClass = createEClass(CHAIN_RESOLVER);
		createEReference(chainResolverEClass, CHAIN_RESOLVER__RESOLVERS);
		createEOperation(chainResolverEClass, CHAIN_RESOLVER___COLLECT_UNITS__LOBJECT_COLLECTION);
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
		RootPackage theRootPackage = (RootPackage)EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eReferenceResolverEClass.getESuperTypes().add(this.getILObjectResolver());
		chainResolverEClass.getESuperTypes().add(this.getILObjectResolver());

		// Initialize classes, features, and operations; add parameters
		initEClass(ilObjectResolverEClass, ILObjectResolver.class, "ILObjectResolver", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getILObjectResolver__CollectUnits__LObject_Collection(), null, "collectUnits", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRootPackage.getLObject(), "source", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRootPackage.getLCollection(), "collected", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(eReferenceResolverEClass, EReferenceResolver.class, "EReferenceResolver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEReferenceResolver_ReferenceName(), theEcorePackage.getEString(), "referenceName", null, 0, 1, EReferenceResolver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEReferenceResolver_ClassName(), theEcorePackage.getEString(), "className", null, 0, 1, EReferenceResolver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEReferenceResolver_InternalReference(), theEcorePackage.getEReference(), null, "internalReference", null, 0, 1, EReferenceResolver.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getEReferenceResolver__CollectUnits__LObject_Collection(), null, "collectUnits", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRootPackage.getLObject(), "source", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRootPackage.getLCollection(), "collected", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(chainResolverEClass, ChainResolver.class, "ChainResolver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChainResolver_Resolvers(), this.getILObjectResolver(), null, "resolvers", null, 0, -1, ChainResolver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getChainResolver__CollectUnits__LObject_Collection(), null, "collectUnits", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRootPackage.getLObject(), "source", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRootPackage.getLCollection(), "collected", 0, 1, !IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ResolverPackageImpl
