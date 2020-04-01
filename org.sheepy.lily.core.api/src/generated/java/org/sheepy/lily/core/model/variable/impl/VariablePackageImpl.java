/**
 */
package org.sheepy.lily.core.model.variable.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.api.util.FeatureDefinition;

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
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.types.impl.TypesPackageImpl;

import org.sheepy.lily.core.model.ui.UiPackage;

import org.sheepy.lily.core.model.ui.impl.UiPackageImpl;

import org.sheepy.lily.core.model.variable.AbstractDefinedVariableResolver;
import org.sheepy.lily.core.model.variable.BooleanChangeAction;
import org.sheepy.lily.core.model.variable.ChainResolver;
import org.sheepy.lily.core.model.variable.ChainVariableResolver;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.core.model.variable.DurationVariable;
import org.sheepy.lily.core.model.variable.FloatVariable;
import org.sheepy.lily.core.model.variable.IDefinitionContainer;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.IModelVariableAction;
import org.sheepy.lily.core.model.variable.IModelVariableActionContainer;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.core.model.variable.IntChangeAction;
import org.sheepy.lily.core.model.variable.IntVariable;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.core.model.variable.SetVariableAction;
import org.sheepy.lily.core.model.variable.VarChangeAction;
import org.sheepy.lily.core.model.variable.VarChangeActionPkg;
import org.sheepy.lily.core.model.variable.VariableFactory;
import org.sheepy.lily.core.model.variable.VariablePackage;
import org.sheepy.lily.core.model.variable.Vector3fVariable;

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
	private EClass iVariableResolverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDefinitionContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass chainVariableResolverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass chainResolverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractDefinedVariableResolverEClass = null;

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
	private EClass intChangeActionEClass = null;

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
	private EClass iModelVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelVariablePkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vector3fVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass durationVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iModelVariableActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iModelVariableActionContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setVariableActionEClass = null;

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
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#eNS_URI
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

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);
		ResourcePackageImpl theResourcePackage = (ResourcePackageImpl)(registeredPackage instanceof ResourcePackageImpl ? registeredPackage : ResourcePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);
		UiPackageImpl theUiPackage = (UiPackageImpl)(registeredPackage instanceof UiPackageImpl ? registeredPackage : UiPackage.eINSTANCE);
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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);
		ApplicationPackageImpl theApplicationPackage = (ApplicationPackageImpl)(registeredPackage instanceof ApplicationPackageImpl ? registeredPackage : ApplicationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);
		ActionPackageImpl theActionPackage = (ActionPackageImpl)(registeredPackage instanceof ActionPackageImpl ? registeredPackage : ActionPackage.eINSTANCE);

		// Create package meta-data objects
		theVariablePackage.createPackageContents();
		theResourcePackage.createPackageContents();
		theUiPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		thePresentationPackage.createPackageContents();
		theMaintainerPackage.createPackageContents();
		theInferencePackage.createPackageContents();
		theCadencePackage.createPackageContents();
		theApplicationPackage.createPackageContents();
		theActionPackage.createPackageContents();

		// Initialize created meta-data
		theVariablePackage.initializePackageContents();
		theResourcePackage.initializePackageContents();
		theUiPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		thePresentationPackage.initializePackageContents();
		theMaintainerPackage.initializePackageContents();
		theInferencePackage.initializePackageContents();
		theCadencePackage.initializePackageContents();
		theApplicationPackage.initializePackageContents();
		theActionPackage.initializePackageContents();

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
	public EClass getIVariableResolver()
	{
		return iVariableResolverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIDefinitionContainer()
	{
		return iDefinitionContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIDefinitionContainer_VariableDefinition()
	{
		return (EAttribute)iDefinitionContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getChainVariableResolver()
	{
		return chainVariableResolverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getChainVariableResolver_FirstResolver()
	{
		return (EReference)chainVariableResolverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getChainVariableResolver_SubResolvers()
	{
		return (EReference)chainVariableResolverEClass.getEStructuralFeatures().get(1);
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
	public EClass getAbstractDefinedVariableResolver()
	{
		return abstractDefinedVariableResolverEClass;
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
	public EClass getIntChangeAction()
	{
		return intChangeActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntChangeAction_Value()
	{
		return (EAttribute)intChangeActionEClass.getEStructuralFeatures().get(0);
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
	public EClass getIModelVariable()
	{
		return iModelVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModelVariablePkg()
	{
		return modelVariablePkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelVariablePkg_Variables()
	{
		return (EReference)modelVariablePkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntVariable()
	{
		return intVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntVariable_Value()
	{
		return (EAttribute)intVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFloatVariable()
	{
		return floatVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFloatVariable_Value()
	{
		return (EAttribute)floatVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVector3fVariable()
	{
		return vector3fVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVector3fVariable_Vector()
	{
		return (EAttribute)vector3fVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDurationVariable()
	{
		return durationVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIModelVariableAction()
	{
		return iModelVariableActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIModelVariableActionContainer()
	{
		return iModelVariableActionContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIModelVariableActionContainer_Actions()
	{
		return (EReference)iModelVariableActionContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSetVariableAction()
	{
		return setVariableActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetVariableAction_Value()
	{
		return (EAttribute)setVariableActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSetVariableAction_Variable()
	{
		return (EReference)setVariableActionEClass.getEStructuralFeatures().get(1);
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
		iVariableResolverEClass = createEClass(IVARIABLE_RESOLVER);

		iDefinitionContainerEClass = createEClass(IDEFINITION_CONTAINER);
		createEAttribute(iDefinitionContainerEClass, IDEFINITION_CONTAINER__VARIABLE_DEFINITION);

		chainVariableResolverEClass = createEClass(CHAIN_VARIABLE_RESOLVER);
		createEReference(chainVariableResolverEClass, CHAIN_VARIABLE_RESOLVER__FIRST_RESOLVER);
		createEReference(chainVariableResolverEClass, CHAIN_VARIABLE_RESOLVER__SUB_RESOLVERS);

		chainResolverEClass = createEClass(CHAIN_RESOLVER);

		abstractDefinedVariableResolverEClass = createEClass(ABSTRACT_DEFINED_VARIABLE_RESOLVER);

		directVariableResolverEClass = createEClass(DIRECT_VARIABLE_RESOLVER);
		createEReference(directVariableResolverEClass, DIRECT_VARIABLE_RESOLVER__TARGET);

		varChangeActionEClass = createEClass(VAR_CHANGE_ACTION);
		createEReference(varChangeActionEClass, VAR_CHANGE_ACTION__VARIABLE_RESOLVER);

		booleanChangeActionEClass = createEClass(BOOLEAN_CHANGE_ACTION);

		intChangeActionEClass = createEClass(INT_CHANGE_ACTION);
		createEAttribute(intChangeActionEClass, INT_CHANGE_ACTION__VALUE);

		varChangeActionPkgEClass = createEClass(VAR_CHANGE_ACTION_PKG);
		createEReference(varChangeActionPkgEClass, VAR_CHANGE_ACTION_PKG__ACTIONS);

		iModelVariableEClass = createEClass(IMODEL_VARIABLE);

		modelVariablePkgEClass = createEClass(MODEL_VARIABLE_PKG);
		createEReference(modelVariablePkgEClass, MODEL_VARIABLE_PKG__VARIABLES);

		intVariableEClass = createEClass(INT_VARIABLE);
		createEAttribute(intVariableEClass, INT_VARIABLE__VALUE);

		floatVariableEClass = createEClass(FLOAT_VARIABLE);
		createEAttribute(floatVariableEClass, FLOAT_VARIABLE__VALUE);

		vector3fVariableEClass = createEClass(VECTOR3F_VARIABLE);
		createEAttribute(vector3fVariableEClass, VECTOR3F_VARIABLE__VECTOR);

		durationVariableEClass = createEClass(DURATION_VARIABLE);

		iModelVariableActionEClass = createEClass(IMODEL_VARIABLE_ACTION);

		iModelVariableActionContainerEClass = createEClass(IMODEL_VARIABLE_ACTION_CONTAINER);
		createEReference(iModelVariableActionContainerEClass, IMODEL_VARIABLE_ACTION_CONTAINER__ACTIONS);

		setVariableActionEClass = createEClass(SET_VARIABLE_ACTION);
		createEAttribute(setVariableActionEClass, SET_VARIABLE_ACTION__VALUE);
		createEReference(setVariableActionEClass, SET_VARIABLE_ACTION__VARIABLE);

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
		ActionPackage theActionPackage = (ActionPackage)EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		chainVariableResolverEClass.getESuperTypes().add(this.getIVariableResolver());
		chainResolverEClass.getESuperTypes().add(this.getIDefinitionContainer());
		abstractDefinedVariableResolverEClass.getESuperTypes().add(this.getIVariableResolver());
		abstractDefinedVariableResolverEClass.getESuperTypes().add(this.getIDefinitionContainer());
		directVariableResolverEClass.getESuperTypes().add(this.getAbstractDefinedVariableResolver());
		varChangeActionEClass.getESuperTypes().add(theActionPackage.getAction());
		booleanChangeActionEClass.getESuperTypes().add(this.getVarChangeAction());
		intChangeActionEClass.getESuperTypes().add(this.getVarChangeAction());
		iModelVariableEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		intVariableEClass.getESuperTypes().add(this.getIModelVariable());
		floatVariableEClass.getESuperTypes().add(this.getIModelVariable());
		vector3fVariableEClass.getESuperTypes().add(this.getIModelVariable());
		durationVariableEClass.getESuperTypes().add(this.getIModelVariable());
		setVariableActionEClass.getESuperTypes().add(this.getIModelVariableAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(iVariableResolverEClass, IVariableResolver.class, "IVariableResolver", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iDefinitionContainerEClass, IDefinitionContainer.class, "IDefinitionContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIDefinitionContainer_VariableDefinition(), this.getVariableDefinition(), "variableDefinition", null, 1, 1, IDefinitionContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(chainVariableResolverEClass, ChainVariableResolver.class, "ChainVariableResolver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChainVariableResolver_FirstResolver(), this.getIVariableResolver(), null, "firstResolver", null, 1, 1, ChainVariableResolver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChainVariableResolver_SubResolvers(), this.getChainResolver(), null, "subResolvers", null, 1, -1, ChainVariableResolver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(chainResolverEClass, ChainResolver.class, "ChainResolver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractDefinedVariableResolverEClass, AbstractDefinedVariableResolver.class, "AbstractDefinedVariableResolver", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(directVariableResolverEClass, DirectVariableResolver.class, "DirectVariableResolver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDirectVariableResolver_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, DirectVariableResolver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varChangeActionEClass, VarChangeAction.class, "VarChangeAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarChangeAction_VariableResolver(), this.getAbstractDefinedVariableResolver(), null, "variableResolver", null, 1, 1, VarChangeAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanChangeActionEClass, BooleanChangeAction.class, "BooleanChangeAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intChangeActionEClass, IntChangeAction.class, "IntChangeAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntChangeAction_Value(), ecorePackage.getEInt(), "value", null, 1, 1, IntChangeAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varChangeActionPkgEClass, VarChangeActionPkg.class, "VarChangeActionPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarChangeActionPkg_Actions(), this.getVarChangeAction(), null, "actions", null, 0, -1, VarChangeActionPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iModelVariableEClass, IModelVariable.class, "IModelVariable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modelVariablePkgEClass, ModelVariablePkg.class, "ModelVariablePkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelVariablePkg_Variables(), this.getIModelVariable(), null, "variables", null, 0, -1, ModelVariablePkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intVariableEClass, IntVariable.class, "IntVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntVariable_Value(), ecorePackage.getEInt(), "value", null, 1, 1, IntVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(floatVariableEClass, FloatVariable.class, "FloatVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFloatVariable_Value(), ecorePackage.getEFloat(), "value", null, 1, 1, FloatVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vector3fVariableEClass, Vector3fVariable.class, "Vector3fVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVector3fVariable_Vector(), theTypesPackage.getVector3f(), "vector", null, 0, 1, Vector3fVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(durationVariableEClass, DurationVariable.class, "DurationVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iModelVariableActionEClass, IModelVariableAction.class, "IModelVariableAction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iModelVariableActionContainerEClass, IModelVariableActionContainer.class, "IModelVariableActionContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIModelVariableActionContainer_Actions(), this.getIModelVariableAction(), null, "actions", null, 0, -1, IModelVariableActionContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setVariableActionEClass, SetVariableAction.class, "SetVariableAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetVariableAction_Value(), ecorePackage.getEString(), "value", null, 1, 1, SetVariableAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetVariableAction_Variable(), this.getIModelVariable(), null, "variable", null, 1, 1, SetVariableAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(lResolvedVariableFeatureEDataType, FeatureDefinition.class, "LResolvedVariableFeature", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(variableDefinitionEDataType, String.class, "VariableDefinition", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //VariablePackageImpl
