/**
 */
package org.sheepy.lily.core.model.presentation.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.lily.core.model.application.IScenePart;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.presentation.*;
import org.sheepy.lily.core.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.core.model.presentation.PresentationPackage
 * @generated
 */
public class PresentationAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PresentationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = PresentationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PresentationSwitch<Adapter> modelSwitch = new PresentationSwitch<Adapter>()
		{
			@Override
			public Adapter caseIPositionElement(IPositionElement object)
			{
				return createIPositionElementAdapter();
			}
			@Override
			public Adapter caseISizedElement(ISizedElement object)
			{
				return createISizedElementAdapter();
			}
			@Override
			public Adapter caseUI(UI object)
			{
				return createUIAdapter();
			}
			@Override
			public Adapter caseIUIElement(IUIElement object)
			{
				return createIUIElementAdapter();
			}
			@Override
			public Adapter caseUIPage(UIPage object)
			{
				return createUIPageAdapter();
			}
			@Override
			public Adapter caseIPanel(IPanel object)
			{
				return createIPanelAdapter();
			}
			@Override
			public Adapter caseIInferenceObject(IInferenceObject object)
			{
				return createIInferenceObjectAdapter();
			}
			@Override
			public Adapter caseIScenePart(IScenePart object)
			{
				return createIScenePartAdapter();
			}
			@Override
			public Adapter caseLNamedElement(LNamedElement object)
			{
				return createLNamedElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.presentation.IPositionElement <em>IPosition Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.presentation.IPositionElement
	 * @generated
	 */
	public Adapter createIPositionElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.presentation.ISizedElement <em>ISized Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.presentation.ISizedElement
	 * @generated
	 */
	public Adapter createISizedElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.presentation.UI <em>UI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.presentation.UI
	 * @generated
	 */
	public Adapter createUIAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.presentation.IUIElement <em>IUI Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.presentation.IUIElement
	 * @generated
	 */
	public Adapter createIUIElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.presentation.UIPage <em>UI Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.presentation.UIPage
	 * @generated
	 */
	public Adapter createUIPageAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.presentation.IPanel <em>IPanel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.presentation.IPanel
	 * @generated
	 */
	public Adapter createIPanelAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.inference.IInferenceObject <em>IInference Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.inference.IInferenceObject
	 * @generated
	 */
	public Adapter createIInferenceObjectAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.application.IScenePart <em>IScene Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.application.IScenePart
	 * @generated
	 */
	public Adapter createIScenePartAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.types.LNamedElement <em>LNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.types.LNamedElement
	 * @generated
	 */
	public Adapter createLNamedElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //PresentationAdapterFactory
