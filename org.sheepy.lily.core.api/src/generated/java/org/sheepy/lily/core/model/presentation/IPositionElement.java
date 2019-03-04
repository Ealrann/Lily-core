/**
 */
package org.sheepy.lily.core.model.presentation;

import org.joml.Vector2i;
import org.sheepy.lily.core.model.root.LObject;

import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IPosition Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.presentation.IPositionElement#getPosition <em>Position</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.presentation.IPositionElement#getVerticalRelative <em>Vertical Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.presentation.IPositionElement#getHorizontalRelative <em>Horizontal Relative</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getIPositionElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IPositionElement extends LObject
{
	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * The default value is <code>"0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(Vector2i)
	 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getIPositionElement_Position()
	 * @model default="0;0" unique="false" dataType="org.sheepy.lily.core.model.types.Vector2i"
	 * @generated
	 */
	Vector2i getPosition();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.presentation.IPositionElement#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Vector2i value);

	/**
	 * Returns the value of the '<em><b>Vertical Relative</b></em>' attribute.
	 * The default value is <code>"TOP"</code>.
	 * The literals are from the enumeration {@link org.sheepy.lily.core.model.types.EVerticalRelative}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertical Relative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertical Relative</em>' attribute.
	 * @see org.sheepy.lily.core.model.types.EVerticalRelative
	 * @see #setVerticalRelative(EVerticalRelative)
	 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getIPositionElement_VerticalRelative()
	 * @model default="TOP" unique="false"
	 * @generated
	 */
	EVerticalRelative getVerticalRelative();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.presentation.IPositionElement#getVerticalRelative <em>Vertical Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertical Relative</em>' attribute.
	 * @see org.sheepy.lily.core.model.types.EVerticalRelative
	 * @see #getVerticalRelative()
	 * @generated
	 */
	void setVerticalRelative(EVerticalRelative value);

	/**
	 * Returns the value of the '<em><b>Horizontal Relative</b></em>' attribute.
	 * The default value is <code>"LEFT"</code>.
	 * The literals are from the enumeration {@link org.sheepy.lily.core.model.types.EHorizontalRelative}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Horizontal Relative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Horizontal Relative</em>' attribute.
	 * @see org.sheepy.lily.core.model.types.EHorizontalRelative
	 * @see #setHorizontalRelative(EHorizontalRelative)
	 * @see org.sheepy.lily.core.model.presentation.PresentationPackage#getIPositionElement_HorizontalRelative()
	 * @model default="LEFT" unique="false"
	 * @generated
	 */
	EHorizontalRelative getHorizontalRelative();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.presentation.IPositionElement#getHorizontalRelative <em>Horizontal Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Horizontal Relative</em>' attribute.
	 * @see org.sheepy.lily.core.model.types.EHorizontalRelative
	 * @see #getHorizontalRelative()
	 * @generated
	 */
	void setHorizontalRelative(EHorizontalRelative value);

} // IPositionElement
