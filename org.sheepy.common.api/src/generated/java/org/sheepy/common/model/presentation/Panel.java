/**
 */
package org.sheepy.common.model.presentation;

import org.eclipse.emf.common.util.EList;
import org.sheepy.common.model.root.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Panel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.presentation.Panel#getControls <em>Controls</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.presentation.PresentationPackage#getPanel()
 * @model
 * @generated
 */
public interface Panel extends UIElement, LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Controls</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.common.model.presentation.Control}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controls</em>' containment reference list.
	 * @see org.sheepy.common.model.presentation.PresentationPackage#getPanel_Controls()
	 * @model containment="true"
	 * @generated
	 */
	EList<Control> getControls();

} // Panel
