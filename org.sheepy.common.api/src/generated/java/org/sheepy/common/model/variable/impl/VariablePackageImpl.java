/**
 */
package org.sheepy.common.model.variable.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.sheepy.common.api.util.FeatureDefinition;
import org.sheepy.common.model.action.ActionPackage;

import org.sheepy.common.model.types.TypesPackage;

import org.sheepy.common.model.variable.AbstractVariableResolver;
import org.sheepy.common.model.variable.BooleanChangeAction;
import org.sheepy.common.model.variable.DirectVariableResolver;
import org.sheepy.common.model.variable.VarChangeAction;
import org.sheepy.common.model.variable.VarChangeActionPkg;
import org.sheepy.common.model.variable.VariableFactory;
import org.sheepy.common.model.variable.VariablePackage;

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
	private EClass abstractVariableResolverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directVariableResolverEClass = null;

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
		EcorePackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

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
	@Override
	public EClass getAbstractVariableResolver()
	{
		return abstractVariableResolverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractVariableResolver_VariableDefinition()
	{
		return (EAttribute)abstractVariableResolverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDirectVariableResolver()
	{
		return directVariableResolverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDirectVariableResolver_Target()
	{
		return (EReference)directVariableResolverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVarChangeAction()
	{
		return varChangeActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVarChangeAction_VariableResolver()
	{
		return (EReference)varChangeActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanChangeAction()
	{
		return booleanChangeActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVarChangeActionPkg()
	{
		return varChangeActionPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVarChangeActionPkg_Actions()
	{
		return (EReference)varChangeActionPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getLResolvedVariableFeature()
	{
		return lResolvedVariableFeatureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getVariableDefinition()
	{
		return variableDefinitionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		abstractVariableResolverEClass = createEClass(ABSTRACT_VARIABLE_RESOLVER);
		createEAttribute(abstractVariableResolverEClass, ABSTRACT_VARIABLE_RESOLVER__VARIABLE_DEFINITION);

		directVariableResolverEClass = createEClass(DIRECT_VARIABLE_RESOLVER);
		createEReference(directVariableResolverEClass, DIRECT_VARIABLE_RESOLVER__TARGET);

		varChangeActionEClass = createEClass(VAR_CHANGE_ACTION);
		createEReference(varChangeActionEClass, VAR_CHANGE_ACTION__VARIABLE_RESOLVER);

		booleanChangeActionEClass = createEClass(BOOLEAN_CHANGE_ACTION);

		varChangeActionPkgEClass = createEClass(VAR_CHANGE_ACTION_PKG);
		createEReference(varChangeActionPkgEClass, VAR_CHANGE_ACTION_PKG__ACTIONS);

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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ActionPackage theActionPackage = (ActionPackage)EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		directVariableResolverEClass.getESuperTypes().add(this.getAbstractVariableResolver());
		varChangeActionEClass.getESuperTypes().add(theActionPackage.getAction());
		booleanChangeActionEClass.getESuperTypes().add(this.getVarChangeAction());
		booleanChangeActionEClass.getESuperTypes().add(theActionPackage.getAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractVariableResolverEClass, AbstractVariableResolver.class, "AbstractVariableResolver", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractVariableResolver_VariableDefinition(), this.getVariableDefinition(), "variableDefinition", null, 0, 1, AbstractVariableResolver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(directVariableResolverEClass, DirectVariableResolver.class, "DirectVariableResolver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDirectVariableResolver_Target(), theEcorePackage.getEObject(), null, "target", null, 0, 1, DirectVariableResolver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varChangeActionEClass, VarChangeAction.class, "VarChangeAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarChangeAction_VariableResolver(), this.getAbstractVariableResolver(), null, "variableResolver", null, 0, 1, VarChangeAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanChangeActionEClass, BooleanChangeAction.class, "BooleanChangeAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(varChangeActionPkgEClass, VarChangeActionPkg.class, "VarChangeActionPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarChangeActionPkg_Actions(), this.getVarChangeAction(), null, "actions", null, 0, -1, VarChangeActionPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(lResolvedVariableFeatureEDataType, FeatureDefinition.class, "LResolvedVariableFeature", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(variableDefinitionEDataType, String.class, "VariableDefinition", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //VariablePackageImpl
