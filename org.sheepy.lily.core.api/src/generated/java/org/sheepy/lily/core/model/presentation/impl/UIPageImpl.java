/**
 */
package org.sheepy.lily.core.model.presentation.impl;

import java.lang.reflect.InvocationTargetException;

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

import org.sheepy.lily.core.api.types.SVector2i;

import org.sheepy.lily.core.api.util.LTreeIterator;

import org.sheepy.lily.core.model.inference.IInferenceObject;

import org.sheepy.lily.core.model.presentation.IPanel;
import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.core.model.presentation.UIPage;

import org.sheepy.lily.core.model.root.LObject;

import org.sheepy.lily.core.model.root.RootPackage.Literals;

import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UI Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.presentation.impl.UIPageImpl#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.presentation.impl.UIPageImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.presentation.impl.UIPageImpl#getVerticalRelative <em>Vertical Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.presentation.impl.UIPageImpl#getHorizontalRelative <em>Horizontal Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.presentation.impl.UIPageImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.presentation.impl.UIPageImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.presentation.impl.UIPageImpl#getPanels <em>Panels</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UIPageImpl extends MinimalEObjectImpl.Container implements UIPage
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
	 * The default value of the '{@link #getVerticalRelative() <em>Vertical Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerticalRelative()
	 * @generated
	 * @ordered
	 */
	protected static final EVerticalRelative VERTICAL_RELATIVE_EDEFAULT = EVerticalRelative.TOP;

	/**
	 * The cached value of the '{@link #getVerticalRelative() <em>Vertical Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerticalRelative()
	 * @generated
	 * @ordered
	 */
	protected EVerticalRelative verticalRelative = VERTICAL_RELATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHorizontalRelative() <em>Horizontal Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHorizontalRelative()
	 * @generated
	 * @ordered
	 */
	protected static final EHorizontalRelative HORIZONTAL_RELATIVE_EDEFAULT = EHorizontalRelative.LEFT;

	/**
	 * The cached value of the '{@link #getHorizontalRelative() <em>Horizontal Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHorizontalRelative()
	 * @generated
	 * @ordered
	 */
	protected EHorizontalRelative horizontalRelative = HORIZONTAL_RELATIVE_EDEFAULT;

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
	protected EList<IPanel> panels;

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
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.UI_PAGE__CONTENT_OBJECTS, oldContentObjects, contentObjects));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SVector2i getPosition()
	{
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public EVerticalRelative getVerticalRelative()
	{
		return verticalRelative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVerticalRelative(EVerticalRelative newVerticalRelative)
	{
		EVerticalRelative oldVerticalRelative = verticalRelative;
		verticalRelative = newVerticalRelative == null ? VERTICAL_RELATIVE_EDEFAULT : newVerticalRelative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.UI_PAGE__VERTICAL_RELATIVE, oldVerticalRelative, verticalRelative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EHorizontalRelative getHorizontalRelative()
	{
		return horizontalRelative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHorizontalRelative(EHorizontalRelative newHorizontalRelative)
	{
		EHorizontalRelative oldHorizontalRelative = horizontalRelative;
		horizontalRelative = newHorizontalRelative == null ? HORIZONTAL_RELATIVE_EDEFAULT : newHorizontalRelative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.UI_PAGE__HORIZONTAL_RELATIVE, oldHorizontalRelative, horizontalRelative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getWidth()
	{
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public int getHeight()
	{
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public EList<IPanel> getPanels()
	{
		if (panels == null)
		{
			panels = new EObjectContainmentEList<IPanel>(IPanel.class, this, PresentationPackage.UI_PAGE__PANELS);
		}
		return panels;
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
			case PresentationPackage.UI_PAGE__CONTENT_OBJECTS:
				return getContentObjects();
			case PresentationPackage.UI_PAGE__POSITION:
				return getPosition();
			case PresentationPackage.UI_PAGE__VERTICAL_RELATIVE:
				return getVerticalRelative();
			case PresentationPackage.UI_PAGE__HORIZONTAL_RELATIVE:
				return getHorizontalRelative();
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
			case PresentationPackage.UI_PAGE__CONTENT_OBJECTS:
				setContentObjects((EList<LObject>)newValue);
				return;
			case PresentationPackage.UI_PAGE__POSITION:
				setPosition((SVector2i)newValue);
				return;
			case PresentationPackage.UI_PAGE__VERTICAL_RELATIVE:
				setVerticalRelative((EVerticalRelative)newValue);
				return;
			case PresentationPackage.UI_PAGE__HORIZONTAL_RELATIVE:
				setHorizontalRelative((EHorizontalRelative)newValue);
				return;
			case PresentationPackage.UI_PAGE__WIDTH:
				setWidth((Integer)newValue);
				return;
			case PresentationPackage.UI_PAGE__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case PresentationPackage.UI_PAGE__PANELS:
				getPanels().clear();
				getPanels().addAll((Collection<? extends IPanel>)newValue);
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
			case PresentationPackage.UI_PAGE__CONTENT_OBJECTS:
				setContentObjects((EList<LObject>)null);
				return;
			case PresentationPackage.UI_PAGE__POSITION:
				setPosition(POSITION_EDEFAULT);
				return;
			case PresentationPackage.UI_PAGE__VERTICAL_RELATIVE:
				setVerticalRelative(VERTICAL_RELATIVE_EDEFAULT);
				return;
			case PresentationPackage.UI_PAGE__HORIZONTAL_RELATIVE:
				setHorizontalRelative(HORIZONTAL_RELATIVE_EDEFAULT);
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
			case PresentationPackage.UI_PAGE__CONTENT_OBJECTS:
				return contentObjects != null;
			case PresentationPackage.UI_PAGE__POSITION:
				return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
			case PresentationPackage.UI_PAGE__VERTICAL_RELATIVE:
				return verticalRelative != VERTICAL_RELATIVE_EDEFAULT;
			case PresentationPackage.UI_PAGE__HORIZONTAL_RELATIVE:
				return horizontalRelative != HORIZONTAL_RELATIVE_EDEFAULT;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case PresentationPackage.UI_PAGE___CREATE_CONTAINMENT_ELIST__ECLASS:
				return createContainmentEList((EClass)arguments.get(0));
			case PresentationPackage.UI_PAGE___LCONTENTS:
				return lContents();
			case PresentationPackage.UI_PAGE___LPARENT:
				return lParent();
			case PresentationPackage.UI_PAGE___LALL_CONTENTS:
				return lAllContents();
			case PresentationPackage.UI_PAGE___LINFERENCE_OBJECT:
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
		result.append(" (contentObjects: ");
		result.append(contentObjects);
		result.append(", position: ");
		result.append(position);
		result.append(", verticalRelative: ");
		result.append(verticalRelative);
		result.append(", horizontalRelative: ");
		result.append(horizontalRelative);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(')');
		return result.toString();
	}

} //UIPageImpl
