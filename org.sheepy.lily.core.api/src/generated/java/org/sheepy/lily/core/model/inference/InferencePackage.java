/**
 */
package org.sheepy.lily.core.model.inference;

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
 * @see org.sheepy.lily.core.model.inference.InferenceFactory
 * @model kind="package"
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
	String eNS_URI = "org.sheepy.lily.core.model.inference";

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
	InferencePackage eINSTANCE = org.sheepy.lily.core.model.inference.impl.InferencePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.inference.IInferenceObject <em>IInference Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.inference.IInferenceObject
	 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getIInferenceObject()
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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.inference.impl.InfererImpl <em>Inferer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.inference.impl.InfererImpl
	 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getInferer()
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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.inference.impl.SensorImpl <em>Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.inference.impl.SensorImpl
	 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getSensor()
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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.inference.impl.LRuleImpl <em>LRule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.inference.impl.LRuleImpl
	 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getLRule()
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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.inference.impl.AbstractNotificationImpl <em>Abstract Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.inference.impl.AbstractNotificationImpl
	 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getAbstractNotification()
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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.inference.impl.LNotificationImpl <em>LNotification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.inference.impl.LNotificationImpl
	 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getLNotification()
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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.inference.impl.ParameteredNotificationImpl <em>Parametered Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.inference.impl.ParameteredNotificationImpl
	 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getParameteredNotification()
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
	 * The meta object id for the '{@link org.sheepy.lily.core.model.inference.Condition <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.inference.Condition
	 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getCondition()
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
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.inference.IInferenceObject <em>IInference Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IInference Object</em>'.
	 * @see org.sheepy.lily.core.model.inference.IInferenceObject
	 * @generated
	 */
	EClass getIInferenceObject();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.inference.Inferer <em>Inferer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inferer</em>'.
	 * @see org.sheepy.lily.core.model.inference.Inferer
	 * @generated
	 */
	EClass getInferer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.inference.Inferer#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.sheepy.lily.core.model.inference.Inferer#getRules()
	 * @see #getInferer()
	 * @generated
	 */
	EReference getInferer_Rules();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.inference.Sensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor</em>'.
	 * @see org.sheepy.lily.core.model.inference.Sensor
	 * @generated
	 */
	EClass getSensor();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.inference.LRule <em>LRule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LRule</em>'.
	 * @see org.sheepy.lily.core.model.inference.LRule
	 * @generated
	 */
	EClass getLRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.inference.LRule#getNotification <em>Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Notification</em>'.
	 * @see org.sheepy.lily.core.model.inference.LRule#getNotification()
	 * @see #getLRule()
	 * @generated
	 */
	EReference getLRule_Notification();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.inference.LRule#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see org.sheepy.lily.core.model.inference.LRule#getAction()
	 * @see #getLRule()
	 * @generated
	 */
	EReference getLRule_Action();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.inference.LRule#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see org.sheepy.lily.core.model.inference.LRule#getConditions()
	 * @see #getLRule()
	 * @generated
	 */
	EReference getLRule_Conditions();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.inference.AbstractNotification <em>Abstract Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Notification</em>'.
	 * @see org.sheepy.lily.core.model.inference.AbstractNotification
	 * @generated
	 */
	EClass getAbstractNotification();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.inference.LNotification <em>LNotification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LNotification</em>'.
	 * @see org.sheepy.lily.core.model.inference.LNotification
	 * @generated
	 */
	EClass getLNotification();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.inference.ParameteredNotification <em>Parametered Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametered Notification</em>'.
	 * @see org.sheepy.lily.core.model.inference.ParameteredNotification
	 * @generated
	 */
	EClass getParameteredNotification();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.inference.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see org.sheepy.lily.core.model.inference.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.core.model.inference.Condition#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.sheepy.lily.core.model.inference.Condition#getValue()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_Value();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.core.model.inference.Condition#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.sheepy.lily.core.model.inference.Condition#getDefinition()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_Definition();

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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.inference.IInferenceObject <em>IInference Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.inference.IInferenceObject
		 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getIInferenceObject()
		 * @generated
		 */
		EClass IINFERENCE_OBJECT = eINSTANCE.getIInferenceObject();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.inference.impl.InfererImpl <em>Inferer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.inference.impl.InfererImpl
		 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getInferer()
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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.inference.impl.SensorImpl <em>Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.inference.impl.SensorImpl
		 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getSensor()
		 * @generated
		 */
		EClass SENSOR = eINSTANCE.getSensor();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.inference.impl.LRuleImpl <em>LRule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.inference.impl.LRuleImpl
		 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getLRule()
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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.inference.impl.AbstractNotificationImpl <em>Abstract Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.inference.impl.AbstractNotificationImpl
		 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getAbstractNotification()
		 * @generated
		 */
		EClass ABSTRACT_NOTIFICATION = eINSTANCE.getAbstractNotification();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.inference.impl.LNotificationImpl <em>LNotification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.inference.impl.LNotificationImpl
		 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getLNotification()
		 * @generated
		 */
		EClass LNOTIFICATION = eINSTANCE.getLNotification();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.inference.impl.ParameteredNotificationImpl <em>Parametered Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.inference.impl.ParameteredNotificationImpl
		 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getParameteredNotification()
		 * @generated
		 */
		EClass PARAMETERED_NOTIFICATION = eINSTANCE.getParameteredNotification();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.inference.Condition <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.inference.Condition
		 * @see org.sheepy.lily.core.model.inference.impl.InferencePackageImpl#getCondition()
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

	}

} //InferencePackage
