/**
 */
package org.sheepy.lily.core.model.variable;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IDefinition Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.IDefinitionContainer#getVariableDefinition <em>Variable Definition</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.variable.VariablePackage#getIDefinitionContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IDefinitionContainer extends EObject
{
	/**
	 * Returns the value of the '<em><b>Variable Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Definition</em>' attribute.
	 * @see #setVariableDefinition(String)
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#getIDefinitionContainer_VariableDefinition()
	 * @model unique="false" dataType="org.sheepy.lily.core.model.variable.VariableDefinition" required="true"
	 * @generated
	 */
	String getVariableDefinition();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.variable.IDefinitionContainer#getVariableDefinition <em>Variable Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Definition</em>' attribute.
	 * @see #getVariableDefinition()
	 * @generated
	 */
	void setVariableDefinition(String value);

} // IDefinitionContainer
