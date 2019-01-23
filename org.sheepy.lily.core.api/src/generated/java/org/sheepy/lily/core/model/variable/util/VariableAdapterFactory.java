/**
 */
package org.sheepy.lily.core.model.variable.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.variable.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.core.model.variable.VariablePackage
 * @generated
 */
public class VariableAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VariablePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = VariablePackage.eINSTANCE;
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
	protected VariableSwitch<Adapter> modelSwitch =
		new VariableSwitch<Adapter>()
		{
			@Override
			public Adapter caseIVariableResolver(IVariableResolver object)
			{
				return createIVariableResolverAdapter();
			}
			@Override
			public Adapter caseIDefinitionContainer(IDefinitionContainer object)
			{
				return createIDefinitionContainerAdapter();
			}
			@Override
			public Adapter caseChainVariableResolver(ChainVariableResolver object)
			{
				return createChainVariableResolverAdapter();
			}
			@Override
			public Adapter caseChainResolver(ChainResolver object)
			{
				return createChainResolverAdapter();
			}
			@Override
			public Adapter caseAbstractVariableResolver(AbstractVariableResolver object)
			{
				return createAbstractVariableResolverAdapter();
			}
			@Override
			public Adapter caseDirectVariableResolver(DirectVariableResolver object)
			{
				return createDirectVariableResolverAdapter();
			}
			@Override
			public Adapter caseVarChangeAction(VarChangeAction object)
			{
				return createVarChangeActionAdapter();
			}
			@Override
			public Adapter caseBooleanChangeAction(BooleanChangeAction object)
			{
				return createBooleanChangeActionAdapter();
			}
			@Override
			public Adapter caseVarChangeActionPkg(VarChangeActionPkg object)
			{
				return createVarChangeActionPkgAdapter();
			}
			@Override
			public Adapter caseLNamedElement(LNamedElement object)
			{
				return createLNamedElementAdapter();
			}
			@Override
			public Adapter caseAction(Action object)
			{
				return createActionAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.variable.IVariableResolver <em>IVariable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.variable.IVariableResolver
	 * @generated
	 */
	public Adapter createIVariableResolverAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.variable.IDefinitionContainer <em>IDefinition Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.variable.IDefinitionContainer
	 * @generated
	 */
	public Adapter createIDefinitionContainerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.variable.ChainVariableResolver <em>Chain Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.variable.ChainVariableResolver
	 * @generated
	 */
	public Adapter createChainVariableResolverAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.variable.ChainResolver <em>Chain Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.variable.ChainResolver
	 * @generated
	 */
	public Adapter createChainResolverAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.variable.AbstractVariableResolver <em>Abstract Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.variable.AbstractVariableResolver
	 * @generated
	 */
	public Adapter createAbstractVariableResolverAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.variable.DirectVariableResolver <em>Direct Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.variable.DirectVariableResolver
	 * @generated
	 */
	public Adapter createDirectVariableResolverAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.variable.VarChangeAction <em>Var Change Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.variable.VarChangeAction
	 * @generated
	 */
	public Adapter createVarChangeActionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.variable.BooleanChangeAction <em>Boolean Change Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.variable.BooleanChangeAction
	 * @generated
	 */
	public Adapter createBooleanChangeActionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.variable.VarChangeActionPkg <em>Var Change Action Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.variable.VarChangeActionPkg
	 * @generated
	 */
	public Adapter createVarChangeActionPkgAdapter()
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
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.action.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.action.Action
	 * @generated
	 */
	public Adapter createActionAdapter()
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

} //VariableAdapterFactory
