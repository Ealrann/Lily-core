/**
 */
package org.sheepy.lily.core.model.ui.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.lily.core.model.inference.IInferenceObject;

import org.sheepy.lily.core.model.presentation.IPanel;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.presentation.IUIElement;

import org.sheepy.lily.core.model.root.LObject;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.core.model.ui.*;

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
 * @see org.sheepy.lily.core.model.ui.UiPackage
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
			case UiPackage.PANEL:
			{
				Panel panel = (Panel)theEObject;
				T result = casePanel(panel);
				if (result == null) result = caseIPanel(panel);
				if (result == null) result = caseISizedElement(panel);
				if (result == null) result = caseLNamedElement(panel);
				if (result == null) result = caseIUIElement(panel);
				if (result == null) result = caseIPositionElement(panel);
				if (result == null) result = caseLObject(panel);
				if (result == null) result = caseIInferenceObject(panel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.ICONTROL:
			{
				IControl iControl = (IControl)theEObject;
				T result = caseIControl(iControl);
				if (result == null) result = caseIUIElement(iControl);
				if (result == null) result = caseLObject(iControl);
				if (result == null) result = caseIInferenceObject(iControl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.WIDGET:
			{
				Widget widget = (Widget)theEObject;
				T result = caseWidget(widget);
				if (result == null) result = caseIControl(widget);
				if (result == null) result = caseISizedElement(widget);
				if (result == null) result = caseIUIElement(widget);
				if (result == null) result = caseIPositionElement(widget);
				if (result == null) result = caseLObject(widget);
				if (result == null) result = caseIInferenceObject(widget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.ABSTRACT_LABEL:
			{
				AbstractLabel abstractLabel = (AbstractLabel)theEObject;
				T result = caseAbstractLabel(abstractLabel);
				if (result == null) result = caseWidget(abstractLabel);
				if (result == null) result = caseIControl(abstractLabel);
				if (result == null) result = caseISizedElement(abstractLabel);
				if (result == null) result = caseIUIElement(abstractLabel);
				if (result == null) result = caseIPositionElement(abstractLabel);
				if (result == null) result = caseLObject(abstractLabel);
				if (result == null) result = caseIInferenceObject(abstractLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.DYNAMIC_ROW_LAYOUT:
			{
				DynamicRowLayout dynamicRowLayout = (DynamicRowLayout)theEObject;
				T result = caseDynamicRowLayout(dynamicRowLayout);
				if (result == null) result = caseIControl(dynamicRowLayout);
				if (result == null) result = caseIUIElement(dynamicRowLayout);
				if (result == null) result = caseLObject(dynamicRowLayout);
				if (result == null) result = caseIInferenceObject(dynamicRowLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.VARIABLE_LABEL:
			{
				VariableLabel variableLabel = (VariableLabel)theEObject;
				T result = caseVariableLabel(variableLabel);
				if (result == null) result = caseAbstractLabel(variableLabel);
				if (result == null) result = caseWidget(variableLabel);
				if (result == null) result = caseIControl(variableLabel);
				if (result == null) result = caseISizedElement(variableLabel);
				if (result == null) result = caseIUIElement(variableLabel);
				if (result == null) result = caseIPositionElement(variableLabel);
				if (result == null) result = caseLObject(variableLabel);
				if (result == null) result = caseIInferenceObject(variableLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.LABEL:
			{
				Label label = (Label)theEObject;
				T result = caseLabel(label);
				if (result == null) result = caseAbstractLabel(label);
				if (result == null) result = caseWidget(label);
				if (result == null) result = caseIControl(label);
				if (result == null) result = caseISizedElement(label);
				if (result == null) result = caseIUIElement(label);
				if (result == null) result = caseIPositionElement(label);
				if (result == null) result = caseLObject(label);
				if (result == null) result = caseIInferenceObject(label);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.SLIDER:
			{
				Slider slider = (Slider)theEObject;
				T result = caseSlider(slider);
				if (result == null) result = caseWidget(slider);
				if (result == null) result = caseIControl(slider);
				if (result == null) result = caseISizedElement(slider);
				if (result == null) result = caseIUIElement(slider);
				if (result == null) result = caseIPositionElement(slider);
				if (result == null) result = caseLObject(slider);
				if (result == null) result = caseIInferenceObject(slider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.TEXT_FIELD:
			{
				TextField textField = (TextField)theEObject;
				T result = caseTextField(textField);
				if (result == null) result = caseWidget(textField);
				if (result == null) result = caseIControl(textField);
				if (result == null) result = caseISizedElement(textField);
				if (result == null) result = caseIUIElement(textField);
				if (result == null) result = caseIPositionElement(textField);
				if (result == null) result = caseLObject(textField);
				if (result == null) result = caseIInferenceObject(textField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.ABSTRACT_BUTTON:
			{
				AbstractButton abstractButton = (AbstractButton)theEObject;
				T result = caseAbstractButton(abstractButton);
				if (result == null) result = caseWidget(abstractButton);
				if (result == null) result = caseIControl(abstractButton);
				if (result == null) result = caseISizedElement(abstractButton);
				if (result == null) result = caseIUIElement(abstractButton);
				if (result == null) result = caseIPositionElement(abstractButton);
				if (result == null) result = caseLObject(abstractButton);
				if (result == null) result = caseIInferenceObject(abstractButton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.BUTTON:
			{
				Button button = (Button)theEObject;
				T result = caseButton(button);
				if (result == null) result = caseAbstractButton(button);
				if (result == null) result = caseWidget(button);
				if (result == null) result = caseIControl(button);
				if (result == null) result = caseISizedElement(button);
				if (result == null) result = caseIUIElement(button);
				if (result == null) result = caseIPositionElement(button);
				if (result == null) result = caseLObject(button);
				if (result == null) result = caseIInferenceObject(button);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.ABSTRACT_BOOLEAN_BUTTON:
			{
				AbstractBooleanButton abstractBooleanButton = (AbstractBooleanButton)theEObject;
				T result = caseAbstractBooleanButton(abstractBooleanButton);
				if (result == null) result = caseAbstractButton(abstractBooleanButton);
				if (result == null) result = caseWidget(abstractBooleanButton);
				if (result == null) result = caseIControl(abstractBooleanButton);
				if (result == null) result = caseISizedElement(abstractBooleanButton);
				if (result == null) result = caseIUIElement(abstractBooleanButton);
				if (result == null) result = caseIPositionElement(abstractBooleanButton);
				if (result == null) result = caseLObject(abstractBooleanButton);
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
				if (result == null) result = caseWidget(booleanButton);
				if (result == null) result = caseIControl(booleanButton);
				if (result == null) result = caseISizedElement(booleanButton);
				if (result == null) result = caseIUIElement(booleanButton);
				if (result == null) result = caseIPositionElement(booleanButton);
				if (result == null) result = caseLObject(booleanButton);
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
				if (result == null) result = caseWidget(booleanActionButton);
				if (result == null) result = caseIControl(booleanActionButton);
				if (result == null) result = caseISizedElement(booleanActionButton);
				if (result == null) result = caseIUIElement(booleanActionButton);
				if (result == null) result = caseIPositionElement(booleanActionButton);
				if (result == null) result = caseLObject(booleanActionButton);
				if (result == null) result = caseIInferenceObject(booleanActionButton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Panel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Panel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePanel(Panel object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IControl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IControl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIControl(IControl object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Widget</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Widget</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWidget(Widget object)
	{
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>Slider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Slider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlider(Slider object)
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
	 * Returns the result of interpreting the object as an instance of '<em>IUI Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IUI Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIUIElement(IUIElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPosition Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPosition Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPositionElement(IPositionElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPanel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPanel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPanel(IPanel object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISized Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISized Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseISizedElement(ISizedElement object)
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
