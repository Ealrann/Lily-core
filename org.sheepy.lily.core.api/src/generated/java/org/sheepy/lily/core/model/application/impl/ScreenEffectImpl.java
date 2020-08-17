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

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.application.ScreenEffect;
import org.sheepy.lily.core.model.application.SpecialEffect;

import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.resource.IImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Screen Effect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl#getExtensionPkg <em>Extension Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl#getSrcImage <em>Src Image</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl#getDstImage <em>Dst Image</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl#getEffect <em>Effect</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScreenEffectImpl extends LilyEObject implements ScreenEffect
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
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

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
	 * The cached value of the '{@link #getEffect() <em>Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffect()
	 * @generated
	 * @ordered
	 */
	protected SpecialEffect effect;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScreenEffectImpl()
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
		return ApplicationPackage.Literals.SCREEN_EFFECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCREEN_EFFECT__NAME, oldName, name));
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
				NotificationChain msgs = oldExtensionPkg.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG, null, null);
				if (newExtensionPkg.eInternalContainer() == null)
				{
					msgs = newExtensionPkg.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG, oldExtensionPkg, extensionPkg));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG, oldExtensionPkg, newExtensionPkg);
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
				msgs = ((InternalEObject)extensionPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG, null, msgs);
			if (newExtensionPkg != null)
				msgs = ((InternalEObject)newExtensionPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG, null, msgs);
			msgs = basicSetExtensionPkg(newExtensionPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG, newExtensionPkg, newExtensionPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCREEN_EFFECT__ENABLED, oldEnabled, enabled));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.SCREEN_EFFECT__SRC_IMAGE, oldSrcImage, srcImage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCREEN_EFFECT__SRC_IMAGE, oldSrcImage, srcImage));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.SCREEN_EFFECT__DST_IMAGE, oldDstImage, dstImage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCREEN_EFFECT__DST_IMAGE, oldDstImage, dstImage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpecialEffect getEffect()
	{
		if (effect != null && ((EObject)effect).eIsProxy())
		{
			InternalEObject oldEffect = effect;
			effect = (SpecialEffect)eResolveProxy(oldEffect);
			if (effect != oldEffect)
			{
				InternalEObject newEffect = effect;
				NotificationChain msgs = oldEffect.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SCREEN_EFFECT__EFFECT, null, null);
				if (newEffect.eInternalContainer() == null)
				{
					msgs = newEffect.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SCREEN_EFFECT__EFFECT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.SCREEN_EFFECT__EFFECT, oldEffect, effect));
			}
		}
		return effect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialEffect basicGetEffect()
	{
		return effect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEffect(SpecialEffect newEffect, NotificationChain msgs)
	{
		SpecialEffect oldEffect = effect;
		effect = newEffect;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCREEN_EFFECT__EFFECT, oldEffect, newEffect);
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
	public void setEffect(SpecialEffect newEffect)
	{
		if (newEffect != effect)
		{
			NotificationChain msgs = null;
			if (effect != null)
				msgs = ((InternalEObject)effect).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SCREEN_EFFECT__EFFECT, null, msgs);
			if (newEffect != null)
				msgs = ((InternalEObject)newEffect).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SCREEN_EFFECT__EFFECT, null, msgs);
			msgs = basicSetEffect(newEffect, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCREEN_EFFECT__EFFECT, newEffect, newEffect));
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
			case ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG:
				return basicSetExtensionPkg(null, msgs);
			case ApplicationPackage.SCREEN_EFFECT__EFFECT:
				return basicSetEffect(null, msgs);
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
			case ApplicationPackage.SCREEN_EFFECT__NAME:
				return getName();
			case ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG:
				if (resolve) return getExtensionPkg();
				return basicGetExtensionPkg();
			case ApplicationPackage.SCREEN_EFFECT__ENABLED:
				return isEnabled();
			case ApplicationPackage.SCREEN_EFFECT__SRC_IMAGE:
				if (resolve) return getSrcImage();
				return basicGetSrcImage();
			case ApplicationPackage.SCREEN_EFFECT__DST_IMAGE:
				if (resolve) return getDstImage();
				return basicGetDstImage();
			case ApplicationPackage.SCREEN_EFFECT__EFFECT:
				if (resolve) return getEffect();
				return basicGetEffect();
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
			case ApplicationPackage.SCREEN_EFFECT__NAME:
				setName((String)newValue);
				return;
			case ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG:
				setExtensionPkg((CompositorExtensionPkg)newValue);
				return;
			case ApplicationPackage.SCREEN_EFFECT__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ApplicationPackage.SCREEN_EFFECT__SRC_IMAGE:
				setSrcImage((IImage)newValue);
				return;
			case ApplicationPackage.SCREEN_EFFECT__DST_IMAGE:
				setDstImage((IImage)newValue);
				return;
			case ApplicationPackage.SCREEN_EFFECT__EFFECT:
				setEffect((SpecialEffect)newValue);
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
			case ApplicationPackage.SCREEN_EFFECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG:
				setExtensionPkg((CompositorExtensionPkg)null);
				return;
			case ApplicationPackage.SCREEN_EFFECT__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ApplicationPackage.SCREEN_EFFECT__SRC_IMAGE:
				setSrcImage((IImage)null);
				return;
			case ApplicationPackage.SCREEN_EFFECT__DST_IMAGE:
				setDstImage((IImage)null);
				return;
			case ApplicationPackage.SCREEN_EFFECT__EFFECT:
				setEffect((SpecialEffect)null);
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
			case ApplicationPackage.SCREEN_EFFECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG:
				return extensionPkg != null;
			case ApplicationPackage.SCREEN_EFFECT__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ApplicationPackage.SCREEN_EFFECT__SRC_IMAGE:
				return srcImage != null;
			case ApplicationPackage.SCREEN_EFFECT__DST_IMAGE:
				return dstImage != null;
			case ApplicationPackage.SCREEN_EFFECT__EFFECT:
				return effect != null;
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
				case ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG: return ApplicationPackage.ICOMPOSITOR__EXTENSION_PKG;
				case ApplicationPackage.SCREEN_EFFECT__ENABLED: return ApplicationPackage.ICOMPOSITOR__ENABLED;
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
				case ApplicationPackage.ICOMPOSITOR__EXTENSION_PKG: return ApplicationPackage.SCREEN_EFFECT__EXTENSION_PKG;
				case ApplicationPackage.ICOMPOSITOR__ENABLED: return ApplicationPackage.SCREEN_EFFECT__ENABLED;
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
				case InferencePackage.IINFERENCE_OBJECT___LINFERENCE_OBJECT: return ApplicationPackage.SCREEN_EFFECT___LINFERENCE_OBJECT;
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
			case ApplicationPackage.SCREEN_EFFECT___LINFERENCE_OBJECT:
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
		result.append(", enabled: ");
		result.append(enabled);
		result.append(')');
		return result.toString();
	}

} //ScreenEffectImpl
