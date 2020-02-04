package org.sheepy.lily.core.allocation;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.List;

public class AllocationTreeTest
{
	@Test
	public void testTreeContext()
	{
		final var c1 = new C1();
		final var c2 = new C2();
		final var c3 = new C3();

		final var a3 = new A3(null, List.of());
		final var a2 = new A2(c3, List.of(a3));
		final var a1 = new A1(c2, List.of(a2));
		final var root = new BasicAllocable<>(c1, List.of(a1));

		final AllocationService service = new AllocationService();

		final var rootManager = service.createAllocator(root, null);
		rootManager.allocate();
	}

	static final class C1 implements IAllocationContext
	{
	}

	static final class C2 implements IAllocationContext
	{
	}

	static final class C3 implements IAllocationContext
	{
	}

	static class BasicAllocable<T extends IAllocationContext> implements IAllocable<T>
	{
		private final List<? extends IAllocable<?>> children;
		private final IAllocationContext childrenContext;

		public BasicAllocable(IAllocationContext childrenContext, List<? extends IAllocable<?>> children)
		{
			this.childrenContext = childrenContext;
			this.children = List.copyOf(children);
		}

		@Override
		public void configureAllocation(IAllocationConfigurator config, T context)
		{
			config.addChildren(children);

			if (childrenContext != null)
			{
				config.setChildrenContext(childrenContext);
			}
		}

		@Override
		public void allocate(T context)
		{
		}

		@Override
		public void free(T context)
		{
		}
	}

	static final class A1 extends BasicAllocable<C1>
	{
		public A1(IAllocationContext childrenContext, List<? extends IAllocable<?>> children)
		{
			super(childrenContext, children);
		}
	}

	static final class A2 extends BasicAllocable<C2>
	{
		public A2(IAllocationContext childrenContext, List<? extends IAllocable<?>> children)
		{
			super(childrenContext, children);
		}
	}

	static final class A3 extends BasicAllocable<C3>
	{
		public A3(IAllocationContext childrenContext, List<? extends IAllocable<?>> children)
		{
			super(childrenContext, children);
		}

		@Override
		public void allocate(C3 context)
		{
			System.out.println();
		}
	}
}
