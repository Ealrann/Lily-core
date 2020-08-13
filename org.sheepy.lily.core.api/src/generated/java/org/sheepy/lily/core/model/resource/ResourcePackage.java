/**
 */
package org.sheepy.lily.core.model.resource;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.model.types.TypesPackage;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.impl.IResourceImpl <em>IResource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.impl.IResourceImpl
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getIResource()
	 * @generated
	 */
	int IRESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>IResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

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
	int SOUND__NAME = IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND__FILE = IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_FEATURE_COUNT = IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_OPERATION_COUNT = IRESOURCE_OPERATION_COUNT + 0;

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
	int MUSIC__NAME = IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUSIC__FILE = IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Music</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUSIC_FEATURE_COUNT = IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Music</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUSIC_OPERATION_COUNT = IRESOURCE_OPERATION_COUNT + 0;


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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.impl.ResourcePkgImpl <em>Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePkgImpl
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getResourcePkg()
	 * @generated
	 */
	int RESOURCE_PKG = 3;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PKG__RESOURCES = 0;

	/**
	 * The number of structural features of the '<em>Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.IImage <em>IImage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.IImage
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getIImage()
	 * @generated
	 */
	int IIMAGE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IIMAGE__NAME = IRESOURCE__NAME;

	/**
	 * The number of structural features of the '<em>IImage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IIMAGE_FEATURE_COUNT = IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IImage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IIMAGE_OPERATION_COUNT = IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.impl.VirtualResourceImpl <em>Virtual Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.impl.VirtualResourceImpl
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getVirtualResource()
	 * @generated
	 */
	int VIRTUAL_RESOURCE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_RESOURCE__NAME = IRESOURCE__NAME;

	/**
	 * The number of structural features of the '<em>Virtual Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_RESOURCE_FEATURE_COUNT = IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Virtual Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_RESOURCE_OPERATION_COUNT = IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.impl.FileResourceImpl <em>File Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.impl.FileResourceImpl
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getFileResource()
	 * @generated
	 */
	int FILE_RESOURCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE__NAME = IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE__PATH = IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE_FEATURE_COUNT = IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>File Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE_OPERATION_COUNT = IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.impl.LocalResourceImpl <em>Local Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.impl.LocalResourceImpl
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getLocalResource()
	 * @generated
	 */
	int LOCAL_RESOURCE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_RESOURCE__NAME = FILE_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_RESOURCE__PATH = FILE_RESOURCE__PATH;

	/**
	 * The number of structural features of the '<em>Local Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_RESOURCE_FEATURE_COUNT = FILE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Local Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_RESOURCE_OPERATION_COUNT = FILE_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.impl.AbstractModuleResourceImpl <em>Abstract Module Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.impl.AbstractModuleResourceImpl
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getAbstractModuleResource()
	 * @generated
	 */
	int ABSTRACT_MODULE_RESOURCE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODULE_RESOURCE__NAME = FILE_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODULE_RESOURCE__PATH = FILE_RESOURCE__PATH;

	/**
	 * The number of structural features of the '<em>Abstract Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODULE_RESOURCE_FEATURE_COUNT = FILE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Abstract Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODULE_RESOURCE_OPERATION_COUNT = FILE_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.impl.ModuleResourceImpl <em>Module Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.impl.ModuleResourceImpl
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getModuleResource()
	 * @generated
	 */
	int MODULE_RESOURCE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE__NAME = ABSTRACT_MODULE_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE__PATH = ABSTRACT_MODULE_RESOURCE__PATH;

	/**
	 * The feature id for the '<em><b>Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE__MODULE = ABSTRACT_MODULE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE_FEATURE_COUNT = ABSTRACT_MODULE_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE_OPERATION_COUNT = ABSTRACT_MODULE_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.impl.StringModuleResourceImpl <em>String Module Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.impl.StringModuleResourceImpl
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getStringModuleResource()
	 * @generated
	 */
	int STRING_MODULE_RESOURCE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODULE_RESOURCE__NAME = ABSTRACT_MODULE_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODULE_RESOURCE__PATH = ABSTRACT_MODULE_RESOURCE__PATH;

	/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODULE_RESOURCE__MODULE_NAME = ABSTRACT_MODULE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODULE_RESOURCE_FEATURE_COUNT = ABSTRACT_MODULE_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODULE_RESOURCE_OPERATION_COUNT = ABSTRACT_MODULE_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.impl.FileImageImpl <em>File Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.impl.FileImageImpl
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getFileImage()
	 * @generated
	 */
	int FILE_IMAGE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__NAME = IIMAGE__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__FILE = IIMAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE_FEATURE_COUNT = IIMAGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>File Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE_OPERATION_COUNT = IIMAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.resource.ESampling <em>ESampling</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.resource.ESampling
	 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getESampling()
	 * @generated
	 */
	int ESAMPLING = 13;


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
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.ResourcePkg <em>Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pkg</em>'.
	 * @see org.sheepy.lily.core.model.resource.ResourcePkg
	 * @generated
	 */
	EClass getResourcePkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.resource.ResourcePkg#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see org.sheepy.lily.core.model.resource.ResourcePkg#getResources()
	 * @see #getResourcePkg()
	 * @generated
	 */
	EReference getResourcePkg_Resources();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.IResource <em>IResource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IResource</em>'.
	 * @see org.sheepy.lily.core.model.resource.IResource
	 * @generated
	 */
	EClass getIResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.IImage <em>IImage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IImage</em>'.
	 * @see org.sheepy.lily.core.model.resource.IImage
	 * @generated
	 */
	EClass getIImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.VirtualResource <em>Virtual Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Resource</em>'.
	 * @see org.sheepy.lily.core.model.resource.VirtualResource
	 * @generated
	 */
	EClass getVirtualResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.FileResource <em>File Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Resource</em>'.
	 * @see org.sheepy.lily.core.model.resource.FileResource
	 * @generated
	 */
	EClass getFileResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.resource.FileResource#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.sheepy.lily.core.model.resource.FileResource#getPath()
	 * @see #getFileResource()
	 * @generated
	 */
	EAttribute getFileResource_Path();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.LocalResource <em>Local Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Resource</em>'.
	 * @see org.sheepy.lily.core.model.resource.LocalResource
	 * @generated
	 */
	EClass getLocalResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.AbstractModuleResource <em>Abstract Module Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Module Resource</em>'.
	 * @see org.sheepy.lily.core.model.resource.AbstractModuleResource
	 * @generated
	 */
	EClass getAbstractModuleResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.ModuleResource <em>Module Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Resource</em>'.
	 * @see org.sheepy.lily.core.model.resource.ModuleResource
	 * @generated
	 */
	EClass getModuleResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.resource.ModuleResource#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module</em>'.
	 * @see org.sheepy.lily.core.model.resource.ModuleResource#getModule()
	 * @see #getModuleResource()
	 * @generated
	 */
	EAttribute getModuleResource_Module();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.StringModuleResource <em>String Module Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Module Resource</em>'.
	 * @see org.sheepy.lily.core.model.resource.StringModuleResource
	 * @generated
	 */
	EClass getStringModuleResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.resource.StringModuleResource#getModuleName <em>Module Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module Name</em>'.
	 * @see org.sheepy.lily.core.model.resource.StringModuleResource#getModuleName()
	 * @see #getStringModuleResource()
	 * @generated
	 */
	EAttribute getStringModuleResource_ModuleName();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.resource.FileImage <em>File Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Image</em>'.
	 * @see org.sheepy.lily.core.model.resource.FileImage
	 * @generated
	 */
	EClass getFileImage();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.resource.FileImage#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.lily.core.model.resource.FileImage#getFile()
	 * @see #getFileImage()
	 * @generated
	 */
	EReference getFileImage_File();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.resource.ESampling <em>ESampling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ESampling</em>'.
	 * @see org.sheepy.lily.core.model.resource.ESampling
	 * @generated
	 */
	EEnum getESampling();

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

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.impl.ResourcePkgImpl <em>Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePkgImpl
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getResourcePkg()
		 * @generated
		 */
		EClass RESOURCE_PKG = eINSTANCE.getResourcePkg();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_PKG__RESOURCES = eINSTANCE.getResourcePkg_Resources();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.impl.IResourceImpl <em>IResource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.impl.IResourceImpl
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getIResource()
		 * @generated
		 */
		EClass IRESOURCE = eINSTANCE.getIResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.IImage <em>IImage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.IImage
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getIImage()
		 * @generated
		 */
		EClass IIMAGE = eINSTANCE.getIImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.impl.VirtualResourceImpl <em>Virtual Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.impl.VirtualResourceImpl
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getVirtualResource()
		 * @generated
		 */
		EClass VIRTUAL_RESOURCE = eINSTANCE.getVirtualResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.impl.FileResourceImpl <em>File Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.impl.FileResourceImpl
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getFileResource()
		 * @generated
		 */
		EClass FILE_RESOURCE = eINSTANCE.getFileResource();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_RESOURCE__PATH = eINSTANCE.getFileResource_Path();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.impl.LocalResourceImpl <em>Local Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.impl.LocalResourceImpl
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getLocalResource()
		 * @generated
		 */
		EClass LOCAL_RESOURCE = eINSTANCE.getLocalResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.impl.AbstractModuleResourceImpl <em>Abstract Module Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.impl.AbstractModuleResourceImpl
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getAbstractModuleResource()
		 * @generated
		 */
		EClass ABSTRACT_MODULE_RESOURCE = eINSTANCE.getAbstractModuleResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.impl.ModuleResourceImpl <em>Module Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.impl.ModuleResourceImpl
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getModuleResource()
		 * @generated
		 */
		EClass MODULE_RESOURCE = eINSTANCE.getModuleResource();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE_RESOURCE__MODULE = eINSTANCE.getModuleResource_Module();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.impl.StringModuleResourceImpl <em>String Module Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.impl.StringModuleResourceImpl
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getStringModuleResource()
		 * @generated
		 */
		EClass STRING_MODULE_RESOURCE = eINSTANCE.getStringModuleResource();

		/**
		 * The meta object literal for the '<em><b>Module Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_MODULE_RESOURCE__MODULE_NAME = eINSTANCE.getStringModuleResource_ModuleName();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.impl.FileImageImpl <em>File Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.impl.FileImageImpl
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getFileImage()
		 * @generated
		 */
		EClass FILE_IMAGE = eINSTANCE.getFileImage();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_IMAGE__FILE = eINSTANCE.getFileImage_File();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.resource.ESampling <em>ESampling</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.resource.ESampling
		 * @see org.sheepy.lily.core.model.resource.impl.ResourcePackageImpl#getESampling()
		 * @generated
		 */
		EEnum ESAMPLING = eINSTANCE.getESampling();

	}

} //ResourcePackage
