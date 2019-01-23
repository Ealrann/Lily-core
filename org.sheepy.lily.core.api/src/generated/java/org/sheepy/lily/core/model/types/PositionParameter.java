/**
 */
package org.sheepy.common.model.types;

import org.sheepy.common.api.types.SVector2i;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Position Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sheepy.common.model.types.TypesPackage#getPositionParameter()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PositionParameter extends Parameter
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.sheepy.common.model.types.SVector2i" unique="false"
	 * @generated
	 */
	SVector2i getPosition();

} // PositionParameter
