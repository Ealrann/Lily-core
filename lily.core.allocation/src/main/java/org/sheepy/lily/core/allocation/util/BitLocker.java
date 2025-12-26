package org.sheepy.lily.core.allocation.util;

import java.math.BigInteger;

public final class BitLocker
{
	private BigInteger bits = BigInteger.ZERO;

	public int newLock()
	{
		int lock = 0;
		while (bits.testBit(lock)) lock++;
		bits = bits.setBit(lock);
		return lock;
	}

	public void release(int lock)
	{
		bits = bits.clearBit(lock);
		if (bits.equals(BigInteger.ZERO))
		{
			bits = BigInteger.ZERO;
		}
	}

	public boolean isLocked()
	{
		return !bits.equals(BigInteger.ZERO);
	}
}
