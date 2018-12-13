/**
 */
package org.sheepy.common.model.presentation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.common.model.application.ApplicationPackage;

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
 * @see org.sheepy.common.model.presentation.PresentationFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.common.model/src/generated/java' editDirectory='/org.sheepy.common.model.edit/src/generated/java' publicConstructors='true' extensibleProviderFactory='true' childCreationExtenders='true' basePackage='org.sheepy.common.model'"
 * @generated
 */
public interface PresentationPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "presentation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.common.model.presentation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "presentation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PresentationPackage eINSTANCE = org.sheepy.common.model.presentation.impl.PresentationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.presentation.IPresentationElement <em>IPresentation Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.presentation.IPresentationElement
	 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getIPresentationElement()
	 * @generated
	 */
	int IPRESENTATION_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPRESENTATION_ELEMENT__POSITION = 0;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPRESENTATION_ELEMENT__WIDTH = 1;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPRESENTATION_ELEMENT__HEIGHT = 2;

	/**
	 * The number of structural features of the '<em>IPresentation Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPRESENTATION_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>IPresentation Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPRESENTATION_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.presentation.IUIView <em>IUI View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.presentation.IUIView
	 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getIUIView()
	 * @generated
	 */
	int IUI_VIEW = 1;

	/**
	 * The feature id for the '<em><b>Ui Pages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW__UI_PAGES = ApplicationPackage.IVIEW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IUI View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW_FEATURE_COUNT = ApplicationPackage.IVIEW_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>IUI View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW_OPERATION_COUNT = ApplicationPackage.IVIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.presentation.IMusicView <em>IMusic View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.presentation.IMusicView
	 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getIMusicView()
	 * @generated
	 */
	int IMUSIC_VIEW = 2;

	/**
	 * The feature id for the '<em><b>Music Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMUSIC_VIEW__MUSIC_PATH = ApplicationPackage.IVIEW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IMusic View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMUSIC_VIEW_FEATURE_COUNT = ApplicationPackage.IVIEW_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>IMusic View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMUSIC_VIEW_OPERATION_COUNT = ApplicationPackage.IVIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.presentation.ISizedView <em>ISized View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.presentation.ISizedView
	 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getISizedView()
	 * @generated
	 */
	int ISIZED_VIEW = 3;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__POSITION = IPRESENTATION_ELEMENT__POSITION;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__WIDTH = IPRESENTATION_ELEMENT__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__HEIGHT = IPRESENTATION_ELEMENT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Moveable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__MOVEABLE = IPRESENTATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Closeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__CLOSEABLE = IPRESENTATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scalable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__SCALABLE = IPRESENTATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Show Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__SHOW_TITLE = IPRESENTATION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fullscreen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__FULLSCREEN = IPRESENTATION_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>ISized View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW_FEATURE_COUNT = IPRESENTATION_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>ISized View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW_OPERATION_COUNT = IPRESENTATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.presentation.impl.UIElementImpl <em>UI Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.presentation.impl.UIElementImpl
	 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getUIElement()
	 * @generated
	 */
	int UI_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT__POSITION = IPRESENTATION_ELEMENT__POSITION;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT__WIDTH = IPRESENTATION_ELEMENT__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT__HEIGHT = IPRESENTATION_ELEMENT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT__VERTICAL_RELATIVE = IPRESENTATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT__HORIZONTAL_RELATIVE = IPRESENTATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UI Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT_FEATURE_COUNT = IPRESENTATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>UI Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT_OPERATION_COUNT = IPRESENTATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.presentation.impl.UIPageImpl <em>UI Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.presentation.impl.UIPageImpl
	 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getUIPage()
	 * @generated
	 */
	int UI_PAGE = 5;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__POSITION = UI_ELEMENT__POSITION;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__WIDTH = UI_ELEMENT__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__HEIGHT = UI_ELEMENT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__VERTICAL_RELATIVE = UI_ELEMENT__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__HORIZONTAL_RELATIVE = UI_ELEMENT__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__CONTROLS = UI_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>UI Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE_FEATURE_COUNT = UI_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>UI Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE_OPERATION_COUNT = UI_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.presentation.impl.ControlImpl <em>Control</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.presentation.impl.ControlImpl
	 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getControl()
	 * @generated
	 */
	int CONTROL = 6;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__POSITION = UI_ELEMENT__POSITION;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__WIDTH = UI_ELEMENT__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__HEIGHT = UI_ELEMENT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__VERTICAL_RELATIVE = UI_ELEMENT__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__HORIZONTAL_RELATIVE = UI_ELEMENT__HORIZONTAL_RELATIVE;

	/**
	 * The number of structural features of the '<em>Control</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FEATURE_COUNT = UI_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Control</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_OPERATION_COUNT = UI_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.presentation.EVerticalRelative <em>EVertical Relative</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.presentation.EVerticalRelative
	 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getEVerticalRelative()
	 * @generated
	 */
	int EVERTICAL_RELATIVE = 7;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.presentation.EHorizontalRelative <em>EHorizontal Relative</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.presentation.EHorizontalRelative
	 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getEHorizontalRelative()
	 * @generated
	 */
	int EHORIZONTAL_RELATIVE = 8;


	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.presentation.IPresentationElement <em>IPresentation Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPresentation Element</em>'.
	 * @see org.sheepy.common.model.presentation.IPresentationElement
	 * @generated
	 */
	EClass getIPresentationElement();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.presentation.IPresentationElement#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see org.sheepy.common.model.presentation.IPresentationElement#getPosition()
	 * @see #getIPresentationElement()
	 * @generated
	 */
	EAttribute getIPresentationElement_Position();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.presentation.IPresentationElement#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.common.model.presentation.IPresentationElement#getWidth()
	 * @see #getIPresentationElement()
	 * @generated
	 */
	EAttribute getIPresentationElement_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.presentation.IPresentationElement#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.common.model.presentation.IPresentationElement#getHeight()
	 * @see #getIPresentationElement()
	 * @generated
	 */
	EAttribute getIPresentationElement_Height();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.presentation.IUIView <em>IUI View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IUI View</em>'.
	 * @see org.sheepy.common.model.presentation.IUIView
	 * @generated
	 */
	EClass getIUIView();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.common.model.presentation.IUIView#getUiPages <em>Ui Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ui Pages</em>'.
	 * @see org.sheepy.common.model.presentation.IUIView#getUiPages()
	 * @see #getIUIView()
	 * @generated
	 */
	EReference getIUIView_UiPages();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.presentation.IMusicView <em>IMusic View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IMusic View</em>'.
	 * @see org.sheepy.common.model.presentation.IMusicView
	 * @generated
	 */
	EClass getIMusicView();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.presentation.IMusicView#getMusicPath <em>Music Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Music Path</em>'.
	 * @see org.sheepy.common.model.presentation.IMusicView#getMusicPath()
	 * @see #getIMusicView()
	 * @generated
	 */
	EAttribute getIMusicView_MusicPath();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.presentation.ISizedView <em>ISized View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISized View</em>'.
	 * @see org.sheepy.common.model.presentation.ISizedView
	 * @generated
	 */
	EClass getISizedView();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.presentation.ISizedView#isMoveable <em>Moveable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Moveable</em>'.
	 * @see org.sheepy.common.model.presentation.ISizedView#isMoveable()
	 * @see #getISizedView()
	 * @generated
	 */
	EAttribute getISizedView_Moveable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.presentation.ISizedView#isCloseable <em>Closeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Closeable</em>'.
	 * @see org.sheepy.common.model.presentation.ISizedView#isCloseable()
	 * @see #getISizedView()
	 * @generated
	 */
	EAttribute getISizedView_Closeable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.presentation.ISizedView#isScalable <em>Scalable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scalable</em>'.
	 * @see org.sheepy.common.model.presentation.ISizedView#isScalable()
	 * @see #getISizedView()
	 * @generated
	 */
	EAttribute getISizedView_Scalable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.presentation.ISizedView#isShowTitle <em>Show Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Title</em>'.
	 * @see org.sheepy.common.model.presentation.ISizedView#isShowTitle()
	 * @see #getISizedView()
	 * @generated
	 */
	EAttribute getISizedView_ShowTitle();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.presentation.ISizedView#isFullscreen <em>Fullscreen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fullscreen</em>'.
	 * @see org.sheepy.common.model.presentation.ISizedView#isFullscreen()
	 * @see #getISizedView()
	 * @generated
	 */
	EAttribute getISizedView_Fullscreen();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.presentation.UIElement <em>UI Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Element</em>'.
	 * @see org.sheepy.common.model.presentation.UIElement
	 * @generated
	 */
	EClass getUIElement();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.presentation.UIElement#getVerticalRelative <em>Vertical Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertical Relative</em>'.
	 * @see org.sheepy.common.model.presentation.UIElement#getVerticalRelative()
	 * @see #getUIElement()
	 * @generated
	 */
	EAttribute getUIElement_VerticalRelative();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.presentation.UIElement#getHorizontalRelative <em>Horizontal Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Horizontal Relative</em>'.
	 * @see org.sheepy.common.model.presentation.UIElement#getHorizontalRelative()
	 * @see #getUIElement()
	 * @generated
	 */
	EAttribute getUIElement_HorizontalRelative();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.presentation.UIPage <em>UI Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Page</em>'.
	 * @see org.sheepy.common.model.presentation.UIPage
	 * @generated
	 */
	EClass getUIPage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.common.model.presentation.UIPage#getControls <em>Controls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Controls</em>'.
	 * @see org.sheepy.common.model.presentation.UIPage#getControls()
	 * @see #getUIPage()
	 * @generated
	 */
	EReference getUIPage_Controls();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.presentation.Control <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control</em>'.
	 * @see org.sheepy.common.model.presentation.Control
	 * @generated
	 */
	EClass getControl();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.common.model.presentation.EVerticalRelative <em>EVertical Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EVertical Relative</em>'.
	 * @see org.sheepy.common.model.presentation.EVerticalRelative
	 * @generated
	 */
	EEnum getEVerticalRelative();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.common.model.presentation.EHorizontalRelative <em>EHorizontal Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EHorizontal Relative</em>'.
	 * @see org.sheepy.common.model.presentation.EHorizontalRelative
	 * @generated
	 */
	EEnum getEHorizontalRelative();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PresentationFactory getPresentationFactory();

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
		 * The meta object literal for the '{@link org.sheepy.common.model.presentation.IPresentationElement <em>IPresentation Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.presentation.IPresentationElement
		 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getIPresentationElement()
		 * @generated
		 */
		EClass IPRESENTATION_ELEMENT = eINSTANCE.getIPresentationElement();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPRESENTATION_ELEMENT__POSITION = eINSTANCE.getIPresentationElement_Position();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPRESENTATION_ELEMENT__WIDTH = eINSTANCE.getIPresentationElement_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPRESENTATION_ELEMENT__HEIGHT = eINSTANCE.getIPresentationElement_Height();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.presentation.IUIView <em>IUI View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.presentation.IUIView
		 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getIUIView()
		 * @generated
		 */
		EClass IUI_VIEW = eINSTANCE.getIUIView();

		/**
		 * The meta object literal for the '<em><b>Ui Pages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IUI_VIEW__UI_PAGES = eINSTANCE.getIUIView_UiPages();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.presentation.IMusicView <em>IMusic View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.presentation.IMusicView
		 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getIMusicView()
		 * @generated
		 */
		EClass IMUSIC_VIEW = eINSTANCE.getIMusicView();

		/**
		 * The meta object literal for the '<em><b>Music Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMUSIC_VIEW__MUSIC_PATH = eINSTANCE.getIMusicView_MusicPath();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.presentation.ISizedView <em>ISized View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.presentation.ISizedView
		 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getISizedView()
		 * @generated
		 */
		EClass ISIZED_VIEW = eINSTANCE.getISizedView();

		/**
		 * The meta object literal for the '<em><b>Moveable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISIZED_VIEW__MOVEABLE = eINSTANCE.getISizedView_Moveable();

		/**
		 * The meta object literal for the '<em><b>Closeable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISIZED_VIEW__CLOSEABLE = eINSTANCE.getISizedView_Closeable();

		/**
		 * The meta object literal for the '<em><b>Scalable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISIZED_VIEW__SCALABLE = eINSTANCE.getISizedView_Scalable();

		/**
		 * The meta object literal for the '<em><b>Show Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISIZED_VIEW__SHOW_TITLE = eINSTANCE.getISizedView_ShowTitle();

		/**
		 * The meta object literal for the '<em><b>Fullscreen</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISIZED_VIEW__FULLSCREEN = eINSTANCE.getISizedView_Fullscreen();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.presentation.impl.UIElementImpl <em>UI Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.presentation.impl.UIElementImpl
		 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getUIElement()
		 * @generated
		 */
		EClass UI_ELEMENT = eINSTANCE.getUIElement();

		/**
		 * The meta object literal for the '<em><b>Vertical Relative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_ELEMENT__VERTICAL_RELATIVE = eINSTANCE.getUIElement_VerticalRelative();

		/**
		 * The meta object literal for the '<em><b>Horizontal Relative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_ELEMENT__HORIZONTAL_RELATIVE = eINSTANCE.getUIElement_HorizontalRelative();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.presentation.impl.UIPageImpl <em>UI Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.presentation.impl.UIPageImpl
		 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getUIPage()
		 * @generated
		 */
		EClass UI_PAGE = eINSTANCE.getUIPage();

		/**
		 * The meta object literal for the '<em><b>Controls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_PAGE__CONTROLS = eINSTANCE.getUIPage_Controls();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.presentation.impl.ControlImpl <em>Control</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.presentation.impl.ControlImpl
		 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getControl()
		 * @generated
		 */
		EClass CONTROL = eINSTANCE.getControl();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.presentation.EVerticalRelative <em>EVertical Relative</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.presentation.EVerticalRelative
		 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getEVerticalRelative()
		 * @generated
		 */
		EEnum EVERTICAL_RELATIVE = eINSTANCE.getEVerticalRelative();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.presentation.EHorizontalRelative <em>EHorizontal Relative</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.presentation.EHorizontalRelative
		 * @see org.sheepy.common.model.presentation.impl.PresentationPackageImpl#getEHorizontalRelative()
		 * @generated
		 */
		EEnum EHORIZONTAL_RELATIVE = eINSTANCE.getEHorizontalRelative();

	}

} //PresentationPackage
