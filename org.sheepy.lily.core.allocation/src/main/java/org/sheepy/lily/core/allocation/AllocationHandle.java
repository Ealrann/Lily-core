package org.sheepy.lily.core.allocation;

import org.eclipse.emf.common.notify.Notification;
import org.logoce.extender.api.IAdaptable;
import org.logoce.extender.api.IAdapter;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.ListenerMap;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.operation.BuildOperation;
import org.sheepy.lily.core.api.allocation.IAllocationHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class AllocationHandle<Allocation extends IAdapter> implements IAllocationHandle<Allocation>
{
	private interface Features extends IFeatures<Features>
	{}

	private static final Feature<Runnable, Features> Activation = Feature.newFeature();
	private final Feature<ExtenderListener<Allocation>, Features> MainAllocation = Feature.newFeature();

	private final ILilyEObject target;
	private final AllocationDescriptor<Allocation> descriptor;
	private final ListenerMap<Features> listeners = new ListenerMap<>(List.of(MainAllocation, Activation));
	private final Consumer<Notification> activatorChanged = n -> activatorChanged(n.getNewBooleanValue());

	private AllocationInstance<Allocation> mainAllocation = null;
	private boolean activated;

	public AllocationHandle(final IAdaptable target, final AllocationDescriptor<Allocation> descriptor)
	{
		this.target = (ILilyEObject) target;
		this.descriptor = descriptor;
	}

	@Override
	public void load(final IAdaptable target)
	{
		final var activator = descriptor.activator();
		if (activator > -1)
		{
			this.target.listen(activatorChanged, activator);
			activated = (boolean) this.target.eGet(activator, true, true);
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
		if (activator > -1) this.target.sulk(activatorChanged, activator);
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

	public ILilyEObject getTarget()
	{
		return target;
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
