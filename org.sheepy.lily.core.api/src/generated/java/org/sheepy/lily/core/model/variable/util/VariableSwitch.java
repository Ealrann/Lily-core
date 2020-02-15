/**
 */
package org.sheepy.lily.core.model.variable.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.lily.core.model.action.Action;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.core.model.variable.*;

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
 * @see org.sheepy.lily.core.model.variable.VariablePackage
 * @generated
 */
public class VariableSwitch<T> extends Switch<T>
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
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case VariablePackage.IVARIABLE_RESOLVER:
			{
				IVariableResolver iVariableResolver = (IVariableResolver)theEObject;
				T result = caseIVariableResolver(iVariableResolver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.IDEFINITION_CONTAINER:
			{
				IDefinitionContainer iDefinitionContainer = (IDefinitionContainer)theEObject;
				T result = caseIDefinitionContainer(iDefinitionContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.CHAIN_VARIABLE_RESOLVER:
			{
				ChainVariableResolver chainVariableResolver = (ChainVariableResolver)theEObject;
				T result = caseChainVariableResolver(chainVariableResolver);
				if (result == null) result = caseIVariableResolver(chainVariableResolver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.CHAIN_RESOLVER:
			{
				ChainResolver chainResolver = (ChainResolver)theEObject;
				T result = caseChainResolver(chainResolver);
				if (result == null) result = caseIDefinitionContainer(chainResolver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.ABSTRACT_DEFINED_VARIABLE_RESOLVER:
			{
				AbstractDefinedVariableResolver abstractDefinedVariableResolver = (AbstractDefinedVariableResolver)theEObject;
				T result = caseAbstractDefinedVariableResolver(abstractDefinedVariableResolver);
				if (result == null) result = caseIVariableResolver(abstractDefinedVariableResolver);
				if (result == null) result = caseIDefinitionContainer(abstractDefinedVariableResolver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.DIRECT_VARIABLE_RESOLVER:
			{
				DirectVariableResolver directVariableResolver = (DirectVariableResolver)theEObject;
				T result = caseDirectVariableResolver(directVariableResolver);
				if (result == null) result = caseAbstractDefinedVariableResolver(directVariableResolver);
				if (result == null) result = caseIVariableResolver(directVariableResolver);
				if (result == null) result = caseIDefinitionContainer(directVariableResolver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.VAR_CHANGE_ACTION:
			{
				VarChangeAction varChangeAction = (VarChangeAction)theEObject;
				T result = caseVarChangeAction(varChangeAction);
				if (result == null) result = caseAction(varChangeAction);
				if (result == null) result = caseLNamedElement(varChangeAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.BOOLEAN_CHANGE_ACTION:
			{
				BooleanChangeAction booleanChangeAction = (BooleanChangeAction)theEObject;
				T result = caseBooleanChangeAction(booleanChangeAction);
				if (result == null) result = caseVarChangeAction(booleanChangeAction);
				if (result == null) result = caseAction(booleanChangeAction);
				if (result == null) result = caseLNamedElement(booleanChangeAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.INT_CHANGE_ACTION:
			{
				IntChangeAction intChangeAction = (IntChangeAction)theEObject;
				T result = caseIntChangeAction(intChangeAction);
				if (result == null) result = caseVarChangeAction(intChangeAction);
				if (result == null) result = caseAction(intChangeAction);
				if (result == null) result = caseLNamedElement(intChangeAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.VAR_CHANGE_ACTION_PKG:
			{
				VarChangeActionPkg varChangeActionPkg = (VarChangeActionPkg)theEObject;
				T result = caseVarChangeActionPkg(varChangeActionPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.IMODEL_VARIABLE:
			{
				IModelVariable iModelVariable = (IModelVariable)theEObject;
				T result = caseIModelVariable(iModelVariable);
				if (result == null) result = caseLNamedElement(iModelVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.INT_VARIABLE:
			{
				IntVariable intVariable = (IntVariable)theEObject;
				T result = caseIntVariable(intVariable);
				if (result == null) result = caseIModelVariable(intVariable);
				if (result == null) result = caseLNamedElement(intVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.DURATION_VARIABLE:
			{
				DurationVariable durationVariable = (DurationVariable)theEObject;
				T result = caseDurationVariable(durationVariable);
				if (result == null) result = caseIModelVariable(durationVariable);
				if (result == null) result = caseLNamedElement(durationVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.IMODEL_VARIABLE_ACTION:
			{
				IModelVariableAction iModelVariableAction = (IModelVariableAction)theEObject;
				T result = caseIModelVariableAction(iModelVariableAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.IMODEL_VARIABLE_ACTION_CONTAINER:
			{
				IModelVariableActionContainer iModelVariableActionContainer = (IModelVariableActionContainer)theEObject;
				T result = caseIModelVariableActionContainer(iModelVariableActionContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VariablePackage.SET_VARIABLE_ACTION:
			{
				SetVariableAction setVariableAction = (SetVariableAction)theEObject;
				T result = caseSetVariableAction(setVariableAction);
				if (result == null) result = caseIModelVariableAction(setVariableAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IVariable Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IVariable Resolver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIVariableResolver(IVariableResolver object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDefinition Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDefinition Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDefinitionContainer(IDefinitionContainer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Chain Variable Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Chain Variable Resolver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChainVariableResolver(ChainVariableResolver object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Chain Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Chain Resolver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChainResolver(ChainResolver object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Defined Variable Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Defined Variable Resolver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractDefinedVariableResolver(AbstractDefinedVariableResolver object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Direct Variable Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Direct Variable Resolver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectVariableResolver(DirectVariableResolver object)
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
	public T caseVarChangeAction(VarChangeAction object)
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
	public T caseBooleanChangeAction(BooleanChangeAction object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Change Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Change Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntChangeAction(IntChangeAction object)
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
	public T caseVarChangeActionPkg(VarChangeActionPkg object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IModel Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IModel Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIModelVariable(IModelVariable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntVariable(IntVariable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Duration Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Duration Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDurationVariable(DurationVariable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IModel Variable Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IModel Variable Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIModelVariableAction(IModelVariableAction object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IModel Variable Action Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IModel Variable Action Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIModelVariableActionContainer(IModelVariableActionContainer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Variable Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Variable Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetVariableAction(SetVariableAction object)
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
	public T caseAction(Action object)
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

} //VariableSwitch
