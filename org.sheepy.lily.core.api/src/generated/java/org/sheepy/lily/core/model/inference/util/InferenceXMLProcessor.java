/**
 */
package org.sheepy.lily.core.model.inference.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.sheepy.lily.core.model.inference.InferencePackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InferenceXMLProcessor extends XMLProcessor
{

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InferenceXMLProcessor()
	{
		super((EPackage.Registry.INSTANCE));
		InferencePackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the InferenceResourceFactoryImpl factory.
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
			registrations.put(XML_EXTENSION, new InferenceResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new InferenceResourceFactoryImpl());
		}
		return registrations;
	}

} //InferenceXMLProcessor
