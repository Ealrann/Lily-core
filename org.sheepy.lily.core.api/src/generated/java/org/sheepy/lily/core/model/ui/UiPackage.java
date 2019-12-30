/**
 */
package org.sheepy.lily.core.model.ui;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.inference.InferencePackage;
import org.sheepy.lily.core.model.presentation.PresentationPackage;
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
 * @see org.sheepy.lily.core.model.ui.UiFactory
 * @model kind="package"
 * @generated
 */
public interface UiPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ui";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.core.model.ui";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ui";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UiPackage eINSTANCE = org.sheepy.lily.core.model.ui.impl.UiPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.IPanel <em>IPanel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.IPanel
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getIPanel()
	 * @generated
	 */
	int IPANEL = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL__POSITION = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL__VERTICAL_RELATIVE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL__HORIZONTAL_RELATIVE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Catch Inputs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL__CATCH_INPUTS = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 3;

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
	 * The number of operations of the '<em>IPanel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.PanelImpl <em>Panel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.PanelImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getPanel()
	 * @generated
	 */
	int PANEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__NAME = IPANEL__NAME;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__POSITION = IPANEL__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__VERTICAL_RELATIVE = IPANEL__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__HORIZONTAL_RELATIVE = IPANEL__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Catch Inputs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__CATCH_INPUTS = IPANEL__CATCH_INPUTS;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__WIDTH = IPANEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__HEIGHT = IPANEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__CONTROLS = IPANEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Show Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__SHOW_TITLE = IPANEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Minimizable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__MINIMIZABLE = IPANEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__MOVABLE = IPANEL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Minimized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__MINIMIZED = IPANEL_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Background Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__BACKGROUND_IMAGE = IPANEL_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Panel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_FEATURE_COUNT = IPANEL_FEATURE_COUNT + 8;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL___LINFERENCE_OBJECT = IPANEL___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Panel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_OPERATION_COUNT = IPANEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.UIImpl <em>UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.UIImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getUI()
	 * @generated
	 */
	int UI = 1;

	/**
	 * The feature id for the '<em><b>Image Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI__IMAGE_SUPPORT = ApplicationPackage.ISCENE_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ui Pages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI__UI_PAGES = ApplicationPackage.ISCENE_PART_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Current UI Page</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI__CURRENT_UI_PAGE = ApplicationPackage.ISCENE_PART_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Font Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI__FONT_PKG = ApplicationPackage.ISCENE_PART_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Images</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI__IMAGES = ApplicationPackage.ISCENE_PART_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_FEATURE_COUNT = ApplicationPackage.ISCENE_PART_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI___LINFERENCE_OBJECT = ApplicationPackage.ISCENE_PART___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_OPERATION_COUNT = ApplicationPackage.ISCENE_PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.IUIElement <em>IUI Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.IUIElement
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getIUIElement()
	 * @generated
	 */
	int IUI_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>IUI Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_ELEMENT_FEATURE_COUNT = InferencePackage.IINFERENCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_ELEMENT___LINFERENCE_OBJECT = InferencePackage.IINFERENCE_OBJECT___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>IUI Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUI_ELEMENT_OPERATION_COUNT = InferencePackage.IINFERENCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.UIPageImpl <em>UI Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.UIPageImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getUIPage()
	 * @generated
	 */
	int UI_PAGE = 3;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__POSITION = PresentationPackage.ISIZED_ELEMENT__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__VERTICAL_RELATIVE = PresentationPackage.ISIZED_ELEMENT__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__HORIZONTAL_RELATIVE = PresentationPackage.ISIZED_ELEMENT__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__WIDTH = PresentationPackage.ISIZED_ELEMENT__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__HEIGHT = PresentationPackage.ISIZED_ELEMENT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__NAME = PresentationPackage.ISIZED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Panels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE__PANELS = PresentationPackage.ISIZED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UI Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE_FEATURE_COUNT = PresentationPackage.ISIZED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>UI Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_PAGE_OPERATION_COUNT = PresentationPackage.ISIZED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.IControl <em>IControl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.IControl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getIControl()
	 * @generated
	 */
	int ICONTROL = 5;

	/**
	 * The number of structural features of the '<em>IControl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTROL_FEATURE_COUNT = IUI_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTROL___LINFERENCE_OBJECT = IUI_ELEMENT___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>IControl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTROL_OPERATION_COUNT = IUI_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.Widget <em>Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.Widget
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getWidget()
	 * @generated
	 */
	int WIDGET = 6;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__POSITION = ICONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__VERTICAL_RELATIVE = ICONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__HORIZONTAL_RELATIVE = ICONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__WIDTH = ICONTROL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__HEIGHT = ICONTROL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_FEATURE_COUNT = ICONTROL_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET___LINFERENCE_OBJECT = ICONTROL___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_OPERATION_COUNT = ICONTROL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.TextWidgetImpl <em>Text Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.TextWidgetImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getTextWidget()
	 * @generated
	 */
	int TEXT_WIDGET = 7;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_WIDGET__POSITION = WIDGET__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_WIDGET__VERTICAL_RELATIVE = WIDGET__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_WIDGET__HORIZONTAL_RELATIVE = WIDGET__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_WIDGET__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_WIDGET__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_WIDGET__FONT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_WIDGET_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_WIDGET___LINFERENCE_OBJECT = WIDGET___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Text Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_WIDGET_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.AbstractLabelImpl <em>Abstract Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.AbstractLabelImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getAbstractLabel()
	 * @generated
	 */
	int ABSTRACT_LABEL = 8;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__POSITION = TEXT_WIDGET__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__VERTICAL_RELATIVE = TEXT_WIDGET__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__HORIZONTAL_RELATIVE = TEXT_WIDGET__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__WIDTH = TEXT_WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__HEIGHT = TEXT_WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__FONT = TEXT_WIDGET__FONT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__TEXT = TEXT_WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Font Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__FONT_SCALE = TEXT_WIDGET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL_FEATURE_COUNT = TEXT_WIDGET_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL___LINFERENCE_OBJECT = TEXT_WIDGET___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Abstract Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL_OPERATION_COUNT = TEXT_WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.DynamicRowLayoutImpl <em>Dynamic Row Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.DynamicRowLayoutImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getDynamicRowLayout()
	 * @generated
	 */
	int DYNAMIC_ROW_LAYOUT = 9;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ROW_LAYOUT__HEIGHT = ICONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ROW_LAYOUT__COLUMN_COUNT = ICONTROL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dynamic Row Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ROW_LAYOUT_FEATURE_COUNT = ICONTROL_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ROW_LAYOUT___LINFERENCE_OBJECT = ICONTROL___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Dynamic Row Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ROW_LAYOUT_OPERATION_COUNT = ICONTROL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.VariableLabelImpl <em>Variable Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.VariableLabelImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getVariableLabel()
	 * @generated
	 */
	int VARIABLE_LABEL = 10;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL__POSITION = ABSTRACT_LABEL__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL__VERTICAL_RELATIVE = ABSTRACT_LABEL__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL__HORIZONTAL_RELATIVE = ABSTRACT_LABEL__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL__WIDTH = ABSTRACT_LABEL__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL__HEIGHT = ABSTRACT_LABEL__HEIGHT;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL__FONT = ABSTRACT_LABEL__FONT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL__TEXT = ABSTRACT_LABEL__TEXT;

	/**
	 * The feature id for the '<em><b>Font Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL__FONT_SCALE = ABSTRACT_LABEL__FONT_SCALE;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL__VARIABLE_RESOLVER = ABSTRACT_LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Show Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL__SHOW_NAME = ABSTRACT_LABEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL__FORMAT = ABSTRACT_LABEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL_FEATURE_COUNT = ABSTRACT_LABEL_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL___LINFERENCE_OBJECT = ABSTRACT_LABEL___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Variable Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LABEL_OPERATION_COUNT = ABSTRACT_LABEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.LabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.LabelImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 11;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__POSITION = ABSTRACT_LABEL__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__VERTICAL_RELATIVE = ABSTRACT_LABEL__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__HORIZONTAL_RELATIVE = ABSTRACT_LABEL__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__WIDTH = ABSTRACT_LABEL__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__HEIGHT = ABSTRACT_LABEL__HEIGHT;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__FONT = ABSTRACT_LABEL__FONT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__TEXT = ABSTRACT_LABEL__TEXT;

	/**
	 * The feature id for the '<em><b>Font Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__FONT_SCALE = ABSTRACT_LABEL__FONT_SCALE;

	/**
	 * The feature id for the '<em><b>Wrap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__WRAP = ABSTRACT_LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = ABSTRACT_LABEL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL___LINFERENCE_OBJECT = ABSTRACT_LABEL___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_OPERATION_COUNT = ABSTRACT_LABEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.SliderImpl <em>Slider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.SliderImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getSlider()
	 * @generated
	 */
	int SLIDER = 12;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__POSITION = TEXT_WIDGET__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__VERTICAL_RELATIVE = TEXT_WIDGET__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__HORIZONTAL_RELATIVE = TEXT_WIDGET__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__WIDTH = TEXT_WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__HEIGHT = TEXT_WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__FONT = TEXT_WIDGET__FONT;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__MIN_VALUE = TEXT_WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__MAX_VALUE = TEXT_WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__STEP = TEXT_WIDGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__VARIABLE_RESOLVER = TEXT_WIDGET_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Slider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER_FEATURE_COUNT = TEXT_WIDGET_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER___LINFERENCE_OBJECT = TEXT_WIDGET___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Slider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER_OPERATION_COUNT = TEXT_WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.TextFieldImpl <em>Text Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.TextFieldImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getTextField()
	 * @generated
	 */
	int TEXT_FIELD = 13;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__POSITION = TEXT_WIDGET__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__VERTICAL_RELATIVE = TEXT_WIDGET__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__HORIZONTAL_RELATIVE = TEXT_WIDGET__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__WIDTH = TEXT_WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__HEIGHT = TEXT_WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__FONT = TEXT_WIDGET__FONT;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__VARIABLE_RESOLVER = TEXT_WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD_FEATURE_COUNT = TEXT_WIDGET_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD___LINFERENCE_OBJECT = TEXT_WIDGET___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Text Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD_OPERATION_COUNT = TEXT_WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.AbstractButtonImpl <em>Abstract Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.AbstractButtonImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getAbstractButton()
	 * @generated
	 */
	int ABSTRACT_BUTTON = 14;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__POSITION = TEXT_WIDGET__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__VERTICAL_RELATIVE = TEXT_WIDGET__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__HORIZONTAL_RELATIVE = TEXT_WIDGET__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__WIDTH = TEXT_WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__HEIGHT = TEXT_WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__FONT = TEXT_WIDGET__FONT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__TEXT = TEXT_WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON_FEATURE_COUNT = TEXT_WIDGET_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON___LINFERENCE_OBJECT = TEXT_WIDGET___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Abstract Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON_OPERATION_COUNT = TEXT_WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.ButtonImpl <em>Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.ButtonImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getButton()
	 * @generated
	 */
	int BUTTON = 15;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__POSITION = ABSTRACT_BUTTON__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__VERTICAL_RELATIVE = ABSTRACT_BUTTON__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__HORIZONTAL_RELATIVE = ABSTRACT_BUTTON__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__WIDTH = ABSTRACT_BUTTON__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__HEIGHT = ABSTRACT_BUTTON__HEIGHT;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__FONT = ABSTRACT_BUTTON__FONT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__TEXT = ABSTRACT_BUTTON__TEXT;

	/**
	 * The feature id for the '<em><b>Shortcut</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__SHORTCUT = ABSTRACT_BUTTON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__STATE = ABSTRACT_BUTTON_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__ACTIONS = ABSTRACT_BUTTON_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_FEATURE_COUNT = ABSTRACT_BUTTON_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON___LINFERENCE_OBJECT = ABSTRACT_BUTTON___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>LActions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON___LACTIONS = ABSTRACT_BUTTON_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Executor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON___GET_EXECUTOR = ABSTRACT_BUTTON_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_OPERATION_COUNT = ABSTRACT_BUTTON_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.AbstractBooleanButtonImpl <em>Abstract Boolean Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.AbstractBooleanButtonImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getAbstractBooleanButton()
	 * @generated
	 */
	int ABSTRACT_BOOLEAN_BUTTON = 16;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BOOLEAN_BUTTON__POSITION = ABSTRACT_BUTTON__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BOOLEAN_BUTTON__VERTICAL_RELATIVE = ABSTRACT_BUTTON__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BOOLEAN_BUTTON__HORIZONTAL_RELATIVE = ABSTRACT_BUTTON__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BOOLEAN_BUTTON__WIDTH = ABSTRACT_BUTTON__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BOOLEAN_BUTTON__HEIGHT = ABSTRACT_BUTTON__HEIGHT;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BOOLEAN_BUTTON__FONT = ABSTRACT_BUTTON__FONT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BOOLEAN_BUTTON__TEXT = ABSTRACT_BUTTON__TEXT;

	/**
	 * The feature id for the '<em><b>Text When True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_TRUE = ABSTRACT_BUTTON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text When False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_FALSE = ABSTRACT_BUTTON_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Boolean Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BOOLEAN_BUTTON_FEATURE_COUNT = ABSTRACT_BUTTON_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BOOLEAN_BUTTON___LINFERENCE_OBJECT = ABSTRACT_BUTTON___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Abstract Boolean Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BOOLEAN_BUTTON_OPERATION_COUNT = ABSTRACT_BUTTON_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.BooleanButtonImpl <em>Boolean Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.BooleanButtonImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getBooleanButton()
	 * @generated
	 */
	int BOOLEAN_BUTTON = 17;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON__POSITION = ABSTRACT_BOOLEAN_BUTTON__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON__VERTICAL_RELATIVE = ABSTRACT_BOOLEAN_BUTTON__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON__HORIZONTAL_RELATIVE = ABSTRACT_BOOLEAN_BUTTON__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON__WIDTH = ABSTRACT_BOOLEAN_BUTTON__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON__HEIGHT = ABSTRACT_BOOLEAN_BUTTON__HEIGHT;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON__FONT = ABSTRACT_BOOLEAN_BUTTON__FONT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON__TEXT = ABSTRACT_BOOLEAN_BUTTON__TEXT;

	/**
	 * The feature id for the '<em><b>Text When True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON__TEXT_WHEN_TRUE = ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_TRUE;

	/**
	 * The feature id for the '<em><b>Text When False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON__TEXT_WHEN_FALSE = ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_FALSE;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON__VARIABLE_RESOLVER = ABSTRACT_BOOLEAN_BUTTON_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON_FEATURE_COUNT = ABSTRACT_BOOLEAN_BUTTON_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON___LINFERENCE_OBJECT = ABSTRACT_BOOLEAN_BUTTON___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Boolean Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BUTTON_OPERATION_COUNT = ABSTRACT_BOOLEAN_BUTTON_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.BooleanActionButtonImpl <em>Boolean Action Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.BooleanActionButtonImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getBooleanActionButton()
	 * @generated
	 */
	int BOOLEAN_ACTION_BUTTON = 18;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON__POSITION = ABSTRACT_BOOLEAN_BUTTON__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON__VERTICAL_RELATIVE = ABSTRACT_BOOLEAN_BUTTON__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON__HORIZONTAL_RELATIVE = ABSTRACT_BOOLEAN_BUTTON__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON__WIDTH = ABSTRACT_BOOLEAN_BUTTON__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON__HEIGHT = ABSTRACT_BOOLEAN_BUTTON__HEIGHT;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON__FONT = ABSTRACT_BOOLEAN_BUTTON__FONT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON__TEXT = ABSTRACT_BOOLEAN_BUTTON__TEXT;

	/**
	 * The feature id for the '<em><b>Text When True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON__TEXT_WHEN_TRUE = ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_TRUE;

	/**
	 * The feature id for the '<em><b>Text When False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON__TEXT_WHEN_FALSE = ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_FALSE;

	/**
	 * The feature id for the '<em><b>Action When True</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON__ACTION_WHEN_TRUE = ABSTRACT_BOOLEAN_BUTTON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action When False</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON__ACTION_WHEN_FALSE = ABSTRACT_BOOLEAN_BUTTON_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boolean Action Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON_FEATURE_COUNT = ABSTRACT_BOOLEAN_BUTTON_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON___LINFERENCE_OBJECT = ABSTRACT_BOOLEAN_BUTTON___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Boolean Action Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ACTION_BUTTON_OPERATION_COUNT = ABSTRACT_BOOLEAN_BUTTON_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.FontPkgImpl <em>Font Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.FontPkgImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getFontPkg()
	 * @generated
	 */
	int FONT_PKG = 19;

	/**
	 * The feature id for the '<em><b>Fonts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_PKG__FONTS = 0;

	/**
	 * The number of structural features of the '<em>Font Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Font Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.FontTableImpl <em>Font Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.FontTableImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getFontTable()
	 * @generated
	 */
	int FONT_TABLE = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TABLE__NAME = ApplicationPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TABLE__FILE = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Char Tables</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TABLE__CHAR_TABLES = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Font Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TABLE_FEATURE_COUNT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Font Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TABLE_OPERATION_COUNT = ApplicationPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.FontImpl <em>Font</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.FontImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getFont()
	 * @generated
	 */
	int FONT = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__NAME = ApplicationPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Tables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__TABLES = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__HEIGHT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Font</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_FEATURE_COUNT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Font</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_OPERATION_COUNT = ApplicationPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.Panel <em>Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Panel</em>'.
	 * @see org.sheepy.lily.core.model.ui.Panel
	 * @generated
	 */
	EClass getPanel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.ui.Panel#getControls <em>Controls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Controls</em>'.
	 * @see org.sheepy.lily.core.model.ui.Panel#getControls()
	 * @see #getPanel()
	 * @generated
	 */
	EReference getPanel_Controls();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.Panel#isShowTitle <em>Show Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Title</em>'.
	 * @see org.sheepy.lily.core.model.ui.Panel#isShowTitle()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_ShowTitle();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.Panel#isMinimizable <em>Minimizable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimizable</em>'.
	 * @see org.sheepy.lily.core.model.ui.Panel#isMinimizable()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_Minimizable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.Panel#isMovable <em>Movable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Movable</em>'.
	 * @see org.sheepy.lily.core.model.ui.Panel#isMovable()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_Movable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.Panel#isMinimized <em>Minimized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimized</em>'.
	 * @see org.sheepy.lily.core.model.ui.Panel#isMinimized()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_Minimized();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.ui.Panel#getBackgroundImage <em>Background Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Background Image</em>'.
	 * @see org.sheepy.lily.core.model.ui.Panel#getBackgroundImage()
	 * @see #getPanel()
	 * @generated
	 */
	EReference getPanel_BackgroundImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.UI <em>UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI</em>'.
	 * @see org.sheepy.lily.core.model.ui.UI
	 * @generated
	 */
	EClass getUI();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.UI#isImageSupport <em>Image Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Support</em>'.
	 * @see org.sheepy.lily.core.model.ui.UI#isImageSupport()
	 * @see #getUI()
	 * @generated
	 */
	EAttribute getUI_ImageSupport();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.ui.UI#getUiPages <em>Ui Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ui Pages</em>'.
	 * @see org.sheepy.lily.core.model.ui.UI#getUiPages()
	 * @see #getUI()
	 * @generated
	 */
	EReference getUI_UiPages();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.ui.UI#getCurrentUIPage <em>Current UI Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current UI Page</em>'.
	 * @see org.sheepy.lily.core.model.ui.UI#getCurrentUIPage()
	 * @see #getUI()
	 * @generated
	 */
	EReference getUI_CurrentUIPage();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.ui.UI#getFontPkg <em>Font Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Font Pkg</em>'.
	 * @see org.sheepy.lily.core.model.ui.UI#getFontPkg()
	 * @see #getUI()
	 * @generated
	 */
	EReference getUI_FontPkg();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.core.model.ui.UI#getImages <em>Images</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Images</em>'.
	 * @see org.sheepy.lily.core.model.ui.UI#getImages()
	 * @see #getUI()
	 * @generated
	 */
	EReference getUI_Images();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.IUIElement <em>IUI Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IUI Element</em>'.
	 * @see org.sheepy.lily.core.model.ui.IUIElement
	 * @generated
	 */
	EClass getIUIElement();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.UIPage <em>UI Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Page</em>'.
	 * @see org.sheepy.lily.core.model.ui.UIPage
	 * @generated
	 */
	EClass getUIPage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.ui.UIPage#getPanels <em>Panels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Panels</em>'.
	 * @see org.sheepy.lily.core.model.ui.UIPage#getPanels()
	 * @see #getUIPage()
	 * @generated
	 */
	EReference getUIPage_Panels();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.IPanel <em>IPanel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPanel</em>'.
	 * @see org.sheepy.lily.core.model.ui.IPanel
	 * @generated
	 */
	EClass getIPanel();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.IPanel#isCatchInputs <em>Catch Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Catch Inputs</em>'.
	 * @see org.sheepy.lily.core.model.ui.IPanel#isCatchInputs()
	 * @see #getIPanel()
	 * @generated
	 */
	EAttribute getIPanel_CatchInputs();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.IControl <em>IControl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IControl</em>'.
	 * @see org.sheepy.lily.core.model.ui.IControl
	 * @generated
	 */
	EClass getIControl();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget</em>'.
	 * @see org.sheepy.lily.core.model.ui.Widget
	 * @generated
	 */
	EClass getWidget();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.TextWidget <em>Text Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Widget</em>'.
	 * @see org.sheepy.lily.core.model.ui.TextWidget
	 * @generated
	 */
	EClass getTextWidget();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.ui.TextWidget#getFont <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Font</em>'.
	 * @see org.sheepy.lily.core.model.ui.TextWidget#getFont()
	 * @see #getTextWidget()
	 * @generated
	 */
	EReference getTextWidget_Font();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.AbstractLabel <em>Abstract Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Label</em>'.
	 * @see org.sheepy.lily.core.model.ui.AbstractLabel
	 * @generated
	 */
	EClass getAbstractLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.AbstractLabel#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.sheepy.lily.core.model.ui.AbstractLabel#getText()
	 * @see #getAbstractLabel()
	 * @generated
	 */
	EAttribute getAbstractLabel_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.AbstractLabel#getFontScale <em>Font Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Scale</em>'.
	 * @see org.sheepy.lily.core.model.ui.AbstractLabel#getFontScale()
	 * @see #getAbstractLabel()
	 * @generated
	 */
	EAttribute getAbstractLabel_FontScale();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.DynamicRowLayout <em>Dynamic Row Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Row Layout</em>'.
	 * @see org.sheepy.lily.core.model.ui.DynamicRowLayout
	 * @generated
	 */
	EClass getDynamicRowLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.DynamicRowLayout#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.core.model.ui.DynamicRowLayout#getHeight()
	 * @see #getDynamicRowLayout()
	 * @generated
	 */
	EAttribute getDynamicRowLayout_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.DynamicRowLayout#getColumnCount <em>Column Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column Count</em>'.
	 * @see org.sheepy.lily.core.model.ui.DynamicRowLayout#getColumnCount()
	 * @see #getDynamicRowLayout()
	 * @generated
	 */
	EAttribute getDynamicRowLayout_ColumnCount();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.VariableLabel <em>Variable Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Label</em>'.
	 * @see org.sheepy.lily.core.model.ui.VariableLabel
	 * @generated
	 */
	EClass getVariableLabel();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.ui.VariableLabel#getVariableResolver <em>Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Resolver</em>'.
	 * @see org.sheepy.lily.core.model.ui.VariableLabel#getVariableResolver()
	 * @see #getVariableLabel()
	 * @generated
	 */
	EReference getVariableLabel_VariableResolver();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.VariableLabel#isShowName <em>Show Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Name</em>'.
	 * @see org.sheepy.lily.core.model.ui.VariableLabel#isShowName()
	 * @see #getVariableLabel()
	 * @generated
	 */
	EAttribute getVariableLabel_ShowName();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.VariableLabel#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.sheepy.lily.core.model.ui.VariableLabel#getFormat()
	 * @see #getVariableLabel()
	 * @generated
	 */
	EAttribute getVariableLabel_Format();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see org.sheepy.lily.core.model.ui.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.Label#isWrap <em>Wrap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wrap</em>'.
	 * @see org.sheepy.lily.core.model.ui.Label#isWrap()
	 * @see #getLabel()
	 * @generated
	 */
	EAttribute getLabel_Wrap();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.Slider <em>Slider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slider</em>'.
	 * @see org.sheepy.lily.core.model.ui.Slider
	 * @generated
	 */
	EClass getSlider();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.Slider#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see org.sheepy.lily.core.model.ui.Slider#getMinValue()
	 * @see #getSlider()
	 * @generated
	 */
	EAttribute getSlider_MinValue();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.Slider#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see org.sheepy.lily.core.model.ui.Slider#getMaxValue()
	 * @see #getSlider()
	 * @generated
	 */
	EAttribute getSlider_MaxValue();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.Slider#getStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step</em>'.
	 * @see org.sheepy.lily.core.model.ui.Slider#getStep()
	 * @see #getSlider()
	 * @generated
	 */
	EAttribute getSlider_Step();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.ui.Slider#getVariableResolver <em>Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Resolver</em>'.
	 * @see org.sheepy.lily.core.model.ui.Slider#getVariableResolver()
	 * @see #getSlider()
	 * @generated
	 */
	EReference getSlider_VariableResolver();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.TextField <em>Text Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Field</em>'.
	 * @see org.sheepy.lily.core.model.ui.TextField
	 * @generated
	 */
	EClass getTextField();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.ui.TextField#getVariableResolver <em>Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Resolver</em>'.
	 * @see org.sheepy.lily.core.model.ui.TextField#getVariableResolver()
	 * @see #getTextField()
	 * @generated
	 */
	EReference getTextField_VariableResolver();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.AbstractButton <em>Abstract Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Button</em>'.
	 * @see org.sheepy.lily.core.model.ui.AbstractButton
	 * @generated
	 */
	EClass getAbstractButton();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.AbstractButton#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.sheepy.lily.core.model.ui.AbstractButton#getText()
	 * @see #getAbstractButton()
	 * @generated
	 */
	EAttribute getAbstractButton_Text();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.Button <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Button</em>'.
	 * @see org.sheepy.lily.core.model.ui.Button
	 * @generated
	 */
	EClass getButton();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.Button#getShortcut <em>Shortcut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shortcut</em>'.
	 * @see org.sheepy.lily.core.model.ui.Button#getShortcut()
	 * @see #getButton()
	 * @generated
	 */
	EAttribute getButton_Shortcut();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.Button#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.sheepy.lily.core.model.ui.Button#getState()
	 * @see #getButton()
	 * @generated
	 */
	EAttribute getButton_State();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.ui.Button#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.sheepy.lily.core.model.ui.Button#getActions()
	 * @see #getButton()
	 * @generated
	 */
	EReference getButton_Actions();

	/**
	 * Returns the meta object for the '{@link org.sheepy.lily.core.model.ui.Button#lActions() <em>LActions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>LActions</em>' operation.
	 * @see org.sheepy.lily.core.model.ui.Button#lActions()
	 * @generated
	 */
	EOperation getButton__LActions();

	/**
	 * Returns the meta object for the '{@link org.sheepy.lily.core.model.ui.Button#getExecutor() <em>Get Executor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Executor</em>' operation.
	 * @see org.sheepy.lily.core.model.ui.Button#getExecutor()
	 * @generated
	 */
	EOperation getButton__GetExecutor();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.AbstractBooleanButton <em>Abstract Boolean Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Boolean Button</em>'.
	 * @see org.sheepy.lily.core.model.ui.AbstractBooleanButton
	 * @generated
	 */
	EClass getAbstractBooleanButton();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.AbstractBooleanButton#getTextWhenTrue <em>Text When True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text When True</em>'.
	 * @see org.sheepy.lily.core.model.ui.AbstractBooleanButton#getTextWhenTrue()
	 * @see #getAbstractBooleanButton()
	 * @generated
	 */
	EAttribute getAbstractBooleanButton_TextWhenTrue();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.AbstractBooleanButton#getTextWhenFalse <em>Text When False</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text When False</em>'.
	 * @see org.sheepy.lily.core.model.ui.AbstractBooleanButton#getTextWhenFalse()
	 * @see #getAbstractBooleanButton()
	 * @generated
	 */
	EAttribute getAbstractBooleanButton_TextWhenFalse();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.BooleanButton <em>Boolean Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Button</em>'.
	 * @see org.sheepy.lily.core.model.ui.BooleanButton
	 * @generated
	 */
	EClass getBooleanButton();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.ui.BooleanButton#getVariableResolver <em>Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Resolver</em>'.
	 * @see org.sheepy.lily.core.model.ui.BooleanButton#getVariableResolver()
	 * @see #getBooleanButton()
	 * @generated
	 */
	EReference getBooleanButton_VariableResolver();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.BooleanActionButton <em>Boolean Action Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Action Button</em>'.
	 * @see org.sheepy.lily.core.model.ui.BooleanActionButton
	 * @generated
	 */
	EClass getBooleanActionButton();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.ui.BooleanActionButton#getActionWhenTrue <em>Action When True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action When True</em>'.
	 * @see org.sheepy.lily.core.model.ui.BooleanActionButton#getActionWhenTrue()
	 * @see #getBooleanActionButton()
	 * @generated
	 */
	EReference getBooleanActionButton_ActionWhenTrue();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.ui.BooleanActionButton#getActionWhenFalse <em>Action When False</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action When False</em>'.
	 * @see org.sheepy.lily.core.model.ui.BooleanActionButton#getActionWhenFalse()
	 * @see #getBooleanActionButton()
	 * @generated
	 */
	EReference getBooleanActionButton_ActionWhenFalse();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.FontPkg <em>Font Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font Pkg</em>'.
	 * @see org.sheepy.lily.core.model.ui.FontPkg
	 * @generated
	 */
	EClass getFontPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.ui.FontPkg#getFonts <em>Fonts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fonts</em>'.
	 * @see org.sheepy.lily.core.model.ui.FontPkg#getFonts()
	 * @see #getFontPkg()
	 * @generated
	 */
	EReference getFontPkg_Fonts();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.FontTable <em>Font Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font Table</em>'.
	 * @see org.sheepy.lily.core.model.ui.FontTable
	 * @generated
	 */
	EClass getFontTable();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.ui.FontTable#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.lily.core.model.ui.FontTable#getFile()
	 * @see #getFontTable()
	 * @generated
	 */
	EReference getFontTable_File();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.core.model.ui.FontTable#getCharTables <em>Char Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Char Tables</em>'.
	 * @see org.sheepy.lily.core.model.ui.FontTable#getCharTables()
	 * @see #getFontTable()
	 * @generated
	 */
	EAttribute getFontTable_CharTables();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.ui.Font <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font</em>'.
	 * @see org.sheepy.lily.core.model.ui.Font
	 * @generated
	 */
	EClass getFont();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.ui.Font#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tables</em>'.
	 * @see org.sheepy.lily.core.model.ui.Font#getTables()
	 * @see #getFont()
	 * @generated
	 */
	EReference getFont_Tables();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.ui.Font#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.core.model.ui.Font#getHeight()
	 * @see #getFont()
	 * @generated
	 */
	EAttribute getFont_Height();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UiFactory getUiFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.PanelImpl <em>Panel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.PanelImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getPanel()
		 * @generated
		 */
		EClass PANEL = eINSTANCE.getPanel();

		/**
		 * The meta object literal for the '<em><b>Controls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PANEL__CONTROLS = eINSTANCE.getPanel_Controls();

		/**
		 * The meta object literal for the '<em><b>Show Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PANEL__SHOW_TITLE = eINSTANCE.getPanel_ShowTitle();

		/**
		 * The meta object literal for the '<em><b>Minimizable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PANEL__MINIMIZABLE = eINSTANCE.getPanel_Minimizable();

		/**
		 * The meta object literal for the '<em><b>Movable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PANEL__MOVABLE = eINSTANCE.getPanel_Movable();

		/**
		 * The meta object literal for the '<em><b>Minimized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PANEL__MINIMIZED = eINSTANCE.getPanel_Minimized();

		/**
		 * The meta object literal for the '<em><b>Background Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PANEL__BACKGROUND_IMAGE = eINSTANCE.getPanel_BackgroundImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.UIImpl <em>UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.UIImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getUI()
		 * @generated
		 */
		EClass UI = eINSTANCE.getUI();

		/**
		 * The meta object literal for the '<em><b>Image Support</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI__IMAGE_SUPPORT = eINSTANCE.getUI_ImageSupport();

		/**
		 * The meta object literal for the '<em><b>Ui Pages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI__UI_PAGES = eINSTANCE.getUI_UiPages();

		/**
		 * The meta object literal for the '<em><b>Current UI Page</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI__CURRENT_UI_PAGE = eINSTANCE.getUI_CurrentUIPage();

		/**
		 * The meta object literal for the '<em><b>Font Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI__FONT_PKG = eINSTANCE.getUI_FontPkg();

		/**
		 * The meta object literal for the '<em><b>Images</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI__IMAGES = eINSTANCE.getUI_Images();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.IUIElement <em>IUI Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.IUIElement
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getIUIElement()
		 * @generated
		 */
		EClass IUI_ELEMENT = eINSTANCE.getIUIElement();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.UIPageImpl <em>UI Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.UIPageImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getUIPage()
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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.IPanel <em>IPanel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.IPanel
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getIPanel()
		 * @generated
		 */
		EClass IPANEL = eINSTANCE.getIPanel();

		/**
		 * The meta object literal for the '<em><b>Catch Inputs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPANEL__CATCH_INPUTS = eINSTANCE.getIPanel_CatchInputs();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.IControl <em>IControl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.IControl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getIControl()
		 * @generated
		 */
		EClass ICONTROL = eINSTANCE.getIControl();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.Widget <em>Widget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.Widget
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getWidget()
		 * @generated
		 */
		EClass WIDGET = eINSTANCE.getWidget();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.TextWidgetImpl <em>Text Widget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.TextWidgetImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getTextWidget()
		 * @generated
		 */
		EClass TEXT_WIDGET = eINSTANCE.getTextWidget();

		/**
		 * The meta object literal for the '<em><b>Font</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_WIDGET__FONT = eINSTANCE.getTextWidget_Font();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.AbstractLabelImpl <em>Abstract Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.AbstractLabelImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getAbstractLabel()
		 * @generated
		 */
		EClass ABSTRACT_LABEL = eINSTANCE.getAbstractLabel();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_LABEL__TEXT = eINSTANCE.getAbstractLabel_Text();

		/**
		 * The meta object literal for the '<em><b>Font Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_LABEL__FONT_SCALE = eINSTANCE.getAbstractLabel_FontScale();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.DynamicRowLayoutImpl <em>Dynamic Row Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.DynamicRowLayoutImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getDynamicRowLayout()
		 * @generated
		 */
		EClass DYNAMIC_ROW_LAYOUT = eINSTANCE.getDynamicRowLayout();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_ROW_LAYOUT__HEIGHT = eINSTANCE.getDynamicRowLayout_Height();

		/**
		 * The meta object literal for the '<em><b>Column Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_ROW_LAYOUT__COLUMN_COUNT = eINSTANCE.getDynamicRowLayout_ColumnCount();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.VariableLabelImpl <em>Variable Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.VariableLabelImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getVariableLabel()
		 * @generated
		 */
		EClass VARIABLE_LABEL = eINSTANCE.getVariableLabel();

		/**
		 * The meta object literal for the '<em><b>Variable Resolver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_LABEL__VARIABLE_RESOLVER = eINSTANCE.getVariableLabel_VariableResolver();

		/**
		 * The meta object literal for the '<em><b>Show Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_LABEL__SHOW_NAME = eINSTANCE.getVariableLabel_ShowName();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_LABEL__FORMAT = eINSTANCE.getVariableLabel_Format();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.LabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.LabelImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '<em><b>Wrap</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL__WRAP = eINSTANCE.getLabel_Wrap();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.SliderImpl <em>Slider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.SliderImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getSlider()
		 * @generated
		 */
		EClass SLIDER = eINSTANCE.getSlider();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLIDER__MIN_VALUE = eINSTANCE.getSlider_MinValue();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLIDER__MAX_VALUE = eINSTANCE.getSlider_MaxValue();

		/**
		 * The meta object literal for the '<em><b>Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLIDER__STEP = eINSTANCE.getSlider_Step();

		/**
		 * The meta object literal for the '<em><b>Variable Resolver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLIDER__VARIABLE_RESOLVER = eINSTANCE.getSlider_VariableResolver();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.TextFieldImpl <em>Text Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.TextFieldImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getTextField()
		 * @generated
		 */
		EClass TEXT_FIELD = eINSTANCE.getTextField();

		/**
		 * The meta object literal for the '<em><b>Variable Resolver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_FIELD__VARIABLE_RESOLVER = eINSTANCE.getTextField_VariableResolver();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.AbstractButtonImpl <em>Abstract Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.AbstractButtonImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getAbstractButton()
		 * @generated
		 */
		EClass ABSTRACT_BUTTON = eINSTANCE.getAbstractButton();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_BUTTON__TEXT = eINSTANCE.getAbstractButton_Text();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.ButtonImpl <em>Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.ButtonImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getButton()
		 * @generated
		 */
		EClass BUTTON = eINSTANCE.getButton();

		/**
		 * The meta object literal for the '<em><b>Shortcut</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUTTON__SHORTCUT = eINSTANCE.getButton_Shortcut();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUTTON__STATE = eINSTANCE.getButton_State();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUTTON__ACTIONS = eINSTANCE.getButton_Actions();

		/**
		 * The meta object literal for the '<em><b>LActions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUTTON___LACTIONS = eINSTANCE.getButton__LActions();

		/**
		 * The meta object literal for the '<em><b>Get Executor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUTTON___GET_EXECUTOR = eINSTANCE.getButton__GetExecutor();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.AbstractBooleanButtonImpl <em>Abstract Boolean Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.AbstractBooleanButtonImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getAbstractBooleanButton()
		 * @generated
		 */
		EClass ABSTRACT_BOOLEAN_BUTTON = eINSTANCE.getAbstractBooleanButton();

		/**
		 * The meta object literal for the '<em><b>Text When True</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_TRUE = eINSTANCE.getAbstractBooleanButton_TextWhenTrue();

		/**
		 * The meta object literal for the '<em><b>Text When False</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_FALSE = eINSTANCE.getAbstractBooleanButton_TextWhenFalse();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.BooleanButtonImpl <em>Boolean Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.BooleanButtonImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getBooleanButton()
		 * @generated
		 */
		EClass BOOLEAN_BUTTON = eINSTANCE.getBooleanButton();

		/**
		 * The meta object literal for the '<em><b>Variable Resolver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_BUTTON__VARIABLE_RESOLVER = eINSTANCE.getBooleanButton_VariableResolver();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.BooleanActionButtonImpl <em>Boolean Action Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.BooleanActionButtonImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getBooleanActionButton()
		 * @generated
		 */
		EClass BOOLEAN_ACTION_BUTTON = eINSTANCE.getBooleanActionButton();

		/**
		 * The meta object literal for the '<em><b>Action When True</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_ACTION_BUTTON__ACTION_WHEN_TRUE = eINSTANCE.getBooleanActionButton_ActionWhenTrue();

		/**
		 * The meta object literal for the '<em><b>Action When False</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_ACTION_BUTTON__ACTION_WHEN_FALSE = eINSTANCE.getBooleanActionButton_ActionWhenFalse();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.FontPkgImpl <em>Font Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.FontPkgImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getFontPkg()
		 * @generated
		 */
		EClass FONT_PKG = eINSTANCE.getFontPkg();

		/**
		 * The meta object literal for the '<em><b>Fonts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FONT_PKG__FONTS = eINSTANCE.getFontPkg_Fonts();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.FontTableImpl <em>Font Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.FontTableImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getFontTable()
		 * @generated
		 */
		EClass FONT_TABLE = eINSTANCE.getFontTable();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FONT_TABLE__FILE = eINSTANCE.getFontTable_File();

		/**
		 * The meta object literal for the '<em><b>Char Tables</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT_TABLE__CHAR_TABLES = eINSTANCE.getFontTable_CharTables();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.ui.impl.FontImpl <em>Font</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.ui.impl.FontImpl
		 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getFont()
		 * @generated
		 */
		EClass FONT = eINSTANCE.getFont();

		/**
		 * The meta object literal for the '<em><b>Tables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FONT__TABLES = eINSTANCE.getFont_Tables();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT__HEIGHT = eINSTANCE.getFont_Height();

	}

} //UiPackage
