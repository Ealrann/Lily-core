/**
 */
package org.sheepy.common.model.root;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.sheepy.common.model.inference.InferencePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.common.model.root.RootFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.common.model/src/generated/java' editDirectory='/org.sheepy.common.model.edit/src/generated/java' publicConstructors='true' extensibleProviderFactory='true' childCreationExtenders='true' basePackage='org.sheepy.common.model'"
 * @generated
 */
public interface RootPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "root";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.common.model.root";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "root";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RootPackage eINSTANCE = org.sheepy.common.model.root.impl.RootPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.root.impl.LObjectImpl <em>LObject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.root.impl.LObjectImpl
	 * @see org.sheepy.common.model.root.impl.RootPackageImpl#getLObject()
	 * @generated
	 */
	int LOBJECT = 0;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOBJECT__CONTENT_OBJECTS = InferencePackage.IINFERENCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>LObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOBJECT_FEATURE_COUNT = InferencePackage.IINFERENCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOBJECT___LINFERENCE_OBJECT = InferencePackage.IINFERENCE_OBJECT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOBJECT___CREATE_CONTAINMENT_ELIST__ECLASS = InferencePackage.IINFERENCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOBJECT___LCONTENTS = InferencePackage.IINFERENCE_OBJECT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOBJECT___LPARENT = InferencePackage.IINFERENCE_OBJECT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>LAll Units</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOBJECT___LALL_UNITS = InferencePackage.IINFERENCE_OBJECT_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>LObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOBJECT_OPERATION_COUNT = InferencePackage.IINFERENCE_OBJECT_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.root.LNamedElement <em>LNamed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.root.LNamedElement
	 * @see org.sheepy.common.model.root.impl.RootPackageImpl#getLNamedElement()
	 * @generated
	 */
	int LNAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LNAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>LNamed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LNAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>LNamed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LNAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>LContent List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.EList
	 * @see org.sheepy.common.model.root.impl.RootPackageImpl#getLContentList()
	 * @generated
	 */
	int LCONTENT_LIST = 2;

	/**
	 * The meta object id for the '<em>LTree Iterator</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.TreeIterator
	 * @see org.sheepy.common.model.root.impl.RootPackageImpl#getLTreeIterator()
	 * @generated
	 */
	int LTREE_ITERATOR = 3;

	/**
	 * The meta object id for the '<em>LCollection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see org.sheepy.common.model.root.impl.RootPackageImpl#getLCollection()
	 * @generated
	 */
	int LCOLLECTION = 4;


	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.root.LObject <em>LObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LObject</em>'.
	 * @see org.sheepy.common.model.root.LObject
	 * @generated
	 */
	EClass getLObject();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.root.LObject#getContentObjects <em>Content Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Objects</em>'.
	 * @see org.sheepy.common.model.root.LObject#getContentObjects()
	 * @see #getLObject()
	 * @generated
	 */
	EAttribute getLObject_ContentObjects();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.root.LObject#createContainmentEList(org.eclipse.emf.ecore.EClass) <em>Create Containment EList</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Containment EList</em>' operation.
	 * @see org.sheepy.common.model.root.LObject#createContainmentEList(org.eclipse.emf.ecore.EClass)
	 * @generated
	 */
	EOperation getLObject__CreateContainmentEList__EClass();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.root.LObject#lContents() <em>LContents</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>LContents</em>' operation.
	 * @see org.sheepy.common.model.root.LObject#lContents()
	 * @generated
	 */
	EOperation getLObject__LContents();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.root.LObject#lParent() <em>LParent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>LParent</em>' operation.
	 * @see org.sheepy.common.model.root.LObject#lParent()
	 * @generated
	 */
	EOperation getLObject__LParent();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.root.LObject#lAllUnits() <em>LAll Units</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>LAll Units</em>' operation.
	 * @see org.sheepy.common.model.root.LObject#lAllUnits()
	 * @generated
	 */
	EOperation getLObject__LAllUnits();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.root.LNamedElement <em>LNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LNamed Element</em>'.
	 * @see org.sheepy.common.model.root.LNamedElement
	 * @generated
	 */
	EClass getLNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.root.LNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sheepy.common.model.root.LNamedElement#getName()
	 * @see #getLNamedElement()
	 * @generated
	 */
	EAttribute getLNamedElement_Name();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.EList <em>LContent List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>LContent List</em>'.
	 * @see org.eclipse.emf.common.util.EList
	 * @model instanceClass="org.eclipse.emf.common.util.EList&lt;org.sheepy.common.model.root.LObject&gt;"
	 * @generated
	 */
	EDataType getLContentList();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.TreeIterator <em>LTree Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>LTree Iterator</em>'.
	 * @see org.eclipse.emf.common.util.TreeIterator
	 * @model instanceClass="org.eclipse.emf.common.util.TreeIterator&lt;org.sheepy.common.model.root.LObject&gt;"
	 * @generated
	 */
	EDataType getLTreeIterator();

	/**
	 * Returns the meta object for data type '{@link java.util.Collection <em>LCollection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>LCollection</em>'.
	 * @see java.util.Collection
	 * @model instanceClass="java.util.Collection&lt;org.sheepy.common.model.root.LObject&gt;"
	 * @generated
	 */
	EDataType getLCollection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RootFactory getRootFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.root.impl.LObjectImpl <em>LObject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.root.impl.LObjectImpl
		 * @see org.sheepy.common.model.root.impl.RootPackageImpl#getLObject()
		 * @generated
		 */
		EClass LOBJECT = eINSTANCE.getLObject();

		/**
		 * The meta object literal for the '<em><b>Content Objects</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOBJECT__CONTENT_OBJECTS = eINSTANCE.getLObject_ContentObjects();

		/**
		 * The meta object literal for the '<em><b>Create Containment EList</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOBJECT___CREATE_CONTAINMENT_ELIST__ECLASS = eINSTANCE.getLObject__CreateContainmentEList__EClass();

		/**
		 * The meta object literal for the '<em><b>LContents</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOBJECT___LCONTENTS = eINSTANCE.getLObject__LContents();

		/**
		 * The meta object literal for the '<em><b>LParent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOBJECT___LPARENT = eINSTANCE.getLObject__LParent();

		/**
		 * The meta object literal for the '<em><b>LAll Units</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOBJECT___LALL_UNITS = eINSTANCE.getLObject__LAllUnits();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.root.LNamedElement <em>LNamed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.root.LNamedElement
		 * @see org.sheepy.common.model.root.impl.RootPackageImpl#getLNamedElement()
		 * @generated
		 */
		EClass LNAMED_ELEMENT = eINSTANCE.getLNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LNAMED_ELEMENT__NAME = eINSTANCE.getLNamedElement_Name();

		/**
		 * The meta object literal for the '<em>LContent List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.EList
		 * @see org.sheepy.common.model.root.impl.RootPackageImpl#getLContentList()
		 * @generated
		 */
		EDataType LCONTENT_LIST = eINSTANCE.getLContentList();

		/**
		 * The meta object literal for the '<em>LTree Iterator</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.TreeIterator
		 * @see org.sheepy.common.model.root.impl.RootPackageImpl#getLTreeIterator()
		 * @generated
		 */
		EDataType LTREE_ITERATOR = eINSTANCE.getLTreeIterator();

		/**
		 * The meta object literal for the '<em>LCollection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Collection
		 * @see org.sheepy.common.model.root.impl.RootPackageImpl#getLCollection()
		 * @generated
		 */
		EDataType LCOLLECTION = eINSTANCE.getLCollection();

	}

} //RootPackage
