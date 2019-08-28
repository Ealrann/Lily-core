/**
 */
package org.sheepy.lily.core.model.inference;

import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.model.types.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.inference.Condition#getValue <em>Value</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.inference.Condition#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.inference.InferencePackage#getCondition()
 * @model interface="true" abstract="true"
 * @extends ILilyEObject
 * @generated
 */
public interface Condition<T extends Parameter> extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Parameter)
	 * @see org.sheepy.lily.core.model.inference.InferencePackage#getCondition_Value()
	 * @model containment="true"
	 * @generated
	 */
	T getValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.inference.Condition#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(T value);

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(LNotification)
	 * @see org.sheepy.lily.core.model.inference.InferencePackage#getCondition_Definition()
	 * @model
	 * @generated
	 */
	LNotification getDefinition();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.inference.Condition#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(LNotification value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Class<T> getType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" compareToUnique="false"
	 * @generated
	 */
	boolean match(T compareTo);

} // Condition
