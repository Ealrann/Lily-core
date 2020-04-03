/**
 */
package org.sheepy.lily.core.model.application;

import org.joml.Vector3ic;
import org.sheepy.lily.core.model.resource.ESampling;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Background Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.BackgroundImage#getClearColor <em>Clear Color</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.BackgroundImage#getSampling <em>Sampling</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.BackgroundImage#getSrcImage <em>Src Image</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.BackgroundImage#getDstImage <em>Dst Image</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getBackgroundImage()
 * @model
 * @generated
 */
public interface BackgroundImage extends LNamedElement, ICompositor
{

	/**
	 * Returns the value of the '<em><b>Clear Color</b></em>' attribute.
	 * The default value is <code>"0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Color</em>' attribute.
	 * @see #setClearColor(Vector3ic)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getBackgroundImage_ClearColor()
	 * @model default="0;0;0" dataType="org.sheepy.lily.core.model.types.Vector3i" required="true"
	 * @generated
	 */
	Vector3ic getClearColor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.BackgroundImage#getClearColor <em>Clear Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Color</em>' attribute.
	 * @see #getClearColor()
	 * @generated
	 */
	void setClearColor(Vector3ic value);

	/**
	 * Returns the value of the '<em><b>Sampling</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.core.model.resource.ESampling}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sampling</em>' attribute.
	 * @see org.sheepy.lily.core.model.resource.ESampling
	 * @see #setSampling(ESampling)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getBackgroundImage_Sampling()
	 * @model required="true"
	 * @generated
	 */
	ESampling getSampling();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.BackgroundImage#getSampling <em>Sampling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sampling</em>' attribute.
	 * @see org.sheepy.lily.core.model.resource.ESampling
	 * @see #getSampling()
	 * @generated
	 */
	void setSampling(ESampling value);

	/**
	 * Returns the value of the '<em><b>Src Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Image</em>' reference.
	 * @see #setSrcImage(IImage)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getBackgroundImage_SrcImage()
	 * @model
	 * @generated
	 */
	IImage getSrcImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.BackgroundImage#getSrcImage <em>Src Image</em>}' reference.
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
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getBackgroundImage_DstImage()
	 * @model required="true"
	 * @generated
	 */
	IImage getDstImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.BackgroundImage#getDstImage <em>Dst Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Image</em>' reference.
	 * @see #getDstImage()
	 * @generated
	 */
	void setDstImage(IImage value);
} // BackgroundImage
