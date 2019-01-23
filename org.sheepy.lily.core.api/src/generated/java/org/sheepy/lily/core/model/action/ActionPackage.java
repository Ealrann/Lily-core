/**
 */
package org.sheepy.lily.core.model.action;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.model.types.TypesPackage;

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
 * @see org.sheepy.lily.core.model.action.ActionFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.lily.core.model/src/generated/java' editDirectory='/org.sheepy.lily.core.model.edit/src/generated/java' publicConstructors='true' complianceLevel='11.0' resource='XMI' extensibleProviderFactory='true' childCreationExtenders='true' updateClasspath='false' basePackage='org.sheepy.lily.core.model'"
 * @generated
 */
public interface ActionPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "action";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.core.model.action";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "action";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionPackage eINSTANCE = org.sheepy.lily.core.model.action.impl.ActionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.action.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.action.impl.ActionImpl
	 * @see org.sheepy.lily.core.model.action.impl.ActionPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.sheepy.lily.core.model.action.impl.ActionPackageImpl#getActionList()
	 * @generated
	 */
	int ACTION_LIST = 1;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.action.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.sheepy.lily.core.model.action.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List&lt;? extends org.sheepy.lily.core.model.action.Action&gt;"
	 * @generated
	 */
	EDataType getActionList();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActionFactory getActionFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.action.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.action.impl.ActionImpl
		 * @see org.sheepy.lily.core.model.action.impl.ActionPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();
		/**
		 * The meta object literal for the '<em>List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.sheepy.lily.core.model.action.impl.ActionPackageImpl#getActionList()
		 * @generated
		 */
		EDataType ACTION_LIST = eINSTANCE.getActionList();

	}

} //ActionPackage
