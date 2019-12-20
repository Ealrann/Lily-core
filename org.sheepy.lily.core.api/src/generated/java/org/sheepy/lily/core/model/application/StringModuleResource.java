/**
 */
package org.sheepy.lily.core.model.application;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Module Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.StringModuleResource#getModuleName <em>Module Name</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getStringModuleResource()
 * @model
 * @generated
 */
public interface StringModuleResource extends AbstractModuleResource
{
	/**
	 * Returns the value of the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Name</em>' attribute.
	 * @see #setModuleName(String)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getStringModuleResource_ModuleName()
	 * @model required="true"
	 * @generated
	 */
	String getModuleName();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.StringModuleResource#getModuleName <em>Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module Name</em>' attribute.
	 * @see #getModuleName()
	 * @generated
	 */
	void setModuleName(String value);

} // StringModuleResource
