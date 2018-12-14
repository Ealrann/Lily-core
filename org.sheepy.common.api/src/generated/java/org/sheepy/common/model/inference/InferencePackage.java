/**
 */
package org.sheepy.common.model.inference;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * @see org.sheepy.common.model.inference.InferenceFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.common.model/src/generated/java' editDirectory='/org.sheepy.common.model.edit/src/generated/java' publicConstructors='true' extensibleProviderFactory='true' childCreationExtenders='true' basePackage='org.sheepy.common.model'"
 * @generated
 */
public interface InferencePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "inference";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.common.model.inference";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "inference";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InferencePackage eINSTANCE = org.sheepy.common.model.inference.impl.InferencePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.inference.IInferenceObject <em>IInference Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.inference.IInferenceObject
	 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getIInferenceObject()
	 * @generated
	 */
	int IINFERENCE_OBJECT = 0;

	/**
	 * The number of structural features of the '<em>IInference Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINFERENCE_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINFERENCE_OBJECT___LINFERENCE_OBJECT = 0;

	/**
	 * The number of operations of the '<em>IInference Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINFERENCE_OBJECT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.inference.impl.InfererImpl <em>Inferer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.inference.impl.InfererImpl
	 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getInferer()
	 * @generated
	 */
	int INFERER = 1;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERER__RULES = IINFERENCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inferer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERER_FEATURE_COUNT = IINFERENCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERER___LINFERENCE_OBJECT = IINFERENCE_OBJECT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>LExecutor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERER___LEXECUTOR = IINFERENCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Inferer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFERER_OPERATION_COUNT = IINFERENCE_OBJECT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.inference.impl.SensorImpl <em>Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.inference.impl.SensorImpl
	 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getSensor()
	 * @generated
	 */
	int SENSOR = 2;

	/**
	 * The number of structural features of the '<em>Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FEATURE_COUNT = IINFERENCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR___LINFERENCE_OBJECT = IINFERENCE_OBJECT___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_OPERATION_COUNT = IINFERENCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.inference.impl.LRuleImpl <em>LRule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.inference.impl.LRuleImpl
	 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getLRule()
	 * @generated
	 */
	int LRULE = 3;

	/**
	 * The feature id for the '<em><b>Notification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LRULE__NOTIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LRULE__ACTION = 1;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LRULE__CONDITIONS = 2;

	/**
	 * The number of structural features of the '<em>LRule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LRULE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>LRule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LRULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.inference.impl.AbstractNotificationImpl <em>Abstract Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.inference.impl.AbstractNotificationImpl
	 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getAbstractNotification()
	 * @generated
	 */
	int ABSTRACT_NOTIFICATION = 4;

	/**
	 * The number of structural features of the '<em>Abstract Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NOTIFICATION_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NOTIFICATION___MATCH__ABSTRACTNOTIFICATION = 0;

	/**
	 * The number of operations of the '<em>Abstract Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NOTIFICATION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.inference.impl.LNotificationImpl <em>LNotification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.inference.impl.LNotificationImpl
	 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getLNotification()
	 * @generated
	 */
	int LNOTIFICATION = 5;

	/**
	 * The number of structural features of the '<em>LNotification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LNOTIFICATION_FEATURE_COUNT = ABSTRACT_NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LNOTIFICATION___MATCH__ABSTRACTNOTIFICATION = ABSTRACT_NOTIFICATION___MATCH__ABSTRACTNOTIFICATION;

	/**
	 * The number of operations of the '<em>LNotification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LNOTIFICATION_OPERATION_COUNT = ABSTRACT_NOTIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.inference.impl.ParameteredNotificationImpl <em>Parametered Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.inference.impl.ParameteredNotificationImpl
	 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getParameteredNotification()
	 * @generated
	 */
	int PARAMETERED_NOTIFICATION = 6;

	/**
	 * The number of structural features of the '<em>Parametered Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERED_NOTIFICATION_FEATURE_COUNT = ABSTRACT_NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERED_NOTIFICATION___MATCH__ABSTRACTNOTIFICATION = ABSTRACT_NOTIFICATION___MATCH__ABSTRACTNOTIFICATION;

	/**
	 * The number of operations of the '<em>Parametered Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERED_NOTIFICATION_OPERATION_COUNT = ABSTRACT_NOTIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.inference.Condition <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.inference.Condition
	 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__DEFINITION = 1;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION___GET_TYPE = 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION___MATCH__PARAMETER = 1;

	/**
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.inference.IInferenceObject <em>IInference Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IInference Object</em>'.
	 * @see org.sheepy.common.model.inference.IInferenceObject
	 * @generated
	 */
	EClass getIInferenceObject();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.inference.IInferenceObject#lInferenceObject() <em>LInference Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>LInference Object</em>' operation.
	 * @see org.sheepy.common.model.inference.IInferenceObject#lInferenceObject()
	 * @generated
	 */
	EOperation getIInferenceObject__LInferenceObject();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.inference.Inferer <em>Inferer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inferer</em>'.
	 * @see org.sheepy.common.model.inference.Inferer
	 * @generated
	 */
	EClass getInferer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.common.model.inference.Inferer#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.sheepy.common.model.inference.Inferer#getRules()
	 * @see #getInferer()
	 * @generated
	 */
	EReference getInferer_Rules();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.inference.Inferer#lExecutor() <em>LExecutor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>LExecutor</em>' operation.
	 * @see org.sheepy.common.model.inference.Inferer#lExecutor()
	 * @generated
	 */
	EOperation getInferer__LExecutor();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.inference.Sensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor</em>'.
	 * @see org.sheepy.common.model.inference.Sensor
	 * @generated
	 */
	EClass getSensor();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.inference.LRule <em>LRule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LRule</em>'.
	 * @see org.sheepy.common.model.inference.LRule
	 * @generated
	 */
	EClass getLRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.common.model.inference.LRule#getNotification <em>Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Notification</em>'.
	 * @see org.sheepy.common.model.inference.LRule#getNotification()
	 * @see #getLRule()
	 * @generated
	 */
	EReference getLRule_Notification();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.common.model.inference.LRule#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see org.sheepy.common.model.inference.LRule#getAction()
	 * @see #getLRule()
	 * @generated
	 */
	EReference getLRule_Action();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.common.model.inference.LRule#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see org.sheepy.common.model.inference.LRule#getConditions()
	 * @see #getLRule()
	 * @generated
	 */
	EReference getLRule_Conditions();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.inference.AbstractNotification <em>Abstract Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Notification</em>'.
	 * @see org.sheepy.common.model.inference.AbstractNotification
	 * @generated
	 */
	EClass getAbstractNotification();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.inference.AbstractNotification#match(org.sheepy.common.model.inference.AbstractNotification) <em>Match</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Match</em>' operation.
	 * @see org.sheepy.common.model.inference.AbstractNotification#match(org.sheepy.common.model.inference.AbstractNotification)
	 * @generated
	 */
	EOperation getAbstractNotification__Match__AbstractNotification();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.inference.LNotification <em>LNotification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LNotification</em>'.
	 * @see org.sheepy.common.model.inference.LNotification
	 * @generated
	 */
	EClass getLNotification();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.inference.ParameteredNotification <em>Parametered Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametered Notification</em>'.
	 * @see org.sheepy.common.model.inference.ParameteredNotification
	 * @generated
	 */
	EClass getParameteredNotification();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.inference.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see org.sheepy.common.model.inference.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.common.model.inference.Condition#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.sheepy.common.model.inference.Condition#getValue()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_Value();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.common.model.inference.Condition#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.sheepy.common.model.inference.Condition#getDefinition()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_Definition();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.inference.Condition#getType() <em>Get Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type</em>' operation.
	 * @see org.sheepy.common.model.inference.Condition#getType()
	 * @generated
	 */
	EOperation getCondition__GetType();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.inference.Condition#match(org.sheepy.common.model.types.Parameter) <em>Match</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Match</em>' operation.
	 * @see org.sheepy.common.model.inference.Condition#match(org.sheepy.common.model.types.Parameter)
	 * @generated
	 */
	EOperation getCondition__Match__Parameter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InferenceFactory getInferenceFactory();

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
		 * The meta object literal for the '{@link org.sheepy.common.model.inference.IInferenceObject <em>IInference Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.inference.IInferenceObject
		 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getIInferenceObject()
		 * @generated
		 */
		EClass IINFERENCE_OBJECT = eINSTANCE.getIInferenceObject();

		/**
		 * The meta object literal for the '<em><b>LInference Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IINFERENCE_OBJECT___LINFERENCE_OBJECT = eINSTANCE.getIInferenceObject__LInferenceObject();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.inference.impl.InfererImpl <em>Inferer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.inference.impl.InfererImpl
		 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getInferer()
		 * @generated
		 */
		EClass INFERER = eINSTANCE.getInferer();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFERER__RULES = eINSTANCE.getInferer_Rules();

		/**
		 * The meta object literal for the '<em><b>LExecutor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INFERER___LEXECUTOR = eINSTANCE.getInferer__LExecutor();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.inference.impl.SensorImpl <em>Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.inference.impl.SensorImpl
		 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getSensor()
		 * @generated
		 */
		EClass SENSOR = eINSTANCE.getSensor();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.inference.impl.LRuleImpl <em>LRule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.inference.impl.LRuleImpl
		 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getLRule()
		 * @generated
		 */
		EClass LRULE = eINSTANCE.getLRule();

		/**
		 * The meta object literal for the '<em><b>Notification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LRULE__NOTIFICATION = eINSTANCE.getLRule_Notification();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LRULE__ACTION = eINSTANCE.getLRule_Action();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LRULE__CONDITIONS = eINSTANCE.getLRule_Conditions();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.inference.impl.AbstractNotificationImpl <em>Abstract Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.inference.impl.AbstractNotificationImpl
		 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getAbstractNotification()
		 * @generated
		 */
		EClass ABSTRACT_NOTIFICATION = eINSTANCE.getAbstractNotification();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_NOTIFICATION___MATCH__ABSTRACTNOTIFICATION = eINSTANCE.getAbstractNotification__Match__AbstractNotification();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.inference.impl.LNotificationImpl <em>LNotification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.inference.impl.LNotificationImpl
		 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getLNotification()
		 * @generated
		 */
		EClass LNOTIFICATION = eINSTANCE.getLNotification();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.inference.impl.ParameteredNotificationImpl <em>Parametered Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.inference.impl.ParameteredNotificationImpl
		 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getParameteredNotification()
		 * @generated
		 */
		EClass PARAMETERED_NOTIFICATION = eINSTANCE.getParameteredNotification();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.inference.Condition <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.inference.Condition
		 * @see org.sheepy.common.model.inference.impl.InferencePackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__VALUE = eINSTANCE.getCondition_Value();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__DEFINITION = eINSTANCE.getCondition_Definition();

		/**
		 * The meta object literal for the '<em><b>Get Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONDITION___GET_TYPE = eINSTANCE.getCondition__GetType();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONDITION___MATCH__PARAMETER = eINSTANCE.getCondition__Match__Parameter();

	}

} //InferencePackage
