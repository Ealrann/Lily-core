package org.logoce.adapter.test;

import org.junit.jupiter.api.Test;
import org.logoce.adapter.api.Adapter;
import org.logoce.adapter.api.BasicAdaptable;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdapter
{
	@Test
	public void testAdapt()
	{
		final var src = new TestAdaptable();

		assertFalse(TestAdapter1.LOADED);
		assertFalse(TestAdapter2.LOADED);

		final var adapter1 = src.adapt(TestAdapter1.class);

		assertNotNull(adapter1);
		assertTrue(TestAdapter1.LOADED);
		assertFalse(TestAdapter2.LOADED);

		final var adapter2 = src.adapt(TestAdapter2.class);

		assertNotNull(adapter1);
		assertNotNull(adapter2);
		assertTrue(TestAdapter1.LOADED);
		assertTrue(TestAdapter2.LOADED);
	}

	public static final class TestAdaptable extends BasicAdaptable
	{}

	@ModelExtender(scope = TestAdaptable.class)
	@Adapter
	public static final class TestAdapter1 implements IAdapter
	{
		public static boolean LOADED = false;

		public TestAdapter1()
		{
			LOADED = true;
		}
	}

	@ModelExtender(scope = TestAdaptable.class)
	@Adapter
	public static final class TestAdapter2 implements IAdapter
	{
		public static boolean LOADED = false;

		public TestAdapter2()
		{
			LOADED = true;
		}
	}
}
