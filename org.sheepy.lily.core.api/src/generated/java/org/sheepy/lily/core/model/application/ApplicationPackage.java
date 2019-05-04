/**
 */
package org.sheepy.lily.core.model.application;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.root.RootPackage;

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
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__CONTENT_OBJECTS = RootPackage.LOBJECT__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__VIEWS = RootPackage.LOBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Engines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__ENGINES = RootPackage.LOBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Run</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__RUN = RootPackage.LOBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fullscreen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__FULLSCREEN = RootPackage.LOBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Resizeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__RESIZEABLE = RootPackage.LOBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__TITLE = RootPackage.LOBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__SIZE = RootPackage.LOBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Current View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__CURRENT_VIEW = RootPackage.LOBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Cadence In Hz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__CADENCE_IN_HZ = RootPackage.LOBJECT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = RootPackage.LOBJECT_FEATURE_COUNT + 9;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION___LINFERENCE_OBJECT = RootPackage.LOBJECT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION___CREATE_CONTAINMENT_ELIST__ECLASS = RootPackage.LOBJECT___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION___LCONTENTS = RootPackage.LOBJECT___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION___LPARENT = RootPackage.LOBJECT___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION___LALL_CONTENTS = RootPackage.LOBJECT___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_OPERATION_COUNT = RootPackage.LOBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.IEngine <em>IEngine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.IEngine
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIEngine()
	 * @generated
	 */
	int IENGINE = 1;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE__CONTENT_OBJECTS = RootPackage.LOBJECT__CONTENT_OBJECTS;

	/**
	 * The number of structural features of the '<em>IEngine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE_FEATURE_COUNT = RootPackage.LOBJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE___LINFERENCE_OBJECT = RootPackage.LOBJECT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE___CREATE_CONTAINMENT_ELIST__ECLASS = RootPackage.LOBJECT___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE___LCONTENTS = RootPackage.LOBJECT___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE___LPARENT = RootPackage.LOBJECT___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE___LALL_CONTENTS = RootPackage.LOBJECT___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>IEngine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE_OPERATION_COUNT = RootPackage.LOBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.application.IView <em>IView</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.application.IView
	 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIView()
	 * @generated
	 */
	int IVIEW = 2;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIEW__CONTENT_OBJECTS = RootPackage.LOBJECT__CONTENT_OBJECTS;

	/**
	 * The number of structural features of the '<em>IView</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIEW_FEATURE_COUNT = RootPackage.LOBJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIEW___LINFERENCE_OBJECT = RootPackage.LOBJECT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIEW___CREATE_CONTAINMENT_ELIST__ECLASS = RootPackage.LOBJECT___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIEW___LCONTENTS = RootPackage.LOBJECT___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIEW___LPARENT = RootPackage.LOBJECT___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIEW___LALL_CONTENTS = RootPackage.LOBJECT___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>IView</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIEW_OPERATION_COUNT = RootPackage.LOBJECT_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.application.Application#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Views</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#getViews()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_Views();

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
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.application.Application#getCurrentView <em>Current View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current View</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#getCurrentView()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_CurrentView();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.application.Application#getCadenceInHz <em>Cadence In Hz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cadence In Hz</em>'.
	 * @see org.sheepy.lily.core.model.application.Application#getCadenceInHz()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_CadenceInHz();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.application.IView <em>IView</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IView</em>'.
	 * @see org.sheepy.lily.core.model.application.IView
	 * @generated
	 */
	EClass getIView();

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
		 * The meta object literal for the '<em><b>Views</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__VIEWS = eINSTANCE.getApplication_Views();

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
		 * The meta object literal for the '<em><b>Current View</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__CURRENT_VIEW = eINSTANCE.getApplication_CurrentView();

		/**
		 * The meta object literal for the '<em><b>Cadence In Hz</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__CADENCE_IN_HZ = eINSTANCE.getApplication_CadenceInHz();

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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.application.IView <em>IView</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.application.IView
		 * @see org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl#getIView()
		 * @generated
		 */
		EClass IVIEW = eINSTANCE.getIView();

	}

} //ApplicationPackage
