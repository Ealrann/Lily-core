/**
 */
package org.sheepy.common.model.types;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.common.model.types.TypesPackage
 * @generated
 */
public interface TypesFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesFactory eINSTANCE = org.sheepy.common.model.types.impl.TypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Float Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Float Parameter</em>'.
	 * @generated
	 */
	FloatParameter createFloatParameter();

	/**
	 * Returns a new object of class '<em>String Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Parameter</em>'.
	 * @generated
	 */
	StringParameter createStringParameter();

	/**
	 * Returns a new object of class '<em>Boolean Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Parameter</em>'.
	 * @generated
	 */
	BooleanParameter createBooleanParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TypesPackage getTypesPackage();

} //TypesFactory
