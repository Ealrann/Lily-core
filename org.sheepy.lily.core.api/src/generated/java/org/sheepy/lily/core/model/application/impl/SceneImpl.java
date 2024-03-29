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
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.core.model.resource.ResourcePkg;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scene</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.SceneImpl#getCompositors <em>Compositors</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.SceneImpl#isFullscreen <em>Fullscreen</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.SceneImpl#isResizeable <em>Resizeable</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.SceneImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.impl.SceneImpl#getResourcePkg <em>Resource Pkg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SceneImpl extends LilyEObject implements Scene
{
	/**
	 * The cached value of the '{@link #getCompositors() <em>Compositors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositors()
	 * @generated
	 * @ordered
	 */
	protected EList<ICompositor> compositors;

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
	 * The cached value of the '{@link #getResourcePkg() <em>Resource Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcePkg()
	 * @generated
	 * @ordered
	 */
	protected ResourcePkg resourcePkg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SceneImpl()
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
		return ApplicationPackage.Literals.SCENE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ICompositor> getCompositors()
	{
		if (compositors == null)
		{
			compositors = new EObjectContainmentEList.Resolving<>(ICompositor.class, this, ApplicationPackage.SCENE__COMPOSITORS);
		}
		return compositors;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCENE__FULLSCREEN, oldFullscreen, fullscreen));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCENE__RESIZEABLE, oldResizeable, resizeable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCENE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourcePkg getResourcePkg()
	{
		if (resourcePkg != null && ((EObject)resourcePkg).eIsProxy())
		{
			InternalEObject oldResourcePkg = resourcePkg;
			resourcePkg = (ResourcePkg)eResolveProxy(oldResourcePkg);
			if (resourcePkg != oldResourcePkg)
			{
				InternalEObject newResourcePkg = resourcePkg;
				NotificationChain msgs = oldResourcePkg.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SCENE__RESOURCE_PKG, null, null);
				if (newResourcePkg.eInternalContainer() == null)
				{
					msgs = newResourcePkg.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SCENE__RESOURCE_PKG, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApplicationPackage.SCENE__RESOURCE_PKG, oldResourcePkg, resourcePkg));
			}
		}
		return resourcePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcePkg basicGetResourcePkg()
	{
		return resourcePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourcePkg(ResourcePkg newResourcePkg, NotificationChain msgs)
	{
		ResourcePkg oldResourcePkg = resourcePkg;
		resourcePkg = newResourcePkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCENE__RESOURCE_PKG, oldResourcePkg, newResourcePkg);
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
	public void setResourcePkg(ResourcePkg newResourcePkg)
	{
		if (newResourcePkg != resourcePkg)
		{
			NotificationChain msgs = null;
			if (resourcePkg != null)
				msgs = ((InternalEObject)resourcePkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SCENE__RESOURCE_PKG, null, msgs);
			if (newResourcePkg != null)
				msgs = ((InternalEObject)newResourcePkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.SCENE__RESOURCE_PKG, null, msgs);
			msgs = basicSetResourcePkg(newResourcePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.SCENE__RESOURCE_PKG, newResourcePkg, newResourcePkg));
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
			case ApplicationPackage.SCENE__COMPOSITORS:
				return ((InternalEList<?>)getCompositors()).basicRemove(otherEnd, msgs);
			case ApplicationPackage.SCENE__RESOURCE_PKG:
				return basicSetResourcePkg(null, msgs);
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
			case ApplicationPackage.SCENE__COMPOSITORS:
				return getCompositors();
			case ApplicationPackage.SCENE__FULLSCREEN:
				return isFullscreen();
			case ApplicationPackage.SCENE__RESIZEABLE:
				return isResizeable();
			case ApplicationPackage.SCENE__SIZE:
				return getSize();
			case ApplicationPackage.SCENE__RESOURCE_PKG:
				if (resolve) return getResourcePkg();
				return basicGetResourcePkg();
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
			case ApplicationPackage.SCENE__COMPOSITORS:
				getCompositors().clear();
				getCompositors().addAll((Collection<? extends ICompositor>)newValue);
				return;
			case ApplicationPackage.SCENE__FULLSCREEN:
				setFullscreen((Boolean)newValue);
				return;
			case ApplicationPackage.SCENE__RESIZEABLE:
				setResizeable((Boolean)newValue);
				return;
			case ApplicationPackage.SCENE__SIZE:
				setSize((Vector2ic)newValue);
				return;
			case ApplicationPackage.SCENE__RESOURCE_PKG:
				setResourcePkg((ResourcePkg)newValue);
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
			case ApplicationPackage.SCENE__COMPOSITORS:
				getCompositors().clear();
				return;
			case ApplicationPackage.SCENE__FULLSCREEN:
				setFullscreen(FULLSCREEN_EDEFAULT);
				return;
			case ApplicationPackage.SCENE__RESIZEABLE:
				setResizeable(RESIZEABLE_EDEFAULT);
				return;
			case ApplicationPackage.SCENE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case ApplicationPackage.SCENE__RESOURCE_PKG:
				setResourcePkg((ResourcePkg)null);
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
			case ApplicationPackage.SCENE__COMPOSITORS:
				return compositors != null && !compositors.isEmpty();
			case ApplicationPackage.SCENE__FULLSCREEN:
				return fullscreen != FULLSCREEN_EDEFAULT;
			case ApplicationPackage.SCENE__RESIZEABLE:
				return resizeable != RESIZEABLE_EDEFAULT;
			case ApplicationPackage.SCENE__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case ApplicationPackage.SCENE__RESOURCE_PKG:
				return resourcePkg != null;
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
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //SceneImpl
