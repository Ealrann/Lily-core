/**
 */
package org.sheepy.common.model.root;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.common.model.inference.IInferenceObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LObject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.root.LObject#getContentObjects <em>Content Objects</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.root.RootPackage#getLObject()
 * @model abstract="true"
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
	 * @see org.sheepy.common.model.root.RootPackage#getLObject_ContentObjects()
	 * @model unique="false" dataType="org.sheepy.common.model.root.LContentList" transient="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel property='None'"
	 * @generated
	 */
	EList<LObject> getContentObjects();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.root.LObject#getContentObjects <em>Content Objects</em>}' attribute.
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
	 * @model dataType="org.sheepy.common.model.root.LTreeIterator" unique="false"
	 * @generated
	 */
	TreeIterator<LObject> lAllUnits();

} // LObject
