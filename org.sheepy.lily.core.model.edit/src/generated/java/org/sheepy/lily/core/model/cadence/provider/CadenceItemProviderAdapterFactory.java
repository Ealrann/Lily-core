/**
 */
package org.sheepy.lily.core.model.cadence.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.sheepy.lily.core.model.cadence.CadencePackage;

import org.sheepy.lily.core.model.cadence.util.CadenceAdapterFactory;

import org.sheepy.lily.core.model.types.provider.LilyEditPlugin;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CadenceItemProviderAdapterFactory extends CadenceAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender
{
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This helps manage the child creation extenders.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(LilyEditPlugin.INSTANCE, CadencePackage.eNS_URI);

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CadenceItemProviderAdapterFactory()
	{
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.core.model.cadence.Cadence} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CadenceItemProvider cadenceItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.core.model.cadence.Cadence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCadenceAdapter()
	{
		if (cadenceItemProvider == null)
		{
			cadenceItemProvider = new CadenceItemProvider(this);
		}

		return cadenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.core.model.cadence.ExecuteWhile} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecuteWhileItemProvider executeWhileItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.core.model.cadence.ExecuteWhile}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExecuteWhileAdapter()
	{
		if (executeWhileItemProvider == null)
		{
			executeWhileItemProvider = new ExecuteWhileItemProvider(this);
		}

		return executeWhileItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.core.model.cadence.ExecuteIf} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecuteIfItemProvider executeIfItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.core.model.cadence.ExecuteIf}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExecuteIfAdapter()
	{
		if (executeIfItemProvider == null)
		{
			executeIfItemProvider = new ExecuteIfItemProvider(this);
		}

		return executeIfItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.core.model.cadence.PrintUPS} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrintUPSItemProvider printUPSItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.core.model.cadence.PrintUPS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPrintUPSAdapter()
	{
		if (printUPSItemProvider == null)
		{
			printUPSItemProvider = new PrintUPSItemProvider(this);
		}

		return printUPSItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.core.model.cadence.HaveTime} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HaveTimeItemProvider haveTimeItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.core.model.cadence.HaveTime}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHaveTimeAdapter()
	{
		if (haveTimeItemProvider == null)
		{
			haveTimeItemProvider = new HaveTimeItemProvider(this);
		}

		return haveTimeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.core.model.cadence.CountUntil} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CountUntilItemProvider countUntilItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.core.model.cadence.CountUntil}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCountUntilAdapter()
	{
		if (countUntilItemProvider == null)
		{
			countUntilItemProvider = new CountUntilItemProvider(this);
		}

		return countUntilItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.core.model.cadence.CloseApplication} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CloseApplicationItemProvider closeApplicationItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.core.model.cadence.CloseApplication}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCloseApplicationAdapter()
	{
		if (closeApplicationItemProvider == null)
		{
			closeApplicationItemProvider = new CloseApplicationItemProvider(this);
		}

		return closeApplicationItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory()
	{
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
	{
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type)
	{
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type)
	{
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type)
	{
		if (isFactoryForType(type))
		{
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter)))
			{
				return adapter;
			}
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<IChildCreationExtender> getChildCreationExtenders()
	{
		return childCreationExtenderManager.getChildCreationExtenders();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain)
	{
		return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		return childCreationExtenderManager;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener)
	{
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener)
	{
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification)
	{
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null)
		{
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void dispose()
	{
		if (cadenceItemProvider != null) cadenceItemProvider.dispose();
		if (executeWhileItemProvider != null) executeWhileItemProvider.dispose();
		if (executeIfItemProvider != null) executeIfItemProvider.dispose();
		if (printUPSItemProvider != null) printUPSItemProvider.dispose();
		if (haveTimeItemProvider != null) haveTimeItemProvider.dispose();
		if (countUntilItemProvider != null) countUntilItemProvider.dispose();
		if (closeApplicationItemProvider != null) closeApplicationItemProvider.dispose();
	}

}
