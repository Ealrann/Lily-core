/**
 */
package org.sheepy.lily.core.model.maintainer;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Maintainer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.maintainer.Maintainer#getMaintained <em>Maintained</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.maintainer.MaintainerPackage#getMaintainer()
 * @model interface="true" abstract="true"
 * @extends ILilyEObject
 * @generated
 */
public interface Maintainer<T extends Maintainable<T>> extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Maintained</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.maintainer.Maintainable}<code>&lt;T&gt;</code>.
	 * It is bidirectional and its opposite is '{@link org.sheepy.lily.core.model.maintainer.Maintainable#getMaintainer <em>Maintainer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maintained</em>' reference list.
	 * @see org.sheepy.lily.core.model.maintainer.MaintainerPackage#getMaintainer_Maintained()
	 * @see org.sheepy.lily.core.model.maintainer.Maintainable#getMaintainer
	 * @model opposite="maintainer"
	 * @generated
	 */
	EList<Maintainable<T>> getMaintained();

} // Maintainer
