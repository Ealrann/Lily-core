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
 *   <li>{@link org.sheepy.lily.core.model.ui.VariableLabel#isShowName <em>Show Name</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Show Name</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Name</em>' attribute.
	 * @see #setShowName(boolean)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getVariableLabel_ShowName()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isShowName();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.VariableLabel#isShowName <em>Show Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Name</em>' attribute.
	 * @see #isShowName()
	 * @generated
	 */
	void setShowName(boolean value);

} // VariableLabel
