/**
 */
package org.sheepy.lily.core.model.presentation.impl;

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
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.core.model.presentation.TranparentUIView;
import org.sheepy.lily.core.model.presentation.UIPage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tranparent UI View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.presentation.impl.TranparentUIViewImpl#getUiPages <em>Ui Pages</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.presentation.impl.TranparentUIViewImpl#getCurrentUIPage <em>Current UI Page</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TranparentUIViewImpl extends LilyEObject implements TranparentUIView
{
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TranparentUIViewImpl()
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
		return PresentationPackage.Literals.TRANPARENT_UI_VIEW;
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
			uiPages = new EObjectContainmentEList<UIPage>(UIPage.class, this, PresentationPackage.TRANPARENT_UI_VIEW__UI_PAGES);
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
			InternalEObject oldCurrentUIPage = (InternalEObject)currentUIPage;
			currentUIPage = (UIPage)eResolveProxy(oldCurrentUIPage);
			if (currentUIPage != oldCurrentUIPage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PresentationPackage.TRANPARENT_UI_VIEW__CURRENT_UI_PAGE, oldCurrentUIPage, currentUIPage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.TRANPARENT_UI_VIEW__CURRENT_UI_PAGE, oldCurrentUIPage, currentUIPage));
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
			case PresentationPackage.TRANPARENT_UI_VIEW__UI_PAGES:
				return ((InternalEList<?>)getUiPages()).basicRemove(otherEnd, msgs);
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
			case PresentationPackage.TRANPARENT_UI_VIEW__UI_PAGES:
				return getUiPages();
			case PresentationPackage.TRANPARENT_UI_VIEW__CURRENT_UI_PAGE:
				if (resolve) return getCurrentUIPage();
				return basicGetCurrentUIPage();
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
			case PresentationPackage.TRANPARENT_UI_VIEW__UI_PAGES:
				getUiPages().clear();
				getUiPages().addAll((Collection<? extends UIPage>)newValue);
				return;
			case PresentationPackage.TRANPARENT_UI_VIEW__CURRENT_UI_PAGE:
				setCurrentUIPage((UIPage)newValue);
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
			case PresentationPackage.TRANPARENT_UI_VIEW__UI_PAGES:
				getUiPages().clear();
				return;
			case PresentationPackage.TRANPARENT_UI_VIEW__CURRENT_UI_PAGE:
				setCurrentUIPage((UIPage)null);
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
			case PresentationPackage.TRANPARENT_UI_VIEW__UI_PAGES:
				return uiPages != null && !uiPages.isEmpty();
			case PresentationPackage.TRANPARENT_UI_VIEW__CURRENT_UI_PAGE:
				return currentUIPage != null;
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
			case PresentationPackage.TRANPARENT_UI_VIEW___LINFERENCE_OBJECT:
				return lInferenceObject();
		}
		return super.eInvoke(operationID, arguments);
	}

} //TranparentUIViewImpl
