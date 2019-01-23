package org.sheepy.common.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sheepy.common.api.util.SingletonUtil;

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

	private class A1
	{
		@SuppressWarnings("unused")
		public int c;
	}

	private class B1 extends A1
	{}

	private class C1 extends B1
	{
		@SuppressWarnings("unused")
		private String a;
	}

	private class A2
	{}

	private class B2 extends A2
	{}

	private class C2 extends B2
	{}
}
