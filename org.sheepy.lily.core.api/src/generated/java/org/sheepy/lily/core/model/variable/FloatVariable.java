/**
 */
package org.sheepy.lily.core.model.variable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Float Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.FloatVariable#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.variable.VariablePackage#getFloatVariable()
 * @model
 * @generated
 */
public interface FloatVariable extends IModelVariable
{
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(float)
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#getFloatVariable_Value()
	 * @model required="true"
	 * @generated
	 */
	float getValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.variable.FloatVariable#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(float value);

} // FloatVariable
