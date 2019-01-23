/**
 */
package org.sheepy.lily.core.model.presentation;

import org.sheepy.lily.core.model.application.IView;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IMusic View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.presentation.IMusicView#getMusicPath <em>Music Path</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getIMusicView()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IMusicView extends IView
{
	/**
	 * Returns the value of the '<em><b>Music Path</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Music Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Music Path</em>' attribute.
	 * @see #setMusicPath(String)
	 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getIMusicView_MusicPath()
	 * @model default="" unique="false"
	 * @generated
	 */
	String getMusicPath();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.presentation.IMusicView#getMusicPath <em>Music Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Music Path</em>' attribute.
	 * @see #getMusicPath()
	 * @generated
	 */
	void setMusicPath(String value);

} // IMusicView
