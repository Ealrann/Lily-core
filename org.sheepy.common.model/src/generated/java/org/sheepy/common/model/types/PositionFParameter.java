/**
 */
package org.sheepy.common.model.types;

import org.sheepy.common.model.util.types.Point2f;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Position FParameter</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sheepy.common.model.types.TypesPackage#getPositionFParameter()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PositionFParameter extends Parameter
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.sheepy.common.model.types.LPointF" unique="false"
	 * @generated
	 */
	Point2f getPosition();

} // PositionFParameter
