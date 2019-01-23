/**
 */
package org.sheepy.common.model.inference.impl;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.common.model.inference.InferencePackage;
import org.sheepy.common.model.inference.ParameteredNotification;

import org.sheepy.common.model.types.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parametered Notification</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ParameteredNotificationImpl<T extends Parameter> extends AbstractNotificationImpl implements ParameteredNotification<T>
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameteredNotificationImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return InferencePackage.Literals.PARAMETERED_NOTIFICATION;
	}

} //ParameteredNotificationImpl
