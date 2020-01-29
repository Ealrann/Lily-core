package org.sheepy.lily.core.api.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.util.SingletonUtil;

@Deprecated
public class SingletonUtilTest
{
	@Test
	public void singletonTestObject()
	{
		assertTrue(SingletonUtil.isSingleton(Object.class));
	}

	@Test
	public void singletonTestA1()
	{
		assertFalse(SingletonUtil.isSingleton(A1.class));
	}

	@Test
	public void singletonTestB1()
	{
		assertFalse(SingletonUtil.isSingleton(B1.class));
	}

	@Test
	public void singletonTestC1()
	{
		assertFalse(SingletonUtil.isSingleton(C1.class));
	}

	@Test
	public void singletonTestA2()
	{
		assertTrue(SingletonUtil.isSingleton(A2.class));
	}

	@Test
	public void singletonTestB2()
	{
		assertTrue(SingletonUtil.isSingleton(B2.class));
	}

	@Test
	public void singletonTestC2()
	{
		assertTrue(SingletonUtil.isSingleton(C2.class));
	}

	private static class A1
	{
		@SuppressWarnings("unused")
		public int c;
	}

	private static class B1 extends A1
	{}

	private static class C1 extends B1
	{
		@SuppressWarnings("unused")
		private String a;
	}

	private static class A2
	{}

	private static class B2 extends A2
	{}

	private static class C2 extends B2
	{}
}
