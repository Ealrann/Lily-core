/**
 */
package org.sheepy.lily.core.model.presentation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.application.ApplicationPackage;
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
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT__POSITION = 0;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT__VERTICAL_RELATIVE = 1;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT__HORIZONTAL_RELATIVE = 2;

	/**
	 * The number of structural features of the '<em>IPosition Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>IPosition Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOSITION_ELEMENT_OPERATION_COUNT = 0;

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
	 * The number of operations of the '<em>ISized Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISIZED_ELEMENT_OPERATION_COUNT = IPOSITION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.presentation.UI <em>UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.presentation.UI
	 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getUI()
	 * @generated
	 */
	int UI = 2;

	/**
	 * The feature id for the '<em><b>Ui Pages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI__UI_PAGES = ApplicationPackage.ISCENE_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Current UI Page</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI__CURRENT_UI_PAGE = ApplicationPackage.ISCENE_PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_FEATURE_COUNT = ApplicationPackage.ISCENE_PART_FEATURE_COUNT + 2;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.presentation.IUIElement <em>IUI Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.presentation.IUIElement
	 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getIUIElement()
	 * @generated
	 */
	int IUI_ELEMENT = 3;

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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.presentation.impl.UIPageImpl <em>UI Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.presentation.impl.UIPageImpl
	 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getUIPage()
	 * @generated
	 */
	int UI_PAGE = 4;

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
	int IPANEL = 5;

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
	 * The number of structural features of the '<em>IPanel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPANEL_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 3;

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
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.presentation.UI <em>UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI</em>'.
	 * @see org.sheepy.lily.core.model.presentation.UI
	 * @generated
	 */
	EClass getUI();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.presentation.UI#getUiPages <em>Ui Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ui Pages</em>'.
	 * @see org.sheepy.lily.core.model.presentation.UI#getUiPages()
	 * @see #getUI()
	 * @generated
	 */
	EReference getUI_UiPages();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.presentation.UI#getCurrentUIPage <em>Current UI Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current UI Page</em>'.
	 * @see org.sheepy.lily.core.model.presentation.UI#getCurrentUIPage()
	 * @see #getUI()
	 * @generated
	 */
	EReference getUI_CurrentUIPage();

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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.presentation.UI <em>UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.presentation.UI
		 * @see org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl#getUI()
		 * @generated
		 */
		EClass UI = eINSTANCE.getUI();

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
