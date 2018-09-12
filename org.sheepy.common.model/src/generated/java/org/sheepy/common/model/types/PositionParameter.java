/**
 */
package org.sheepy.common.model.types;

import org.sheepy.common.model.util.types.Point2i;

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
	 * @model kind="operation" dataType="org.sheepy.common.model.types.LPoint" unique="false"
	 * @generated
	 */
	Point2i getPosition();

} // PositionParameter
