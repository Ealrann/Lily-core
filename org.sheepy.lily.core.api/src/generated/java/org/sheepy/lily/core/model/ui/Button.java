/**
 */
package org.sheepy.lily.core.model.ui;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.action.Action;

import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.types.EKeyState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Button</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.Button#getShortcut <em>Shortcut</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.Button#getState <em>State</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.Button#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getButton()
 * @model
 * @generated
 */
public interface Button extends AbstractButton
{
	/**
	 * Returns the value of the '<em><b>Shortcut</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shortcut</em>' attribute.
	 * @see #setShortcut(int)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getButton_Shortcut()
	 * @model unique="false"
	 * @generated
	 */
	int getShortcut();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Button#getShortcut <em>Shortcut</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shortcut</em>' attribute.
	 * @see #getShortcut()
	 * @generated
	 */
	void setShortcut(int value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.core.model.types.EKeyState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.sheepy.lily.core.model.types.EKeyState
	 * @see #setState(EKeyState)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getButton_State()
	 * @model unique="false"
	 * @generated
	 */
	EKeyState getState();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Button#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.sheepy.lily.core.model.types.EKeyState
	 * @see #getState()
	 * @generated
	 */
	void setState(EKeyState value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.action.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getButton_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getActions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.sheepy.lily.core.model.action.ActionList" unique="false"
	 * @generated
	 */
	List<? extends Action> lActions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	IInferenceObject getExecutor();

} // Button
