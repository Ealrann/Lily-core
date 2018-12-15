/**
 */
package org.sheepy.common.model.application;

import org.eclipse.emf.common.util.EList;

import org.sheepy.common.api.types.SVector2i;

import org.sheepy.common.model.root.LObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.application.Application#getViews <em>Views</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.Application#getEngines <em>Engines</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.Application#isFullscreen <em>Fullscreen</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.Application#isResizeable <em>Resizeable</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.Application#isDebug <em>Debug</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.Application#getTitle <em>Title</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.Application#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.Application#getCurrentView <em>Current View</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.application.ApplicationPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends LObject
{
	/**
	 * Returns the value of the '<em><b>Views</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.common.model.application.IView}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' containment reference list.
	 * @see org.sheepy.common.model.application.ApplicationPackage#getApplication_Views()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IView> getViews();

	/**
	 * Returns the value of the '<em><b>Engines</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.common.model.application.IEngine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engines</em>' containment reference list.
	 * @see org.sheepy.common.model.application.ApplicationPackage#getApplication_Engines()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IEngine> getEngines();

	/**
	 * Returns the value of the '<em><b>Fullscreen</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fullscreen</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fullscreen</em>' attribute.
	 * @see #setFullscreen(boolean)
	 * @see org.sheepy.common.model.application.ApplicationPackage#getApplication_Fullscreen()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isFullscreen();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.application.Application#isFullscreen <em>Fullscreen</em>}' attribute.
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
	 * <p>
	 * If the meaning of the '<em>Resizeable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resizeable</em>' attribute.
	 * @see #setResizeable(boolean)
	 * @see org.sheepy.common.model.application.ApplicationPackage#getApplication_Resizeable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isResizeable();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.application.Application#isResizeable <em>Resizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resizeable</em>' attribute.
	 * @see #isResizeable()
	 * @generated
	 */
	void setResizeable(boolean value);

	/**
	 * Returns the value of the '<em><b>Debug</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Debug</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug</em>' attribute.
	 * @see #setDebug(boolean)
	 * @see org.sheepy.common.model.application.ApplicationPackage#getApplication_Debug()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isDebug();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.application.Application#isDebug <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug</em>' attribute.
	 * @see #isDebug()
	 * @generated
	 */
	void setDebug(boolean value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * The default value is <code>"Vulkan Application"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.sheepy.common.model.application.ApplicationPackage#getApplication_Title()
	 * @model default="Vulkan Application" unique="false"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.application.Application#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The default value is <code>"400,400"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(SVector2i)
	 * @see org.sheepy.common.model.application.ApplicationPackage#getApplication_Size()
	 * @model default="400,400" unique="false" dataType="org.sheepy.common.model.types.SVector2i"
	 * @generated
	 */
	SVector2i getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.application.Application#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(SVector2i value);

	/**
	 * Returns the value of the '<em><b>Current View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current View</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current View</em>' reference.
	 * @see #setCurrentView(IView)
	 * @see org.sheepy.common.model.application.ApplicationPackage#getApplication_CurrentView()
	 * @model
	 * @generated
	 */
	IView getCurrentView();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.application.Application#getCurrentView <em>Current View</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current View</em>' reference.
	 * @see #getCurrentView()
	 * @generated
	 */
	void setCurrentView(IView value);

} // Application
