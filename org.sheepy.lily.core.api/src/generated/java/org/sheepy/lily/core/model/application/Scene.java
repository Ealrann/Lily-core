/**
 */
package org.sheepy.lily.core.model.application;

import org.eclipse.emf.common.util.EList;

import org.joml.Vector2ic;

import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scene</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.Scene#getCompositors <em>Compositors</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Scene#isFullscreen <em>Fullscreen</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Scene#isResizeable <em>Resizeable</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Scene#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getScene()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface Scene extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Compositors</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.application.ICompositor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compositors</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getScene_Compositors()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ICompositor> getCompositors();

	/**
	 * Returns the value of the '<em><b>Fullscreen</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fullscreen</em>' attribute.
	 * @see #setFullscreen(boolean)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getScene_Fullscreen()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isFullscreen();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Scene#isFullscreen <em>Fullscreen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fullscreen</em>' attribute.
	 * @see #isFullscreen()
	 * @generated
	 */
	void setFullscreen(boolean value);

	/**
	 * Returns the value of the '<em><b>Resizeable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resizeable</em>' attribute.
	 * @see #setResizeable(boolean)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getScene_Resizeable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isResizeable();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Scene#isResizeable <em>Resizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resizeable</em>' attribute.
	 * @see #isResizeable()
	 * @generated
	 */
	void setResizeable(boolean value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The default value is <code>"400,400"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(Vector2ic)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getScene_Size()
	 * @model default="400,400" unique="false" dataType="org.sheepy.lily.core.model.types.Vector2i"
	 * @generated
	 */
	Vector2ic getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Scene#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Vector2ic value);

} // Scene
