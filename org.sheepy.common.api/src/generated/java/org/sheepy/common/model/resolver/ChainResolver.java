/**
 */
package org.sheepy.common.model.resolver;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.sheepy.common.model.root.LObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Chain Resolver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.resolver.ChainResolver#getResolvers <em>Resolvers</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.resolver.ResolverPackage#getChainResolver()
 * @model
 * @generated
 */
public interface ChainResolver extends ILObjectResolver
{
	/**
	 * Returns the value of the '<em><b>Resolvers</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.common.model.resolver.ILObjectResolver}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolvers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolvers</em>' containment reference list.
	 * @see org.sheepy.common.model.resolver.ResolverPackage#getChainResolver_Resolvers()
	 * @model containment="true"
	 * @generated
	 */
	EList<ILObjectResolver> getResolvers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sourceUnique="false" collectedDataType="org.sheepy.common.model.root.LCollection" collectedUnique="false"
	 * @generated
	 */
	void collectUnits(LObject source, Collection<LObject> collected);

} // ChainResolver
