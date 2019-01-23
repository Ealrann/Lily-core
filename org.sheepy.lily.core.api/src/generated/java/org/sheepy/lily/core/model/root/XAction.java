/**
 */
package org.sheepy.lily.core.model.root;

import org.sheepy.lily.core.model.action.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAction</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sheepy.lily.core.model.root.RootPackage#getXAction()
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
