/**
 */
package org.sheepy.lily.core.model.ui;

import org.sheepy.lily.core.model.variable.IVariableResolver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.ui.Slider#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.Slider#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.Slider#getStep <em>Step</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.ui.Slider#getVariableResolver <em>Variable Resolver</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.ui.UiPackage#getSlider()
 * @model
 * @generated
 */
public interface Slider extends TextWidget
{
	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see #setMinValue(int)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getSlider_MinValue()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getMinValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Slider#getMinValue <em>Min Value</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #setMaxValue(int)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getSlider_MaxValue()
	 * @model default="10" unique="false"
	 * @generated
	 */
	int getMaxValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Slider#getMaxValue <em>Max Value</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' attribute.
	 * @see #setStep(int)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getSlider_Step()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getStep();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Slider#getStep <em>Step</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #setVariableResolver(IVariableResolver)
	 * @see org.sheepy.lily.core.model.ui.UiPackage#getSlider_VariableResolver()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IVariableResolver getVariableResolver();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.ui.Slider#getVariableResolver <em>Variable Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #getVariableResolver()
	 * @generated
	 */
	void setVariableResolver(IVariableResolver value);

} // Slider
