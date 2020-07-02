/**
 */
package org.sheepy.lily.core.allocation.test.testallocation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.core.allocation.test.testallocation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestallocationFactoryImpl extends EFactoryImpl implements TestallocationFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TestallocationFactory init()
	{
		try
		{
			TestallocationFactory theTestallocationFactory = (TestallocationFactory)EPackage.Registry.INSTANCE.getEFactory(TestallocationPackage.eNS_URI);
			if (theTestallocationFactory != null)
			{
				return theTestallocationFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestallocationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestallocationFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case TestallocationPackage.ROOT: return (EObject)createRoot();
			case TestallocationPackage.NODE: return (EObject)createNode();
			case TestallocationPackage.CONTAINER: return (EObject)createContainer();
			case TestallocationPackage.LEAF: return (EObject)createLeaf();
			case TestallocationPackage.BOX: return (EObject)createBox();
			case TestallocationPackage.ALLOCATION_OBJECT: return (EObject)createAllocationObject();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Root createRoot()
	{
		RootImpl root = new RootImpl();
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node createNode()
	{
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.sheepy.lily.core.allocation.test.testallocation.Container createContainer()
	{
		ContainerImpl container = new ContainerImpl();
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Leaf createLeaf()
	{
		LeafImpl leaf = new LeafImpl();
		return leaf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Box createBox()
	{
		BoxImpl box = new BoxImpl();
		return box;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AllocationObject createAllocationObject()
	{
		AllocationObjectImpl allocationObject = new AllocationObjectImpl();
		return allocationObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestallocationPackage getTestallocationPackage()
	{
		return (TestallocationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TestallocationPackage getPackage()
	{
		return TestallocationPackage.eINSTANCE;
	}

} //TestallocationFactoryImpl
