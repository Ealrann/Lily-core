/**
 */
package org.sheepy.common.model.variable.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.common.api.util.ResolvedVariableFeature;

import org.sheepy.common.model.resolver.ILObjectResolver;

import org.sheepy.common.model.variable.VariablePackage;
import org.sheepy.common.model.variable.VariableResolver;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.variable.impl.VariableResolverImpl#getResolver <em>Resolver</em>}</li>
 *   <li>{@link org.sheepy.common.model.variable.impl.VariableResolverImpl#getVariableDefinition <em>Variable Definition</em>}</li>
 *   <li>{@link org.sheepy.common.model.variable.impl.VariableResolverImpl#getEmfAttributes <em>Emf Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableResolverImpl extends MinimalEObjectImpl.Container implements VariableResolver
{
	/**
	 * The cached value of the '{@link #getResolver() <em>Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolver()
	 * @generated
	 * @ordered
	 */
	protected ILObjectResolver resolver;

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
	 * The default value of the '{@link #getEmfAttributes() <em>Emf Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmfAttributes()
	 * @generated
	 * @ordered
	 */
	protected static final ResolvedVariableFeature EMF_ATTRIBUTES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmfAttributes() <em>Emf Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmfAttributes()
	 * @generated
	 * @ordered
	 */
	protected ResolvedVariableFeature emfAttributes = EMF_ATTRIBUTES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableResolverImpl()
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
		return VariablePackage.Literals.VARIABLE_RESOLVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILObjectResolver getResolver()
	{
		return resolver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResolver(ILObjectResolver newResolver, NotificationChain msgs)
	{
		ILObjectResolver oldResolver = resolver;
		resolver = newResolver;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VariablePackage.VARIABLE_RESOLVER__RESOLVER, oldResolver, newResolver);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolver(ILObjectResolver newResolver)
	{
		if (newResolver != resolver)
		{
			NotificationChain msgs = null;
			if (resolver != null)
				msgs = ((InternalEObject)resolver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VariablePackage.VARIABLE_RESOLVER__RESOLVER, null, msgs);
			if (newResolver != null)
				msgs = ((InternalEObject)newResolver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VariablePackage.VARIABLE_RESOLVER__RESOLVER, null, msgs);
			msgs = basicSetResolver(newResolver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariablePackage.VARIABLE_RESOLVER__RESOLVER, newResolver, newResolver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariableDefinition()
	{
		return variableDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableDefinition(String newVariableDefinition)
	{
		String oldVariableDefinition = variableDefinition;
		variableDefinition = newVariableDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariablePackage.VARIABLE_RESOLVER__VARIABLE_DEFINITION, oldVariableDefinition, variableDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolvedVariableFeature getEmfAttributes()
	{
		return emfAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmfAttributes(ResolvedVariableFeature newEmfAttributes)
	{
		ResolvedVariableFeature oldEmfAttributes = emfAttributes;
		emfAttributes = newEmfAttributes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariablePackage.VARIABLE_RESOLVER__EMF_ATTRIBUTES, oldEmfAttributes, emfAttributes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolvedVariableFeature lEMFAttributes()
	{
		if (((this.getEmfAttributes() == null) && (this.getVariableDefinition() != null)))
		{
			String _variableDefinition = this.getVariableDefinition();
			ResolvedVariableFeature _resolvedVariableFeature = new ResolvedVariableFeature(_variableDefinition);
			this.setEmfAttributes(_resolvedVariableFeature);
		}
		return this.getEmfAttributes();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case VariablePackage.VARIABLE_RESOLVER__RESOLVER:
				return basicSetResolver(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case VariablePackage.VARIABLE_RESOLVER__RESOLVER:
				return getResolver();
			case VariablePackage.VARIABLE_RESOLVER__VARIABLE_DEFINITION:
				return getVariableDefinition();
			case VariablePackage.VARIABLE_RESOLVER__EMF_ATTRIBUTES:
				return getEmfAttributes();
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
			case VariablePackage.VARIABLE_RESOLVER__RESOLVER:
				setResolver((ILObjectResolver)newValue);
				return;
			case VariablePackage.VARIABLE_RESOLVER__VARIABLE_DEFINITION:
				setVariableDefinition((String)newValue);
				return;
			case VariablePackage.VARIABLE_RESOLVER__EMF_ATTRIBUTES:
				setEmfAttributes((ResolvedVariableFeature)newValue);
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
			case VariablePackage.VARIABLE_RESOLVER__RESOLVER:
				setResolver((ILObjectResolver)null);
				return;
			case VariablePackage.VARIABLE_RESOLVER__VARIABLE_DEFINITION:
				setVariableDefinition(VARIABLE_DEFINITION_EDEFAULT);
				return;
			case VariablePackage.VARIABLE_RESOLVER__EMF_ATTRIBUTES:
				setEmfAttributes(EMF_ATTRIBUTES_EDEFAULT);
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
			case VariablePackage.VARIABLE_RESOLVER__RESOLVER:
				return resolver != null;
			case VariablePackage.VARIABLE_RESOLVER__VARIABLE_DEFINITION:
				return VARIABLE_DEFINITION_EDEFAULT == null ? variableDefinition != null : !VARIABLE_DEFINITION_EDEFAULT.equals(variableDefinition);
			case VariablePackage.VARIABLE_RESOLVER__EMF_ATTRIBUTES:
				return EMF_ATTRIBUTES_EDEFAULT == null ? emfAttributes != null : !EMF_ATTRIBUTES_EDEFAULT.equals(emfAttributes);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case VariablePackage.VARIABLE_RESOLVER___LEMF_ATTRIBUTES:
				return lEMFAttributes();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(", emfAttributes: ");
		result.append(emfAttributes);
		result.append(')');
		return result.toString();
	}

} //VariableResolverImpl
