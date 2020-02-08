/**
 */
package org.sheepy.lily.core.model.resource;

import org.sheepy.lily.core.model.application.IResource;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sound Continuous</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.resource.SoundContinuous#getAttackMs <em>Attack Ms</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.resource.SoundContinuous#getDecayMs <em>Decay Ms</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.resource.ResourcePackage#getSoundContinuous()
 * @model
 * @generated
 */
public interface SoundContinuous extends Sound, IResource
{
	/**
	 * Returns the value of the '<em><b>Attack Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attack Ms</em>' attribute.
	 * @see #setAttackMs(int)
	 * @see org.sheepy.lily.core.model.resource.ResourcePackage#getSoundContinuous_AttackMs()
	 * @model required="true"
	 * @generated
	 */
	int getAttackMs();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.resource.SoundContinuous#getAttackMs <em>Attack Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attack Ms</em>' attribute.
	 * @see #getAttackMs()
	 * @generated
	 */
	void setAttackMs(int value);

	/**
	 * Returns the value of the '<em><b>Decay Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decay Ms</em>' attribute.
	 * @see #setDecayMs(int)
	 * @see org.sheepy.lily.core.model.resource.ResourcePackage#getSoundContinuous_DecayMs()
	 * @model required="true"
	 * @generated
	 */
	int getDecayMs();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.resource.SoundContinuous#getDecayMs <em>Decay Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decay Ms</em>' attribute.
	 * @see #getDecayMs()
	 * @generated
	 */
	void setDecayMs(int value);

} // SoundContinuous
