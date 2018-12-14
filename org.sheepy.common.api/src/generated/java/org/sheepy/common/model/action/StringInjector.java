/**
 */
package org.sheepy.common.model.action;

import org.sheepy.common.model.types.StringParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Injector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.action.StringInjector#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.action.ActionPackage#getStringInjector()
 * @model
 * @generated
 */
public interface StringInjector extends TypeInjectorAction<StringParameter>
{
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.sheepy.common.model.action.ActionPackage#getStringInjector_Value()
	 * @model unique="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.action.StringInjector#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	StringParameter getInjectedValue();

} // StringInjector
