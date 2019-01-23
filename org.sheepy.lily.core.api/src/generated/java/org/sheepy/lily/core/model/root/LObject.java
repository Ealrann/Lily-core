/**
 */
package org.sheepy.lily.core.model.root;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.util.LTreeIterator;
import org.sheepy.lily.core.model.inference.IInferenceObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LObject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.root.LObject#getContentObjects <em>Content Objects</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.root.RootPackage#getLObject()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface LObject extends IInferenceObject
{
	/**
	 * Returns the value of the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Objects</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Objects</em>' attribute.
	 * @see #setContentObjects(EList)
	 * @see org.sheepy.lily.core.model.root.RootPackage#getLObject_ContentObjects()
	 * @model unique="false" dataType="org.sheepy.lily.core.model.root.LContentList" transient="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel property='None'"
	 * @generated
	 */
	EList<LObject> getContentObjects();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.root.LObject#getContentObjects <em>Content Objects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Objects</em>' attribute.
	 * @see #getContentObjects()
	 * @generated
	 */
	void setContentObjects(EList<LObject> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" targetEClassUnique="false"
	 * @generated
	 */
	<T extends LObject> EList<T> createContainmentEList(EClass targetEClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	EList<LObject> lContents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	LObject lParent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.sheepy.lily.core.model.root.LTreeIterator" unique="false"
	 * @generated
	 */
	LTreeIterator lAllContents();

} // LObject
