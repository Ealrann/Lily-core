/**
 */
package org.sheepy.common.model.variable.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.common.model.action.Action;
import org.sheepy.common.model.action.ParameteredAction;

import org.sheepy.common.model.root.LNamedElement;

import org.sheepy.common.model.types.Parameter;

import org.sheepy.common.model.variable.*;

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
 * @see org.sheepy.common.model.variable.VariablePackage
 * @generated
 */
public class VariableSwitch<T1> extends Switch<T1>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VariablePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = VariablePackage.eINSTANCE;
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
			case VariablePackage.VARIABLE_RESOLVER:
			{
				VariableResolver variableResolver = (VariableResolver)theEObject;
				T1 result = caseVariableResolver(variableResolver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.VAR_CHANGE_ACTION:
			{
				VarChangeAction varChangeAction = (VarChangeAction)theEObject;
				T1 result = caseVarChangeAction(varChangeAction);
				if (result == null) result = caseAction(varChangeAction);
				if (result == null) result = caseLNamedElement(varChangeAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.BOOLEAN_CHANGE_ACTION:
			{
				BooleanChangeAction booleanChangeAction = (BooleanChangeAction)theEObject;
				T1 result = caseBooleanChangeAction(booleanChangeAction);
				if (result == null) result = caseVarChangeAction(booleanChangeAction);
				if (result == null) result = caseAction(booleanChangeAction);
				if (result == null) result = caseLNamedElement(booleanChangeAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.VAR_CHANGE_ACTION_PKG:
			{
				VarChangeActionPkg varChangeActionPkg = (VarChangeActionPkg)theEObject;
				T1 result = caseVarChangeActionPkg(varChangeActionPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.INCREMENT_ACTION:
			{
				IncrementAction incrementAction = (IncrementAction)theEObject;
				T1 result = caseIncrementAction(incrementAction);
				if (result == null) result = caseParameteredAction(incrementAction);
				if (result == null) result = caseVarChangeAction(incrementAction);
				if (result == null) result = caseAction(incrementAction);
				if (result == null) result = caseLNamedElement(incrementAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.SET_STRING:
			{
				SetString setString = (SetString)theEObject;
				T1 result = caseSetString(setString);
				if (result == null) result = caseParameteredAction(setString);
				if (result == null) result = caseVarChangeAction(setString);
				if (result == null) result = caseAction(setString);
				if (result == null) result = caseLNamedElement(setString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.SET_BOOLEAN:
			{
				SetBoolean setBoolean = (SetBoolean)theEObject;
				T1 result = caseSetBoolean(setBoolean);
				if (result == null) result = caseParameteredAction(setBoolean);
				if (result == null) result = caseVarChangeAction(setBoolean);
				if (result == null) result = caseAction(setBoolean);
				if (result == null) result = caseLNamedElement(setBoolean);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.SET_NUMBER:
			{
				SetNumber setNumber = (SetNumber)theEObject;
				T1 result = caseSetNumber(setNumber);
				if (result == null) result = caseParameteredAction(setNumber);
				if (result == null) result = caseVarChangeAction(setNumber);
				if (result == null) result = caseAction(setNumber);
				if (result == null) result = caseLNamedElement(setNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVariableResolver(VariableResolver object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Change Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Change Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVarChangeAction(VarChangeAction object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Change Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Change Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBooleanChangeAction(BooleanChangeAction object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Change Action Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Change Action Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVarChangeActionPkg(VarChangeActionPkg object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Increment Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Increment Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIncrementAction(IncrementAction object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSetString(SetString object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Boolean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSetBoolean(SetBoolean object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSetNumber(SetNumber object)
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
	public T1 caseLNamedElement(LNamedElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAction(Action object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parametered Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parametered Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Parameter> T1 caseParameteredAction(ParameteredAction<T> object)
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

} //VariableSwitch
