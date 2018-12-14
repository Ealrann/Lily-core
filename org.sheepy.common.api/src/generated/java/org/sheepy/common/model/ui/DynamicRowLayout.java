/**
 */
package org.sheepy.common.model.ui;

import org.sheepy.common.model.presentation.Control;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Row Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.ui.DynamicRowLayout#getColumnCount <em>Column Count</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.ui.UiPackage#getDynamicRowLayout()
 * @model
 * @generated
 */
public interface DynamicRowLayout extends Control
{
	/**
	 * Returns the value of the '<em><b>Column Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Count</em>' attribute.
	 * @see #setColumnCount(int)
	 * @see org.sheepy.common.model.ui.UiPackage#getDynamicRowLayout_ColumnCount()
	 * @model unique="false"
	 * @generated
	 */
	int getColumnCount();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.ui.DynamicRowLayout#getColumnCount <em>Column Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column Count</em>' attribute.
	 * @see #getColumnCount()
	 * @generated
	 */
	void setColumnCount(int value);

} // DynamicRowLayout
