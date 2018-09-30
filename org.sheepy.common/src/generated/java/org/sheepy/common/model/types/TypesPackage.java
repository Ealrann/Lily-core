/**
 */
package org.sheepy.common.model.types;

import org.eclipse.emf.ecore.EDataType;
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
	 * The meta object id for the '<em>SVector2f</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.api.types.SVector2f
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getSVector2f()
	 * @generated
	 */
	int SVECTOR2F = 0;

	/**
	 * The meta object id for the '<em>SVector2i</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.api.types.SVector2i
	 * @see org.sheepy.common.model.types.impl.TypesPackageImpl#getSVector2i()
	 * @generated
	 */
	int SVECTOR2I = 1;


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
