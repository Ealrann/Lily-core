/**
 */
package org.sheepy.lily.core.model.cadence;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Count Until</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.cadence.CountUntil#getTotalCount <em>Total Count</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.cadence.CountUntil#getCurrentCount <em>Current Count</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getCountUntil()
 * @model
 * @generated
 */
public interface CountUntil extends ICadenceCondition
{
	/**
	 * Returns the value of the '<em><b>Total Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Count</em>' attribute.
	 * @see #setTotalCount(int)
	 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getCountUntil_TotalCount()
	 * @model default="1" required="true"
	 * @generated
	 */
	int getTotalCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.cadence.CountUntil#getTotalCount <em>Total Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Count</em>' attribute.
	 * @see #getTotalCount()
	 * @generated
	 */
	void setTotalCount(int value);

	/**
	 * Returns the value of the '<em><b>Current Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Count</em>' attribute.
	 * @see #setCurrentCount(int)
	 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getCountUntil_CurrentCount()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getCurrentCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.cadence.CountUntil#getCurrentCount <em>Current Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Count</em>' attribute.
	 * @see #getCurrentCount()
	 * @generated
	 */
	void setCurrentCount(int value);

} // CountUntil
