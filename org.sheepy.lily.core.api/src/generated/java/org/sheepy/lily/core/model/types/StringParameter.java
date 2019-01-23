/**
 */
package org.sheepy.lily.core.model.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.types.StringParameter#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.types.TypesPackage#getStringParameter()
 * @model superTypes="org.sheepy.lily.core.model.types.NativeParameter&lt;org.eclipse.emf.ecore.EString&gt;"
 * @generated
 */
public interface StringParameter extends NativeParameter<String>
{
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.sheepy.lily.core.model.types.TypesPackage#getStringParameter_Value()
	 * @model unique="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.types.StringParameter#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	@Override
	String getNativeValue();

} // StringParameter
