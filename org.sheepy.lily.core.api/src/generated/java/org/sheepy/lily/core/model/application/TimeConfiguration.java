/**
 */
package org.sheepy.lily.core.model.application;

import org.sheepy.lily.core.api.model.ILilyEObject;

import org.sheepy.lily.core.model.types.ETimeUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.TimeConfiguration#getTimeStep <em>Time Step</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.TimeConfiguration#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.TimeConfiguration#getTimeFactor <em>Time Factor</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getTimeConfiguration()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface TimeConfiguration extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Time Step</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Step</em>' attribute.
	 * @see #setTimeStep(long)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getTimeConfiguration_TimeStep()
	 * @model default="1" required="true"
	 * @generated
	 */
	long getTimeStep();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.TimeConfiguration#getTimeStep <em>Time Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Step</em>' attribute.
	 * @see #getTimeStep()
	 * @generated
	 */
	void setTimeStep(long value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * The default value is <code>"SECONDS"</code>.
	 * The literals are from the enumeration {@link org.sheepy.lily.core.model.types.ETimeUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see org.sheepy.lily.core.model.types.ETimeUnit
	 * @see #setUnit(ETimeUnit)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getTimeConfiguration_Unit()
	 * @model default="SECONDS" required="true"
	 * @generated
	 */
	ETimeUnit getUnit();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.TimeConfiguration#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see org.sheepy.lily.core.model.types.ETimeUnit
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(ETimeUnit value);

	/**
	 * Returns the value of the '<em><b>Time Factor</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Factor</em>' attribute.
	 * @see #setTimeFactor(double)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getTimeConfiguration_TimeFactor()
	 * @model default="1" unique="false" required="true"
	 * @generated
	 */
	double getTimeFactor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.TimeConfiguration#getTimeFactor <em>Time Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Factor</em>' attribute.
	 * @see #getTimeFactor()
	 * @generated
	 */
	void setTimeFactor(double value);

} // TimeConfiguration
