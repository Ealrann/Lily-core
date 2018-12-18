/**
 */
package org.sheepy.common.model.root.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.common.model.action.impl.ActionImpl;

import org.sheepy.common.model.root.LObject;
import org.sheepy.common.model.root.RootPackage;
import org.sheepy.common.model.root.XAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XAction</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class XActionImpl extends ActionImpl implements XAction
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XActionImpl()
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
		return RootPackage.Literals.XACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void execute(LObject object)
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case RootPackage.XACTION___EXECUTE__LOBJECT:
				execute((LObject)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //XActionImpl
