/**
 */
package org.sheepy.lily.core.model.variable;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.action.ActionPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.core.model.variable.VariableFactory
 * @model kind="package"
 * @generated
 */
public interface VariablePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "variable";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.core.model.variable";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "variable";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VariablePackage eINSTANCE = org.sheepy.lily.core.model.variable.impl.VariablePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.variable.IVariableResolver <em>IVariable Resolver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.variable.IVariableResolver
	 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getIVariableResolver()
	 * @generated
	 */
	int IVARIABLE_RESOLVER = 0;

	/**
	 * The number of structural features of the '<em>IVariable Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVARIABLE_RESOLVER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IVariable Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVARIABLE_RESOLVER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.variable.IDefinitionContainer <em>IDefinition Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.variable.IDefinitionContainer
	 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getIDefinitionContainer()
	 * @generated
	 */
	int IDEFINITION_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Variable Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEFINITION_CONTAINER__VARIABLE_DEFINITION = 0;

	/**
	 * The number of structural features of the '<em>IDefinition Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEFINITION_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>IDefinition Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEFINITION_CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.variable.impl.ChainVariableResolverImpl <em>Chain Variable Resolver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.variable.impl.ChainVariableResolverImpl
	 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getChainVariableResolver()
	 * @generated
	 */
	int CHAIN_VARIABLE_RESOLVER = 2;

	/**
	 * The feature id for the '<em><b>First Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAIN_VARIABLE_RESOLVER__FIRST_RESOLVER = IVARIABLE_RESOLVER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Resolvers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAIN_VARIABLE_RESOLVER__SUB_RESOLVERS = IVARIABLE_RESOLVER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Chain Variable Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAIN_VARIABLE_RESOLVER_FEATURE_COUNT = IVARIABLE_RESOLVER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Chain Variable Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAIN_VARIABLE_RESOLVER_OPERATION_COUNT = IVARIABLE_RESOLVER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.variable.impl.ChainResolverImpl <em>Chain Resolver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.variable.impl.ChainResolverImpl
	 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getChainResolver()
	 * @generated
	 */
	int CHAIN_RESOLVER = 3;

	/**
	 * The feature id for the '<em><b>Variable Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAIN_RESOLVER__VARIABLE_DEFINITION = IDEFINITION_CONTAINER__VARIABLE_DEFINITION;

	/**
	 * The number of structural features of the '<em>Chain Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAIN_RESOLVER_FEATURE_COUNT = IDEFINITION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Chain Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAIN_RESOLVER_OPERATION_COUNT = IDEFINITION_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.variable.impl.AbstractDefinedVariableResolverImpl <em>Abstract Defined Variable Resolver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.variable.impl.AbstractDefinedVariableResolverImpl
	 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getAbstractDefinedVariableResolver()
	 * @generated
	 */
	int ABSTRACT_DEFINED_VARIABLE_RESOLVER = 4;

	/**
	 * The feature id for the '<em><b>Variable Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DEFINED_VARIABLE_RESOLVER__VARIABLE_DEFINITION = IVARIABLE_RESOLVER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Defined Variable Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DEFINED_VARIABLE_RESOLVER_FEATURE_COUNT = IVARIABLE_RESOLVER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Defined Variable Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DEFINED_VARIABLE_RESOLVER_OPERATION_COUNT = IVARIABLE_RESOLVER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.variable.impl.DirectVariableResolverImpl <em>Direct Variable Resolver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.variable.impl.DirectVariableResolverImpl
	 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getDirectVariableResolver()
	 * @generated
	 */
	int DIRECT_VARIABLE_RESOLVER = 5;

	/**
	 * The feature id for the '<em><b>Variable Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_VARIABLE_RESOLVER__VARIABLE_DEFINITION = ABSTRACT_DEFINED_VARIABLE_RESOLVER__VARIABLE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_VARIABLE_RESOLVER__TARGET = ABSTRACT_DEFINED_VARIABLE_RESOLVER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Direct Variable Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_VARIABLE_RESOLVER_FEATURE_COUNT = ABSTRACT_DEFINED_VARIABLE_RESOLVER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Direct Variable Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_VARIABLE_RESOLVER_OPERATION_COUNT = ABSTRACT_DEFINED_VARIABLE_RESOLVER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.variable.impl.VarChangeActionImpl <em>Var Change Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.variable.impl.VarChangeActionImpl
	 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getVarChangeAction()
	 * @generated
	 */
	int VAR_CHANGE_ACTION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_CHANGE_ACTION__NAME = ActionPackage.ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_CHANGE_ACTION__VARIABLE_RESOLVER = ActionPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Var Change Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_CHANGE_ACTION_FEATURE_COUNT = ActionPackage.ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Var Change Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_CHANGE_ACTION_OPERATION_COUNT = ActionPackage.ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.variable.impl.BooleanChangeActionImpl <em>Boolean Change Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.variable.impl.BooleanChangeActionImpl
	 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getBooleanChangeAction()
	 * @generated
	 */
	int BOOLEAN_CHANGE_ACTION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CHANGE_ACTION__NAME = VAR_CHANGE_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CHANGE_ACTION__VARIABLE_RESOLVER = VAR_CHANGE_ACTION__VARIABLE_RESOLVER;

	/**
	 * The number of structural features of the '<em>Boolean Change Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CHANGE_ACTION_FEATURE_COUNT = VAR_CHANGE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Change Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CHANGE_ACTION_OPERATION_COUNT = VAR_CHANGE_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.variable.impl.VarChangeActionPkgImpl <em>Var Change Action Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.variable.impl.VarChangeActionPkgImpl
	 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getVarChangeActionPkg()
	 * @generated
	 */
	int VAR_CHANGE_ACTION_PKG = 8;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_CHANGE_ACTION_PKG__ACTIONS = 0;

	/**
	 * The number of structural features of the '<em>Var Change Action Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_CHANGE_ACTION_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Var Change Action Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_CHANGE_ACTION_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>LResolved Variable Feature</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.api.util.FeatureDefinition
	 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getLResolvedVariableFeature()
	 * @generated
	 */
	int LRESOLVED_VARIABLE_FEATURE = 9;

	/**
	 * The meta object id for the '<em>Definition</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getVariableDefinition()
	 * @generated
	 */
	int VARIABLE_DEFINITION = 10;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.variable.IVariableResolver <em>IVariable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IVariable Resolver</em>'.
	 * @see org.sheepy.lily.core.model.variable.IVariableResolver
	 * @generated
	 */
	EClass getIVariableResolver();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.variable.IDefinitionContainer <em>IDefinition Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDefinition Container</em>'.
	 * @see org.sheepy.lily.core.model.variable.IDefinitionContainer
	 * @generated
	 */
	EClass getIDefinitionContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.variable.IDefinitionContainer#getVariableDefinition <em>Variable Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Definition</em>'.
	 * @see org.sheepy.lily.core.model.variable.IDefinitionContainer#getVariableDefinition()
	 * @see #getIDefinitionContainer()
	 * @generated
	 */
	EAttribute getIDefinitionContainer_VariableDefinition();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.variable.ChainVariableResolver <em>Chain Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Chain Variable Resolver</em>'.
	 * @see org.sheepy.lily.core.model.variable.ChainVariableResolver
	 * @generated
	 */
	EClass getChainVariableResolver();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.variable.ChainVariableResolver#getFirstResolver <em>First Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First Resolver</em>'.
	 * @see org.sheepy.lily.core.model.variable.ChainVariableResolver#getFirstResolver()
	 * @see #getChainVariableResolver()
	 * @generated
	 */
	EReference getChainVariableResolver_FirstResolver();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.variable.ChainVariableResolver#getSubResolvers <em>Sub Resolvers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Resolvers</em>'.
	 * @see org.sheepy.lily.core.model.variable.ChainVariableResolver#getSubResolvers()
	 * @see #getChainVariableResolver()
	 * @generated
	 */
	EReference getChainVariableResolver_SubResolvers();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.variable.ChainResolver <em>Chain Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Chain Resolver</em>'.
	 * @see org.sheepy.lily.core.model.variable.ChainResolver
	 * @generated
	 */
	EClass getChainResolver();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.variable.AbstractDefinedVariableResolver <em>Abstract Defined Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Defined Variable Resolver</em>'.
	 * @see org.sheepy.lily.core.model.variable.AbstractDefinedVariableResolver
	 * @generated
	 */
	EClass getAbstractDefinedVariableResolver();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.variable.DirectVariableResolver <em>Direct Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direct Variable Resolver</em>'.
	 * @see org.sheepy.lily.core.model.variable.DirectVariableResolver
	 * @generated
	 */
	EClass getDirectVariableResolver();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.variable.DirectVariableResolver#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.sheepy.lily.core.model.variable.DirectVariableResolver#getTarget()
	 * @see #getDirectVariableResolver()
	 * @generated
	 */
	EReference getDirectVariableResolver_Target();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.variable.VarChangeAction <em>Var Change Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Change Action</em>'.
	 * @see org.sheepy.lily.core.model.variable.VarChangeAction
	 * @generated
	 */
	EClass getVarChangeAction();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.variable.VarChangeAction#getVariableResolver <em>Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Resolver</em>'.
	 * @see org.sheepy.lily.core.model.variable.VarChangeAction#getVariableResolver()
	 * @see #getVarChangeAction()
	 * @generated
	 */
	EReference getVarChangeAction_VariableResolver();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.variable.BooleanChangeAction <em>Boolean Change Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Change Action</em>'.
	 * @see org.sheepy.lily.core.model.variable.BooleanChangeAction
	 * @generated
	 */
	EClass getBooleanChangeAction();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.variable.VarChangeActionPkg <em>Var Change Action Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Change Action Pkg</em>'.
	 * @see org.sheepy.lily.core.model.variable.VarChangeActionPkg
	 * @generated
	 */
	EClass getVarChangeActionPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.variable.VarChangeActionPkg#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.sheepy.lily.core.model.variable.VarChangeActionPkg#getActions()
	 * @see #getVarChangeActionPkg()
	 * @generated
	 */
	EReference getVarChangeActionPkg_Actions();

	/**
	 * Returns the meta object for data type '{@link org.sheepy.lily.core.api.util.FeatureDefinition <em>LResolved Variable Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>LResolved Variable Feature</em>'.
	 * @see org.sheepy.lily.core.api.util.FeatureDefinition
	 * @model instanceClass="org.sheepy.lily.core.api.util.FeatureDefinition"
	 * @generated
	 */
	EDataType getLResolvedVariableFeature();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Definition</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getVariableDefinition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VariableFactory getVariableFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.variable.IVariableResolver <em>IVariable Resolver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.variable.IVariableResolver
		 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getIVariableResolver()
		 * @generated
		 */
		EClass IVARIABLE_RESOLVER = eINSTANCE.getIVariableResolver();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.variable.IDefinitionContainer <em>IDefinition Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.variable.IDefinitionContainer
		 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getIDefinitionContainer()
		 * @generated
		 */
		EClass IDEFINITION_CONTAINER = eINSTANCE.getIDefinitionContainer();

		/**
		 * The meta object literal for the '<em><b>Variable Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDEFINITION_CONTAINER__VARIABLE_DEFINITION = eINSTANCE.getIDefinitionContainer_VariableDefinition();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.variable.impl.ChainVariableResolverImpl <em>Chain Variable Resolver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.variable.impl.ChainVariableResolverImpl
		 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getChainVariableResolver()
		 * @generated
		 */
		EClass CHAIN_VARIABLE_RESOLVER = eINSTANCE.getChainVariableResolver();

		/**
		 * The meta object literal for the '<em><b>First Resolver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHAIN_VARIABLE_RESOLVER__FIRST_RESOLVER = eINSTANCE.getChainVariableResolver_FirstResolver();

		/**
		 * The meta object literal for the '<em><b>Sub Resolvers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHAIN_VARIABLE_RESOLVER__SUB_RESOLVERS = eINSTANCE.getChainVariableResolver_SubResolvers();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.variable.impl.ChainResolverImpl <em>Chain Resolver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.variable.impl.ChainResolverImpl
		 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getChainResolver()
		 * @generated
		 */
		EClass CHAIN_RESOLVER = eINSTANCE.getChainResolver();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.variable.impl.AbstractDefinedVariableResolverImpl <em>Abstract Defined Variable Resolver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.variable.impl.AbstractDefinedVariableResolverImpl
		 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getAbstractDefinedVariableResolver()
		 * @generated
		 */
		EClass ABSTRACT_DEFINED_VARIABLE_RESOLVER = eINSTANCE.getAbstractDefinedVariableResolver();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.variable.impl.DirectVariableResolverImpl <em>Direct Variable Resolver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.variable.impl.DirectVariableResolverImpl
		 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getDirectVariableResolver()
		 * @generated
		 */
		EClass DIRECT_VARIABLE_RESOLVER = eINSTANCE.getDirectVariableResolver();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECT_VARIABLE_RESOLVER__TARGET = eINSTANCE.getDirectVariableResolver_Target();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.variable.impl.VarChangeActionImpl <em>Var Change Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.variable.impl.VarChangeActionImpl
		 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getVarChangeAction()
		 * @generated
		 */
		EClass VAR_CHANGE_ACTION = eINSTANCE.getVarChangeAction();

		/**
		 * The meta object literal for the '<em><b>Variable Resolver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_CHANGE_ACTION__VARIABLE_RESOLVER = eINSTANCE.getVarChangeAction_VariableResolver();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.variable.impl.BooleanChangeActionImpl <em>Boolean Change Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.variable.impl.BooleanChangeActionImpl
		 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getBooleanChangeAction()
		 * @generated
		 */
		EClass BOOLEAN_CHANGE_ACTION = eINSTANCE.getBooleanChangeAction();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.variable.impl.VarChangeActionPkgImpl <em>Var Change Action Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.variable.impl.VarChangeActionPkgImpl
		 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getVarChangeActionPkg()
		 * @generated
		 */
		EClass VAR_CHANGE_ACTION_PKG = eINSTANCE.getVarChangeActionPkg();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_CHANGE_ACTION_PKG__ACTIONS = eINSTANCE.getVarChangeActionPkg_Actions();

		/**
		 * The meta object literal for the '<em>LResolved Variable Feature</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.api.util.FeatureDefinition
		 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getLResolvedVariableFeature()
		 * @generated
		 */
		EDataType LRESOLVED_VARIABLE_FEATURE = eINSTANCE.getLResolvedVariableFeature();

		/**
		 * The meta object literal for the '<em>Definition</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.sheepy.lily.core.model.variable.impl.VariablePackageImpl#getVariableDefinition()
		 * @generated
		 */
		EDataType VARIABLE_DEFINITION = eINSTANCE.getVariableDefinition();

	}

} //VariablePackage
