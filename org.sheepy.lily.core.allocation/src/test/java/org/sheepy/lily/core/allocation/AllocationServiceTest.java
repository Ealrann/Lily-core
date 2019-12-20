package org.sheepy.lily.core.allocation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.allocation.AllocationServiceTest.BasicContext.BasicBasicContext;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

public class AllocationServiceTest
{
	@Test
	public void BasicTest()
	{
		final var lvl2_1 = new BasicAllocable(List.of(), List.of());
		final var lvl1_1 = new BasicAllocable(List.of(lvl2_1), List.of());
		final var lvl1_2 = new BasicAllocable(List.of(), List.of());
		final var root = new BasicAllocable(List.of(lvl1_1, lvl1_2), List.of());

		final AllocationService service = new AllocationService();

		final var rootManager = service.createManager(root);
		rootManager.configure(null);

		rootManager.allocate();

		assertTrue(root.tag);
		assertTrue(lvl1_1.tag);
		assertTrue(lvl1_2.tag);
		assertTrue(lvl2_1.tag);

		rootManager.free();

		assertTrue(!root.tag);
		assertTrue(!lvl1_1.tag);
		assertTrue(!lvl1_2.tag);
		assertTrue(!lvl2_1.tag);
	}

	@Test
	public void BasicTestDirty()
	{
		final var lvl2_1 = new BasicAllocable(List.of(), List.of());
		final var lvl1_1 = new BasicAllocable(List.of(lvl2_1), List.of());
		final var lvl1_2 = new BasicAllocable(List.of(), List.of());
		final var root = new BasicAllocable(List.of(lvl1_1, lvl1_2), List.of());

		final AllocationService service = new AllocationService();

		final var rootManager = service.createManager(root);
		rootManager.configure(null);

		rootManager.allocate();

		lvl1_2.setDirty();

		assertTrue(lvl1_2.dirty);
		assertTrue(lvl1_2.tag);

		rootManager.freeDirtyElements();
		rootManager.allocate();

		assertTrue(!lvl1_2.dirty);
		assertTrue(lvl1_2.tag);

		lvl1_2.setDirty();
		rootManager.free();

		assertTrue(!lvl1_2.dirty);
		assertTrue(!lvl1_2.tag);
	}

	@Test
	public void testDependencies()
	{
		final var lvl2_1 = new BasicAllocable(List.of(), List.of());
		final var lvl1_2 = new BasicAllocable(List.of(), List.of());
		final var lvl1_1 = new BasicAllocable(List.of(lvl2_1), List.of(lvl1_2));
		final var root = new BasicAllocable(List.of(lvl1_1, lvl1_2), List.of());

		final AllocationService service = new AllocationService();

		final var rootManager = service.createManager(root);
		rootManager.configure(null);

		rootManager.allocate();

		assertTrue(lvl1_2.tag);
		assertTrue(lvl2_1.tag);
		assertTrue(lvl1_1.tag);

		lvl1_1.tag = false;

		rootManager.allocate();

		assertTrue(!lvl1_1.tag);

		lvl1_2.setDirty();

		rootManager.freeDirtyElements();
		rootManager.allocate();

		assertTrue(lvl1_1.tag);
	}

	@Test
	public void contextAllocation()
	{
		final var context = new BasicContext();

		final var lvl1_1 = new BasicAllocable(context, List.of(), List.of());
		final var root = new BasicAllocable(List.of(lvl1_1), List.of());

		final AllocationService service = new AllocationService();

		final var rootManager = service.createManager(root);
		rootManager.configure(null);

		rootManager.allocate();

		assertTrue(context.allocated);

		rootManager.free();

		assertTrue(!context.allocated);
	}

	@Test
	public void addChildrenDuringAllocation()
	{
		final var lvl2_1 = new BasicAllocable(List.of(), List.of());
		final var lvl1_1 = new BasicAllocable(List.of(), List.of());
		final var root = new BasicAllocable(List.of(lvl1_1), List.of());

		lvl1_1.childrenToAddDuringAlloc.add(lvl2_1);

		final AllocationService service = new AllocationService();

		final var rootManager = service.createManager(root);
		rootManager.configure(null);

		assertTrue(!lvl2_1.tag);
		assertTrue(!lvl2_1.configured);

		rootManager.allocate();

		assertTrue(lvl2_1.tag);
		assertTrue(lvl2_1.configured);

		rootManager.free();

		assertTrue(!lvl2_1.tag);
	}

	final static class BasicContext implements IAllocationContext, IAllocable<BasicBasicContext>
	{
		public boolean allocated = false;

		@Override
		public void allocate(BasicBasicContext context)
		{
			allocated = true;
		}

		@Override
		public void free(BasicBasicContext context)
		{
			allocated = false;
		}

		final static class BasicBasicContext implements IAllocationContext
		{}
	}

	static class BasicAllocable implements IAllocable<BasicContext>
	{
		private final List<BasicAllocable> children;
		private final List<BasicAllocable> dependencies;
		private final IAllocationContext providedContext;
		private final List<BasicAllocable> childrenToAddDuringAlloc = new ArrayList<>();

		public boolean tag = false;
		public boolean configured = false;
		public boolean dirty = false;
		private IAllocationConfigurator config;

		public BasicAllocable(List<BasicAllocable> children, List<BasicAllocable> dependencies)
		{
			this(null, children, dependencies);
		}

		public BasicAllocable(	IAllocationContext context,
								List<BasicAllocable> children,
								List<BasicAllocable> dependencies)
		{
			this.providedContext = context;
			this.children = List.copyOf(children);
			this.dependencies = List.copyOf(dependencies);
		}

		@Override
		public void configureAllocation(IAllocationConfigurator config, BasicContext context)
		{
			this.config = config;

			config.addChildren(children);
			config.addDependencies(dependencies);

			if (providedContext != null)
			{
				config.setChildrenContext(providedContext);
			}

			configured = true;
		}

		public void setDirty()
		{
			config.setDirty();
			dirty = true;
		}

		@Override
		public void allocate(BasicContext context)
		{
			if (childrenToAddDuringAlloc.isEmpty() == false)
			{
				config.addChildren(childrenToAddDuringAlloc, true);
			}

			tag = true;
			dirty = false;
		}

		@Override
		public void free(BasicContext context)
		{
			tag = false;
			dirty = false;

			if (childrenToAddDuringAlloc.isEmpty() == false)
			{
				config.removeChildren(childrenToAddDuringAlloc, true);
			}
		}
	}
}
