/**
 */
package org.sheepy.lily.core.model.inference;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Notification</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sheepy.lily.core.model.inference.InferencePackage#getAbstractNotification()
 * @model abstract="true"
 * @generated
 */
public interface AbstractNotification extends EObject
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" compareToUnique="false"
	 * @generated
	 */
	boolean match(AbstractNotification compareTo);

} // AbstractNotification
