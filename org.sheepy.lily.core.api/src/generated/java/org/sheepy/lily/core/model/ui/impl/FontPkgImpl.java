/**
 */
package org.sheepy.lily.core.model.ui.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.FontPkg;
import org.sheepy.lily.core.model.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font Pkg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.FontPkgImpl#getFonts <em>Fonts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FontPkgImpl extends LilyEObject implements FontPkg
{
	/**
	 * The cached value of the '{@link #getFonts() <em>Fonts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFonts()
	 * @generated
	 * @ordered
	 */
	protected EList<Font> fonts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FontPkgImpl()
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
		return UiPackage.Literals.FONT_PKG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Font> getFonts()
	{
		if (fonts == null)
		{
			fonts = new EObjectContainmentEList.Resolving<Font>(Font.class, this, UiPackage.FONT_PKG__FONTS);
		}
		return fonts;
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
			case UiPackage.FONT_PKG__FONTS:
				return ((InternalEList<?>)getFonts()).basicRemove(otherEnd, msgs);
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
			case UiPackage.FONT_PKG__FONTS:
				return getFonts();
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
			case UiPackage.FONT_PKG__FONTS:
				getFonts().clear();
				getFonts().addAll((Collection<? extends Font>)newValue);
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
			case UiPackage.FONT_PKG__FONTS:
				getFonts().clear();
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
			case UiPackage.FONT_PKG__FONTS:
				return fonts != null && !fonts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FontPkgImpl
