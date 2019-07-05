package org.joml;

public class Vector4d implements Vector4dc
{
	private final double x;
	private final double y;
	private final double z;
	private final double w;

	public Vector4d(double x, double y, double z, double w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	@Override
	public double x()
	{
		return x;
	}

	@Override
	public double y()
	{
		return y;
	}

	@Override
	public double z()
	{
		return z;
	}

	@Override
	public double w()
	{
		return w;
	}
}
