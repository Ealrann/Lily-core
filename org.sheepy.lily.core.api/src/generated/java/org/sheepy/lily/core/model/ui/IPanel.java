/**
 */
package org.sheepy.lily.core.model.ui;

import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IPanel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.IPanel#isCatchInputs <em>Catch Inputs</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.IPanel#isReportingHover <em>Reporting Hover</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getIPanel()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IPanel extends LNamedElement, IUIElement, IPositionElement
{

	/**
	 * Returns the value of the '<em><b>Catch Inputs</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch Inputs</em>' attribute.
	 * @see #setCatchInputs(boolean)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getIPanel_CatchInputs()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isCatchInputs();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.IPanel#isCatchInputs <em>Catch Inputs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catch Inputs</em>' attribute.
	 * @see #isCatchInputs()
	 * @generated
	 */
	void setCatchInputs(boolean value);

	/**
	 * Returns the value of the '<em><b>Reporting Hover</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reporting Hover</em>' attribute.
	 * @see #setReportingHover(boolean)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getIPanel_ReportingHover()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isReportingHover();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.IPanel#isReportingHover <em>Reporting Hover</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reporting Hover</em>' attribute.
	 * @see #isReportingHover()
	 * @generated
	 */
	void setReportingHover(boolean value);
} // IPanel
