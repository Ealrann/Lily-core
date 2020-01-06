package org.sheepy.lily.core.api.adapter.util;

import java.util.function.Consumer;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * Will try to deploy an Adapter on all children - Notify when one adatper is found/removed
 */
public class AdapterDeployer<T extends IAdapter>
{
	private final Class<? extends IAdapter> type;
	private final ContentAdapter contentAdapter = new ContentAdapter(	this::install,
																		this::uninstall);
	private final Consumer<T> adapterAdd;
	private final Consumer<T> adapterRemove;

	public AdapterDeployer(Class<T> type, Consumer<T> adapterAdd, Consumer<T> adapterRemove)
	{
		this.adapterAdd = adapterAdd;
		this.adapterRemove = adapterRemove;
		this.type = type;
	}

	public void deploy(ILilyEObject root)
	{
		contentAdapter.install(root);
	}

	public void remove(ILilyEObject root)
	{
		contentAdapter.uninstall(root);
	}

	@SuppressWarnings("unchecked")
	private void install(ILilyEObject object)
	{
		final var adapter = object.adapt(type);

		if (adapter != null)
		{
			adapterAdd.accept((T) adapter);
		}
	}

	@SuppressWarnings("unchecked")
	private void uninstall(ILilyEObject object)
	{
		final var adapter = object.adapt(type);

		if (adapter != null)
		{
			adapterRemove.accept((T) adapter);
		}
	}
}
