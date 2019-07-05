package org.joml;

public class Vector2f implements Vector2fc
{
	private final float x;
	private final float y;

	public Vector2f(float x, float y)
	{
		this.x = x;
		this.y = y;
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
}
