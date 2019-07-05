package org.joml;

public class Vector2i implements Vector2ic
{
	private final int x;
	private final int y;

	public Vector2i(int x, int y)
	{
		this.x = x;
		this.y = y;
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
}
