import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.application.IApplicationAdapter;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.resource.CoreModelExtension;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.core.api.resource.IResourceService;

module org.sheepy.lily.core.api {
	requires transitive logoce.adapter;
	requires transitive logoce.extender;
	requires transitive logoce.notification;

	requires transitive org.eclipse.emf.common;
	requires transitive org.eclipse.emf.ecore;
	requires transitive org.eclipse.emf.ecore.xmi;

	requires transitive org.joml;

	exports org.sheepy.lily.core.api;
	exports org.sheepy.lily.core.api.action;
	exports org.sheepy.lily.core.api.allocation;
	exports org.sheepy.lily.core.api.allocation.annotation;
	exports org.sheepy.lily.core.api.model;
	exports org.sheepy.lily.core.api.application;
	exports org.sheepy.lily.core.api.adapter;
	exports org.sheepy.lily.core.api.cadence;
	exports org.sheepy.lily.core.api.engine;
	exports org.sheepy.lily.core.api.inference;
	exports org.sheepy.lily.core.api.input;
	exports org.sheepy.lily.core.api.input.event;
	exports org.sheepy.lily.core.api.maintainer;
	exports org.sheepy.lily.core.api.notification;
	exports org.sheepy.lily.core.api.notification.impl;
	exports org.sheepy.lily.core.api.notification.observatory;
	exports org.sheepy.lily.core.api.notification.util;
	exports org.sheepy.lily.core.api.resource;
	exports org.sheepy.lily.core.api.util;
	exports org.sheepy.lily.core.api.variable;

	exports org.sheepy.lily.core.model.action;
	exports org.sheepy.lily.core.model.action.impl;
	exports org.sheepy.lily.core.model.application;
	exports org.sheepy.lily.core.model.application.impl;
	exports org.sheepy.lily.core.model.cadence;
	exports org.sheepy.lily.core.model.cadence.impl;
	exports org.sheepy.lily.core.model.inference;
	exports org.sheepy.lily.core.model.inference.impl;
	exports org.sheepy.lily.core.model.maintainer;
	exports org.sheepy.lily.core.model.maintainer.impl;
	exports org.sheepy.lily.core.model.presentation;
	exports org.sheepy.lily.core.model.presentation.impl;
	exports org.sheepy.lily.core.model.resource;
	exports org.sheepy.lily.core.model.resource.impl;
	exports org.sheepy.lily.core.model.resource.util;
	exports org.sheepy.lily.core.model.types;
	exports org.sheepy.lily.core.model.types.impl;
	exports org.sheepy.lily.core.model.ui;
	exports org.sheepy.lily.core.model.ui.impl;
	exports org.sheepy.lily.core.model.variable;
	exports org.sheepy.lily.core.model.variable.impl;

	provides IModelExtension with CoreModelExtension;

	uses IApplicationAdapter;
	uses IModelExtension;
	uses IResourceService;
	uses IStatistics;
	uses IAllocationService;
}
