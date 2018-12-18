/**
 */
package org.sheepy.common.model.root;

import org.sheepy.common.model.action.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAction</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sheepy.common.model.root.RootPackage#getXAction()
 * @model abstract="true"
 * @generated
 */
public interface XAction extends Action
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model objectUnique="false"
	 * @generated
	 */
	void execute(LObject object);

} // XAction
