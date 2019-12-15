package org.sheepy.lily.core.application;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.application.IApplicationAdapter;
import org.sheepy.lily.core.api.cadence.ICadencer;
import org.sheepy.lily.core.api.view.IViewAdapter;
import org.sheepy.lily.core.cadence.common.Cadencer;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.application.IView;

@Statefull
@Adapter(scope = Application.class, scopeInheritance = true)
public class ApplicationAdapter implements IApplicationAdapter
{
	private Cadencer cadencer = null;
	private boolean launched = false;

	private final Application application;

	private ApplicationAdapter(Application application)
	{
		this.application = application;
	}

	@NotifyChanged(featureIds = ApplicationPackage.APPLICATION__RUN)
	private void notifyChanged(Notification notification)
	{
		if (launched == true && notification.getNewBooleanValue() == false)
		{
			stop((Application) notification.getNotifier());
		}
	}

	@Override
	public void launch(Application application)
	{
		reloadEngines();
		cadencer = new Cadencer(application);

		cadencer.load();
		launched = true;

		cadencer.run();
	}

	private void reloadEngines()
	{
		application.getEngines().clear();

		final var view = application.getView();
		application.getEngines().add(buildEngine(view));
	}

	private static <T extends IView> IEngine buildEngine(T view)
	{
		final var viewAdapter = view.<IViewAdapter<T>> adaptNotNullGeneric(IViewAdapter.class);
		final var engine = viewAdapter.buildEngine(view);
		return engine;
	}

	@Override
	public void stop(Application application)
	{
		if (launched == true)
		{
			cadencer.stop();
			cadencer = null;
			launched = false;
		}
	}

	@Override
	public ICadencer getCadencer()
	{
		return cadencer;
	}
}
