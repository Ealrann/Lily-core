/**
 */
package org.sheepy.lily.core.model.ui;

import org.sheepy.lily.core.model.variable.IVariableResolver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.VariableLabel#getVariableResolver <em>Variable Resolver</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getVariableLabel()
 * @model
 * @generated
 */
public interface VariableLabel extends AbstractLabel
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
	 * @see #setVariableResolver(IVariableResolver)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getVariableLabel_VariableResolver()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IVariableResolver getVariableResolver();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.VariableLabel#getVariableResolver <em>Variable Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #getVariableResolver()
	 * @generated
	 */
	void setVariableResolver(IVariableResolver value);

} // VariableLabel
