package org.sheepy.lily.core.allocation.internal;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.util.AdapterObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class AllocableListener
{
	private final List<AdapterObserver<IAllocableAdapter<?>>> observers = new ArrayList<>();
	private final ILilyEObject object;
	private final Consumer<IAllocableAdapter<?>> newAdapter;
	private final Consumer<IAllocableAdapter<?>> oldAapter;

	public AllocableListener(ILilyEObject object,
							 Consumer<IAllocableAdapter<?>> newAdapter,
							 Consumer<IAllocableAdapter<?>> oldAapter)
	{
		this.object = object;
		this.newAdapter = newAdapter;
		this.oldAapter = oldAapter;
	}

	public void listen(List<List<EReference>> referenceLists)
	{
		for (var references : referenceLists)
		{
			final var observer = new AdapterObserver<>(IAllocableAdapter.class, references, newAdapter, oldAapter);
			observer.startObserve(object);
			observers.add(observer);
		}
	}

	public void startListening()
	{
		for (var observer : observers)
		{
			observer.startObserve(object);
		}
	}

	public void stopListening()
	{
		for (var observer : observers)
		{
			observer.stopObserve(object);
		}
	}
}