/**
 */
package org.sheepy.common.model.ui.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.common.model.action.ActionPackage;

import org.sheepy.common.model.application.ApplicationPackage;

import org.sheepy.common.model.inference.InferencePackage;

import org.sheepy.common.model.presentation.PresentationPackage;

import org.sheepy.common.model.root.RootPackage;

import org.sheepy.common.model.types.TypesPackage;

import org.sheepy.common.model.ui.AbstractBooleanButton;
import org.sheepy.common.model.ui.AbstractButton;
import org.sheepy.common.model.ui.AbstractLabel;
import org.sheepy.common.model.ui.BooleanActionButton;
import org.sheepy.common.model.ui.BooleanButton;
import org.sheepy.common.model.ui.Button;
import org.sheepy.common.model.ui.DynamicRowLayout;
import org.sheepy.common.model.ui.Label;
import org.sheepy.common.model.ui.Slider;
import org.sheepy.common.model.ui.TextField;
import org.sheepy.common.model.ui.UiFactory;
import org.sheepy.common.model.ui.UiPackage;
import org.sheepy.common.model.ui.VariableLabel;

import org.sheepy.common.model.variable.VariablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UiPackageImpl extends EPackageImpl implements UiPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicRowLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sliderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractButtonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buttonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractBooleanButtonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanButtonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanActionButtonEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.sheepy.common.model.ui.UiPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UiPackageImpl()
	{
		super(eNS_URI, UiFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link UiPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UiPackage init()
	{
		if (isInited) return (UiPackage)EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredUiPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UiPackageImpl theUiPackage = registeredUiPackage instanceof UiPackageImpl ? (UiPackageImpl)registeredUiPackage : new UiPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		PresentationPackage.eINSTANCE.eClass();
		RootPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		VariablePackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUiPackage.createPackageContents();

		// Initialize created meta-data
		theUiPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUiPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UiPackage.eNS_URI, theUiPackage);
		return theUiPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractLabel()
	{
		return abstractLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractLabel_Text()
	{
		return (EAttribute)abstractLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractLabel_FontScale()
	{
		return (EAttribute)abstractLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDynamicRowLayout()
	{
		return dynamicRowLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDynamicRowLayout_Height()
	{
		return (EAttribute)dynamicRowLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDynamicRowLayout_ColumnCount()
	{
		return (EAttribute)dynamicRowLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableLabel()
	{
		return variableLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableLabel_VariableResolver()
	{
		return (EReference)variableLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLabel()
	{
		return labelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSlider()
	{
		return sliderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSlider_MinValue()
	{
		return (EAttribute)sliderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSlider_MaxValue()
	{
		return (EAttribute)sliderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSlider_Step()
	{
		return (EAttribute)sliderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSlider_VariableResolver()
	{
		return (EReference)sliderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTextField()
	{
		return textFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTextField_VariableResolver()
	{
		return (EReference)textFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractButton()
	{
		return abstractButtonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractButton_Text()
	{
		return (EAttribute)abstractButtonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getButton()
	{
		return buttonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getButton_Shortcut()
	{
		return (EAttribute)buttonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getButton_State()
	{
		return (EAttribute)buttonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getButton_Actions()
	{
		return (EReference)buttonEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getButton__LActions()
	{
		return buttonEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getButton__GetExecutor()
	{
		return buttonEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractBooleanButton()
	{
		return abstractBooleanButtonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractBooleanButton_TextWhenTrue()
	{
		return (EAttribute)abstractBooleanButtonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractBooleanButton_TextWhenFalse()
	{
		return (EAttribute)abstractBooleanButtonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanButton()
	{
		return booleanButtonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBooleanButton_VariableResolver()
	{
		return (EReference)booleanButtonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanActionButton()
	{
		return booleanActionButtonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBooleanActionButton_ActionWhenTrue()
	{
		return (EReference)booleanActionButtonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBooleanActionButton_ActionWhenFalse()
	{
		return (EReference)booleanActionButtonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UiFactory getUiFactory()
	{
		return (UiFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractLabelEClass = createEClass(ABSTRACT_LABEL);
		createEAttribute(abstractLabelEClass, ABSTRACT_LABEL__TEXT);
		createEAttribute(abstractLabelEClass, ABSTRACT_LABEL__FONT_SCALE);

		dynamicRowLayoutEClass = createEClass(DYNAMIC_ROW_LAYOUT);
		createEAttribute(dynamicRowLayoutEClass, DYNAMIC_ROW_LAYOUT__HEIGHT);
		createEAttribute(dynamicRowLayoutEClass, DYNAMIC_ROW_LAYOUT__COLUMN_COUNT);

		variableLabelEClass = createEClass(VARIABLE_LABEL);
		createEReference(variableLabelEClass, VARIABLE_LABEL__VARIABLE_RESOLVER);

		labelEClass = createEClass(LABEL);

		sliderEClass = createEClass(SLIDER);
		createEAttribute(sliderEClass, SLIDER__MIN_VALUE);
		createEAttribute(sliderEClass, SLIDER__MAX_VALUE);
		createEAttribute(sliderEClass, SLIDER__STEP);
		createEReference(sliderEClass, SLIDER__VARIABLE_RESOLVER);

		textFieldEClass = createEClass(TEXT_FIELD);
		createEReference(textFieldEClass, TEXT_FIELD__VARIABLE_RESOLVER);

		abstractButtonEClass = createEClass(ABSTRACT_BUTTON);
		createEAttribute(abstractButtonEClass, ABSTRACT_BUTTON__TEXT);

		buttonEClass = createEClass(BUTTON);
		createEAttribute(buttonEClass, BUTTON__SHORTCUT);
		createEAttribute(buttonEClass, BUTTON__STATE);
		createEReference(buttonEClass, BUTTON__ACTIONS);
		createEOperation(buttonEClass, BUTTON___LACTIONS);
		createEOperation(buttonEClass, BUTTON___GET_EXECUTOR);

		abstractBooleanButtonEClass = createEClass(ABSTRACT_BOOLEAN_BUTTON);
		createEAttribute(abstractBooleanButtonEClass, ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_TRUE);
		createEAttribute(abstractBooleanButtonEClass, ABSTRACT_BOOLEAN_BUTTON__TEXT_WHEN_FALSE);

		booleanButtonEClass = createEClass(BOOLEAN_BUTTON);
		createEReference(booleanButtonEClass, BOOLEAN_BUTTON__VARIABLE_RESOLVER);

		booleanActionButtonEClass = createEClass(BOOLEAN_ACTION_BUTTON);
		createEReference(booleanActionButtonEClass, BOOLEAN_ACTION_BUTTON__ACTION_WHEN_TRUE);
		createEReference(booleanActionButtonEClass, BOOLEAN_ACTION_BUTTON__ACTION_WHEN_FALSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PresentationPackage thePresentationPackage = (PresentationPackage)EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		VariablePackage theVariablePackage = (VariablePackage)EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		ActionPackage theActionPackage = (ActionPackage)EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);
		RootPackage theRootPackage = (RootPackage)EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractLabelEClass.getESuperTypes().add(thePresentationPackage.getWidget());
		dynamicRowLayoutEClass.getESuperTypes().add(thePresentationPackage.getIControl());
		variableLabelEClass.getESuperTypes().add(this.getAbstractLabel());
		labelEClass.getESuperTypes().add(this.getAbstractLabel());
		sliderEClass.getESuperTypes().add(thePresentationPackage.getWidget());
		textFieldEClass.getESuperTypes().add(thePresentationPackage.getWidget());
		abstractButtonEClass.getESuperTypes().add(thePresentationPackage.getWidget());
		buttonEClass.getESuperTypes().add(this.getAbstractButton());
		abstractBooleanButtonEClass.getESuperTypes().add(this.getAbstractButton());
		booleanButtonEClass.getESuperTypes().add(this.getAbstractBooleanButton());
		booleanActionButtonEClass.getESuperTypes().add(this.getAbstractBooleanButton());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractLabelEClass, AbstractLabel.class, "AbstractLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractLabel_Text(), theEcorePackage.getEString(), "text", "", 0, 1, AbstractLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractLabel_FontScale(), theEcorePackage.getEFloat(), "fontScale", "1", 0, 1, AbstractLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dynamicRowLayoutEClass, DynamicRowLayout.class, "DynamicRowLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDynamicRowLayout_Height(), theEcorePackage.getEInt(), "height", "16", 0, 1, DynamicRowLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDynamicRowLayout_ColumnCount(), theEcorePackage.getEInt(), "columnCount", null, 0, 1, DynamicRowLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableLabelEClass, VariableLabel.class, "VariableLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableLabel_VariableResolver(), theVariablePackage.getAbstractVariableResolver(), null, "variableResolver", null, 0, 1, VariableLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(labelEClass, Label.class, "Label", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sliderEClass, Slider.class, "Slider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSlider_MinValue(), theEcorePackage.getEInt(), "minValue", "0", 0, 1, Slider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSlider_MaxValue(), theEcorePackage.getEInt(), "maxValue", "10", 0, 1, Slider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSlider_Step(), theEcorePackage.getEInt(), "step", "1", 0, 1, Slider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSlider_VariableResolver(), theVariablePackage.getAbstractVariableResolver(), null, "variableResolver", null, 1, 1, Slider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textFieldEClass, TextField.class, "TextField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTextField_VariableResolver(), theVariablePackage.getAbstractVariableResolver(), null, "variableResolver", null, 0, 1, TextField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractButtonEClass, AbstractButton.class, "AbstractButton", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractButton_Text(), theEcorePackage.getEString(), "text", "", 0, 1, AbstractButton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(buttonEClass, Button.class, "Button", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getButton_Shortcut(), theEcorePackage.getEInt(), "shortcut", null, 0, 1, Button.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getButton_State(), theTypesPackage.getEKeyState(), "state", null, 0, 1, Button.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getButton_Actions(), theActionPackage.getAction(), null, "actions", null, 0, -1, Button.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getButton__LActions(), theActionPackage.getActionList(), "lActions", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getButton__GetExecutor(), theRootPackage.getLObject(), "getExecutor", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(abstractBooleanButtonEClass, AbstractBooleanButton.class, "AbstractBooleanButton", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractBooleanButton_TextWhenTrue(), theEcorePackage.getEString(), "textWhenTrue", null, 0, 1, AbstractBooleanButton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractBooleanButton_TextWhenFalse(), theEcorePackage.getEString(), "textWhenFalse", null, 0, 1, AbstractBooleanButton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanButtonEClass, BooleanButton.class, "BooleanButton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBooleanButton_VariableResolver(), theVariablePackage.getAbstractVariableResolver(), null, "variableResolver", null, 0, 1, BooleanButton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanActionButtonEClass, BooleanActionButton.class, "BooleanActionButton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBooleanActionButton_ActionWhenTrue(), theActionPackage.getAction(), null, "actionWhenTrue", null, 0, 1, BooleanActionButton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBooleanActionButton_ActionWhenFalse(), theActionPackage.getAction(), null, "actionWhenFalse", null, 0, 1, BooleanActionButton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UiPackageImpl
