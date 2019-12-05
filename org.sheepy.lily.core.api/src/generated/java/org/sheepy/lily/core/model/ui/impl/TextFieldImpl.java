/**
 */
package org.sheepy.lily.core.model.ui.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.joml.Vector2ic;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.core.model.inference.IInferenceObject;

import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.presentation.PresentationPackage;

import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.ui.TextField;
import org.sheepy.lily.core.model.ui.UiPackage;

import org.sheepy.lily.core.model.variable.IVariableResolver;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.TextFieldImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.TextFieldImpl#getVerticalRelative <em>Vertical Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.TextFieldImpl#getHorizontalRelative <em>Horizontal Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.TextFieldImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.TextFieldImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.TextFieldImpl#getVariableResolver <em>Variable Resolver</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TextFieldImpl extends LilyEObject implements TextField
{
	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final Vector2ic POSITION_EDEFAULT = (Vector2ic)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector2i(), "0;0");

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected Vector2ic position = POSITION_EDEFAULT;

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
	 * The cached value of the '{@link #getVariableResolver() <em>Variable Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableResolver()
	 * @generated
	 * @ordered
	 */
	protected IVariableResolver variableResolver;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextFieldImpl()
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
		return UiPackage.Literals.TEXT_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector2ic getPosition()
	{
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPosition(Vector2ic newPosition)
	{
		Vector2ic oldPosition = position;
		position = newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT_FIELD__POSITION, oldPosition, position));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT_FIELD__VERTICAL_RELATIVE, oldVerticalRelative, verticalRelative));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT_FIELD__HORIZONTAL_RELATIVE, oldHorizontalRelative, horizontalRelative));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT_FIELD__WIDTH, oldWidth, width));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT_FIELD__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IVariableResolver getVariableResolver()
	{
		return variableResolver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableResolver(IVariableResolver newVariableResolver, NotificationChain msgs)
	{
		IVariableResolver oldVariableResolver = variableResolver;
		variableResolver = newVariableResolver;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.TEXT_FIELD__VARIABLE_RESOLVER, oldVariableResolver, newVariableResolver);
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
	public void setVariableResolver(IVariableResolver newVariableResolver)
	{
		if (newVariableResolver != variableResolver)
		{
			NotificationChain msgs = null;
			if (variableResolver != null)
				msgs = ((InternalEObject)variableResolver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.TEXT_FIELD__VARIABLE_RESOLVER, null, msgs);
			if (newVariableResolver != null)
				msgs = ((InternalEObject)newVariableResolver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.TEXT_FIELD__VARIABLE_RESOLVER, null, msgs);
			msgs = basicSetVariableResolver(newVariableResolver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT_FIELD__VARIABLE_RESOLVER, newVariableResolver, newVariableResolver));
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
			case UiPackage.TEXT_FIELD__VARIABLE_RESOLVER:
				return basicSetVariableResolver(null, msgs);
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
			case UiPackage.TEXT_FIELD__POSITION:
				return getPosition();
			case UiPackage.TEXT_FIELD__VERTICAL_RELATIVE:
				return getVerticalRelative();
			case UiPackage.TEXT_FIELD__HORIZONTAL_RELATIVE:
				return getHorizontalRelative();
			case UiPackage.TEXT_FIELD__WIDTH:
				return getWidth();
			case UiPackage.TEXT_FIELD__HEIGHT:
				return getHeight();
			case UiPackage.TEXT_FIELD__VARIABLE_RESOLVER:
				return getVariableResolver();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case UiPackage.TEXT_FIELD__POSITION:
				setPosition((Vector2ic)newValue);
				return;
			case UiPackage.TEXT_FIELD__VERTICAL_RELATIVE:
				setVerticalRelative((EVerticalRelative)newValue);
				return;
			case UiPackage.TEXT_FIELD__HORIZONTAL_RELATIVE:
				setHorizontalRelative((EHorizontalRelative)newValue);
				return;
			case UiPackage.TEXT_FIELD__WIDTH:
				setWidth((Integer)newValue);
				return;
			case UiPackage.TEXT_FIELD__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case UiPackage.TEXT_FIELD__VARIABLE_RESOLVER:
				setVariableResolver((IVariableResolver)newValue);
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
			case UiPackage.TEXT_FIELD__POSITION:
				setPosition(POSITION_EDEFAULT);
				return;
			case UiPackage.TEXT_FIELD__VERTICAL_RELATIVE:
				setVerticalRelative(VERTICAL_RELATIVE_EDEFAULT);
				return;
			case UiPackage.TEXT_FIELD__HORIZONTAL_RELATIVE:
				setHorizontalRelative(HORIZONTAL_RELATIVE_EDEFAULT);
				return;
			case UiPackage.TEXT_FIELD__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case UiPackage.TEXT_FIELD__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case UiPackage.TEXT_FIELD__VARIABLE_RESOLVER:
				setVariableResolver((IVariableResolver)null);
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
			case UiPackage.TEXT_FIELD__POSITION:
				return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
			case UiPackage.TEXT_FIELD__VERTICAL_RELATIVE:
				return verticalRelative != VERTICAL_RELATIVE_EDEFAULT;
			case UiPackage.TEXT_FIELD__HORIZONTAL_RELATIVE:
				return horizontalRelative != HORIZONTAL_RELATIVE_EDEFAULT;
			case UiPackage.TEXT_FIELD__WIDTH:
				return width != WIDTH_EDEFAULT;
			case UiPackage.TEXT_FIELD__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case UiPackage.TEXT_FIELD__VARIABLE_RESOLVER:
				return variableResolver != null;
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
		if (baseClass == IPositionElement.class)
		{
			switch (derivedFeatureID)
			{
				case UiPackage.TEXT_FIELD__POSITION: return PresentationPackage.IPOSITION_ELEMENT__POSITION;
				case UiPackage.TEXT_FIELD__VERTICAL_RELATIVE: return PresentationPackage.IPOSITION_ELEMENT__VERTICAL_RELATIVE;
				case UiPackage.TEXT_FIELD__HORIZONTAL_RELATIVE: return PresentationPackage.IPOSITION_ELEMENT__HORIZONTAL_RELATIVE;
				default: return -1;
			}
		}
		if (baseClass == ISizedElement.class)
		{
			switch (derivedFeatureID)
			{
				case UiPackage.TEXT_FIELD__WIDTH: return PresentationPackage.ISIZED_ELEMENT__WIDTH;
				case UiPackage.TEXT_FIELD__HEIGHT: return PresentationPackage.ISIZED_ELEMENT__HEIGHT;
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
		if (baseClass == IPositionElement.class)
		{
			switch (baseFeatureID)
			{
				case PresentationPackage.IPOSITION_ELEMENT__POSITION: return UiPackage.TEXT_FIELD__POSITION;
				case PresentationPackage.IPOSITION_ELEMENT__VERTICAL_RELATIVE: return UiPackage.TEXT_FIELD__VERTICAL_RELATIVE;
				case PresentationPackage.IPOSITION_ELEMENT__HORIZONTAL_RELATIVE: return UiPackage.TEXT_FIELD__HORIZONTAL_RELATIVE;
				default: return -1;
			}
		}
		if (baseClass == ISizedElement.class)
		{
			switch (baseFeatureID)
			{
				case PresentationPackage.ISIZED_ELEMENT__WIDTH: return UiPackage.TEXT_FIELD__WIDTH;
				case PresentationPackage.ISIZED_ELEMENT__HEIGHT: return UiPackage.TEXT_FIELD__HEIGHT;
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
			case UiPackage.TEXT_FIELD___LINFERENCE_OBJECT:
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
		result.append(" (position: ");
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

} //TextFieldImpl
