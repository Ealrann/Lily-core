/**
 */
package org.sheepy.lily.core.model.presentation;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Presentations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.presentation.Presentations#getPresentationPkgs <em>Presentation Pkgs</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getPresentations()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface Presentations extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Presentation Pkgs</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.presentation.IPresentationPkg}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presentation Pkgs</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getPresentations_PresentationPkgs()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IPresentationPkg> getPresentationPkgs();

} // Presentations
