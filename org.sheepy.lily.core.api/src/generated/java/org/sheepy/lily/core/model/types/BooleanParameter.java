/**
 */
package org.sheepy.lily.core.model.types;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.types.BooleanParameter#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.types.TypesPackage#getBooleanParameter()
 * @model superTypes="org.sheepy.lily.core.model.types.NativeParameter&lt;org.eclipse.emf.ecore.EBooleanObject&gt;"
 * @generated
 */
public interface BooleanParameter extends NativeParameter<Boolean>
{
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Boolean)
	 * @see org.sheepy.lily.core.model.types.TypesPackage#getBooleanParameter_Value()
	 * @model unique="false"
	 * @generated
	 */
	Boolean getValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.types.BooleanParameter#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	@Override
	Boolean getNativeValue();

} // BooleanParameter
