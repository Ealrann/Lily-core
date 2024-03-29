/**
 */
package org.sheepy.lily.core.model.ui.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.core.model.ui.UiFactory;
import org.sheepy.lily.core.model.ui.UiPackage;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.core.model.ui.UI} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UIItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIItemProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
	{
		if (itemPropertyDescriptors == null)
		{
			super.getPropertyDescriptors(object);

			addEnabledPropertyDescriptor(object);
			addCurrentUIPagePropertyDescriptor(object);
			addDstImagePropertyDescriptor(object);
			addImagesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnabledPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ICompositor_enabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ICompositor_enabled_feature", "_UI_ICompositor_type"),
				 ApplicationPackage.Literals.ICOMPOSITOR__ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Current UI Page feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCurrentUIPagePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UI_currentUIPage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UI_currentUIPage_feature", "_UI_UI_type"),
				 UiPackage.Literals.UI__CURRENT_UI_PAGE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dst Image feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDstImagePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UI_dstImage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UI_dstImage_feature", "_UI_UI_type"),
				 UiPackage.Literals.UI__DST_IMAGE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Images feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImagesPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UI_images_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UI_images_feature", "_UI_UI_type"),
				 UiPackage.Literals.UI__IMAGES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
	{
		if (childrenFeatures == null)
		{
			super.getChildrenFeatures(object);
			childrenFeatures.add(ApplicationPackage.Literals.ICOMPOSITOR__EXTENSION_PKG);
			childrenFeatures.add(UiPackage.Literals.UI__UI_PAGES);
			childrenFeatures.add(UiPackage.Literals.UI__FONT_PKG);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child)
	{
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns UI.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/UI"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object)
	{
		UI ui = (UI)object;
		return getString("_UI_UI_type") + " " + ui.isEnabled();
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification)
	{
		updateChildren(notification);

		switch (notification.getFeatureID(UI.class))
		{
			case UiPackage.UI__ENABLED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case UiPackage.UI__EXTENSION_PKG:
			case UiPackage.UI__UI_PAGES:
			case UiPackage.UI__FONT_PKG:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
	{
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ApplicationPackage.Literals.ICOMPOSITOR__EXTENSION_PKG,
				 ApplicationFactory.eINSTANCE.createCompositorExtensionPkg()));

		newChildDescriptors.add
			(createChildParameter
				(UiPackage.Literals.UI__UI_PAGES,
				 UiFactory.eINSTANCE.createUIPage()));

		newChildDescriptors.add
			(createChildParameter
				(UiPackage.Literals.UI__FONT_PKG,
				 UiFactory.eINSTANCE.createFontPkg()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		return ((IChildCreationExtender)adapterFactory).getResourceLocator();
	}

}
