package org.joml;

public class Vector3i implements Vector3ic
{
	private final int x;
	private final int y;
	private final int z;

	public Vector3i(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int x()
	{
		return x;
	}

	@Override
	public int y()
	{
		return y;
	}

	@Override
	public int z()
	{
		return z;
	}
}
