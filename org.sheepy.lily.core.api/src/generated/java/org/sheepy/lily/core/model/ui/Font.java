/**
 */
package org.sheepy.lily.core.model.ui;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.application.IResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.Font#getTables <em>Tables</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.Font#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getFont()
 * @model
 * @generated
 */
public interface Font extends IResource
{
	/**
	 * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.ui.FontTable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables</em>' containment reference list.
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getFont_Tables()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	EList<FontTable> getTables();

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * The default value is <code>"18.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(float)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getFont_Height()
	 * @model default="18.0" required="true"
	 * @generated
	 */
	float getHeight();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Font#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(float value);

} // Font
