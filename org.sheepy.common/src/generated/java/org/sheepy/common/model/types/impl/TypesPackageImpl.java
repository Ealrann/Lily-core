/**
 */
package org.sheepy.common.model.types.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.common.api.adapter.AdapterIndexer;

import org.sheepy.common.api.types.SVector2f;
import org.sheepy.common.api.types.SVector2i;

import org.sheepy.common.model.types.SObject;
import org.sheepy.common.model.types.TypesFactory;
import org.sheepy.common.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesPackageImpl extends EPackageImpl implements TypesPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sAdapterIndexerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sVector2fEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sVector2iEDataType = null;

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
	 * @see org.sheepy.common.model.types.TypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypesPackageImpl()
	{
		super(eNS_URI, TypesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypesPackage init()
	{
		if (isInited) return (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTypesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TypesPackageImpl theTypesPackage = registeredTypesPackage instanceof TypesPackageImpl ? (TypesPackageImpl)registeredTypesPackage : new TypesPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTypesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, theTypesPackage);
		return theTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSObject()
	{
		return sObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSObject_AdapterIndexer()
	{
		return (EAttribute)sObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSObject__LAdapterIndexer()
	{
		return sObjectEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSAdapterIndexer()
	{
		return sAdapterIndexerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSVector2f()
	{
		return sVector2fEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSVector2i()
	{
		return sVector2iEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactory getTypesFactory()
	{
		return (TypesFactory)getEFactoryInstance();
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
		sObjectEClass = createEClass(SOBJECT);
		createEAttribute(sObjectEClass, SOBJECT__ADAPTER_INDEXER);
		createEOperation(sObjectEClass, SOBJECT___LADAPTER_INDEXER);

		// Create data types
		sAdapterIndexerEDataType = createEDataType(SADAPTER_INDEXER);
		sVector2fEDataType = createEDataType(SVECTOR2F);
		sVector2iEDataType = createEDataType(SVECTOR2I);
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

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(sObjectEClass, SObject.class, "SObject", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSObject_AdapterIndexer(), this.getSAdapterIndexer(), "adapterIndexer", null, 0, 1, SObject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSObject__LAdapterIndexer(), this.getSAdapterIndexer(), "lAdapterIndexer", 0, 1, !IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(sAdapterIndexerEDataType, AdapterIndexer.class, "SAdapterIndexer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(sVector2fEDataType, SVector2f.class, "SVector2f", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(sVector2iEDataType, SVector2i.class, "SVector2i", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TypesPackageImpl
