/**
 */
package org.sheepy.lily.core.model.application;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.model.inference.InferencePackage;
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
 * @see org.sheepy.lily.core.model.application.ApplicationFactory
 * @model kind="package"
 * @generated
 */
public interface ApplicationPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "application";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.core.model.application";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "application";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ApplicationPackage eINSTANCE = org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getApplication()
	 * @generated
	 */
	int APPLICATION = 0;

	/**
	 * The feature id for the '<em><b>Engines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__ENGINES = 0;

	/**
	 * The feature id for the '<em><b>Run</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__RUN = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__TITLE = 2;

	/**
	 * The feature id for the '<em><b>Scene</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__SCENE = 3;

	/**
	 * The feature id for the '<em><b>Time Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__TIME_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Extension Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__EXTENSION_PKG = 5;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__MODELS = 6;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.IApplicationExtension <em>IApplication Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.IApplicationExtension
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIApplicationExtension()
	 * @generated
	 */
	int IAPPLICATION_EXTENSION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAPPLICATION_EXTENSION__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>IApplication Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAPPLICATION_EXTENSION_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IApplication Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAPPLICATION_EXTENSION_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.ApplicationExtensionPkgImpl <em>Extension Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationExtensionPkgImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getApplicationExtensionPkg()
	 * @generated
	 */
	int APPLICATION_EXTENSION_PKG = 2;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_EXTENSION_PKG__EXTENSIONS = 0;

	/**
	 * The number of structural features of the '<em>Extension Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_EXTENSION_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Extension Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_EXTENSION_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.TimeConfigurationImpl <em>Time Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.TimeConfigurationImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getTimeConfiguration()
	 * @generated
	 */
	int TIME_CONFIGURATION = 3;

	/**
	 * The feature id for the '<em><b>Time Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONFIGURATION__TIME_STEP = 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONFIGURATION__UNIT = 1;

	/**
	 * The feature id for the '<em><b>Time Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONFIGURATION__TIME_FACTOR = 2;

	/**
	 * The number of structural features of the '<em>Time Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Time Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.IEngine <em>IEngine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.IEngine
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIEngine()
	 * @generated
	 */
	int IENGINE = 4;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE__RESOURCE_PKG = 0;

	/**
	 * The number of structural features of the '<em>IEngine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>IEngine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.IModelImpl <em>IModel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.IModelImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIModel()
	 * @generated
	 */
	int IMODEL = 5;

	/**
	 * The number of structural features of the '<em>IModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMODEL_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.IScenePart <em>IScene Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.IScenePart
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIScenePart()
	 * @generated
	 */
	int ISCENE_PART = 6;

	/**
	 * The number of structural features of the '<em>IScene Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISCENE_PART_FEATURE_COUNT = InferencePackage.IINFERENCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISCENE_PART___LINFERENCE_OBJECT = InferencePackage.IINFERENCE_OBJECT___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>IScene Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISCENE_PART_OPERATION_COUNT = InferencePackage.IINFERENCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.ICadence <em>ICadence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.ICadence
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getICadence()
	 * @generated
	 */
	int ICADENCE = 7;

	/**
	 * The number of structural features of the '<em>ICadence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICADENCE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>ICadence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICADENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.SceneImpl <em>Scene</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.SceneImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getScene()
	 * @generated
	 */
	int SCENE = 8;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE__PARTS = 0;

	/**
	 * The feature id for the '<em><b>Fullscreen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE__FULLSCREEN = 1;

	/**
	 * The feature id for the '<em><b>Resizeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE__RESIZEABLE = 2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE__SIZE = 3;

	/**
	 * The number of structural features of the '<em>Scene</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Scene</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.GenericScenePartImpl <em>Generic Scene Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.GenericScenePartImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getGenericScenePart()
	 * @generated
	 */
	int GENERIC_SCENE_PART = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCENE_PART__NAME = ISCENE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Generic Scene Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCENE_PART_FEATURE_COUNT = ISCENE_PART_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCENE_PART___LINFERENCE_OBJECT = ISCENE_PART___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Generic Scene Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCENE_PART_OPERATION_COUNT = ISCENE_PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl <em>Background Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.BackgroundImageImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getBackgroundImage()
	 * @generated
	 */
	int BACKGROUND_IMAGE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_IMAGE__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_IMAGE__IMAGE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Clear Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_IMAGE__CLEAR_COLOR = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sampling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_IMAGE__SAMPLING = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Background Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_IMAGE_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_IMAGE___LINFERENCE_OBJECT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Background Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_IMAGE_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.ResourcePkgImpl <em>Resource Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.ResourcePkgImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getResourcePkg()
	 * @generated
	 */
	int RESOURCE_PKG = 11;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PKG__RESOURCES = 0;

	/**
	 * The number of structural features of the '<em>Resource Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Resource Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.IResourceImpl <em>IResource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.IResourceImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIResource()
	 * @generated
	 */
	int IRESOURCE = 12;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.IImage <em>IImage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.IImage
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIImage()
	 * @generated
	 */
	int IIMAGE = 13;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.VirtualResourceImpl <em>Virtual Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.VirtualResourceImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getVirtualResource()
	 * @generated
	 */
	int VIRTUAL_RESOURCE = 14;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.FileResourceImpl <em>File Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.FileResourceImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getFileResource()
	 * @generated
	 */
	int FILE_RESOURCE = 15;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.LocalResourceImpl <em>Local Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.LocalResourceImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getLocalResource()
	 * @generated
	 */
	int LOCAL_RESOURCE = 16;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.AbstractModuleResourceImpl <em>Abstract Module Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.AbstractModuleResourceImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getAbstractModuleResource()
	 * @generated
	 */
	int ABSTRACT_MODULE_RESOURCE = 17;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.ModuleResourceImpl <em>Module Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.ModuleResourceImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getModuleResource()
	 * @generated
	 */
	int MODULE_RESOURCE = 18;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.StringModuleResourceImpl <em>String Module Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.StringModuleResourceImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getStringModuleResource()
	 * @generated
	 */
	int STRING_MODULE_RESOURCE = 19;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.ESampling <em>ESampling</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.ESampling
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getESampling()
	 * @generated
	 */
	int ESAMPLING = 20;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see org.sheepy.lily.core.model.application.Application
	 * @generated
	 */
	EClass getApplication();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.application.Application#getEngines <em>Engines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Engines</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#getEngines()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_Engines();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.Application#isRun <em>Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Run</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#isRun()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_Run();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.Application#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#getTitle()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_Title();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.application.Application#getScene <em>Scene</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scene</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#getScene()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_Scene();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.application.Application#getTimeConfiguration <em>Time Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Configuration</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#getTimeConfiguration()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_TimeConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.application.Application#getExtensionPkg <em>Extension Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension Pkg</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#getExtensionPkg()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_ExtensionPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.application.Application#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Models</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#getModels()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_Models();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.IApplicationExtension <em>IApplication Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IApplication Extension</em>'.
	 * @see org.sheepy.lily.core.model.application.IApplicationExtension
	 * @generated
	 */
	EClass getIApplicationExtension();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.ApplicationExtensionPkg <em>Extension Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Pkg</em>'.
	 * @see org.sheepy.lily.core.model.application.ApplicationExtensionPkg
	 * @generated
	 */
	EClass getApplicationExtensionPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.application.ApplicationExtensionPkg#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extensions</em>'.
	 * @see org.sheepy.lily.core.model.application.ApplicationExtensionPkg#getExtensions()
	 * @see #getApplicationExtensionPkg()
	 * @generated
	 */
	EReference getApplicationExtensionPkg_Extensions();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.TimeConfiguration <em>Time Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Configuration</em>'.
	 * @see org.sheepy.lily.core.model.application.TimeConfiguration
	 * @generated
	 */
	EClass getTimeConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.TimeConfiguration#getTimeStep <em>Time Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Step</em>'.
	 * @see org.sheepy.lily.core.model.application.TimeConfiguration#getTimeStep()
	 * @see #getTimeConfiguration()
	 * @generated
	 */
	EAttribute getTimeConfiguration_TimeStep();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.TimeConfiguration#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see org.sheepy.lily.core.model.application.TimeConfiguration#getUnit()
	 * @see #getTimeConfiguration()
	 * @generated
	 */
	EAttribute getTimeConfiguration_Unit();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.TimeConfiguration#getTimeFactor <em>Time Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Factor</em>'.
	 * @see org.sheepy.lily.core.model.application.TimeConfiguration#getTimeFactor()
	 * @see #getTimeConfiguration()
	 * @generated
	 */
	EAttribute getTimeConfiguration_TimeFactor();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.IEngine <em>IEngine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IEngine</em>'.
	 * @see org.sheepy.lily.core.model.application.IEngine
	 * @generated
	 */
	EClass getIEngine();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.application.IEngine#getResourcePkg <em>Resource Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Pkg</em>'.
	 * @see org.sheepy.lily.core.model.application.IEngine#getResourcePkg()
	 * @see #getIEngine()
	 * @generated
	 */
	EReference getIEngine_ResourcePkg();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.IModel <em>IModel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IModel</em>'.
	 * @see org.sheepy.lily.core.model.application.IModel
	 * @generated
	 */
	EClass getIModel();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.IScenePart <em>IScene Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IScene Part</em>'.
	 * @see org.sheepy.lily.core.model.application.IScenePart
	 * @generated
	 */
	EClass getIScenePart();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.ICadence <em>ICadence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ICadence</em>'.
	 * @see org.sheepy.lily.core.model.application.ICadence
	 * @generated
	 */
	EClass getICadence();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.Scene <em>Scene</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scene</em>'.
	 * @see org.sheepy.lily.core.model.application.Scene
	 * @generated
	 */
	EClass getScene();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.application.Scene#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.sheepy.lily.core.model.application.Scene#getParts()
	 * @see #getScene()
	 * @generated
	 */
	EReference getScene_Parts();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.Scene#isFullscreen <em>Fullscreen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fullscreen</em>'.
	 * @see org.sheepy.lily.core.model.application.Scene#isFullscreen()
	 * @see #getScene()
	 * @generated
	 */
	EAttribute getScene_Fullscreen();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.Scene#isResizeable <em>Resizeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resizeable</em>'.
	 * @see org.sheepy.lily.core.model.application.Scene#isResizeable()
	 * @see #getScene()
	 * @generated
	 */
	EAttribute getScene_Resizeable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.Scene#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.core.model.application.Scene#getSize()
	 * @see #getScene()
	 * @generated
	 */
	EAttribute getScene_Size();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.GenericScenePart <em>Generic Scene Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Scene Part</em>'.
	 * @see org.sheepy.lily.core.model.application.GenericScenePart
	 * @generated
	 */
	EClass getGenericScenePart();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.BackgroundImage <em>Background Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Background Image</em>'.
	 * @see org.sheepy.lily.core.model.application.BackgroundImage
	 * @generated
	 */
	EClass getBackgroundImage();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.application.BackgroundImage#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.lily.core.model.application.BackgroundImage#getImage()
	 * @see #getBackgroundImage()
	 * @generated
	 */
	EReference getBackgroundImage_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.BackgroundImage#getClearColor <em>Clear Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clear Color</em>'.
	 * @see org.sheepy.lily.core.model.application.BackgroundImage#getClearColor()
	 * @see #getBackgroundImage()
	 * @generated
	 */
	EAttribute getBackgroundImage_ClearColor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.BackgroundImage#getSampling <em>Sampling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sampling</em>'.
	 * @see org.sheepy.lily.core.model.application.BackgroundImage#getSampling()
	 * @see #getBackgroundImage()
	 * @generated
	 */
	EAttribute getBackgroundImage_Sampling();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.ResourcePkg <em>Resource Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Pkg</em>'.
	 * @see org.sheepy.lily.core.model.application.ResourcePkg
	 * @generated
	 */
	EClass getResourcePkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.application.ResourcePkg#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see org.sheepy.lily.core.model.application.ResourcePkg#getResources()
	 * @see #getResourcePkg()
	 * @generated
	 */
	EReference getResourcePkg_Resources();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.IResource <em>IResource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IResource</em>'.
	 * @see org.sheepy.lily.core.model.application.IResource
	 * @generated
	 */
	EClass getIResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.IImage <em>IImage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IImage</em>'.
	 * @see org.sheepy.lily.core.model.application.IImage
	 * @generated
	 */
	EClass getIImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.VirtualResource <em>Virtual Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Resource</em>'.
	 * @see org.sheepy.lily.core.model.application.VirtualResource
	 * @generated
	 */
	EClass getVirtualResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.FileResource <em>File Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Resource</em>'.
	 * @see org.sheepy.lily.core.model.application.FileResource
	 * @generated
	 */
	EClass getFileResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.FileResource#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.sheepy.lily.core.model.application.FileResource#getPath()
	 * @see #getFileResource()
	 * @generated
	 */
	EAttribute getFileResource_Path();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.LocalResource <em>Local Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Resource</em>'.
	 * @see org.sheepy.lily.core.model.application.LocalResource
	 * @generated
	 */
	EClass getLocalResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.AbstractModuleResource <em>Abstract Module Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Module Resource</em>'.
	 * @see org.sheepy.lily.core.model.application.AbstractModuleResource
	 * @generated
	 */
	EClass getAbstractModuleResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.ModuleResource <em>Module Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Resource</em>'.
	 * @see org.sheepy.lily.core.model.application.ModuleResource
	 * @generated
	 */
	EClass getModuleResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.ModuleResource#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module</em>'.
	 * @see org.sheepy.lily.core.model.application.ModuleResource#getModule()
	 * @see #getModuleResource()
	 * @generated
	 */
	EAttribute getModuleResource_Module();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.StringModuleResource <em>String Module Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Module Resource</em>'.
	 * @see org.sheepy.lily.core.model.application.StringModuleResource
	 * @generated
	 */
	EClass getStringModuleResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.StringModuleResource#getModuleName <em>Module Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module Name</em>'.
	 * @see org.sheepy.lily.core.model.application.StringModuleResource#getModuleName()
	 * @see #getStringModuleResource()
	 * @generated
	 */
	EAttribute getStringModuleResource_ModuleName();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.application.ESampling <em>ESampling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ESampling</em>'.
	 * @see org.sheepy.lily.core.model.application.ESampling
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
	ApplicationFactory getApplicationFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getApplication()
		 * @generated
		 */
		EClass APPLICATION = eINSTANCE.getApplication();

		/**
		 * The meta object literal for the '<em><b>Engines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__ENGINES = eINSTANCE.getApplication_Engines();

		/**
		 * The meta object literal for the '<em><b>Run</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__RUN = eINSTANCE.getApplication_Run();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__TITLE = eINSTANCE.getApplication_Title();

		/**
		 * The meta object literal for the '<em><b>Scene</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__SCENE = eINSTANCE.getApplication_Scene();

		/**
		 * The meta object literal for the '<em><b>Time Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__TIME_CONFIGURATION = eINSTANCE.getApplication_TimeConfiguration();

		/**
		 * The meta object literal for the '<em><b>Extension Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__EXTENSION_PKG = eINSTANCE.getApplication_ExtensionPkg();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__MODELS = eINSTANCE.getApplication_Models();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.IApplicationExtension <em>IApplication Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.IApplicationExtension
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIApplicationExtension()
		 * @generated
		 */
		EClass IAPPLICATION_EXTENSION = eINSTANCE.getIApplicationExtension();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.ApplicationExtensionPkgImpl <em>Extension Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationExtensionPkgImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getApplicationExtensionPkg()
		 * @generated
		 */
		EClass APPLICATION_EXTENSION_PKG = eINSTANCE.getApplicationExtensionPkg();

		/**
		 * The meta object literal for the '<em><b>Extensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_EXTENSION_PKG__EXTENSIONS = eINSTANCE.getApplicationExtensionPkg_Extensions();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.TimeConfigurationImpl <em>Time Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.TimeConfigurationImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getTimeConfiguration()
		 * @generated
		 */
		EClass TIME_CONFIGURATION = eINSTANCE.getTimeConfiguration();

		/**
		 * The meta object literal for the '<em><b>Time Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONFIGURATION__TIME_STEP = eINSTANCE.getTimeConfiguration_TimeStep();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONFIGURATION__UNIT = eINSTANCE.getTimeConfiguration_Unit();

		/**
		 * The meta object literal for the '<em><b>Time Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONFIGURATION__TIME_FACTOR = eINSTANCE.getTimeConfiguration_TimeFactor();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.IEngine <em>IEngine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.IEngine
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIEngine()
		 * @generated
		 */
		EClass IENGINE = eINSTANCE.getIEngine();

		/**
		 * The meta object literal for the '<em><b>Resource Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IENGINE__RESOURCE_PKG = eINSTANCE.getIEngine_ResourcePkg();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.IModelImpl <em>IModel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.IModelImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIModel()
		 * @generated
		 */
		EClass IMODEL = eINSTANCE.getIModel();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.IScenePart <em>IScene Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.IScenePart
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIScenePart()
		 * @generated
		 */
		EClass ISCENE_PART = eINSTANCE.getIScenePart();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.ICadence <em>ICadence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.ICadence
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getICadence()
		 * @generated
		 */
		EClass ICADENCE = eINSTANCE.getICadence();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.SceneImpl <em>Scene</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.SceneImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getScene()
		 * @generated
		 */
		EClass SCENE = eINSTANCE.getScene();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENE__PARTS = eINSTANCE.getScene_Parts();

		/**
		 * The meta object literal for the '<em><b>Fullscreen</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENE__FULLSCREEN = eINSTANCE.getScene_Fullscreen();

		/**
		 * The meta object literal for the '<em><b>Resizeable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENE__RESIZEABLE = eINSTANCE.getScene_Resizeable();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENE__SIZE = eINSTANCE.getScene_Size();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.GenericScenePartImpl <em>Generic Scene Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.GenericScenePartImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getGenericScenePart()
		 * @generated
		 */
		EClass GENERIC_SCENE_PART = eINSTANCE.getGenericScenePart();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl <em>Background Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.BackgroundImageImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getBackgroundImage()
		 * @generated
		 */
		EClass BACKGROUND_IMAGE = eINSTANCE.getBackgroundImage();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BACKGROUND_IMAGE__IMAGE = eINSTANCE.getBackgroundImage_Image();

		/**
		 * The meta object literal for the '<em><b>Clear Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKGROUND_IMAGE__CLEAR_COLOR = eINSTANCE.getBackgroundImage_ClearColor();

		/**
		 * The meta object literal for the '<em><b>Sampling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKGROUND_IMAGE__SAMPLING = eINSTANCE.getBackgroundImage_Sampling();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.ResourcePkgImpl <em>Resource Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.ResourcePkgImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getResourcePkg()
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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.IResourceImpl <em>IResource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.IResourceImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIResource()
		 * @generated
		 */
		EClass IRESOURCE = eINSTANCE.getIResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.IImage <em>IImage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.IImage
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIImage()
		 * @generated
		 */
		EClass IIMAGE = eINSTANCE.getIImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.VirtualResourceImpl <em>Virtual Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.VirtualResourceImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getVirtualResource()
		 * @generated
		 */
		EClass VIRTUAL_RESOURCE = eINSTANCE.getVirtualResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.FileResourceImpl <em>File Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.FileResourceImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getFileResource()
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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.LocalResourceImpl <em>Local Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.LocalResourceImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getLocalResource()
		 * @generated
		 */
		EClass LOCAL_RESOURCE = eINSTANCE.getLocalResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.AbstractModuleResourceImpl <em>Abstract Module Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.AbstractModuleResourceImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getAbstractModuleResource()
		 * @generated
		 */
		EClass ABSTRACT_MODULE_RESOURCE = eINSTANCE.getAbstractModuleResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.ModuleResourceImpl <em>Module Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.ModuleResourceImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getModuleResource()
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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.StringModuleResourceImpl <em>String Module Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.StringModuleResourceImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getStringModuleResource()
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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.ESampling <em>ESampling</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.ESampling
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getESampling()
		 * @generated
		 */
		EEnum ESAMPLING = eINSTANCE.getESampling();

	}

} //ApplicationPackage
