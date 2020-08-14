/**
 */
package org.sheepy.lily.core.model.resource;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.resource.FileImage#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.resource.ResourcePackage#getFileImage()
 * @model
 * @generated
 */
public interface FileImage extends IRootResource, IImage
{
	/**
	 * Returns the value of the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' containment reference.
	 * @see #setFile(FileResource)
	 * @see org.sheepy.lily.core.model.resource.ResourcePackage#getFileImage_File()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	FileResource getFile();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.resource.FileImage#getFile <em>File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' containment reference.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(FileResource value);

} // FileImage
