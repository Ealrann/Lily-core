import org.logoce.lmf.core.api.extender.IAdapterExtension;
import org.logoce.lmf.core.api.extender.IAdapterProvider;
import org.logoce.lmf.core.api.extender.ext.IAdaptableNameMatcher;
import org.sheepy.lily.core.Extenders;
import org.sheepy.lily.core.adapter.AdaptableNameMatcher;
import org.sheepy.lily.core.adapter.LoadDisposeAdapterExtension;
import org.sheepy.lily.core.adapter.NotifyChangeManager;
import org.sheepy.lily.core.adapter.ObservatoryManager;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.resource.IResourceService;
import org.sheepy.lily.core.cadence.CadencerStatistics;
import org.sheepy.lily.core.resource.ResourceService;

module org.sheepy.lily.core.impl {

	requires transitive org.sheepy.lily.core.api;
	requires logoce.lmf.core.loader;

	provides IResourceService with ResourceService;
	provides IStatistics with CadencerStatistics;
	provides IAdapterProvider with Extenders;
	provides IAdapterExtension.Descriptor with ObservatoryManager.Descriptor, LoadDisposeAdapterExtension.Descriptor, NotifyChangeManager.Descriptor;
	provides IAdaptableNameMatcher with AdaptableNameMatcher;

	opens org.sheepy.lily.core.action;
	opens org.sheepy.lily.core.cadence.adapter;
	opens org.sheepy.lily.core.application;
	opens org.sheepy.lily.core.inference;
	opens org.sheepy.lily.core.variable;
	opens org.sheepy.lily.core.variable.action;
}
