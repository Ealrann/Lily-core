/**
 */
package org.sheepy.common.model.inference.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.common.model.inference.*;

import org.sheepy.common.model.types.Parameter;

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
 * @see org.sheepy.common.model.inference.InferencePackage
 * @generated
 */
public class InferenceSwitch<T1> extends Switch<T1>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static InferencePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InferenceSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = InferencePackage.eINSTANCE;
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
	protected T1 doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case InferencePackage.IINFERENCE_OBJECT:
			{
				IInferenceObject iInferenceObject = (IInferenceObject)theEObject;
				T1 result = caseIInferenceObject(iInferenceObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InferencePackage.INFERER:
			{
				Inferer inferer = (Inferer)theEObject;
				T1 result = caseInferer(inferer);
				if (result == null) result = caseIInferenceObject(inferer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InferencePackage.SENSOR:
			{
				Sensor sensor = (Sensor)theEObject;
				T1 result = caseSensor(sensor);
				if (result == null) result = caseIInferenceObject(sensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InferencePackage.LRULE:
			{
				LRule lRule = (LRule)theEObject;
				T1 result = caseLRule(lRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InferencePackage.ABSTRACT_NOTIFICATION:
			{
				AbstractNotification abstractNotification = (AbstractNotification)theEObject;
				T1 result = caseAbstractNotification(abstractNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InferencePackage.LNOTIFICATION:
			{
				LNotification lNotification = (LNotification)theEObject;
				T1 result = caseLNotification(lNotification);
				if (result == null) result = caseAbstractNotification(lNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InferencePackage.PARAMETERED_NOTIFICATION:
			{
				ParameteredNotification<?> parameteredNotification = (ParameteredNotification<?>)theEObject;
				T1 result = caseParameteredNotification(parameteredNotification);
				if (result == null) result = caseAbstractNotification(parameteredNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InferencePackage.CONDITION:
			{
				Condition<?> condition = (Condition<?>)theEObject;
				T1 result = caseCondition(condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInference Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInference Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIInferenceObject(IInferenceObject object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inferer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inferer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInferer(Inferer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSensor(Sensor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LRule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LRule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLRule(LRule object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAbstractNotification(AbstractNotification object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LNotification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LNotification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLNotification(LNotification object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parametered Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parametered Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Parameter> T1 caseParameteredNotification(ParameteredNotification<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Parameter> T1 caseCondition(Condition<T> object)
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
	public T1 defaultCase(EObject object)
	{
		return null;
	}

} //InferenceSwitch
