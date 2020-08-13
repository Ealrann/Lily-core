/**
 */
package org.sheepy.lily.core.model.resource.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;
import org.sheepy.lily.core.model.resource.*;

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
 * @see org.sheepy.lily.core.model.resource.ResourcePackage
 * @generated
 */
public class ResourceSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ResourcePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = ResourcePackage.eINSTANCE;
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
			case ResourcePackage.SOUND:
			{
				Sound sound = (Sound)theEObject;
				T result = caseSound(sound);
				if (result == null) result = caseIResource(sound);
				if (result == null) result = caseLNamedElement(sound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourcePackage.MUSIC:
			{
				Music music = (Music)theEObject;
				T result = caseMusic(music);
				if (result == null) result = caseIResource(music);
				if (result == null) result = caseLNamedElement(music);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourcePackage.SOUND_CONTINUOUS:
			{
				SoundContinuous soundContinuous = (SoundContinuous)theEObject;
				T result = caseSoundContinuous(soundContinuous);
				if (result == null) result = caseSound(soundContinuous);
				if (result == null) result = caseIResource(soundContinuous);
				if (result == null) result = caseLNamedElement(soundContinuous);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourcePackage.RESOURCE_PKG:
			{
				ResourcePkg resourcePkg = (ResourcePkg)theEObject;
				T result = caseResourcePkg(resourcePkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourcePackage.IRESOURCE:
			{
				IResource iResource = (IResource)theEObject;
				T result = caseIResource(iResource);
				if (result == null) result = caseLNamedElement(iResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourcePackage.IIMAGE:
			{
				IImage iImage = (IImage)theEObject;
				T result = caseIImage(iImage);
				if (result == null) result = caseIResource(iImage);
				if (result == null) result = caseLNamedElement(iImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourcePackage.VIRTUAL_RESOURCE:
			{
				VirtualResource virtualResource = (VirtualResource)theEObject;
				T result = caseVirtualResource(virtualResource);
				if (result == null) result = caseIResource(virtualResource);
				if (result == null) result = caseLNamedElement(virtualResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourcePackage.FILE_RESOURCE:
			{
				FileResource fileResource = (FileResource)theEObject;
				T result = caseFileResource(fileResource);
				if (result == null) result = caseIResource(fileResource);
				if (result == null) result = caseLNamedElement(fileResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourcePackage.LOCAL_RESOURCE:
			{
				LocalResource localResource = (LocalResource)theEObject;
				T result = caseLocalResource(localResource);
				if (result == null) result = caseFileResource(localResource);
				if (result == null) result = caseIResource(localResource);
				if (result == null) result = caseLNamedElement(localResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourcePackage.ABSTRACT_MODULE_RESOURCE:
			{
				AbstractModuleResource abstractModuleResource = (AbstractModuleResource)theEObject;
				T result = caseAbstractModuleResource(abstractModuleResource);
				if (result == null) result = caseFileResource(abstractModuleResource);
				if (result == null) result = caseIResource(abstractModuleResource);
				if (result == null) result = caseLNamedElement(abstractModuleResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourcePackage.MODULE_RESOURCE:
			{
				ModuleResource moduleResource = (ModuleResource)theEObject;
				T result = caseModuleResource(moduleResource);
				if (result == null) result = caseAbstractModuleResource(moduleResource);
				if (result == null) result = caseFileResource(moduleResource);
				if (result == null) result = caseIResource(moduleResource);
				if (result == null) result = caseLNamedElement(moduleResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourcePackage.STRING_MODULE_RESOURCE:
			{
				StringModuleResource stringModuleResource = (StringModuleResource)theEObject;
				T result = caseStringModuleResource(stringModuleResource);
				if (result == null) result = caseAbstractModuleResource(stringModuleResource);
				if (result == null) result = caseFileResource(stringModuleResource);
				if (result == null) result = caseIResource(stringModuleResource);
				if (result == null) result = caseLNamedElement(stringModuleResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourcePackage.FILE_IMAGE:
			{
				FileImage fileImage = (FileImage)theEObject;
				T result = caseFileImage(fileImage);
				if (result == null) result = caseIImage(fileImage);
				if (result == null) result = caseIResource(fileImage);
				if (result == null) result = caseLNamedElement(fileImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSound(Sound object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Music</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Music</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMusic(Music object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sound Continuous</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sound Continuous</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSoundContinuous(SoundContinuous object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourcePkg(ResourcePkg object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IResource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IResource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIResource(IResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IImage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IImage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIImage(IImage object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualResource(VirtualResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileResource(FileResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalResource(LocalResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Module Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Module Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractModuleResource(AbstractModuleResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleResource(ModuleResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Module Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Module Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringModuleResource(StringModuleResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileImage(FileImage object)
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

} //ResourceSwitch
