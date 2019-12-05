/**
 */
package org.sheepy.lily.core.model.application.impl;

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

import org.joml.Vector2ic;

import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.application.IView;
import org.sheepy.lily.core.model.application.TimeConfiguration;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getViews <em>Views</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getEngines <em>Engines</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#isRun <em>Run</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#isFullscreen <em>Fullscreen</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#isResizeable <em>Resizeable</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#isHeadless <em>Headless</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getCurrentView <em>Current View</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getCadence <em>Cadence</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getTimeConfiguration <em>Time Configuration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationImpl extends LilyEObject implements Application
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
	 * The default value of the '{@link #isRun() <em>Run</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRun()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RUN_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRun() <em>Run</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRun()
	 * @generated
	 * @ordered
	 */
	protected boolean run = RUN_EDEFAULT;

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
	 * The default value of the '{@link #isHeadless() <em>Headless</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHeadless()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HEADLESS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHeadless() <em>Headless</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHeadless()
	 * @generated
	 * @ordered
	 */
	protected boolean headless = HEADLESS_EDEFAULT;

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
	protected static final Vector2ic SIZE_EDEFAULT = (Vector2ic)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector2i(), "400,400");

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected Vector2ic size = SIZE_EDEFAULT;

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
	 * The cached value of the '{@link #getCadence() <em>Cadence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCadence()
	 * @generated
	 * @ordered
	 */
	protected ICadence cadence;

	/**
	 * The cached value of the '{@link #getTimeConfiguration() <em>Time Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeConfiguration()
	 * @generated
	 * @ordered
	 */
	protected TimeConfiguration timeConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationImpl()
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
	@Override
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
	@Override
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
	@Override
	public boolean isRun()
	{
		return run;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRun(boolean newRun)
	{
		boolean oldRun = run;
		run = newRun;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__RUN, oldRun, run));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFullscreen()
	{
		return fullscreen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public boolean isResizeable()
	{
		return resizeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public boolean isHeadless()
	{
		return headless;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeadless(boolean newHeadless)
	{
		boolean oldHeadless = headless;
		headless = newHeadless;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__HEADLESS, oldHeadless, headless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTitle()
	{
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public Vector2ic getSize()
	{
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(Vector2ic newSize)
	{
		Vector2ic oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IView getCurrentView()
	{
		if (currentView != null && ((EObject)currentView).eIsProxy())
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
	@Override
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
	@Override
	public ICadence getCadence()
	{
		if (cadence != null && ((EObject)cadence).eIsProxy())
		{
			InternalEObject oldCadence = (InternalEObject)cadence;
			cadence = (ICadence)eResolveProxy(oldCadence);
			if (cadence != oldCadence)
			{
				InternalEObject newCadence = (InternalEObject)cadence;
				NotificationChain msgs = oldCadence.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__CADENCE, null, null);
				if (newCadence.eInternalContainer() == null)
				{
					msgs = newCadence.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__CADENCE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.APPLICATION__CADENCE, oldCadence, cadence));
			}
		}
		return cadence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICadence basicGetCadence()
	{
		return cadence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCadence(ICadence newCadence, NotificationChain msgs)
	{
		ICadence oldCadence = cadence;
		cadence = newCadence;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__CADENCE, oldCadence, newCadence);
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
	public void setCadence(ICadence newCadence)
	{
		if (newCadence != cadence)
		{
			NotificationChain msgs = null;
			if (cadence != null)
				msgs = ((InternalEObject)cadence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__CADENCE, null, msgs);
			if (newCadence != null)
				msgs = ((InternalEObject)newCadence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__CADENCE, null, msgs);
			msgs = basicSetCadence(newCadence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__CADENCE, newCadence, newCadence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TimeConfiguration getTimeConfiguration()
	{
		if (timeConfiguration != null && ((EObject)timeConfiguration).eIsProxy())
		{
			InternalEObject oldTimeConfiguration = (InternalEObject)timeConfiguration;
			timeConfiguration = (TimeConfiguration)eResolveProxy(oldTimeConfiguration);
			if (timeConfiguration != oldTimeConfiguration)
			{
				InternalEObject newTimeConfiguration = (InternalEObject)timeConfiguration;
				NotificationChain msgs = oldTimeConfiguration.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__TIME_CONFIGURATION, null, null);
				if (newTimeConfiguration.eInternalContainer() == null)
				{
					msgs = newTimeConfiguration.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__TIME_CONFIGURATION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.APPLICATION__TIME_CONFIGURATION, oldTimeConfiguration, timeConfiguration));
			}
		}
		return timeConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeConfiguration basicGetTimeConfiguration()
	{
		return timeConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeConfiguration(TimeConfiguration newTimeConfiguration, NotificationChain msgs)
	{
		TimeConfiguration oldTimeConfiguration = timeConfiguration;
		timeConfiguration = newTimeConfiguration;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__TIME_CONFIGURATION, oldTimeConfiguration, newTimeConfiguration);
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
	public void setTimeConfiguration(TimeConfiguration newTimeConfiguration)
	{
		if (newTimeConfiguration != timeConfiguration)
		{
			NotificationChain msgs = null;
			if (timeConfiguration != null)
				msgs = ((InternalEObject)timeConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__TIME_CONFIGURATION, null, msgs);
			if (newTimeConfiguration != null)
				msgs = ((InternalEObject)newTimeConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__TIME_CONFIGURATION, null, msgs);
			msgs = basicSetTimeConfiguration(newTimeConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__TIME_CONFIGURATION, newTimeConfiguration, newTimeConfiguration));
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
			case ApplicationPackage.APPLICATION__CADENCE:
				return basicSetCadence(null, msgs);
			case ApplicationPackage.APPLICATION__TIME_CONFIGURATION:
				return basicSetTimeConfiguration(null, msgs);
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
			case ApplicationPackage.APPLICATION__RUN:
				return isRun();
			case ApplicationPackage.APPLICATION__FULLSCREEN:
				return isFullscreen();
			case ApplicationPackage.APPLICATION__RESIZEABLE:
				return isResizeable();
			case ApplicationPackage.APPLICATION__HEADLESS:
				return isHeadless();
			case ApplicationPackage.APPLICATION__TITLE:
				return getTitle();
			case ApplicationPackage.APPLICATION__SIZE:
				return getSize();
			case ApplicationPackage.APPLICATION__CURRENT_VIEW:
				if (resolve) return getCurrentView();
				return basicGetCurrentView();
			case ApplicationPackage.APPLICATION__CADENCE:
				if (resolve) return getCadence();
				return basicGetCadence();
			case ApplicationPackage.APPLICATION__TIME_CONFIGURATION:
				if (resolve) return getTimeConfiguration();
				return basicGetTimeConfiguration();
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
			case ApplicationPackage.APPLICATION__RUN:
				setRun((Boolean)newValue);
				return;
			case ApplicationPackage.APPLICATION__FULLSCREEN:
				setFullscreen((Boolean)newValue);
				return;
			case ApplicationPackage.APPLICATION__RESIZEABLE:
				setResizeable((Boolean)newValue);
				return;
			case ApplicationPackage.APPLICATION__HEADLESS:
				setHeadless((Boolean)newValue);
				return;
			case ApplicationPackage.APPLICATION__TITLE:
				setTitle((String)newValue);
				return;
			case ApplicationPackage.APPLICATION__SIZE:
				setSize((Vector2ic)newValue);
				return;
			case ApplicationPackage.APPLICATION__CURRENT_VIEW:
				setCurrentView((IView)newValue);
				return;
			case ApplicationPackage.APPLICATION__CADENCE:
				setCadence((ICadence)newValue);
				return;
			case ApplicationPackage.APPLICATION__TIME_CONFIGURATION:
				setTimeConfiguration((TimeConfiguration)newValue);
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
			case ApplicationPackage.APPLICATION__RUN:
				setRun(RUN_EDEFAULT);
				return;
			case ApplicationPackage.APPLICATION__FULLSCREEN:
				setFullscreen(FULLSCREEN_EDEFAULT);
				return;
			case ApplicationPackage.APPLICATION__RESIZEABLE:
				setResizeable(RESIZEABLE_EDEFAULT);
				return;
			case ApplicationPackage.APPLICATION__HEADLESS:
				setHeadless(HEADLESS_EDEFAULT);
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
			case ApplicationPackage.APPLICATION__CADENCE:
				setCadence((ICadence)null);
				return;
			case ApplicationPackage.APPLICATION__TIME_CONFIGURATION:
				setTimeConfiguration((TimeConfiguration)null);
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
			case ApplicationPackage.APPLICATION__RUN:
				return run != RUN_EDEFAULT;
			case ApplicationPackage.APPLICATION__FULLSCREEN:
				return fullscreen != FULLSCREEN_EDEFAULT;
			case ApplicationPackage.APPLICATION__RESIZEABLE:
				return resizeable != RESIZEABLE_EDEFAULT;
			case ApplicationPackage.APPLICATION__HEADLESS:
				return headless != HEADLESS_EDEFAULT;
			case ApplicationPackage.APPLICATION__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case ApplicationPackage.APPLICATION__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case ApplicationPackage.APPLICATION__CURRENT_VIEW:
				return currentView != null;
			case ApplicationPackage.APPLICATION__CADENCE:
				return cadence != null;
			case ApplicationPackage.APPLICATION__TIME_CONFIGURATION:
				return timeConfiguration != null;
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
		result.append(" (run: ");
		result.append(run);
		result.append(", fullscreen: ");
		result.append(fullscreen);
		result.append(", resizeable: ");
		result.append(resizeable);
		result.append(", headless: ");
		result.append(headless);
		result.append(", title: ");
		result.append(title);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //ApplicationImpl
