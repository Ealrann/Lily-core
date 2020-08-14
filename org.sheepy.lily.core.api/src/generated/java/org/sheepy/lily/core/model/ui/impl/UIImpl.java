/**
 */
package org.sheepy.lily.core.model.ui.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.ui.FontPkg;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.core.model.ui.UIPage;
import org.sheepy.lily.core.model.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.UIImpl#getExtensionPkg <em>Extension Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.UIImpl#isImageSupport <em>Image Support</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.UIImpl#getUiPages <em>Ui Pages</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.UIImpl#getCurrentUIPage <em>Current UI Page</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.UIImpl#getFontPkg <em>Font Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.UIImpl#getDstImage <em>Dst Image</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.UIImpl#getImages <em>Images</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UIImpl extends LilyEObject implements UI
{
	/**
	 * The cached value of the '{@link #getExtensionPkg() <em>Extension Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPkg()
	 * @generated
	 * @ordered
	 */
	protected CompositorExtensionPkg extensionPkg;

	/**
	 * The default value of the '{@link #isImageSupport() <em>Image Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImageSupport()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMAGE_SUPPORT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isImageSupport() <em>Image Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImageSupport()
	 * @generated
	 * @ordered
	 */
	protected boolean imageSupport = IMAGE_SUPPORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUiPages() <em>Ui Pages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUiPages()
	 * @generated
	 * @ordered
	 */
	protected EList<UIPage> uiPages;

	/**
	 * The cached value of the '{@link #getCurrentUIPage() <em>Current UI Page</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentUIPage()
	 * @generated
	 * @ordered
	 */
	protected UIPage currentUIPage;

	/**
	 * The cached value of the '{@link #getFontPkg() <em>Font Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontPkg()
	 * @generated
	 * @ordered
	 */
	protected FontPkg fontPkg;

	/**
	 * The cached value of the '{@link #getDstImage() <em>Dst Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstImage()
	 * @generated
	 * @ordered
	 */
	protected IImage dstImage;

	/**
	 * The cached value of the '{@link #getImages() <em>Images</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImages()
	 * @generated
	 * @ordered
	 */
	protected EList<IImage> images;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return UiPackage.Literals.UI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositorExtensionPkg getExtensionPkg()
	{
		if (extensionPkg != null && ((EObject)extensionPkg).eIsProxy())
		{
			InternalEObject oldExtensionPkg = extensionPkg;
			extensionPkg = (CompositorExtensionPkg)eResolveProxy(oldExtensionPkg);
			if (extensionPkg != oldExtensionPkg)
			{
				InternalEObject newExtensionPkg = extensionPkg;
				NotificationChain msgs = oldExtensionPkg.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.UI__EXTENSION_PKG, null, null);
				if (newExtensionPkg.eInternalContainer() == null)
				{
					msgs = newExtensionPkg.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.UI__EXTENSION_PKG, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiPackage.UI__EXTENSION_PKG, oldExtensionPkg, extensionPkg));
			}
		}
		return extensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositorExtensionPkg basicGetExtensionPkg()
	{
		return extensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionPkg(CompositorExtensionPkg newExtensionPkg, NotificationChain msgs)
	{
		CompositorExtensionPkg oldExtensionPkg = extensionPkg;
		extensionPkg = newExtensionPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.UI__EXTENSION_PKG, oldExtensionPkg, newExtensionPkg);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtensionPkg(CompositorExtensionPkg newExtensionPkg)
	{
		if (newExtensionPkg != extensionPkg)
		{
			NotificationChain msgs = null;
			if (extensionPkg != null)
				msgs = ((InternalEObject)extensionPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.UI__EXTENSION_PKG, null, msgs);
			if (newExtensionPkg != null)
				msgs = ((InternalEObject)newExtensionPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.UI__EXTENSION_PKG, null, msgs);
			msgs = basicSetExtensionPkg(newExtensionPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.UI__EXTENSION_PKG, newExtensionPkg, newExtensionPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isImageSupport()
	{
		return imageSupport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageSupport(boolean newImageSupport)
	{
		boolean oldImageSupport = imageSupport;
		imageSupport = newImageSupport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.UI__IMAGE_SUPPORT, oldImageSupport, imageSupport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UIPage> getUiPages()
	{
		if (uiPages == null)
		{
			uiPages = new EObjectContainmentEList.Resolving<UIPage>(UIPage.class, this, UiPackage.UI__UI_PAGES);
		}
		return uiPages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UIPage getCurrentUIPage()
	{
		if (currentUIPage != null && ((EObject)currentUIPage).eIsProxy())
		{
			InternalEObject oldCurrentUIPage = currentUIPage;
			currentUIPage = (UIPage)eResolveProxy(oldCurrentUIPage);
			if (currentUIPage != oldCurrentUIPage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiPackage.UI__CURRENT_UI_PAGE, oldCurrentUIPage, currentUIPage));
			}
		}
		return currentUIPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIPage basicGetCurrentUIPage()
	{
		return currentUIPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentUIPage(UIPage newCurrentUIPage)
	{
		UIPage oldCurrentUIPage = currentUIPage;
		currentUIPage = newCurrentUIPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.UI__CURRENT_UI_PAGE, oldCurrentUIPage, currentUIPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FontPkg getFontPkg()
	{
		if (fontPkg != null && ((EObject)fontPkg).eIsProxy())
		{
			InternalEObject oldFontPkg = fontPkg;
			fontPkg = (FontPkg)eResolveProxy(oldFontPkg);
			if (fontPkg != oldFontPkg)
			{
				InternalEObject newFontPkg = fontPkg;
				NotificationChain msgs = oldFontPkg.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.UI__FONT_PKG, null, null);
				if (newFontPkg.eInternalContainer() == null)
				{
					msgs = newFontPkg.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.UI__FONT_PKG, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiPackage.UI__FONT_PKG, oldFontPkg, fontPkg));
			}
		}
		return fontPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontPkg basicGetFontPkg()
	{
		return fontPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFontPkg(FontPkg newFontPkg, NotificationChain msgs)
	{
		FontPkg oldFontPkg = fontPkg;
		fontPkg = newFontPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.UI__FONT_PKG, oldFontPkg, newFontPkg);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFontPkg(FontPkg newFontPkg)
	{
		if (newFontPkg != fontPkg)
		{
			NotificationChain msgs = null;
			if (fontPkg != null)
				msgs = ((InternalEObject)fontPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.UI__FONT_PKG, null, msgs);
			if (newFontPkg != null)
				msgs = ((InternalEObject)newFontPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.UI__FONT_PKG, null, msgs);
			msgs = basicSetFontPkg(newFontPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.UI__FONT_PKG, newFontPkg, newFontPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IImage getDstImage()
	{
		if (dstImage != null && ((EObject)dstImage).eIsProxy())
		{
			InternalEObject oldDstImage = dstImage;
			dstImage = (IImage)eResolveProxy(oldDstImage);
			if (dstImage != oldDstImage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiPackage.UI__DST_IMAGE, oldDstImage, dstImage));
			}
		}
		return dstImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IImage basicGetDstImage()
	{
		return dstImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstImage(IImage newDstImage)
	{
		IImage oldDstImage = dstImage;
		dstImage = newDstImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.UI__DST_IMAGE, oldDstImage, dstImage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IImage> getImages()
	{
		if (images == null)
		{
			images = new EObjectResolvingEList<IImage>(IImage.class, this, UiPackage.UI__IMAGES);
		}
		return images;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IInferenceObject lInferenceObject()
	{
		return this;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case UiPackage.UI__EXTENSION_PKG:
				return basicSetExtensionPkg(null, msgs);
			case UiPackage.UI__UI_PAGES:
				return ((InternalEList<?>)getUiPages()).basicRemove(otherEnd, msgs);
			case UiPackage.UI__FONT_PKG:
				return basicSetFontPkg(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case UiPackage.UI__EXTENSION_PKG:
				if (resolve) return getExtensionPkg();
				return basicGetExtensionPkg();
			case UiPackage.UI__IMAGE_SUPPORT:
				return isImageSupport();
			case UiPackage.UI__UI_PAGES:
				return getUiPages();
			case UiPackage.UI__CURRENT_UI_PAGE:
				if (resolve) return getCurrentUIPage();
				return basicGetCurrentUIPage();
			case UiPackage.UI__FONT_PKG:
				if (resolve) return getFontPkg();
				return basicGetFontPkg();
			case UiPackage.UI__DST_IMAGE:
				if (resolve) return getDstImage();
				return basicGetDstImage();
			case UiPackage.UI__IMAGES:
				return getImages();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case UiPackage.UI__EXTENSION_PKG:
				setExtensionPkg((CompositorExtensionPkg)newValue);
				return;
			case UiPackage.UI__IMAGE_SUPPORT:
				setImageSupport((Boolean)newValue);
				return;
			case UiPackage.UI__UI_PAGES:
				getUiPages().clear();
				getUiPages().addAll((Collection<? extends UIPage>)newValue);
				return;
			case UiPackage.UI__CURRENT_UI_PAGE:
				setCurrentUIPage((UIPage)newValue);
				return;
			case UiPackage.UI__FONT_PKG:
				setFontPkg((FontPkg)newValue);
				return;
			case UiPackage.UI__DST_IMAGE:
				setDstImage((IImage)newValue);
				return;
			case UiPackage.UI__IMAGES:
				getImages().clear();
				getImages().addAll((Collection<? extends IImage>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case UiPackage.UI__EXTENSION_PKG:
				setExtensionPkg((CompositorExtensionPkg)null);
				return;
			case UiPackage.UI__IMAGE_SUPPORT:
				setImageSupport(IMAGE_SUPPORT_EDEFAULT);
				return;
			case UiPackage.UI__UI_PAGES:
				getUiPages().clear();
				return;
			case UiPackage.UI__CURRENT_UI_PAGE:
				setCurrentUIPage((UIPage)null);
				return;
			case UiPackage.UI__FONT_PKG:
				setFontPkg((FontPkg)null);
				return;
			case UiPackage.UI__DST_IMAGE:
				setDstImage((IImage)null);
				return;
			case UiPackage.UI__IMAGES:
				getImages().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case UiPackage.UI__EXTENSION_PKG:
				return extensionPkg != null;
			case UiPackage.UI__IMAGE_SUPPORT:
				return imageSupport != IMAGE_SUPPORT_EDEFAULT;
			case UiPackage.UI__UI_PAGES:
				return uiPages != null && !uiPages.isEmpty();
			case UiPackage.UI__CURRENT_UI_PAGE:
				return currentUIPage != null;
			case UiPackage.UI__FONT_PKG:
				return fontPkg != null;
			case UiPackage.UI__DST_IMAGE:
				return dstImage != null;
			case UiPackage.UI__IMAGES:
				return images != null && !images.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case UiPackage.UI___LINFERENCE_OBJECT:
				return lInferenceObject();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (imageSupport: ");
		result.append(imageSupport);
		result.append(')');
		return result.toString();
	}

} //UIImpl
