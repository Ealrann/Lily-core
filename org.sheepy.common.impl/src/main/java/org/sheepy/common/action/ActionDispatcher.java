package org.sheepy.common.action;

import org.sheepy.common.api.action.IActionDispatcher;
import org.sheepy.common.api.action.context.ExecutionContext;
import org.sheepy.common.api.cadence.ICadencer;

public class ActionDispatcher implements IActionDispatcher
{
	private final ICadencer cadencer = ICadencer.INSTANCE;
	private final ActionHandlerRegistry registry = new ActionHandlerRegistry();

	private final ActionDispatcherThread dispatcher = new ActionDispatcherThread(cadencer,
			registry);

	// Note: this class was made to use different cadencers (cadencers per eResources)
	public void deactivate()
	{
		dispatcher.dispose();
	}

	@Override
	public void postAction(ExecutionContext executionContext)
	{
		dispatcher.postAction(executionContext);
	}
}
