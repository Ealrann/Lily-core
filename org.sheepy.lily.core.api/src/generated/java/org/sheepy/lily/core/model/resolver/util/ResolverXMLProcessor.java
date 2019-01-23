/**
 */
package org.sheepy.lily.core.model.resolver.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.sheepy.lily.core.model.resolver.ResolverPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ResolverXMLProcessor extends XMLProcessor
{

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolverXMLProcessor()
	{
		super((EPackage.Registry.INSTANCE));
		ResolverPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the ResolverResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations()
	{
		if (registrations == null)
		{
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new ResolverResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new ResolverResourceFactoryImpl());
		}
		return registrations;
	}

} //ResolverXMLProcessor
