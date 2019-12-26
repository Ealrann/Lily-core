/**
 */
package org.sheepy.lily.core.model.ui;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.UIPage#getPanels <em>Panels</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getUIPage()
 * @model
 * @generated
 */
public interface UIPage extends ISizedElement, LNamedElement
{

	/**
	 * Returns the value of the '<em><b>Panels</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.ui.IPanel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Panels</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getUIPage_Panels()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IPanel> getPanels();
} // UIPage
