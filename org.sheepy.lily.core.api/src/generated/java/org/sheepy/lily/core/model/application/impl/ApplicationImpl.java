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
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationExtensionPackage;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.core.model.application.TimeConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getEngines <em>Engines</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#isRun <em>Run</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getScene <em>Scene</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getTimeConfiguration <em>Time Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getExtensionPkg <em>Extension Pkg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationImpl extends LilyEObject implements Application
{
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
	 * The cached value of the '{@link #getScene() <em>Scene</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScene()
	 * @generated
	 * @ordered
	 */
	protected Scene scene;

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
	 * The cached value of the '{@link #getExtensionPkg() <em>Extension Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPkg()
	 * @generated
	 * @ordered
	 */
	protected ApplicationExtensionPackage extensionPkg;

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
	public Scene getScene()
	{
		if (scene != null && ((EObject)scene).eIsProxy())
		{
			InternalEObject oldScene = (InternalEObject)scene;
			scene = (Scene)eResolveProxy(oldScene);
			if (scene != oldScene)
			{
				InternalEObject newScene = (InternalEObject)scene;
				NotificationChain msgs = oldScene.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__SCENE, null, null);
				if (newScene.eInternalContainer() == null)
				{
					msgs = newScene.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__SCENE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.APPLICATION__SCENE, oldScene, scene));
			}
		}
		return scene;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scene basicGetScene()
	{
		return scene;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScene(Scene newScene, NotificationChain msgs)
	{
		Scene oldScene = scene;
		scene = newScene;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__SCENE, oldScene, newScene);
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
	public void setScene(Scene newScene)
	{
		if (newScene != scene)
		{
			NotificationChain msgs = null;
			if (scene != null)
				msgs = ((InternalEObject)scene).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__SCENE, null, msgs);
			if (newScene != null)
				msgs = ((InternalEObject)newScene).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__SCENE, null, msgs);
			msgs = basicSetScene(newScene, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__SCENE, newScene, newScene));
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
	public ApplicationExtensionPackage getExtensionPkg()
	{
		if (extensionPkg != null && ((EObject)extensionPkg).eIsProxy())
		{
			InternalEObject oldExtensionPkg = (InternalEObject)extensionPkg;
			extensionPkg = (ApplicationExtensionPackage)eResolveProxy(oldExtensionPkg);
			if (extensionPkg != oldExtensionPkg)
			{
				InternalEObject newExtensionPkg = (InternalEObject)extensionPkg;
				NotificationChain msgs = oldExtensionPkg.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__EXTENSION_PKG, null, null);
				if (newExtensionPkg.eInternalContainer() == null)
				{
					msgs = newExtensionPkg.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__EXTENSION_PKG, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.APPLICATION__EXTENSION_PKG, oldExtensionPkg, extensionPkg));
			}
		}
		return extensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationExtensionPackage basicGetExtensionPkg()
	{
		return extensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionPkg(ApplicationExtensionPackage newExtensionPkg, NotificationChain msgs)
	{
		ApplicationExtensionPackage oldExtensionPkg = extensionPkg;
		extensionPkg = newExtensionPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__EXTENSION_PKG, oldExtensionPkg, newExtensionPkg);
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
	public void setExtensionPkg(ApplicationExtensionPackage newExtensionPkg)
	{
		if (newExtensionPkg != extensionPkg)
		{
			NotificationChain msgs = null;
			if (extensionPkg != null)
				msgs = ((InternalEObject)extensionPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__EXTENSION_PKG, null, msgs);
			if (newExtensionPkg != null)
				msgs = ((InternalEObject)newExtensionPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.APPLICATION__EXTENSION_PKG, null, msgs);
			msgs = basicSetExtensionPkg(newExtensionPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__EXTENSION_PKG, newExtensionPkg, newExtensionPkg));
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
			case ApplicationPackage.APPLICATION__ENGINES:
				return ((InternalEList<?>)getEngines()).basicRemove(otherEnd, msgs);
			case ApplicationPackage.APPLICATION__SCENE:
				return basicSetScene(null, msgs);
			case ApplicationPackage.APPLICATION__TIME_CONFIGURATION:
				return basicSetTimeConfiguration(null, msgs);
			case ApplicationPackage.APPLICATION__EXTENSION_PKG:
				return basicSetExtensionPkg(null, msgs);
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
			case ApplicationPackage.APPLICATION__ENGINES:
				return getEngines();
			case ApplicationPackage.APPLICATION__RUN:
				return isRun();
			case ApplicationPackage.APPLICATION__TITLE:
				return getTitle();
			case ApplicationPackage.APPLICATION__SCENE:
				if (resolve) return getScene();
				return basicGetScene();
			case ApplicationPackage.APPLICATION__TIME_CONFIGURATION:
				if (resolve) return getTimeConfiguration();
				return basicGetTimeConfiguration();
			case ApplicationPackage.APPLICATION__EXTENSION_PKG:
				if (resolve) return getExtensionPkg();
				return basicGetExtensionPkg();
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
			case ApplicationPackage.APPLICATION__ENGINES:
				getEngines().clear();
				getEngines().addAll((Collection<? extends IEngine>)newValue);
				return;
			case ApplicationPackage.APPLICATION__RUN:
				setRun((Boolean)newValue);
				return;
			case ApplicationPackage.APPLICATION__TITLE:
				setTitle((String)newValue);
				return;
			case ApplicationPackage.APPLICATION__SCENE:
				setScene((Scene)newValue);
				return;
			case ApplicationPackage.APPLICATION__TIME_CONFIGURATION:
				setTimeConfiguration((TimeConfiguration)newValue);
				return;
			case ApplicationPackage.APPLICATION__EXTENSION_PKG:
				setExtensionPkg((ApplicationExtensionPackage)newValue);
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
			case ApplicationPackage.APPLICATION__ENGINES:
				getEngines().clear();
				return;
			case ApplicationPackage.APPLICATION__RUN:
				setRun(RUN_EDEFAULT);
				return;
			case ApplicationPackage.APPLICATION__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case ApplicationPackage.APPLICATION__SCENE:
				setScene((Scene)null);
				return;
			case ApplicationPackage.APPLICATION__TIME_CONFIGURATION:
				setTimeConfiguration((TimeConfiguration)null);
				return;
			case ApplicationPackage.APPLICATION__EXTENSION_PKG:
				setExtensionPkg((ApplicationExtensionPackage)null);
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
			case ApplicationPackage.APPLICATION__ENGINES:
				return engines != null && !engines.isEmpty();
			case ApplicationPackage.APPLICATION__RUN:
				return run != RUN_EDEFAULT;
			case ApplicationPackage.APPLICATION__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case ApplicationPackage.APPLICATION__SCENE:
				return scene != null;
			case ApplicationPackage.APPLICATION__TIME_CONFIGURATION:
				return timeConfiguration != null;
			case ApplicationPackage.APPLICATION__EXTENSION_PKG:
				return extensionPkg != null;
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
		result.append(", title: ");
		result.append(title);
		result.append(')');
		return result.toString();
	}

} //ApplicationImpl
