/**
 */
package org.sheepy.lily.core.model.ui;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.application.IImage;
import org.sheepy.lily.core.model.presentation.ISizedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Panel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.Panel#getControls <em>Controls</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.Panel#isShowTitle <em>Show Title</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.Panel#isMinimizable <em>Minimizable</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.Panel#isMovable <em>Movable</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.Panel#isMinimized <em>Minimized</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.Panel#getBackgroundImage <em>Background Image</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getPanel()
 * @model
 * @generated
 */
public interface Panel extends IPanel, ISizedElement
{
	/**
	 * Returns the value of the '<em><b>Controls</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.ui.IControl}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controls</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getPanel_Controls()
	 * @model containment="true"
	 * @generated
	 */
	EList<IControl> getControls();

	/**
	 * Returns the value of the '<em><b>Show Title</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Title</em>' attribute.
	 * @see #setShowTitle(boolean)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getPanel_ShowTitle()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isShowTitle();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Panel#isShowTitle <em>Show Title</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimizable</em>' attribute.
	 * @see #setMinimizable(boolean)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getPanel_Minimizable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isMinimizable();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Panel#isMinimizable <em>Minimizable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimizable</em>' attribute.
	 * @see #isMinimizable()
	 * @generated
	 */
	void setMinimizable(boolean value);

	/**
	 * Returns the value of the '<em><b>Movable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Movable</em>' attribute.
	 * @see #setMovable(boolean)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getPanel_Movable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isMovable();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Panel#isMovable <em>Movable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Movable</em>' attribute.
	 * @see #isMovable()
	 * @generated
	 */
	void setMovable(boolean value);

	/**
	 * Returns the value of the '<em><b>Minimized</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimized</em>' attribute.
	 * @see #setMinimized(boolean)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getPanel_Minimized()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isMinimized();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Panel#isMinimized <em>Minimized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimized</em>' attribute.
	 * @see #isMinimized()
	 * @generated
	 */
	void setMinimized(boolean value);

	/**
	 * Returns the value of the '<em><b>Background Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Image</em>' reference.
	 * @see #setBackgroundImage(IImage)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getPanel_BackgroundImage()
	 * @model
	 * @generated
	 */
	IImage getBackgroundImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Panel#getBackgroundImage <em>Background Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Image</em>' reference.
	 * @see #getBackgroundImage()
	 * @generated
	 */
	void setBackgroundImage(IImage value);

} // Panel
