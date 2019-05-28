/**
 */
package org.sheepy.lily.core.model.builder;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buildable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.builder.Buildable#getBuilder <em>Builder</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.builder.BuilderPackage#getBuildable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Buildable<T extends Buildable<T>> extends EObject
{
	/**
	 * Returns the value of the '<em><b>Builder</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Builder</em>' containment reference.
	 * @see #setBuilder(Builder)
	 * @see org.sheepy.lily.core.model.builder.BuilderPackage#getBuildable_Builder()
	 * @model containment="true"
	 * @generated
	 */
	Builder<T> getBuilder();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.builder.Buildable#getBuilder <em>Builder</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Builder</em>' containment reference.
	 * @see #getBuilder()
	 * @generated
	 */
	void setBuilder(Builder<T> value);

} // Buildable
