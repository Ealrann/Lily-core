/**
 */
package org.sheepy.lily.core.allocation.test.testallocation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.core.allocation.test.testallocation.TestallocationFactory
 * @model kind="package"
 * @generated
 */
public interface TestallocationPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testallocation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "testallocation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testallocation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestallocationPackage eINSTANCE = org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.allocation.test.testallocation.impl.AllocationObjectImpl <em>Allocation Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.AllocationObjectImpl
	 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl#getAllocationObject()
	 * @generated
	 */
	int ALLOCATION_OBJECT = 5;

	/**
	 * The feature id for the '<em><b>Current Allocation Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_OBJECT__CURRENT_ALLOCATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Total Allocation Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_OBJECT__TOTAL_ALLOCATION_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Dependency Update Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_OBJECT__DEPENDENCY_UPDATE_COUNT = 2;

	/**
	 * The number of structural features of the '<em>Allocation Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_OBJECT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Allocation Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.allocation.test.testallocation.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.RootImpl
	 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 0;

	/**
	 * The feature id for the '<em><b>Current Allocation Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__CURRENT_ALLOCATION_COUNT = ALLOCATION_OBJECT__CURRENT_ALLOCATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Allocation Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__TOTAL_ALLOCATION_COUNT = ALLOCATION_OBJECT__TOTAL_ALLOCATION_COUNT;

	/**
	 * The feature id for the '<em><b>Dependency Update Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__DEPENDENCY_UPDATE_COUNT = ALLOCATION_OBJECT__DEPENDENCY_UPDATE_COUNT;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__NODES = ALLOCATION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__CONTAINERS = ALLOCATION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = ALLOCATION_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_OPERATION_COUNT = ALLOCATION_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.allocation.test.testallocation.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.NodeImpl
	 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>Current Allocation Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CURRENT_ALLOCATION_COUNT = ALLOCATION_OBJECT__CURRENT_ALLOCATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Allocation Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TOTAL_ALLOCATION_COUNT = ALLOCATION_OBJECT__TOTAL_ALLOCATION_COUNT;

	/**
	 * The feature id for the '<em><b>Dependency Update Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DEPENDENCY_UPDATE_COUNT = ALLOCATION_OBJECT__DEPENDENCY_UPDATE_COUNT;

	/**
	 * The feature id for the '<em><b>Leaves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__LEAVES = ALLOCATION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CONTAINER = ALLOCATION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = ALLOCATION_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = ALLOCATION_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.allocation.test.testallocation.impl.ContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.ContainerImpl
	 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Current Allocation Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__CURRENT_ALLOCATION_COUNT = ALLOCATION_OBJECT__CURRENT_ALLOCATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Allocation Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__TOTAL_ALLOCATION_COUNT = ALLOCATION_OBJECT__TOTAL_ALLOCATION_COUNT;

	/**
	 * The feature id for the '<em><b>Dependency Update Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__DEPENDENCY_UPDATE_COUNT = ALLOCATION_OBJECT__DEPENDENCY_UPDATE_COUNT;

	/**
	 * The feature id for the '<em><b>Boxes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__BOXES = ALLOCATION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = ALLOCATION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_OPERATION_COUNT = ALLOCATION_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.allocation.test.testallocation.impl.LeafImpl <em>Leaf</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.LeafImpl
	 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl#getLeaf()
	 * @generated
	 */
	int LEAF = 3;

	/**
	 * The feature id for the '<em><b>Current Allocation Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__CURRENT_ALLOCATION_COUNT = ALLOCATION_OBJECT__CURRENT_ALLOCATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Allocation Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__TOTAL_ALLOCATION_COUNT = ALLOCATION_OBJECT__TOTAL_ALLOCATION_COUNT;

	/**
	 * The feature id for the '<em><b>Dependency Update Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__DEPENDENCY_UPDATE_COUNT = ALLOCATION_OBJECT__DEPENDENCY_UPDATE_COUNT;

	/**
	 * The feature id for the '<em><b>Boxes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__BOXES = ALLOCATION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Leaf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_FEATURE_COUNT = ALLOCATION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Leaf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_OPERATION_COUNT = ALLOCATION_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.allocation.test.testallocation.impl.BoxImpl <em>Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.BoxImpl
	 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl#getBox()
	 * @generated
	 */
	int BOX = 4;

	/**
	 * The feature id for the '<em><b>Current Allocation Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__CURRENT_ALLOCATION_COUNT = ALLOCATION_OBJECT__CURRENT_ALLOCATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Allocation Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__TOTAL_ALLOCATION_COUNT = ALLOCATION_OBJECT__TOTAL_ALLOCATION_COUNT;

	/**
	 * The feature id for the '<em><b>Dependency Update Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__DEPENDENCY_UPDATE_COUNT = ALLOCATION_OBJECT__DEPENDENCY_UPDATE_COUNT;

	/**
	 * The number of structural features of the '<em>Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX_FEATURE_COUNT = ALLOCATION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX_OPERATION_COUNT = ALLOCATION_OBJECT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.allocation.test.testallocation.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.allocation.test.testallocation.Root#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.Root#getNodes()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.allocation.test.testallocation.Root#getContainers <em>Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Containers</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.Root#getContainers()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Containers();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.allocation.test.testallocation.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.allocation.test.testallocation.Node#getLeaves <em>Leaves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Leaves</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.Node#getLeaves()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Leaves();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.allocation.test.testallocation.Node#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.Node#getContainer()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Container();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.allocation.test.testallocation.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.allocation.test.testallocation.Container#getBoxes <em>Boxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Boxes</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.Container#getBoxes()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Boxes();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.allocation.test.testallocation.Leaf <em>Leaf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.Leaf
	 * @generated
	 */
	EClass getLeaf();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.core.allocation.test.testallocation.Leaf#getBoxes <em>Boxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Boxes</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.Leaf#getBoxes()
	 * @see #getLeaf()
	 * @generated
	 */
	EReference getLeaf_Boxes();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.allocation.test.testallocation.Box <em>Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Box</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.Box
	 * @generated
	 */
	EClass getBox();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.allocation.test.testallocation.AllocationObject <em>Allocation Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocation Object</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.AllocationObject
	 * @generated
	 */
	EClass getAllocationObject();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#getCurrentAllocationCount <em>Current Allocation Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Allocation Count</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#getCurrentAllocationCount()
	 * @see #getAllocationObject()
	 * @generated
	 */
	EAttribute getAllocationObject_CurrentAllocationCount();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#getTotalAllocationCount <em>Total Allocation Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Allocation Count</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#getTotalAllocationCount()
	 * @see #getAllocationObject()
	 * @generated
	 */
	EAttribute getAllocationObject_TotalAllocationCount();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#getDependencyUpdateCount <em>Dependency Update Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependency Update Count</em>'.
	 * @see org.sheepy.lily.core.allocation.test.testallocation.AllocationObject#getDependencyUpdateCount()
	 * @see #getAllocationObject()
	 * @generated
	 */
	EAttribute getAllocationObject_DependencyUpdateCount();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestallocationFactory getTestallocationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.allocation.test.testallocation.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.RootImpl
		 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__NODES = eINSTANCE.getRoot_Nodes();

		/**
		 * The meta object literal for the '<em><b>Containers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__CONTAINERS = eINSTANCE.getRoot_Containers();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.allocation.test.testallocation.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.NodeImpl
		 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Leaves</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__LEAVES = eINSTANCE.getNode_Leaves();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CONTAINER = eINSTANCE.getNode_Container();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.allocation.test.testallocation.impl.ContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.ContainerImpl
		 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Boxes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__BOXES = eINSTANCE.getContainer_Boxes();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.allocation.test.testallocation.impl.LeafImpl <em>Leaf</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.LeafImpl
		 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl#getLeaf()
		 * @generated
		 */
		EClass LEAF = eINSTANCE.getLeaf();

		/**
		 * The meta object literal for the '<em><b>Boxes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LEAF__BOXES = eINSTANCE.getLeaf_Boxes();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.allocation.test.testallocation.impl.BoxImpl <em>Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.BoxImpl
		 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl#getBox()
		 * @generated
		 */
		EClass BOX = eINSTANCE.getBox();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.allocation.test.testallocation.impl.AllocationObjectImpl <em>Allocation Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.AllocationObjectImpl
		 * @see org.sheepy.lily.core.allocation.test.testallocation.impl.TestallocationPackageImpl#getAllocationObject()
		 * @generated
		 */
		EClass ALLOCATION_OBJECT = eINSTANCE.getAllocationObject();

		/**
		 * The meta object literal for the '<em><b>Current Allocation Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALLOCATION_OBJECT__CURRENT_ALLOCATION_COUNT = eINSTANCE.getAllocationObject_CurrentAllocationCount();

		/**
		 * The meta object literal for the '<em><b>Total Allocation Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALLOCATION_OBJECT__TOTAL_ALLOCATION_COUNT = eINSTANCE.getAllocationObject_TotalAllocationCount();

		/**
		 * The meta object literal for the '<em><b>Dependency Update Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALLOCATION_OBJECT__DEPENDENCY_UPDATE_COUNT = eINSTANCE.getAllocationObject_DependencyUpdateCount();

	}

} //TestallocationPackage
