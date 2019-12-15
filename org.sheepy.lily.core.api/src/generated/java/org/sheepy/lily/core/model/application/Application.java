/**
 */
package org.sheepy.lily.core.model.application;

import org.eclipse.emf.common.util.EList;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.Application#getEngines <em>Engines</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Application#isRun <em>Run</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Application#isFullscreen <em>Fullscreen</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Application#isResizeable <em>Resizeable</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Application#isHeadless <em>Headless</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Application#getTitle <em>Title</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Application#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Application#getView <em>View</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Application#getTimeConfiguration <em>Time Configuration</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplication()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface Application extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Engines</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.application.IEngine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engines</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplication_Engines()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IEngine> getEngines();

	/**
	 * Returns the value of the '<em><b>Run</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run</em>' attribute.
	 * @see #setRun(boolean)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplication_Run()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isRun();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Application#isRun <em>Run</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run</em>' attribute.
	 * @see #isRun()
	 * @generated
	 */
	void setRun(boolean value);

	/**
	 * Returns the value of the '<em><b>Fullscreen</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fullscreen</em>' attribute.
	 * @see #setFullscreen(boolean)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplication_Fullscreen()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isFullscreen();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Application#isFullscreen <em>Fullscreen</em>}' attribute.
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
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplication_Resizeable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isResizeable();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Application#isResizeable <em>Resizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resizeable</em>' attribute.
	 * @see #isResizeable()
	 * @generated
	 */
	void setResizeable(boolean value);

	/**
	 * Returns the value of the '<em><b>Headless</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Headless</em>' attribute.
	 * @see #setHeadless(boolean)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplication_Headless()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isHeadless();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Application#isHeadless <em>Headless</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Headless</em>' attribute.
	 * @see #isHeadless()
	 * @generated
	 */
	void setHeadless(boolean value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * The default value is <code>"Vulkan Application"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplication_Title()
	 * @model default="Vulkan Application" unique="false"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Application#getTitle <em>Title</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(Vector2ic)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplication_Size()
	 * @model default="400,400" unique="false" dataType="org.sheepy.lily.core.model.types.Vector2i"
	 * @generated
	 */
	Vector2ic getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Application#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Vector2ic value);

	/**
	 * Returns the value of the '<em><b>View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View</em>' containment reference.
	 * @see #setView(IView)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplication_View()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IView getView();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Application#getView <em>View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View</em>' containment reference.
	 * @see #getView()
	 * @generated
	 */
	void setView(IView value);

	/**
	 * Returns the value of the '<em><b>Time Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Configuration</em>' containment reference.
	 * @see #setTimeConfiguration(TimeConfiguration)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplication_TimeConfiguration()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	TimeConfiguration getTimeConfiguration();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Application#getTimeConfiguration <em>Time Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Configuration</em>' containment reference.
	 * @see #getTimeConfiguration()
	 * @generated
	 */
	void setTimeConfiguration(TimeConfiguration value);

} // Application
