package org.sheepy.lily.core.action;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.action.IActionAdapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.action.CloseApplicationAction;

@ModelExtender(scope = CloseApplicationAction.class)
@Adapter
public class CloseApplicationActionAdapter implements IActionAdapter<CloseApplicationAction>
{

	@Override
	public void execute(final CloseApplicationAction action)
	{
		final var application = ModelUtil.getApplication(action);
		application.run(false);
	}
}
