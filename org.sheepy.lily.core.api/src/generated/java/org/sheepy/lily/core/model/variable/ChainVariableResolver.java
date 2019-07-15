/**
 */
package org.sheepy.lily.core.model.variable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Chain Variable Resolver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.ChainVariableResolver#getFirstResolver <em>First Resolver</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.variable.ChainVariableResolver#getSubResolvers <em>Sub Resolvers</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.variable.VariablePackage#getChainVariableResolver()
 * @model
 * @generated
 */
public interface ChainVariableResolver extends IVariableResolver
{
	/**
	 * Returns the value of the '<em><b>First Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Resolver</em>' containment reference.
	 * @see #setFirstResolver(IVariableResolver)
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#getChainVariableResolver_FirstResolver()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IVariableResolver getFirstResolver();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.variable.ChainVariableResolver#getFirstResolver <em>First Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Resolver</em>' containment reference.
	 * @see #getFirstResolver()
	 * @generated
	 */
	void setFirstResolver(IVariableResolver value);

	/**
	 * Returns the value of the '<em><b>Sub Resolvers</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.variable.ChainResolver}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Resolvers</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.variable.VariablePackage#getChainVariableResolver_SubResolvers()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ChainResolver> getSubResolvers();

} // ChainVariableResolver
