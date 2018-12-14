/**
 */
package org.sheepy.common.model.presentation.impl;

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
import org.sheepy.common.model.presentation.IPresentationElement;
import org.sheepy.common.model.presentation.Panel;
import org.sheepy.common.model.presentation.PresentationPackage;
import org.sheepy.common.model.presentation.UIPage;
import org.sheepy.common.model.root.impl.LObjectImpl;
import org.sheepy.common.model.types.TypesFactory;
import org.sheepy.common.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UI Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.presentation.impl.UIPageImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.sheepy.common.model.presentation.impl.UIPageImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.common.model.presentation.impl.UIPageImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.common.model.presentation.impl.UIPageImpl#getPanels <em>Panels</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UIPageImpl extends LObjectImpl implements UIPage
{
	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final SVector2i POSITION_EDEFAULT = (SVector2i)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getSVector2i(), "0;0");
	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected SVector2i position = POSITION_EDEFAULT;
	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;
	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int HEIGHT_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected int height = HEIGHT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getPanels() <em>Panels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPanels()
	 * @generated
	 * @ordered
	 */
	protected EList<Panel> panels;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIPageImpl()
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
		return PresentationPackage.Literals.UI_PAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SVector2i getPosition()
	{
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(SVector2i newPosition)
	{
		SVector2i oldPosition = position;
		position = newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.UI_PAGE__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(int newWidth)
	{
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.UI_PAGE__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(int newHeight)
	{
		int oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.UI_PAGE__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Panel> getPanels()
	{
		if (panels == null)
		{
			panels = new EObjectContainmentEList<Panel>(Panel.class, this, PresentationPackage.UI_PAGE__PANELS);
		}
		return panels;
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
			case PresentationPackage.UI_PAGE__PANELS:
				return ((InternalEList<?>)getPanels()).basicRemove(otherEnd, msgs);
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
			case PresentationPackage.UI_PAGE__POSITION:
				return getPosition();
			case PresentationPackage.UI_PAGE__WIDTH:
				return getWidth();
			case PresentationPackage.UI_PAGE__HEIGHT:
				return getHeight();
			case PresentationPackage.UI_PAGE__PANELS:
				return getPanels();
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
			case PresentationPackage.UI_PAGE__POSITION:
				setPosition((SVector2i)newValue);
				return;
			case PresentationPackage.UI_PAGE__WIDTH:
				setWidth((Integer)newValue);
				return;
			case PresentationPackage.UI_PAGE__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case PresentationPackage.UI_PAGE__PANELS:
				getPanels().clear();
				getPanels().addAll((Collection<? extends Panel>)newValue);
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
			case PresentationPackage.UI_PAGE__POSITION:
				setPosition(POSITION_EDEFAULT);
				return;
			case PresentationPackage.UI_PAGE__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case PresentationPackage.UI_PAGE__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case PresentationPackage.UI_PAGE__PANELS:
				getPanels().clear();
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
			case PresentationPackage.UI_PAGE__POSITION:
				return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
			case PresentationPackage.UI_PAGE__WIDTH:
				return width != WIDTH_EDEFAULT;
			case PresentationPackage.UI_PAGE__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case PresentationPackage.UI_PAGE__PANELS:
				return panels != null && !panels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == IPresentationElement.class)
		{
			switch (derivedFeatureID)
			{
				case PresentationPackage.UI_PAGE__POSITION: return PresentationPackage.IPRESENTATION_ELEMENT__POSITION;
				case PresentationPackage.UI_PAGE__WIDTH: return PresentationPackage.IPRESENTATION_ELEMENT__WIDTH;
				case PresentationPackage.UI_PAGE__HEIGHT: return PresentationPackage.IPRESENTATION_ELEMENT__HEIGHT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == IPresentationElement.class)
		{
			switch (baseFeatureID)
			{
				case PresentationPackage.IPRESENTATION_ELEMENT__POSITION: return PresentationPackage.UI_PAGE__POSITION;
				case PresentationPackage.IPRESENTATION_ELEMENT__WIDTH: return PresentationPackage.UI_PAGE__WIDTH;
				case PresentationPackage.IPRESENTATION_ELEMENT__HEIGHT: return PresentationPackage.UI_PAGE__HEIGHT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (position: ");
		result.append(position);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(')');
		return result.toString();
	}

} //UIPageImpl
