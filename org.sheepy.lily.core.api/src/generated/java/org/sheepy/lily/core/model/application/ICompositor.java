/**
 */
package org.sheepy.lily.core.model.application;

import org.sheepy.lily.core.model.inference.IInferenceObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ICompositor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.ICompositor#getExtensionPkg <em>Extension Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.ICompositor#isEnabled <em>Enabled</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getICompositor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ICompositor extends IInferenceObject
{

	/**
	 * Returns the value of the '<em><b>Extension Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Pkg</em>' containment reference.
	 * @see #setExtensionPkg(CompositorExtensionPkg)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getICompositor_ExtensionPkg()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	CompositorExtensionPkg getExtensionPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.ICompositor#getExtensionPkg <em>Extension Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Pkg</em>' containment reference.
	 * @see #getExtensionPkg()
	 * @generated
	 */
	void setExtensionPkg(CompositorExtensionPkg value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getICompositor_Enabled()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.ICompositor#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);
} // ICompositor
