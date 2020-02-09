/**
 */
package org.sheepy.lily.core.model.resource.impl;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.lily.core.model.resource.LocalResource;
import org.sheepy.lily.core.model.resource.ResourcePackage;

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
		return ResourcePackage.Literals.LOCAL_RESOURCE;
	}

} //LocalResourceImpl
