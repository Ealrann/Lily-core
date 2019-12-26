/**
 */
package org.sheepy.lily.core.model.application;

import org.eclipse.emf.common.util.EList;
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
 *   <li>{@link org.sheepy.lily.core.model.application.Application#getTitle <em>Title</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Application#getScene <em>Scene</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Application#getTimeConfiguration <em>Time Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.Application#getExtensionPkg <em>Extension Pkg</em>}</li>
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
	 * Returns the value of the '<em><b>Scene</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scene</em>' containment reference.
	 * @see #setScene(Scene)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplication_Scene()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Scene getScene();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Application#getScene <em>Scene</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scene</em>' containment reference.
	 * @see #getScene()
	 * @generated
	 */
	void setScene(Scene value);

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

	/**
	 * Returns the value of the '<em><b>Extension Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Pkg</em>' containment reference.
	 * @see #setExtensionPkg(ApplicationExtensionPackage)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getApplication_ExtensionPkg()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ApplicationExtensionPackage getExtensionPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.Application#getExtensionPkg <em>Extension Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Pkg</em>' containment reference.
	 * @see #getExtensionPkg()
	 * @generated
	 */
	void setExtensionPkg(ApplicationExtensionPackage value);

} // Application
