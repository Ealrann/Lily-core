/**
 */
package org.sheepy.lily.core.model.ui;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.core.model.ui.UiPackage
 * @generated
 */
public interface UiFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UiFactory eINSTANCE = org.sheepy.lily.core.model.ui.impl.UiFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Panel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Panel</em>'.
	 * @generated
	 */
	Panel createPanel();

	/**
	 * Returns a new object of class '<em>UI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UI</em>'.
	 * @generated
	 */
	UI createUI();

	/**
	 * Returns a new object of class '<em>UI Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UI Page</em>'.
	 * @generated
	 */
	UIPage createUIPage();

	/**
	 * Returns a new object of class '<em>Dynamic Row Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Row Layout</em>'.
	 * @generated
	 */
	DynamicRowLayout createDynamicRowLayout();

	/**
	 * Returns a new object of class '<em>Variable Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Label</em>'.
	 * @generated
	 */
	VariableLabel createVariableLabel();

	/**
	 * Returns a new object of class '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Label</em>'.
	 * @generated
	 */
	Label createLabel();

	/**
	 * Returns a new object of class '<em>Slider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Slider</em>'.
	 * @generated
	 */
	Slider createSlider();

	/**
	 * Returns a new object of class '<em>Text Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Field</em>'.
	 * @generated
	 */
	TextField createTextField();

	/**
	 * Returns a new object of class '<em>Button</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Button</em>'.
	 * @generated
	 */
	Button createButton();

	/**
	 * Returns a new object of class '<em>Boolean Button</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Button</em>'.
	 * @generated
	 */
	BooleanButton createBooleanButton();

	/**
	 * Returns a new object of class '<em>Boolean Action Button</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Action Button</em>'.
	 * @generated
	 */
	BooleanActionButton createBooleanActionButton();

	/**
	 * Returns a new object of class '<em>Font Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Font Pkg</em>'.
	 * @generated
	 */
	FontPkg createFontPkg();

	/**
	 * Returns a new object of class '<em>Font Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Font Table</em>'.
	 * @generated
	 */
	FontTable createFontTable();

	/**
	 * Returns a new object of class '<em>Font</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Font</em>'.
	 * @generated
	 */
	Font createFont();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UiPackage getUiPackage();

} //UiFactory
