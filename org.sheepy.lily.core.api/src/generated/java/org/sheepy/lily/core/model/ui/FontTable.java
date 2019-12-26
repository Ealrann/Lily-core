/**
 */
package org.sheepy.lily.core.model.ui;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.core.model.application.IResource;

import org.sheepy.lily.core.model.types.ECharTable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.FontTable#getFile <em>File</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.FontTable#getCharTables <em>Char Tables</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getFontTable()
 * @model
 * @generated
 */
public interface FontTable extends IResource
{
	/**
	 * Returns the value of the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' containment reference.
	 * @see #setFile(FileResource)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getFontTable_File()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	FileResource getFile();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.FontTable#getFile <em>File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' containment reference.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(FileResource value);

	/**
	 * Returns the value of the '<em><b>Char Tables</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.types.ECharTable}.
	 * The literals are from the enumeration {@link org.sheepy.lily.core.model.types.ECharTable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Char Tables</em>' attribute list.
	 * @see org.sheepy.lily.core.model.types.ECharTable
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getFontTable_CharTables()
	 * @model required="true"
	 * @generated
	 */
	EList<ECharTable> getCharTables();

} // FontTable
