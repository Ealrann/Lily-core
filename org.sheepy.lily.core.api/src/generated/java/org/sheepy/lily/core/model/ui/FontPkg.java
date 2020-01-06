/**
 */
package org.sheepy.lily.core.model.ui;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.FontPkg#getFonts <em>Fonts</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getFontPkg()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface FontPkg extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Fonts</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.ui.Font}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fonts</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getFontPkg_Fonts()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	EList<Font> getFonts();

} // FontPkg
