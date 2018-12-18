/**
 */
package org.sheepy.common.model.presentation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.common.model.action.ActionPackage;

import org.sheepy.common.model.application.ApplicationPackage;

import org.sheepy.common.model.inference.InferencePackage;

import org.sheepy.common.model.presentation.IControl;
import org.sheepy.common.model.presentation.IMusicView;
import org.sheepy.common.model.presentation.IRelativeElement;
import org.sheepy.common.model.presentation.ISizedElement;
import org.sheepy.common.model.presentation.ISizedView;
import org.sheepy.common.model.presentation.IUIElement;
import org.sheepy.common.model.presentation.IUIView;
import org.sheepy.common.model.presentation.Panel;
import org.sheepy.common.model.presentation.PresentationFactory;
import org.sheepy.common.model.presentation.PresentationPackage;
import org.sheepy.common.model.presentation.TranparentUIView;
import org.sheepy.common.model.presentation.UIPage;
import org.sheepy.common.model.presentation.Widget;

import org.sheepy.common.model.root.RootPackage;

import org.sheepy.common.model.types.TypesPackage;

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
	private EClass iSizedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iRelativeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iuiViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tranparentUIViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iMusicViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSizedViewEClass = null;

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
	private EClass panelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iControlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass widgetEClass = null;

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
	 * @see org.sheepy.common.model.presentation.PresentationPackage#eNS_URI
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

		// Initialize simple dependencies
		RootPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePresentationPackage.createPackageContents();

		// Initialize created meta-data
		thePresentationPackage.initializePackageContents();

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
	public EAttribute getISizedElement_Position()
	{
		return (EAttribute)iSizedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getISizedElement_Width()
	{
		return (EAttribute)iSizedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getISizedElement_Height()
	{
		return (EAttribute)iSizedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIRelativeElement()
	{
		return iRelativeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIRelativeElement_VerticalRelative()
	{
		return (EAttribute)iRelativeElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIRelativeElement_HorizontalRelative()
	{
		return (EAttribute)iRelativeElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIUIView()
	{
		return iuiViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIUIView_UiPages()
	{
		return (EReference)iuiViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIUIView_CurrentUIPage()
	{
		return (EReference)iuiViewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTranparentUIView()
	{
		return tranparentUIViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIMusicView()
	{
		return iMusicViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIMusicView_MusicPath()
	{
		return (EAttribute)iMusicViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getISizedView()
	{
		return iSizedViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getISizedView_Moveable()
	{
		return (EAttribute)iSizedViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getISizedView_Closeable()
	{
		return (EAttribute)iSizedViewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getISizedView_Scalable()
	{
		return (EAttribute)iSizedViewEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getISizedView_ShowTitle()
	{
		return (EAttribute)iSizedViewEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getISizedView_Fullscreen()
	{
		return (EAttribute)iSizedViewEClass.getEStructuralFeatures().get(4);
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
	public EClass getPanel()
	{
		return panelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPanel_Controls()
	{
		return (EReference)panelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIControl()
	{
		return iControlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWidget()
	{
		return widgetEClass;
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
		iSizedElementEClass = createEClass(ISIZED_ELEMENT);
		createEAttribute(iSizedElementEClass, ISIZED_ELEMENT__POSITION);
		createEAttribute(iSizedElementEClass, ISIZED_ELEMENT__WIDTH);
		createEAttribute(iSizedElementEClass, ISIZED_ELEMENT__HEIGHT);

		iRelativeElementEClass = createEClass(IRELATIVE_ELEMENT);
		createEAttribute(iRelativeElementEClass, IRELATIVE_ELEMENT__VERTICAL_RELATIVE);
		createEAttribute(iRelativeElementEClass, IRELATIVE_ELEMENT__HORIZONTAL_RELATIVE);

		iuiViewEClass = createEClass(IUI_VIEW);
		createEReference(iuiViewEClass, IUI_VIEW__UI_PAGES);
		createEReference(iuiViewEClass, IUI_VIEW__CURRENT_UI_PAGE);

		tranparentUIViewEClass = createEClass(TRANPARENT_UI_VIEW);

		iMusicViewEClass = createEClass(IMUSIC_VIEW);
		createEAttribute(iMusicViewEClass, IMUSIC_VIEW__MUSIC_PATH);

		iSizedViewEClass = createEClass(ISIZED_VIEW);
		createEAttribute(iSizedViewEClass, ISIZED_VIEW__MOVEABLE);
		createEAttribute(iSizedViewEClass, ISIZED_VIEW__CLOSEABLE);
		createEAttribute(iSizedViewEClass, ISIZED_VIEW__SCALABLE);
		createEAttribute(iSizedViewEClass, ISIZED_VIEW__SHOW_TITLE);
		createEAttribute(iSizedViewEClass, ISIZED_VIEW__FULLSCREEN);

		iuiElementEClass = createEClass(IUI_ELEMENT);

		uiPageEClass = createEClass(UI_PAGE);
		createEReference(uiPageEClass, UI_PAGE__PANELS);

		panelEClass = createEClass(PANEL);
		createEReference(panelEClass, PANEL__CONTROLS);

		iControlEClass = createEClass(ICONTROL);

		widgetEClass = createEClass(WIDGET);
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
		RootPackage theRootPackage = (RootPackage)EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ApplicationPackage theApplicationPackage = (ApplicationPackage)EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		iSizedElementEClass.getESuperTypes().add(theRootPackage.getLObject());
		iRelativeElementEClass.getESuperTypes().add(theRootPackage.getLObject());
		iuiViewEClass.getESuperTypes().add(theApplicationPackage.getIView());
		tranparentUIViewEClass.getESuperTypes().add(this.getIUIView());
		iMusicViewEClass.getESuperTypes().add(theApplicationPackage.getIView());
		iSizedViewEClass.getESuperTypes().add(this.getISizedElement());
		iSizedViewEClass.getESuperTypes().add(theApplicationPackage.getIView());
		iuiElementEClass.getESuperTypes().add(theRootPackage.getLObject());
		uiPageEClass.getESuperTypes().add(this.getISizedElement());
		panelEClass.getESuperTypes().add(this.getIUIElement());
		panelEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		panelEClass.getESuperTypes().add(this.getIRelativeElement());
		panelEClass.getESuperTypes().add(this.getISizedElement());
		iControlEClass.getESuperTypes().add(this.getIUIElement());
		widgetEClass.getESuperTypes().add(this.getIControl());
		widgetEClass.getESuperTypes().add(this.getIUIElement());
		widgetEClass.getESuperTypes().add(this.getIRelativeElement());
		widgetEClass.getESuperTypes().add(this.getISizedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(iSizedElementEClass, ISizedElement.class, "ISizedElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getISizedElement_Position(), theTypesPackage.getSVector2i(), "position", "0;0", 0, 1, ISizedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getISizedElement_Width(), theEcorePackage.getEInt(), "width", null, 0, 1, ISizedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getISizedElement_Height(), theEcorePackage.getEInt(), "height", null, 0, 1, ISizedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iRelativeElementEClass, IRelativeElement.class, "IRelativeElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIRelativeElement_VerticalRelative(), theTypesPackage.getEVerticalRelative(), "verticalRelative", "TOP", 0, 1, IRelativeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIRelativeElement_HorizontalRelative(), theTypesPackage.getEHorizontalRelative(), "horizontalRelative", "LEFT", 0, 1, IRelativeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iuiViewEClass, IUIView.class, "IUIView", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIUIView_UiPages(), this.getUIPage(), null, "uiPages", null, 0, -1, IUIView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIUIView_CurrentUIPage(), this.getUIPage(), null, "currentUIPage", null, 0, 1, IUIView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tranparentUIViewEClass, TranparentUIView.class, "TranparentUIView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iMusicViewEClass, IMusicView.class, "IMusicView", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIMusicView_MusicPath(), theEcorePackage.getEString(), "musicPath", "", 0, 1, IMusicView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iSizedViewEClass, ISizedView.class, "ISizedView", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getISizedView_Moveable(), theEcorePackage.getEBoolean(), "moveable", "false", 0, 1, ISizedView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getISizedView_Closeable(), theEcorePackage.getEBoolean(), "closeable", "false", 0, 1, ISizedView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getISizedView_Scalable(), theEcorePackage.getEBoolean(), "scalable", "false", 0, 1, ISizedView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getISizedView_ShowTitle(), theEcorePackage.getEBoolean(), "showTitle", "false", 0, 1, ISizedView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getISizedView_Fullscreen(), theEcorePackage.getEBoolean(), "fullscreen", "true", 0, 1, ISizedView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iuiElementEClass, IUIElement.class, "IUIElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uiPageEClass, UIPage.class, "UIPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUIPage_Panels(), this.getPanel(), null, "panels", null, 0, -1, UIPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(panelEClass, Panel.class, "Panel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPanel_Controls(), this.getIControl(), null, "controls", null, 0, -1, Panel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iControlEClass, IControl.class, "IControl", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(widgetEClass, Widget.class, "Widget", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //PresentationPackageImpl
