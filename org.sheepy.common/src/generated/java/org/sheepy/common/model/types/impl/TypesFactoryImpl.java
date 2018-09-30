/**
 */
package org.sheepy.common.model.types.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sheepy.common.api.types.SVector2f;
import org.sheepy.common.api.types.SVector2i;

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
			case TypesPackage.SVECTOR2F:
				return createSVector2fFromString(eDataType, initialValue);
			case TypesPackage.SVECTOR2I:
				return createSVector2iFromString(eDataType, initialValue);
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
			case TypesPackage.SVECTOR2F:
				return convertSVector2fToString(eDataType, instanceValue);
			case TypesPackage.SVECTOR2I:
				return convertSVector2iToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SVector2f createSVector2f(final String it)
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
				return new SVector2f((_valueOf).floatValue(), (_valueOf_1).floatValue());
			}
		}
		return new SVector2f(0, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SVector2f createSVector2fFromString(EDataType eDataType, String initialValue)
	{
		return createSVector2f(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSVector2f(final SVector2f it)
	{
		String _plus = (Float.valueOf(it.x) + ";");
		return (_plus + Float.valueOf(it.y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSVector2fToString(EDataType eDataType, Object instanceValue)
	{
		return convertSVector2f((SVector2f)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SVector2i createSVector2i(final String it)
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
				return new SVector2i((_valueOf).intValue(), (_valueOf_1).intValue());
			}
		}
		return new SVector2i(0, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SVector2i createSVector2iFromString(EDataType eDataType, String initialValue)
	{
		return createSVector2i(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSVector2i(final SVector2i it)
	{
		String _plus = (Integer.valueOf(it.x) + ";");
		return (_plus + Integer.valueOf(it.y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSVector2iToString(EDataType eDataType, Object instanceValue)
	{
		return convertSVector2i((SVector2i)instanceValue);
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
