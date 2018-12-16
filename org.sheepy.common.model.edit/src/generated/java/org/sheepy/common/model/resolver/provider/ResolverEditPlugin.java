/**
 */
package org.sheepy.common.model.resolver.provider;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.sheepy.common.model.action.provider.ActionEditPlugin;

import org.sheepy.common.model.inference.provider.InferenceEditPlugin;

import org.sheepy.common.model.root.provider.RootEditPlugin;

import org.sheepy.common.model.types.provider.TypesEditPlugin;

/**
 * This is the central singleton for the Resolver edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class ResolverEditPlugin extends EMFPlugin
{
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ResolverEditPlugin INSTANCE = new ResolverEditPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolverEditPlugin()
	{
		super
		  (new ResourceLocator [] 
		   {
		     RootEditPlugin.INSTANCE,
		     EcoreEditPlugin.INSTANCE,
		     InferenceEditPlugin.INSTANCE,
		     ActionEditPlugin.INSTANCE,
		     TypesEditPlugin.INSTANCE,
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator()
	{
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin()
	{
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin
	{
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation()
		{
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

}
