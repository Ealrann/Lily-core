/**
 */
package org.sheepy.lily.core.model.types;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Float Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.types.FloatParameter#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.types.TypesPackage#getFloatParameter()
 * @model superTypes="org.sheepy.lily.core.model.types.NativeParameter&lt;org.eclipse.emf.ecore.EFloatObject&gt;"
 * @generated
 */
public interface FloatParameter extends NativeParameter<Float>
{
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(float)
	 * @see org.sheepy.lily.core.model.types.TypesPackage#getFloatParameter_Value()
	 * @model unique="false"
	 * @generated
	 */
	float getValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.types.FloatParameter#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(float value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	@Override
	Float getNativeValue();

} // FloatParameter
