/**
 */
package org.sheepy.common.model.presentation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.presentation.UIPage#getPanels <em>Panels</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.presentation.PresentationPackage#getUIPage()
 * @model
 * @generated
 */
public interface UIPage extends ISizedElement
{
	/**
	 * Returns the value of the '<em><b>Panels</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.common.model.presentation.IPanel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Panels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Panels</em>' containment reference list.
	 * @see org.sheepy.common.model.presentation.PresentationPackage#getUIPage_Panels()
	 * @model containment="true"
	 * @generated
	 */
	EList<IPanel> getPanels();

} // UIPage
