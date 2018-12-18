/**
 */
package org.sheepy.common.model.ui.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EContentsEList;

import org.sheepy.common.api.types.SVector2i;

import org.sheepy.common.api.util.LTreeIterator;

import org.sheepy.common.model.inference.IInferenceObject;

import org.sheepy.common.model.presentation.IRelativeElement;
import org.sheepy.common.model.presentation.ISizedElement;
import org.sheepy.common.model.presentation.PresentationPackage;

import org.sheepy.common.model.root.LObject;

import org.sheepy.common.model.root.RootPackage.Literals;

import org.sheepy.common.model.types.EHorizontalRelative;
import org.sheepy.common.model.types.EVerticalRelative;
import org.sheepy.common.model.types.TypesFactory;
import org.sheepy.common.model.types.TypesPackage;

import org.sheepy.common.model.ui.AbstractLabel;
import org.sheepy.common.model.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.ui.impl.AbstractLabelImpl#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.impl.AbstractLabelImpl#getVerticalRelative <em>Vertical Relative</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.impl.AbstractLabelImpl#getHorizontalRelative <em>Horizontal Relative</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.impl.AbstractLabelImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.impl.AbstractLabelImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.impl.AbstractLabelImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.impl.AbstractLabelImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.impl.AbstractLabelImpl#getFontScale <em>Font Scale</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractLabelImpl extends MinimalEObjectImpl.Container implements AbstractLabel
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
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFontScale() <em>Font Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontScale()
	 * @generated
	 * @ordered
	 */
	protected static final float FONT_SCALE_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getFontScale() <em>Font Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontScale()
	 * @generated
	 * @ordered
	 */
	protected float fontScale = FONT_SCALE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractLabelImpl()
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
		return UiPackage.Literals.ABSTRACT_LABEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.ABSTRACT_LABEL__CONTENT_OBJECTS, oldContentObjects, contentObjects));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.ABSTRACT_LABEL__VERTICAL_RELATIVE, oldVerticalRelative, verticalRelative));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.ABSTRACT_LABEL__HORIZONTAL_RELATIVE, oldHorizontalRelative, horizontalRelative));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.ABSTRACT_LABEL__POSITION, oldPosition, position));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.ABSTRACT_LABEL__WIDTH, oldWidth, width));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.ABSTRACT_LABEL__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText()
	{
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setText(String newText)
	{
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.ABSTRACT_LABEL__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getFontScale()
	{
		return fontScale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFontScale(float newFontScale)
	{
		float oldFontScale = fontScale;
		fontScale = newFontScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.ABSTRACT_LABEL__FONT_SCALE, oldFontScale, fontScale));
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
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case UiPackage.ABSTRACT_LABEL__CONTENT_OBJECTS:
				return getContentObjects();
			case UiPackage.ABSTRACT_LABEL__VERTICAL_RELATIVE:
				return getVerticalRelative();
			case UiPackage.ABSTRACT_LABEL__HORIZONTAL_RELATIVE:
				return getHorizontalRelative();
			case UiPackage.ABSTRACT_LABEL__POSITION:
				return getPosition();
			case UiPackage.ABSTRACT_LABEL__WIDTH:
				return getWidth();
			case UiPackage.ABSTRACT_LABEL__HEIGHT:
				return getHeight();
			case UiPackage.ABSTRACT_LABEL__TEXT:
				return getText();
			case UiPackage.ABSTRACT_LABEL__FONT_SCALE:
				return getFontScale();
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
			case UiPackage.ABSTRACT_LABEL__CONTENT_OBJECTS:
				setContentObjects((EList<LObject>)newValue);
				return;
			case UiPackage.ABSTRACT_LABEL__VERTICAL_RELATIVE:
				setVerticalRelative((EVerticalRelative)newValue);
				return;
			case UiPackage.ABSTRACT_LABEL__HORIZONTAL_RELATIVE:
				setHorizontalRelative((EHorizontalRelative)newValue);
				return;
			case UiPackage.ABSTRACT_LABEL__POSITION:
				setPosition((SVector2i)newValue);
				return;
			case UiPackage.ABSTRACT_LABEL__WIDTH:
				setWidth((Integer)newValue);
				return;
			case UiPackage.ABSTRACT_LABEL__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case UiPackage.ABSTRACT_LABEL__TEXT:
				setText((String)newValue);
				return;
			case UiPackage.ABSTRACT_LABEL__FONT_SCALE:
				setFontScale((Float)newValue);
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
			case UiPackage.ABSTRACT_LABEL__CONTENT_OBJECTS:
				setContentObjects((EList<LObject>)null);
				return;
			case UiPackage.ABSTRACT_LABEL__VERTICAL_RELATIVE:
				setVerticalRelative(VERTICAL_RELATIVE_EDEFAULT);
				return;
			case UiPackage.ABSTRACT_LABEL__HORIZONTAL_RELATIVE:
				setHorizontalRelative(HORIZONTAL_RELATIVE_EDEFAULT);
				return;
			case UiPackage.ABSTRACT_LABEL__POSITION:
				setPosition(POSITION_EDEFAULT);
				return;
			case UiPackage.ABSTRACT_LABEL__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case UiPackage.ABSTRACT_LABEL__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case UiPackage.ABSTRACT_LABEL__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case UiPackage.ABSTRACT_LABEL__FONT_SCALE:
				setFontScale(FONT_SCALE_EDEFAULT);
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
			case UiPackage.ABSTRACT_LABEL__CONTENT_OBJECTS:
				return contentObjects != null;
			case UiPackage.ABSTRACT_LABEL__VERTICAL_RELATIVE:
				return verticalRelative != VERTICAL_RELATIVE_EDEFAULT;
			case UiPackage.ABSTRACT_LABEL__HORIZONTAL_RELATIVE:
				return horizontalRelative != HORIZONTAL_RELATIVE_EDEFAULT;
			case UiPackage.ABSTRACT_LABEL__POSITION:
				return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
			case UiPackage.ABSTRACT_LABEL__WIDTH:
				return width != WIDTH_EDEFAULT;
			case UiPackage.ABSTRACT_LABEL__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case UiPackage.ABSTRACT_LABEL__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case UiPackage.ABSTRACT_LABEL__FONT_SCALE:
				return fontScale != FONT_SCALE_EDEFAULT;
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
		if (baseClass == IRelativeElement.class)
		{
			switch (derivedFeatureID)
			{
				case UiPackage.ABSTRACT_LABEL__VERTICAL_RELATIVE: return PresentationPackage.IRELATIVE_ELEMENT__VERTICAL_RELATIVE;
				case UiPackage.ABSTRACT_LABEL__HORIZONTAL_RELATIVE: return PresentationPackage.IRELATIVE_ELEMENT__HORIZONTAL_RELATIVE;
				default: return -1;
			}
		}
		if (baseClass == ISizedElement.class)
		{
			switch (derivedFeatureID)
			{
				case UiPackage.ABSTRACT_LABEL__POSITION: return PresentationPackage.ISIZED_ELEMENT__POSITION;
				case UiPackage.ABSTRACT_LABEL__WIDTH: return PresentationPackage.ISIZED_ELEMENT__WIDTH;
				case UiPackage.ABSTRACT_LABEL__HEIGHT: return PresentationPackage.ISIZED_ELEMENT__HEIGHT;
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
		if (baseClass == IRelativeElement.class)
		{
			switch (baseFeatureID)
			{
				case PresentationPackage.IRELATIVE_ELEMENT__VERTICAL_RELATIVE: return UiPackage.ABSTRACT_LABEL__VERTICAL_RELATIVE;
				case PresentationPackage.IRELATIVE_ELEMENT__HORIZONTAL_RELATIVE: return UiPackage.ABSTRACT_LABEL__HORIZONTAL_RELATIVE;
				default: return -1;
			}
		}
		if (baseClass == ISizedElement.class)
		{
			switch (baseFeatureID)
			{
				case PresentationPackage.ISIZED_ELEMENT__POSITION: return UiPackage.ABSTRACT_LABEL__POSITION;
				case PresentationPackage.ISIZED_ELEMENT__WIDTH: return UiPackage.ABSTRACT_LABEL__WIDTH;
				case PresentationPackage.ISIZED_ELEMENT__HEIGHT: return UiPackage.ABSTRACT_LABEL__HEIGHT;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case UiPackage.ABSTRACT_LABEL___CREATE_CONTAINMENT_ELIST__ECLASS:
				return createContainmentEList((EClass)arguments.get(0));
			case UiPackage.ABSTRACT_LABEL___LCONTENTS:
				return lContents();
			case UiPackage.ABSTRACT_LABEL___LPARENT:
				return lParent();
			case UiPackage.ABSTRACT_LABEL___LALL_CONTENTS:
				return lAllContents();
			case UiPackage.ABSTRACT_LABEL___LINFERENCE_OBJECT:
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
		result.append(", verticalRelative: ");
		result.append(verticalRelative);
		result.append(", horizontalRelative: ");
		result.append(horizontalRelative);
		result.append(", position: ");
		result.append(position);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", text: ");
		result.append(text);
		result.append(", fontScale: ");
		result.append(fontScale);
		result.append(')');
		return result.toString();
	}

} //AbstractLabelImpl
