/**
 */
package org.sheepy.common.model.ui;

import org.sheepy.common.model.presentation.Control;

import org.sheepy.common.model.variable.VariableResolver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.ui.TextField#getVariableResolver <em>Variable Resolver</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.ui.UiPackage#getTextField()
 * @model
 * @generated
 */
public interface TextField extends Control
{
	/**
	 * Returns the value of the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Resolver</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #setVariableResolver(VariableResolver)
	 * @see org.sheepy.common.model.ui.UiPackage#getTextField_VariableResolver()
	 * @model containment="true"
	 * @generated
	 */
	VariableResolver getVariableResolver();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.ui.TextField#getVariableResolver <em>Variable Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #getVariableResolver()
	 * @generated
	 */
	void setVariableResolver(VariableResolver value);

} // TextField
