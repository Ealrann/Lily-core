/**
 */
package org.sheepy.lily.core.allocation.test.testallocation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.allocation.test.testallocation.Leaf;
import org.sheepy.lily.core.allocation.test.testallocation.Node;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.impl.NodeImpl#getLeaves <em>Leaves</em>}</li>
 *   <li>{@link org.sheepy.lily.core.allocation.test.testallocation.impl.NodeImpl#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends AllocationObjectImpl implements Node
{
	/**
	 * The cached value of the '{@link #getLeaves() <em>Leaves</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeaves()
	 * @generated
	 * @ordered
	 */
	protected EList<Leaf> leaves;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected org.sheepy.lily.core.allocation.test.testallocation.Container container;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return TestallocationPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Leaf> getLeaves()
	{
		if (leaves == null)
		{
			leaves = new EObjectContainmentEList<Leaf>(Leaf.class, this, TestallocationPackage.NODE__LEAVES);
		}
		return leaves;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.sheepy.lily.core.allocation.test.testallocation.Container getContainer()
	{
		if (container != null && ((EObject)container).eIsProxy())
		{
			InternalEObject oldContainer = (InternalEObject)container;
			container = (org.sheepy.lily.core.allocation.test.testallocation.Container)eResolveProxy(oldContainer);
			if (container != oldContainer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestallocationPackage.NODE__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.sheepy.lily.core.allocation.test.testallocation.Container basicGetContainer()
	{
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContainer(org.sheepy.lily.core.allocation.test.testallocation.Container newContainer)
	{
		org.sheepy.lily.core.allocation.test.testallocation.Container oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestallocationPackage.NODE__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case TestallocationPackage.NODE__LEAVES:
				return ((InternalEList<?>)getLeaves()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case TestallocationPackage.NODE__LEAVES:
				return getLeaves();
			case TestallocationPackage.NODE__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case TestallocationPackage.NODE__LEAVES:
				getLeaves().clear();
				getLeaves().addAll((Collection<? extends Leaf>)newValue);
				return;
			case TestallocationPackage.NODE__CONTAINER:
				setContainer((org.sheepy.lily.core.allocation.test.testallocation.Container)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case TestallocationPackage.NODE__LEAVES:
				getLeaves().clear();
				return;
			case TestallocationPackage.NODE__CONTAINER:
				setContainer((org.sheepy.lily.core.allocation.test.testallocation.Container)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case TestallocationPackage.NODE__LEAVES:
				return leaves != null && !leaves.isEmpty();
			case TestallocationPackage.NODE__CONTAINER:
				return container != null;
		}
		return super.eIsSet(featureID);
	}

} //NodeImpl
