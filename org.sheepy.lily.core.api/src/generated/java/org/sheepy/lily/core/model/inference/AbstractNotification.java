/**
 */
package org.sheepy.lily.core.model.inference;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Notification</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sheepy.lily.core.model.inference.InferencePackage#getAbstractNotification()
 * @model abstract="true"
 * @extends ILilyEObject
 * @generated
 */
public interface AbstractNotification extends ILilyEObject
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" compareToUnique="false"
	 * @generated
	 */
	boolean match(AbstractNotification compareTo);

} // AbstractNotification
