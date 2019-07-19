/**
 */
package org.sheepy.lily.core.model.application.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.joml.Vector2ic;

import org.sheepy.lily.core.api.util.LTreeIterator;

import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.application.IView;

import org.sheepy.lily.core.model.inference.IInferenceObject;

import org.sheepy.lily.core.model.root.LObject;

import org.sheepy.lily.core.model.root.RootPackage.Literals;

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
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getViews <em>Views</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getEngines <em>Engines</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#isRun <em>Run</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#isFullscreen <em>Fullscreen</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#isResizeable <em>Resizeable</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#isHeadless <em>Headless</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getCurrentView <em>Current View</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.ApplicationImpl#getCadenceInHz <em>Cadence In Hz</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationImpl extends MinimalEObjectImpl.Container implements Application
{
	/**
	 * The cached value of the '{@link #getContentObjects() <em>Content Objects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<LObject> contentObjects;

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
	public EList<LObject> getContentObjects()
	{
		return contentObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContentObjects(EList<LObject> newContentObjects)
	{
		EList<LObject> oldContentObjects = contentObjects;
		contentObjects = newContentObjects;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__CONTENT_OBJECTS, oldContentObjects, contentObjects));
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
			views = new EObjectContainmentEList<IView>(IView.class, this, ApplicationPackage.APPLICATION__VIEWS);
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
			engines = new EObjectContainmentEList<IEngine>(IEngine.class, this, ApplicationPackage.APPLICATION__ENGINES);
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
	public int getCadenceInHz()
	{
		return cadenceInHz;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	public <T extends LObject> EList<T> createContainmentEList(final EClass targetEClass)
	{
		EList<T> res = null;
		final List<EStructuralFeature> unitRefs = new ArrayList<EStructuralFeature>();
		EList<EReference> _eAllContainments = this.eClass().getEAllContainments();
		for (final EReference ref : _eAllContainments)
		{
			EClassifier _eType = ref.getEType();
			boolean _isSuperTypeOf = targetEClass.isSuperTypeOf(((EClass) _eType));
			if (_isSuperTypeOf)
			{
				unitRefs.add(ref);
			}
		}
		boolean _isEmpty = unitRefs.isEmpty();
		if (_isEmpty)
		{
			res = ECollections.<T>emptyEList();
		}
		else
		{
			EContentsEList<T> _eContentsEList = new EContentsEList<T>(this, unitRefs);
			res = _eContentsEList;
		}
		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LObject> lContents()
	{
		EList<LObject> _xblockexpression = null;
		{
			EList<LObject> _contentObjects = this.getContentObjects();
			boolean _tripleEquals = (_contentObjects == null);
			if (_tripleEquals)
			{
				this.setContentObjects(this.<LObject>createContainmentEList(Literals.LOBJECT));
			}
			_xblockexpression = this.getContentObjects();
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LObject lParent()
	{
		LObject _xifexpression = null;
		EObject _eContainer = this.eContainer();
		if ((_eContainer instanceof LObject))
		{
			EObject _eContainer_1 = this.eContainer();
			_xifexpression = ((LObject) _eContainer_1);
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LTreeIterator lAllContents()
	{
		return new LTreeIterator(this);
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
			case ApplicationPackage.APPLICATION__CONTENT_OBJECTS:
				return getContentObjects();
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
			case ApplicationPackage.APPLICATION__CONTENT_OBJECTS:
				setContentObjects((EList<LObject>)newValue);
				return;
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
			case ApplicationPackage.APPLICATION__CONTENT_OBJECTS:
				setContentObjects((EList<LObject>)null);
				return;
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
			case ApplicationPackage.APPLICATION__CONTENT_OBJECTS:
				return contentObjects != null;
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
		result.append(" (contentObjects: ");
		result.append(contentObjects);
		result.append(", run: ");
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
		result.append(", cadenceInHz: ");
		result.append(cadenceInHz);
		result.append(')');
		return result.toString();
	}

} //ApplicationImpl
