/**
 */
package org.sheepy.lily.core.model.ui.impl;

import java.lang.reflect.InvocationTargetException;
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
import org.joml.Vector4ic;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.inference.InferencePackage;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.core.model.ui.IControl;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.core.model.ui.Panel;
import org.sheepy.lily.core.model.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Panel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#getVerticalRelative <em>Vertical Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#getHorizontalRelative <em>Horizontal Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#isCatchInputs <em>Catch Inputs</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#getControls <em>Controls</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#isShowTitle <em>Show Title</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#isMinimizable <em>Minimizable</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#isMovable <em>Movable</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#isMinimized <em>Minimized</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#getBackgroundImage <em>Background Image</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.PanelImpl#getBorderColor <em>Border Color</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PanelImpl extends LilyEObject implements Panel
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #isCatchInputs() <em>Catch Inputs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCatchInputs()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CATCH_INPUTS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCatchInputs() <em>Catch Inputs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCatchInputs()
	 * @generated
	 * @ordered
	 */
	protected boolean catchInputs = CATCH_INPUTS_EDEFAULT;

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
	 * The cached value of the '{@link #getControls() <em>Controls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControls()
	 * @generated
	 * @ordered
	 */
	protected EList<IControl> controls;

	/**
	 * The default value of the '{@link #isShowTitle() <em>Show Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowTitle()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_TITLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isShowTitle() <em>Show Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowTitle()
	 * @generated
	 * @ordered
	 */
	protected boolean showTitle = SHOW_TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isMinimizable() <em>Minimizable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimizable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MINIMIZABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMinimizable() <em>Minimizable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimizable()
	 * @generated
	 * @ordered
	 */
	protected boolean minimizable = MINIMIZABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isMovable() <em>Movable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMovable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MOVABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMovable() <em>Movable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMovable()
	 * @generated
	 * @ordered
	 */
	protected boolean movable = MOVABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isMinimized() <em>Minimized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MINIMIZED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMinimized() <em>Minimized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimized()
	 * @generated
	 * @ordered
	 */
	protected boolean minimized = MINIMIZED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBackgroundImage() <em>Background Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundImage()
	 * @generated
	 * @ordered
	 */
	protected IImage backgroundImage;

	/**
	 * The default value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected static final Vector4ic BACKGROUND_COLOR_EDEFAULT = (Vector4ic)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector4i(), "90;90;90;150");

	/**
	 * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected Vector4ic backgroundColor = BACKGROUND_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderColor() <em>Border Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderColor()
	 * @generated
	 * @ordered
	 */
	protected static final Vector4ic BORDER_COLOR_EDEFAULT = (Vector4ic)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector4i(), "60;60;60;150");

	/**
	 * The cached value of the '{@link #getBorderColor() <em>Border Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderColor()
	 * @generated
	 * @ordered
	 */
	protected Vector4ic borderColor = BORDER_COLOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PanelImpl()
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
		return UiPackage.Literals.PANEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__POSITION, oldPosition, position));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__VERTICAL_RELATIVE, oldVerticalRelative, verticalRelative));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__HORIZONTAL_RELATIVE, oldHorizontalRelative, horizontalRelative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCatchInputs()
	{
		return catchInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCatchInputs(boolean newCatchInputs)
	{
		boolean oldCatchInputs = catchInputs;
		catchInputs = newCatchInputs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__CATCH_INPUTS, oldCatchInputs, catchInputs));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__WIDTH, oldWidth, width));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IControl> getControls()
	{
		if (controls == null)
		{
			controls = new EObjectContainmentEList<>(IControl.class, this, UiPackage.PANEL__CONTROLS);
		}
		return controls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isShowTitle()
	{
		return showTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShowTitle(boolean newShowTitle)
	{
		boolean oldShowTitle = showTitle;
		showTitle = newShowTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__SHOW_TITLE, oldShowTitle, showTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMinimizable()
	{
		return minimizable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinimizable(boolean newMinimizable)
	{
		boolean oldMinimizable = minimizable;
		minimizable = newMinimizable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__MINIMIZABLE, oldMinimizable, minimizable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMovable()
	{
		return movable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMovable(boolean newMovable)
	{
		boolean oldMovable = movable;
		movable = newMovable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__MOVABLE, oldMovable, movable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMinimized()
	{
		return minimized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinimized(boolean newMinimized)
	{
		boolean oldMinimized = minimized;
		minimized = newMinimized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__MINIMIZED, oldMinimized, minimized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IImage getBackgroundImage()
	{
		if (backgroundImage != null && ((EObject)backgroundImage).eIsProxy())
		{
			InternalEObject oldBackgroundImage = backgroundImage;
			backgroundImage = (IImage)eResolveProxy(oldBackgroundImage);
			if (backgroundImage != oldBackgroundImage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiPackage.PANEL__BACKGROUND_IMAGE, oldBackgroundImage, backgroundImage));
			}
		}
		return backgroundImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IImage basicGetBackgroundImage()
	{
		return backgroundImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBackgroundImage(IImage newBackgroundImage)
	{
		IImage oldBackgroundImage = backgroundImage;
		backgroundImage = newBackgroundImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__BACKGROUND_IMAGE, oldBackgroundImage, backgroundImage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector4ic getBackgroundColor()
	{
		return backgroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBackgroundColor(Vector4ic newBackgroundColor)
	{
		Vector4ic oldBackgroundColor = backgroundColor;
		backgroundColor = newBackgroundColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__BACKGROUND_COLOR, oldBackgroundColor, backgroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector4ic getBorderColor()
	{
		return borderColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBorderColor(Vector4ic newBorderColor)
	{
		Vector4ic oldBorderColor = borderColor;
		borderColor = newBorderColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PANEL__BORDER_COLOR, oldBorderColor, borderColor));
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
			case UiPackage.PANEL__CONTROLS:
				return ((InternalEList<?>)getControls()).basicRemove(otherEnd, msgs);
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
			case UiPackage.PANEL__NAME:
				return getName();
			case UiPackage.PANEL__POSITION:
				return getPosition();
			case UiPackage.PANEL__VERTICAL_RELATIVE:
				return getVerticalRelative();
			case UiPackage.PANEL__HORIZONTAL_RELATIVE:
				return getHorizontalRelative();
			case UiPackage.PANEL__CATCH_INPUTS:
				return isCatchInputs();
			case UiPackage.PANEL__WIDTH:
				return getWidth();
			case UiPackage.PANEL__HEIGHT:
				return getHeight();
			case UiPackage.PANEL__CONTROLS:
				return getControls();
			case UiPackage.PANEL__SHOW_TITLE:
				return isShowTitle();
			case UiPackage.PANEL__MINIMIZABLE:
				return isMinimizable();
			case UiPackage.PANEL__MOVABLE:
				return isMovable();
			case UiPackage.PANEL__MINIMIZED:
				return isMinimized();
			case UiPackage.PANEL__BACKGROUND_IMAGE:
				if (resolve) return getBackgroundImage();
				return basicGetBackgroundImage();
			case UiPackage.PANEL__BACKGROUND_COLOR:
				return getBackgroundColor();
			case UiPackage.PANEL__BORDER_COLOR:
				return getBorderColor();
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
			case UiPackage.PANEL__NAME:
				setName((String)newValue);
				return;
			case UiPackage.PANEL__POSITION:
				setPosition((Vector2ic)newValue);
				return;
			case UiPackage.PANEL__VERTICAL_RELATIVE:
				setVerticalRelative((EVerticalRelative)newValue);
				return;
			case UiPackage.PANEL__HORIZONTAL_RELATIVE:
				setHorizontalRelative((EHorizontalRelative)newValue);
				return;
			case UiPackage.PANEL__CATCH_INPUTS:
				setCatchInputs((Boolean)newValue);
				return;
			case UiPackage.PANEL__WIDTH:
				setWidth((Integer)newValue);
				return;
			case UiPackage.PANEL__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case UiPackage.PANEL__CONTROLS:
				getControls().clear();
				getControls().addAll((Collection<? extends IControl>)newValue);
				return;
			case UiPackage.PANEL__SHOW_TITLE:
				setShowTitle((Boolean)newValue);
				return;
			case UiPackage.PANEL__MINIMIZABLE:
				setMinimizable((Boolean)newValue);
				return;
			case UiPackage.PANEL__MOVABLE:
				setMovable((Boolean)newValue);
				return;
			case UiPackage.PANEL__MINIMIZED:
				setMinimized((Boolean)newValue);
				return;
			case UiPackage.PANEL__BACKGROUND_IMAGE:
				setBackgroundImage((IImage)newValue);
				return;
			case UiPackage.PANEL__BACKGROUND_COLOR:
				setBackgroundColor((Vector4ic)newValue);
				return;
			case UiPackage.PANEL__BORDER_COLOR:
				setBorderColor((Vector4ic)newValue);
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
			case UiPackage.PANEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UiPackage.PANEL__POSITION:
				setPosition(POSITION_EDEFAULT);
				return;
			case UiPackage.PANEL__VERTICAL_RELATIVE:
				setVerticalRelative(VERTICAL_RELATIVE_EDEFAULT);
				return;
			case UiPackage.PANEL__HORIZONTAL_RELATIVE:
				setHorizontalRelative(HORIZONTAL_RELATIVE_EDEFAULT);
				return;
			case UiPackage.PANEL__CATCH_INPUTS:
				setCatchInputs(CATCH_INPUTS_EDEFAULT);
				return;
			case UiPackage.PANEL__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case UiPackage.PANEL__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case UiPackage.PANEL__CONTROLS:
				getControls().clear();
				return;
			case UiPackage.PANEL__SHOW_TITLE:
				setShowTitle(SHOW_TITLE_EDEFAULT);
				return;
			case UiPackage.PANEL__MINIMIZABLE:
				setMinimizable(MINIMIZABLE_EDEFAULT);
				return;
			case UiPackage.PANEL__MOVABLE:
				setMovable(MOVABLE_EDEFAULT);
				return;
			case UiPackage.PANEL__MINIMIZED:
				setMinimized(MINIMIZED_EDEFAULT);
				return;
			case UiPackage.PANEL__BACKGROUND_IMAGE:
				setBackgroundImage((IImage)null);
				return;
			case UiPackage.PANEL__BACKGROUND_COLOR:
				setBackgroundColor(BACKGROUND_COLOR_EDEFAULT);
				return;
			case UiPackage.PANEL__BORDER_COLOR:
				setBorderColor(BORDER_COLOR_EDEFAULT);
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
			case UiPackage.PANEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UiPackage.PANEL__POSITION:
				return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
			case UiPackage.PANEL__VERTICAL_RELATIVE:
				return verticalRelative != VERTICAL_RELATIVE_EDEFAULT;
			case UiPackage.PANEL__HORIZONTAL_RELATIVE:
				return horizontalRelative != HORIZONTAL_RELATIVE_EDEFAULT;
			case UiPackage.PANEL__CATCH_INPUTS:
				return catchInputs != CATCH_INPUTS_EDEFAULT;
			case UiPackage.PANEL__WIDTH:
				return width != WIDTH_EDEFAULT;
			case UiPackage.PANEL__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case UiPackage.PANEL__CONTROLS:
				return controls != null && !controls.isEmpty();
			case UiPackage.PANEL__SHOW_TITLE:
				return showTitle != SHOW_TITLE_EDEFAULT;
			case UiPackage.PANEL__MINIMIZABLE:
				return minimizable != MINIMIZABLE_EDEFAULT;
			case UiPackage.PANEL__MOVABLE:
				return movable != MOVABLE_EDEFAULT;
			case UiPackage.PANEL__MINIMIZED:
				return minimized != MINIMIZED_EDEFAULT;
			case UiPackage.PANEL__BACKGROUND_IMAGE:
				return backgroundImage != null;
			case UiPackage.PANEL__BACKGROUND_COLOR:
				return BACKGROUND_COLOR_EDEFAULT == null ? backgroundColor != null : !BACKGROUND_COLOR_EDEFAULT.equals(backgroundColor);
			case UiPackage.PANEL__BORDER_COLOR:
				return BORDER_COLOR_EDEFAULT == null ? borderColor != null : !BORDER_COLOR_EDEFAULT.equals(borderColor);
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
		if (baseClass == IInferenceObject.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == IUIElement.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == IPositionElement.class)
		{
			switch (derivedFeatureID)
			{
				case UiPackage.PANEL__POSITION: return PresentationPackage.IPOSITION_ELEMENT__POSITION;
				case UiPackage.PANEL__VERTICAL_RELATIVE: return PresentationPackage.IPOSITION_ELEMENT__VERTICAL_RELATIVE;
				case UiPackage.PANEL__HORIZONTAL_RELATIVE: return PresentationPackage.IPOSITION_ELEMENT__HORIZONTAL_RELATIVE;
				default: return -1;
			}
		}
		if (baseClass == ISizedElement.class)
		{
			switch (derivedFeatureID)
			{
				case UiPackage.PANEL__WIDTH: return PresentationPackage.ISIZED_ELEMENT__WIDTH;
				case UiPackage.PANEL__HEIGHT: return PresentationPackage.ISIZED_ELEMENT__HEIGHT;
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
		if (baseClass == IInferenceObject.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == IUIElement.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == IPositionElement.class)
		{
			switch (baseFeatureID)
			{
				case PresentationPackage.IPOSITION_ELEMENT__POSITION: return UiPackage.PANEL__POSITION;
				case PresentationPackage.IPOSITION_ELEMENT__VERTICAL_RELATIVE: return UiPackage.PANEL__VERTICAL_RELATIVE;
				case PresentationPackage.IPOSITION_ELEMENT__HORIZONTAL_RELATIVE: return UiPackage.PANEL__HORIZONTAL_RELATIVE;
				default: return -1;
			}
		}
		if (baseClass == ISizedElement.class)
		{
			switch (baseFeatureID)
			{
				case PresentationPackage.ISIZED_ELEMENT__WIDTH: return UiPackage.PANEL__WIDTH;
				case PresentationPackage.ISIZED_ELEMENT__HEIGHT: return UiPackage.PANEL__HEIGHT;
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
	{
		if (baseClass == IInferenceObject.class)
		{
			switch (baseOperationID)
			{
				case InferencePackage.IINFERENCE_OBJECT___LINFERENCE_OBJECT: return UiPackage.PANEL___LINFERENCE_OBJECT;
				default: return -1;
			}
		}
		if (baseClass == IUIElement.class)
		{
			switch (baseOperationID)
			{
				default: return -1;
			}
		}
		if (baseClass == IPositionElement.class)
		{
			switch (baseOperationID)
			{
				default: return -1;
			}
		}
		if (baseClass == ISizedElement.class)
		{
			switch (baseOperationID)
			{
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case UiPackage.PANEL___LINFERENCE_OBJECT:
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
		result.append(" (name: ");
		result.append(name);
		result.append(", position: ");
		result.append(position);
		result.append(", verticalRelative: ");
		result.append(verticalRelative);
		result.append(", horizontalRelative: ");
		result.append(horizontalRelative);
		result.append(", catchInputs: ");
		result.append(catchInputs);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", showTitle: ");
		result.append(showTitle);
		result.append(", minimizable: ");
		result.append(minimizable);
		result.append(", movable: ");
		result.append(movable);
		result.append(", minimized: ");
		result.append(minimized);
		result.append(", backgroundColor: ");
		result.append(backgroundColor);
		result.append(", borderColor: ");
		result.append(borderColor);
		result.append(')');
		return result.toString();
	}

} //PanelImpl
