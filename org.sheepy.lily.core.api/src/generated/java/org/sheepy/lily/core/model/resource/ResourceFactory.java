/**
 */
package org.sheepy.lily.core.model.resource;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.core.model.resource.ResourcePackage
 * @generated
 */
public interface ResourceFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourceFactory eINSTANCE = org.sheepy.lily.core.model.resource.impl.ResourceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sound</em>'.
	 * @generated
	 */
	Sound createSound();

	/**
	 * Returns a new object of class '<em>Music</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Music</em>'.
	 * @generated
	 */
	Music createMusic();

	/**
	 * Returns a new object of class '<em>Sound Continuous</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sound Continuous</em>'.
	 * @generated
	 */
	SoundContinuous createSoundContinuous();

	/**
	 * Returns a new object of class '<em>Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pkg</em>'.
	 * @generated
	 */
	ResourcePkg createResourcePkg();

	/**
	 * Returns a new object of class '<em>Local Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Resource</em>'.
	 * @generated
	 */
	LocalResource createLocalResource();

	/**
	 * Returns a new object of class '<em>Module Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Resource</em>'.
	 * @generated
	 */
	ModuleResource createModuleResource();

	/**
	 * Returns a new object of class '<em>String Module Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Module Resource</em>'.
	 * @generated
	 */
	StringModuleResource createStringModuleResource();

	/**
	 * Returns a new object of class '<em>File Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Image</em>'.
	 * @generated
	 */
	FileImage createFileImage();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResourcePackage getResourcePackage();

} //ResourceFactory
