/**
 */
package org.sheepy.common.model.ui.provider;


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

import org.sheepy.common.model.presentation.PresentationPackage;
import org.sheepy.common.model.types.TypesPackage;
import org.sheepy.common.model.ui.Panel;
import org.sheepy.common.model.ui.UiFactory;
import org.sheepy.common.model.ui.UiPackage;

/**
 * This is the item provider adapter for a {@link org.sheepy.common.model.ui.Panel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PanelItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PanelItemProvider(AdapterFactory adapterFactory)
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

			addNamePropertyDescriptor(object);
			addPositionPropertyDescriptor(object);
			addVerticalRelativePropertyDescriptor(object);
			addHorizontalRelativePropertyDescriptor(object);
			addWidthPropertyDescriptor(object);
			addHeightPropertyDescriptor(object);
			addShowTitlePropertyDescriptor(object);
			addMinimizablePropertyDescriptor(object);
			addMovablePropertyDescriptor(object);
			addMinimizedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LNamedElement_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LNamedElement_name_feature", "_UI_LNamedElement_type"),
				 TypesPackage.Literals.LNAMED_ELEMENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vertical Relative feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVerticalRelativePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IPositionElement_verticalRelative_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IPositionElement_verticalRelative_feature", "_UI_IPositionElement_type"),
				 PresentationPackage.Literals.IPOSITION_ELEMENT__VERTICAL_RELATIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Horizontal Relative feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHorizontalRelativePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IPositionElement_horizontalRelative_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IPositionElement_horizontalRelative_feature", "_UI_IPositionElement_type"),
				 PresentationPackage.Literals.IPOSITION_ELEMENT__HORIZONTAL_RELATIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Position feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPositionPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IPositionElement_position_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IPositionElement_position_feature", "_UI_IPositionElement_type"),
				 PresentationPackage.Literals.IPOSITION_ELEMENT__POSITION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Width feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWidthPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ISizedElement_width_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ISizedElement_width_feature", "_UI_ISizedElement_type"),
				 PresentationPackage.Literals.ISIZED_ELEMENT__WIDTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Height feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHeightPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ISizedElement_height_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ISizedElement_height_feature", "_UI_ISizedElement_type"),
				 PresentationPackage.Literals.ISIZED_ELEMENT__HEIGHT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Show Title feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addShowTitlePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Panel_showTitle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Panel_showTitle_feature", "_UI_Panel_type"),
				 UiPackage.Literals.PANEL__SHOW_TITLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Minimizable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinimizablePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Panel_minimizable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Panel_minimizable_feature", "_UI_Panel_type"),
				 UiPackage.Literals.PANEL__MINIMIZABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Movable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMovablePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Panel_movable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Panel_movable_feature", "_UI_Panel_type"),
				 UiPackage.Literals.PANEL__MOVABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Minimized feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinimizedPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Panel_minimized_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Panel_minimized_feature", "_UI_Panel_type"),
				 UiPackage.Literals.PANEL__MINIMIZED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(UiPackage.Literals.PANEL__CONTROLS);
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
	 * This returns Panel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Panel"));
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
		String label = ((Panel)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Panel_type") :
			getString("_UI_Panel_type") + " " + label;
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

		switch (notification.getFeatureID(Panel.class))
		{
			case UiPackage.PANEL__NAME:
			case UiPackage.PANEL__CONTENT_OBJECTS:
			case UiPackage.PANEL__POSITION:
			case UiPackage.PANEL__VERTICAL_RELATIVE:
			case UiPackage.PANEL__HORIZONTAL_RELATIVE:
			case UiPackage.PANEL__WIDTH:
			case UiPackage.PANEL__HEIGHT:
			case UiPackage.PANEL__SHOW_TITLE:
			case UiPackage.PANEL__MINIMIZABLE:
			case UiPackage.PANEL__MOVABLE:
			case UiPackage.PANEL__MINIMIZED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case UiPackage.PANEL__CONTROLS:
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
				(UiPackage.Literals.PANEL__CONTROLS,
				 UiFactory.eINSTANCE.createDynamicRowLayout()));

		newChildDescriptors.add
			(createChildParameter
				(UiPackage.Literals.PANEL__CONTROLS,
				 UiFactory.eINSTANCE.createVariableLabel()));

		newChildDescriptors.add
			(createChildParameter
				(UiPackage.Literals.PANEL__CONTROLS,
				 UiFactory.eINSTANCE.createLabel()));

		newChildDescriptors.add
			(createChildParameter
				(UiPackage.Literals.PANEL__CONTROLS,
				 UiFactory.eINSTANCE.createSlider()));

		newChildDescriptors.add
			(createChildParameter
				(UiPackage.Literals.PANEL__CONTROLS,
				 UiFactory.eINSTANCE.createTextField()));

		newChildDescriptors.add
			(createChildParameter
				(UiPackage.Literals.PANEL__CONTROLS,
				 UiFactory.eINSTANCE.createButton()));

		newChildDescriptors.add
			(createChildParameter
				(UiPackage.Literals.PANEL__CONTROLS,
				 UiFactory.eINSTANCE.createBooleanButton()));

		newChildDescriptors.add
			(createChildParameter
				(UiPackage.Literals.PANEL__CONTROLS,
				 UiFactory.eINSTANCE.createBooleanActionButton()));
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
