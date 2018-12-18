/**
 */
package org.sheepy.common.model.ui.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.common.model.inference.IInferenceObject;

import org.sheepy.common.model.presentation.IControl;
import org.sheepy.common.model.presentation.IRelativeElement;
import org.sheepy.common.model.presentation.ISizedElement;
import org.sheepy.common.model.presentation.IUIElement;
import org.sheepy.common.model.presentation.Widget;

import org.sheepy.common.model.root.LObject;

import org.sheepy.common.model.ui.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.common.model.ui.UiPackage
 * @generated
 */
public class UiAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UiPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = UiPackage.eINSTANCE;
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
	protected UiSwitch<Adapter> modelSwitch =
		new UiSwitch<Adapter>()
		{
			@Override
			public Adapter caseAbstractLabel(AbstractLabel object)
			{
				return createAbstractLabelAdapter();
			}
			@Override
			public Adapter caseDynamicRowLayout(DynamicRowLayout object)
			{
				return createDynamicRowLayoutAdapter();
			}
			@Override
			public Adapter caseVariableLabel(VariableLabel object)
			{
				return createVariableLabelAdapter();
			}
			@Override
			public Adapter caseLabel(Label object)
			{
				return createLabelAdapter();
			}
			@Override
			public Adapter caseTextField(TextField object)
			{
				return createTextFieldAdapter();
			}
			@Override
			public Adapter caseAbstractButton(AbstractButton object)
			{
				return createAbstractButtonAdapter();
			}
			@Override
			public Adapter caseButton(Button object)
			{
				return createButtonAdapter();
			}
			@Override
			public Adapter caseAbstractBooleanButton(AbstractBooleanButton object)
			{
				return createAbstractBooleanButtonAdapter();
			}
			@Override
			public Adapter caseBooleanButton(BooleanButton object)
			{
				return createBooleanButtonAdapter();
			}
			@Override
			public Adapter caseBooleanActionButton(BooleanActionButton object)
			{
				return createBooleanActionButtonAdapter();
			}
			@Override
			public Adapter caseIInferenceObject(IInferenceObject object)
			{
				return createIInferenceObjectAdapter();
			}
			@Override
			public Adapter caseLObject(LObject object)
			{
				return createLObjectAdapter();
			}
			@Override
			public Adapter caseIUIElement(IUIElement object)
			{
				return createIUIElementAdapter();
			}
			@Override
			public Adapter caseIControl(IControl object)
			{
				return createIControlAdapter();
			}
			@Override
			public Adapter caseIRelativeElement(IRelativeElement object)
			{
				return createIRelativeElementAdapter();
			}
			@Override
			public Adapter caseISizedElement(ISizedElement object)
			{
				return createISizedElementAdapter();
			}
			@Override
			public Adapter caseWidget(Widget object)
			{
				return createWidgetAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.ui.AbstractLabel <em>Abstract Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.ui.AbstractLabel
	 * @generated
	 */
	public Adapter createAbstractLabelAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.ui.DynamicRowLayout <em>Dynamic Row Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.ui.DynamicRowLayout
	 * @generated
	 */
	public Adapter createDynamicRowLayoutAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.ui.VariableLabel <em>Variable Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.ui.VariableLabel
	 * @generated
	 */
	public Adapter createVariableLabelAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.ui.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.ui.Label
	 * @generated
	 */
	public Adapter createLabelAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.ui.TextField <em>Text Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.ui.TextField
	 * @generated
	 */
	public Adapter createTextFieldAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.ui.AbstractButton <em>Abstract Button</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.ui.AbstractButton
	 * @generated
	 */
	public Adapter createAbstractButtonAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.ui.Button <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.ui.Button
	 * @generated
	 */
	public Adapter createButtonAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.ui.AbstractBooleanButton <em>Abstract Boolean Button</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.ui.AbstractBooleanButton
	 * @generated
	 */
	public Adapter createAbstractBooleanButtonAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.ui.BooleanButton <em>Boolean Button</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.ui.BooleanButton
	 * @generated
	 */
	public Adapter createBooleanButtonAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.ui.BooleanActionButton <em>Boolean Action Button</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.ui.BooleanActionButton
	 * @generated
	 */
	public Adapter createBooleanActionButtonAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.inference.IInferenceObject <em>IInference Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.inference.IInferenceObject
	 * @generated
	 */
	public Adapter createIInferenceObjectAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.root.LObject <em>LObject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.root.LObject
	 * @generated
	 */
	public Adapter createLObjectAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.presentation.IUIElement <em>IUI Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.presentation.IUIElement
	 * @generated
	 */
	public Adapter createIUIElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.presentation.IControl <em>IControl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.presentation.IControl
	 * @generated
	 */
	public Adapter createIControlAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.presentation.IRelativeElement <em>IRelative Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.presentation.IRelativeElement
	 * @generated
	 */
	public Adapter createIRelativeElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.presentation.ISizedElement <em>ISized Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.presentation.ISizedElement
	 * @generated
	 */
	public Adapter createISizedElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.common.model.presentation.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.common.model.presentation.Widget
	 * @generated
	 */
	public Adapter createWidgetAdapter()
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

} //UiAdapterFactory
