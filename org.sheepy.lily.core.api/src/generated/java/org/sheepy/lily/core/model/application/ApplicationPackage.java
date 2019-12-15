/**
 */
package org.sheepy.lily.core.model.application;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.model.inference.InferencePackage;

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
	 * The feature id for the '<em><b>Fullscreen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__FULLSCREEN = 2;

	/**
	 * The feature id for the '<em><b>Resizeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__RESIZEABLE = 3;

	/**
	 * The feature id for the '<em><b>Headless</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__HEADLESS = 4;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__TITLE = 5;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__SIZE = 6;

	/**
	 * The feature id for the '<em><b>View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__VIEW = 7;

	/**
	 * The feature id for the '<em><b>Time Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__TIME_CONFIGURATION = 8;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.impl.TimeConfigurationImpl <em>Time Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.impl.TimeConfigurationImpl
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getTimeConfiguration()
	 * @generated
	 */
	int TIME_CONFIGURATION = 1;

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
	int IENGINE = 2;

	/**
	 * The feature id for the '<em><b>Cadence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE__CADENCE = 0;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.IView <em>IView</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.IView
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIView()
	 * @generated
	 */
	int IVIEW = 3;

	/**
	 * The number of structural features of the '<em>IView</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIEW_FEATURE_COUNT = InferencePackage.IINFERENCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIEW___LINFERENCE_OBJECT = InferencePackage.IINFERENCE_OBJECT___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>IView</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIEW_OPERATION_COUNT = InferencePackage.IINFERENCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.ICadence <em>ICadence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.ICadence
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getICadence()
	 * @generated
	 */
	int ICADENCE = 4;

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.Application#isFullscreen <em>Fullscreen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fullscreen</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#isFullscreen()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_Fullscreen();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.Application#isResizeable <em>Resizeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resizeable</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#isResizeable()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_Resizeable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.Application#isHeadless <em>Headless</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Headless</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#isHeadless()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_Headless();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.Application#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#getSize()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_Size();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.application.Application#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>View</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#getView()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_View();

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
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.application.IEngine#getCadence <em>Cadence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cadence</em>'.
	 * @see org.sheepy.lily.core.model.application.IEngine#getCadence()
	 * @see #getIEngine()
	 * @generated
	 */
	EReference getIEngine_Cadence();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.IView <em>IView</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IView</em>'.
	 * @see org.sheepy.lily.core.model.application.IView
	 * @generated
	 */
	EClass getIView();

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
		 * The meta object literal for the '<em><b>Fullscreen</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__FULLSCREEN = eINSTANCE.getApplication_Fullscreen();

		/**
		 * The meta object literal for the '<em><b>Resizeable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__RESIZEABLE = eINSTANCE.getApplication_Resizeable();

		/**
		 * The meta object literal for the '<em><b>Headless</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__HEADLESS = eINSTANCE.getApplication_Headless();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__TITLE = eINSTANCE.getApplication_Title();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__SIZE = eINSTANCE.getApplication_Size();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__VIEW = eINSTANCE.getApplication_View();

		/**
		 * The meta object literal for the '<em><b>Time Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__TIME_CONFIGURATION = eINSTANCE.getApplication_TimeConfiguration();

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
		 * The meta object literal for the '<em><b>Cadence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IENGINE__CADENCE = eINSTANCE.getIEngine_Cadence();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.IView <em>IView</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.IView
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIView()
		 * @generated
		 */
		EClass IVIEW = eINSTANCE.getIView();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.ICadence <em>ICadence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.ICadence
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getICadence()
		 * @generated
		 */
		EClass ICADENCE = eINSTANCE.getICadence();

	}

} //ApplicationPackage
