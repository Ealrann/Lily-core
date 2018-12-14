/**
 */
package org.sheepy.common.model.types;

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
 * @see org.sheepy.common.model.types.TypesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.common.model/src/generated/java' editDirectory='/org.sheepy.common.model.edit/src/generated/java' publicConstructors='true' updateClasspath='false' basePackage='org.sheepy.common.model'"
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
	String eNS_URI = "org.sheepy.common.model.types";

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
	TypesPackage eINSTANCE = org.sheepy.common.model.types.impl.TypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.types.Parameter <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.Parameter
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 0;

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
	 * The meta object id for the '{@link org.sheepy.common.model.types.PositionParameter <em>Position Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.PositionParameter
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getPositionParameter()
	 * @generated
	 */
	int POSITION_PARAMETER = 1;

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
	 * The meta object id for the '{@link org.sheepy.common.model.types.PositionFParameter <em>Position FParameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.PositionFParameter
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getPositionFParameter()
	 * @generated
	 */
	int POSITION_FPARAMETER = 2;

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
	 * The meta object id for the '{@link org.sheepy.common.model.types.NativeParameter <em>Native Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.NativeParameter
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getNativeParameter()
	 * @generated
	 */
	int NATIVE_PARAMETER = 3;

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
	 * The meta object id for the '{@link org.sheepy.common.model.types.impl.FloatParameterImpl <em>Float Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.impl.FloatParameterImpl
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getFloatParameter()
	 * @generated
	 */
	int FLOAT_PARAMETER = 4;

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
	 * The meta object id for the '{@link org.sheepy.common.model.types.impl.StringParameterImpl <em>String Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.impl.StringParameterImpl
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getStringParameter()
	 * @generated
	 */
	int STRING_PARAMETER = 5;

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
	 * The meta object id for the '{@link org.sheepy.common.model.types.impl.BooleanParameterImpl <em>Boolean Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.impl.BooleanParameterImpl
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getBooleanParameter()
	 * @generated
	 */
	int BOOLEAN_PARAMETER = 6;

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
	 * The meta object id for the '{@link org.sheepy.common.model.types.ENotificationDirection <em>ENotification Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.ENotificationDirection
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getENotificationDirection()
	 * @generated
	 */
	int ENOTIFICATION_DIRECTION = 7;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.types.EMoveState <em>EMove State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.EMoveState
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getEMoveState()
	 * @generated
	 */
	int EMOVE_STATE = 8;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.types.EDirection <em>EDirection</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.EDirection
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getEDirection()
	 * @generated
	 */
	int EDIRECTION = 9;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.types.ETimeUnit <em>ETime Unit</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.ETimeUnit
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getETimeUnit()
	 * @generated
	 */
	int ETIME_UNIT = 10;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.types.ENumberComparisonType <em>ENumber Comparison Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.ENumberComparisonType
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getENumberComparisonType()
	 * @generated
	 */
	int ENUMBER_COMPARISON_TYPE = 11;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.types.EVerticalRelative <em>EVertical Relative</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.EVerticalRelative
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getEVerticalRelative()
	 * @generated
	 */
	int EVERTICAL_RELATIVE = 12;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.types.EHorizontalRelative <em>EHorizontal Relative</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.EHorizontalRelative
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getEHorizontalRelative()
	 * @generated
	 */
	int EHORIZONTAL_RELATIVE = 13;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.types.EMouseButton <em>EMouse Button</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.EMouseButton
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getEMouseButton()
	 * @generated
	 */
	int EMOUSE_BUTTON = 14;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.types.EKeyState <em>EKey State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.types.EKeyState
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getEKeyState()
	 * @generated
	 */
	int EKEY_STATE = 15;

	/**
	 * The meta object id for the '<em>SVector2f</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.api.types.SVector2f
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getSVector2f()
	 * @generated
	 */
	int SVECTOR2F = 16;

	/**
	 * The meta object id for the '<em>SVector2i</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.api.types.SVector2i
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getSVector2i()
	 * @generated
	 */
	int SVECTOR2I = 17;


	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.types.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.sheepy.common.model.types.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.types.PositionParameter <em>Position Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Position Parameter</em>'.
	 * @see org.sheepy.common.model.types.PositionParameter
	 * @generated
	 */
	EClass getPositionParameter();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.types.PositionParameter#getPosition() <em>Get Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Position</em>' operation.
	 * @see org.sheepy.common.model.types.PositionParameter#getPosition()
	 * @generated
	 */
	EOperation getPositionParameter__GetPosition();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.types.PositionFParameter <em>Position FParameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Position FParameter</em>'.
	 * @see org.sheepy.common.model.types.PositionFParameter
	 * @generated
	 */
	EClass getPositionFParameter();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.types.PositionFParameter#getPosition() <em>Get Position</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Position</em>' operation.
	 * @see org.sheepy.common.model.types.PositionFParameter#getPosition()
	 * @generated
	 */
	EOperation getPositionFParameter__GetPosition();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.types.NativeParameter <em>Native Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Native Parameter</em>'.
	 * @see org.sheepy.common.model.types.NativeParameter
	 * @generated
	 */
	EClass getNativeParameter();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.types.NativeParameter#getNativeValue() <em>Get Native Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Native Value</em>' operation.
	 * @see org.sheepy.common.model.types.NativeParameter#getNativeValue()
	 * @generated
	 */
	EOperation getNativeParameter__GetNativeValue();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.types.FloatParameter <em>Float Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float Parameter</em>'.
	 * @see org.sheepy.common.model.types.FloatParameter
	 * @generated
	 */
	EClass getFloatParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.types.FloatParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.sheepy.common.model.types.FloatParameter#getValue()
	 * @see #getFloatParameter()
	 * @generated
	 */
	EAttribute getFloatParameter_Value();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.types.FloatParameter#getNativeValue() <em>Get Native Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Native Value</em>' operation.
	 * @see org.sheepy.common.model.types.FloatParameter#getNativeValue()
	 * @generated
	 */
	EOperation getFloatParameter__GetNativeValue();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.types.StringParameter <em>String Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Parameter</em>'.
	 * @see org.sheepy.common.model.types.StringParameter
	 * @generated
	 */
	EClass getStringParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.types.StringParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.sheepy.common.model.types.StringParameter#getValue()
	 * @see #getStringParameter()
	 * @generated
	 */
	EAttribute getStringParameter_Value();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.types.StringParameter#getNativeValue() <em>Get Native Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Native Value</em>' operation.
	 * @see org.sheepy.common.model.types.StringParameter#getNativeValue()
	 * @generated
	 */
	EOperation getStringParameter__GetNativeValue();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.types.BooleanParameter <em>Boolean Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Parameter</em>'.
	 * @see org.sheepy.common.model.types.BooleanParameter
	 * @generated
	 */
	EClass getBooleanParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.types.BooleanParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.sheepy.common.model.types.BooleanParameter#getValue()
	 * @see #getBooleanParameter()
	 * @generated
	 */
	EAttribute getBooleanParameter_Value();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.types.BooleanParameter#getNativeValue() <em>Get Native Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Native Value</em>' operation.
	 * @see org.sheepy.common.model.types.BooleanParameter#getNativeValue()
	 * @generated
	 */
	EOperation getBooleanParameter__GetNativeValue();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.common.model.types.ENotificationDirection <em>ENotification Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ENotification Direction</em>'.
	 * @see org.sheepy.common.model.types.ENotificationDirection
	 * @generated
	 */
	EEnum getENotificationDirection();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.common.model.types.EMoveState <em>EMove State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EMove State</em>'.
	 * @see org.sheepy.common.model.types.EMoveState
	 * @generated
	 */
	EEnum getEMoveState();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.common.model.types.EDirection <em>EDirection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EDirection</em>'.
	 * @see org.sheepy.common.model.types.EDirection
	 * @generated
	 */
	EEnum getEDirection();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.common.model.types.ETimeUnit <em>ETime Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ETime Unit</em>'.
	 * @see org.sheepy.common.model.types.ETimeUnit
	 * @generated
	 */
	EEnum getETimeUnit();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.common.model.types.ENumberComparisonType <em>ENumber Comparison Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ENumber Comparison Type</em>'.
	 * @see org.sheepy.common.model.types.ENumberComparisonType
	 * @generated
	 */
	EEnum getENumberComparisonType();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.common.model.types.EVerticalRelative <em>EVertical Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EVertical Relative</em>'.
	 * @see org.sheepy.common.model.types.EVerticalRelative
	 * @generated
	 */
	EEnum getEVerticalRelative();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.common.model.types.EHorizontalRelative <em>EHorizontal Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EHorizontal Relative</em>'.
	 * @see org.sheepy.common.model.types.EHorizontalRelative
	 * @generated
	 */
	EEnum getEHorizontalRelative();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.common.model.types.EMouseButton <em>EMouse Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EMouse Button</em>'.
	 * @see org.sheepy.common.model.types.EMouseButton
	 * @generated
	 */
	EEnum getEMouseButton();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.common.model.types.EKeyState <em>EKey State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EKey State</em>'.
	 * @see org.sheepy.common.model.types.EKeyState
	 * @generated
	 */
	EEnum getEKeyState();

	/**
	 * Returns the meta object for data type '{@link org.sheepy.common.api.types.SVector2f <em>SVector2f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>SVector2f</em>'.
	 * @see org.sheepy.common.api.types.SVector2f
	 * @model instanceClass="org.sheepy.common.api.types.SVector2f"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel create='if ((it != null))\n{\n\tfinal &lt;%java.lang.String%&gt;[] split = it.split(\";\");\n\tint _length = split.length;\n\tboolean _equals = (_length == 2);\n\tif (_equals)\n\t{\n\t\t&lt;%java.lang.Float%&gt; _valueOf = &lt;%java.lang.Float%&gt;.valueOf(split[0]);\n\t\t&lt;%java.lang.Float%&gt; _valueOf_1 = &lt;%java.lang.Float%&gt;.valueOf(split[1]);\n\t\treturn new &lt;%org.sheepy.common.api.types.SVector2f%&gt;((_valueOf).floatValue(), (_valueOf_1).floatValue());\n\t}\n}\nreturn new &lt;%org.sheepy.common.api.types.SVector2f%&gt;(0, 0);' convert='&lt;%java.lang.String%&gt; _plus = (&lt;%java.lang.Float%&gt;.valueOf(it.x) + \";\");\nreturn (_plus + &lt;%java.lang.Float%&gt;.valueOf(it.y));'"
	 * @generated
	 */
	EDataType getSVector2f();

	/**
	 * Returns the meta object for data type '{@link org.sheepy.common.api.types.SVector2i <em>SVector2i</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>SVector2i</em>'.
	 * @see org.sheepy.common.api.types.SVector2i
	 * @model instanceClass="org.sheepy.common.api.types.SVector2i"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel create='if ((it != null))\n{\n\tfinal &lt;%java.lang.String%&gt;[] split = it.split(\";\");\n\tint _length = split.length;\n\tboolean _equals = (_length == 2);\n\tif (_equals)\n\t{\n\t\t&lt;%java.lang.Integer%&gt; _valueOf = &lt;%java.lang.Integer%&gt;.valueOf(split[0]);\n\t\t&lt;%java.lang.Integer%&gt; _valueOf_1 = &lt;%java.lang.Integer%&gt;.valueOf(split[1]);\n\t\treturn new &lt;%org.sheepy.common.api.types.SVector2i%&gt;((_valueOf).intValue(), (_valueOf_1).intValue());\n\t}\n}\nreturn new &lt;%org.sheepy.common.api.types.SVector2i%&gt;(0, 0);' convert='&lt;%java.lang.String%&gt; _plus = (&lt;%java.lang.Integer%&gt;.valueOf(it.x) + \";\");\nreturn (_plus + &lt;%java.lang.Integer%&gt;.valueOf(it.y));'"
	 * @generated
	 */
	EDataType getSVector2i();

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
		 * The meta object literal for the '{@link org.sheepy.common.model.types.Parameter <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.Parameter
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.types.PositionParameter <em>Position Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.PositionParameter
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getPositionParameter()
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
		 * The meta object literal for the '{@link org.sheepy.common.model.types.PositionFParameter <em>Position FParameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.PositionFParameter
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getPositionFParameter()
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
		 * The meta object literal for the '{@link org.sheepy.common.model.types.NativeParameter <em>Native Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.NativeParameter
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getNativeParameter()
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
		 * The meta object literal for the '{@link org.sheepy.common.model.types.impl.FloatParameterImpl <em>Float Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.impl.FloatParameterImpl
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getFloatParameter()
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
		 * The meta object literal for the '{@link org.sheepy.common.model.types.impl.StringParameterImpl <em>String Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.impl.StringParameterImpl
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getStringParameter()
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
		 * The meta object literal for the '{@link org.sheepy.common.model.types.impl.BooleanParameterImpl <em>Boolean Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.impl.BooleanParameterImpl
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getBooleanParameter()
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
		 * The meta object literal for the '{@link org.sheepy.common.model.types.ENotificationDirection <em>ENotification Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.ENotificationDirection
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getENotificationDirection()
		 * @generated
		 */
		EEnum ENOTIFICATION_DIRECTION = eINSTANCE.getENotificationDirection();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.types.EMoveState <em>EMove State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.EMoveState
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getEMoveState()
		 * @generated
		 */
		EEnum EMOVE_STATE = eINSTANCE.getEMoveState();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.types.EDirection <em>EDirection</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.EDirection
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getEDirection()
		 * @generated
		 */
		EEnum EDIRECTION = eINSTANCE.getEDirection();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.types.ETimeUnit <em>ETime Unit</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.ETimeUnit
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getETimeUnit()
		 * @generated
		 */
		EEnum ETIME_UNIT = eINSTANCE.getETimeUnit();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.types.ENumberComparisonType <em>ENumber Comparison Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.ENumberComparisonType
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getENumberComparisonType()
		 * @generated
		 */
		EEnum ENUMBER_COMPARISON_TYPE = eINSTANCE.getENumberComparisonType();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.types.EVerticalRelative <em>EVertical Relative</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.EVerticalRelative
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getEVerticalRelative()
		 * @generated
		 */
		EEnum EVERTICAL_RELATIVE = eINSTANCE.getEVerticalRelative();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.types.EHorizontalRelative <em>EHorizontal Relative</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.EHorizontalRelative
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getEHorizontalRelative()
		 * @generated
		 */
		EEnum EHORIZONTAL_RELATIVE = eINSTANCE.getEHorizontalRelative();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.types.EMouseButton <em>EMouse Button</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.EMouseButton
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getEMouseButton()
		 * @generated
		 */
		EEnum EMOUSE_BUTTON = eINSTANCE.getEMouseButton();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.types.EKeyState <em>EKey State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.types.EKeyState
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getEKeyState()
		 * @generated
		 */
		EEnum EKEY_STATE = eINSTANCE.getEKeyState();

		/**
		 * The meta object literal for the '<em>SVector2f</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.api.types.SVector2f
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getSVector2f()
		 * @generated
		 */
		EDataType SVECTOR2F = eINSTANCE.getSVector2f();

		/**
		 * The meta object literal for the '<em>SVector2i</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.api.types.SVector2i
		 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getSVector2i()
		 * @generated
		 */
		EDataType SVECTOR2I = eINSTANCE.getSVector2i();

	}

} //TypesPackage
