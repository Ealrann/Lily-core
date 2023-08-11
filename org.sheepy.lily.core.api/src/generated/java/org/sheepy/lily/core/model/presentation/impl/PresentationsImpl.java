/**
 */
package org.sheepy.lily.core.model.presentation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.model.presentation.IPresentationPkg;
import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.core.model.presentation.Presentations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Presentations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.presentation.impl.PresentationsImpl#getPresentationPkgs <em>Presentation Pkgs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PresentationsImpl extends LilyEObject implements Presentations
{
	/**
	 * The cached value of the '{@link #getPresentationPkgs() <em>Presentation Pkgs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationPkgs()
	 * @generated
	 * @ordered
	 */
	protected EList<IPresentationPkg> presentationPkgs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PresentationsImpl()
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
		return PresentationPackage.Literals.PRESENTATIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IPresentationPkg> getPresentationPkgs()
	{
		if (presentationPkgs == null)
		{
			presentationPkgs = new EObjectContainmentEList.Resolving<>(IPresentationPkg.class, this, PresentationPackage.PRESENTATIONS__PRESENTATION_PKGS);
		}
		return presentationPkgs;
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
			case PresentationPackage.PRESENTATIONS__PRESENTATION_PKGS:
				return ((InternalEList<?>)getPresentationPkgs()).basicRemove(otherEnd, msgs);
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
			case PresentationPackage.PRESENTATIONS__PRESENTATION_PKGS:
				return getPresentationPkgs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PresentationPackage.PRESENTATIONS__PRESENTATION_PKGS:
				getPresentationPkgs().clear();
				getPresentationPkgs().addAll((Collection<? extends IPresentationPkg>)newValue);
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
			case PresentationPackage.PRESENTATIONS__PRESENTATION_PKGS:
				getPresentationPkgs().clear();
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
			case PresentationPackage.PRESENTATIONS__PRESENTATION_PKGS:
				return presentationPkgs != null && !presentationPkgs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PresentationsImpl
