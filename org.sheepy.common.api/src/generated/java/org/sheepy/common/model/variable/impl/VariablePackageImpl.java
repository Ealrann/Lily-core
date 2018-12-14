/**
 */
package org.sheepy.common.model.variable.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.common.api.util.ResolvedVariableFeature;

import org.sheepy.common.model.action.ActionPackage;

import org.sheepy.common.model.inference.InferencePackage;

import org.sheepy.common.model.resolver.ResolverPackage;

import org.sheepy.common.model.root.RootPackage;

import org.sheepy.common.model.types.TypesPackage;

import org.sheepy.common.model.variable.BooleanChangeAction;
import org.sheepy.common.model.variable.IncrementAction;
import org.sheepy.common.model.variable.SetBoolean;
import org.sheepy.common.model.variable.SetNumber;
import org.sheepy.common.model.variable.SetString;
import org.sheepy.common.model.variable.VarChangeAction;
import org.sheepy.common.model.variable.VarChangeActionPkg;
import org.sheepy.common.model.variable.VariableFactory;
import org.sheepy.common.model.variable.VariablePackage;
import org.sheepy.common.model.variable.VariableResolver;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VariablePackageImpl extends EPackageImpl implements VariablePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableResolverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varChangeActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanChangeActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varChangeActionPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass incrementActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setBooleanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lResolvedVariableFeatureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType variableDefinitionEDataType = null;

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
	 * @see org.sheepy.common.model.variable.VariablePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VariablePackageImpl()
	{
		super(eNS_URI, VariableFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link VariablePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VariablePackage init()
	{
		if (isInited) return (VariablePackage)EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredVariablePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		VariablePackageImpl theVariablePackage = registeredVariablePackage instanceof VariablePackageImpl ? (VariablePackageImpl)registeredVariablePackage : new VariablePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ResolverPackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		RootPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theVariablePackage.createPackageContents();

		// Initialize created meta-data
		theVariablePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVariablePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VariablePackage.eNS_URI, theVariablePackage);
		return theVariablePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableResolver()
	{
		return variableResolverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableResolver_Resolver()
	{
		return (EReference)variableResolverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableResolver_VariableDefinition()
	{
		return (EAttribute)variableResolverEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableResolver_EmfAttributes()
	{
		return (EAttribute)variableResolverEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVariableResolver__LEMFAttributes()
	{
		return variableResolverEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVarChangeAction()
	{
		return varChangeActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVarChangeAction_VariableResolver()
	{
		return (EReference)varChangeActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanChangeAction()
	{
		return booleanChangeActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVarChangeActionPkg()
	{
		return varChangeActionPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVarChangeActionPkg_Actions()
	{
		return (EReference)varChangeActionPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIncrementAction()
	{
		return incrementActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncrementAction_Increment()
	{
		return (EAttribute)incrementActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetString()
	{
		return setStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetBoolean()
	{
		return setBooleanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetNumber()
	{
		return setNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLResolvedVariableFeature()
	{
		return lResolvedVariableFeatureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVariableDefinition()
	{
		return variableDefinitionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableFactory getVariableFactory()
	{
		return (VariableFactory)getEFactoryInstance();
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
		variableResolverEClass = createEClass(VARIABLE_RESOLVER);
		createEReference(variableResolverEClass, VARIABLE_RESOLVER__RESOLVER);
		createEAttribute(variableResolverEClass, VARIABLE_RESOLVER__VARIABLE_DEFINITION);
		createEAttribute(variableResolverEClass, VARIABLE_RESOLVER__EMF_ATTRIBUTES);
		createEOperation(variableResolverEClass, VARIABLE_RESOLVER___LEMF_ATTRIBUTES);

		varChangeActionEClass = createEClass(VAR_CHANGE_ACTION);
		createEReference(varChangeActionEClass, VAR_CHANGE_ACTION__VARIABLE_RESOLVER);

		booleanChangeActionEClass = createEClass(BOOLEAN_CHANGE_ACTION);

		varChangeActionPkgEClass = createEClass(VAR_CHANGE_ACTION_PKG);
		createEReference(varChangeActionPkgEClass, VAR_CHANGE_ACTION_PKG__ACTIONS);

		incrementActionEClass = createEClass(INCREMENT_ACTION);
		createEAttribute(incrementActionEClass, INCREMENT_ACTION__INCREMENT);

		setStringEClass = createEClass(SET_STRING);

		setBooleanEClass = createEClass(SET_BOOLEAN);

		setNumberEClass = createEClass(SET_NUMBER);

		// Create data types
		lResolvedVariableFeatureEDataType = createEDataType(LRESOLVED_VARIABLE_FEATURE);
		variableDefinitionEDataType = createEDataType(VARIABLE_DEFINITION);
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
		ResolverPackage theResolverPackage = (ResolverPackage)EPackage.Registry.INSTANCE.getEPackage(ResolverPackage.eNS_URI);
		ActionPackage theActionPackage = (ActionPackage)EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		varChangeActionEClass.getESuperTypes().add(theActionPackage.getAction());
		booleanChangeActionEClass.getESuperTypes().add(this.getVarChangeAction());
		booleanChangeActionEClass.getESuperTypes().add(theActionPackage.getAction());
		EGenericType g1 = createEGenericType(theActionPackage.getParameteredAction());
		EGenericType g2 = createEGenericType(theTypesPackage.getFloatParameter());
		g1.getETypeArguments().add(g2);
		incrementActionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getVarChangeAction());
		incrementActionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theActionPackage.getParameteredAction());
		g2 = createEGenericType(theTypesPackage.getStringParameter());
		g1.getETypeArguments().add(g2);
		setStringEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getVarChangeAction());
		setStringEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theActionPackage.getParameteredAction());
		g2 = createEGenericType(theTypesPackage.getBooleanParameter());
		g1.getETypeArguments().add(g2);
		setBooleanEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getVarChangeAction());
		setBooleanEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theActionPackage.getParameteredAction());
		g2 = createEGenericType(theTypesPackage.getFloatParameter());
		g1.getETypeArguments().add(g2);
		setNumberEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getVarChangeAction());
		setNumberEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(variableResolverEClass, VariableResolver.class, "VariableResolver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableResolver_Resolver(), theResolverPackage.getILObjectResolver(), null, "resolver", null, 0, 1, VariableResolver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableResolver_VariableDefinition(), this.getVariableDefinition(), "variableDefinition", null, 0, 1, VariableResolver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableResolver_EmfAttributes(), this.getLResolvedVariableFeature(), "emfAttributes", null, 0, 1, VariableResolver.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getVariableResolver__LEMFAttributes(), this.getLResolvedVariableFeature(), "lEMFAttributes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(varChangeActionEClass, VarChangeAction.class, "VarChangeAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarChangeAction_VariableResolver(), this.getVariableResolver(), null, "variableResolver", null, 0, 1, VarChangeAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanChangeActionEClass, BooleanChangeAction.class, "BooleanChangeAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(varChangeActionPkgEClass, VarChangeActionPkg.class, "VarChangeActionPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarChangeActionPkg_Actions(), this.getVarChangeAction(), null, "actions", null, 0, -1, VarChangeActionPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(incrementActionEClass, IncrementAction.class, "IncrementAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIncrementAction_Increment(), theEcorePackage.getEInt(), "increment", "1", 0, 1, IncrementAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setStringEClass, SetString.class, "SetString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setBooleanEClass, SetBoolean.class, "SetBoolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setNumberEClass, SetNumber.class, "SetNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(lResolvedVariableFeatureEDataType, ResolvedVariableFeature.class, "LResolvedVariableFeature", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(variableDefinitionEDataType, String.class, "VariableDefinition", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //VariablePackageImpl
