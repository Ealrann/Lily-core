/**
 */
package org.sheepy.lily.core.model.application.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationExtensionPkg;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.GenericScenePart;
import org.sheepy.lily.core.model.application.IModel;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.core.model.application.ScreenEffect;
import org.sheepy.lily.core.model.application.SpecialEffect;
import org.sheepy.lily.core.model.application.TimeConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ApplicationFactoryImpl extends EFactoryImpl implements ApplicationFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ApplicationFactory init()
	{
		try
		{
			ApplicationFactory theApplicationFactory = (ApplicationFactory)EPackage.Registry.INSTANCE.getEFactory(ApplicationPackage.eNS_URI);
			if (theApplicationFactory != null)
			{
				return theApplicationFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ApplicationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case ApplicationPackage.APPLICATION: return createApplication();
			case ApplicationPackage.APPLICATION_EXTENSION_PKG: return createApplicationExtensionPkg();
			case ApplicationPackage.TIME_CONFIGURATION: return createTimeConfiguration();
			case ApplicationPackage.IMODEL: return createIModel();
			case ApplicationPackage.COMPOSITOR_EXTENSION_PKG: return createCompositorExtensionPkg();
			case ApplicationPackage.SCENE: return createScene();
			case ApplicationPackage.GENERIC_SCENE_PART: return createGenericScenePart();
			case ApplicationPackage.BACKGROUND_IMAGE: return createBackgroundImage();
			case ApplicationPackage.SCREEN_EFFECT: return createScreenEffect();
			case ApplicationPackage.SPECIAL_EFFECT: return createSpecialEffect();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Application createApplication()
	{
		ApplicationImpl application = new ApplicationImpl();
		return application;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApplicationExtensionPkg createApplicationExtensionPkg()
	{
		ApplicationExtensionPkgImpl applicationExtensionPkg = new ApplicationExtensionPkgImpl();
		return applicationExtensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TimeConfiguration createTimeConfiguration()
	{
		TimeConfigurationImpl timeConfiguration = new TimeConfigurationImpl();
		return timeConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IModel createIModel()
	{
		IModelImpl iModel = new IModelImpl();
		return iModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositorExtensionPkg createCompositorExtensionPkg()
	{
		CompositorExtensionPkgImpl compositorExtensionPkg = new CompositorExtensionPkgImpl();
		return compositorExtensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scene createScene()
	{
		SceneImpl scene = new SceneImpl();
		return scene;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenericScenePart createGenericScenePart()
	{
		GenericScenePartImpl genericScenePart = new GenericScenePartImpl();
		return genericScenePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BackgroundImage createBackgroundImage()
	{
		BackgroundImageImpl backgroundImage = new BackgroundImageImpl();
		return backgroundImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScreenEffect createScreenEffect()
	{
		ScreenEffectImpl screenEffect = new ScreenEffectImpl();
		return screenEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpecialEffect createSpecialEffect()
	{
		SpecialEffectImpl specialEffect = new SpecialEffectImpl();
		return specialEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApplicationPackage getApplicationPackage()
	{
		return (ApplicationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ApplicationPackage getPackage()
	{
		return ApplicationPackage.eINSTANCE;
	}

} //ApplicationFactoryImpl
