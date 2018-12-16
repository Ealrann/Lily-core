/**
 */
package org.sheepy.common.model.application.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.common.api.types.SVector2i;

import org.sheepy.common.model.application.Application;
import org.sheepy.common.model.application.ApplicationPackage;
import org.sheepy.common.model.application.IEngine;
import org.sheepy.common.model.application.IView;

import org.sheepy.common.model.root.impl.LObjectImpl;
import org.sheepy.common.model.types.TypesFactory;
import org.sheepy.common.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.application.impl.ApplicationImpl#getViews <em>Views</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.impl.ApplicationImpl#getEngines <em>Engines</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.impl.ApplicationImpl#isFullscreen <em>Fullscreen</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.impl.ApplicationImpl#isResizeable <em>Resizeable</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.impl.ApplicationImpl#isDebug <em>Debug</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.impl.ApplicationImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.impl.ApplicationImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.impl.ApplicationImpl#getCurrentView <em>Current View</em>}</li>
 *   <li>{@link org.sheepy.common.model.application.impl.ApplicationImpl#getCadenceInHz <em>Cadence In Hz</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationImpl extends LObjectImpl implements Application
{
	/**
	 * The cached value of the '{@link #getViews() <em>Views</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViews()
	 * @generated
	 * @ordered
	 */
	protected EList<IView> views;

	/**
	 * The cached value of the '{@link #getEngines() <em>Engines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngines()
	 * @generated
	 * @ordered
	 */
	protected EList<IEngine> engines;

	/**
	 * The default value of the '{@link #isFullscreen() <em>Fullscreen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFullscreen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FULLSCREEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFullscreen() <em>Fullscreen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFullscreen()
	 * @generated
	 * @ordered
	 */
	protected boolean fullscreen = FULLSCREEN_EDEFAULT;

	/**
	 * The default value of the '{@link #isResizeable() <em>Resizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResizeable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESIZEABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResizeable() <em>Resizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResizeable()
	 * @generated
	 * @ordered
	 */
	protected boolean resizeable = RESIZEABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDebug() <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDebug()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEBUG_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDebug() <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDebug()
	 * @generated
	 * @ordered
	 */
	protected boolean debug = DEBUG_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = "Vulkan Application";

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final SVector2i SIZE_EDEFAULT = (SVector2i)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getSVector2i(), "400,400");

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected SVector2i size = SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCurrentView() <em>Current View</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentView()
	 * @generated
	 * @ordered
	 */
	protected IView currentView;

	/**
	 * The default value of the '{@link #getCadenceInHz() <em>Cadence In Hz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCadenceInHz()
	 * @generated
	 * @ordered
	 */
	protected static final int CADENCE_IN_HZ_EDEFAULT = 60;

	/**
	 * The cached value of the '{@link #getCadenceInHz() <em>Cadence In Hz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCadenceInHz()
	 * @generated
	 * @ordered
	 */
	protected int cadenceInHz = CADENCE_IN_HZ_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationImpl()
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
		return ApplicationPackage.Literals.APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IView> getViews()
	{
		if (views == null)
		{
			views = new EObjectContainmentEList.Resolving<IView>(IView.class, this, ApplicationPackage.APPLICATION__VIEWS);
		}
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IEngine> getEngines()
	{
		if (engines == null)
		{
			engines = new EObjectContainmentEList.Resolving<IEngine>(IEngine.class, this, ApplicationPackage.APPLICATION__ENGINES);
		}
		return engines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFullscreen()
	{
		return fullscreen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullscreen(boolean newFullscreen)
	{
		boolean oldFullscreen = fullscreen;
		fullscreen = newFullscreen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__FULLSCREEN, oldFullscreen, fullscreen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResizeable()
	{
		return resizeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResizeable(boolean newResizeable)
	{
		boolean oldResizeable = resizeable;
		resizeable = newResizeable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__RESIZEABLE, oldResizeable, resizeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDebug()
	{
		return debug;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebug(boolean newDebug)
	{
		boolean oldDebug = debug;
		debug = newDebug;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__DEBUG, oldDebug, debug));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle)
	{
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SVector2i getSize()
	{
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(SVector2i newSize)
	{
		SVector2i oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IView getCurrentView()
	{
		if (currentView != null && currentView.eIsProxy())
		{
			InternalEObject oldCurrentView = (InternalEObject)currentView;
			currentView = (IView)eResolveProxy(oldCurrentView);
			if (currentView != oldCurrentView)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.APPLICATION__CURRENT_VIEW, oldCurrentView, currentView));
			}
		}
		return currentView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IView basicGetCurrentView()
	{
		return currentView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentView(IView newCurrentView)
	{
		IView oldCurrentView = currentView;
		currentView = newCurrentView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__CURRENT_VIEW, oldCurrentView, currentView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCadenceInHz()
	{
		return cadenceInHz;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCadenceInHz(int newCadenceInHz)
	{
		int oldCadenceInHz = cadenceInHz;
		cadenceInHz = newCadenceInHz;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__CADENCE_IN_HZ, oldCadenceInHz, cadenceInHz));
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
			case ApplicationPackage.APPLICATION__VIEWS:
				return ((InternalEList<?>)getViews()).basicRemove(otherEnd, msgs);
			case ApplicationPackage.APPLICATION__ENGINES:
				return ((InternalEList<?>)getEngines()).basicRemove(otherEnd, msgs);
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
			case ApplicationPackage.APPLICATION__VIEWS:
				return getViews();
			case ApplicationPackage.APPLICATION__ENGINES:
				return getEngines();
			case ApplicationPackage.APPLICATION__FULLSCREEN:
				return isFullscreen();
			case ApplicationPackage.APPLICATION__RESIZEABLE:
				return isResizeable();
			case ApplicationPackage.APPLICATION__DEBUG:
				return isDebug();
			case ApplicationPackage.APPLICATION__TITLE:
				return getTitle();
			case ApplicationPackage.APPLICATION__SIZE:
				return getSize();
			case ApplicationPackage.APPLICATION__CURRENT_VIEW:
				if (resolve) return getCurrentView();
				return basicGetCurrentView();
			case ApplicationPackage.APPLICATION__CADENCE_IN_HZ:
				return getCadenceInHz();
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
			case ApplicationPackage.APPLICATION__VIEWS:
				getViews().clear();
				getViews().addAll((Collection<? extends IView>)newValue);
				return;
			case ApplicationPackage.APPLICATION__ENGINES:
				getEngines().clear();
				getEngines().addAll((Collection<? extends IEngine>)newValue);
				return;
			case ApplicationPackage.APPLICATION__FULLSCREEN:
				setFullscreen((Boolean)newValue);
				return;
			case ApplicationPackage.APPLICATION__RESIZEABLE:
				setResizeable((Boolean)newValue);
				return;
			case ApplicationPackage.APPLICATION__DEBUG:
				setDebug((Boolean)newValue);
				return;
			case ApplicationPackage.APPLICATION__TITLE:
				setTitle((String)newValue);
				return;
			case ApplicationPackage.APPLICATION__SIZE:
				setSize((SVector2i)newValue);
				return;
			case ApplicationPackage.APPLICATION__CURRENT_VIEW:
				setCurrentView((IView)newValue);
				return;
			case ApplicationPackage.APPLICATION__CADENCE_IN_HZ:
				setCadenceInHz((Integer)newValue);
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
			case ApplicationPackage.APPLICATION__VIEWS:
				getViews().clear();
				return;
			case ApplicationPackage.APPLICATION__ENGINES:
				getEngines().clear();
				return;
			case ApplicationPackage.APPLICATION__FULLSCREEN:
				setFullscreen(FULLSCREEN_EDEFAULT);
				return;
			case ApplicationPackage.APPLICATION__RESIZEABLE:
				setResizeable(RESIZEABLE_EDEFAULT);
				return;
			case ApplicationPackage.APPLICATION__DEBUG:
				setDebug(DEBUG_EDEFAULT);
				return;
			case ApplicationPackage.APPLICATION__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case ApplicationPackage.APPLICATION__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case ApplicationPackage.APPLICATION__CURRENT_VIEW:
				setCurrentView((IView)null);
				return;
			case ApplicationPackage.APPLICATION__CADENCE_IN_HZ:
				setCadenceInHz(CADENCE_IN_HZ_EDEFAULT);
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
			case ApplicationPackage.APPLICATION__VIEWS:
				return views != null && !views.isEmpty();
			case ApplicationPackage.APPLICATION__ENGINES:
				return engines != null && !engines.isEmpty();
			case ApplicationPackage.APPLICATION__FULLSCREEN:
				return fullscreen != FULLSCREEN_EDEFAULT;
			case ApplicationPackage.APPLICATION__RESIZEABLE:
				return resizeable != RESIZEABLE_EDEFAULT;
			case ApplicationPackage.APPLICATION__DEBUG:
				return debug != DEBUG_EDEFAULT;
			case ApplicationPackage.APPLICATION__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case ApplicationPackage.APPLICATION__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case ApplicationPackage.APPLICATION__CURRENT_VIEW:
				return currentView != null;
			case ApplicationPackage.APPLICATION__CADENCE_IN_HZ:
				return cadenceInHz != CADENCE_IN_HZ_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (fullscreen: ");
		result.append(fullscreen);
		result.append(", resizeable: ");
		result.append(resizeable);
		result.append(", debug: ");
		result.append(debug);
		result.append(", title: ");
		result.append(title);
		result.append(", size: ");
		result.append(size);
		result.append(", cadenceInHz: ");
		result.append(cadenceInHz);
		result.append(')');
		return result.toString();
	}

} //ApplicationImpl
