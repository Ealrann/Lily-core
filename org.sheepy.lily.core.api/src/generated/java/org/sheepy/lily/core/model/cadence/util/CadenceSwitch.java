/**
 */
package org.sheepy.lily.core.model.cadence.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.cadence.*;
import org.sheepy.lily.core.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.core.model.cadence.CadencePackage
 * @generated
 */
public class CadenceSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CadencePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CadenceSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = CadencePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case CadencePackage.CADENCE:
			{
				Cadence cadence = (Cadence)theEObject;
				T result = caseCadence(cadence);
				if (result == null) result = caseCadenceTaskPkg(cadence);
				if (result == null) result = caseICadence(cadence);
				if (result == null) result = caseICadenceTask(cadence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CadencePackage.ICADENCE_TASK:
			{
				ICadenceTask iCadenceTask = (ICadenceTask)theEObject;
				T result = caseICadenceTask(iCadenceTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CadencePackage.CADENCE_TASK_PKG:
			{
				CadenceTaskPkg cadenceTaskPkg = (CadenceTaskPkg)theEObject;
				T result = caseCadenceTaskPkg(cadenceTaskPkg);
				if (result == null) result = caseICadenceTask(cadenceTaskPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CadencePackage.EXECUTE_WHILE:
			{
				ExecuteWhile executeWhile = (ExecuteWhile)theEObject;
				T result = caseExecuteWhile(executeWhile);
				if (result == null) result = caseCadenceTaskPkg(executeWhile);
				if (result == null) result = caseICadenceTask(executeWhile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CadencePackage.EXECUTE_IF:
			{
				ExecuteIf executeIf = (ExecuteIf)theEObject;
				T result = caseExecuteIf(executeIf);
				if (result == null) result = caseCadenceTaskPkg(executeIf);
				if (result == null) result = caseICadenceTask(executeIf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CadencePackage.PRINT_UPS:
			{
				PrintUPS printUPS = (PrintUPS)theEObject;
				T result = casePrintUPS(printUPS);
				if (result == null) result = caseICadenceTask(printUPS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CadencePackage.ICADENCE_CONDITION:
			{
				ICadenceCondition iCadenceCondition = (ICadenceCondition)theEObject;
				T result = caseICadenceCondition(iCadenceCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CadencePackage.HAVE_TIME:
			{
				HaveTime haveTime = (HaveTime)theEObject;
				T result = caseHaveTime(haveTime);
				if (result == null) result = caseICadenceCondition(haveTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CadencePackage.COUNT_UNTIL:
			{
				CountUntil countUntil = (CountUntil)theEObject;
				T result = caseCountUntil(countUntil);
				if (result == null) result = caseICadenceCondition(countUntil);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CadencePackage.CLOSE_APPLICATION:
			{
				CloseApplication closeApplication = (CloseApplication)theEObject;
				T result = caseCloseApplication(closeApplication);
				if (result == null) result = caseICadenceTask(closeApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CadencePackage.GENERIC_CADENCE:
			{
				GenericCadence genericCadence = (GenericCadence)theEObject;
				T result = caseGenericCadence(genericCadence);
				if (result == null) result = caseICadence(genericCadence);
				if (result == null) result = caseLNamedElement(genericCadence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cadence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cadence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCadence(Cadence object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICadence Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICadence Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICadenceTask(ICadenceTask object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCadenceTaskPkg(CadenceTaskPkg object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execute While</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execute While</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecuteWhile(ExecuteWhile object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execute If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execute If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecuteIf(ExecuteIf object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Print UPS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Print UPS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrintUPS(PrintUPS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICadence Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICadence Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICadenceCondition(ICadenceCondition object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Have Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Have Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHaveTime(HaveTime object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Count Until</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Count Until</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountUntil(CountUntil object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Close Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Close Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloseApplication(CloseApplication object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Cadence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Cadence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericCadence(GenericCadence object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICadence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICadence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICadence(ICadence object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LNamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LNamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLNamedElement(LNamedElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object)
	{
		return null;
	}

} //CadenceSwitch
