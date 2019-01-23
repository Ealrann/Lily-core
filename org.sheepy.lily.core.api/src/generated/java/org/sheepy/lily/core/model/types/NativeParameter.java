/**
 */
package org.sheepy.lily.core.model.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Native Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sheepy.lily.core.model.types.TypesPackage#getNativeParameter()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface NativeParameter<T> extends Parameter
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	T getNativeValue();

} // NativeParameter
