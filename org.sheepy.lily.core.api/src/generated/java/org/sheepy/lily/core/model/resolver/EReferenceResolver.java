/**
 */
package org.sheepy.common.model.resolver;

import java.util.Collection;

import org.eclipse.emf.ecore.EReference;

import org.sheepy.common.model.root.LObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EReference Resolver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.common.model.resolver.EReferenceResolver#getReferenceName <em>Reference Name</em>}</li>
 *   <li>{@link org.sheepy.common.model.resolver.EReferenceResolver#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.sheepy.common.model.resolver.EReferenceResolver#getInternalReference <em>Internal Reference</em>}</li>
 * </ul>
 *
 * @see org.sheepy.common.model.resolver.ResolverPackage#getEReferenceResolver()
 * @model
 * @generated
 */
public interface EReferenceResolver extends ILObjectResolver
{
	/**
	 * Returns the value of the '<em><b>Reference Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Name</em>' attribute.
	 * @see #setReferenceName(String)
	 * @see org.sheepy.common.model.resolver.ResolverPackage#getEReferenceResolver_ReferenceName()
	 * @model unique="false"
	 * @generated
	 */
	String getReferenceName();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.resolver.EReferenceResolver#getReferenceName <em>Reference Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Name</em>' attribute.
	 * @see #getReferenceName()
	 * @generated
	 */
	void setReferenceName(String value);

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.sheepy.common.model.resolver.ResolverPackage#getEReferenceResolver_ClassName()
	 * @model unique="false"
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.resolver.EReferenceResolver#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Internal Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Reference</em>' reference.
	 * @see #setInternalReference(EReference)
	 * @see org.sheepy.common.model.resolver.ResolverPackage#getEReferenceResolver_InternalReference()
	 * @model transient="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel property='None'"
	 * @generated
	 */
	EReference getInternalReference();

	/**
	 * Sets the value of the '{@link org.sheepy.common.model.resolver.EReferenceResolver#getInternalReference <em>Internal Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Reference</em>' reference.
	 * @see #getInternalReference()
	 * @generated
	 */
	void setInternalReference(EReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sourceUnique="false" collectedDataType="org.sheepy.common.model.root.LCollection" collectedUnique="false"
	 * @generated
	 */
	@Override
	void collectUnits(LObject source, Collection<LObject> collected);

} // EReferenceResolver
