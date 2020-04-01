/**
 */
package org.sheepy.lily.core.model.variable;

import org.joml.Vector3fc;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vector3f Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.Vector3fVariable#getVector <em>Vector</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.variable.VariablePackage#getVector3fVariable()
 * @model
 * @generated
 */
public interface Vector3fVariable extends IModelVariable
{
	/**
	 * Returns the value of the '<em><b>Vector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vector</em>' attribute.
	 * @see #setVector(Vector3fc)
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#getVector3fVariable_Vector()
	 * @model dataType="org.sheepy.lily.core.model.types.Vector3f"
	 * @generated
	 */
	Vector3fc getVector();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.variable.Vector3fVariable#getVector <em>Vector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vector</em>' attribute.
	 * @see #getVector()
	 * @generated
	 */
	void setVector(Vector3fc value);

} // Vector3fVariable
