package org.joml;

public class Vector4i implements Vector4ic
{
	private final int x;
	private final int y;
	private final int z;
	private final int w;

	public Vector4i(int x, int y, int z, int w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
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

	@Override
	public int w()
	{
		return w;
	}
}
