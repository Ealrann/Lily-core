/**
 */
package org.sheepy.common.model.types.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.common.model.types.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesFactoryImpl extends EFactoryImpl implements TypesFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypesFactory init()
	{
		try
		{
			TypesFactory theTypesFactory = (TypesFactory)EPackage.Registry.INSTANCE.getEFactory(TypesPackage.eNS_URI);
			if (theTypesFactory != null)
			{
				return theTypesFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactoryImpl()
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
			case TypesPackage.FLOAT_PARAMETER: return createFloatParameter();
			case TypesPackage.STRING_PARAMETER: return createStringParameter();
			case TypesPackage.BOOLEAN_PARAMETER: return createBooleanParameter();
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
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case TypesPackage.ENOTIFICATION_DIRECTION:
				return createENotificationDirectionFromString(eDataType, initialValue);
			case TypesPackage.EMOVE_STATE:
				return createEMoveStateFromString(eDataType, initialValue);
			case TypesPackage.EDIRECTION:
				return createEDirectionFromString(eDataType, initialValue);
			case TypesPackage.ETIME_UNIT:
				return createETimeUnitFromString(eDataType, initialValue);
			case TypesPackage.ENUMBER_COMPARISON_TYPE:
				return createENumberComparisonTypeFromString(eDataType, initialValue);
			case TypesPackage.EVERTICAL_RELATIVE:
				return createEVerticalRelativeFromString(eDataType, initialValue);
			case TypesPackage.EHORIZONTAL_RELATIVE:
				return createEHorizontalRelativeFromString(eDataType, initialValue);
			case TypesPackage.EMOUSE_BUTTON:
				return createEMouseButtonFromString(eDataType, initialValue);
			case TypesPackage.EKEY_STATE:
				return createEKeyStateFromString(eDataType, initialValue);
			case TypesPackage.LPOINT_F:
				return createLPointFFromString(eDataType, initialValue);
			case TypesPackage.LPOINT:
				return createLPointFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case TypesPackage.ENOTIFICATION_DIRECTION:
				return convertENotificationDirectionToString(eDataType, instanceValue);
			case TypesPackage.EMOVE_STATE:
				return convertEMoveStateToString(eDataType, instanceValue);
			case TypesPackage.EDIRECTION:
				return convertEDirectionToString(eDataType, instanceValue);
			case TypesPackage.ETIME_UNIT:
				return convertETimeUnitToString(eDataType, instanceValue);
			case TypesPackage.ENUMBER_COMPARISON_TYPE:
				return convertENumberComparisonTypeToString(eDataType, instanceValue);
			case TypesPackage.EVERTICAL_RELATIVE:
				return convertEVerticalRelativeToString(eDataType, instanceValue);
			case TypesPackage.EHORIZONTAL_RELATIVE:
				return convertEHorizontalRelativeToString(eDataType, instanceValue);
			case TypesPackage.EMOUSE_BUTTON:
				return convertEMouseButtonToString(eDataType, instanceValue);
			case TypesPackage.EKEY_STATE:
				return convertEKeyStateToString(eDataType, instanceValue);
			case TypesPackage.LPOINT_F:
				return convertLPointFToString(eDataType, instanceValue);
			case TypesPackage.LPOINT:
				return convertLPointToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatParameter createFloatParameter()
	{
		FloatParameterImpl floatParameter = new FloatParameterImpl();
		return floatParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringParameter createStringParameter()
	{
		StringParameterImpl stringParameter = new StringParameterImpl();
		return stringParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanParameter createBooleanParameter()
	{
		BooleanParameterImpl booleanParameter = new BooleanParameterImpl();
		return booleanParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENotificationDirection createENotificationDirectionFromString(EDataType eDataType, String initialValue)
	{
		ENotificationDirection result = ENotificationDirection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertENotificationDirectionToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMoveState createEMoveStateFromString(EDataType eDataType, String initialValue)
	{
		EMoveState result = EMoveState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEMoveStateToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDirection createEDirectionFromString(EDataType eDataType, String initialValue)
	{
		EDirection result = EDirection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDirectionToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETimeUnit createETimeUnitFromString(EDataType eDataType, String initialValue)
	{
		ETimeUnit result = ETimeUnit.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertETimeUnitToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENumberComparisonType createENumberComparisonTypeFromString(EDataType eDataType, String initialValue)
	{
		ENumberComparisonType result = ENumberComparisonType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertENumberComparisonTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EVerticalRelative createEVerticalRelativeFromString(EDataType eDataType, String initialValue)
	{
		EVerticalRelative result = EVerticalRelative.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEVerticalRelativeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EHorizontalRelative createEHorizontalRelativeFromString(EDataType eDataType, String initialValue)
	{
		EHorizontalRelative result = EHorizontalRelative.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEHorizontalRelativeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMouseButton createEMouseButtonFromString(EDataType eDataType, String initialValue)
	{
		EMouseButton result = EMouseButton.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEMouseButtonToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EKeyState createEKeyStateFromString(EDataType eDataType, String initialValue)
	{
		EKeyState result = EKeyState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEKeyStateToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createLPointF(final String it)
	{
		throw new Error("Unresolved compilation problems: Point2f cannot be resolved.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createLPointFFromString(EDataType eDataType, String initialValue)
	{
		return createLPointF(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLPointF(final Object it)
	{
		throw new Error("Unresolved compilation problems: The method or field x is undefined for the type Object");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLPointFToString(EDataType eDataType, Object instanceValue)
	{
		return convertLPointF((Object)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createLPoint(final String it)
	{
		throw new Error("Unresolved compilation problems: Point2i cannot be resolved.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createLPointFromString(EDataType eDataType, String initialValue)
	{
		return createLPoint(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLPoint(final Object it)
	{
		throw new Error("Unresolved compilation problems: The method or field x is undefined for the type Object");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLPointToString(EDataType eDataType, Object instanceValue)
	{
		return convertLPoint((Object)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesPackage getTypesPackage()
	{
		return (TypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TypesPackage getPackage()
	{
		return TypesPackage.eINSTANCE;
	}

} //TypesFactoryImpl
