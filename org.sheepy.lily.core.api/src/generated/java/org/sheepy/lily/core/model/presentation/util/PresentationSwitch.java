/**
 */
package org.sheepy.lily.core.model.presentation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.IPresentationPkg;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.core.model.presentation.Presentations;
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
 * @see org.sheepy.lily.core.model.presentation.PresentationPackage
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
			case PresentationPackage.IPOSITION_ELEMENT:
			{
				IPositionElement iPositionElement = (IPositionElement)theEObject;
				T result = caseIPositionElement(iPositionElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.ISIZED_ELEMENT:
			{
				ISizedElement iSizedElement = (ISizedElement)theEObject;
				T result = caseISizedElement(iSizedElement);
				if (result == null) result = caseIPositionElement(iSizedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.PRESENTATIONS:
			{
				Presentations presentations = (Presentations)theEObject;
				T result = casePresentations(presentations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.IPRESENTATION_PKG:
			{
				IPresentationPkg iPresentationPkg = (IPresentationPkg)theEObject;
				T result = caseIPresentationPkg(iPresentationPkg);
				if (result == null) result = caseLNamedElement(iPresentationPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Presentations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePresentations(Presentations object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPresentation Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPresentation Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPresentationPkg(IPresentationPkg object)
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
