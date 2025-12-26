package org.sheepy.lily.core.allocation;

import org.logoce.lmf.core.api.extender.IAdaptable;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.ListenerMap;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.operation.BuildOperation;
import org.sheepy.lily.core.api.allocation.IAllocationHandle;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class AllocationHandle<Allocation extends IAdapter> implements IAllocationHandle<Allocation>
{
	private interface Features extends IFeatures<Features>
	{}

	private static final IFeature<Runnable, Features> Activation = IFeature.newFeature();
	private final IFeature<ExtenderListener<Allocation>, Features> MainAllocation = IFeature.newFeature();

	private final IFeaturedObject target;
	private final AllocationDescriptor<Allocation> descriptor;
	private final ListenerMap<Features> listeners = new ListenerMap<>(List.of(MainAllocation, Activation));
	private final Consumer<Notification> activatorChanged = n -> activatorChanged(n.booleanValue());

	private AllocationInstance<Allocation> mainAllocation = null;
	private boolean activated;

	public AllocationHandle(final IAdaptable target, final AllocationDescriptor<Allocation> descriptor)
	{
		this.target = (IFeaturedObject) target;
		this.descriptor = descriptor;
	}

	@Override
	public void load(final IAdaptable target)
	{
		final var activator = descriptor.activator();
		if (activator != -1)
		{
			this.target.notifier().listen(activatorChanged, activator);
			activated = readActivatorValue(activator);
		}
		else
		{
			activated = true;
		}
	}

	@Override
	public void dispose(final IAdaptable target)
	{
		final var activator = descriptor.activator();
		if (activator != -1)
		{
			this.target.notifier().sulk(activatorChanged, activator);
		}
	}

	private void activatorChanged(boolean newState)
	{
		activated = newState;
		if (mainAllocation != null) mainAllocation.setDirty();
		listeners.notify(Activation);
	}

	public void setupBuildOperation(BuildOperation buildOperation)
	{
		buildOperation.setup(getDescriptor().prepareBuild(target, () -> {}), this::setMainAllocationUnsafe);
	}

	public void setupBuildOperation(BuildOperation buildOperation,
									Runnable whenUpdateNeeded,
									Consumer<AllocationInstance<Allocation>> postBuild)
	{
		final Consumer<AllocationInstance<?>> afterBuild = newAllocation -> {
			@SuppressWarnings("unchecked") final var allocation = (AllocationInstance<Allocation>) newAllocation;
			setMainAllocation(allocation);
			postBuild.accept(allocation);
		};

		buildOperation.setup(getDescriptor().prepareBuild(target, whenUpdateNeeded), afterBuild);
	}

	@SuppressWarnings("unchecked")
	private void setMainAllocationUnsafe(final AllocationInstance<?> newAllocation)
	{
		setMainAllocation((AllocationInstance<Allocation>) newAllocation);
	}

	public void setMainAllocation(final AllocationInstance<Allocation> allocation)
	{
		final var previousAllocation = getAllocationOrNull(mainAllocation);
		final var newAllocation = getAllocationOrNull(allocation);
		this.mainAllocation = allocation;
		onAllocationChange(previousAllocation, newAllocation);
	}

	@Override
	public <A extends Annotation> Stream<AnnotatedHandle<A>> annotatedHandles(final Class<A> annotationClass)
	{
		return mainAllocation != null ? mainAllocation.annotatedHandles(annotationClass) : Stream.empty();
	}

	public boolean isActivated()
	{
		return activated;
	}

	@Override
	public Allocation getExtender()
	{
		return getAllocationOrNull(mainAllocation);
	}

	private void onAllocationChange(Allocation oldAllocation, Allocation newAllocation)
	{
		listeners.notify(MainAllocation, listener -> listener.accept(oldAllocation, newAllocation));
	}

	public AllocationInstance<Allocation> getMainAllocation()
	{
		return mainAllocation;
	}

	@Override
	public void listen(final ExtenderListener<Allocation> listener)
	{
		listeners.listen(listener, MainAllocation);
	}

	@Override
	public void listenNoParam(final Runnable listener)
	{
		listeners.listenNoParam(listener, MainAllocation);
	}

	@Override
	public void sulk(final ExtenderListener<Allocation> listener)
	{
		listeners.sulk(listener, MainAllocation);
	}

	@Override
	public void sulkNoParam(final Runnable listener)
	{
		listeners.sulkNoParam(listener, MainAllocation);
	}

	public AllocationDescriptor<Allocation> getDescriptor()
	{
		return descriptor;
	}

	public IFeaturedObject getTarget()
	{
		return target;
	}

	private boolean readActivatorValue(final int featureId)
	{
		return Boolean.TRUE.equals(target.get(featureId));
	}

	private static <T extends IAdapter> T getAllocationOrNull(AllocationInstance<T> instance)
	{
		return instance != null ? instance.getAllocation() : null;
	}

	public void listenActivation(final Runnable onActivationChange)
	{
		listeners.listen(onActivationChange, Activation);
	}

	public void sulkActivation(final Runnable onActivationChange)
	{
		listeners.sulk(onActivationChange, Activation);
	}
}
