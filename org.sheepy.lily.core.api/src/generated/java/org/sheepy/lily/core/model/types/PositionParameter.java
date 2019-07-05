/**
 */
package org.sheepy.lily.core.model.types;

import org.joml.Vector2ic;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Position Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sheepy.lily.core.model.types.TypesPackage#getPositionParameter()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PositionParameter extends Parameter
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.sheepy.lily.core.model.types.Vector2i" unique="false"
	 * @generated
	 */
	Vector2ic getPosition();

} // PositionParameter
