package org.sheepy.lily.core.api.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ClassHierarchyIteratorTest
{
	@Test
	public void testClassIteratorOnObject()
	{
		final ClassHierarchyIterator iterator = new ClassHierarchyIterator(Object.class);
		checkCount(iterator, 1);
	}

	@Test
	public void testClassIteratorOnClassB()
	{
		final ClassHierarchyIterator iterator = new ClassHierarchyIterator(B.class);
		checkCount(iterator, 8);
	}

	private void checkCount(ClassHierarchyIterator iterator, int expectedCount)
	{
		int count = 0;
		while (iterator.hasNext())
		{
			final Class<?> current = iterator.next();
			if (current != null)
			{
				count++;
			}
			else
			{
				fail("Null Class encoutered");
			}
		}

		assertEquals(expectedCount, count);
	}

	private static class A implements I11, I21
	{}

	private interface I1
	{}

	private interface I11 extends I1
	{}

	private interface I2
	{}

	private interface I21 extends I2
	{}

	private interface I3
	{}

	private class B extends A implements I3
	{}
}
