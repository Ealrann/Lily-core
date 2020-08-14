/**
 */
package org.sheepy.lily.core.model.application;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.IRootResource;
import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.core.model.variable.IModelVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Special Effect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.core.model.application.SpecialEffect#getShader <em>Shader</em>}</li>
 *   <li>{@link org.sheepy.lily.core.model.application.SpecialEffect#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getSpecialEffect()
 * @model
 * @generated
 */
public interface SpecialEffect extends LNamedElement, IRootResource
{
	/**
	 * Returns the value of the '<em><b>Shader</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shader</em>' containment reference.
	 * @see #setShader(FileResource)
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getSpecialEffect_Shader()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	FileResource getShader();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.core.model.application.SpecialEffect#getShader <em>Shader</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shader</em>' containment reference.
	 * @see #getShader()
	 * @generated
	 */
	void setShader(FileResource value);

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.variable.IModelVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.sheepy.lily.core.model.application.ApplicationPackage#getSpecialEffect_Inputs()
	 * @model
	 * @generated
	 */
	EList<IModelVariable> getInputs();

} // SpecialEffect
