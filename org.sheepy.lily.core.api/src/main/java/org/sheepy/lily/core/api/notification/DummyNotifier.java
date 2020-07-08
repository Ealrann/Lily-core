package org.sheepy.lily.core.api.notification;

import java.util.Collection;

public class DummyNotifier<Type extends IFeatures<Type>> implements INotifier<Type>
{
	public DummyNotifier()
	{
	}

	@Override
	public <Callback> void listen(final Callback listener, final Feature<? super Callback, Type> feature)
	{
	}

	@Override
	public <Callback> void listen(final Callback listener,
								  final Collection<? extends Feature<? super Callback, Type>> features)
	{
	}

	@Override
	public void listenNoParam(final Runnable listener, final Feature<?, Type> feature)
	{
	}

	@Override
	public void listenNoParam(final Runnable listener, final Collection<? extends Feature<?, Type>> features)
	{
	}

	@Override
	public <Callback> void sulk(final Callback listener, final Feature<? super Callback, Type> feature)
	{
	}

	@Override
	public <Callback> void sulk(final Callback listener,
								final Collection<? extends Feature<? super Callback, Type>> features)
	{
	}

	@Override
	public void sulkNoParam(final Runnable listener, final Feature<?, Type> feature)
	{
	}

	@Override
	public void sulkNoParam(final Runnable listener, final Collection<? extends Feature<?, Type>> features)
	{
	}
}
