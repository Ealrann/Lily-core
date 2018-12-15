import org.sheepy.common.api.action.IActionDispatcher;
import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.common.api.cadence.ICadencer;
import org.sheepy.common.api.cadence.IStatistics;
import org.sheepy.common.api.input.IInputManager;
import org.sheepy.common.api.resource.CoreModelExtension;
import org.sheepy.common.api.resource.IModelExtension;
import org.sheepy.common.api.resource.IResourceManager;

module org.sheepy.common.api
{
	requires transitive org.eclipse.emf.common;
	requires transitive org.eclipse.emf.ecore;

	exports org.sheepy.common.api.action;
	exports org.sheepy.common.api.action.context;
	exports org.sheepy.common.api.adapter;
	exports org.sheepy.common.api.adapter.impl;
	exports org.sheepy.common.api.application;
	exports org.sheepy.common.api.cadence;
	exports org.sheepy.common.api.inference;
	exports org.sheepy.common.api.input;
	exports org.sheepy.common.api.resource;
	exports org.sheepy.common.api.service;
	exports org.sheepy.common.api.types;
	exports org.sheepy.common.api.util;
	exports org.sheepy.common.api.variable;

	exports org.sheepy.common.model.action;
	exports org.sheepy.common.model.action.impl;
	exports org.sheepy.common.model.application;
	exports org.sheepy.common.model.application.impl;
	exports org.sheepy.common.model.inference;
	exports org.sheepy.common.model.inference.impl;
	exports org.sheepy.common.model.presentation;
	exports org.sheepy.common.model.presentation.impl;
	exports org.sheepy.common.model.resolver;
	exports org.sheepy.common.model.resolver.impl;
	exports org.sheepy.common.model.root;
	exports org.sheepy.common.model.root.impl;
	exports org.sheepy.common.model.types;
	exports org.sheepy.common.model.types.impl;
	exports org.sheepy.common.model.ui;
	exports org.sheepy.common.model.ui.impl;
	exports org.sheepy.common.model.variable;
	exports org.sheepy.common.model.variable.impl;

	provides IModelExtension with CoreModelExtension;

	uses IActionDispatcher;
	uses ICadencer;
	uses IInputManager;
	uses IModelExtension;
	uses IResourceManager;
	uses ISingletonAdapter;
	uses IStatistics;
}
