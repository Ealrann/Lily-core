/**
 */
package org.sheepy.common.model.ui.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.common.model.inference.IInferenceObject;

import org.sheepy.common.model.presentation.Control;
import org.sheepy.common.model.presentation.IPresentationElement;
import org.sheepy.common.model.presentation.UIElement;

import org.sheepy.common.model.root.LObject;

import org.sheepy.common.model.ui.*;

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
 * @see org.sheepy.common.model.ui.UiPackage
 * @generated
 */
public class UiSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UiPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = UiPackage.eINSTANCE;
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
			case UiPackage.ABSTRACT_LABEL:
			{
				AbstractLabel abstractLabel = (AbstractLabel)theEObject;
				T result = caseAbstractLabel(abstractLabel);
				if (result == null) result = caseControl(abstractLabel);
				if (result == null) result = caseUIElement(abstractLabel);
				if (result == null) result = caseLObject(abstractLabel);
				if (result == null) result = caseIPresentationElement(abstractLabel);
				if (result == null) result = caseIInferenceObject(abstractLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.DYNAMIC_ROW_LAYOUT:
			{
				DynamicRowLayout dynamicRowLayout = (DynamicRowLayout)theEObject;
				T result = caseDynamicRowLayout(dynamicRowLayout);
				if (result == null) result = caseControl(dynamicRowLayout);
				if (result == null) result = caseUIElement(dynamicRowLayout);
				if (result == null) result = caseLObject(dynamicRowLayout);
				if (result == null) result = caseIPresentationElement(dynamicRowLayout);
				if (result == null) result = caseIInferenceObject(dynamicRowLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.VARIABLE_LABEL:
			{
				VariableLabel variableLabel = (VariableLabel)theEObject;
				T result = caseVariableLabel(variableLabel);
				if (result == null) result = caseAbstractLabel(variableLabel);
				if (result == null) result = caseControl(variableLabel);
				if (result == null) result = caseUIElement(variableLabel);
				if (result == null) result = caseLObject(variableLabel);
				if (result == null) result = caseIPresentationElement(variableLabel);
				if (result == null) result = caseIInferenceObject(variableLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.LABEL:
			{
				Label label = (Label)theEObject;
				T result = caseLabel(label);
				if (result == null) result = caseAbstractLabel(label);
				if (result == null) result = caseControl(label);
				if (result == null) result = caseUIElement(label);
				if (result == null) result = caseLObject(label);
				if (result == null) result = caseIPresentationElement(label);
				if (result == null) result = caseIInferenceObject(label);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.TEXT_FIELD:
			{
				TextField textField = (TextField)theEObject;
				T result = caseTextField(textField);
				if (result == null) result = caseControl(textField);
				if (result == null) result = caseUIElement(textField);
				if (result == null) result = caseLObject(textField);
				if (result == null) result = caseIPresentationElement(textField);
				if (result == null) result = caseIInferenceObject(textField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.ABSTRACT_BUTTON:
			{
				AbstractButton abstractButton = (AbstractButton)theEObject;
				T result = caseAbstractButton(abstractButton);
				if (result == null) result = caseControl(abstractButton);
				if (result == null) result = caseUIElement(abstractButton);
				if (result == null) result = caseLObject(abstractButton);
				if (result == null) result = caseIPresentationElement(abstractButton);
				if (result == null) result = caseIInferenceObject(abstractButton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.BUTTON:
			{
				Button button = (Button)theEObject;
				T result = caseButton(button);
				if (result == null) result = caseAbstractButton(button);
				if (result == null) result = caseControl(button);
				if (result == null) result = caseUIElement(button);
				if (result == null) result = caseLObject(button);
				if (result == null) result = caseIPresentationElement(button);
				if (result == null) result = caseIInferenceObject(button);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.ABSTRACT_BOOLEAN_BUTTON:
			{
				AbstractBooleanButton abstractBooleanButton = (AbstractBooleanButton)theEObject;
				T result = caseAbstractBooleanButton(abstractBooleanButton);
				if (result == null) result = caseAbstractButton(abstractBooleanButton);
				if (result == null) result = caseControl(abstractBooleanButton);
				if (result == null) result = caseUIElement(abstractBooleanButton);
				if (result == null) result = caseLObject(abstractBooleanButton);
				if (result == null) result = caseIPresentationElement(abstractBooleanButton);
				if (result == null) result = caseIInferenceObject(abstractBooleanButton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.BOOLEAN_BUTTON:
			{
				BooleanButton booleanButton = (BooleanButton)theEObject;
				T result = caseBooleanButton(booleanButton);
				if (result == null) result = caseAbstractBooleanButton(booleanButton);
				if (result == null) result = caseAbstractButton(booleanButton);
				if (result == null) result = caseControl(booleanButton);
				if (result == null) result = caseUIElement(booleanButton);
				if (result == null) result = caseLObject(booleanButton);
				if (result == null) result = caseIPresentationElement(booleanButton);
				if (result == null) result = caseIInferenceObject(booleanButton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.BOOLEAN_ACTION_BUTTON:
			{
				BooleanActionButton booleanActionButton = (BooleanActionButton)theEObject;
				T result = caseBooleanActionButton(booleanActionButton);
				if (result == null) result = caseAbstractBooleanButton(booleanActionButton);
				if (result == null) result = caseAbstractButton(booleanActionButton);
				if (result == null) result = caseControl(booleanActionButton);
				if (result == null) result = caseUIElement(booleanActionButton);
				if (result == null) result = caseLObject(booleanActionButton);
				if (result == null) result = caseIPresentationElement(booleanActionButton);
				if (result == null) result = caseIInferenceObject(booleanActionButton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractLabel(AbstractLabel object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Row Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Row Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicRowLayout(DynamicRowLayout object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableLabel(VariableLabel object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabel(Label object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextField(TextField object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Button</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Button</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractButton(AbstractButton object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Button</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Button</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseButton(Button object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Boolean Button</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Boolean Button</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractBooleanButton(AbstractBooleanButton object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Button</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Button</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanButton(BooleanButton object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Action Button</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Action Button</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanActionButton(BooleanActionButton object)
	{
		return null;
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
	public T caseIInferenceObject(IInferenceObject object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLObject(LObject object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPresentation Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPresentation Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPresentationElement(IPresentationElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UI Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UI Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUIElement(UIElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControl(Control object)
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

} //UiSwitch
