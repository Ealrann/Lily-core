/**
 */
package org.sheepy.common.model.types;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.common.api.adapter.AdapterIndexer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SObject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.types.SObject#getAdapterIndexer <em>Adapter Indexer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.types.TypesPackage#getSObject()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SObject extends EObject
{
	/**
	 * Returns the value of the '<em><b>Adapter Indexer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapter Indexer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapter Indexer</em>' attribute.
	 * @see #setAdapterIndexer(AdapterIndexer)
	 * @see org.sheepy.common.model.types.TypesPackage#getSObject_AdapterIndexer()
	 * @model unique="false" dataType="org.sheepy.common.model.types.SAdapterIndexer" transient="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel property='None'"
	 * @generated
	 */
	AdapterIndexer getAdapterIndexer();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.types.SObject#getAdapterIndexer <em>Adapter Indexer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapter Indexer</em>' attribute.
	 * @see #getAdapterIndexer()
	 * @generated
	 */
	void setAdapterIndexer(AdapterIndexer value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.sheepy.common.model.types.SAdapterIndexer" unique="false"
	 * @generated
	 */
	AdapterIndexer lAdapterIndexer();

} // SObject
