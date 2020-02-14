/**
 */
package org.sheepy.lily.core.model.application;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	 * The feature id for the '<em><b>Clear Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_IMAGE__CLEAR_COLOR = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sampling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_IMAGE__SAMPLING = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Src Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_IMAGE__SRC_IMAGE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dst Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_IMAGE__DST_IMAGE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Background Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_IMAGE_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 4;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl <em>Screen Effect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.ScreenEffectImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getScreenEffect()
	 * @generated
	 */
	int SCREEN_EFFECT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_EFFECT__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_EFFECT__INPUTS = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_EFFECT__SRC_IMAGE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dst Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_EFFECT__DST_IMAGE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Shader</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_EFFECT__SHADER = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Screen Effect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_EFFECT_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_EFFECT___LINFERENCE_OBJECT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Screen Effect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_EFFECT_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 1;

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
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.application.BackgroundImage#getSrcImage <em>Src Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src Image</em>'.
	 * @see org.sheepy.lily.core.model.application.BackgroundImage#getSrcImage()
	 * @see #getBackgroundImage()
	 * @generated
	 */
	EReference getBackgroundImage_SrcImage();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.application.BackgroundImage#getDstImage <em>Dst Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dst Image</em>'.
	 * @see org.sheepy.lily.core.model.application.BackgroundImage#getDstImage()
	 * @see #getBackgroundImage()
	 * @generated
	 */
	EReference getBackgroundImage_DstImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.ScreenEffect <em>Screen Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Screen Effect</em>'.
	 * @see org.sheepy.lily.core.model.application.ScreenEffect
	 * @generated
	 */
	EClass getScreenEffect();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.core.model.application.ScreenEffect#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.sheepy.lily.core.model.application.ScreenEffect#getInputs()
	 * @see #getScreenEffect()
	 * @generated
	 */
	EReference getScreenEffect_Inputs();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.application.ScreenEffect#getSrcImage <em>Src Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src Image</em>'.
	 * @see org.sheepy.lily.core.model.application.ScreenEffect#getSrcImage()
	 * @see #getScreenEffect()
	 * @generated
	 */
	EReference getScreenEffect_SrcImage();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.application.ScreenEffect#getDstImage <em>Dst Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dst Image</em>'.
	 * @see org.sheepy.lily.core.model.application.ScreenEffect#getDstImage()
	 * @see #getScreenEffect()
	 * @generated
	 */
	EReference getScreenEffect_DstImage();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.application.ScreenEffect#getShader <em>Shader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Shader</em>'.
	 * @see org.sheepy.lily.core.model.application.ScreenEffect#getShader()
	 * @see #getScreenEffect()
	 * @generated
	 */
	EReference getScreenEffect_Shader();

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
		 * The meta object literal for the '<em><b>Src Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BACKGROUND_IMAGE__SRC_IMAGE = eINSTANCE.getBackgroundImage_SrcImage();

		/**
		 * The meta object literal for the '<em><b>Dst Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BACKGROUND_IMAGE__DST_IMAGE = eINSTANCE.getBackgroundImage_DstImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl <em>Screen Effect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.impl.ScreenEffectImpl
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getScreenEffect()
		 * @generated
		 */
		EClass SCREEN_EFFECT = eINSTANCE.getScreenEffect();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCREEN_EFFECT__INPUTS = eINSTANCE.getScreenEffect_Inputs();

		/**
		 * The meta object literal for the '<em><b>Src Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCREEN_EFFECT__SRC_IMAGE = eINSTANCE.getScreenEffect_SrcImage();

		/**
		 * The meta object literal for the '<em><b>Dst Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCREEN_EFFECT__DST_IMAGE = eINSTANCE.getScreenEffect_DstImage();

		/**
		 * The meta object literal for the '<em><b>Shader</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCREEN_EFFECT__SHADER = eINSTANCE.getScreenEffect_Shader();

	}

} //ApplicationPackage
