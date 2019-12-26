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
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector2ic;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Vector3ic;
import org.joml.Vector4dc;
import org.joml.Vector4fc;

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

import org.sheepy.lily.core.model.presentation.PresentationPackage;

import org.sheepy.lily.core.model.presentation.impl.PresentationPackageImpl;
import org.sheepy.lily.core.model.types.BooleanParameter;
import org.sheepy.lily.core.model.types.ECharTable;
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
	private EEnum eCharTableEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType vector4dEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType vector4fEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType color4fEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType color3fEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType vector3dEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType vector3fEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType vector3iEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType vector2fEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType vector2iEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType vector2dEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javaModuleEDataType = null;

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

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);
		UiPackageImpl theUiPackage = (UiPackageImpl)(registeredPackage instanceof UiPackageImpl ? registeredPackage : UiPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI);
		PresentationPackageImpl thePresentationPackage = (PresentationPackageImpl)(registeredPackage instanceof PresentationPackageImpl ? registeredPackage : PresentationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);
		ApplicationPackageImpl theApplicationPackage = (ApplicationPackageImpl)(registeredPackage instanceof ApplicationPackageImpl ? registeredPackage : ApplicationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);
		VariablePackageImpl theVariablePackage = (VariablePackageImpl)(registeredPackage instanceof VariablePackageImpl ? registeredPackage : VariablePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InferencePackage.eNS_URI);
		InferencePackageImpl theInferencePackage = (InferencePackageImpl)(registeredPackage instanceof InferencePackageImpl ? registeredPackage : InferencePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MaintainerPackage.eNS_URI);
		MaintainerPackageImpl theMaintainerPackage = (MaintainerPackageImpl)(registeredPackage instanceof MaintainerPackageImpl ? registeredPackage : MaintainerPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CadencePackage.eNS_URI);
		CadencePackageImpl theCadencePackage = (CadencePackageImpl)(registeredPackage instanceof CadencePackageImpl ? registeredPackage : CadencePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);
		ActionPackageImpl theActionPackage = (ActionPackageImpl)(registeredPackage instanceof ActionPackageImpl ? registeredPackage : ActionPackage.eINSTANCE);

		// Create package meta-data objects
		theTypesPackage.createPackageContents();
		theUiPackage.createPackageContents();
		thePresentationPackage.createPackageContents();
		theApplicationPackage.createPackageContents();
		theVariablePackage.createPackageContents();
		theInferencePackage.createPackageContents();
		theMaintainerPackage.createPackageContents();
		theCadencePackage.createPackageContents();
		theActionPackage.createPackageContents();

		// Initialize created meta-data
		theTypesPackage.initializePackageContents();
		theUiPackage.initializePackageContents();
		thePresentationPackage.initializePackageContents();
		theApplicationPackage.initializePackageContents();
		theVariablePackage.initializePackageContents();
		theInferencePackage.initializePackageContents();
		theMaintainerPackage.initializePackageContents();
		theCadencePackage.initializePackageContents();
		theActionPackage.initializePackageContents();

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
	public EEnum getECharTable()
	{
		return eCharTableEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getVector4d()
	{
		return vector4dEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getVector4f()
	{
		return vector4fEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getColor4f()
	{
		return color4fEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getColor3f()
	{
		return color3fEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getVector3d()
	{
		return vector3dEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getVector3f()
	{
		return vector3fEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getVector3i()
	{
		return vector3iEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getVector2f()
	{
		return vector2fEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getVector2i()
	{
		return vector2iEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getVector2d()
	{
		return vector2dEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getJavaModule()
	{
		return javaModuleEDataType;
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
		eCharTableEEnum = createEEnum(ECHAR_TABLE);

		// Create data types
		vector4dEDataType = createEDataType(VECTOR4D);
		vector4fEDataType = createEDataType(VECTOR4F);
		color4fEDataType = createEDataType(COLOR4F);
		color3fEDataType = createEDataType(COLOR3F);
		vector3dEDataType = createEDataType(VECTOR3D);
		vector3fEDataType = createEDataType(VECTOR3F);
		vector3iEDataType = createEDataType(VECTOR3I);
		vector2fEDataType = createEDataType(VECTOR2F);
		vector2iEDataType = createEDataType(VECTOR2I);
		vector2dEDataType = createEDataType(VECTOR2D);
		javaModuleEDataType = createEDataType(JAVA_MODULE);
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

		// Create type parameters
		ETypeParameter nativeParameterEClass_T = addETypeParameter(nativeParameterEClass, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		positionParameterEClass.getESuperTypes().add(this.getParameter());
		positionFParameterEClass.getESuperTypes().add(this.getParameter());
		nativeParameterEClass.getESuperTypes().add(this.getParameter());
		EGenericType g1 = createEGenericType(this.getNativeParameter());
		EGenericType g2 = createEGenericType(ecorePackage.getEFloatObject());
		g1.getETypeArguments().add(g2);
		floatParameterEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getNativeParameter());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		stringParameterEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getNativeParameter());
		g2 = createEGenericType(ecorePackage.getEBooleanObject());
		g1.getETypeArguments().add(g2);
		booleanParameterEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(lNamedElementEClass, LNamedElement.class, "LNamedElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, LNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(positionParameterEClass, PositionParameter.class, "PositionParameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getPositionParameter__GetPosition(), this.getVector2i(), "getPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(positionFParameterEClass, PositionFParameter.class, "PositionFParameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getPositionFParameter__GetPosition(), this.getVector2f(), "getPosition", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(nativeParameterEClass, NativeParameter.class, "NativeParameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getNativeParameter__GetNativeValue(), null, "getNativeValue", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(nativeParameterEClass_T);
		initEOperation(op, g1);

		initEClass(floatParameterEClass, FloatParameter.class, "FloatParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFloatParameter_Value(), ecorePackage.getEFloat(), "value", null, 0, 1, FloatParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getFloatParameter__GetNativeValue(), ecorePackage.getEFloatObject(), "getNativeValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(stringParameterEClass, StringParameter.class, "StringParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringParameter_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getStringParameter__GetNativeValue(), ecorePackage.getEString(), "getNativeValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(booleanParameterEClass, BooleanParameter.class, "BooleanParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanParameter_Value(), ecorePackage.getEBooleanObject(), "value", null, 0, 1, BooleanParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getBooleanParameter__GetNativeValue(), ecorePackage.getEBooleanObject(), "getNativeValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

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
		addEEnumLiteral(eTimeUnitEEnum, ETimeUnit.NANOSECONDS);
		addEEnumLiteral(eTimeUnitEEnum, ETimeUnit.MICROSECONDS);
		addEEnumLiteral(eTimeUnitEEnum, ETimeUnit.MILLISECONDS);
		addEEnumLiteral(eTimeUnitEEnum, ETimeUnit.SECONDS);
		addEEnumLiteral(eTimeUnitEEnum, ETimeUnit.MINUTES);
		addEEnumLiteral(eTimeUnitEEnum, ETimeUnit.HOURS);
		addEEnumLiteral(eTimeUnitEEnum, ETimeUnit.DAYS);

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

		initEEnum(eCharTableEEnum, ECharTable.class, "ECharTable");
		addEEnumLiteral(eCharTableEEnum, ECharTable.BASE);
		addEEnumLiteral(eCharTableEEnum, ECharTable.EXTENDED);
		addEEnumLiteral(eCharTableEEnum, ECharTable.CHINESE);

		// Initialize data types
		initEDataType(vector4dEDataType, Vector4dc.class, "Vector4d", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(vector4fEDataType, Vector4fc.class, "Vector4f", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(color4fEDataType, Vector4fc.class, "Color4f", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(color3fEDataType, Vector3fc.class, "Color3f", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(vector3dEDataType, Vector3dc.class, "Vector3d", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(vector3fEDataType, Vector3fc.class, "Vector3f", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(vector3iEDataType, Vector3ic.class, "Vector3i", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(vector2fEDataType, Vector2fc.class, "Vector2f", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(vector2iEDataType, Vector2ic.class, "Vector2i", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(vector2dEDataType, Vector2dc.class, "Vector2d", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(javaModuleEDataType, Module.class, "JavaModule", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TypesPackageImpl
