/**
 */
package org.sheepy.lily.core.model.application;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.ModuleResource#getModule <em>Module</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getModuleResource()
 * @model
 * @generated
 */
public interface ModuleResource extends AbstractModuleResource
{
	/**
	 * Returns the value of the '<em><b>Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' attribute.
	 * @see #setModule(Module)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getModuleResource_Module()
	 * @model dataType="org.sheepy.lily.core.model.types.JavaModule" required="true"
	 * @generated
	 */
	Module getModule();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.ModuleResource#getModule <em>Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' attribute.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(Module value);

} // ModuleResource
