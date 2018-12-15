/**
 */
package org.sheepy.common.model.variable;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.common.model.action.ActionPackage;

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
 * @see org.sheepy.common.model.variable.VariableFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.common.model/src/generated/java' editDirectory='/org.sheepy.common.model.edit/src/generated/java' publicConstructors='true' extensibleProviderFactory='true' childCreationExtenders='true' basePackage='org.sheepy.common.model'"
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
	String eNS_URI = "org.sheepy.common.model.variable";

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
	VariablePackage eINSTANCE = org.sheepy.common.model.variable.impl.VariablePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.variable.impl.AbstractVariableResolverImpl <em>Abstract Variable Resolver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.variable.impl.AbstractVariableResolverImpl
	 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getAbstractVariableResolver()
	 * @generated
	 */
	int ABSTRACT_VARIABLE_RESOLVER = 0;

	/**
	 * The feature id for the '<em><b>Variable Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE_RESOLVER__VARIABLE_DEFINITION = 0;

	/**
	 * The number of structural features of the '<em>Abstract Variable Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE_RESOLVER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Abstract Variable Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE_RESOLVER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.variable.impl.DirectVariableResolverImpl <em>Direct Variable Resolver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.variable.impl.DirectVariableResolverImpl
	 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getDirectVariableResolver()
	 * @generated
	 */
	int DIRECT_VARIABLE_RESOLVER = 1;

	/**
	 * The feature id for the '<em><b>Variable Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_VARIABLE_RESOLVER__VARIABLE_DEFINITION = ABSTRACT_VARIABLE_RESOLVER__VARIABLE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_VARIABLE_RESOLVER__TARGET = ABSTRACT_VARIABLE_RESOLVER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Direct Variable Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_VARIABLE_RESOLVER_FEATURE_COUNT = ABSTRACT_VARIABLE_RESOLVER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Direct Variable Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_VARIABLE_RESOLVER_OPERATION_COUNT = ABSTRACT_VARIABLE_RESOLVER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.variable.impl.VarChangeActionImpl <em>Var Change Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.variable.impl.VarChangeActionImpl
	 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getVarChangeAction()
	 * @generated
	 */
	int VAR_CHANGE_ACTION = 2;

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
	 * The meta object id for the '{@link org.sheepy.common.model.variable.impl.BooleanChangeActionImpl <em>Boolean Change Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.variable.impl.BooleanChangeActionImpl
	 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getBooleanChangeAction()
	 * @generated
	 */
	int BOOLEAN_CHANGE_ACTION = 3;

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
	 * The meta object id for the '{@link org.sheepy.common.model.variable.impl.VarChangeActionPkgImpl <em>Var Change Action Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.variable.impl.VarChangeActionPkgImpl
	 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getVarChangeActionPkg()
	 * @generated
	 */
	int VAR_CHANGE_ACTION_PKG = 4;

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
	 * The meta object id for the '{@link org.sheepy.common.model.variable.impl.IncrementActionImpl <em>Increment Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.variable.impl.IncrementActionImpl
	 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getIncrementAction()
	 * @generated
	 */
	int INCREMENT_ACTION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_ACTION__NAME = ActionPackage.PARAMETERED_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_ACTION__VARIABLE_RESOLVER = ActionPackage.PARAMETERED_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_ACTION__INCREMENT = ActionPackage.PARAMETERED_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Increment Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_ACTION_FEATURE_COUNT = ActionPackage.PARAMETERED_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Increment Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_ACTION_OPERATION_COUNT = ActionPackage.PARAMETERED_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.variable.impl.SetStringImpl <em>Set String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.variable.impl.SetStringImpl
	 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getSetString()
	 * @generated
	 */
	int SET_STRING = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STRING__NAME = ActionPackage.PARAMETERED_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STRING__VARIABLE_RESOLVER = ActionPackage.PARAMETERED_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STRING_FEATURE_COUNT = ActionPackage.PARAMETERED_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Set String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STRING_OPERATION_COUNT = ActionPackage.PARAMETERED_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.variable.impl.SetBooleanImpl <em>Set Boolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.variable.impl.SetBooleanImpl
	 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getSetBoolean()
	 * @generated
	 */
	int SET_BOOLEAN = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_BOOLEAN__NAME = ActionPackage.PARAMETERED_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_BOOLEAN__VARIABLE_RESOLVER = ActionPackage.PARAMETERED_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_BOOLEAN_FEATURE_COUNT = ActionPackage.PARAMETERED_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Set Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_BOOLEAN_OPERATION_COUNT = ActionPackage.PARAMETERED_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.variable.impl.SetNumberImpl <em>Set Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.variable.impl.SetNumberImpl
	 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getSetNumber()
	 * @generated
	 */
	int SET_NUMBER = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_NUMBER__NAME = ActionPackage.PARAMETERED_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_NUMBER__VARIABLE_RESOLVER = ActionPackage.PARAMETERED_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_NUMBER_FEATURE_COUNT = ActionPackage.PARAMETERED_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Set Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_NUMBER_OPERATION_COUNT = ActionPackage.PARAMETERED_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>LResolved Variable Feature</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.api.util.ResolvedVariableFeature
	 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getLResolvedVariableFeature()
	 * @generated
	 */
	int LRESOLVED_VARIABLE_FEATURE = 9;

	/**
	 * The meta object id for the '<em>Definition</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getVariableDefinition()
	 * @generated
	 */
	int VARIABLE_DEFINITION = 10;


	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.variable.AbstractVariableResolver <em>Abstract Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Variable Resolver</em>'.
	 * @see org.sheepy.common.model.variable.AbstractVariableResolver
	 * @generated
	 */
	EClass getAbstractVariableResolver();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.variable.AbstractVariableResolver#getVariableDefinition <em>Variable Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Definition</em>'.
	 * @see org.sheepy.common.model.variable.AbstractVariableResolver#getVariableDefinition()
	 * @see #getAbstractVariableResolver()
	 * @generated
	 */
	EAttribute getAbstractVariableResolver_VariableDefinition();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.variable.DirectVariableResolver <em>Direct Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direct Variable Resolver</em>'.
	 * @see org.sheepy.common.model.variable.DirectVariableResolver
	 * @generated
	 */
	EClass getDirectVariableResolver();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.common.model.variable.DirectVariableResolver#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.sheepy.common.model.variable.DirectVariableResolver#getTarget()
	 * @see #getDirectVariableResolver()
	 * @generated
	 */
	EReference getDirectVariableResolver_Target();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.variable.VarChangeAction <em>Var Change Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Change Action</em>'.
	 * @see org.sheepy.common.model.variable.VarChangeAction
	 * @generated
	 */
	EClass getVarChangeAction();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.common.model.variable.VarChangeAction#getVariableResolver <em>Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Resolver</em>'.
	 * @see org.sheepy.common.model.variable.VarChangeAction#getVariableResolver()
	 * @see #getVarChangeAction()
	 * @generated
	 */
	EReference getVarChangeAction_VariableResolver();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.variable.BooleanChangeAction <em>Boolean Change Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Change Action</em>'.
	 * @see org.sheepy.common.model.variable.BooleanChangeAction
	 * @generated
	 */
	EClass getBooleanChangeAction();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.variable.VarChangeActionPkg <em>Var Change Action Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Change Action Pkg</em>'.
	 * @see org.sheepy.common.model.variable.VarChangeActionPkg
	 * @generated
	 */
	EClass getVarChangeActionPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.common.model.variable.VarChangeActionPkg#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.sheepy.common.model.variable.VarChangeActionPkg#getActions()
	 * @see #getVarChangeActionPkg()
	 * @generated
	 */
	EReference getVarChangeActionPkg_Actions();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.variable.IncrementAction <em>Increment Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Increment Action</em>'.
	 * @see org.sheepy.common.model.variable.IncrementAction
	 * @generated
	 */
	EClass getIncrementAction();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.variable.IncrementAction#getIncrement <em>Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Increment</em>'.
	 * @see org.sheepy.common.model.variable.IncrementAction#getIncrement()
	 * @see #getIncrementAction()
	 * @generated
	 */
	EAttribute getIncrementAction_Increment();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.variable.SetString <em>Set String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set String</em>'.
	 * @see org.sheepy.common.model.variable.SetString
	 * @generated
	 */
	EClass getSetString();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.variable.SetBoolean <em>Set Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Boolean</em>'.
	 * @see org.sheepy.common.model.variable.SetBoolean
	 * @generated
	 */
	EClass getSetBoolean();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.variable.SetNumber <em>Set Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Number</em>'.
	 * @see org.sheepy.common.model.variable.SetNumber
	 * @generated
	 */
	EClass getSetNumber();

	/**
	 * Returns the meta object for data type '{@link org.sheepy.common.api.util.ResolvedVariableFeature <em>LResolved Variable Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>LResolved Variable Feature</em>'.
	 * @see org.sheepy.common.api.util.ResolvedVariableFeature
	 * @model instanceClass="org.sheepy.common.api.util.ResolvedVariableFeature"
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
		 * The meta object literal for the '{@link org.sheepy.common.model.variable.impl.AbstractVariableResolverImpl <em>Abstract Variable Resolver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.variable.impl.AbstractVariableResolverImpl
		 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getAbstractVariableResolver()
		 * @generated
		 */
		EClass ABSTRACT_VARIABLE_RESOLVER = eINSTANCE.getAbstractVariableResolver();

		/**
		 * The meta object literal for the '<em><b>Variable Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VARIABLE_RESOLVER__VARIABLE_DEFINITION = eINSTANCE.getAbstractVariableResolver_VariableDefinition();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.variable.impl.DirectVariableResolverImpl <em>Direct Variable Resolver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.variable.impl.DirectVariableResolverImpl
		 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getDirectVariableResolver()
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
		 * The meta object literal for the '{@link org.sheepy.common.model.variable.impl.VarChangeActionImpl <em>Var Change Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.variable.impl.VarChangeActionImpl
		 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getVarChangeAction()
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
		 * The meta object literal for the '{@link org.sheepy.common.model.variable.impl.BooleanChangeActionImpl <em>Boolean Change Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.variable.impl.BooleanChangeActionImpl
		 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getBooleanChangeAction()
		 * @generated
		 */
		EClass BOOLEAN_CHANGE_ACTION = eINSTANCE.getBooleanChangeAction();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.variable.impl.VarChangeActionPkgImpl <em>Var Change Action Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.variable.impl.VarChangeActionPkgImpl
		 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getVarChangeActionPkg()
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
		 * The meta object literal for the '{@link org.sheepy.common.model.variable.impl.IncrementActionImpl <em>Increment Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.variable.impl.IncrementActionImpl
		 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getIncrementAction()
		 * @generated
		 */
		EClass INCREMENT_ACTION = eINSTANCE.getIncrementAction();

		/**
		 * The meta object literal for the '<em><b>Increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCREMENT_ACTION__INCREMENT = eINSTANCE.getIncrementAction_Increment();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.variable.impl.SetStringImpl <em>Set String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.variable.impl.SetStringImpl
		 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getSetString()
		 * @generated
		 */
		EClass SET_STRING = eINSTANCE.getSetString();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.variable.impl.SetBooleanImpl <em>Set Boolean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.variable.impl.SetBooleanImpl
		 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getSetBoolean()
		 * @generated
		 */
		EClass SET_BOOLEAN = eINSTANCE.getSetBoolean();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.variable.impl.SetNumberImpl <em>Set Number</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.variable.impl.SetNumberImpl
		 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getSetNumber()
		 * @generated
		 */
		EClass SET_NUMBER = eINSTANCE.getSetNumber();

		/**
		 * The meta object literal for the '<em>LResolved Variable Feature</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.api.util.ResolvedVariableFeature
		 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getLResolvedVariableFeature()
		 * @generated
		 */
		EDataType LRESOLVED_VARIABLE_FEATURE = eINSTANCE.getLResolvedVariableFeature();

		/**
		 * The meta object literal for the '<em>Definition</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.sheepy.common.model.variable.impl.VariablePackageImpl#getVariableDefinition()
		 * @generated
		 */
		EDataType VARIABLE_DEFINITION = eINSTANCE.getVariableDefinition();

	}

} //VariablePackage
