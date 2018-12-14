/**
 */
package org.sheepy.common.model.action.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.common.model.action.*;

import org.sheepy.common.model.root.LNamedElement;

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
 * @see org.sheepy.common.model.action.ActionPackage
 * @generated
 */
public class ActionSwitch<T1> extends Switch<T1>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ActionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = ActionPackage.eINSTANCE;
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
			case ActionPackage.ACTION:
			{
				Action action = (Action)theEObject;
				T1 result = caseAction(action);
				if (result == null) result = caseLNamedElement(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionPackage.XACTION:
			{
				XAction xAction = (XAction)theEObject;
				T1 result = caseXAction(xAction);
				if (result == null) result = caseAction(xAction);
				if (result == null) result = caseLNamedElement(xAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionPackage.PARAMETERED_ACTION:
			{
				ParameteredAction<?> parameteredAction = (ParameteredAction<?>)theEObject;
				T1 result = caseParameteredAction(parameteredAction);
				if (result == null) result = caseAction(parameteredAction);
				if (result == null) result = caseLNamedElement(parameteredAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionPackage.TYPE_INJECTOR_ACTION:
			{
				TypeInjectorAction<?> typeInjectorAction = (TypeInjectorAction<?>)theEObject;
				T1 result = caseTypeInjectorAction(typeInjectorAction);
				if (result == null) result = caseAction(typeInjectorAction);
				if (result == null) result = caseLNamedElement(typeInjectorAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionPackage.STRING_INJECTOR:
			{
				StringInjector stringInjector = (StringInjector)theEObject;
				T1 result = caseStringInjector(stringInjector);
				if (result == null) result = caseTypeInjectorAction(stringInjector);
				if (result == null) result = caseAction(stringInjector);
				if (result == null) result = caseLNamedElement(stringInjector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionPackage.NUMBER_INJECTOR:
			{
				NumberInjector numberInjector = (NumberInjector)theEObject;
				T1 result = caseNumberInjector(numberInjector);
				if (result == null) result = caseTypeInjectorAction(numberInjector);
				if (result == null) result = caseAction(numberInjector);
				if (result == null) result = caseLNamedElement(numberInjector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionPackage.PARAMETERED_ACTIONS_PKG:
			{
				ParameteredActionsPkg<?> parameteredActionsPkg = (ParameteredActionsPkg<?>)theEObject;
				T1 result = caseParameteredActionsPkg(parameteredActionsPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionPackage.ACTIONS_PKG:
			{
				ActionsPkg actionsPkg = (ActionsPkg)theEObject;
				T1 result = caseActionsPkg(actionsPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>XAction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XAction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseXAction(XAction object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Type Injector Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Injector Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Parameter> T1 caseTypeInjectorAction(TypeInjectorAction<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Injector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Injector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStringInjector(StringInjector object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Injector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Injector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNumberInjector(NumberInjector object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parametered Actions Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parametered Actions Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Parameter> T1 caseParameteredActionsPkg(ParameteredActionsPkg<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actions Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actions Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseActionsPkg(ActionsPkg object)
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

} //ActionSwitch
