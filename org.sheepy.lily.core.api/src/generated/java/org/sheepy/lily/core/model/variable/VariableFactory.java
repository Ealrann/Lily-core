/**
 */
package org.sheepy.lily.core.model.variable;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.core.model.variable.VariablePackage
 * @generated
 */
public interface VariableFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VariableFactory eINSTANCE = org.sheepy.lily.core.model.variable.impl.VariableFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Chain Variable Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Chain Variable Resolver</em>'.
	 * @generated
	 */
	ChainVariableResolver createChainVariableResolver();

	/**
	 * Returns a new object of class '<em>Chain Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Chain Resolver</em>'.
	 * @generated
	 */
	ChainResolver createChainResolver();

	/**
	 * Returns a new object of class '<em>Direct Variable Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Direct Variable Resolver</em>'.
	 * @generated
	 */
	DirectVariableResolver createDirectVariableResolver();

	/**
	 * Returns a new object of class '<em>Boolean Change Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Change Action</em>'.
	 * @generated
	 */
	BooleanChangeAction createBooleanChangeAction();

	/**
	 * Returns a new object of class '<em>Int Change Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Change Action</em>'.
	 * @generated
	 */
	IntChangeAction createIntChangeAction();

	/**
	 * Returns a new object of class '<em>Var Change Action Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var Change Action Pkg</em>'.
	 * @generated
	 */
	VarChangeActionPkg createVarChangeActionPkg();

	/**
	 * Returns a new object of class '<em>IModel Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IModel Variable</em>'.
	 * @generated
	 */
	IModelVariable createIModelVariable();

	/**
	 * Returns a new object of class '<em>Int Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Variable</em>'.
	 * @generated
	 */
	IntVariable createIntVariable();

	/**
	 * Returns a new object of class '<em>Duration Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Duration Variable</em>'.
	 * @generated
	 */
	DurationVariable createDurationVariable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VariablePackage getVariablePackage();

} //VariableFactory
