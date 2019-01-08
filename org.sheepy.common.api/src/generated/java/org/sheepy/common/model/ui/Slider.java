/**
 */
package org.sheepy.common.model.ui;

import org.sheepy.common.model.presentation.Widget;
import org.sheepy.common.model.variable.IVariableResolver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.ui.Slider#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.Slider#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.Slider#getStep <em>Step</em>}</li>
 *   <li>{@link org.sheepy.common.model.ui.Slider#getVariableResolver <em>Variable Resolver</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.ui.UiPackage#getSlider()
 * @model
 * @generated
 */
public interface Slider extends Widget
{
	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see #setMinValue(int)
	 * @see org.sheepy.common.model.ui.UiPackage#getSlider_MinValue()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getMinValue();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.ui.Slider#getMinValue <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Value</em>' attribute.
	 * @see #getMinValue()
	 * @generated
	 */
	void setMinValue(int value);

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #setMaxValue(int)
	 * @see org.sheepy.common.model.ui.UiPackage#getSlider_MaxValue()
	 * @model default="10" unique="false"
	 * @generated
	 */
	int getMaxValue();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.ui.Slider#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(int value);

	/**
	 * Returns the value of the '<em><b>Step</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' attribute.
	 * @see #setStep(int)
	 * @see org.sheepy.common.model.ui.UiPackage#getSlider_Step()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getStep();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.ui.Slider#getStep <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step</em>' attribute.
	 * @see #getStep()
	 * @generated
	 */
	void setStep(int value);

	/**
	 * Returns the value of the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Resolver</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #setVariableResolver(IVariableResolver)
	 * @see org.sheepy.common.model.ui.UiPackage#getSlider_VariableResolver()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IVariableResolver getVariableResolver();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.ui.Slider#getVariableResolver <em>Variable Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #getVariableResolver()
	 * @generated
	 */
	void setVariableResolver(IVariableResolver value);

} // Slider
