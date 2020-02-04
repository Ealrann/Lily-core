/**
 */
package org.sheepy.lily.core.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.model.application.FileResource;

import org.sheepy.lily.core.model.application.impl.IResourceImpl;

import org.sheepy.lily.core.model.resource.Music;
import org.sheepy.lily.core.model.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Music</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.resource.impl.MusicImpl#getFile <em>File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MusicImpl extends IResourceImpl implements Music
{
	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected FileResource file;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MusicImpl()
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
		return ResourcePackage.Literals.MUSIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FileResource getFile()
	{
		if (file != null && ((EObject)file).eIsProxy())
		{
			InternalEObject oldFile = file;
			file = (FileResource)eResolveProxy(oldFile);
			if (file != oldFile)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcePackage.MUSIC__FILE, oldFile, file));
			}
		}
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileResource basicGetFile()
	{
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFile(FileResource newFile)
	{
		FileResource oldFile = file;
		file = newFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.MUSIC__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ResourcePackage.MUSIC__FILE:
				if (resolve) return getFile();
				return basicGetFile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ResourcePackage.MUSIC__FILE:
				setFile((FileResource)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ResourcePackage.MUSIC__FILE:
				setFile((FileResource)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ResourcePackage.MUSIC__FILE:
				return file != null;
		}
		return super.eIsSet(featureID);
	}

} //MusicImpl
