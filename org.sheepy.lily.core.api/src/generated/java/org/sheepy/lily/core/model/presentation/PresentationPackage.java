/**
 */
package org.sheepy.lily.core.model.presentation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.root.RootPackage;
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
 * @see org.sheepy.lily.core.model.presentation.PresentationFactory
 * @model kind="package"
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
	String eNS_URI = "org.sheepy.lily.core.model.presentation";

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
	PresentationPackage eINSTANCE = org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.presentation.IPositionElement <em>IPosition Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.presentation.IPositionElement
	 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getIPositionElement()
	 * @generated
	 */
	int IPOSITION_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT__CONTENT_OBJECTS = RootPackage.LOBJECT__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT__POSITION = RootPackage.LOBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT__VERTICAL_RELATIVE = RootPackage.LOBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT__HORIZONTAL_RELATIVE = RootPackage.LOBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>IPosition Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT_FEATURE_COUNT = RootPackage.LOBJECT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT___LINFERENCE_OBJECT = RootPackage.LOBJECT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT___CREATE_CONTAINMENT_ELIST__ECLASS = RootPackage.LOBJECT___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT___LCONTENTS = RootPackage.LOBJECT___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT___LPARENT = RootPackage.LOBJECT___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT___LALL_CONTENTS = RootPackage.LOBJECT___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>IPosition Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT_OPERATION_COUNT = RootPackage.LOBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.presentation.ISizedElement <em>ISized Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.presentation.ISizedElement
	 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getISizedElement()
	 * @generated
	 */
	int ISIZED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT__CONTENT_OBJECTS = IPOSITION_ELEMENT__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT__POSITION = IPOSITION_ELEMENT__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT__VERTICAL_RELATIVE = IPOSITION_ELEMENT__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT__HORIZONTAL_RELATIVE = IPOSITION_ELEMENT__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT__WIDTH = IPOSITION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT__HEIGHT = IPOSITION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>ISized Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT_FEATURE_COUNT = IPOSITION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT___LINFERENCE_OBJECT = IPOSITION_ELEMENT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT___CREATE_CONTAINMENT_ELIST__ECLASS = IPOSITION_ELEMENT___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT___LCONTENTS = IPOSITION_ELEMENT___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT___LPARENT = IPOSITION_ELEMENT___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT___LALL_CONTENTS = IPOSITION_ELEMENT___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>ISized Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT_OPERATION_COUNT = IPOSITION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.presentation.IUIView <em>IUI View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.presentation.IUIView
	 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getIUIView()
	 * @generated
	 */
	int IUI_VIEW = 2;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW__CONTENT_OBJECTS = ApplicationPackage.IVIEW__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Ui Pages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW__UI_PAGES = ApplicationPackage.IVIEW_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Current UI Page</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW__CURRENT_UI_PAGE = ApplicationPackage.IVIEW_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IUI View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW_FEATURE_COUNT = ApplicationPackage.IVIEW_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW___LINFERENCE_OBJECT = ApplicationPackage.IVIEW___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW___CREATE_CONTAINMENT_ELIST__ECLASS = ApplicationPackage.IVIEW___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW___LCONTENTS = ApplicationPackage.IVIEW___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW___LPARENT = ApplicationPackage.IVIEW___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW___LALL_CONTENTS = ApplicationPackage.IVIEW___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>IUI View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_VIEW_OPERATION_COUNT = ApplicationPackage.IVIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.presentation.impl.TranparentUIViewImpl <em>Tranparent UI View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.presentation.impl.TranparentUIViewImpl
	 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getTranparentUIView()
	 * @generated
	 */
	int TRANPARENT_UI_VIEW = 3;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANPARENT_UI_VIEW__CONTENT_OBJECTS = IUI_VIEW__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Ui Pages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANPARENT_UI_VIEW__UI_PAGES = IUI_VIEW__UI_PAGES;

	/**
	 * The feature id for the '<em><b>Current UI Page</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANPARENT_UI_VIEW__CURRENT_UI_PAGE = IUI_VIEW__CURRENT_UI_PAGE;

	/**
	 * The number of structural features of the '<em>Tranparent UI View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANPARENT_UI_VIEW_FEATURE_COUNT = IUI_VIEW_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANPARENT_UI_VIEW___LINFERENCE_OBJECT = IUI_VIEW___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANPARENT_UI_VIEW___CREATE_CONTAINMENT_ELIST__ECLASS = IUI_VIEW___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANPARENT_UI_VIEW___LCONTENTS = IUI_VIEW___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANPARENT_UI_VIEW___LPARENT = IUI_VIEW___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANPARENT_UI_VIEW___LALL_CONTENTS = IUI_VIEW___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Tranparent UI View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANPARENT_UI_VIEW_OPERATION_COUNT = IUI_VIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.presentation.IMusicView <em>IMusic View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.presentation.IMusicView
	 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getIMusicView()
	 * @generated
	 */
	int IMUSIC_VIEW = 4;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMUSIC_VIEW__CONTENT_OBJECTS = ApplicationPackage.IVIEW__CONTENT_OBJECTS;

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
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMUSIC_VIEW___LINFERENCE_OBJECT = ApplicationPackage.IVIEW___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMUSIC_VIEW___CREATE_CONTAINMENT_ELIST__ECLASS = ApplicationPackage.IVIEW___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMUSIC_VIEW___LCONTENTS = ApplicationPackage.IVIEW___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMUSIC_VIEW___LPARENT = ApplicationPackage.IVIEW___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMUSIC_VIEW___LALL_CONTENTS = ApplicationPackage.IVIEW___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>IMusic View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMUSIC_VIEW_OPERATION_COUNT = ApplicationPackage.IVIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.presentation.ISizedView <em>ISized View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.presentation.ISizedView
	 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getISizedView()
	 * @generated
	 */
	int ISIZED_VIEW = 5;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__CONTENT_OBJECTS = ISIZED_ELEMENT__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__POSITION = ISIZED_ELEMENT__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__VERTICAL_RELATIVE = ISIZED_ELEMENT__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__HORIZONTAL_RELATIVE = ISIZED_ELEMENT__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__WIDTH = ISIZED_ELEMENT__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__HEIGHT = ISIZED_ELEMENT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Moveable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__MOVEABLE = ISIZED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Closeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__CLOSEABLE = ISIZED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scalable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__SCALABLE = ISIZED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Show Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__SHOW_TITLE = ISIZED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fullscreen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW__FULLSCREEN = ISIZED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>ISized View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW_FEATURE_COUNT = ISIZED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW___LINFERENCE_OBJECT = ISIZED_ELEMENT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW___CREATE_CONTAINMENT_ELIST__ECLASS = ISIZED_ELEMENT___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW___LCONTENTS = ISIZED_ELEMENT___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW___LPARENT = ISIZED_ELEMENT___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW___LALL_CONTENTS = ISIZED_ELEMENT___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>ISized View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_VIEW_OPERATION_COUNT = ISIZED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.presentation.IUIElement <em>IUI Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.presentation.IUIElement
	 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getIUIElement()
	 * @generated
	 */
	int IUI_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_ELEMENT__CONTENT_OBJECTS = RootPackage.LOBJECT__CONTENT_OBJECTS;

	/**
	 * The number of structural features of the '<em>IUI Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_ELEMENT_FEATURE_COUNT = RootPackage.LOBJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_ELEMENT___LINFERENCE_OBJECT = RootPackage.LOBJECT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_ELEMENT___CREATE_CONTAINMENT_ELIST__ECLASS = RootPackage.LOBJECT___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_ELEMENT___LCONTENTS = RootPackage.LOBJECT___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_ELEMENT___LPARENT = RootPackage.LOBJECT___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_ELEMENT___LALL_CONTENTS = RootPackage.LOBJECT___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>IUI Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_ELEMENT_OPERATION_COUNT = RootPackage.LOBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.presentation.impl.UIPageImpl <em>UI Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.presentation.impl.UIPageImpl
	 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getUIPage()
	 * @generated
	 */
	int UI_PAGE = 7;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__CONTENT_OBJECTS = ISIZED_ELEMENT__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__POSITION = ISIZED_ELEMENT__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__VERTICAL_RELATIVE = ISIZED_ELEMENT__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__HORIZONTAL_RELATIVE = ISIZED_ELEMENT__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__WIDTH = ISIZED_ELEMENT__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__HEIGHT = ISIZED_ELEMENT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Panels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__PANELS = ISIZED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>UI Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE_FEATURE_COUNT = ISIZED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE___LINFERENCE_OBJECT = ISIZED_ELEMENT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE___CREATE_CONTAINMENT_ELIST__ECLASS = ISIZED_ELEMENT___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE___LCONTENTS = ISIZED_ELEMENT___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE___LPARENT = ISIZED_ELEMENT___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE___LALL_CONTENTS = ISIZED_ELEMENT___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>UI Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE_OPERATION_COUNT = ISIZED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.presentation.IPanel <em>IPanel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.presentation.IPanel
	 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getIPanel()
	 * @generated
	 */
	int IPANEL = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL__CONTENT_OBJECTS = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL__POSITION = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL__VERTICAL_RELATIVE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL__HORIZONTAL_RELATIVE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>IPanel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL___LINFERENCE_OBJECT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL___CREATE_CONTAINMENT_ELIST__ECLASS = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL___LCONTENTS = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL___LPARENT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL___LALL_CONTENTS = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>IPanel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.presentation.IPositionElement <em>IPosition Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPosition Element</em>'.
	 * @see org.sheepy.lily.core.model.presentation.IPositionElement
	 * @generated
	 */
	EClass getIPositionElement();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.presentation.IPositionElement#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see org.sheepy.lily.core.model.presentation.IPositionElement#getPosition()
	 * @see #getIPositionElement()
	 * @generated
	 */
	EAttribute getIPositionElement_Position();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.presentation.IPositionElement#getVerticalRelative <em>Vertical Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertical Relative</em>'.
	 * @see org.sheepy.lily.core.model.presentation.IPositionElement#getVerticalRelative()
	 * @see #getIPositionElement()
	 * @generated
	 */
	EAttribute getIPositionElement_VerticalRelative();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.presentation.IPositionElement#getHorizontalRelative <em>Horizontal Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Horizontal Relative</em>'.
	 * @see org.sheepy.lily.core.model.presentation.IPositionElement#getHorizontalRelative()
	 * @see #getIPositionElement()
	 * @generated
	 */
	EAttribute getIPositionElement_HorizontalRelative();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.presentation.ISizedElement <em>ISized Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISized Element</em>'.
	 * @see org.sheepy.lily.core.model.presentation.ISizedElement
	 * @generated
	 */
	EClass getISizedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.presentation.ISizedElement#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.lily.core.model.presentation.ISizedElement#getWidth()
	 * @see #getISizedElement()
	 * @generated
	 */
	EAttribute getISizedElement_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.presentation.ISizedElement#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.core.model.presentation.ISizedElement#getHeight()
	 * @see #getISizedElement()
	 * @generated
	 */
	EAttribute getISizedElement_Height();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.presentation.IUIView <em>IUI View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IUI View</em>'.
	 * @see org.sheepy.lily.core.model.presentation.IUIView
	 * @generated
	 */
	EClass getIUIView();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.presentation.IUIView#getUiPages <em>Ui Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ui Pages</em>'.
	 * @see org.sheepy.lily.core.model.presentation.IUIView#getUiPages()
	 * @see #getIUIView()
	 * @generated
	 */
	EReference getIUIView_UiPages();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.presentation.IUIView#getCurrentUIPage <em>Current UI Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current UI Page</em>'.
	 * @see org.sheepy.lily.core.model.presentation.IUIView#getCurrentUIPage()
	 * @see #getIUIView()
	 * @generated
	 */
	EReference getIUIView_CurrentUIPage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.presentation.TranparentUIView <em>Tranparent UI View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tranparent UI View</em>'.
	 * @see org.sheepy.lily.core.model.presentation.TranparentUIView
	 * @generated
	 */
	EClass getTranparentUIView();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.presentation.IMusicView <em>IMusic View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IMusic View</em>'.
	 * @see org.sheepy.lily.core.model.presentation.IMusicView
	 * @generated
	 */
	EClass getIMusicView();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.presentation.IMusicView#getMusicPath <em>Music Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Music Path</em>'.
	 * @see org.sheepy.lily.core.model.presentation.IMusicView#getMusicPath()
	 * @see #getIMusicView()
	 * @generated
	 */
	EAttribute getIMusicView_MusicPath();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.presentation.ISizedView <em>ISized View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISized View</em>'.
	 * @see org.sheepy.lily.core.model.presentation.ISizedView
	 * @generated
	 */
	EClass getISizedView();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.presentation.ISizedView#isMoveable <em>Moveable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Moveable</em>'.
	 * @see org.sheepy.lily.core.model.presentation.ISizedView#isMoveable()
	 * @see #getISizedView()
	 * @generated
	 */
	EAttribute getISizedView_Moveable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.presentation.ISizedView#isCloseable <em>Closeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Closeable</em>'.
	 * @see org.sheepy.lily.core.model.presentation.ISizedView#isCloseable()
	 * @see #getISizedView()
	 * @generated
	 */
	EAttribute getISizedView_Closeable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.presentation.ISizedView#isScalable <em>Scalable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scalable</em>'.
	 * @see org.sheepy.lily.core.model.presentation.ISizedView#isScalable()
	 * @see #getISizedView()
	 * @generated
	 */
	EAttribute getISizedView_Scalable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.presentation.ISizedView#isShowTitle <em>Show Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Title</em>'.
	 * @see org.sheepy.lily.core.model.presentation.ISizedView#isShowTitle()
	 * @see #getISizedView()
	 * @generated
	 */
	EAttribute getISizedView_ShowTitle();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.presentation.ISizedView#isFullscreen <em>Fullscreen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fullscreen</em>'.
	 * @see org.sheepy.lily.core.model.presentation.ISizedView#isFullscreen()
	 * @see #getISizedView()
	 * @generated
	 */
	EAttribute getISizedView_Fullscreen();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.presentation.IUIElement <em>IUI Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IUI Element</em>'.
	 * @see org.sheepy.lily.core.model.presentation.IUIElement
	 * @generated
	 */
	EClass getIUIElement();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.presentation.UIPage <em>UI Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Page</em>'.
	 * @see org.sheepy.lily.core.model.presentation.UIPage
	 * @generated
	 */
	EClass getUIPage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.presentation.UIPage#getPanels <em>Panels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Panels</em>'.
	 * @see org.sheepy.lily.core.model.presentation.UIPage#getPanels()
	 * @see #getUIPage()
	 * @generated
	 */
	EReference getUIPage_Panels();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.presentation.IPanel <em>IPanel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPanel</em>'.
	 * @see org.sheepy.lily.core.model.presentation.IPanel
	 * @generated
	 */
	EClass getIPanel();

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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.presentation.IPositionElement <em>IPosition Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.presentation.IPositionElement
		 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getIPositionElement()
		 * @generated
		 */
		EClass IPOSITION_ELEMENT = eINSTANCE.getIPositionElement();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPOSITION_ELEMENT__POSITION = eINSTANCE.getIPositionElement_Position();

		/**
		 * The meta object literal for the '<em><b>Vertical Relative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPOSITION_ELEMENT__VERTICAL_RELATIVE = eINSTANCE.getIPositionElement_VerticalRelative();

		/**
		 * The meta object literal for the '<em><b>Horizontal Relative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPOSITION_ELEMENT__HORIZONTAL_RELATIVE = eINSTANCE.getIPositionElement_HorizontalRelative();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.presentation.ISizedElement <em>ISized Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.presentation.ISizedElement
		 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getISizedElement()
		 * @generated
		 */
		EClass ISIZED_ELEMENT = eINSTANCE.getISizedElement();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISIZED_ELEMENT__WIDTH = eINSTANCE.getISizedElement_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISIZED_ELEMENT__HEIGHT = eINSTANCE.getISizedElement_Height();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.presentation.IUIView <em>IUI View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.presentation.IUIView
		 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getIUIView()
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
		 * The meta object literal for the '<em><b>Current UI Page</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IUI_VIEW__CURRENT_UI_PAGE = eINSTANCE.getIUIView_CurrentUIPage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.presentation.impl.TranparentUIViewImpl <em>Tranparent UI View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.presentation.impl.TranparentUIViewImpl
		 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getTranparentUIView()
		 * @generated
		 */
		EClass TRANPARENT_UI_VIEW = eINSTANCE.getTranparentUIView();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.presentation.IMusicView <em>IMusic View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.presentation.IMusicView
		 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getIMusicView()
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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.presentation.ISizedView <em>ISized View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.presentation.ISizedView
		 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getISizedView()
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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.presentation.IUIElement <em>IUI Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.presentation.IUIElement
		 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getIUIElement()
		 * @generated
		 */
		EClass IUI_ELEMENT = eINSTANCE.getIUIElement();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.presentation.impl.UIPageImpl <em>UI Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.presentation.impl.UIPageImpl
		 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getUIPage()
		 * @generated
		 */
		EClass UI_PAGE = eINSTANCE.getUIPage();

		/**
		 * The meta object literal for the '<em><b>Panels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_PAGE__PANELS = eINSTANCE.getUIPage_Panels();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.presentation.IPanel <em>IPanel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.presentation.IPanel
		 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getIPanel()
		 * @generated
		 */
		EClass IPANEL = eINSTANCE.getIPanel();

	}

} //PresentationPackage
