/**
 */
package org.sheepy.common.model.variable;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.common.model.variable.VariablePackage
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
	VariableFactory eINSTANCE = org.sheepy.common.model.variable.impl.VariableFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolver</em>'.
	 * @generated
	 */
	VariableResolver createVariableResolver();

	/**
	 * Returns a new object of class '<em>Boolean Change Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Change Action</em>'.
	 * @generated
	 */
	BooleanChangeAction createBooleanChangeAction();

	/**
	 * Returns a new object of class '<em>Var Change Action Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var Change Action Pkg</em>'.
	 * @generated
	 */
	VarChangeActionPkg createVarChangeActionPkg();

	/**
	 * Returns a new object of class '<em>Increment Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Increment Action</em>'.
	 * @generated
	 */
	IncrementAction createIncrementAction();

	/**
	 * Returns a new object of class '<em>Set String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set String</em>'.
	 * @generated
	 */
	SetString createSetString();

	/**
	 * Returns a new object of class '<em>Set Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Boolean</em>'.
	 * @generated
	 */
	SetBoolean createSetBoolean();

	/**
	 * Returns a new object of class '<em>Set Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Number</em>'.
	 * @generated
	 */
	SetNumber createSetNumber();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VariablePackage getVariablePackage();

} //VariableFactory
