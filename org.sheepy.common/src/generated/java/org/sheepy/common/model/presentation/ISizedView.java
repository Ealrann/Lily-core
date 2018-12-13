/**
 */
package org.sheepy.common.model.presentation;

import org.sheepy.common.model.application.IView;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ISized View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.presentation.ISizedView#isMoveable <em>Moveable</em>}</li>
 *   <li>{@link org.sheepy.common.model.presentation.ISizedView#isCloseable <em>Closeable</em>}</li>
 *   <li>{@link org.sheepy.common.model.presentation.ISizedView#isScalable <em>Scalable</em>}</li>
 *   <li>{@link org.sheepy.common.model.presentation.ISizedView#isShowTitle <em>Show Title</em>}</li>
 *   <li>{@link org.sheepy.common.model.presentation.ISizedView#isFullscreen <em>Fullscreen</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.presentation.PresentationPackage#getISizedView()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ISizedView extends IPresentationElement, IView
{
	/**
	 * Returns the value of the '<em><b>Moveable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moveable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moveable</em>' attribute.
	 * @see #setMoveable(boolean)
	 * @see org.sheepy.common.model.presentation.PresentationPackage#getISizedView_Moveable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isMoveable();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.presentation.ISizedView#isMoveable <em>Moveable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moveable</em>' attribute.
	 * @see #isMoveable()
	 * @generated
	 */
	void setMoveable(boolean value);

	/**
	 * Returns the value of the '<em><b>Closeable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closeable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closeable</em>' attribute.
	 * @see #setCloseable(boolean)
	 * @see org.sheepy.common.model.presentation.PresentationPackage#getISizedView_Closeable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isCloseable();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.presentation.ISizedView#isCloseable <em>Closeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closeable</em>' attribute.
	 * @see #isCloseable()
	 * @generated
	 */
	void setCloseable(boolean value);

	/**
	 * Returns the value of the '<em><b>Scalable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scalable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scalable</em>' attribute.
	 * @see #setScalable(boolean)
	 * @see org.sheepy.common.model.presentation.PresentationPackage#getISizedView_Scalable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isScalable();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.presentation.ISizedView#isScalable <em>Scalable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scalable</em>' attribute.
	 * @see #isScalable()
	 * @generated
	 */
	void setScalable(boolean value);

	/**
	 * Returns the value of the '<em><b>Show Title</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Title</em>' attribute.
	 * @see #setShowTitle(boolean)
	 * @see org.sheepy.common.model.presentation.PresentationPackage#getISizedView_ShowTitle()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isShowTitle();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.presentation.ISizedView#isShowTitle <em>Show Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Title</em>' attribute.
	 * @see #isShowTitle()
	 * @generated
	 */
	void setShowTitle(boolean value);

	/**
	 * Returns the value of the '<em><b>Fullscreen</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fullscreen</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fullscreen</em>' attribute.
	 * @see #setFullscreen(boolean)
	 * @see org.sheepy.common.model.presentation.PresentationPackage#getISizedView_Fullscreen()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isFullscreen();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.presentation.ISizedView#isFullscreen <em>Fullscreen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fullscreen</em>' attribute.
	 * @see #isFullscreen()
	 * @generated
	 */
	void setFullscreen(boolean value);

} // ISizedView
