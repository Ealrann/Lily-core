/**
 */
package org.sheepy.common.model.variable;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.common.api.util.ResolvedVariableFeature;

import org.sheepy.common.model.resolver.ILObjectResolver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.variable.VariableResolver#getResolver <em>Resolver</em>}</li>
 *   <li>{@link org.sheepy.common.model.variable.VariableResolver#getVariableDefinition <em>Variable Definition</em>}</li>
 *   <li>{@link org.sheepy.common.model.variable.VariableResolver#getEmfAttributes <em>Emf Attributes</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.variable.VariablePackage#getVariableResolver()
 * @model
 * @generated
 */
public interface VariableResolver extends EObject
{
	/**
	 * Returns the value of the '<em><b>Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolver</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolver</em>' containment reference.
	 * @see #setResolver(ILObjectResolver)
	 * @see org.sheepy.common.model.variable.VariablePackage#getVariableResolver_Resolver()
	 * @model containment="true"
	 * @generated
	 */
	ILObjectResolver getResolver();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.variable.VariableResolver#getResolver <em>Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolver</em>' containment reference.
	 * @see #getResolver()
	 * @generated
	 */
	void setResolver(ILObjectResolver value);

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
	 * @see org.sheepy.common.model.variable.VariablePackage#getVariableResolver_VariableDefinition()
	 * @model unique="false" dataType="org.sheepy.common.model.variable.VariableDefinition"
	 * @generated
	 */
	String getVariableDefinition();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.variable.VariableResolver#getVariableDefinition <em>Variable Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Definition</em>' attribute.
	 * @see #getVariableDefinition()
	 * @generated
	 */
	void setVariableDefinition(String value);

	/**
	 * Returns the value of the '<em><b>Emf Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Emf Attributes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Emf Attributes</em>' attribute.
	 * @see #setEmfAttributes(ResolvedVariableFeature)
	 * @see org.sheepy.common.model.variable.VariablePackage#getVariableResolver_EmfAttributes()
	 * @model unique="false" dataType="org.sheepy.common.model.variable.LResolvedVariableFeature" transient="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel property='None'"
	 * @generated
	 */
	ResolvedVariableFeature getEmfAttributes();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.variable.VariableResolver#getEmfAttributes <em>Emf Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Emf Attributes</em>' attribute.
	 * @see #getEmfAttributes()
	 * @generated
	 */
	void setEmfAttributes(ResolvedVariableFeature value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.sheepy.common.model.variable.LResolvedVariableFeature" unique="false"
	 * @generated
	 */
	ResolvedVariableFeature lEMFAttributes();

} // VariableResolver
