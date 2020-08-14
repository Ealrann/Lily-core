/**
 */
package org.sheepy.lily.core.model.ui.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.types.ECharTable;

import org.sheepy.lily.core.model.ui.FontTable;
import org.sheepy.lily.core.model.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.FontTableImpl#getFile <em>File</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.impl.FontTableImpl#getCharTables <em>Char Tables</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FontTableImpl extends LilyEObject implements FontTable
{
	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected FileResource file;

	/**
	 * The cached value of the '{@link #getCharTables() <em>Char Tables</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharTables()
	 * @generated
	 * @ordered
	 */
	protected EList<ECharTable> charTables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FontTableImpl()
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
		return UiPackage.Literals.FONT_TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FileResource getFile()
	{
		if (file != null && ((EObject)file).eIsProxy())
		{
			InternalEObject oldFile = file;
			file = (FileResource)eResolveProxy(oldFile);
			if (file != oldFile)
			{
				InternalEObject newFile = file;
				NotificationChain msgs = oldFile.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.FONT_TABLE__FILE, null, null);
				if (newFile.eInternalContainer() == null)
				{
					msgs = newFile.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.FONT_TABLE__FILE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiPackage.FONT_TABLE__FILE, oldFile, file));
			}
		}
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileResource basicGetFile()
	{
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFile(FileResource newFile, NotificationChain msgs)
	{
		FileResource oldFile = file;
		file = newFile;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.FONT_TABLE__FILE, oldFile, newFile);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFile(FileResource newFile)
	{
		if (newFile != file)
		{
			NotificationChain msgs = null;
			if (file != null)
				msgs = ((InternalEObject)file).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.FONT_TABLE__FILE, null, msgs);
			if (newFile != null)
				msgs = ((InternalEObject)newFile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.FONT_TABLE__FILE, null, msgs);
			msgs = basicSetFile(newFile, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.FONT_TABLE__FILE, newFile, newFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ECharTable> getCharTables()
	{
		if (charTables == null)
		{
			charTables = new EDataTypeUniqueEList<ECharTable>(ECharTable.class, this, UiPackage.FONT_TABLE__CHAR_TABLES);
		}
		return charTables;
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
			case UiPackage.FONT_TABLE__FILE:
				return basicSetFile(null, msgs);
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
			case UiPackage.FONT_TABLE__FILE:
				if (resolve) return getFile();
				return basicGetFile();
			case UiPackage.FONT_TABLE__CHAR_TABLES:
				return getCharTables();
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
			case UiPackage.FONT_TABLE__FILE:
				setFile((FileResource)newValue);
				return;
			case UiPackage.FONT_TABLE__CHAR_TABLES:
				getCharTables().clear();
				getCharTables().addAll((Collection<? extends ECharTable>)newValue);
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
			case UiPackage.FONT_TABLE__FILE:
				setFile((FileResource)null);
				return;
			case UiPackage.FONT_TABLE__CHAR_TABLES:
				getCharTables().clear();
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
			case UiPackage.FONT_TABLE__FILE:
				return file != null;
			case UiPackage.FONT_TABLE__CHAR_TABLES:
				return charTables != null && !charTables.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (charTables: ");
		result.append(charTables);
		result.append(')');
		return result.toString();
	}

} //FontTableImpl
