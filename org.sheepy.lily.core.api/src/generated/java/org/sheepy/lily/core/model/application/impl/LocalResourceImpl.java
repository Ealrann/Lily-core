/**
 */
package org.sheepy.lily.core.model.application.impl;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.LocalResource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class LocalResourceImpl extends FileResourceImpl implements LocalResource
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalResourceImpl()
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
		return ApplicationPackage.Literals.LOCAL_RESOURCE;
	}

} //LocalResourceImpl
