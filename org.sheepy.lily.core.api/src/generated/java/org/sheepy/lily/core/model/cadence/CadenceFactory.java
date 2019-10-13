/**
 */
package org.sheepy.lily.core.model.cadence;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.core.model.cadence.CadencePackage
 * @generated
 */
public interface CadenceFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CadenceFactory eINSTANCE = org.sheepy.lily.core.model.cadence.impl.CadenceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Cadence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cadence</em>'.
	 * @generated
	 */
	Cadence createCadence();

	/**
	 * Returns a new object of class '<em>Execute While</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execute While</em>'.
	 * @generated
	 */
	ExecuteWhile createExecuteWhile();

	/**
	 * Returns a new object of class '<em>Execute If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execute If</em>'.
	 * @generated
	 */
	ExecuteIf createExecuteIf();

	/**
	 * Returns a new object of class '<em>Print UPS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Print UPS</em>'.
	 * @generated
	 */
	PrintUPS createPrintUPS();

	/**
	 * Returns a new object of class '<em>Have Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Have Time</em>'.
	 * @generated
	 */
	HaveTime createHaveTime();

	/**
	 * Returns a new object of class '<em>Count Until</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Count Until</em>'.
	 * @generated
	 */
	CountUntil createCountUntil();

	/**
	 * Returns a new object of class '<em>Close Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Close Application</em>'.
	 * @generated
	 */
	CloseApplication createCloseApplication();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CadencePackage getCadencePackage();

} //CadenceFactory
