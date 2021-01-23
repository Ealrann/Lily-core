package org.sheepy.lily.core.api.adapter;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.logoce.extender.api.IAdapter;

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

	public AdapterDeployer(Class<Adapter> type, Consumer<Adapter> adapterAdd, Consumer<Adapter> adapterRemove)
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

	private void install(ILilyEObject object)
	{
		final var adapter = object.adapt(type);

		if (adapter != null)
		{
			adapterAdd.accept(adapter);
		}
	}

	private void uninstall(ILilyEObject object)
	{
		final var adapter = object.adapt(type);

		if (adapter != null)
		{
			adapterRemove.accept(adapter);
		}
	}
}
