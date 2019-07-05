package org.joml;

public class Vector2d implements Vector2dc
{
	private final double x;
	private final double y;

	public Vector2d(double x, double y)
	{
		this.x = x;
		this.y = y;
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
}
