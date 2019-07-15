/**
 */
package org.sheepy.lily.core.model.root.impl;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.lily.core.model.action.impl.ActionImpl;

import org.sheepy.lily.core.model.root.LObject;
import org.sheepy.lily.core.model.root.RootPackage;
import org.sheepy.lily.core.model.root.XAction;

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
	protected XActionImpl()
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

} //XActionImpl
