package org.joml;

public class Vector4f implements Vector4fc
{
	private final float x;
	private final float y;
	private final float z;
	private final float w;

	public Vector4f(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	@Override
	public float x()
	{
		return x;
	}

	@Override
	public float y()
	{
		return y;
	}

	@Override
	public float z()
	{
		return z;
	}

	@Override
	public float w()
	{
		return w;
	}
}
