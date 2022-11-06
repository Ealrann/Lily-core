/**
 */
package org.sheepy.lily.core.model.application.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.SpecialEffect;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.variable.IModelVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Special Effect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.SpecialEffectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.SpecialEffectImpl#getShader <em>Shader</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.SpecialEffectImpl#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecialEffectImpl extends LilyEObject implements SpecialEffect
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
	 * The cached value of the '{@link #getShader() <em>Shader</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShader()
	 * @generated
	 * @ordered
	 */
	protected FileResource shader;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecialEffectImpl()
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
		return ApplicationPackage.Literals.SPECIAL_EFFECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SPECIAL_EFFECT__NAME, oldName, name));
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
				InternalEObject newShader = shader;
				NotificationChain msgs = oldShader.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SPECIAL_EFFECT__SHADER, null, null);
				if (newShader.eInternalContainer() == null)
				{
					msgs = newShader.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SPECIAL_EFFECT__SHADER, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.SPECIAL_EFFECT__SHADER, oldShader, shader));
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
	public NotificationChain basicSetShader(FileResource newShader, NotificationChain msgs)
	{
		FileResource oldShader = shader;
		shader = newShader;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.SPECIAL_EFFECT__SHADER, oldShader, newShader);
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
	public void setShader(FileResource newShader)
	{
		if (newShader != shader)
		{
			NotificationChain msgs = null;
			if (shader != null)
				msgs = ((InternalEObject)shader).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SPECIAL_EFFECT__SHADER, null, msgs);
			if (newShader != null)
				msgs = ((InternalEObject)newShader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SPECIAL_EFFECT__SHADER, null, msgs);
			msgs = basicSetShader(newShader, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SPECIAL_EFFECT__SHADER, newShader, newShader));
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
			inputs = new EObjectResolvingEList<>(IModelVariable.class, this, ApplicationPackage.SPECIAL_EFFECT__INPUTS);
		}
		return inputs;
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
			case ApplicationPackage.SPECIAL_EFFECT__SHADER:
				return basicSetShader(null, msgs);
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
			case ApplicationPackage.SPECIAL_EFFECT__NAME:
				return getName();
			case ApplicationPackage.SPECIAL_EFFECT__SHADER:
				if (resolve) return getShader();
				return basicGetShader();
			case ApplicationPackage.SPECIAL_EFFECT__INPUTS:
				return getInputs();
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
			case ApplicationPackage.SPECIAL_EFFECT__NAME:
				setName((String)newValue);
				return;
			case ApplicationPackage.SPECIAL_EFFECT__SHADER:
				setShader((FileResource)newValue);
				return;
			case ApplicationPackage.SPECIAL_EFFECT__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends IModelVariable>)newValue);
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
			case ApplicationPackage.SPECIAL_EFFECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ApplicationPackage.SPECIAL_EFFECT__SHADER:
				setShader((FileResource)null);
				return;
			case ApplicationPackage.SPECIAL_EFFECT__INPUTS:
				getInputs().clear();
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
			case ApplicationPackage.SPECIAL_EFFECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ApplicationPackage.SPECIAL_EFFECT__SHADER:
				return shader != null;
			case ApplicationPackage.SPECIAL_EFFECT__INPUTS:
				return inputs != null && !inputs.isEmpty();
		}
		return super.eIsSet(featureID);
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

} //SpecialEffectImpl
