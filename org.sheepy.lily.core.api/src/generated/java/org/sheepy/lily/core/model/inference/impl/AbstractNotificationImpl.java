/**
 */
package org.sheepy.lily.core.model.inference.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.core.model.inference.AbstractNotification;
import org.sheepy.lily.core.model.inference.InferencePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Notification</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class AbstractNotificationImpl extends MinimalEObjectImpl.Container implements AbstractNotification
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNotificationImpl()
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
		return InferencePackage.Literals.ABSTRACT_NOTIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean match(final AbstractNotification compareTo)
	{
		return this.eClass().equals(compareTo.eClass());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case InferencePackage.ABSTRACT_NOTIFICATION___MATCH__ABSTRACTNOTIFICATION:
				return match((AbstractNotification)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //AbstractNotificationImpl
