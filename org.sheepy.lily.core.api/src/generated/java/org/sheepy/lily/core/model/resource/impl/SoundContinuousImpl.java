/**
 */
package org.sheepy.lily.core.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.core.model.resource.SoundContinuous;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sound Continuous</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.resource.impl.SoundContinuousImpl#getAttackMs <em>Attack Ms</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.resource.impl.SoundContinuousImpl#getDecayMs <em>Decay Ms</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SoundContinuousImpl extends SoundImpl implements SoundContinuous
{
	/**
	 * The default value of the '{@link #getAttackMs() <em>Attack Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackMs()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTACK_MS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAttackMs() <em>Attack Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackMs()
	 * @generated
	 * @ordered
	 */
	protected int attackMs = ATTACK_MS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDecayMs() <em>Decay Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecayMs()
	 * @generated
	 * @ordered
	 */
	protected static final int DECAY_MS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDecayMs() <em>Decay Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecayMs()
	 * @generated
	 * @ordered
	 */
	protected int decayMs = DECAY_MS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoundContinuousImpl()
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
		return ResourcePackage.Literals.SOUND_CONTINUOUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getAttackMs()
	{
		return attackMs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttackMs(int newAttackMs)
	{
		int oldAttackMs = attackMs;
		attackMs = newAttackMs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.SOUND_CONTINUOUS__ATTACK_MS, oldAttackMs, attackMs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDecayMs()
	{
		return decayMs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDecayMs(int newDecayMs)
	{
		int oldDecayMs = decayMs;
		decayMs = newDecayMs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.SOUND_CONTINUOUS__DECAY_MS, oldDecayMs, decayMs));
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
			case ResourcePackage.SOUND_CONTINUOUS__ATTACK_MS:
				return getAttackMs();
			case ResourcePackage.SOUND_CONTINUOUS__DECAY_MS:
				return getDecayMs();
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
			case ResourcePackage.SOUND_CONTINUOUS__ATTACK_MS:
				setAttackMs((Integer)newValue);
				return;
			case ResourcePackage.SOUND_CONTINUOUS__DECAY_MS:
				setDecayMs((Integer)newValue);
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
			case ResourcePackage.SOUND_CONTINUOUS__ATTACK_MS:
				setAttackMs(ATTACK_MS_EDEFAULT);
				return;
			case ResourcePackage.SOUND_CONTINUOUS__DECAY_MS:
				setDecayMs(DECAY_MS_EDEFAULT);
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
			case ResourcePackage.SOUND_CONTINUOUS__ATTACK_MS:
				return attackMs != ATTACK_MS_EDEFAULT;
			case ResourcePackage.SOUND_CONTINUOUS__DECAY_MS:
				return decayMs != DECAY_MS_EDEFAULT;
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
		result.append(" (attackMs: ");
		result.append(attackMs);
		result.append(", decayMs: ");
		result.append(decayMs);
		result.append(')');
		return result.toString();
	}

} //SoundContinuousImpl
