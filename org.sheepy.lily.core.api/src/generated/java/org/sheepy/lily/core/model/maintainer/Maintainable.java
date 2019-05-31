/**
 */
package org.sheepy.lily.core.model.maintainer;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Maintainable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.maintainer.Maintainable#getBuilder <em>Builder</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.maintainer.MaintainerPackage#getMaintainable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Maintainable<T extends Maintainable<T>> extends EObject
{
	/**
	 * Returns the value of the '<em><b>Builder</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Builder</em>' containment reference.
	 * @see #setBuilder(Maintainer)
	 * @see org.sheepy.lily.core.model.maintainer.MaintainerPackage#getMaintainable_Builder()
	 * @model containment="true"
	 * @generated
	 */
	Maintainer<T> getBuilder();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.maintainer.Maintainable#getBuilder <em>Builder</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Builder</em>' containment reference.
	 * @see #getBuilder()
	 * @generated
	 */
	void setBuilder(Maintainer<T> value);

} // Maintainable
