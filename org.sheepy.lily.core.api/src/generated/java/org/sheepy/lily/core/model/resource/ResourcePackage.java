/**
 */
package org.sheepy.lily.core.model.resource;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.application.ApplicationPackage;

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
 * @see org.sheepy.lily.core.model.resource.ResourceFactory
 * @model kind="package"
 * @generated
 */
public interface ResourcePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resource";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.core.model.resource";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "resource";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourcePackage eINSTANCE = org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.impl.SoundImpl <em>Sound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.impl.SoundImpl
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getSound()
	 * @generated
	 */
	int SOUND = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND__NAME = ApplicationPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND__FILE = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_FEATURE_COUNT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_OPERATION_COUNT = ApplicationPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.impl.MusicImpl <em>Music</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.impl.MusicImpl
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getMusic()
	 * @generated
	 */
	int MUSIC = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUSIC__NAME = ApplicationPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUSIC__FILE = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Music</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUSIC_FEATURE_COUNT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Music</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUSIC_OPERATION_COUNT = ApplicationPackage.IRESOURCE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.impl.SoundContinuousImpl <em>Sound Continuous</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.impl.SoundContinuousImpl
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getSoundContinuous()
	 * @generated
	 */
	int SOUND_CONTINUOUS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CONTINUOUS__NAME = SOUND__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CONTINUOUS__FILE = SOUND__FILE;

	/**
	 * The feature id for the '<em><b>Attack Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CONTINUOUS__ATTACK_MS = SOUND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Decay Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CONTINUOUS__DECAY_MS = SOUND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sound Continuous</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CONTINUOUS_FEATURE_COUNT = SOUND_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sound Continuous</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CONTINUOUS_OPERATION_COUNT = SOUND_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.Sound <em>Sound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sound</em>'.
	 * @see org.sheepy.lily.core.model.resource.Sound
	 * @generated
	 */
	EClass getSound();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.resource.Sound#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.lily.core.model.resource.Sound#getFile()
	 * @see #getSound()
	 * @generated
	 */
	EReference getSound_File();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.Music <em>Music</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Music</em>'.
	 * @see org.sheepy.lily.core.model.resource.Music
	 * @generated
	 */
	EClass getMusic();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.resource.Music#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.lily.core.model.resource.Music#getFile()
	 * @see #getMusic()
	 * @generated
	 */
	EReference getMusic_File();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.SoundContinuous <em>Sound Continuous</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sound Continuous</em>'.
	 * @see org.sheepy.lily.core.model.resource.SoundContinuous
	 * @generated
	 */
	EClass getSoundContinuous();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.resource.SoundContinuous#getAttackMs <em>Attack Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attack Ms</em>'.
	 * @see org.sheepy.lily.core.model.resource.SoundContinuous#getAttackMs()
	 * @see #getSoundContinuous()
	 * @generated
	 */
	EAttribute getSoundContinuous_AttackMs();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.resource.SoundContinuous#getDecayMs <em>Decay Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decay Ms</em>'.
	 * @see org.sheepy.lily.core.model.resource.SoundContinuous#getDecayMs()
	 * @see #getSoundContinuous()
	 * @generated
	 */
	EAttribute getSoundContinuous_DecayMs();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResourceFactory getResourceFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.impl.SoundImpl <em>Sound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.impl.SoundImpl
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getSound()
		 * @generated
		 */
		EClass SOUND = eINSTANCE.getSound();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOUND__FILE = eINSTANCE.getSound_File();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.impl.MusicImpl <em>Music</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.impl.MusicImpl
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getMusic()
		 * @generated
		 */
		EClass MUSIC = eINSTANCE.getMusic();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUSIC__FILE = eINSTANCE.getMusic_File();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.impl.SoundContinuousImpl <em>Sound Continuous</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.impl.SoundContinuousImpl
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getSoundContinuous()
		 * @generated
		 */
		EClass SOUND_CONTINUOUS = eINSTANCE.getSoundContinuous();

		/**
		 * The meta object literal for the '<em><b>Attack Ms</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOUND_CONTINUOUS__ATTACK_MS = eINSTANCE.getSoundContinuous_AttackMs();

		/**
		 * The meta object literal for the '<em><b>Decay Ms</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOUND_CONTINUOUS__DECAY_MS = eINSTANCE.getSoundContinuous_DecayMs();

	}

} //ResourcePackage
