/**
 */
package org.sheepy.common.model.action;

import org.eclipse.emf.ecore.EFactory;

import org.sheepy.common.model.types.Parameter;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.common.model.action.ActionPackage
 * @generated
 */
public interface ActionFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionFactory eINSTANCE = org.sheepy.common.model.action.impl.ActionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>String Injector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Injector</em>'.
	 * @generated
	 */
	StringInjector createStringInjector();

	/**
	 * Returns a new object of class '<em>Number Injector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Number Injector</em>'.
	 * @generated
	 */
	NumberInjector createNumberInjector();

	/**
	 * Returns a new object of class '<em>Parametered Actions Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parametered Actions Pkg</em>'.
	 * @generated
	 */
	<T extends Parameter> ParameteredActionsPkg<T> createParameteredActionsPkg();

	/**
	 * Returns a new object of class '<em>Actions Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actions Pkg</em>'.
	 * @generated
	 */
	ActionsPkg createActionsPkg();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ActionPackage getActionPackage();

} //ActionFactory
