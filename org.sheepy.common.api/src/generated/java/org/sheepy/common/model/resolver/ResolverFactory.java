/**
 */
package org.sheepy.common.model.resolver;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.common.model.resolver.ResolverPackage
 * @generated
 */
public interface ResolverFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResolverFactory eINSTANCE = org.sheepy.common.model.resolver.impl.ResolverFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EReference Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EReference Resolver</em>'.
	 * @generated
	 */
	EReferenceResolver createEReferenceResolver();

	/**
	 * Returns a new object of class '<em>Chain Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Chain Resolver</em>'.
	 * @generated
	 */
	ChainResolver createChainResolver();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResolverPackage getResolverPackage();

} //ResolverFactory
