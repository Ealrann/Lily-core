package org.sheepy.lily.core.api.types;

public class SVector2i implements Cloneable
{
	public int x;
	public int y;

	public SVector2i()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public SVector2i(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
	
	@Override
	public SVector2i clone()
	{
		return new SVector2i(x, y);
	}
	
	public float distanceSquare(SVector2i target)
	{
		return (target.x - x) * (target.x - x) 
				+ (target.y - y) * (target.y - y);
	}


	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Point [x=");
		sb.append(x);
		sb.append(", y=");
		sb.append(y);
		sb.append("]");
		
		return sb.toString();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SVector2i other = (SVector2i) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}