/**
 */
package org.sheepy.common.model.presentation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.common.model.presentation.PresentationPackage
 * @generated
 */
public interface PresentationFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PresentationFactory eINSTANCE = org.sheepy.common.model.presentation.impl.PresentationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Tranparent UI View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tranparent UI View</em>'.
	 * @generated
	 */
	TranparentUIView createTranparentUIView();

	/**
	 * Returns a new object of class '<em>UI Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UI Page</em>'.
	 * @generated
	 */
	UIPage createUIPage();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PresentationPackage getPresentationPackage();

} //PresentationFactory
