/**
 */
package org.sheepy.lily.core.model.resource;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.resource.FileResource#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.resource.ResourcePackage#getFileResource()
 * @model abstract="true"
 * @generated
 */
public interface FileResource extends IRootResource
{
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.sheepy.lily.core.model.resource.ResourcePackage#getFileResource_Path()
	 * @model required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.resource.FileResource#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // FileResource
