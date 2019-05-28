/**
 */
package org.sheepy.lily.core.model.builder;

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
 * @see org.sheepy.lily.core.model.builder.BuilderFactory
 * @model kind="package"
 * @generated
 */
public interface BuilderPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "builder";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.core.model.builder";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "builder";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BuilderPackage eINSTANCE = org.sheepy.lily.core.model.builder.impl.BuilderPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.builder.Buildable <em>Buildable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.builder.Buildable
	 * @see org.sheepy.lily.core.model.builder.impl.BuilderPackageImpl#getBuildable()
	 * @generated
	 */
	int BUILDABLE = 0;

	/**
	 * The feature id for the '<em><b>Builder</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDABLE__BUILDER = 0;

	/**
	 * The number of structural features of the '<em>Buildable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Buildable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.builder.Builder <em>Builder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.builder.Builder
	 * @see org.sheepy.lily.core.model.builder.impl.BuilderPackageImpl#getBuilder()
	 * @generated
	 */
	int BUILDER = 1;

	/**
	 * The number of structural features of the '<em>Builder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Builder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDER_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.builder.Buildable <em>Buildable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buildable</em>'.
	 * @see org.sheepy.lily.core.model.builder.Buildable
	 * @generated
	 */
	EClass getBuildable();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.builder.Buildable#getBuilder <em>Builder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Builder</em>'.
	 * @see org.sheepy.lily.core.model.builder.Buildable#getBuilder()
	 * @see #getBuildable()
	 * @generated
	 */
	EReference getBuildable_Builder();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.builder.Builder <em>Builder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Builder</em>'.
	 * @see org.sheepy.lily.core.model.builder.Builder
	 * @generated
	 */
	EClass getBuilder();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BuilderFactory getBuilderFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.builder.Buildable <em>Buildable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.builder.Buildable
		 * @see org.sheepy.lily.core.model.builder.impl.BuilderPackageImpl#getBuildable()
		 * @generated
		 */
		EClass BUILDABLE = eINSTANCE.getBuildable();

		/**
		 * The meta object literal for the '<em><b>Builder</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUILDABLE__BUILDER = eINSTANCE.getBuildable_Builder();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.builder.Builder <em>Builder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.builder.Builder
		 * @see org.sheepy.lily.core.model.builder.impl.BuilderPackageImpl#getBuilder()
		 * @generated
		 */
		EClass BUILDER = eINSTANCE.getBuilder();

	}

} //BuilderPackage
