/**
 */
package org.sheepy.lily.core.model.inference;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.core.model.inference.InferencePackage
 * @generated
 */
public interface InferenceFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InferenceFactory eINSTANCE = org.sheepy.lily.core.model.inference.impl.InferenceFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>LRule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>LRule</em>'.
	 * @generated
	 */
	LRule createLRule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InferencePackage getInferencePackage();

} //InferenceFactory
