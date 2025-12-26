package org.sheepy.lily.core.api.adapter;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.lang.LMObject;

import java.util.function.Consumer;

/**
 * Will try to deploy an Adapter on all children - Notify when one adatper is found/removed
 */
public class AdapterDeployer<Adapter extends IAdapter>
{
	private final Class<Adapter> type;
	private final ContentAdapter contentAdapter = new ContentAdapter(this::install, this::uninstall);
	private final Consumer<Adapter> adapterAdd;
	private final Consumer<Adapter> adapterRemove;

	public AdapterDeployer(final Class<Adapter> type,
						   final Consumer<Adapter> adapterAdd,
						   final Consumer<Adapter> adapterRemove)
	{
		this.adapterAdd = adapterAdd;
		this.adapterRemove = adapterRemove;
		this.type = type;
	}

	public void deploy(final LMObject root)
	{
		contentAdapter.install(root);
	}

	public void remove(final LMObject root)
	{
		contentAdapter.uninstall(root);
	}

	private void install(final LMObject object)
	{
		final var adapter = object.adapt(type);

		if (adapter != null)
		{
			adapterAdd.accept(adapter);
		}
	}

	private void uninstall(final LMObject object)
	{
		final var adapter = object.adapt(type);

		if (adapter != null)
		{
			adapterRemove.accept(adapter);
		}
	}
}

