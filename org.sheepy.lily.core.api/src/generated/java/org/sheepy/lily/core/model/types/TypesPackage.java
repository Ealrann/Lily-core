/**
 */
package org.sheepy.lily.core.model.types;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.core.model.types.TypesFactory
 * @model kind="package"
 * @generated
 */
public interface TypesPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "types";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.core.model.types";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "types";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesPackage eINSTANCE = org.sheepy.lily.core.model.types.impl.TypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.LNamedElement <em>LNamed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.LNamedElement
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getLNamedElement()
	 * @generated
	 */
	int LNAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LNAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>LNamed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LNAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>LNamed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LNAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.Parameter <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.Parameter
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 1;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.PositionParameter <em>Position Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.PositionParameter
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getPositionParameter()
	 * @generated
	 */
	int POSITION_PARAMETER = 2;

	/**
	 * The number of structural features of the '<em>Position Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_PARAMETER___GET_POSITION = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Position Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.PositionFParameter <em>Position FParameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.PositionFParameter
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getPositionFParameter()
	 * @generated
	 */
	int POSITION_FPARAMETER = 3;

	/**
	 * The number of structural features of the '<em>Position FParameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_FPARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Position</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_FPARAMETER___GET_POSITION = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Position FParameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_FPARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.NativeParameter <em>Native Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.NativeParameter
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getNativeParameter()
	 * @generated
	 */
	int NATIVE_PARAMETER = 4;

	/**
	 * The number of structural features of the '<em>Native Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Native Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_PARAMETER___GET_NATIVE_VALUE = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Native Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.impl.FloatParameterImpl <em>Float Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.impl.FloatParameterImpl
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getFloatParameter()
	 * @generated
	 */
	int FLOAT_PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_PARAMETER__VALUE = NATIVE_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Float Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_PARAMETER_FEATURE_COUNT = NATIVE_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Native Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_PARAMETER___GET_NATIVE_VALUE = NATIVE_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Float Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_PARAMETER_OPERATION_COUNT = NATIVE_PARAMETER_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.impl.StringParameterImpl <em>String Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.impl.StringParameterImpl
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getStringParameter()
	 * @generated
	 */
	int STRING_PARAMETER = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER__VALUE = NATIVE_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER_FEATURE_COUNT = NATIVE_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Native Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER___GET_NATIVE_VALUE = NATIVE_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>String Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER_OPERATION_COUNT = NATIVE_PARAMETER_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.impl.BooleanParameterImpl <em>Boolean Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.impl.BooleanParameterImpl
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getBooleanParameter()
	 * @generated
	 */
	int BOOLEAN_PARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER__VALUE = NATIVE_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER_FEATURE_COUNT = NATIVE_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Native Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER___GET_NATIVE_VALUE = NATIVE_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER_OPERATION_COUNT = NATIVE_PARAMETER_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.ENotificationDirection <em>ENotification Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.ENotificationDirection
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getENotificationDirection()
	 * @generated
	 */
	int ENOTIFICATION_DIRECTION = 8;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.EMoveState <em>EMove State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.EMoveState
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getEMoveState()
	 * @generated
	 */
	int EMOVE_STATE = 9;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.EDirection <em>EDirection</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.EDirection
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getEDirection()
	 * @generated
	 */
	int EDIRECTION = 10;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.ETimeUnit <em>ETime Unit</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.ETimeUnit
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getETimeUnit()
	 * @generated
	 */
	int ETIME_UNIT = 11;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.ENumberComparisonType <em>ENumber Comparison Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.ENumberComparisonType
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getENumberComparisonType()
	 * @generated
	 */
	int ENUMBER_COMPARISON_TYPE = 12;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.ERelative <em>ERelative</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.ERelative
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getERelative()
	 * @generated
	 */
	int ERELATIVE = 13;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.EVerticalRelative <em>EVertical Relative</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.EVerticalRelative
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getEVerticalRelative()
	 * @generated
	 */
	int EVERTICAL_RELATIVE = 14;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.EHorizontalRelative <em>EHorizontal Relative</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.EHorizontalRelative
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getEHorizontalRelative()
	 * @generated
	 */
	int EHORIZONTAL_RELATIVE = 15;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.EMouseButton <em>EMouse Button</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.EMouseButton
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getEMouseButton()
	 * @generated
	 */
	int EMOUSE_BUTTON = 16;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.EKeyState <em>EKey State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.EKeyState
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getEKeyState()
	 * @generated
	 */
	int EKEY_STATE = 17;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.types.ECharTable <em>EChar Table</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.types.ECharTable
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getECharTable()
	 * @generated
	 */
	int ECHAR_TABLE = 18;

	/**
	 * The meta object id for the '<em>Vector4d</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joml.Vector4dc
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector4d()
	 * @generated
	 */
	int VECTOR4D = 19;

	/**
	 * The meta object id for the '<em>Vector4f</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joml.Vector4fc
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector4f()
	 * @generated
	 */
	int VECTOR4F = 20;

	/**
	 * The meta object id for the '<em>Vector4i</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joml.Vector4ic
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector4i()
	 * @generated
	 */
	int VECTOR4I = 21;

	/**
	 * The meta object id for the '<em>Color4f</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joml.Vector4fc
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getColor4f()
	 * @generated
	 */
	int COLOR4F = 22;

	/**
	 * The meta object id for the '<em>Color3f</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joml.Vector3fc
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getColor3f()
	 * @generated
	 */
	int COLOR3F = 23;

	/**
	 * The meta object id for the '<em>Vector3d</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joml.Vector3dc
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector3d()
	 * @generated
	 */
	int VECTOR3D = 24;

	/**
	 * The meta object id for the '<em>Vector3f</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joml.Vector3fc
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector3f()
	 * @generated
	 */
	int VECTOR3F = 25;

	/**
	 * The meta object id for the '<em>Vector3i</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joml.Vector3ic
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector3i()
	 * @generated
	 */
	int VECTOR3I = 26;

	/**
	 * The meta object id for the '<em>Vector2f</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joml.Vector2fc
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector2f()
	 * @generated
	 */
	int VECTOR2F = 27;

	/**
	 * The meta object id for the '<em>Vector2i</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joml.Vector2ic
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector2i()
	 * @generated
	 */
	int VECTOR2I = 28;

	/**
	 * The meta object id for the '<em>Vector2d</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joml.Vector2dc
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector2d()
	 * @generated
	 */
	int VECTOR2D = 29;

	/**
	 * The meta object id for the '<em>Java Module</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Module
	 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getJavaModule()
	 * @generated
	 */
	int JAVA_MODULE = 30;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.types.LNamedElement <em>LNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LNamed Element</em>'.
	 * @see org.sheepy.lily.core.model.types.LNamedElement
	 * @generated
	 */
	EClass getLNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.types.LNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sheepy.lily.core.model.types.LNamedElement#getName()
	 * @see #getLNamedElement()
	 * @generated
	 */
	EAttribute getLNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.types.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.sheepy.lily.core.model.types.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.types.PositionParameter <em>Position Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Position Parameter</em>'.
	 * @see org.sheepy.lily.core.model.types.PositionParameter
	 * @generated
	 */
	EClass getPositionParameter();

	/**
	 * Returns the meta object for the '{@link org.sheepy.lily.core.model.types.PositionParameter#getPosition() <em>Get Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Position</em>' operation.
	 * @see org.sheepy.lily.core.model.types.PositionParameter#getPosition()
	 * @generated
	 */
	EOperation getPositionParameter__GetPosition();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.types.PositionFParameter <em>Position FParameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Position FParameter</em>'.
	 * @see org.sheepy.lily.core.model.types.PositionFParameter
	 * @generated
	 */
	EClass getPositionFParameter();

	/**
	 * Returns the meta object for the '{@link org.sheepy.lily.core.model.types.PositionFParameter#getPosition() <em>Get Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Position</em>' operation.
	 * @see org.sheepy.lily.core.model.types.PositionFParameter#getPosition()
	 * @generated
	 */
	EOperation getPositionFParameter__GetPosition();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.types.NativeParameter <em>Native Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Native Parameter</em>'.
	 * @see org.sheepy.lily.core.model.types.NativeParameter
	 * @generated
	 */
	EClass getNativeParameter();

	/**
	 * Returns the meta object for the '{@link org.sheepy.lily.core.model.types.NativeParameter#getNativeValue() <em>Get Native Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Native Value</em>' operation.
	 * @see org.sheepy.lily.core.model.types.NativeParameter#getNativeValue()
	 * @generated
	 */
	EOperation getNativeParameter__GetNativeValue();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.types.FloatParameter <em>Float Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float Parameter</em>'.
	 * @see org.sheepy.lily.core.model.types.FloatParameter
	 * @generated
	 */
	EClass getFloatParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.types.FloatParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.sheepy.lily.core.model.types.FloatParameter#getValue()
	 * @see #getFloatParameter()
	 * @generated
	 */
	EAttribute getFloatParameter_Value();

	/**
	 * Returns the meta object for the '{@link org.sheepy.lily.core.model.types.FloatParameter#getNativeValue() <em>Get Native Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Native Value</em>' operation.
	 * @see org.sheepy.lily.core.model.types.FloatParameter#getNativeValue()
	 * @generated
	 */
	EOperation getFloatParameter__GetNativeValue();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.types.StringParameter <em>String Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Parameter</em>'.
	 * @see org.sheepy.lily.core.model.types.StringParameter
	 * @generated
	 */
	EClass getStringParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.types.StringParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.sheepy.lily.core.model.types.StringParameter#getValue()
	 * @see #getStringParameter()
	 * @generated
	 */
	EAttribute getStringParameter_Value();

	/**
	 * Returns the meta object for the '{@link org.sheepy.lily.core.model.types.StringParameter#getNativeValue() <em>Get Native Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Native Value</em>' operation.
	 * @see org.sheepy.lily.core.model.types.StringParameter#getNativeValue()
	 * @generated
	 */
	EOperation getStringParameter__GetNativeValue();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.types.BooleanParameter <em>Boolean Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Parameter</em>'.
	 * @see org.sheepy.lily.core.model.types.BooleanParameter
	 * @generated
	 */
	EClass getBooleanParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.types.BooleanParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.sheepy.lily.core.model.types.BooleanParameter#getValue()
	 * @see #getBooleanParameter()
	 * @generated
	 */
	EAttribute getBooleanParameter_Value();

	/**
	 * Returns the meta object for the '{@link org.sheepy.lily.core.model.types.BooleanParameter#getNativeValue() <em>Get Native Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Native Value</em>' operation.
	 * @see org.sheepy.lily.core.model.types.BooleanParameter#getNativeValue()
	 * @generated
	 */
	EOperation getBooleanParameter__GetNativeValue();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.types.ENotificationDirection <em>ENotification Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ENotification Direction</em>'.
	 * @see org.sheepy.lily.core.model.types.ENotificationDirection
	 * @generated
	 */
	EEnum getENotificationDirection();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.types.EMoveState <em>EMove State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EMove State</em>'.
	 * @see org.sheepy.lily.core.model.types.EMoveState
	 * @generated
	 */
	EEnum getEMoveState();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.types.EDirection <em>EDirection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EDirection</em>'.
	 * @see org.sheepy.lily.core.model.types.EDirection
	 * @generated
	 */
	EEnum getEDirection();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.types.ETimeUnit <em>ETime Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ETime Unit</em>'.
	 * @see org.sheepy.lily.core.model.types.ETimeUnit
	 * @generated
	 */
	EEnum getETimeUnit();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.types.ENumberComparisonType <em>ENumber Comparison Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ENumber Comparison Type</em>'.
	 * @see org.sheepy.lily.core.model.types.ENumberComparisonType
	 * @generated
	 */
	EEnum getENumberComparisonType();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.types.ERelative <em>ERelative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ERelative</em>'.
	 * @see org.sheepy.lily.core.model.types.ERelative
	 * @generated
	 */
	EEnum getERelative();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.types.EVerticalRelative <em>EVertical Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EVertical Relative</em>'.
	 * @see org.sheepy.lily.core.model.types.EVerticalRelative
	 * @generated
	 */
	EEnum getEVerticalRelative();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.types.EHorizontalRelative <em>EHorizontal Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EHorizontal Relative</em>'.
	 * @see org.sheepy.lily.core.model.types.EHorizontalRelative
	 * @generated
	 */
	EEnum getEHorizontalRelative();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.types.EMouseButton <em>EMouse Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EMouse Button</em>'.
	 * @see org.sheepy.lily.core.model.types.EMouseButton
	 * @generated
	 */
	EEnum getEMouseButton();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.types.EKeyState <em>EKey State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EKey State</em>'.
	 * @see org.sheepy.lily.core.model.types.EKeyState
	 * @generated
	 */
	EEnum getEKeyState();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.core.model.types.ECharTable <em>EChar Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EChar Table</em>'.
	 * @see org.sheepy.lily.core.model.types.ECharTable
	 * @generated
	 */
	EEnum getECharTable();

	/**
	 * Returns the meta object for data type '{@link org.joml.Vector4dc <em>Vector4d</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Vector4d</em>'.
	 * @see org.joml.Vector4dc
	 * @model instanceClass="org.joml.Vector4dc"
	 * @generated
	 */
	EDataType getVector4d();

	/**
	 * Returns the meta object for data type '{@link org.joml.Vector4fc <em>Vector4f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Vector4f</em>'.
	 * @see org.joml.Vector4fc
	 * @model instanceClass="org.joml.Vector4fc"
	 * @generated
	 */
	EDataType getVector4f();

	/**
	 * Returns the meta object for data type '{@link org.joml.Vector4ic <em>Vector4i</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Vector4i</em>'.
	 * @see org.joml.Vector4ic
	 * @model instanceClass="org.joml.Vector4ic"
	 * @generated
	 */
	EDataType getVector4i();

	/**
	 * Returns the meta object for data type '{@link org.joml.Vector4fc <em>Color4f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Color4f</em>'.
	 * @see org.joml.Vector4fc
	 * @model instanceClass="org.joml.Vector4fc"
	 * @generated
	 */
	EDataType getColor4f();

	/**
	 * Returns the meta object for data type '{@link org.joml.Vector3fc <em>Color3f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Color3f</em>'.
	 * @see org.joml.Vector3fc
	 * @model instanceClass="org.joml.Vector3fc"
	 * @generated
	 */
	EDataType getColor3f();

	/**
	 * Returns the meta object for data type '{@link org.joml.Vector3dc <em>Vector3d</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Vector3d</em>'.
	 * @see org.joml.Vector3dc
	 * @model instanceClass="org.joml.Vector3dc"
	 * @generated
	 */
	EDataType getVector3d();

	/**
	 * Returns the meta object for data type '{@link org.joml.Vector3fc <em>Vector3f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Vector3f</em>'.
	 * @see org.joml.Vector3fc
	 * @model instanceClass="org.joml.Vector3fc"
	 * @generated
	 */
	EDataType getVector3f();

	/**
	 * Returns the meta object for data type '{@link org.joml.Vector3ic <em>Vector3i</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Vector3i</em>'.
	 * @see org.joml.Vector3ic
	 * @model instanceClass="org.joml.Vector3ic"
	 * @generated
	 */
	EDataType getVector3i();

	/**
	 * Returns the meta object for data type '{@link org.joml.Vector2fc <em>Vector2f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Vector2f</em>'.
	 * @see org.joml.Vector2fc
	 * @model instanceClass="org.joml.Vector2fc"
	 * @generated
	 */
	EDataType getVector2f();

	/**
	 * Returns the meta object for data type '{@link org.joml.Vector2ic <em>Vector2i</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Vector2i</em>'.
	 * @see org.joml.Vector2ic
	 * @model instanceClass="org.joml.Vector2ic"
	 * @generated
	 */
	EDataType getVector2i();

	/**
	 * Returns the meta object for data type '{@link org.joml.Vector2dc <em>Vector2d</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Vector2d</em>'.
	 * @see org.joml.Vector2dc
	 * @model instanceClass="org.joml.Vector2dc"
	 * @generated
	 */
	EDataType getVector2d();

	/**
	 * Returns the meta object for data type '{@link java.lang.Module <em>Java Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Module</em>'.
	 * @see java.lang.Module
	 * @model instanceClass="java.lang.Module"
	 * @generated
	 */
	EDataType getJavaModule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypesFactory getTypesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.LNamedElement <em>LNamed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.LNamedElement
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getLNamedElement()
		 * @generated
		 */
		EClass LNAMED_ELEMENT = eINSTANCE.getLNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LNAMED_ELEMENT__NAME = eINSTANCE.getLNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.Parameter <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.Parameter
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.PositionParameter <em>Position Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.PositionParameter
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getPositionParameter()
		 * @generated
		 */
		EClass POSITION_PARAMETER = eINSTANCE.getPositionParameter();

		/**
		 * The meta object literal for the '<em><b>Get Position</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POSITION_PARAMETER___GET_POSITION = eINSTANCE.getPositionParameter__GetPosition();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.PositionFParameter <em>Position FParameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.PositionFParameter
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getPositionFParameter()
		 * @generated
		 */
		EClass POSITION_FPARAMETER = eINSTANCE.getPositionFParameter();

		/**
		 * The meta object literal for the '<em><b>Get Position</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POSITION_FPARAMETER___GET_POSITION = eINSTANCE.getPositionFParameter__GetPosition();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.NativeParameter <em>Native Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.NativeParameter
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getNativeParameter()
		 * @generated
		 */
		EClass NATIVE_PARAMETER = eINSTANCE.getNativeParameter();

		/**
		 * The meta object literal for the '<em><b>Get Native Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NATIVE_PARAMETER___GET_NATIVE_VALUE = eINSTANCE.getNativeParameter__GetNativeValue();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.impl.FloatParameterImpl <em>Float Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.impl.FloatParameterImpl
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getFloatParameter()
		 * @generated
		 */
		EClass FLOAT_PARAMETER = eINSTANCE.getFloatParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOAT_PARAMETER__VALUE = eINSTANCE.getFloatParameter_Value();

		/**
		 * The meta object literal for the '<em><b>Get Native Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FLOAT_PARAMETER___GET_NATIVE_VALUE = eINSTANCE.getFloatParameter__GetNativeValue();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.impl.StringParameterImpl <em>String Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.impl.StringParameterImpl
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getStringParameter()
		 * @generated
		 */
		EClass STRING_PARAMETER = eINSTANCE.getStringParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_PARAMETER__VALUE = eINSTANCE.getStringParameter_Value();

		/**
		 * The meta object literal for the '<em><b>Get Native Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRING_PARAMETER___GET_NATIVE_VALUE = eINSTANCE.getStringParameter__GetNativeValue();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.impl.BooleanParameterImpl <em>Boolean Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.impl.BooleanParameterImpl
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getBooleanParameter()
		 * @generated
		 */
		EClass BOOLEAN_PARAMETER = eINSTANCE.getBooleanParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_PARAMETER__VALUE = eINSTANCE.getBooleanParameter_Value();

		/**
		 * The meta object literal for the '<em><b>Get Native Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOOLEAN_PARAMETER___GET_NATIVE_VALUE = eINSTANCE.getBooleanParameter__GetNativeValue();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.ENotificationDirection <em>ENotification Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.ENotificationDirection
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getENotificationDirection()
		 * @generated
		 */
		EEnum ENOTIFICATION_DIRECTION = eINSTANCE.getENotificationDirection();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.EMoveState <em>EMove State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.EMoveState
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getEMoveState()
		 * @generated
		 */
		EEnum EMOVE_STATE = eINSTANCE.getEMoveState();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.EDirection <em>EDirection</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.EDirection
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getEDirection()
		 * @generated
		 */
		EEnum EDIRECTION = eINSTANCE.getEDirection();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.ETimeUnit <em>ETime Unit</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.ETimeUnit
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getETimeUnit()
		 * @generated
		 */
		EEnum ETIME_UNIT = eINSTANCE.getETimeUnit();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.ENumberComparisonType <em>ENumber Comparison Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.ENumberComparisonType
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getENumberComparisonType()
		 * @generated
		 */
		EEnum ENUMBER_COMPARISON_TYPE = eINSTANCE.getENumberComparisonType();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.ERelative <em>ERelative</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.ERelative
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getERelative()
		 * @generated
		 */
		EEnum ERELATIVE = eINSTANCE.getERelative();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.EVerticalRelative <em>EVertical Relative</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.EVerticalRelative
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getEVerticalRelative()
		 * @generated
		 */
		EEnum EVERTICAL_RELATIVE = eINSTANCE.getEVerticalRelative();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.EHorizontalRelative <em>EHorizontal Relative</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.EHorizontalRelative
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getEHorizontalRelative()
		 * @generated
		 */
		EEnum EHORIZONTAL_RELATIVE = eINSTANCE.getEHorizontalRelative();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.EMouseButton <em>EMouse Button</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.EMouseButton
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getEMouseButton()
		 * @generated
		 */
		EEnum EMOUSE_BUTTON = eINSTANCE.getEMouseButton();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.EKeyState <em>EKey State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.EKeyState
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getEKeyState()
		 * @generated
		 */
		EEnum EKEY_STATE = eINSTANCE.getEKeyState();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.types.ECharTable <em>EChar Table</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.types.ECharTable
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getECharTable()
		 * @generated
		 */
		EEnum ECHAR_TABLE = eINSTANCE.getECharTable();

		/**
		 * The meta object literal for the '<em>Vector4d</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joml.Vector4dc
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector4d()
		 * @generated
		 */
		EDataType VECTOR4D = eINSTANCE.getVector4d();

		/**
		 * The meta object literal for the '<em>Vector4f</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joml.Vector4fc
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector4f()
		 * @generated
		 */
		EDataType VECTOR4F = eINSTANCE.getVector4f();

		/**
		 * The meta object literal for the '<em>Vector4i</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joml.Vector4ic
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector4i()
		 * @generated
		 */
		EDataType VECTOR4I = eINSTANCE.getVector4i();

		/**
		 * The meta object literal for the '<em>Color4f</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joml.Vector4fc
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getColor4f()
		 * @generated
		 */
		EDataType COLOR4F = eINSTANCE.getColor4f();

		/**
		 * The meta object literal for the '<em>Color3f</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joml.Vector3fc
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getColor3f()
		 * @generated
		 */
		EDataType COLOR3F = eINSTANCE.getColor3f();

		/**
		 * The meta object literal for the '<em>Vector3d</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joml.Vector3dc
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector3d()
		 * @generated
		 */
		EDataType VECTOR3D = eINSTANCE.getVector3d();

		/**
		 * The meta object literal for the '<em>Vector3f</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joml.Vector3fc
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector3f()
		 * @generated
		 */
		EDataType VECTOR3F = eINSTANCE.getVector3f();

		/**
		 * The meta object literal for the '<em>Vector3i</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joml.Vector3ic
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector3i()
		 * @generated
		 */
		EDataType VECTOR3I = eINSTANCE.getVector3i();

		/**
		 * The meta object literal for the '<em>Vector2f</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joml.Vector2fc
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector2f()
		 * @generated
		 */
		EDataType VECTOR2F = eINSTANCE.getVector2f();

		/**
		 * The meta object literal for the '<em>Vector2i</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joml.Vector2ic
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector2i()
		 * @generated
		 */
		EDataType VECTOR2I = eINSTANCE.getVector2i();

		/**
		 * The meta object literal for the '<em>Vector2d</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joml.Vector2dc
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getVector2d()
		 * @generated
		 */
		EDataType VECTOR2D = eINSTANCE.getVector2d();

		/**
		 * The meta object literal for the '<em>Java Module</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Module
		 * @see org.sheepy.lily.core.model.types.impl.TypesPackageImpl#getJavaModule()
		 * @generated
		 */
		EDataType JAVA_MODULE = eINSTANCE.getJavaModule();

	}

} //TypesPackage
