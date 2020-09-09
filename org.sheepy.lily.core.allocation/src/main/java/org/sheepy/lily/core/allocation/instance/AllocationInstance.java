package org.sheepy.lily.core.allocation.instance;

import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.dependency.DependencyManager;
import org.sheepy.lily.core.api.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.Update;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public final class AllocationInstance<Allocation extends IExtender>
{
	private final IObservatory preObservatory;
	private final IObservatory observatory;
	private final AllocationState state;
	private final DependencyManager dependencyManager;
	private final AllocationChildrenManager preChildrenManager;
	private final AllocationChildrenManager postChildrenManager;
	private final IExtenderDescriptor.ExtenderContext<Allocation> extenderContext;

	public AllocationInstance(final ILilyEObject target,
							  final IObservatory preObservatory,
							  final IObservatory observatory,
							  final AllocationState state,
							  final DependencyManager dependencyManager,
							  final AllocationChildrenManager preChildrenManager,
							  final AllocationChildrenManager postChildrenManager,
							  final IExtenderDescriptor.ExtenderContext<Allocation> extenderContext)
	{
		this.preObservatory = preObservatory;
		this.observatory = observatory;
		this.state = state;
		this.dependencyManager = dependencyManager;
		this.preChildrenManager = preChildrenManager;
		this.postChildrenManager = postChildrenManager;
		this.extenderContext = extenderContext;

		if (observatory != null) observatory.observe(target);
	}

	public void update(ILilyEObject target)
	{
		assert isUpdatable();

		dependencyManager.update(target);

		if (state.needUpdate())
		{
			state.updated();
			final var it = extenderContext.annotatedConsumer(Update.class).iterator();
			while (it.hasNext()) it.next().invoke();
		}

		state.reset();
	}

	public void free(final ILilyEObject target, final IAllocationContext context)
	{
		assert isUnlocked();
		if (preObservatory != null) preObservatory.shut(target);
		if (observatory != null) observatory.shut(target);
		dependencyManager.free();
		final var it = extenderContext.annotatedConsumer(Free.class).iterator();
		while (it.hasNext()) it.next().invoke(context);
		state.setStatus(EAllocationStatus.Free);
	}

	public boolean isDirty()
	{
		return state.isDirty();
	}

	public boolean isUpdatable()
	{
		final var status = state.getStatus();
		final boolean updatableStatus = status != EAllocationStatus.Obsolete && status != EAllocationStatus.Free;
		final boolean updatable = updatableStatus && isUnlocked();

		return !isDirty() || updatable;
	}

	public void setDirty()
	{
		state.markDirty();
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

	public <A extends Annotation> Stream<IExtenderHandle.AnnotatedHandle<A>> annotatedHandles(Class<A> annotationClass)
	{
		return extenderContext.annotatedHandles(annotationClass);
	}

	public AllocationChildrenManager getPreChildrenManager()
	{
		return preChildrenManager;
	}

	public AllocationChildrenManager getPostChildrenManager()
	{
		return postChildrenManager;
	}

	public Allocation getAllocation()
	{
		return extenderContext.extender();
	}
}
