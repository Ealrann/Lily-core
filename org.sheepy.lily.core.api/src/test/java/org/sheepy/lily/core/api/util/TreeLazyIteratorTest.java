package org.sheepy.lily.core.api.util;

import org.eclipse.emf.ecore.EClass;
import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.core.model.resource.Music;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.core.model.resource.ResourcePackage;

import java.util.ArrayDeque;

public class TreeLazyIteratorTest
{
	@Test
	public void testTreeLazyIterator()
	{
		final var checkDeque = new ArrayDeque<EClass>();
		checkDeque.add(ApplicationPackage.Literals.APPLICATION);
		checkDeque.add(ResourcePackage.Literals.RESOURCE_PKG);
		checkDeque.add(ResourcePackage.Literals.FILE_IMAGE);
		checkDeque.add(ResourcePackage.Literals.MODULE_RESOURCE);
		checkDeque.add(ResourcePackage.Literals.MUSIC);
		checkDeque.add(ResourcePackage.Literals.SOUND);

		final var app = ApplicationFactory.eINSTANCE.createApplication();
		final var resourcePkg = ResourceFactory.eINSTANCE.createResourcePkg();
		final var fileImage = ResourceFactory.eINSTANCE.createFileImage();
		final var music = ResourceFactory.eINSTANCE.createMusic();
		final var resources = resourcePkg.getResources();

		app.setResourcePkg(resourcePkg);
		resources.add(fileImage);
		resources.add(music);

		final var it = new TreeLazyIterator(app);
		it.forEachRemaining(elem -> {
			if (elem instanceof Music) resources.add(ResourceFactory.eINSTANCE.createSound());
			if (elem instanceof FileImage fi) fi.setFile(ResourceFactory.eINSTANCE.createModuleResource());

			System.out.println(elem.eClass().getName());
			assert elem.eClass() == checkDeque.pop();
		});
	}
}
