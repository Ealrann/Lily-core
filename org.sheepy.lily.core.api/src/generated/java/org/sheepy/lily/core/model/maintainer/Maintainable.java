/**
 */
package org.sheepy.lily.core.model.maintainer;

import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Maintainable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.maintainer.Maintainable#getMaintainer <em>Maintainer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.maintainer.MaintainerPackage#getMaintainable()
 * @model interface="true" abstract="true"
 * @extends ILilyEObject
 * @generated
 */
public interface Maintainable<T extends Maintainable<T>> extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Maintainer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sheepy.lily.core.model.maintainer.Maintainer#getMaintained <em>Maintained</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maintainer</em>' reference.
	 * @see #setMaintainer(Maintainer)
	 * @see org.sheepy.lily.core.model.maintainer.MaintainerPackage#getMaintainable_Maintainer()
	 * @see org.sheepy.lily.core.model.maintainer.Maintainer#getMaintained
	 * @model opposite="maintained"
	 * @generated
	 */
	Maintainer<T> getMaintainer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.maintainer.Maintainable#getMaintainer <em>Maintainer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maintainer</em>' reference.
	 * @see #getMaintainer()
	 * @generated
	 */
	void setMaintainer(Maintainer<T> value);

} // Maintainable
