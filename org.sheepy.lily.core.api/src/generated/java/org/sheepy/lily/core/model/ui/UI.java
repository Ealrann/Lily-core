/**
 */
package org.sheepy.lily.core.model.ui;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.resource.IImage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.UI#getUiPages <em>Ui Pages</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.UI#getCurrentUIPage <em>Current UI Page</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.UI#getFontPkg <em>Font Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.UI#getDstImage <em>Dst Image</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.UI#getImages <em>Images</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getUI()
 * @model
 * @generated
 */
public interface UI extends ICompositor
{
	/**
	 * Returns the value of the '<em><b>Ui Pages</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.ui.UIPage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ui Pages</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getUI_UiPages()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<UIPage> getUiPages();

	/**
	 * Returns the value of the '<em><b>Current UI Page</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current UI Page</em>' reference.
	 * @see #setCurrentUIPage(UIPage)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getUI_CurrentUIPage()
	 * @model
	 * @generated
	 */
	UIPage getCurrentUIPage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.UI#getCurrentUIPage <em>Current UI Page</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current UI Page</em>' reference.
	 * @see #getCurrentUIPage()
	 * @generated
	 */
	void setCurrentUIPage(UIPage value);

	/**
	 * Returns the value of the '<em><b>Font Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Pkg</em>' containment reference.
	 * @see #setFontPkg(FontPkg)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getUI_FontPkg()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	FontPkg getFontPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.UI#getFontPkg <em>Font Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Pkg</em>' containment reference.
	 * @see #getFontPkg()
	 * @generated
	 */
	void setFontPkg(FontPkg value);

	/**
	 * Returns the value of the '<em><b>Dst Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Image</em>' reference.
	 * @see #setDstImage(IImage)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getUI_DstImage()
	 * @model required="true"
	 * @generated
	 */
	IImage getDstImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.UI#getDstImage <em>Dst Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Image</em>' reference.
	 * @see #getDstImage()
	 * @generated
	 */
	void setDstImage(IImage value);

	/**
	 * Returns the value of the '<em><b>Images</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.resource.IImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Images</em>' reference list.
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getUI_Images()
	 * @model
	 * @generated
	 */
	EList<IImage> getImages();

} // UI
