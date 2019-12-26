/**
 */
package org.sheepy.lily.core.model.ui;

import org.sheepy.lily.core.model.variable.IVariableResolver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.TextField#getVariableResolver <em>Variable Resolver</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getTextField()
 * @model
 * @generated
 */
public interface TextField extends TextWidget
{
	/**
	 * Returns the value of the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #setVariableResolver(IVariableResolver)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getTextField_VariableResolver()
	 * @model containment="true"
	 * @generated
	 */
	IVariableResolver getVariableResolver();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.TextField#getVariableResolver <em>Variable Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #getVariableResolver()
	 * @generated
	 */
	void setVariableResolver(IVariableResolver value);

} // TextField
