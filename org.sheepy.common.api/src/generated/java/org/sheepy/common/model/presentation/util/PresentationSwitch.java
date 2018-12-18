/**
 */
package org.sheepy.common.model.presentation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.common.model.application.IView;

import org.sheepy.common.model.inference.IInferenceObject;

import org.sheepy.common.model.presentation.*;

import org.sheepy.common.model.root.LObject;

import org.sheepy.common.model.types.LNamedElement;

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
 * @see org.sheepy.common.model.presentation.PresentationPackage
 * @generated
 */
public class PresentationSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PresentationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = PresentationPackage.eINSTANCE;
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
			case PresentationPackage.ISIZED_ELEMENT:
			{
				ISizedElement iSizedElement = (ISizedElement)theEObject;
				T result = caseISizedElement(iSizedElement);
				if (result == null) result = caseLObject(iSizedElement);
				if (result == null) result = caseIInferenceObject(iSizedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.IRELATIVE_ELEMENT:
			{
				IRelativeElement iRelativeElement = (IRelativeElement)theEObject;
				T result = caseIRelativeElement(iRelativeElement);
				if (result == null) result = caseLObject(iRelativeElement);
				if (result == null) result = caseIInferenceObject(iRelativeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.IUI_VIEW:
			{
				IUIView iuiView = (IUIView)theEObject;
				T result = caseIUIView(iuiView);
				if (result == null) result = caseIView(iuiView);
				if (result == null) result = caseLObject(iuiView);
				if (result == null) result = caseIInferenceObject(iuiView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.TRANPARENT_UI_VIEW:
			{
				TranparentUIView tranparentUIView = (TranparentUIView)theEObject;
				T result = caseTranparentUIView(tranparentUIView);
				if (result == null) result = caseIUIView(tranparentUIView);
				if (result == null) result = caseIView(tranparentUIView);
				if (result == null) result = caseLObject(tranparentUIView);
				if (result == null) result = caseIInferenceObject(tranparentUIView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.IMUSIC_VIEW:
			{
				IMusicView iMusicView = (IMusicView)theEObject;
				T result = caseIMusicView(iMusicView);
				if (result == null) result = caseIView(iMusicView);
				if (result == null) result = caseLObject(iMusicView);
				if (result == null) result = caseIInferenceObject(iMusicView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.ISIZED_VIEW:
			{
				ISizedView iSizedView = (ISizedView)theEObject;
				T result = caseISizedView(iSizedView);
				if (result == null) result = caseISizedElement(iSizedView);
				if (result == null) result = caseIView(iSizedView);
				if (result == null) result = caseLObject(iSizedView);
				if (result == null) result = caseIInferenceObject(iSizedView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.IUI_ELEMENT:
			{
				IUIElement iuiElement = (IUIElement)theEObject;
				T result = caseIUIElement(iuiElement);
				if (result == null) result = caseLObject(iuiElement);
				if (result == null) result = caseIInferenceObject(iuiElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.UI_PAGE:
			{
				UIPage uiPage = (UIPage)theEObject;
				T result = caseUIPage(uiPage);
				if (result == null) result = caseISizedElement(uiPage);
				if (result == null) result = caseLObject(uiPage);
				if (result == null) result = caseIInferenceObject(uiPage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.PANEL:
			{
				Panel panel = (Panel)theEObject;
				T result = casePanel(panel);
				if (result == null) result = caseIUIElement(panel);
				if (result == null) result = caseLNamedElement(panel);
				if (result == null) result = caseIRelativeElement(panel);
				if (result == null) result = caseISizedElement(panel);
				if (result == null) result = caseLObject(panel);
				if (result == null) result = caseIInferenceObject(panel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.ICONTROL:
			{
				IControl iControl = (IControl)theEObject;
				T result = caseIControl(iControl);
				if (result == null) result = caseIUIElement(iControl);
				if (result == null) result = caseLObject(iControl);
				if (result == null) result = caseIInferenceObject(iControl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.WIDGET:
			{
				Widget widget = (Widget)theEObject;
				T result = caseWidget(widget);
				if (result == null) result = caseIControl(widget);
				if (result == null) result = caseIRelativeElement(widget);
				if (result == null) result = caseISizedElement(widget);
				if (result == null) result = caseIUIElement(widget);
				if (result == null) result = caseLObject(widget);
				if (result == null) result = caseIInferenceObject(widget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>IRelative Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRelative Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIRelativeElement(IRelativeElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IUI View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IUI View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIUIView(IUIView object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tranparent UI View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tranparent UI View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTranparentUIView(TranparentUIView object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMusic View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMusic View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMusicView(IMusicView object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISized View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISized View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseISizedView(ISizedView object)
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
	 * Returns the result of interpreting the object as an instance of '<em>UI Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UI Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUIPage(UIPage object)
	{
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>IView</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IView</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIView(IView object)
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

} //PresentationSwitch
