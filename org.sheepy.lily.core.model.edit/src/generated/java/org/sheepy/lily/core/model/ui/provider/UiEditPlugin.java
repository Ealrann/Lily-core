/**
 */
package org.sheepy.common.model.ui.provider;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.sheepy.common.model.action.provider.ActionEditPlugin;

import org.sheepy.common.model.application.provider.ApplicationEditPlugin;

import org.sheepy.common.model.inference.provider.InferenceEditPlugin;

import org.sheepy.common.model.presentation.provider.PresentationEditPlugin;

import org.sheepy.common.model.root.provider.RootEditPlugin;

import org.sheepy.common.model.types.provider.TypesEditPlugin;

import org.sheepy.common.model.variable.provider.VariableEditPlugin;

/**
 * This is the central singleton for the Ui edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class UiEditPlugin extends EMFPlugin
{
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final UiEditPlugin INSTANCE = new UiEditPlugin();

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
	public UiEditPlugin()
	{
		super
		  (new ResourceLocator [] 
		   {
		     PresentationEditPlugin.INSTANCE,
		     TypesEditPlugin.INSTANCE,
		     RootEditPlugin.INSTANCE,
		     InferenceEditPlugin.INSTANCE,
		     EcoreEditPlugin.INSTANCE,
		     VariableEditPlugin.INSTANCE,
		     ActionEditPlugin.INSTANCE,
		     ApplicationEditPlugin.INSTANCE,
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
