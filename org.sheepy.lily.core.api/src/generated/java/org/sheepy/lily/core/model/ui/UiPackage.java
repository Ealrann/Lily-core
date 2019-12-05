/**
 */
package org.sheepy.lily.core.model.ui;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.presentation.PresentationPackage;

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
	int PANEL__NAME = PresentationPackage.IPANEL__NAME;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__POSITION = PresentationPackage.IPANEL__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__VERTICAL_RELATIVE = PresentationPackage.IPANEL__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__HORIZONTAL_RELATIVE = PresentationPackage.IPANEL__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__WIDTH = PresentationPackage.IPANEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__HEIGHT = PresentationPackage.IPANEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__CONTROLS = PresentationPackage.IPANEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Show Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__SHOW_TITLE = PresentationPackage.IPANEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Minimizable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__MINIMIZABLE = PresentationPackage.IPANEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__MOVABLE = PresentationPackage.IPANEL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Minimized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__MINIMIZED = PresentationPackage.IPANEL_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Panel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_FEATURE_COUNT = PresentationPackage.IPANEL_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL___LINFERENCE_OBJECT = PresentationPackage.IPANEL___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Panel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_OPERATION_COUNT = PresentationPackage.IPANEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.IControl <em>IControl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.IControl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getIControl()
	 * @generated
	 */
	int ICONTROL = 1;

	/**
	 * The number of structural features of the '<em>IControl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTROL_FEATURE_COUNT = PresentationPackage.IUI_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTROL___LINFERENCE_OBJECT = PresentationPackage.IUI_ELEMENT___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>IControl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTROL_OPERATION_COUNT = PresentationPackage.IUI_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.Widget <em>Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.Widget
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getWidget()
	 * @generated
	 */
	int WIDGET = 2;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.AbstractLabelImpl <em>Abstract Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.AbstractLabelImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getAbstractLabel()
	 * @generated
	 */
	int ABSTRACT_LABEL = 3;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__POSITION = WIDGET__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__VERTICAL_RELATIVE = WIDGET__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__HORIZONTAL_RELATIVE = WIDGET__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__TEXT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Font Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL__FONT_SCALE = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL___LINFERENCE_OBJECT = WIDGET___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Abstract Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.DynamicRowLayoutImpl <em>Dynamic Row Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.DynamicRowLayoutImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getDynamicRowLayout()
	 * @generated
	 */
	int DYNAMIC_ROW_LAYOUT = 4;

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
	int VARIABLE_LABEL = 5;

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
	int LABEL = 6;

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
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = ABSTRACT_LABEL_FEATURE_COUNT + 0;

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
	int SLIDER = 7;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__POSITION = WIDGET__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__VERTICAL_RELATIVE = WIDGET__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__HORIZONTAL_RELATIVE = WIDGET__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__MIN_VALUE = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__MAX_VALUE = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__STEP = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__VARIABLE_RESOLVER = WIDGET_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Slider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER___LINFERENCE_OBJECT = WIDGET___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Slider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.TextFieldImpl <em>Text Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.TextFieldImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getTextField()
	 * @generated
	 */
	int TEXT_FIELD = 8;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__POSITION = WIDGET__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__VERTICAL_RELATIVE = WIDGET__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__HORIZONTAL_RELATIVE = WIDGET__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__VARIABLE_RESOLVER = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD___LINFERENCE_OBJECT = WIDGET___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Text Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.AbstractButtonImpl <em>Abstract Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.AbstractButtonImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getAbstractButton()
	 * @generated
	 */
	int ABSTRACT_BUTTON = 9;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__POSITION = WIDGET__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__VERTICAL_RELATIVE = WIDGET__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__HORIZONTAL_RELATIVE = WIDGET__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON__TEXT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON___LINFERENCE_OBJECT = WIDGET___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Abstract Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUTTON_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.ui.impl.ButtonImpl <em>Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.ui.impl.ButtonImpl
	 * @see org.sheepy.lily.core.model.ui.impl.UiPackageImpl#getButton()
	 * @generated
	 */
	int BUTTON = 10;

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
	int ABSTRACT_BOOLEAN_BUTTON = 11;

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
	int BOOLEAN_BUTTON = 12;

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
	int BOOLEAN_ACTION_BUTTON = 13;

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

	}

} //UiPackage
