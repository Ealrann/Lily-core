/**
 */
package org.sheepy.lily.core.model.ui.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.core.model.ui.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UiFactoryImpl extends EFactoryImpl implements UiFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UiFactory init()
	{
		try
		{
			UiFactory theUiFactory = (UiFactory)EPackage.Registry.INSTANCE.getEFactory(UiPackage.eNS_URI);
			if (theUiFactory != null)
			{
				return theUiFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case UiPackage.PANEL: return (EObject)createPanel();
			case UiPackage.UI: return (EObject)createUI();
			case UiPackage.UI_PAGE: return (EObject)createUIPage();
			case UiPackage.DYNAMIC_ROW_LAYOUT: return (EObject)createDynamicRowLayout();
			case UiPackage.VARIABLE_LABEL: return (EObject)createVariableLabel();
			case UiPackage.LABEL: return (EObject)createLabel();
			case UiPackage.SLIDER: return (EObject)createSlider();
			case UiPackage.TEXT_FIELD: return (EObject)createTextField();
			case UiPackage.BUTTON: return (EObject)createButton();
			case UiPackage.BOOLEAN_BUTTON: return (EObject)createBooleanButton();
			case UiPackage.BOOLEAN_ACTION_BUTTON: return (EObject)createBooleanActionButton();
			case UiPackage.FONT_PKG: return (EObject)createFontPkg();
			case UiPackage.FONT_TABLE: return (EObject)createFontTable();
			case UiPackage.FONT: return (EObject)createFont();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Panel createPanel()
	{
		PanelImpl panel = new PanelImpl();
		return panel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UI createUI()
	{
		UIImpl ui = new UIImpl();
		return ui;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UIPage createUIPage()
	{
		UIPageImpl uiPage = new UIPageImpl();
		return uiPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DynamicRowLayout createDynamicRowLayout()
	{
		DynamicRowLayoutImpl dynamicRowLayout = new DynamicRowLayoutImpl();
		return dynamicRowLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableLabel createVariableLabel()
	{
		VariableLabelImpl variableLabel = new VariableLabelImpl();
		return variableLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Label createLabel()
	{
		LabelImpl label = new LabelImpl();
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Slider createSlider()
	{
		SliderImpl slider = new SliderImpl();
		return slider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TextField createTextField()
	{
		TextFieldImpl textField = new TextFieldImpl();
		return textField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Button createButton()
	{
		ButtonImpl button = new ButtonImpl();
		return button;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanButton createBooleanButton()
	{
		BooleanButtonImpl booleanButton = new BooleanButtonImpl();
		return booleanButton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanActionButton createBooleanActionButton()
	{
		BooleanActionButtonImpl booleanActionButton = new BooleanActionButtonImpl();
		return booleanActionButton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FontPkg createFontPkg()
	{
		FontPkgImpl fontPkg = new FontPkgImpl();
		return fontPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FontTable createFontTable()
	{
		FontTableImpl fontTable = new FontTableImpl();
		return fontTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Font createFont()
	{
		FontImpl font = new FontImpl();
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UiPackage getUiPackage()
	{
		return (UiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UiPackage getPackage()
	{
		return UiPackage.eINSTANCE;
	}

} //UiFactoryImpl
