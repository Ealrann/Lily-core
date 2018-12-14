/**
 */
package org.sheepy.common.model.action.impl;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.common.model.action.Action;
import org.sheepy.common.model.action.ActionFactory;
import org.sheepy.common.model.action.ActionPackage;
import org.sheepy.common.model.action.ActionsPkg;
import org.sheepy.common.model.action.NumberInjector;
import org.sheepy.common.model.action.ParameteredAction;
import org.sheepy.common.model.action.ParameteredActionsPkg;
import org.sheepy.common.model.action.StringInjector;
import org.sheepy.common.model.action.TypeInjectorAction;
import org.sheepy.common.model.action.XAction;

import org.sheepy.common.model.inference.InferencePackage;

import org.sheepy.common.model.inference.impl.InferencePackageImpl;

import org.sheepy.common.model.root.RootPackage;

import org.sheepy.common.model.root.impl.RootPackageImpl;

import org.sheepy.common.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionPackageImpl extends EPackageImpl implements ActionPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

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
	private EClass parameteredActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeInjectorActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringInjectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberInjectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameteredActionsPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionsPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType actionListEDataType = null;

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
	 * @see org.sheepy.common.model.action.ActionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ActionPackageImpl()
	{
		super(eNS_URI, ActionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ActionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ActionPackage init()
	{
		if (isInited) return (ActionPackage)EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredActionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ActionPackageImpl theActionPackage = registeredActionPackage instanceof ActionPackageImpl ? (ActionPackageImpl)registeredActionPackage : new ActionPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI);
		RootPackageImpl theRootPackage = (RootPackageImpl)(registeredPackage instanceof RootPackageImpl ? registeredPackage : RootPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InferencePackage.eNS_URI);
		InferencePackageImpl theInferencePackage = (InferencePackageImpl)(registeredPackage instanceof InferencePackageImpl ? registeredPackage : InferencePackage.eINSTANCE);

		// Create package meta-data objects
		theActionPackage.createPackageContents();
		theRootPackage.createPackageContents();
		theInferencePackage.createPackageContents();

		// Initialize created meta-data
		theActionPackage.initializePackageContents();
		theRootPackage.initializePackageContents();
		theInferencePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActionPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ActionPackage.eNS_URI, theActionPackage);
		return theActionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction()
	{
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAction()
	{
		return xActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getXAction__Execute__LObject()
	{
		return xActionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameteredAction()
	{
		return parameteredActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeInjectorAction()
	{
		return typeInjectorActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeInjectorAction_Action()
	{
		return (EReference)typeInjectorActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeInjectorAction__GetInjectedValue()
	{
		return typeInjectorActionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringInjector()
	{
		return stringInjectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringInjector_Value()
	{
		return (EAttribute)stringInjectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStringInjector__GetInjectedValue()
	{
		return stringInjectorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberInjector()
	{
		return numberInjectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberInjector_Value()
	{
		return (EAttribute)numberInjectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNumberInjector__GetInjectedValue()
	{
		return numberInjectorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameteredActionsPkg()
	{
		return parameteredActionsPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameteredActionsPkg_Actions()
	{
		return (EReference)parameteredActionsPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getParameteredActionsPkg__GetParameterClassifier()
	{
		return parameteredActionsPkgEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionsPkg()
	{
		return actionsPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionsPkg_Actions()
	{
		return (EReference)actionsPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getActionList()
	{
		return actionListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionFactory getActionFactory()
	{
		return (ActionFactory)getEFactoryInstance();
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
		actionEClass = createEClass(ACTION);

		xActionEClass = createEClass(XACTION);
		createEOperation(xActionEClass, XACTION___EXECUTE__LOBJECT);

		parameteredActionEClass = createEClass(PARAMETERED_ACTION);

		typeInjectorActionEClass = createEClass(TYPE_INJECTOR_ACTION);
		createEReference(typeInjectorActionEClass, TYPE_INJECTOR_ACTION__ACTION);
		createEOperation(typeInjectorActionEClass, TYPE_INJECTOR_ACTION___GET_INJECTED_VALUE);

		stringInjectorEClass = createEClass(STRING_INJECTOR);
		createEAttribute(stringInjectorEClass, STRING_INJECTOR__VALUE);
		createEOperation(stringInjectorEClass, STRING_INJECTOR___GET_INJECTED_VALUE);

		numberInjectorEClass = createEClass(NUMBER_INJECTOR);
		createEAttribute(numberInjectorEClass, NUMBER_INJECTOR__VALUE);
		createEOperation(numberInjectorEClass, NUMBER_INJECTOR___GET_INJECTED_VALUE);

		parameteredActionsPkgEClass = createEClass(PARAMETERED_ACTIONS_PKG);
		createEReference(parameteredActionsPkgEClass, PARAMETERED_ACTIONS_PKG__ACTIONS);
		createEOperation(parameteredActionsPkgEClass, PARAMETERED_ACTIONS_PKG___GET_PARAMETER_CLASSIFIER);

		actionsPkgEClass = createEClass(ACTIONS_PKG);
		createEReference(actionsPkgEClass, ACTIONS_PKG__ACTIONS);

		// Create data types
		actionListEDataType = createEDataType(ACTION_LIST);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters
		ETypeParameter parameteredActionEClass_T = addETypeParameter(parameteredActionEClass, "T");
		ETypeParameter typeInjectorActionEClass_T = addETypeParameter(typeInjectorActionEClass, "T");
		ETypeParameter parameteredActionsPkgEClass_T = addETypeParameter(parameteredActionsPkgEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(theTypesPackage.getParameter());
		parameteredActionEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theTypesPackage.getParameter());
		typeInjectorActionEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theTypesPackage.getParameter());
		parameteredActionsPkgEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		actionEClass.getESuperTypes().add(theRootPackage.getLNamedElement());
		xActionEClass.getESuperTypes().add(this.getAction());
		parameteredActionEClass.getESuperTypes().add(this.getAction());
		typeInjectorActionEClass.getESuperTypes().add(this.getAction());
		g1 = createEGenericType(this.getTypeInjectorAction());
		EGenericType g2 = createEGenericType(theTypesPackage.getStringParameter());
		g1.getETypeArguments().add(g2);
		stringInjectorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTypeInjectorAction());
		g2 = createEGenericType(theTypesPackage.getFloatParameter());
		g1.getETypeArguments().add(g2);
		numberInjectorEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xActionEClass, XAction.class, "XAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getXAction__Execute__LObject(), null, "execute", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRootPackage.getLObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(parameteredActionEClass, ParameteredAction.class, "ParameteredAction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeInjectorActionEClass, TypeInjectorAction.class, "TypeInjectorAction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getParameteredAction());
		g2 = createEGenericType(typeInjectorActionEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getTypeInjectorAction_Action(), g1, null, "action", null, 0, 1, TypeInjectorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTypeInjectorAction__GetInjectedValue(), null, "getInjectedValue", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(typeInjectorActionEClass_T);
		initEOperation(op, g1);

		initEClass(stringInjectorEClass, StringInjector.class, "StringInjector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringInjector_Value(), theEcorePackage.getEString(), "value", null, 0, 1, StringInjector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getStringInjector__GetInjectedValue(), theTypesPackage.getStringParameter(), "getInjectedValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(numberInjectorEClass, NumberInjector.class, "NumberInjector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumberInjector_Value(), theEcorePackage.getEFloat(), "value", null, 0, 1, NumberInjector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getNumberInjector__GetInjectedValue(), theTypesPackage.getFloatParameter(), "getInjectedValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(parameteredActionsPkgEClass, ParameteredActionsPkg.class, "ParameteredActionsPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getParameteredAction());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getParameteredActionsPkg_Actions(), g1, null, "actions", null, 0, -1, ParameteredActionsPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getParameteredActionsPkg__GetParameterClassifier(), theEcorePackage.getEClass(), "getParameterClassifier", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(actionsPkgEClass, ActionsPkg.class, "ActionsPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionsPkg_Actions(), this.getAction(), null, "actions", null, 0, -1, ActionsPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(actionListEDataType, List.class, "ActionList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<? extends org.sheepy.common.model.action.Action>");

		// Create resource
		createResource(eNS_URI);
	}

} //ActionPackageImpl
