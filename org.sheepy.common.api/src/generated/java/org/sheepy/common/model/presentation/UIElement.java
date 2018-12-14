/**
 */
package org.sheepy.common.model.presentation;

import org.sheepy.common.model.root.LObject;

import org.sheepy.common.model.types.EHorizontalRelative;
import org.sheepy.common.model.types.EVerticalRelative;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.presentation.UIElement#getVerticalRelative <em>Vertical Relative</em>}</li>
 *   <li>{@link org.sheepy.common.model.presentation.UIElement#getHorizontalRelative <em>Horizontal Relative</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.presentation.PresentationPackage#getUIElement()
 * @model abstract="true"
 * @generated
 */
public interface UIElement extends LObject, IPresentationElement
{
	/**
	 * Returns the value of the '<em><b>Vertical Relative</b></em>' attribute.
	 * The default value is <code>"TOP"</code>.
	 * The literals are from the enumeration {@link org.sheepy.common.model.types.EVerticalRelative}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertical Relative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertical Relative</em>' attribute.
	 * @see org.sheepy.common.model.types.EVerticalRelative
	 * @see #setVerticalRelative(EVerticalRelative)
	 * @see org.sheepy.common.model.presentation.PresentationPackage#getUIElement_VerticalRelative()
	 * @model default="TOP" unique="false"
	 * @generated
	 */
	EVerticalRelative getVerticalRelative();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.presentation.UIElement#getVerticalRelative <em>Vertical Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertical Relative</em>' attribute.
	 * @see org.sheepy.common.model.types.EVerticalRelative
	 * @see #getVerticalRelative()
	 * @generated
	 */
	void setVerticalRelative(EVerticalRelative value);

	/**
	 * Returns the value of the '<em><b>Horizontal Relative</b></em>' attribute.
	 * The default value is <code>"LEFT"</code>.
	 * The literals are from the enumeration {@link org.sheepy.common.model.types.EHorizontalRelative}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Horizontal Relative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Horizontal Relative</em>' attribute.
	 * @see org.sheepy.common.model.types.EHorizontalRelative
	 * @see #setHorizontalRelative(EHorizontalRelative)
	 * @see org.sheepy.common.model.presentation.PresentationPackage#getUIElement_HorizontalRelative()
	 * @model default="LEFT" unique="false"
	 * @generated
	 */
	EHorizontalRelative getHorizontalRelative();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.presentation.UIElement#getHorizontalRelative <em>Horizontal Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Horizontal Relative</em>' attribute.
	 * @see org.sheepy.common.model.types.EHorizontalRelative
	 * @see #getHorizontalRelative()
	 * @generated
	 */
	void setHorizontalRelative(EHorizontalRelative value);

} // UIElement
