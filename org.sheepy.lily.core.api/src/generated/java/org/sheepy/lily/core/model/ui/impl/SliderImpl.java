/**
 */
package org.sheepy.lily.core.model.ui.impl;

import java.util.ArrayList;
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

import org.joml.Vector2ic;

import org.sheepy.lily.core.api.util.LTreeIterator;

import org.sheepy.lily.core.model.inference.IInferenceObject;

import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.presentation.PresentationPackage;

import org.sheepy.lily.core.model.root.LObject;

import org.sheepy.lily.core.model.root.RootPackage.Literals;

import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.ui.Slider;
import org.sheepy.lily.core.model.ui.UiPackage;

import org.sheepy.lily.core.model.variable.IVariableResolver;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getVerticalRelative <em>Vertical Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getHorizontalRelative <em>Horizontal Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getStep <em>Step</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.SliderImpl#getVariableResolver <em>Variable Resolver</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SliderImpl extends MinimalEObjectImpl.Container implements Slider
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
	protected static final Vector2ic POSITION_EDEFAULT = (Vector2ic) TypesFactory.eINSTANCE
			.createFromString(TypesPackage.eINSTANCE.getVector2i(), "0;0");

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
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected int minValue = MIN_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_VALUE_EDEFAULT = 10;

	/**
	 * The cached value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected int maxValue = MAX_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected int step = STEP_EDEFAULT;

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
	protected SliderImpl()
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
		return UiPackage.Literals.SLIDER;
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				UiPackage.SLIDER__CONTENT_OBJECTS, oldContentObjects, contentObjects));
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				UiPackage.SLIDER__POSITION, oldPosition, position));
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
		verticalRelative = newVerticalRelative == null
				? VERTICAL_RELATIVE_EDEFAULT
				: newVerticalRelative;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				UiPackage.SLIDER__VERTICAL_RELATIVE, oldVerticalRelative, verticalRelative));
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
		horizontalRelative = newHorizontalRelative == null
				? HORIZONTAL_RELATIVE_EDEFAULT
				: newHorizontalRelative;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				UiPackage.SLIDER__HORIZONTAL_RELATIVE, oldHorizontalRelative, horizontalRelative));
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				UiPackage.SLIDER__WIDTH, oldWidth, width));
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				UiPackage.SLIDER__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMinValue()
	{
		return minValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinValue(int newMinValue)
	{
		int oldMinValue = minValue;
		minValue = newMinValue;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				UiPackage.SLIDER__MIN_VALUE, oldMinValue, minValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMaxValue()
	{
		return maxValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxValue(int newMaxValue)
	{
		int oldMaxValue = maxValue;
		maxValue = newMaxValue;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				UiPackage.SLIDER__MAX_VALUE, oldMaxValue, maxValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getStep()
	{
		return step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStep(int newStep)
	{
		int oldStep = step;
		step = newStep;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				UiPackage.SLIDER__STEP, oldStep, step));
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
	public NotificationChain basicSetVariableResolver(	IVariableResolver newVariableResolver,
														NotificationChain msgs)
	{
		IVariableResolver oldVariableResolver = variableResolver;
		variableResolver = newVariableResolver;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					UiPackage.SLIDER__VARIABLE_RESOLVER, oldVariableResolver, newVariableResolver);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
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
				msgs = ((InternalEObject) variableResolver).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - UiPackage.SLIDER__VARIABLE_RESOLVER, null, msgs);
			if (newVariableResolver != null)
				msgs = ((InternalEObject) newVariableResolver).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - UiPackage.SLIDER__VARIABLE_RESOLVER, null, msgs);
			msgs = basicSetVariableResolver(newVariableResolver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				UiPackage.SLIDER__VARIABLE_RESOLVER, newVariableResolver, newVariableResolver));
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
			res = ECollections.<T> emptyEList();
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
				this.setContentObjects(this.<LObject> createContainmentEList(Literals.LOBJECT));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case UiPackage.SLIDER__VARIABLE_RESOLVER:
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
		case UiPackage.SLIDER__CONTENT_OBJECTS:
			return getContentObjects();
		case UiPackage.SLIDER__POSITION:
			return getPosition();
		case UiPackage.SLIDER__VERTICAL_RELATIVE:
			return getVerticalRelative();
		case UiPackage.SLIDER__HORIZONTAL_RELATIVE:
			return getHorizontalRelative();
		case UiPackage.SLIDER__WIDTH:
			return getWidth();
		case UiPackage.SLIDER__HEIGHT:
			return getHeight();
		case UiPackage.SLIDER__MIN_VALUE:
			return getMinValue();
		case UiPackage.SLIDER__MAX_VALUE:
			return getMaxValue();
		case UiPackage.SLIDER__STEP:
			return getStep();
		case UiPackage.SLIDER__VARIABLE_RESOLVER:
			return getVariableResolver();
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
		case UiPackage.SLIDER__CONTENT_OBJECTS:
			setContentObjects((EList<LObject>) newValue);
			return;
		case UiPackage.SLIDER__POSITION:
			setPosition((Vector2ic) newValue);
			return;
		case UiPackage.SLIDER__VERTICAL_RELATIVE:
			setVerticalRelative((EVerticalRelative) newValue);
			return;
		case UiPackage.SLIDER__HORIZONTAL_RELATIVE:
			setHorizontalRelative((EHorizontalRelative) newValue);
			return;
		case UiPackage.SLIDER__WIDTH:
			setWidth((Integer) newValue);
			return;
		case UiPackage.SLIDER__HEIGHT:
			setHeight((Integer) newValue);
			return;
		case UiPackage.SLIDER__MIN_VALUE:
			setMinValue((Integer) newValue);
			return;
		case UiPackage.SLIDER__MAX_VALUE:
			setMaxValue((Integer) newValue);
			return;
		case UiPackage.SLIDER__STEP:
			setStep((Integer) newValue);
			return;
		case UiPackage.SLIDER__VARIABLE_RESOLVER:
			setVariableResolver((IVariableResolver) newValue);
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
		case UiPackage.SLIDER__CONTENT_OBJECTS:
			setContentObjects((EList<LObject>) null);
			return;
		case UiPackage.SLIDER__POSITION:
			setPosition(POSITION_EDEFAULT);
			return;
		case UiPackage.SLIDER__VERTICAL_RELATIVE:
			setVerticalRelative(VERTICAL_RELATIVE_EDEFAULT);
			return;
		case UiPackage.SLIDER__HORIZONTAL_RELATIVE:
			setHorizontalRelative(HORIZONTAL_RELATIVE_EDEFAULT);
			return;
		case UiPackage.SLIDER__WIDTH:
			setWidth(WIDTH_EDEFAULT);
			return;
		case UiPackage.SLIDER__HEIGHT:
			setHeight(HEIGHT_EDEFAULT);
			return;
		case UiPackage.SLIDER__MIN_VALUE:
			setMinValue(MIN_VALUE_EDEFAULT);
			return;
		case UiPackage.SLIDER__MAX_VALUE:
			setMaxValue(MAX_VALUE_EDEFAULT);
			return;
		case UiPackage.SLIDER__STEP:
			setStep(STEP_EDEFAULT);
			return;
		case UiPackage.SLIDER__VARIABLE_RESOLVER:
			setVariableResolver((IVariableResolver) null);
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
		case UiPackage.SLIDER__CONTENT_OBJECTS:
			return contentObjects != null;
		case UiPackage.SLIDER__POSITION:
			return POSITION_EDEFAULT == null
					? position != null
					: !POSITION_EDEFAULT.equals(position);
		case UiPackage.SLIDER__VERTICAL_RELATIVE:
			return verticalRelative != VERTICAL_RELATIVE_EDEFAULT;
		case UiPackage.SLIDER__HORIZONTAL_RELATIVE:
			return horizontalRelative != HORIZONTAL_RELATIVE_EDEFAULT;
		case UiPackage.SLIDER__WIDTH:
			return width != WIDTH_EDEFAULT;
		case UiPackage.SLIDER__HEIGHT:
			return height != HEIGHT_EDEFAULT;
		case UiPackage.SLIDER__MIN_VALUE:
			return minValue != MIN_VALUE_EDEFAULT;
		case UiPackage.SLIDER__MAX_VALUE:
			return maxValue != MAX_VALUE_EDEFAULT;
		case UiPackage.SLIDER__STEP:
			return step != STEP_EDEFAULT;
		case UiPackage.SLIDER__VARIABLE_RESOLVER:
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
			case UiPackage.SLIDER__POSITION:
				return PresentationPackage.IPOSITION_ELEMENT__POSITION;
			case UiPackage.SLIDER__VERTICAL_RELATIVE:
				return PresentationPackage.IPOSITION_ELEMENT__VERTICAL_RELATIVE;
			case UiPackage.SLIDER__HORIZONTAL_RELATIVE:
				return PresentationPackage.IPOSITION_ELEMENT__HORIZONTAL_RELATIVE;
			default:
				return -1;
			}
		}
		if (baseClass == ISizedElement.class)
		{
			switch (derivedFeatureID)
			{
			case UiPackage.SLIDER__WIDTH:
				return PresentationPackage.ISIZED_ELEMENT__WIDTH;
			case UiPackage.SLIDER__HEIGHT:
				return PresentationPackage.ISIZED_ELEMENT__HEIGHT;
			default:
				return -1;
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
			case PresentationPackage.IPOSITION_ELEMENT__POSITION:
				return UiPackage.SLIDER__POSITION;
			case PresentationPackage.IPOSITION_ELEMENT__VERTICAL_RELATIVE:
				return UiPackage.SLIDER__VERTICAL_RELATIVE;
			case PresentationPackage.IPOSITION_ELEMENT__HORIZONTAL_RELATIVE:
				return UiPackage.SLIDER__HORIZONTAL_RELATIVE;
			default:
				return -1;
			}
		}
		if (baseClass == ISizedElement.class)
		{
			switch (baseFeatureID)
			{
			case PresentationPackage.ISIZED_ELEMENT__WIDTH:
				return UiPackage.SLIDER__WIDTH;
			case PresentationPackage.ISIZED_ELEMENT__HEIGHT:
				return UiPackage.SLIDER__HEIGHT;
			default:
				return -1;
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
		result.append(", minValue: ");
		result.append(minValue);
		result.append(", maxValue: ");
		result.append(maxValue);
		result.append(", step: ");
		result.append(step);
		result.append(')');
		return result.toString();
	}

} //SliderImpl
