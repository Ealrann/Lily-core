/**
 */
package org.sheepy.lily.core.model.presentation;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.application.IScenePart;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.presentation.UI#getUiPages <em>Ui Pages</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.presentation.UI#getCurrentUIPage <em>Current UI Page</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getUI()
 * @model
 * @generated
 */
public interface UI extends IScenePart
{
	/**
	 * Returns the value of the '<em><b>Ui Pages</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.presentation.UIPage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ui Pages</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getUI_UiPages()
	 * @model containment="true"
	 * @generated
	 */
	EList<UIPage> getUiPages();

	/**
	 * Returns the value of the '<em><b>Current UI Page</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current UI Page</em>' reference.
	 * @see #setCurrentUIPage(UIPage)
	 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getUI_CurrentUIPage()
	 * @model
	 * @generated
	 */
	UIPage getCurrentUIPage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.presentation.UI#getCurrentUIPage <em>Current UI Page</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current UI Page</em>' reference.
	 * @see #getCurrentUIPage()
	 * @generated
	 */
	void setCurrentUIPage(UIPage value);

} // UI
