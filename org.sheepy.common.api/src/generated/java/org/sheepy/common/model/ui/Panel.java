/**
 */
package org.sheepy.common.model.ui;

import org.eclipse.emf.common.util.EList;
import org.sheepy.common.model.presentation.IPanel;
import org.sheepy.common.model.presentation.ISizedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Panel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.ui.Panel#getControls <em>Controls</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.Panel#isShowTitle <em>Show Title</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.Panel#isMinimizable <em>Minimizable</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.ui.UiPackage#getPanel()
 * @model
 * @generated
 */
public interface Panel extends IPanel, ISizedElement
{
	/**
	 * Returns the value of the '<em><b>Controls</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.common.model.ui.IControl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controls</em>' containment reference list.
	 * @see org.sheepy.common.model.ui.UiPackage#getPanel_Controls()
	 * @model containment="true"
	 * @generated
	 */
	EList<IControl> getControls();

	/**
	 * Returns the value of the '<em><b>Show Title</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Title</em>' attribute.
	 * @see #setShowTitle(boolean)
	 * @see org.sheepy.common.model.ui.UiPackage#getPanel_ShowTitle()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isShowTitle();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.ui.Panel#isShowTitle <em>Show Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Title</em>' attribute.
	 * @see #isShowTitle()
	 * @generated
	 */
	void setShowTitle(boolean value);

	/**
	 * Returns the value of the '<em><b>Minimizable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimizable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimizable</em>' attribute.
	 * @see #setMinimizable(boolean)
	 * @see org.sheepy.common.model.ui.UiPackage#getPanel_Minimizable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isMinimizable();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.ui.Panel#isMinimizable <em>Minimizable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimizable</em>' attribute.
	 * @see #isMinimizable()
	 * @generated
	 */
	void setMinimizable(boolean value);

} // Panel
