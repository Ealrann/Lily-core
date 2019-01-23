/**
 */
package org.sheepy.lily.core.model.root.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.sheepy.lily.core.api.util.LTreeIterator;
import org.sheepy.lily.core.model.action.ActionPackage;
import org.sheepy.lily.core.model.inference.InferencePackage;
import org.sheepy.lily.core.model.root.LObject;
import org.sheepy.lily.core.model.root.RootFactory;
import org.sheepy.lily.core.model.root.RootPackage;
import org.sheepy.lily.core.model.root.XAction;
import org.sheepy.lily.core.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RootPackageImpl extends EPackageImpl implements RootPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lContentListEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lTreeIteratorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lCollectionEDataType = null;

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
	 * @see org.sheepy.lily.core.model.root.RootPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RootPackageImpl()
	{
		super(eNS_URI, RootFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RootPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RootPackage init()
	{
		if (isInited) return (RootPackage)EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredRootPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		RootPackageImpl theRootPackage = registeredRootPackage instanceof RootPackageImpl ? (RootPackageImpl)registeredRootPackage : new RootPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		InferencePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRootPackage.createPackageContents();

		// Initialize created meta-data
		theRootPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRootPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RootPackage.eNS_URI, theRootPackage);
		return theRootPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLObject()
	{
		return lObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLObject_ContentObjects()
	{
		return (EAttribute)lObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getLObject__CreateContainmentEList__EClass()
	{
		return lObjectEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getLObject__LContents()
	{
		return lObjectEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getLObject__LParent()
	{
		return lObjectEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getLObject__LAllContents()
	{
		return lObjectEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXAction()
	{
		return xActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getXAction__Execute__LObject()
	{
		return xActionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getLContentList()
	{
		return lContentListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getLTreeIterator()
	{
		return lTreeIteratorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getLCollection()
	{
		return lCollectionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RootFactory getRootFactory()
	{
		return (RootFactory)getEFactoryInstance();
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
		lObjectEClass = createEClass(LOBJECT);
		createEAttribute(lObjectEClass, LOBJECT__CONTENT_OBJECTS);
		createEOperation(lObjectEClass, LOBJECT___CREATE_CONTAINMENT_ELIST__ECLASS);
		createEOperation(lObjectEClass, LOBJECT___LCONTENTS);
		createEOperation(lObjectEClass, LOBJECT___LPARENT);
		createEOperation(lObjectEClass, LOBJECT___LALL_CONTENTS);

		xActionEClass = createEClass(XACTION);
		createEOperation(xActionEClass, XACTION___EXECUTE__LOBJECT);

		// Create data types
		lContentListEDataType = createEDataType(LCONTENT_LIST);
		lTreeIteratorEDataType = createEDataType(LTREE_ITERATOR);
		lCollectionEDataType = createEDataType(LCOLLECTION);
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
		InferencePackage theInferencePackage = (InferencePackage)EPackage.Registry.INSTANCE.getEPackage(InferencePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ActionPackage theActionPackage = (ActionPackage)EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		lObjectEClass.getESuperTypes().add(theInferencePackage.getIInferenceObject());
		xActionEClass.getESuperTypes().add(theActionPackage.getAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(lObjectEClass, LObject.class, "LObject", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLObject_ContentObjects(), this.getLContentList(), "contentObjects", null, 0, 1, LObject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getLObject__CreateContainmentEList__EClass(), null, "createContainmentEList", 0, -1, !IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "T");
		EGenericType g1 = createEGenericType(this.getLObject());
		t1.getEBounds().add(g1);
		addEParameter(op, theEcorePackage.getEClass(), "targetEClass", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEOperation(getLObject__LContents(), this.getLObject(), "lContents", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getLObject__LParent(), this.getLObject(), "lParent", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getLObject__LAllContents(), this.getLTreeIterator(), "lAllContents", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(xActionEClass, XAction.class, "XAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getXAction__Execute__LObject(), null, "execute", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(lContentListEDataType, EList.class, "LContentList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "org.eclipse.emf.common.util.EList<org.sheepy.lily.core.model.root.LObject>");
		initEDataType(lTreeIteratorEDataType, LTreeIterator.class, "LTreeIterator", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lCollectionEDataType, Collection.class, "LCollection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Collection<org.sheepy.lily.core.model.root.LObject>");

		// Create resource
		createResource(eNS_URI);
	}

} //RootPackageImpl
