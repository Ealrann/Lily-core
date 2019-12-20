/**
 */
package org.sheepy.lily.core.model.application.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.application.IResource;
import org.sheepy.lily.core.model.application.IScenePart;

import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.inference.InferencePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Background Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl#getResource <em>Resource</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BackgroundImageImpl extends LilyEObject implements BackgroundImage
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected IResource resource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BackgroundImageImpl()
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
		return ApplicationPackage.Literals.BACKGROUND_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.BACKGROUND_IMAGE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IResource getResource()
	{
		if (resource != null && ((EObject)resource).eIsProxy())
		{
			InternalEObject oldResource = (InternalEObject)resource;
			resource = (IResource)eResolveProxy(oldResource);
			if (resource != oldResource)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.BACKGROUND_IMAGE__RESOURCE, oldResource, resource));
			}
		}
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IResource basicGetResource()
	{
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResource(IResource newResource)
	{
		IResource oldResource = resource;
		resource = newResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.BACKGROUND_IMAGE__RESOURCE, oldResource, resource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IInferenceObject lInferenceObject()
	{
		return this;
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
			case ApplicationPackage.BACKGROUND_IMAGE__NAME:
				return getName();
			case ApplicationPackage.BACKGROUND_IMAGE__RESOURCE:
				if (resolve) return getResource();
				return basicGetResource();
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
			case ApplicationPackage.BACKGROUND_IMAGE__NAME:
				setName((String)newValue);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__RESOURCE:
				setResource((IResource)newValue);
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
			case ApplicationPackage.BACKGROUND_IMAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__RESOURCE:
				setResource((IResource)null);
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
			case ApplicationPackage.BACKGROUND_IMAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ApplicationPackage.BACKGROUND_IMAGE__RESOURCE:
				return resource != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
	{
		if (baseClass == IInferenceObject.class)
		{
			switch (baseOperationID)
			{
				case InferencePackage.IINFERENCE_OBJECT___LINFERENCE_OBJECT: return ApplicationPackage.BACKGROUND_IMAGE___LINFERENCE_OBJECT;
				default: return -1;
			}
		}
		if (baseClass == IScenePart.class)
		{
			switch (baseOperationID)
			{
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case ApplicationPackage.BACKGROUND_IMAGE___LINFERENCE_OBJECT:
				return lInferenceObject();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //BackgroundImageImpl
