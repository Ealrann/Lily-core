/**
 */
package org.sheepy.lily.core.model.types.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.joml.Vector2d;
import org.joml.Vector2dc;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.Vector4d;
import org.joml.Vector4dc;
import org.joml.Vector4f;
import org.joml.Vector4fc;

import org.sheepy.lily.core.model.types.*;

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
			TypesFactory theTypesFactory = (TypesFactory) EPackage.Registry.INSTANCE
					.getEFactory(TypesPackage.eNS_URI);
			if (theTypesFactory != null)
			{
				return theTypesFactory;
			}
		} catch (Exception exception)
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
		case TypesPackage.FLOAT_PARAMETER:
			return createFloatParameter();
		case TypesPackage.STRING_PARAMETER:
			return createStringParameter();
		case TypesPackage.BOOLEAN_PARAMETER:
			return createBooleanParameter();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier");
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
		case TypesPackage.VECTOR4D:
			return createVector4dFromString(eDataType, initialValue);
		case TypesPackage.VECTOR4F:
			return createVector4fFromString(eDataType, initialValue);
		case TypesPackage.COLOR4F:
			return createColor4fFromString(eDataType, initialValue);
		case TypesPackage.COLOR3F:
			return createColor3fFromString(eDataType, initialValue);
		case TypesPackage.VECTOR3D:
			return createVector3dFromString(eDataType, initialValue);
		case TypesPackage.VECTOR3F:
			return createVector3fFromString(eDataType, initialValue);
		case TypesPackage.VECTOR3I:
			return createVector3iFromString(eDataType, initialValue);
		case TypesPackage.VECTOR2F:
			return createVector2fFromString(eDataType, initialValue);
		case TypesPackage.VECTOR2I:
			return createVector2iFromString(eDataType, initialValue);
		case TypesPackage.VECTOR2D:
			return createVector2dFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
		case TypesPackage.VECTOR4D:
			return convertVector4dToString(eDataType, instanceValue);
		case TypesPackage.VECTOR4F:
			return convertVector4fToString(eDataType, instanceValue);
		case TypesPackage.COLOR4F:
			return convertColor4fToString(eDataType, instanceValue);
		case TypesPackage.COLOR3F:
			return convertColor3fToString(eDataType, instanceValue);
		case TypesPackage.VECTOR3D:
			return convertVector3dToString(eDataType, instanceValue);
		case TypesPackage.VECTOR3F:
			return convertVector3fToString(eDataType, instanceValue);
		case TypesPackage.VECTOR3I:
			return convertVector3iToString(eDataType, instanceValue);
		case TypesPackage.VECTOR2F:
			return convertVector2fToString(eDataType, instanceValue);
		case TypesPackage.VECTOR2I:
			return convertVector2iToString(eDataType, instanceValue);
		case TypesPackage.VECTOR2D:
			return convertVector2dToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	public ENotificationDirection createENotificationDirectionFromString(	EDataType eDataType,
																			String initialValue)
	{
		ENotificationDirection result = ENotificationDirection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
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
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
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
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
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
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
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
	public ENumberComparisonType createENumberComparisonTypeFromString(	EDataType eDataType,
																		String initialValue)
	{
		ENumberComparisonType result = ENumberComparisonType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
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
	public EVerticalRelative createEVerticalRelativeFromString(	EDataType eDataType,
																String initialValue)
	{
		EVerticalRelative result = EVerticalRelative.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
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
	public EHorizontalRelative createEHorizontalRelativeFromString(	EDataType eDataType,
																	String initialValue)
	{
		EHorizontalRelative result = EHorizontalRelative.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
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
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
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
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
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
	public Vector4dc createVector4d(final String it)
	{
		if ((it != null))
		{
			final String[] split = it.split(";");
			int _length = split.length;
			boolean _equals = (_length == 4);
			if (_equals)
			{
				Double _valueOf = Double.valueOf(split[0]);
				Double _valueOf_1 = Double.valueOf(split[1]);
				Double _valueOf_2 = Double.valueOf(split[2]);
				Double _valueOf_3 = Double.valueOf(split[3]);
				return new Vector4d((_valueOf).doubleValue(), (_valueOf_1).doubleValue(),
						(_valueOf_2).doubleValue(), (_valueOf_3).doubleValue());
			}
		}
		return new Vector4d(0, 0, 0, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector4dc createVector4dFromString(EDataType eDataType, String initialValue)
	{
		return createVector4d(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector4d(final Vector4dc it)
	{
		if ((it != null))
		{
			double _x = it.x();
			String _plus = (Double.valueOf(_x) + ";");
			double _y = it.y();
			String _plus_1 = (_plus + Double.valueOf(_y));
			String _plus_2 = (_plus_1 + ";");
			double _z = it.z();
			String _plus_3 = (_plus_2 + Double.valueOf(_z));
			String _plus_4 = (_plus_3 + ";");
			double _w = it.w();
			return (_plus_4 + Double.valueOf(_w));
		}
		else
		{
			return "0;0;0;0";
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector4dToString(EDataType eDataType, Object instanceValue)
	{
		return convertVector4d((Vector4dc) instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector4fc createVector4f(final String it)
	{
		if ((it != null))
		{
			final String[] split = it.split(";");
			int _length = split.length;
			boolean _equals = (_length == 4);
			if (_equals)
			{
				Float _valueOf = Float.valueOf(split[0]);
				Float _valueOf_1 = Float.valueOf(split[1]);
				Float _valueOf_2 = Float.valueOf(split[2]);
				Float _valueOf_3 = Float.valueOf(split[3]);
				return new Vector4f((_valueOf).floatValue(), (_valueOf_1).floatValue(),
						(_valueOf_2).floatValue(), (_valueOf_3).floatValue());
			}
		}
		return new Vector4f(0, 0, 0, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector4fc createVector4fFromString(EDataType eDataType, String initialValue)
	{
		return createVector4f(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector4f(final Vector4fc it)
	{
		if ((it != null))
		{
			float _x = it.x();
			String _plus = (Float.valueOf(_x) + ";");
			float _y = it.y();
			String _plus_1 = (_plus + Float.valueOf(_y));
			String _plus_2 = (_plus_1 + ";");
			float _z = it.z();
			String _plus_3 = (_plus_2 + Float.valueOf(_z));
			String _plus_4 = (_plus_3 + ";");
			float _w = it.w();
			return (_plus_4 + Float.valueOf(_w));
		}
		else
		{
			return "0;0;0;0";
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector4fToString(EDataType eDataType, Object instanceValue)
	{
		return convertVector4f((Vector4fc) instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector4fc createColor4f(final String it)
	{
		if ((it != null))
		{
			final String[] split = it.split(";");
			int _length = split.length;
			boolean _equals = (_length == 4);
			if (_equals)
			{
				Float _valueOf = Float.valueOf(split[0]);
				Float _valueOf_1 = Float.valueOf(split[1]);
				Float _valueOf_2 = Float.valueOf(split[2]);
				Float _valueOf_3 = Float.valueOf(split[3]);
				return new Vector4f((_valueOf).floatValue(), (_valueOf_1).floatValue(),
						(_valueOf_2).floatValue(), (_valueOf_3).floatValue());
			}
		}
		return new Vector4f(0, 0, 0, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector4fc createColor4fFromString(EDataType eDataType, String initialValue)
	{
		return createColor4f(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColor4f(final Vector4fc it)
	{
		if ((it != null))
		{
			float _x = it.x();
			String _plus = (Float.valueOf(_x) + ";");
			float _y = it.y();
			String _plus_1 = (_plus + Float.valueOf(_y));
			String _plus_2 = (_plus_1 + ";");
			float _z = it.z();
			String _plus_3 = (_plus_2 + Float.valueOf(_z));
			String _plus_4 = (_plus_3 + ";");
			float _w = it.w();
			return (_plus_4 + Float.valueOf(_w));
		}
		else
		{
			return "0;0;0;0";
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColor4fToString(EDataType eDataType, Object instanceValue)
	{
		return convertColor4f((Vector4fc) instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3fc createColor3f(final String it)
	{
		if ((it != null))
		{
			final String[] split = it.split(";");
			int _length = split.length;
			boolean _equals = (_length == 3);
			if (_equals)
			{
				Float _valueOf = Float.valueOf(split[0]);
				Float _valueOf_1 = Float.valueOf(split[1]);
				Float _valueOf_2 = Float.valueOf(split[2]);
				return new Vector3f((_valueOf).floatValue(), (_valueOf_1).floatValue(),
						(_valueOf_2).floatValue());
			}
		}
		return new Vector3f(0, 0, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3fc createColor3fFromString(EDataType eDataType, String initialValue)
	{
		return createColor3f(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColor3f(final Vector3fc it)
	{
		if ((it != null))
		{
			float _x = it.x();
			String _plus = (Float.valueOf(_x) + ";");
			float _y = it.y();
			String _plus_1 = (_plus + Float.valueOf(_y));
			String _plus_2 = (_plus_1 + ";");
			float _z = it.z();
			return (_plus_2 + Float.valueOf(_z));
		}
		else
		{
			return "0;0;0";
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColor3fToString(EDataType eDataType, Object instanceValue)
	{
		return convertColor3f((Vector3fc) instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3dc createVector3d(final String it)
	{
		if ((it != null))
		{
			final String[] split = it.split(";");
			int _length = split.length;
			boolean _equals = (_length == 3);
			if (_equals)
			{
				Double _valueOf = Double.valueOf(split[0]);
				Double _valueOf_1 = Double.valueOf(split[1]);
				Double _valueOf_2 = Double.valueOf(split[2]);
				return new Vector3d((_valueOf).doubleValue(), (_valueOf_1).doubleValue(),
						(_valueOf_2).doubleValue());
			}
		}
		return new Vector3d(0, 0, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3dc createVector3dFromString(EDataType eDataType, String initialValue)
	{
		return createVector3d(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector3d(final Vector3dc it)
	{
		if ((it != null))
		{
			double _x = it.x();
			String _plus = (Double.valueOf(_x) + ";");
			double _y = it.y();
			String _plus_1 = (_plus + Double.valueOf(_y));
			String _plus_2 = (_plus_1 + ";");
			double _z = it.z();
			return (_plus_2 + Double.valueOf(_z));
		}
		else
		{
			return "0;0;0";
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector3dToString(EDataType eDataType, Object instanceValue)
	{
		return convertVector3d((Vector3dc) instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3fc createVector3f(final String it)
	{
		if ((it != null))
		{
			final String[] split = it.split(";");
			int _length = split.length;
			boolean _equals = (_length == 3);
			if (_equals)
			{
				Float _valueOf = Float.valueOf(split[0]);
				Float _valueOf_1 = Float.valueOf(split[1]);
				Float _valueOf_2 = Float.valueOf(split[2]);
				return new Vector3f((_valueOf).floatValue(), (_valueOf_1).floatValue(),
						(_valueOf_2).floatValue());
			}
		}
		return new Vector3f(0, 0, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3fc createVector3fFromString(EDataType eDataType, String initialValue)
	{
		return createVector3f(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector3f(final Vector3fc it)
	{
		if ((it != null))
		{
			float _x = it.x();
			String _plus = (Float.valueOf(_x) + ";");
			float _y = it.y();
			String _plus_1 = (_plus + Float.valueOf(_y));
			String _plus_2 = (_plus_1 + ";");
			float _z = it.z();
			return (_plus_2 + Float.valueOf(_z));
		}
		else
		{
			return "0;0;0";
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector3fToString(EDataType eDataType, Object instanceValue)
	{
		return convertVector3f((Vector3fc) instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3ic createVector3i(final String it)
	{
		if ((it != null))
		{
			final String[] split = it.split(";");
			int _length = split.length;
			boolean _equals = (_length == 3);
			if (_equals)
			{
				Integer _valueOf = Integer.valueOf(split[0]);
				Integer _valueOf_1 = Integer.valueOf(split[1]);
				Integer _valueOf_2 = Integer.valueOf(split[2]);
				return new Vector3i((_valueOf).intValue(), (_valueOf_1).intValue(),
						(_valueOf_2).intValue());
			}
		}
		return new Vector3i(0, 0, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3ic createVector3iFromString(EDataType eDataType, String initialValue)
	{
		return createVector3i(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector3i(final Vector3ic it)
	{
		if ((it != null))
		{
			int _x = it.x();
			String _plus = (Integer.valueOf(_x) + ";");
			int _y = it.y();
			String _plus_1 = (_plus + Integer.valueOf(_y));
			String _plus_2 = (_plus_1 + ";");
			int _z = it.z();
			return (_plus_2 + Integer.valueOf(_z));
		}
		else
		{
			return "0;0;0";
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector3iToString(EDataType eDataType, Object instanceValue)
	{
		return convertVector3i((Vector3ic) instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector2fc createVector2f(final String it)
	{
		if ((it != null))
		{
			final String[] split = it.split(";");
			int _length = split.length;
			boolean _equals = (_length == 2);
			if (_equals)
			{
				Float _valueOf = Float.valueOf(split[0]);
				Float _valueOf_1 = Float.valueOf(split[1]);
				return new Vector2f((_valueOf).floatValue(), (_valueOf_1).floatValue());
			}
		}
		return new Vector2f(0, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector2fc createVector2fFromString(EDataType eDataType, String initialValue)
	{
		return createVector2f(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector2f(final Vector2fc it)
	{
		if ((it != null))
		{
			float _x = it.x();
			String _plus = (Float.valueOf(_x) + ";");
			float _y = it.y();
			return (_plus + Float.valueOf(_y));
		}
		else
		{
			return "0;0";
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector2fToString(EDataType eDataType, Object instanceValue)
	{
		return convertVector2f((Vector2fc) instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector2ic createVector2i(final String it)
	{
		if ((it != null))
		{
			final String[] split = it.split(";");
			int _length = split.length;
			boolean _equals = (_length == 2);
			if (_equals)
			{
				Integer _valueOf = Integer.valueOf(split[0]);
				Integer _valueOf_1 = Integer.valueOf(split[1]);
				return new Vector2i((_valueOf).intValue(), (_valueOf_1).intValue());
			}
		}
		return new Vector2i(0, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector2ic createVector2iFromString(EDataType eDataType, String initialValue)
	{
		return createVector2i(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector2i(final Vector2ic it)
	{
		if ((it != null))
		{
			int _x = it.x();
			String _plus = (Integer.valueOf(_x) + ";");
			int _y = it.y();
			return (_plus + Integer.valueOf(_y));
		}
		else
		{
			return "0;0";
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector2iToString(EDataType eDataType, Object instanceValue)
	{
		return convertVector2i((Vector2ic) instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector2dc createVector2d(final String it)
	{
		if ((it != null))
		{
			final String[] split = it.split(";");
			int _length = split.length;
			boolean _equals = (_length == 2);
			if (_equals)
			{
				Double _valueOf = Double.valueOf(split[0]);
				Double _valueOf_1 = Double.valueOf(split[1]);
				return new Vector2d((_valueOf).doubleValue(), (_valueOf_1).doubleValue());
			}
		}
		return new Vector2d(0, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector2dc createVector2dFromString(EDataType eDataType, String initialValue)
	{
		return createVector2d(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector2d(final Vector2dc it)
	{
		if ((it != null))
		{
			double _x = it.x();
			String _plus = (Double.valueOf(_x) + ";");
			double _y = it.y();
			return (_plus + Double.valueOf(_y));
		}
		else
		{
			return "0;0";
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVector2dToString(EDataType eDataType, Object instanceValue)
	{
		return convertVector2d((Vector2dc) instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypesPackage getTypesPackage()
	{
		return (TypesPackage) getEPackage();
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
