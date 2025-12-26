import org.sheepy.lily.core.api.resource.CoreModelExtension;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.core.api.resource.IResourceService;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.cadence.IStatistics;

module org.sheepy.lily.core.api {
	requires transitive logoce.lmf.core.api;
	requires transitive org.joml;

	exports org.sheepy.lily.core.api;
	exports org.sheepy.lily.core.api.action;
	exports org.sheepy.lily.core.api.adapter;
	exports org.sheepy.lily.core.api.allocation;
	exports org.sheepy.lily.core.api.allocation.annotation;
	exports org.sheepy.lily.core.api.application;
	exports org.sheepy.lily.core.api.cadence;
	exports org.sheepy.lily.core.api.engine;
	exports org.sheepy.lily.core.api.inference;
	exports org.sheepy.lily.core.api.input;
	exports org.sheepy.lily.core.api.input.event;
	exports org.sheepy.lily.core.api.maintainer;
	exports org.sheepy.lily.core.api.resource;
	exports org.sheepy.lily.core.api.variable;
	exports org.sheepy.lily.core.api.util;

	// Generated LMF model API (formerly exported by the EMF "model" bundle)
	exports org.sheepy.lily.core.model.action;
	exports org.sheepy.lily.core.model.application;
	exports org.sheepy.lily.core.model.cadence;
	exports org.sheepy.lily.core.model.inference;
	exports org.sheepy.lily.core.model.maintainer;
	exports org.sheepy.lily.core.model.presentation;
	exports org.sheepy.lily.core.model.resource;
	exports org.sheepy.lily.core.model.types;
	exports org.sheepy.lily.core.model.ui;
	exports org.sheepy.lily.core.model.variable;

	provides IModelExtension with CoreModelExtension;

	uses IModelExtension;
	uses IResourceService;
	uses IAllocationService;
	uses IStatistics;
}
