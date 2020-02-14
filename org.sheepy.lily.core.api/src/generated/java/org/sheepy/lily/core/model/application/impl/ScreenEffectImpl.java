/**
 */
package org.sheepy.lily.core.model.application.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.IScenePart;
import org.sheepy.lily.core.model.application.ScreenEffect;

import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.inference.InferencePackage;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.variable.IModelVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Screen Effect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl#getSrcImage <em>Src Image</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl#getDstImage <em>Dst Image</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ScreenEffectImpl#getShader <em>Shader</em>}</li>
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
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<IModelVariable> inputs;

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
	 * The cached value of the '{@link #getShader() <em>Shader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShader()
	 * @generated
	 * @ordered
	 */
	protected FileResource shader;

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
	public EList<IModelVariable> getInputs()
	{
		if (inputs == null)
		{
			inputs = new EObjectResolvingEList<IModelVariable>(IModelVariable.class, this, ApplicationPackage.SCREEN_EFFECT__INPUTS);
		}
		return inputs;
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
	public FileResource getShader()
	{
		if (shader != null && ((EObject)shader).eIsProxy())
		{
			InternalEObject oldShader = shader;
			shader = (FileResource)eResolveProxy(oldShader);
			if (shader != oldShader)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.SCREEN_EFFECT__SHADER, oldShader, shader));
			}
		}
		return shader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileResource basicGetShader()
	{
		return shader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShader(FileResource newShader)
	{
		FileResource oldShader = shader;
		shader = newShader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCREEN_EFFECT__SHADER, oldShader, shader));
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
			case ApplicationPackage.SCREEN_EFFECT__NAME:
				return getName();
			case ApplicationPackage.SCREEN_EFFECT__INPUTS:
				return getInputs();
			case ApplicationPackage.SCREEN_EFFECT__SRC_IMAGE:
				if (resolve) return getSrcImage();
				return basicGetSrcImage();
			case ApplicationPackage.SCREEN_EFFECT__DST_IMAGE:
				if (resolve) return getDstImage();
				return basicGetDstImage();
			case ApplicationPackage.SCREEN_EFFECT__SHADER:
				if (resolve) return getShader();
				return basicGetShader();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ApplicationPackage.SCREEN_EFFECT__NAME:
				setName((String)newValue);
				return;
			case ApplicationPackage.SCREEN_EFFECT__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends IModelVariable>)newValue);
				return;
			case ApplicationPackage.SCREEN_EFFECT__SRC_IMAGE:
				setSrcImage((IImage)newValue);
				return;
			case ApplicationPackage.SCREEN_EFFECT__DST_IMAGE:
				setDstImage((IImage)newValue);
				return;
			case ApplicationPackage.SCREEN_EFFECT__SHADER:
				setShader((FileResource)newValue);
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
			case ApplicationPackage.SCREEN_EFFECT__INPUTS:
				getInputs().clear();
				return;
			case ApplicationPackage.SCREEN_EFFECT__SRC_IMAGE:
				setSrcImage((IImage)null);
				return;
			case ApplicationPackage.SCREEN_EFFECT__DST_IMAGE:
				setDstImage((IImage)null);
				return;
			case ApplicationPackage.SCREEN_EFFECT__SHADER:
				setShader((FileResource)null);
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
			case ApplicationPackage.SCREEN_EFFECT__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case ApplicationPackage.SCREEN_EFFECT__SRC_IMAGE:
				return srcImage != null;
			case ApplicationPackage.SCREEN_EFFECT__DST_IMAGE:
				return dstImage != null;
			case ApplicationPackage.SCREEN_EFFECT__SHADER:
				return shader != null;
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
				case InferencePackage.IINFERENCE_OBJECT___LINFERENCE_OBJECT: return ApplicationPackage.SCREEN_EFFECT___LINFERENCE_OBJECT;
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
		result.append(')');
		return result.toString();
	}

} //ScreenEffectImpl
