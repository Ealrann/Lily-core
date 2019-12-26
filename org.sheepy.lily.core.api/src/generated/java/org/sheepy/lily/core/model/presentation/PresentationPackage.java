/**
 */
package org.sheepy.lily.core.model.presentation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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

	}

} //PresentationPackage
