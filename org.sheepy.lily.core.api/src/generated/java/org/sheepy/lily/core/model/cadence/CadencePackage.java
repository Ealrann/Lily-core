/**
 */
package org.sheepy.lily.core.model.cadence;

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
 * @see org.sheepy.lily.core.model.cadence.CadenceFactory
 * @model kind="package"
 * @generated
 */
public interface CadencePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cadence";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.core.model.cadence";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cadence";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CadencePackage eINSTANCE = org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.cadence.ICadenceTask <em>ICadence Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.cadence.ICadenceTask
	 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getICadenceTask()
	 * @generated
	 */
	int ICADENCE_TASK = 1;

	/**
	 * The number of structural features of the '<em>ICadence Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICADENCE_TASK_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>ICadence Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICADENCE_TASK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.cadence.impl.CadenceTaskPkgImpl <em>Task Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.cadence.impl.CadenceTaskPkgImpl
	 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getCadenceTaskPkg()
	 * @generated
	 */
	int CADENCE_TASK_PKG = 2;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CADENCE_TASK_PKG__TASKS = ICADENCE_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Task Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CADENCE_TASK_PKG_FEATURE_COUNT = ICADENCE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Task Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CADENCE_TASK_PKG_OPERATION_COUNT = ICADENCE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.cadence.impl.CadenceImpl <em>Cadence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.cadence.impl.CadenceImpl
	 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getCadence()
	 * @generated
	 */
	int CADENCE = 0;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CADENCE__TASKS = CADENCE_TASK_PKG__TASKS;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CADENCE__FREQUENCY = CADENCE_TASK_PKG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Print UPS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CADENCE__PRINT_UPS = CADENCE_TASK_PKG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cadence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CADENCE_FEATURE_COUNT = CADENCE_TASK_PKG_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cadence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CADENCE_OPERATION_COUNT = CADENCE_TASK_PKG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.cadence.impl.ExecuteWhileImpl <em>Execute While</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.cadence.impl.ExecuteWhileImpl
	 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getExecuteWhile()
	 * @generated
	 */
	int EXECUTE_WHILE = 3;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_WHILE__TASKS = CADENCE_TASK_PKG__TASKS;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_WHILE__CONDITIONS = CADENCE_TASK_PKG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Execute While</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_WHILE_FEATURE_COUNT = CADENCE_TASK_PKG_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Execute While</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_WHILE_OPERATION_COUNT = CADENCE_TASK_PKG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.cadence.impl.ExecuteIfImpl <em>Execute If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.cadence.impl.ExecuteIfImpl
	 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getExecuteIf()
	 * @generated
	 */
	int EXECUTE_IF = 4;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_IF__TASKS = CADENCE_TASK_PKG__TASKS;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_IF__CONDITIONS = CADENCE_TASK_PKG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Execute If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_IF_FEATURE_COUNT = CADENCE_TASK_PKG_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Execute If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_IF_OPERATION_COUNT = CADENCE_TASK_PKG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.cadence.impl.PrintUPSImpl <em>Print UPS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.cadence.impl.PrintUPSImpl
	 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getPrintUPS()
	 * @generated
	 */
	int PRINT_UPS = 5;

	/**
	 * The feature id for the '<em><b>Print Every Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_UPS__PRINT_EVERY_MS = ICADENCE_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Print UPS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_UPS_FEATURE_COUNT = ICADENCE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Print UPS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_UPS_OPERATION_COUNT = ICADENCE_TASK_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.cadence.ICadenceCondition <em>ICadence Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.cadence.ICadenceCondition
	 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getICadenceCondition()
	 * @generated
	 */
	int ICADENCE_CONDITION = 6;

	/**
	 * The number of structural features of the '<em>ICadence Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICADENCE_CONDITION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>ICadence Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICADENCE_CONDITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.cadence.impl.HaveTimeImpl <em>Have Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.cadence.impl.HaveTimeImpl
	 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getHaveTime()
	 * @generated
	 */
	int HAVE_TIME = 7;

	/**
	 * The number of structural features of the '<em>Have Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAVE_TIME_FEATURE_COUNT = ICADENCE_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Have Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAVE_TIME_OPERATION_COUNT = ICADENCE_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.cadence.impl.CountUntilImpl <em>Count Until</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.cadence.impl.CountUntilImpl
	 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getCountUntil()
	 * @generated
	 */
	int COUNT_UNTIL = 8;

	/**
	 * The feature id for the '<em><b>Total Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_UNTIL__TOTAL_COUNT = ICADENCE_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Current Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_UNTIL__CURRENT_COUNT = ICADENCE_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Count Until</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_UNTIL_FEATURE_COUNT = ICADENCE_CONDITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Count Until</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_UNTIL_OPERATION_COUNT = ICADENCE_CONDITION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.sheepy.lily.core.model.cadence.impl.CloseApplicationImpl <em>Close Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.core.model.cadence.impl.CloseApplicationImpl
	 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getCloseApplication()
	 * @generated
	 */
	int CLOSE_APPLICATION = 9;

	/**
	 * The number of structural features of the '<em>Close Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_APPLICATION_FEATURE_COUNT = ICADENCE_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Close Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_APPLICATION_OPERATION_COUNT = ICADENCE_TASK_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.cadence.Cadence <em>Cadence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cadence</em>'.
	 * @see org.sheepy.lily.core.model.cadence.Cadence
	 * @generated
	 */
	EClass getCadence();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.cadence.Cadence#getFrequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frequency</em>'.
	 * @see org.sheepy.lily.core.model.cadence.Cadence#getFrequency()
	 * @see #getCadence()
	 * @generated
	 */
	EAttribute getCadence_Frequency();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.cadence.Cadence#isPrintUPS <em>Print UPS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Print UPS</em>'.
	 * @see org.sheepy.lily.core.model.cadence.Cadence#isPrintUPS()
	 * @see #getCadence()
	 * @generated
	 */
	EAttribute getCadence_PrintUPS();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.cadence.ICadenceTask <em>ICadence Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ICadence Task</em>'.
	 * @see org.sheepy.lily.core.model.cadence.ICadenceTask
	 * @generated
	 */
	EClass getICadenceTask();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.cadence.CadenceTaskPkg <em>Task Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Pkg</em>'.
	 * @see org.sheepy.lily.core.model.cadence.CadenceTaskPkg
	 * @generated
	 */
	EClass getCadenceTaskPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.cadence.CadenceTaskPkg#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see org.sheepy.lily.core.model.cadence.CadenceTaskPkg#getTasks()
	 * @see #getCadenceTaskPkg()
	 * @generated
	 */
	EReference getCadenceTaskPkg_Tasks();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.cadence.ExecuteWhile <em>Execute While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execute While</em>'.
	 * @see org.sheepy.lily.core.model.cadence.ExecuteWhile
	 * @generated
	 */
	EClass getExecuteWhile();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.cadence.ExecuteWhile#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see org.sheepy.lily.core.model.cadence.ExecuteWhile#getConditions()
	 * @see #getExecuteWhile()
	 * @generated
	 */
	EReference getExecuteWhile_Conditions();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.cadence.ExecuteIf <em>Execute If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execute If</em>'.
	 * @see org.sheepy.lily.core.model.cadence.ExecuteIf
	 * @generated
	 */
	EClass getExecuteIf();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.core.model.cadence.ExecuteIf#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see org.sheepy.lily.core.model.cadence.ExecuteIf#getConditions()
	 * @see #getExecuteIf()
	 * @generated
	 */
	EReference getExecuteIf_Conditions();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.cadence.PrintUPS <em>Print UPS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Print UPS</em>'.
	 * @see org.sheepy.lily.core.model.cadence.PrintUPS
	 * @generated
	 */
	EClass getPrintUPS();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.cadence.PrintUPS#getPrintEveryMs <em>Print Every Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Print Every Ms</em>'.
	 * @see org.sheepy.lily.core.model.cadence.PrintUPS#getPrintEveryMs()
	 * @see #getPrintUPS()
	 * @generated
	 */
	EAttribute getPrintUPS_PrintEveryMs();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.cadence.ICadenceCondition <em>ICadence Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ICadence Condition</em>'.
	 * @see org.sheepy.lily.core.model.cadence.ICadenceCondition
	 * @generated
	 */
	EClass getICadenceCondition();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.cadence.HaveTime <em>Have Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Have Time</em>'.
	 * @see org.sheepy.lily.core.model.cadence.HaveTime
	 * @generated
	 */
	EClass getHaveTime();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.cadence.CountUntil <em>Count Until</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Count Until</em>'.
	 * @see org.sheepy.lily.core.model.cadence.CountUntil
	 * @generated
	 */
	EClass getCountUntil();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.cadence.CountUntil#getTotalCount <em>Total Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Count</em>'.
	 * @see org.sheepy.lily.core.model.cadence.CountUntil#getTotalCount()
	 * @see #getCountUntil()
	 * @generated
	 */
	EAttribute getCountUntil_TotalCount();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.core.model.cadence.CountUntil#getCurrentCount <em>Current Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Count</em>'.
	 * @see org.sheepy.lily.core.model.cadence.CountUntil#getCurrentCount()
	 * @see #getCountUntil()
	 * @generated
	 */
	EAttribute getCountUntil_CurrentCount();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.core.model.cadence.CloseApplication <em>Close Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Close Application</em>'.
	 * @see org.sheepy.lily.core.model.cadence.CloseApplication
	 * @generated
	 */
	EClass getCloseApplication();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CadenceFactory getCadenceFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.cadence.impl.CadenceImpl <em>Cadence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.cadence.impl.CadenceImpl
		 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getCadence()
		 * @generated
		 */
		EClass CADENCE = eINSTANCE.getCadence();

		/**
		 * The meta object literal for the '<em><b>Frequency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CADENCE__FREQUENCY = eINSTANCE.getCadence_Frequency();

		/**
		 * The meta object literal for the '<em><b>Print UPS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CADENCE__PRINT_UPS = eINSTANCE.getCadence_PrintUPS();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.cadence.ICadenceTask <em>ICadence Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.cadence.ICadenceTask
		 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getICadenceTask()
		 * @generated
		 */
		EClass ICADENCE_TASK = eINSTANCE.getICadenceTask();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.cadence.impl.CadenceTaskPkgImpl <em>Task Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.cadence.impl.CadenceTaskPkgImpl
		 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getCadenceTaskPkg()
		 * @generated
		 */
		EClass CADENCE_TASK_PKG = eINSTANCE.getCadenceTaskPkg();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CADENCE_TASK_PKG__TASKS = eINSTANCE.getCadenceTaskPkg_Tasks();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.cadence.impl.ExecuteWhileImpl <em>Execute While</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.cadence.impl.ExecuteWhileImpl
		 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getExecuteWhile()
		 * @generated
		 */
		EClass EXECUTE_WHILE = eINSTANCE.getExecuteWhile();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTE_WHILE__CONDITIONS = eINSTANCE.getExecuteWhile_Conditions();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.cadence.impl.ExecuteIfImpl <em>Execute If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.cadence.impl.ExecuteIfImpl
		 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getExecuteIf()
		 * @generated
		 */
		EClass EXECUTE_IF = eINSTANCE.getExecuteIf();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTE_IF__CONDITIONS = eINSTANCE.getExecuteIf_Conditions();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.cadence.impl.PrintUPSImpl <em>Print UPS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.cadence.impl.PrintUPSImpl
		 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getPrintUPS()
		 * @generated
		 */
		EClass PRINT_UPS = eINSTANCE.getPrintUPS();

		/**
		 * The meta object literal for the '<em><b>Print Every Ms</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRINT_UPS__PRINT_EVERY_MS = eINSTANCE.getPrintUPS_PrintEveryMs();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.cadence.ICadenceCondition <em>ICadence Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.cadence.ICadenceCondition
		 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getICadenceCondition()
		 * @generated
		 */
		EClass ICADENCE_CONDITION = eINSTANCE.getICadenceCondition();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.cadence.impl.HaveTimeImpl <em>Have Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.cadence.impl.HaveTimeImpl
		 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getHaveTime()
		 * @generated
		 */
		EClass HAVE_TIME = eINSTANCE.getHaveTime();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.cadence.impl.CountUntilImpl <em>Count Until</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.cadence.impl.CountUntilImpl
		 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getCountUntil()
		 * @generated
		 */
		EClass COUNT_UNTIL = eINSTANCE.getCountUntil();

		/**
		 * The meta object literal for the '<em><b>Total Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUNT_UNTIL__TOTAL_COUNT = eINSTANCE.getCountUntil_TotalCount();

		/**
		 * The meta object literal for the '<em><b>Current Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUNT_UNTIL__CURRENT_COUNT = eINSTANCE.getCountUntil_CurrentCount();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.core.model.cadence.impl.CloseApplicationImpl <em>Close Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.core.model.cadence.impl.CloseApplicationImpl
		 * @see org.sheepy.lily.core.model.cadence.impl.CadencePackageImpl#getCloseApplication()
		 * @generated
		 */
		EClass CLOSE_APPLICATION = eINSTANCE.getCloseApplication();

	}

} //CadencePackage
