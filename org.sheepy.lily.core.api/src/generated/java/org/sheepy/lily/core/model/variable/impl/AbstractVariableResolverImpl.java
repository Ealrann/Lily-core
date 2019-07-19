/**
 */
package org.sheepy.lily.core.model.variable.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.core.model.variable.AbstractVariableResolver;
import org.sheepy.lily.core.model.variable.IDefinitionContainer;
import org.sheepy.lily.core.model.variable.VariablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Variable Resolver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.variable.impl.AbstractVariableResolverImpl#getVariableDefinition <em>Variable Definition</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractVariableResolverImpl extends MinimalEObjectImpl.Container
		implements AbstractVariableResolver
{
	/**
	 * The default value of the '{@link #getVariableDefinition() <em>Variable Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_DEFINITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariableDefinition() <em>Variable Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableDefinition()
	 * @generated
	 * @ordered
	 */
	protected String variableDefinition = VARIABLE_DEFINITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractVariableResolverImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return VariablePackage.Literals.ABSTRACT_VARIABLE_RESOLVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVariableDefinition()
	{
		return variableDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariableDefinition(String newVariableDefinition)
	{
		String oldVariableDefinition = variableDefinition;
		variableDefinition = newVariableDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariablePackage.ABSTRACT_VARIABLE_RESOLVER__VARIABLE_DEFINITION, oldVariableDefinition, variableDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case VariablePackage.ABSTRACT_VARIABLE_RESOLVER__VARIABLE_DEFINITION:
				return getVariableDefinition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case VariablePackage.ABSTRACT_VARIABLE_RESOLVER__VARIABLE_DEFINITION:
				setVariableDefinition((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case VariablePackage.ABSTRACT_VARIABLE_RESOLVER__VARIABLE_DEFINITION:
				setVariableDefinition(VARIABLE_DEFINITION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case VariablePackage.ABSTRACT_VARIABLE_RESOLVER__VARIABLE_DEFINITION:
				return VARIABLE_DEFINITION_EDEFAULT == null ? variableDefinition != null : !VARIABLE_DEFINITION_EDEFAULT.equals(variableDefinition);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == IDefinitionContainer.class)
		{
			switch (derivedFeatureID)
			{
				case VariablePackage.ABSTRACT_VARIABLE_RESOLVER__VARIABLE_DEFINITION: return VariablePackage.IDEFINITION_CONTAINER__VARIABLE_DEFINITION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == IDefinitionContainer.class)
		{
			switch (baseFeatureID)
			{
				case VariablePackage.IDEFINITION_CONTAINER__VARIABLE_DEFINITION: return VariablePackage.ABSTRACT_VARIABLE_RESOLVER__VARIABLE_DEFINITION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (variableDefinition: ");
		result.append(variableDefinition);
		result.append(')');
		return result.toString();
	}

} //AbstractVariableResolverImpl
