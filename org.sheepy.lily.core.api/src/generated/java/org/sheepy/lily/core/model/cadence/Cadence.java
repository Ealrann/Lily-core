/**
 */
package org.sheepy.lily.core.model.cadence;

import org.sheepy.lily.core.model.application.ICadence;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cadence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.cadence.Cadence#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.cadence.Cadence#isPrintUPS <em>Print UPS</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getCadence()
 * @model
 * @generated
 */
public interface Cadence extends CadenceTaskPkg, ICadence
{
	/**
	 * Returns the value of the '<em><b>Frequency</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frequency</em>' attribute.
	 * @see #setFrequency(int)
	 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getCadence_Frequency()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getFrequency();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.cadence.Cadence#getFrequency <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frequency</em>' attribute.
	 * @see #getFrequency()
	 * @generated
	 */
	void setFrequency(int value);

	/**
	 * Returns the value of the '<em><b>Print UPS</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Print UPS</em>' attribute.
	 * @see #setPrintUPS(boolean)
	 * @see org.sheepy.lily.core.model.cadence.CadencePackage#getCadence_PrintUPS()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isPrintUPS();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.cadence.Cadence#isPrintUPS <em>Print UPS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Print UPS</em>' attribute.
	 * @see #isPrintUPS()
	 * @generated
	 */
	void setPrintUPS(boolean value);

} // Cadence
