/**
 */
package org.sheepy.lily.core.model.application.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.joml.Vector3ic;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.resource.ESampling;
import org.sheepy.lily.core.model.resource.IImage;

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
 *   <li>{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl#getExtensionPkg <em>Extension Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl#getClearColor <em>Clear Color</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl#getSampling <em>Sampling</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl#getSrcImage <em>Src Image</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.BackgroundImageImpl#getDstImage <em>Dst Image</em>}</li>
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
	 * The cached value of the '{@link #getExtensionPkg() <em>Extension Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPkg()
	 * @generated
	 * @ordered
	 */
	protected CompositorExtensionPkg extensionPkg;

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
	 * The cached value of the '{@link #getSrcImage() <em>Src Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcImage()
	 * @generated
	 * @ordered
	 */
	protected IImage srcImage;

	/**
	 * The cached value of the '{@link #getDstImage() <em>Dst Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstImage()
	 * @generated
	 * @ordered
	 */
	protected IImage dstImage;

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
	public CompositorExtensionPkg getExtensionPkg()
	{
		if (extensionPkg != null && ((EObject)extensionPkg).eIsProxy())
		{
			InternalEObject oldExtensionPkg = extensionPkg;
			extensionPkg = (CompositorExtensionPkg)eResolveProxy(oldExtensionPkg);
			if (extensionPkg != oldExtensionPkg)
			{
				InternalEObject newExtensionPkg = extensionPkg;
				NotificationChain msgs = oldExtensionPkg.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG, null, null);
				if (newExtensionPkg.eInternalContainer() == null)
				{
					msgs = newExtensionPkg.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG, oldExtensionPkg, extensionPkg));
			}
		}
		return extensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositorExtensionPkg basicGetExtensionPkg()
	{
		return extensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionPkg(CompositorExtensionPkg newExtensionPkg, NotificationChain msgs)
	{
		CompositorExtensionPkg oldExtensionPkg = extensionPkg;
		extensionPkg = newExtensionPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG, oldExtensionPkg, newExtensionPkg);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtensionPkg(CompositorExtensionPkg newExtensionPkg)
	{
		if (newExtensionPkg != extensionPkg)
		{
			NotificationChain msgs = null;
			if (extensionPkg != null)
				msgs = ((InternalEObject)extensionPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG, null, msgs);
			if (newExtensionPkg != null)
				msgs = ((InternalEObject)newExtensionPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG, null, msgs);
			msgs = basicSetExtensionPkg(newExtensionPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG, newExtensionPkg, newExtensionPkg));
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
	public IImage getSrcImage()
	{
		if (srcImage != null && ((EObject)srcImage).eIsProxy())
		{
			InternalEObject oldSrcImage = srcImage;
			srcImage = (IImage)eResolveProxy(oldSrcImage);
			if (srcImage != oldSrcImage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.BACKGROUND_IMAGE__SRC_IMAGE, oldSrcImage, srcImage));
			}
		}
		return srcImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IImage basicGetSrcImage()
	{
		return srcImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcImage(IImage newSrcImage)
	{
		IImage oldSrcImage = srcImage;
		srcImage = newSrcImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.BACKGROUND_IMAGE__SRC_IMAGE, oldSrcImage, srcImage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IImage getDstImage()
	{
		if (dstImage != null && ((EObject)dstImage).eIsProxy())
		{
			InternalEObject oldDstImage = dstImage;
			dstImage = (IImage)eResolveProxy(oldDstImage);
			if (dstImage != oldDstImage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.BACKGROUND_IMAGE__DST_IMAGE, oldDstImage, dstImage));
			}
		}
		return dstImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IImage basicGetDstImage()
	{
		return dstImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstImage(IImage newDstImage)
	{
		IImage oldDstImage = dstImage;
		dstImage = newDstImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.BACKGROUND_IMAGE__DST_IMAGE, oldDstImage, dstImage));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG:
				return basicSetExtensionPkg(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG:
				if (resolve) return getExtensionPkg();
				return basicGetExtensionPkg();
			case ApplicationPackage.BACKGROUND_IMAGE__CLEAR_COLOR:
				return getClearColor();
			case ApplicationPackage.BACKGROUND_IMAGE__SAMPLING:
				return getSampling();
			case ApplicationPackage.BACKGROUND_IMAGE__SRC_IMAGE:
				if (resolve) return getSrcImage();
				return basicGetSrcImage();
			case ApplicationPackage.BACKGROUND_IMAGE__DST_IMAGE:
				if (resolve) return getDstImage();
				return basicGetDstImage();
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
			case ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG:
				setExtensionPkg((CompositorExtensionPkg)newValue);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__CLEAR_COLOR:
				setClearColor((Vector3ic)newValue);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__SAMPLING:
				setSampling((ESampling)newValue);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__SRC_IMAGE:
				setSrcImage((IImage)newValue);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__DST_IMAGE:
				setDstImage((IImage)newValue);
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
			case ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG:
				setExtensionPkg((CompositorExtensionPkg)null);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__CLEAR_COLOR:
				setClearColor(CLEAR_COLOR_EDEFAULT);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__SAMPLING:
				setSampling(SAMPLING_EDEFAULT);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__SRC_IMAGE:
				setSrcImage((IImage)null);
				return;
			case ApplicationPackage.BACKGROUND_IMAGE__DST_IMAGE:
				setDstImage((IImage)null);
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
			case ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG:
				return extensionPkg != null;
			case ApplicationPackage.BACKGROUND_IMAGE__CLEAR_COLOR:
				return CLEAR_COLOR_EDEFAULT == null ? clearColor != null : !CLEAR_COLOR_EDEFAULT.equals(clearColor);
			case ApplicationPackage.BACKGROUND_IMAGE__SAMPLING:
				return sampling != SAMPLING_EDEFAULT;
			case ApplicationPackage.BACKGROUND_IMAGE__SRC_IMAGE:
				return srcImage != null;
			case ApplicationPackage.BACKGROUND_IMAGE__DST_IMAGE:
				return dstImage != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == IInferenceObject.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == ICompositor.class)
		{
			switch (derivedFeatureID)
			{
				case ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG: return ApplicationPackage.ICOMPOSITOR__EXTENSION_PKG;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == IInferenceObject.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == ICompositor.class)
		{
			switch (baseFeatureID)
			{
				case ApplicationPackage.ICOMPOSITOR__EXTENSION_PKG: return ApplicationPackage.BACKGROUND_IMAGE__EXTENSION_PKG;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		if (baseClass == ICompositor.class)
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
