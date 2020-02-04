/**
 */
package org.sheepy.lily.core.model.resource;

import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.core.model.application.IResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.resource.Sound#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.resource.ResourcePackage#getSound()
 * @model
 * @generated
 */
public interface Sound extends IResource
{
	/**
	 * Returns the value of the '<em><b>File</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' reference.
	 * @see #setFile(FileResource)
	 * @see org.sheepy.lily.core.model.resource.ResourcePackage#getSound_File()
	 * @model required="true"
	 * @generated
	 */
	FileResource getFile();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.resource.Sound#getFile <em>File</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' reference.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(FileResource value);

} // Sound
