/**
 */
package org.sheepy.lily.core.model.cadence;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Print UPS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.cadence.PrintUPS#getPrintEveryMs <em>Print Every Ms</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getPrintUPS()
 * @model
 * @generated
 */
public interface PrintUPS extends ICadenceTask
{

	/**
	 * Returns the value of the '<em><b>Print Every Ms</b></em>' attribute.
	 * The default value is <code>"2000"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Print Every Ms</em>' attribute.
	 * @see #setPrintEveryMs(int)
	 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getPrintUPS_PrintEveryMs()
	 * @model default="2000" required="true"
	 * @generated
	 */
	int getPrintEveryMs();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.cadence.PrintUPS#getPrintEveryMs <em>Print Every Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Print Every Ms</em>' attribute.
	 * @see #getPrintEveryMs()
	 * @generated
	 */
	void setPrintEveryMs(int value);
} // PrintUPS
