/**
 */
package org.sheepy.lily.core.model.ui;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Row Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.DynamicRowLayout#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.DynamicRowLayout#getColumnCount <em>Column Count</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getDynamicRowLayout()
 * @model
 * @generated
 */
public interface DynamicRowLayout extends IControl
{
	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * The default value is <code>"16"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getDynamicRowLayout_Height()
	 * @model default="16" unique="false"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.DynamicRowLayout#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * Returns the value of the '<em><b>Column Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Count</em>' attribute.
	 * @see #setColumnCount(int)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getDynamicRowLayout_ColumnCount()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getColumnCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.DynamicRowLayout#getColumnCount <em>Column Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column Count</em>' attribute.
	 * @see #getColumnCount()
	 * @generated
	 */
	void setColumnCount(int value);

} // DynamicRowLayout
