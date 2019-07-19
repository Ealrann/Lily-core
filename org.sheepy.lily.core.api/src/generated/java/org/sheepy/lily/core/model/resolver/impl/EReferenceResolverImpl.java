/**
 */
package org.sheepy.lily.core.model.resolver.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.core.model.resolver.EReferenceResolver;
import org.sheepy.lily.core.model.resolver.ResolverPackage;

import org.sheepy.lily.core.model.root.LObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EReference Resolver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.resolver.impl.EReferenceResolverImpl#getReferenceName <em>Reference Name</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.resolver.impl.EReferenceResolverImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.resolver.impl.EReferenceResolverImpl#getInternalReference <em>Internal Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EReferenceResolverImpl extends MinimalEObjectImpl.Container implements EReferenceResolver
{
	/**
	 * The default value of the '{@link #getReferenceName() <em>Reference Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferenceName() <em>Reference Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceName()
	 * @generated
	 * @ordered
	 */
	protected String referenceName = REFERENCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInternalReference() <em>Internal Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalReference()
	 * @generated
	 * @ordered
	 */
	protected EReference internalReference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EReferenceResolverImpl()
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
		return ResolverPackage.Literals.EREFERENCE_RESOLVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getReferenceName()
	{
		return referenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceName(String newReferenceName)
	{
		String oldReferenceName = referenceName;
		referenceName = newReferenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResolverPackage.EREFERENCE_RESOLVER__REFERENCE_NAME, oldReferenceName, referenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClassName()
	{
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassName(String newClassName)
	{
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResolverPackage.EREFERENCE_RESOLVER__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInternalReference()
	{
		if (internalReference != null && internalReference.eIsProxy())
		{
			InternalEObject oldInternalReference = (InternalEObject)internalReference;
			internalReference = (EReference)eResolveProxy(oldInternalReference);
			if (internalReference != oldInternalReference)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResolverPackage.EREFERENCE_RESOLVER__INTERNAL_REFERENCE, oldInternalReference, internalReference));
			}
		}
		return internalReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetInternalReference()
	{
		return internalReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInternalReference(EReference newInternalReference)
	{
		EReference oldInternalReference = internalReference;
		internalReference = newInternalReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResolverPackage.EREFERENCE_RESOLVER__INTERNAL_REFERENCE, oldInternalReference, internalReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void collectUnits(final LObject source, final Collection<LObject> collected)
	{
		EReference _internalReference = this.getInternalReference();
		boolean _tripleEquals = (_internalReference == null);
		if (_tripleEquals)
		{
			EList<EReference> _eAllReferences = source.eClass().getEAllReferences();
			for (final EReference ref : _eAllReferences)
			{
				boolean _equals = ref.getName().equals(this.getReferenceName());
				if (_equals)
				{
					this.setInternalReference(ref);
				}
			}
		}
		EReference _internalReference_1 = this.getInternalReference();
		boolean _tripleNotEquals = (_internalReference_1 != null);
		if (_tripleNotEquals)
		{
			boolean _isMany = this.getInternalReference().isMany();
			if (_isMany)
			{
				Object _eGet = source.eGet(this.getInternalReference());
				for (final Object obj : ((EList<?>) _eGet))
				{
					if (((this.getClassName() == null) || ((EObject) obj).eClass().getName().equals(this.getClassName())))
					{
						collected.add(((LObject) obj));
					}
				}
			}
			else
			{
				Object _eGet_1 = source.eGet(this.getInternalReference());
				final LObject target = ((LObject) _eGet_1);
				if (((this.getClassName() == null) || target.eClass().getName().equals(this.getClassName())))
				{
					collected.add(target);
				}
			}
		}
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
			case ResolverPackage.EREFERENCE_RESOLVER__REFERENCE_NAME:
				return getReferenceName();
			case ResolverPackage.EREFERENCE_RESOLVER__CLASS_NAME:
				return getClassName();
			case ResolverPackage.EREFERENCE_RESOLVER__INTERNAL_REFERENCE:
				if (resolve) return getInternalReference();
				return basicGetInternalReference();
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
			case ResolverPackage.EREFERENCE_RESOLVER__REFERENCE_NAME:
				setReferenceName((String)newValue);
				return;
			case ResolverPackage.EREFERENCE_RESOLVER__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case ResolverPackage.EREFERENCE_RESOLVER__INTERNAL_REFERENCE:
				setInternalReference((EReference)newValue);
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
			case ResolverPackage.EREFERENCE_RESOLVER__REFERENCE_NAME:
				setReferenceName(REFERENCE_NAME_EDEFAULT);
				return;
			case ResolverPackage.EREFERENCE_RESOLVER__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case ResolverPackage.EREFERENCE_RESOLVER__INTERNAL_REFERENCE:
				setInternalReference((EReference)null);
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
			case ResolverPackage.EREFERENCE_RESOLVER__REFERENCE_NAME:
				return REFERENCE_NAME_EDEFAULT == null ? referenceName != null : !REFERENCE_NAME_EDEFAULT.equals(referenceName);
			case ResolverPackage.EREFERENCE_RESOLVER__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case ResolverPackage.EREFERENCE_RESOLVER__INTERNAL_REFERENCE:
				return internalReference != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case ResolverPackage.EREFERENCE_RESOLVER___COLLECT_UNITS__LOBJECT_COLLECTION:
				collectUnits((LObject)arguments.get(0), (Collection<LObject>)arguments.get(1));
				return null;
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
		result.append(" (referenceName: ");
		result.append(referenceName);
		result.append(", className: ");
		result.append(className);
		result.append(')');
		return result.toString();
	}

} //EReferenceResolverImpl
