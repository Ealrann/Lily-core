package org.joml;

public class Vector3d implements Vector3dc
{
	private final double x;
	private final double y;
	private final double z;

	public Vector3d(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
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
}
