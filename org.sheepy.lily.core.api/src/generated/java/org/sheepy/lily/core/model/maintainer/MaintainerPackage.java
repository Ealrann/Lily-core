/**
 */
package org.sheepy.lily.core.model.maintainer;

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
 * @see org.sheepy.lily.core.model.maintainer.MaintainerFactory
 * @model kind="package"
 * @generated
 */
public interface MaintainerPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "maintainer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.core.model.maintainer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "maintainer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MaintainerPackage eINSTANCE = org.sheepy.lily.core.model.maintainer.impl.MaintainerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.maintainer.Maintainable <em>Maintainable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.maintainer.Maintainable
	 * @see org.sheepy.lily.core.model.maintainer.impl.MaintainerPackageImpl#getMaintainable()
	 * @generated
	 */
	int MAINTAINABLE = 0;

	/**
	 * The feature id for the '<em><b>Maintainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAINTAINABLE__MAINTAINER = 0;

	/**
	 * The number of structural features of the '<em>Maintainable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAINTAINABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.maintainer.Maintainer <em>Maintainer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.maintainer.Maintainer
	 * @see org.sheepy.lily.core.model.maintainer.impl.MaintainerPackageImpl#getMaintainer()
	 * @generated
	 */
	int MAINTAINER = 1;

	/**
	 * The feature id for the '<em><b>Maintained</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAINTAINER__MAINTAINED = 0;

	/**
	 * The number of structural features of the '<em>Maintainer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAINTAINER_FEATURE_COUNT = 1;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.maintainer.Maintainable <em>Maintainable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Maintainable</em>'.
	 * @see org.sheepy.lily.core.model.maintainer.Maintainable
	 * @generated
	 */
	EClass getMaintainable();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.maintainer.Maintainable#getMaintainer <em>Maintainer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Maintainer</em>'.
	 * @see org.sheepy.lily.core.model.maintainer.Maintainable#getMaintainer()
	 * @see #getMaintainable()
	 * @generated
	 */
	EReference getMaintainable_Maintainer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.maintainer.Maintainer <em>Maintainer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Maintainer</em>'.
	 * @see org.sheepy.lily.core.model.maintainer.Maintainer
	 * @generated
	 */
	EClass getMaintainer();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.core.model.maintainer.Maintainer#getMaintained <em>Maintained</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Maintained</em>'.
	 * @see org.sheepy.lily.core.model.maintainer.Maintainer#getMaintained()
	 * @see #getMaintainer()
	 * @generated
	 */
	EReference getMaintainer_Maintained();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MaintainerFactory getMaintainerFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.maintainer.Maintainable <em>Maintainable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.maintainer.Maintainable
		 * @see org.sheepy.lily.core.model.maintainer.impl.MaintainerPackageImpl#getMaintainable()
		 * @generated
		 */
		EClass MAINTAINABLE = eINSTANCE.getMaintainable();

		/**
		 * The meta object literal for the '<em><b>Maintainer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAINTAINABLE__MAINTAINER = eINSTANCE.getMaintainable_Maintainer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.maintainer.Maintainer <em>Maintainer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.maintainer.Maintainer
		 * @see org.sheepy.lily.core.model.maintainer.impl.MaintainerPackageImpl#getMaintainer()
		 * @generated
		 */
		EClass MAINTAINER = eINSTANCE.getMaintainer();

		/**
		 * The meta object literal for the '<em><b>Maintained</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAINTAINER__MAINTAINED = eINSTANCE.getMaintainer_Maintained();

	}

} //MaintainerPackage
