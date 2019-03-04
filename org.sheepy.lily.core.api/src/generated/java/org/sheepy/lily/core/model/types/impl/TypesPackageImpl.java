/**
 */
package org.sheepy.lily.core.model.types.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.api.types.SVector2f;
import org.sheepy.lily.core.api.types.SVector2i;

import org.sheepy.lily.core.api.types.SVector3f;
import org.sheepy.lily.core.model.types.BooleanParameter;
import org.sheepy.lily.core.model.types.EDirection;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EKeyState;
import org.sheepy.lily.core.model.types.EMouseButton;
import org.sheepy.lily.core.model.types.EMoveState;
import org.sheepy.lily.core.model.types.ENotificationDirection;
import org.sheepy.lily.core.model.types.ENumberComparisonType;
import org.sheepy.lily.core.model.types.ETimeUnit;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.FloatParameter;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.NativeParameter;
import org.sheepy.lily.core.model.types.Parameter;
import org.sheepy.lily.core.model.types.PositionFParameter;
import org.sheepy.lily.core.model.types.PositionParameter;
import org.sheepy.lily.core.model.types.StringParameter;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesPackageImpl extends EPackageImpl implements TypesPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionFParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nativeParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eNotificationDirectionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eMoveStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eDirectionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eTimeUnitEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eNumberComparisonTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eVerticalRelativeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eHorizontalRelativeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eMouseButtonEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eKeyStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sVector3fEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sVector2fEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sVector2iEDataType = null;

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
	 * @see org.sheepy.lily.core.model.types.TypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypesPackageImpl()
	{
		super(eNS_URI, TypesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypesPackage init()
	{
		if (isInited) return (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTypesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TypesPackageImpl theTypesPackage = registeredTypesPackage instanceof TypesPackageImpl ? (TypesPackageImpl)registeredTypesPackage : new TypesPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTypesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, theTypesPackage);
		return theTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLNamedElement()
	{
		return lNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLNamedElement_Name()
	{
		return (EAttribute)lNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameter()
	{
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPositionParameter()
	{
		return positionParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPositionParameter__GetPosition()
	{
		return positionParameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPositionFParameter()
	{
		return positionFParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPositionFParameter__GetPosition()
	{
		return positionFParameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNativeParameter()
	{
		return nativeParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNativeParameter__GetNativeValue()
	{
		return nativeParameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFloatParameter()
	{
		return floatParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFloatParameter_Value()
	{
		return (EAttribute)floatParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getFloatParameter__GetNativeValue()
	{
		return floatParameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringParameter()
	{
		return stringParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringParameter_Value()
	{
		return (EAttribute)stringParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getStringParameter__GetNativeValue()
	{
		return stringParameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanParameter()
	{
		return booleanParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBooleanParameter_Value()
	{
		return (EAttribute)booleanParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getBooleanParameter__GetNativeValue()
	{
		return booleanParameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getENotificationDirection()
	{
		return eNotificationDirectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEMoveState()
	{
		return eMoveStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEDirection()
	{
		return eDirectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getETimeUnit()
	{
		return eTimeUnitEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getENumberComparisonType()
	{
		return eNumberComparisonTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEVerticalRelative()
	{
		return eVerticalRelativeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEHorizontalRelative()
	{
		return eHorizontalRelativeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEMouseButton()
	{
		return eMouseButtonEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEKeyState()
	{
		return eKeyStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getSVector3f()
	{
		return sVector3fEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getSVector2f()
	{
		return sVector2fEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getSVector2i()
	{
		return sVector2iEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypesFactory getTypesFactory()
	{
		return (TypesFactory)getEFactoryInstance();
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
		lNamedElementEClass = createEClass(LNAMED_ELEMENT);
		createEAttribute(lNamedElementEClass, LNAMED_ELEMENT__NAME);

		parameterEClass = createEClass(PARAMETER);

		positionParameterEClass = createEClass(POSITION_PARAMETER);
		createEOperation(positionParameterEClass, POSITION_PARAMETER___GET_POSITION);

		positionFParameterEClass = createEClass(POSITION_FPARAMETER);
		createEOperation(positionFParameterEClass, POSITION_FPARAMETER___GET_POSITION);

		nativeParameterEClass = createEClass(NATIVE_PARAMETER);
		createEOperation(nativeParameterEClass, NATIVE_PARAMETER___GET_NATIVE_VALUE);

		floatParameterEClass = createEClass(FLOAT_PARAMETER);
		createEAttribute(floatParameterEClass, FLOAT_PARAMETER__VALUE);
		createEOperation(floatParameterEClass, FLOAT_PARAMETER___GET_NATIVE_VALUE);

		stringParameterEClass = createEClass(STRING_PARAMETER);
		createEAttribute(stringParameterEClass, STRING_PARAMETER__VALUE);
		createEOperation(stringParameterEClass, STRING_PARAMETER___GET_NATIVE_VALUE);

		booleanParameterEClass = createEClass(BOOLEAN_PARAMETER);
		createEAttribute(booleanParameterEClass, BOOLEAN_PARAMETER__VALUE);
		createEOperation(booleanParameterEClass, BOOLEAN_PARAMETER___GET_NATIVE_VALUE);

		// Create enums
		eNotificationDirectionEEnum = createEEnum(ENOTIFICATION_DIRECTION);
		eMoveStateEEnum = createEEnum(EMOVE_STATE);
		eDirectionEEnum = createEEnum(EDIRECTION);
		eTimeUnitEEnum = createEEnum(ETIME_UNIT);
		eNumberComparisonTypeEEnum = createEEnum(ENUMBER_COMPARISON_TYPE);
		eVerticalRelativeEEnum = createEEnum(EVERTICAL_RELATIVE);
		eHorizontalRelativeEEnum = createEEnum(EHORIZONTAL_RELATIVE);
		eMouseButtonEEnum = createEEnum(EMOUSE_BUTTON);
		eKeyStateEEnum = createEEnum(EKEY_STATE);

		// Create data types
		sVector3fEDataType = createEDataType(SVECTOR3F);
		sVector2fEDataType = createEDataType(SVECTOR2F);
		sVector2iEDataType = createEDataType(SVECTOR2I);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters
		ETypeParameter nativeParameterEClass_T = addETypeParameter(nativeParameterEClass, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		positionParameterEClass.getESuperTypes().add(this.getParameter());
		positionFParameterEClass.getESuperTypes().add(this.getParameter());
		nativeParameterEClass.getESuperTypes().add(this.getParameter());
		EGenericType g1 = createEGenericType(this.getNativeParameter());
		EGenericType g2 = createEGenericType(theEcorePackage.getEFloatObject());
		g1.getETypeArguments().add(g2);
		floatParameterEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getNativeParameter());
		g2 = createEGenericType(theEcorePackage.getEString());
		g1.getETypeArguments().add(g2);
		stringParameterEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getNativeParameter());
		g2 = createEGenericType(theEcorePackage.getEBooleanObject());
		g1.getETypeArguments().add(g2);
		booleanParameterEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(lNamedElementEClass, LNamedElement.class, "LNamedElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLNamedElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, LNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(positionParameterEClass, PositionParameter.class, "PositionParameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getPositionParameter__GetPosition(), this.getSVector2i(), "getPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(positionFParameterEClass, PositionFParameter.class, "PositionFParameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getPositionFParameter__GetPosition(), this.getSVector2f(), "getPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(nativeParameterEClass, NativeParameter.class, "NativeParameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getNativeParameter__GetNativeValue(), null, "getNativeValue", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(nativeParameterEClass_T);
		initEOperation(op, g1);

		initEClass(floatParameterEClass, FloatParameter.class, "FloatParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFloatParameter_Value(), theEcorePackage.getEFloatObject(), "value", null, 0, 1, FloatParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getFloatParameter__GetNativeValue(), theEcorePackage.getEFloatObject(), "getNativeValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(stringParameterEClass, StringParameter.class, "StringParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringParameter_Value(), theEcorePackage.getEString(), "value", null, 0, 1, StringParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getStringParameter__GetNativeValue(), theEcorePackage.getEString(), "getNativeValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(booleanParameterEClass, BooleanParameter.class, "BooleanParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanParameter_Value(), theEcorePackage.getEBooleanObject(), "value", null, 0, 1, BooleanParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getBooleanParameter__GetNativeValue(), theEcorePackage.getEBooleanObject(), "getNativeValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eNotificationDirectionEEnum, ENotificationDirection.class, "ENotificationDirection");
		addEEnumLiteral(eNotificationDirectionEEnum, ENotificationDirection.PARENT);
		addEEnumLiteral(eNotificationDirectionEEnum, ENotificationDirection.CHILDREN);
		addEEnumLiteral(eNotificationDirectionEEnum, ENotificationDirection.SELF);
		addEEnumLiteral(eNotificationDirectionEEnum, ENotificationDirection.ALL);

		initEEnum(eMoveStateEEnum, EMoveState.class, "EMoveState");
		addEEnumLiteral(eMoveStateEEnum, EMoveState.START_MOVING);
		addEEnumLiteral(eMoveStateEEnum, EMoveState.STOP_MOVING);

		initEEnum(eDirectionEEnum, EDirection.class, "EDirection");
		addEEnumLiteral(eDirectionEEnum, EDirection.UP);
		addEEnumLiteral(eDirectionEEnum, EDirection.LEFT);
		addEEnumLiteral(eDirectionEEnum, EDirection.RIGHT);
		addEEnumLiteral(eDirectionEEnum, EDirection.DOWN);

		initEEnum(eTimeUnitEEnum, ETimeUnit.class, "ETimeUnit");
		addEEnumLiteral(eTimeUnitEEnum, ETimeUnit.MILLISECOND);
		addEEnumLiteral(eTimeUnitEEnum, ETimeUnit.SECOND);
		addEEnumLiteral(eTimeUnitEEnum, ETimeUnit.MINUTE);
		addEEnumLiteral(eTimeUnitEEnum, ETimeUnit.HOUR);

		initEEnum(eNumberComparisonTypeEEnum, ENumberComparisonType.class, "ENumberComparisonType");
		addEEnumLiteral(eNumberComparisonTypeEEnum, ENumberComparisonType.EQUAL);
		addEEnumLiteral(eNumberComparisonTypeEEnum, ENumberComparisonType.INF_OR_EQUAL);
		addEEnumLiteral(eNumberComparisonTypeEEnum, ENumberComparisonType.SUP_OR_EQUAL);
		addEEnumLiteral(eNumberComparisonTypeEEnum, ENumberComparisonType.INF);
		addEEnumLiteral(eNumberComparisonTypeEEnum, ENumberComparisonType.SUP);

		initEEnum(eVerticalRelativeEEnum, EVerticalRelative.class, "EVerticalRelative");
		addEEnumLiteral(eVerticalRelativeEEnum, EVerticalRelative.BOTTOM);
		addEEnumLiteral(eVerticalRelativeEEnum, EVerticalRelative.MIDDLE);
		addEEnumLiteral(eVerticalRelativeEEnum, EVerticalRelative.TOP);

		initEEnum(eHorizontalRelativeEEnum, EHorizontalRelative.class, "EHorizontalRelative");
		addEEnumLiteral(eHorizontalRelativeEEnum, EHorizontalRelative.LEFT);
		addEEnumLiteral(eHorizontalRelativeEEnum, EHorizontalRelative.MIDDLE);
		addEEnumLiteral(eHorizontalRelativeEEnum, EHorizontalRelative.RIGHT);

		initEEnum(eMouseButtonEEnum, EMouseButton.class, "EMouseButton");
		addEEnumLiteral(eMouseButtonEEnum, EMouseButton.RIGHT);
		addEEnumLiteral(eMouseButtonEEnum, EMouseButton.LEFT);
		addEEnumLiteral(eMouseButtonEEnum, EMouseButton.MIDDLE);
		addEEnumLiteral(eMouseButtonEEnum, EMouseButton._4);
		addEEnumLiteral(eMouseButtonEEnum, EMouseButton._5);
		addEEnumLiteral(eMouseButtonEEnum, EMouseButton._6);
		addEEnumLiteral(eMouseButtonEEnum, EMouseButton._7);
		addEEnumLiteral(eMouseButtonEEnum, EMouseButton._8);

		initEEnum(eKeyStateEEnum, EKeyState.class, "EKeyState");
		addEEnumLiteral(eKeyStateEEnum, EKeyState.RELEASED);
		addEEnumLiteral(eKeyStateEEnum, EKeyState.PRESSED);
		addEEnumLiteral(eKeyStateEEnum, EKeyState.REPEATED);

		// Initialize data types
		initEDataType(sVector3fEDataType, SVector3f.class, "SVector3f", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(sVector2fEDataType, SVector2f.class, "SVector2f", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(sVector2iEDataType, SVector2i.class, "SVector2i", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TypesPackageImpl
