/**
 */
package org.sheepy.common.model.resolver;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.sheepy.common.model.resolver.ResolverFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.common.model/src/generated/java' editDirectory='/org.sheepy.common.model.edit/src/generated/java' publicConstructors='true' extensibleProviderFactory='true' childCreationExtenders='true' basePackage='org.sheepy.common.model'"
 * @generated
 */
public interface ResolverPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resolver";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.common.model.resolver";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "resolver";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResolverPackage eINSTANCE = org.sheepy.common.model.resolver.impl.ResolverPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.resolver.ILObjectResolver <em>IL Object Resolver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.resolver.ILObjectResolver
	 * @see org.sheepy.common.model.resolver.impl.ResolverPackageImpl#getILObjectResolver()
	 * @generated
	 */
	int IL_OBJECT_RESOLVER = 0;

	/**
	 * The number of structural features of the '<em>IL Object Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_OBJECT_RESOLVER_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Collect Units</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_OBJECT_RESOLVER___COLLECT_UNITS__LOBJECT_COLLECTION = 0;

	/**
	 * The number of operations of the '<em>IL Object Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_OBJECT_RESOLVER_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.resolver.impl.EReferenceResolverImpl <em>EReference Resolver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.resolver.impl.EReferenceResolverImpl
	 * @see org.sheepy.common.model.resolver.impl.ResolverPackageImpl#getEReferenceResolver()
	 * @generated
	 */
	int EREFERENCE_RESOLVER = 1;

	/**
	 * The feature id for the '<em><b>Reference Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_RESOLVER__REFERENCE_NAME = IL_OBJECT_RESOLVER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_RESOLVER__CLASS_NAME = IL_OBJECT_RESOLVER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Internal Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_RESOLVER__INTERNAL_REFERENCE = IL_OBJECT_RESOLVER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EReference Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_RESOLVER_FEATURE_COUNT = IL_OBJECT_RESOLVER_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Collect Units</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_RESOLVER___COLLECT_UNITS__LOBJECT_COLLECTION = IL_OBJECT_RESOLVER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>EReference Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_RESOLVER_OPERATION_COUNT = IL_OBJECT_RESOLVER_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sheepy.common.model.resolver.impl.ChainResolverImpl <em>Chain Resolver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.common.model.resolver.impl.ChainResolverImpl
	 * @see org.sheepy.common.model.resolver.impl.ResolverPackageImpl#getChainResolver()
	 * @generated
	 */
	int CHAIN_RESOLVER = 2;

	/**
	 * The feature id for the '<em><b>Resolvers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAIN_RESOLVER__RESOLVERS = IL_OBJECT_RESOLVER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Chain Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAIN_RESOLVER_FEATURE_COUNT = IL_OBJECT_RESOLVER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Collect Units</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAIN_RESOLVER___COLLECT_UNITS__LOBJECT_COLLECTION = IL_OBJECT_RESOLVER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Chain Resolver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAIN_RESOLVER_OPERATION_COUNT = IL_OBJECT_RESOLVER_OPERATION_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.resolver.ILObjectResolver <em>IL Object Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IL Object Resolver</em>'.
	 * @see org.sheepy.common.model.resolver.ILObjectResolver
	 * @generated
	 */
	EClass getILObjectResolver();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.resolver.ILObjectResolver#collectUnits(org.sheepy.common.model.root.LObject, java.util.Collection) <em>Collect Units</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Collect Units</em>' operation.
	 * @see org.sheepy.common.model.resolver.ILObjectResolver#collectUnits(org.sheepy.common.model.root.LObject, java.util.Collection)
	 * @generated
	 */
	EOperation getILObjectResolver__CollectUnits__LObject_Collection();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.resolver.EReferenceResolver <em>EReference Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EReference Resolver</em>'.
	 * @see org.sheepy.common.model.resolver.EReferenceResolver
	 * @generated
	 */
	EClass getEReferenceResolver();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.resolver.EReferenceResolver#getReferenceName <em>Reference Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Name</em>'.
	 * @see org.sheepy.common.model.resolver.EReferenceResolver#getReferenceName()
	 * @see #getEReferenceResolver()
	 * @generated
	 */
	EAttribute getEReferenceResolver_ReferenceName();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.common.model.resolver.EReferenceResolver#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.sheepy.common.model.resolver.EReferenceResolver#getClassName()
	 * @see #getEReferenceResolver()
	 * @generated
	 */
	EAttribute getEReferenceResolver_ClassName();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.common.model.resolver.EReferenceResolver#getInternalReference <em>Internal Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Internal Reference</em>'.
	 * @see org.sheepy.common.model.resolver.EReferenceResolver#getInternalReference()
	 * @see #getEReferenceResolver()
	 * @generated
	 */
	EReference getEReferenceResolver_InternalReference();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.resolver.EReferenceResolver#collectUnits(org.sheepy.common.model.root.LObject, java.util.Collection) <em>Collect Units</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Collect Units</em>' operation.
	 * @see org.sheepy.common.model.resolver.EReferenceResolver#collectUnits(org.sheepy.common.model.root.LObject, java.util.Collection)
	 * @generated
	 */
	EOperation getEReferenceResolver__CollectUnits__LObject_Collection();

	/**
	 * Returns the meta object for class '{@link org.sheepy.common.model.resolver.ChainResolver <em>Chain Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Chain Resolver</em>'.
	 * @see org.sheepy.common.model.resolver.ChainResolver
	 * @generated
	 */
	EClass getChainResolver();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.common.model.resolver.ChainResolver#getResolvers <em>Resolvers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resolvers</em>'.
	 * @see org.sheepy.common.model.resolver.ChainResolver#getResolvers()
	 * @see #getChainResolver()
	 * @generated
	 */
	EReference getChainResolver_Resolvers();

	/**
	 * Returns the meta object for the '{@link org.sheepy.common.model.resolver.ChainResolver#collectUnits(org.sheepy.common.model.root.LObject, java.util.Collection) <em>Collect Units</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Collect Units</em>' operation.
	 * @see org.sheepy.common.model.resolver.ChainResolver#collectUnits(org.sheepy.common.model.root.LObject, java.util.Collection)
	 * @generated
	 */
	EOperation getChainResolver__CollectUnits__LObject_Collection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResolverFactory getResolverFactory();

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
		 * The meta object literal for the '{@link org.sheepy.common.model.resolver.ILObjectResolver <em>IL Object Resolver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.resolver.ILObjectResolver
		 * @see org.sheepy.common.model.resolver.impl.ResolverPackageImpl#getILObjectResolver()
		 * @generated
		 */
		EClass IL_OBJECT_RESOLVER = eINSTANCE.getILObjectResolver();

		/**
		 * The meta object literal for the '<em><b>Collect Units</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IL_OBJECT_RESOLVER___COLLECT_UNITS__LOBJECT_COLLECTION = eINSTANCE.getILObjectResolver__CollectUnits__LObject_Collection();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.resolver.impl.EReferenceResolverImpl <em>EReference Resolver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.resolver.impl.EReferenceResolverImpl
		 * @see org.sheepy.common.model.resolver.impl.ResolverPackageImpl#getEReferenceResolver()
		 * @generated
		 */
		EClass EREFERENCE_RESOLVER = eINSTANCE.getEReferenceResolver();

		/**
		 * The meta object literal for the '<em><b>Reference Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREFERENCE_RESOLVER__REFERENCE_NAME = eINSTANCE.getEReferenceResolver_ReferenceName();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREFERENCE_RESOLVER__CLASS_NAME = eINSTANCE.getEReferenceResolver_ClassName();

		/**
		 * The meta object literal for the '<em><b>Internal Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREFERENCE_RESOLVER__INTERNAL_REFERENCE = eINSTANCE.getEReferenceResolver_InternalReference();

		/**
		 * The meta object literal for the '<em><b>Collect Units</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EREFERENCE_RESOLVER___COLLECT_UNITS__LOBJECT_COLLECTION = eINSTANCE.getEReferenceResolver__CollectUnits__LObject_Collection();

		/**
		 * The meta object literal for the '{@link org.sheepy.common.model.resolver.impl.ChainResolverImpl <em>Chain Resolver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.common.model.resolver.impl.ChainResolverImpl
		 * @see org.sheepy.common.model.resolver.impl.ResolverPackageImpl#getChainResolver()
		 * @generated
		 */
		EClass CHAIN_RESOLVER = eINSTANCE.getChainResolver();

		/**
		 * The meta object literal for the '<em><b>Resolvers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHAIN_RESOLVER__RESOLVERS = eINSTANCE.getChainResolver_Resolvers();

		/**
		 * The meta object literal for the '<em><b>Collect Units</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CHAIN_RESOLVER___COLLECT_UNITS__LOBJECT_COLLECTION = eINSTANCE.getChainResolver__CollectUnits__LObject_Collection();

	}

} //ResolverPackage
