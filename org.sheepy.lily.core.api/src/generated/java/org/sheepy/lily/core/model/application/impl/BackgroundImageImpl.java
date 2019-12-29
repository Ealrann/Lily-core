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

import org.joml.Vector3ic;
import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.application.ESampling;
import org.sheepy.lily.core.model.application.IImage;
import org.sheepy.lily.core.model.application.IScenePart;

import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.inference.InferencePackage;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Background Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl#getClearColor <em>Clear Color</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl#getSampling <em>Sampling</em>}</li>
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
	 * The cached value of the '{@link #getImage() <em>Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected IImage image;

	/**
	 * The default value of the '{@link #getClearColor() <em>Clear Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClearColor()
	 * @generated
	 * @ordered
	 */
	protected static final Vector3ic CLEAR_COLOR_EDEFAULT = (Vector3ic)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector3i(), "0;0;0");

	/**
	 * The cached value of the '{@link #getClearColor() <em>Clear Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClearColor()
	 * @generated
	 * @ordered
	 */
	protected Vector3ic clearColor = CLEAR_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSampling() <em>Sampling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampling()
	 * @generated
	 * @ordered
	 */
	protected static final ESampling SAMPLING_EDEFAULT = ESampling.LINEAR;

	/**
	 * The cached value of the '{@link #getSampling() <em>Sampling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampling()
	 * @generated
	 * @ordered
	 */
	protected ESampling sampling = SAMPLING_EDEFAULT;

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
	public IImage getImage()
	{
		if (image != null && ((EObject)image).eIsProxy())
		{
			InternalEObject oldImage = (InternalEObject)image;
			image = (IImage)eResolveProxy(oldImage);
			if (image != oldImage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.BACKGROUND_IMAGE__IMAGE, oldImage, image));
			}
		}
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IImage basicGetImage()
	{
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImage(IImage newImage)
	{
		IImage oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.BACKGROUND_IMAGE__IMAGE, oldImage, image));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector3ic getClearColor()
	{
		return clearColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClearColor(Vector3ic newClearColor)
	{
		Vector3ic oldClearColor = clearColor;
		clearColor = newClearColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.BACKGROUND_IMAGE__CLEAR_COLOR, oldClearColor, clearColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ESampling getSampling()
	{
		return sampling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSampling(ESampling newSampling)
	{
		ESampling oldSampling = sampling;
		sampling = newSampling == null ? SAMPLING_EDEFAULT : newSampling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.BACKGROUND_IMAGE__SAMPLING, oldSampling, sampling));
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
			case ApplicationPackage.BACKGROUND_IMAGE__IMAGE:
				if (resolve) return getImage();
				return basicGetImage();
			case ApplicationPackage.BACKGROUND_IMAGE__CLEAR_COLOR:
				return getClearColor();
			case ApplicationPackage.BACKGROUND_IMAGE__SAMPLING:
				return getSampling();
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
			case ApplicationPackage.BACKGROUND_IMAGE__IMAGE:
				setImage((IImage)newValue);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__CLEAR_COLOR:
				setClearColor((Vector3ic)newValue);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__SAMPLING:
				setSampling((ESampling)newValue);
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
			case ApplicationPackage.BACKGROUND_IMAGE__IMAGE:
				setImage((IImage)null);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__CLEAR_COLOR:
				setClearColor(CLEAR_COLOR_EDEFAULT);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__SAMPLING:
				setSampling(SAMPLING_EDEFAULT);
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
			case ApplicationPackage.BACKGROUND_IMAGE__IMAGE:
				return image != null;
			case ApplicationPackage.BACKGROUND_IMAGE__CLEAR_COLOR:
				return CLEAR_COLOR_EDEFAULT == null ? clearColor != null : !CLEAR_COLOR_EDEFAULT.equals(clearColor);
			case ApplicationPackage.BACKGROUND_IMAGE__SAMPLING:
				return sampling != SAMPLING_EDEFAULT;
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
		result.append(", clearColor: ");
		result.append(clearColor);
		result.append(", sampling: ");
		result.append(sampling);
		result.append(')');
		return result.toString();
	}

} //BackgroundImageImpl
