/**
 */
package org.sheepy.lily.core.model.application.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.lily.core.model.application.*;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.resource.IRootResource;
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
 * @see org.sheepy.lily.core.model.application.ApplicationPackage
 * @generated
 */
public class ApplicationSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ApplicationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = ApplicationPackage.eINSTANCE;
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
			case ApplicationPackage.APPLICATION:
			{
				Application application = (Application)theEObject;
				T result = caseApplication(application);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.IAPPLICATION_EXTENSION:
			{
				IApplicationExtension iApplicationExtension = (IApplicationExtension)theEObject;
				T result = caseIApplicationExtension(iApplicationExtension);
				if (result == null) result = caseLNamedElement(iApplicationExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.APPLICATION_EXTENSION_PKG:
			{
				ApplicationExtensionPkg applicationExtensionPkg = (ApplicationExtensionPkg)theEObject;
				T result = caseApplicationExtensionPkg(applicationExtensionPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.TIME_CONFIGURATION:
			{
				TimeConfiguration timeConfiguration = (TimeConfiguration)theEObject;
				T result = caseTimeConfiguration(timeConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.IENGINE:
			{
				IEngine iEngine = (IEngine)theEObject;
				T result = caseIEngine(iEngine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.IMODEL:
			{
				IModel iModel = (IModel)theEObject;
				T result = caseIModel(iModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.ICOMPOSITOR:
			{
				ICompositor iCompositor = (ICompositor)theEObject;
				T result = caseICompositor(iCompositor);
				if (result == null) result = caseIInferenceObject(iCompositor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.COMPOSITOR_EXTENSION_PKG:
			{
				CompositorExtensionPkg compositorExtensionPkg = (CompositorExtensionPkg)theEObject;
				T result = caseCompositorExtensionPkg(compositorExtensionPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.ICOMPOSITOR_EXTENSION:
			{
				ICompositorExtension iCompositorExtension = (ICompositorExtension)theEObject;
				T result = caseICompositorExtension(iCompositorExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.ICADENCE:
			{
				ICadence iCadence = (ICadence)theEObject;
				T result = caseICadence(iCadence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.SCENE:
			{
				Scene scene = (Scene)theEObject;
				T result = caseScene(scene);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.GENERIC_SCENE_PART:
			{
				GenericScenePart genericScenePart = (GenericScenePart)theEObject;
				T result = caseGenericScenePart(genericScenePart);
				if (result == null) result = caseICompositor(genericScenePart);
				if (result == null) result = caseLNamedElement(genericScenePart);
				if (result == null) result = caseIInferenceObject(genericScenePart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.BACKGROUND_IMAGE:
			{
				BackgroundImage backgroundImage = (BackgroundImage)theEObject;
				T result = caseBackgroundImage(backgroundImage);
				if (result == null) result = caseLNamedElement(backgroundImage);
				if (result == null) result = caseICompositor(backgroundImage);
				if (result == null) result = caseIInferenceObject(backgroundImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.SCREEN_EFFECT:
			{
				ScreenEffect screenEffect = (ScreenEffect)theEObject;
				T result = caseScreenEffect(screenEffect);
				if (result == null) result = caseLNamedElement(screenEffect);
				if (result == null) result = caseICompositor(screenEffect);
				if (result == null) result = caseIInferenceObject(screenEffect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ApplicationPackage.SPECIAL_EFFECT:
			{
				SpecialEffect specialEffect = (SpecialEffect)theEObject;
				T result = caseSpecialEffect(specialEffect);
				if (result == null) result = caseIRootResource(specialEffect);
				if (result == null) result = caseLNamedElement(specialEffect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplication(Application object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IApplication Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IApplication Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIApplicationExtension(IApplicationExtension object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationExtensionPkg(ApplicationExtensionPkg object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeConfiguration(TimeConfiguration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEngine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEngine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEngine(IEngine object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IModel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IModel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIModel(IModel object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICompositor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICompositor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICompositor(ICompositor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compositor Extension Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compositor Extension Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositorExtensionPkg(CompositorExtensionPkg object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICompositor Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICompositor Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICompositorExtension(ICompositorExtension object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Scene</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scene</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScene(Scene object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Scene Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Scene Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericScenePart(GenericScenePart object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Background Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Background Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBackgroundImage(BackgroundImage object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Screen Effect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Screen Effect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScreenEffect(ScreenEffect object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Special Effect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Special Effect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecialEffect(SpecialEffect object)
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
	 * Returns the result of interpreting the object as an instance of '<em>IRoot Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRoot Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIRootResource(IRootResource object)
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

} //ApplicationSwitch
