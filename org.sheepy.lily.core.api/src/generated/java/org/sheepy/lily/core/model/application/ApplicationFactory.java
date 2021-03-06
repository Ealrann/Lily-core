/**
 */
package org.sheepy.lily.core.model.application;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.core.model.application.ApplicationPackage
 * @generated
 */
public interface ApplicationFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ApplicationFactory eINSTANCE = org.sheepy.lily.core.model.application.impl.ApplicationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application</em>'.
	 * @generated
	 */
	Application createApplication();

	/**
	 * Returns a new object of class '<em>Extension Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Pkg</em>'.
	 * @generated
	 */
	ApplicationExtensionPkg createApplicationExtensionPkg();

	/**
	 * Returns a new object of class '<em>Time Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Configuration</em>'.
	 * @generated
	 */
	TimeConfiguration createTimeConfiguration();

	/**
	 * Returns a new object of class '<em>IModel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IModel</em>'.
	 * @generated
	 */
	IModel createIModel();

	/**
	 * Returns a new object of class '<em>Compositor Extension Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compositor Extension Pkg</em>'.
	 * @generated
	 */
	CompositorExtensionPkg createCompositorExtensionPkg();

	/**
	 * Returns a new object of class '<em>Scene</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scene</em>'.
	 * @generated
	 */
	Scene createScene();

	/**
	 * Returns a new object of class '<em>Generic Scene Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Scene Part</em>'.
	 * @generated
	 */
	GenericScenePart createGenericScenePart();

	/**
	 * Returns a new object of class '<em>Background Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Background Image</em>'.
	 * @generated
	 */
	BackgroundImage createBackgroundImage();

	/**
	 * Returns a new object of class '<em>Screen Effect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Screen Effect</em>'.
	 * @generated
	 */
	ScreenEffect createScreenEffect();

	/**
	 * Returns a new object of class '<em>Special Effect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Special Effect</em>'.
	 * @generated
	 */
	SpecialEffect createSpecialEffect();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ApplicationPackage getApplicationPackage();

} //ApplicationFactory
