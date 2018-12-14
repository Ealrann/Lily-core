/**
 */
package org.sheepy.common.model.action;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.common.model.root.RootPackage;

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
 * @see org.sheepy.common.model.action.ActionFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.common.model/src/generated/java' editDirectory='/org.sheepy.common.model.edit/src/generated/java' publicConstructors='true' extensibleProviderFactory='true' childCreationExtenders='true' basePackage='org.sheepy.common.model'"
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
	String eNS_URI = "org.sheepy.common.model.action";

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
	ActionPackage eINSTANCE = org.sheepy.common.model.action.impl.ActionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.action.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.action.impl.ActionImpl
	 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getAction()
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
	int ACTION__NAME = RootPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = RootPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = RootPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.action.impl.XActionImpl <em>XAction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.action.impl.XActionImpl
	 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getXAction()
	 * @generated
	 */
	int XACTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XACTION__NAME = ACTION__NAME;

	/**
	 * The number of structural features of the '<em>XAction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XACTION___EXECUTE__LOBJECT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>XAction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XACTION_OPERATION_COUNT = ACTION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.action.ParameteredAction <em>Parametered Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.action.ParameteredAction
	 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getParameteredAction()
	 * @generated
	 */
	int PARAMETERED_ACTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERED_ACTION__NAME = ACTION__NAME;

	/**
	 * The number of structural features of the '<em>Parametered Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERED_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parametered Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERED_ACTION_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.action.TypeInjectorAction <em>Type Injector Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.action.TypeInjectorAction
	 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getTypeInjectorAction()
	 * @generated
	 */
	int TYPE_INJECTOR_ACTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INJECTOR_ACTION__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INJECTOR_ACTION__ACTION = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Injector Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INJECTOR_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Injected Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INJECTOR_ACTION___GET_INJECTED_VALUE = ACTION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Type Injector Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INJECTOR_ACTION_OPERATION_COUNT = ACTION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.action.impl.StringInjectorImpl <em>String Injector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.action.impl.StringInjectorImpl
	 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getStringInjector()
	 * @generated
	 */
	int STRING_INJECTOR = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INJECTOR__NAME = TYPE_INJECTOR_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INJECTOR__ACTION = TYPE_INJECTOR_ACTION__ACTION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INJECTOR__VALUE = TYPE_INJECTOR_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Injector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INJECTOR_FEATURE_COUNT = TYPE_INJECTOR_ACTION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Injected Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INJECTOR___GET_INJECTED_VALUE = TYPE_INJECTOR_ACTION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>String Injector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INJECTOR_OPERATION_COUNT = TYPE_INJECTOR_ACTION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.action.impl.NumberInjectorImpl <em>Number Injector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.action.impl.NumberInjectorImpl
	 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getNumberInjector()
	 * @generated
	 */
	int NUMBER_INJECTOR = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_INJECTOR__NAME = TYPE_INJECTOR_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_INJECTOR__ACTION = TYPE_INJECTOR_ACTION__ACTION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_INJECTOR__VALUE = TYPE_INJECTOR_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Number Injector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_INJECTOR_FEATURE_COUNT = TYPE_INJECTOR_ACTION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Injected Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_INJECTOR___GET_INJECTED_VALUE = TYPE_INJECTOR_ACTION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Number Injector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_INJECTOR_OPERATION_COUNT = TYPE_INJECTOR_ACTION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.action.impl.ParameteredActionsPkgImpl <em>Parametered Actions Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.action.impl.ParameteredActionsPkgImpl
	 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getParameteredActionsPkg()
	 * @generated
	 */
	int PARAMETERED_ACTIONS_PKG = 6;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERED_ACTIONS_PKG__ACTIONS = 0;

	/**
	 * The number of structural features of the '<em>Parametered Actions Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERED_ACTIONS_PKG_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Parameter Classifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERED_ACTIONS_PKG___GET_PARAMETER_CLASSIFIER = 0;

	/**
	 * The number of operations of the '<em>Parametered Actions Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERED_ACTIONS_PKG_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.action.impl.ActionsPkgImpl <em>Actions Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.action.impl.ActionsPkgImpl
	 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getActionsPkg()
	 * @generated
	 */
	int ACTIONS_PKG = 7;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIONS_PKG__ACTIONS = 0;

	/**
	 * The number of structural features of the '<em>Actions Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIONS_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Actions Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIONS_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getActionList()
	 * @generated
	 */
	int ACTION_LIST = 8;


	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.action.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.sheepy.common.model.action.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.action.XAction <em>XAction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAction</em>'.
	 * @see org.sheepy.common.model.action.XAction
	 * @generated
	 */
	EClass getXAction();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.action.XAction#execute(org.sheepy.common.model.root.LObject) <em>Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see org.sheepy.common.model.action.XAction#execute(org.sheepy.common.model.root.LObject)
	 * @generated
	 */
	EOperation getXAction__Execute__LObject();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.action.ParameteredAction <em>Parametered Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametered Action</em>'.
	 * @see org.sheepy.common.model.action.ParameteredAction
	 * @generated
	 */
	EClass getParameteredAction();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.action.TypeInjectorAction <em>Type Injector Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Injector Action</em>'.
	 * @see org.sheepy.common.model.action.TypeInjectorAction
	 * @generated
	 */
	EClass getTypeInjectorAction();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.common.model.action.TypeInjectorAction#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action</em>'.
	 * @see org.sheepy.common.model.action.TypeInjectorAction#getAction()
	 * @see #getTypeInjectorAction()
	 * @generated
	 */
	EReference getTypeInjectorAction_Action();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.action.TypeInjectorAction#getInjectedValue() <em>Get Injected Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Injected Value</em>' operation.
	 * @see org.sheepy.common.model.action.TypeInjectorAction#getInjectedValue()
	 * @generated
	 */
	EOperation getTypeInjectorAction__GetInjectedValue();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.action.StringInjector <em>String Injector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Injector</em>'.
	 * @see org.sheepy.common.model.action.StringInjector
	 * @generated
	 */
	EClass getStringInjector();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.action.StringInjector#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.sheepy.common.model.action.StringInjector#getValue()
	 * @see #getStringInjector()
	 * @generated
	 */
	EAttribute getStringInjector_Value();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.action.StringInjector#getInjectedValue() <em>Get Injected Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Injected Value</em>' operation.
	 * @see org.sheepy.common.model.action.StringInjector#getInjectedValue()
	 * @generated
	 */
	EOperation getStringInjector__GetInjectedValue();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.action.NumberInjector <em>Number Injector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Injector</em>'.
	 * @see org.sheepy.common.model.action.NumberInjector
	 * @generated
	 */
	EClass getNumberInjector();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.action.NumberInjector#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.sheepy.common.model.action.NumberInjector#getValue()
	 * @see #getNumberInjector()
	 * @generated
	 */
	EAttribute getNumberInjector_Value();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.action.NumberInjector#getInjectedValue() <em>Get Injected Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Injected Value</em>' operation.
	 * @see org.sheepy.common.model.action.NumberInjector#getInjectedValue()
	 * @generated
	 */
	EOperation getNumberInjector__GetInjectedValue();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.action.ParameteredActionsPkg <em>Parametered Actions Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametered Actions Pkg</em>'.
	 * @see org.sheepy.common.model.action.ParameteredActionsPkg
	 * @generated
	 */
	EClass getParameteredActionsPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.common.model.action.ParameteredActionsPkg#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.sheepy.common.model.action.ParameteredActionsPkg#getActions()
	 * @see #getParameteredActionsPkg()
	 * @generated
	 */
	EReference getParameteredActionsPkg_Actions();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.action.ParameteredActionsPkg#getParameterClassifier() <em>Get Parameter Classifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Parameter Classifier</em>' operation.
	 * @see org.sheepy.common.model.action.ParameteredActionsPkg#getParameterClassifier()
	 * @generated
	 */
	EOperation getParameteredActionsPkg__GetParameterClassifier();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.action.ActionsPkg <em>Actions Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actions Pkg</em>'.
	 * @see org.sheepy.common.model.action.ActionsPkg
	 * @generated
	 */
	EClass getActionsPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.common.model.action.ActionsPkg#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.sheepy.common.model.action.ActionsPkg#getActions()
	 * @see #getActionsPkg()
	 * @generated
	 */
	EReference getActionsPkg_Actions();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List&lt;? extends org.sheepy.common.model.action.Action&gt;"
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
		 * The meta object literal for the '{@link org.sheepy.common.model.action.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.action.impl.ActionImpl
		 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.action.impl.XActionImpl <em>XAction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.action.impl.XActionImpl
		 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getXAction()
		 * @generated
		 */
		EClass XACTION = eINSTANCE.getXAction();

		/**
		 * The meta object literal for the '<em><b>Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation XACTION___EXECUTE__LOBJECT = eINSTANCE.getXAction__Execute__LObject();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.action.ParameteredAction <em>Parametered Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.action.ParameteredAction
		 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getParameteredAction()
		 * @generated
		 */
		EClass PARAMETERED_ACTION = eINSTANCE.getParameteredAction();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.action.TypeInjectorAction <em>Type Injector Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.action.TypeInjectorAction
		 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getTypeInjectorAction()
		 * @generated
		 */
		EClass TYPE_INJECTOR_ACTION = eINSTANCE.getTypeInjectorAction();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_INJECTOR_ACTION__ACTION = eINSTANCE.getTypeInjectorAction_Action();

		/**
		 * The meta object literal for the '<em><b>Get Injected Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_INJECTOR_ACTION___GET_INJECTED_VALUE = eINSTANCE.getTypeInjectorAction__GetInjectedValue();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.action.impl.StringInjectorImpl <em>String Injector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.action.impl.StringInjectorImpl
		 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getStringInjector()
		 * @generated
		 */
		EClass STRING_INJECTOR = eINSTANCE.getStringInjector();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_INJECTOR__VALUE = eINSTANCE.getStringInjector_Value();

		/**
		 * The meta object literal for the '<em><b>Get Injected Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRING_INJECTOR___GET_INJECTED_VALUE = eINSTANCE.getStringInjector__GetInjectedValue();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.action.impl.NumberInjectorImpl <em>Number Injector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.action.impl.NumberInjectorImpl
		 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getNumberInjector()
		 * @generated
		 */
		EClass NUMBER_INJECTOR = eINSTANCE.getNumberInjector();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_INJECTOR__VALUE = eINSTANCE.getNumberInjector_Value();

		/**
		 * The meta object literal for the '<em><b>Get Injected Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NUMBER_INJECTOR___GET_INJECTED_VALUE = eINSTANCE.getNumberInjector__GetInjectedValue();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.action.impl.ParameteredActionsPkgImpl <em>Parametered Actions Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.action.impl.ParameteredActionsPkgImpl
		 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getParameteredActionsPkg()
		 * @generated
		 */
		EClass PARAMETERED_ACTIONS_PKG = eINSTANCE.getParameteredActionsPkg();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERED_ACTIONS_PKG__ACTIONS = eINSTANCE.getParameteredActionsPkg_Actions();

		/**
		 * The meta object literal for the '<em><b>Get Parameter Classifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERED_ACTIONS_PKG___GET_PARAMETER_CLASSIFIER = eINSTANCE.getParameteredActionsPkg__GetParameterClassifier();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.action.impl.ActionsPkgImpl <em>Actions Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.action.impl.ActionsPkgImpl
		 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getActionsPkg()
		 * @generated
		 */
		EClass ACTIONS_PKG = eINSTANCE.getActionsPkg();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIONS_PKG__ACTIONS = eINSTANCE.getActionsPkg_Actions();

		/**
		 * The meta object literal for the '<em>List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.sheepy.common.model.action.impl.ActionPackageImpl#getActionList()
		 * @generated
		 */
		EDataType ACTION_LIST = eINSTANCE.getActionList();

	}

} //ActionPackage
