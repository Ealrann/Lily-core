/**
 */
package org.sheepy.lily.core.model.presentation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.action.impl.ActionPackageImpl;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.application.impl.ApplicationPackageImpl;

import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl;
import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.inference.impl.InferencePackageImpl;

import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

import org.sheepy.lily.core.model.maintainer.impl.MaintainerPackageImpl;
import org.sheepy.lily.core.model.presentation.IPanel;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.presentation.IUIElement;
import org.sheepy.lily.core.model.presentation.PresentationFactory;
import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.core.model.presentation.UIPage;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.types.impl.TypesPackageImpl;

import org.sheepy.lily.core.model.ui.UiPackage;

import org.sheepy.lily.core.model.ui.impl.UiPackageImpl;

import org.sheepy.lily.core.model.variable.VariablePackage;

import org.sheepy.lily.core.model.variable.impl.VariablePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PresentationPackageImpl extends EPackageImpl implements PresentationPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPositionElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSizedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iuiElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uiPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPanelEClass = null;

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
	 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PresentationPackageImpl()
	{
		super(eNS_URI, PresentationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PresentationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PresentationPackage init()
	{
		if (isInited) return (PresentationPackage)EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPresentationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PresentationPackageImpl thePresentationPackage = registeredPresentationPackage instanceof PresentationPackageImpl ? (PresentationPackageImpl)registeredPresentationPackage : new PresentationPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);
		UiPackageImpl theUiPackage = (UiPackageImpl)(registeredPackage instanceof UiPackageImpl ? registeredPackage : UiPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);
		ApplicationPackageImpl theApplicationPackage = (ApplicationPackageImpl)(registeredPackage instanceof ApplicationPackageImpl ? registeredPackage : ApplicationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);
		VariablePackageImpl theVariablePackage = (VariablePackageImpl)(registeredPackage instanceof VariablePackageImpl ? registeredPackage : VariablePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(registeredPackage instanceof TypesPackageImpl ? registeredPackage : TypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InferencePackage.eNS_URI);
		InferencePackageImpl theInferencePackage = (InferencePackageImpl)(registeredPackage instanceof InferencePackageImpl ? registeredPackage : InferencePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MaintainerPackage.eNS_URI);
		MaintainerPackageImpl theMaintainerPackage = (MaintainerPackageImpl)(registeredPackage instanceof MaintainerPackageImpl ? registeredPackage : MaintainerPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CadencePackage.eNS_URI);
		CadencePackageImpl theCadencePackage = (CadencePackageImpl)(registeredPackage instanceof CadencePackageImpl ? registeredPackage : CadencePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);
		ActionPackageImpl theActionPackage = (ActionPackageImpl)(registeredPackage instanceof ActionPackageImpl ? registeredPackage : ActionPackage.eINSTANCE);

		// Create package meta-data objects
		thePresentationPackage.createPackageContents();
		theUiPackage.createPackageContents();
		theApplicationPackage.createPackageContents();
		theVariablePackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theInferencePackage.createPackageContents();
		theMaintainerPackage.createPackageContents();
		theCadencePackage.createPackageContents();
		theActionPackage.createPackageContents();

		// Initialize created meta-data
		thePresentationPackage.initializePackageContents();
		theUiPackage.initializePackageContents();
		theApplicationPackage.initializePackageContents();
		theVariablePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theInferencePackage.initializePackageContents();
		theMaintainerPackage.initializePackageContents();
		theCadencePackage.initializePackageContents();
		theActionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePresentationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PresentationPackage.eNS_URI, thePresentationPackage);
		return thePresentationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIPositionElement()
	{
		return iPositionElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIPositionElement_Position()
	{
		return (EAttribute)iPositionElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIPositionElement_VerticalRelative()
	{
		return (EAttribute)iPositionElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIPositionElement_HorizontalRelative()
	{
		return (EAttribute)iPositionElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getISizedElement()
	{
		return iSizedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getISizedElement_Width()
	{
		return (EAttribute)iSizedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getISizedElement_Height()
	{
		return (EAttribute)iSizedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUI()
	{
		return uiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUI_UiPages()
	{
		return (EReference)uiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUI_CurrentUIPage()
	{
		return (EReference)uiEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIUIElement()
	{
		return iuiElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUIPage()
	{
		return uiPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUIPage_Panels()
	{
		return (EReference)uiPageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIPanel()
	{
		return iPanelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PresentationFactory getPresentationFactory()
	{
		return (PresentationFactory)getEFactoryInstance();
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
		iPositionElementEClass = createEClass(IPOSITION_ELEMENT);
		createEAttribute(iPositionElementEClass, IPOSITION_ELEMENT__POSITION);
		createEAttribute(iPositionElementEClass, IPOSITION_ELEMENT__VERTICAL_RELATIVE);
		createEAttribute(iPositionElementEClass, IPOSITION_ELEMENT__HORIZONTAL_RELATIVE);

		iSizedElementEClass = createEClass(ISIZED_ELEMENT);
		createEAttribute(iSizedElementEClass, ISIZED_ELEMENT__WIDTH);
		createEAttribute(iSizedElementEClass, ISIZED_ELEMENT__HEIGHT);

		uiEClass = createEClass(UI);
		createEReference(uiEClass, UI__UI_PAGES);
		createEReference(uiEClass, UI__CURRENT_UI_PAGE);

		iuiElementEClass = createEClass(IUI_ELEMENT);

		uiPageEClass = createEClass(UI_PAGE);
		createEReference(uiPageEClass, UI_PAGE__PANELS);

		iPanelEClass = createEClass(IPANEL);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		ApplicationPackage theApplicationPackage = (ApplicationPackage)EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);
		InferencePackage theInferencePackage = (InferencePackage)EPackage.Registry.INSTANCE.getEPackage(InferencePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		iSizedElementEClass.getESuperTypes().add(this.getIPositionElement());
		uiEClass.getESuperTypes().add(theApplicationPackage.getIScenePart());
		iuiElementEClass.getESuperTypes().add(theInferencePackage.getIInferenceObject());
		uiPageEClass.getESuperTypes().add(this.getISizedElement());
		iPanelEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		iPanelEClass.getESuperTypes().add(this.getIUIElement());
		iPanelEClass.getESuperTypes().add(this.getIPositionElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(iPositionElementEClass, IPositionElement.class, "IPositionElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIPositionElement_Position(), theTypesPackage.getVector2i(), "position", "0;0", 0, 1, IPositionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIPositionElement_VerticalRelative(), theTypesPackage.getEVerticalRelative(), "verticalRelative", "TOP", 0, 1, IPositionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIPositionElement_HorizontalRelative(), theTypesPackage.getEHorizontalRelative(), "horizontalRelative", "LEFT", 0, 1, IPositionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iSizedElementEClass, ISizedElement.class, "ISizedElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getISizedElement_Width(), ecorePackage.getEInt(), "width", null, 0, 1, ISizedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getISizedElement_Height(), ecorePackage.getEInt(), "height", null, 0, 1, ISizedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uiEClass, org.sheepy.lily.core.model.presentation.UI.class, "UI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUI_UiPages(), this.getUIPage(), null, "uiPages", null, 0, -1, org.sheepy.lily.core.model.presentation.UI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUI_CurrentUIPage(), this.getUIPage(), null, "currentUIPage", null, 0, 1, org.sheepy.lily.core.model.presentation.UI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iuiElementEClass, IUIElement.class, "IUIElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uiPageEClass, UIPage.class, "UIPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUIPage_Panels(), this.getIPanel(), null, "panels", null, 0, -1, UIPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iPanelEClass, IPanel.class, "IPanel", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //PresentationPackageImpl
