/**
 */
package org.sheepy.lily.core.model.application;

import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Screen Effect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.ScreenEffect#getSrcImage <em>Src Image</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.ScreenEffect#getDstImage <em>Dst Image</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.ScreenEffect#getEffect <em>Effect</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getScreenEffect()
 * @model
 * @generated
 */
public interface ScreenEffect extends LNamedElement, ICompositor
{
	/**
	 * Returns the value of the '<em><b>Src Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Image</em>' reference.
	 * @see #setSrcImage(IImage)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getScreenEffect_SrcImage()
	 * @model
	 * @generated
	 */
	IImage getSrcImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.ScreenEffect#getSrcImage <em>Src Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Image</em>' reference.
	 * @see #getSrcImage()
	 * @generated
	 */
	void setSrcImage(IImage value);

	/**
	 * Returns the value of the '<em><b>Dst Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Image</em>' reference.
	 * @see #setDstImage(IImage)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getScreenEffect_DstImage()
	 * @model required="true"
	 * @generated
	 */
	IImage getDstImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.ScreenEffect#getDstImage <em>Dst Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Image</em>' reference.
	 * @see #getDstImage()
	 * @generated
	 */
	void setDstImage(IImage value);

	/**
	 * Returns the value of the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effect</em>' containment reference.
	 * @see #setEffect(SpecialEffect)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getScreenEffect_Effect()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	SpecialEffect getEffect();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.ScreenEffect#getEffect <em>Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effect</em>' containment reference.
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(SpecialEffect value);

} // ScreenEffect
