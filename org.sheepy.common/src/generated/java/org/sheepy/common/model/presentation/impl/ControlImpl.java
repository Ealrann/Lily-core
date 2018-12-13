/**
 */
package org.sheepy.common.model.presentation.impl;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.common.model.presentation.Control;
import org.sheepy.common.model.presentation.PresentationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ControlImpl extends UIElementImpl implements Control
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlImpl()
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
		return PresentationPackage.Literals.CONTROL;
	}

} //ControlImpl
