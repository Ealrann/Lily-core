package org.sheepy.lily.core.allocation.instance;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.children.manager.IAllocationChildrenManager;
import org.sheepy.lily.core.allocation.dependency.DependencyManager;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationInstance;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.Update;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.util.ConsumerListenerList;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.annotation.Annotation;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class AllocationInstance<Allocation extends IExtender> implements IAllocationInstance<Allocation>
{
	private final ILilyEObject target;
	private final IObservatory observatory;
	private final AllocationState state;
	private final ConsumerListenerList<EAllocationStatus> listeners;
	private final DependencyManager dependencyManager;
	private final IAllocationChildrenManager preChildrenManager;
	private final IAllocationChildrenManager postChildrenManager;
	private final IExtenderDescriptor.ExtenderContext<Allocation> extenderContext;

	public AllocationInstance(final ILilyEObject target,
							  final IObservatory observatory,
							  final AllocationState state,
							  final ConsumerListenerList<EAllocationStatus> listeners,
							  final DependencyManager dependencyManager,
							  final IAllocationChildrenManager preChildrenManager,
							  final IAllocationChildrenManager postChildrenManager,
							  final IExtenderDescriptor.ExtenderContext<Allocation> extenderContext)
	{
		this.target = target;
		this.observatory = observatory;
		this.state = state;
		this.listeners = listeners;
		this.dependencyManager = dependencyManager;
		this.preChildrenManager = preChildrenManager;
		this.postChildrenManager = postChildrenManager;
		this.extenderContext = extenderContext;

		if (observatory != null) observatory.observe(target);
	}

	public void load(final IAllocationContext context)
	{
		postChildrenManager.update(target, context);
		state.reset();
	}

	@Override
	public void update(IAllocationContext context)
	{
		assert isDirty();
		assert isUpdatable();

		if (preChildrenManager.isDirty())
		{
			preChildrenManager.update(target, context);
		}

		dependencyManager.update(target);

		if (state.needUpdate())
		{
			state.updated();
			extenderContext.annotatedConsumer(Update.class).forEach(ConsumerHandle::invoke);
		}

		if (postChildrenManager.isDirty())
		{
			postChildrenManager.update(target, context);
		}

		state.reset();
	}

	@Override
	public void free(IAllocationContext context)
	{
		cleanup(new FreeContext(context, true));
	}

	@Override
	public void cleanup(final IAllocationContext context)
	{
		cleanup(new FreeContext(context, false));
	}

	public void cleanup(final FreeContext context)
	{
		final var subContext = context.encapsulate(context.freeEverything() || state.getStatus() == EAllocationStatus.Obsolete);
		final var freeRequested = subContext.freeEverything();
		assert !freeRequested || isUnlocked();

		if (freeRequested || postChildrenManager.isDirty())
		{
			postChildrenManager.cleanup(subContext);
		}

		if (freeRequested)
		{
			freeInternal(subContext.context());
		}

		if (freeRequested || preChildrenManager.isDirty())
		{
			preChildrenManager.cleanup(subContext);
		}
		if (freeRequested)
		{
			state.setStatus(EAllocationStatus.Free);
		}
	}

	private void freeInternal(IAllocationContext context)
	{
		if (observatory != null) observatory.shut(target);
		dependencyManager.free();
		extenderContext.annotatedConsumer(Free.class).forEach(c -> c.invoke(context));
		state.setStatus(EAllocationStatus.Free);
	}

	@Override
	public boolean isDirty()
	{
		return state.isDirty();
	}

	public boolean isUpdatable()
	{
		final var status = state.getStatus();
		final boolean updatableStatus = status != EAllocationStatus.Obsolete && status != EAllocationStatus.Free;
		return isUnlocked() && updatableStatus;
	}

	public void markObsolete()
	{
		state.markObsolete();
	}

	public boolean isLocked()
	{
		return state.isLocked();
	}

	public boolean isUnlocked()
	{
		return !isLocked();
	}

	public EAllocationStatus getStatus()
	{
		return state.getStatus();
	}

	public void listen(Consumer<EAllocationStatus> listener)
	{
		listeners.listen(listener);
	}

	public void sulk(Consumer<EAllocationStatus> listener)
	{
		listeners.sulk(listener);
	}

	public <A extends Annotation> Stream<IExtenderHandle.AnnotatedHandle<A>> annotatedHandles(Class<A> annotationClass)
	{
		return extenderContext.annotatedHandles(annotationClass);
	}

	@Override
	public Allocation getAllocation()
	{
		return extenderContext.extender();
	}
}
