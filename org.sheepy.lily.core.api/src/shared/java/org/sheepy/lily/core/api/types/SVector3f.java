package org.sheepy.lily.core.api.types;

public class SVector3f implements Cloneable, Comparable<SVector3f>
{
	public float x;
	public float y;
	public float z;

	public static final SVector3f ZERO_POINT = new SVector3f(0, 0, 0);

	public SVector3f()
	{
		this(0, 0, 0);
	}

	public SVector3f(SVector3f vector)
	{
		this(vector.x, vector.y, vector.z);
	}

	public SVector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX()
	{
		return x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY(float y)
	{
		this.y = y;
	}

	public float getZ()
	{
		return z;
	}

	public void setZ(float z)
	{
		this.z = z;
	}

	public float length()
	{
		return (float) Math.sqrt(x * x + y * y + z * z);
	}

	public void normalize()
	{
		float length = length();
		if (length > 0.)
		{
			x /= length;
			y /= length;
			z /= length;
		}
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("PointF [x=");
		sb.append(x);
		sb.append(", y=");
		sb.append(y);
		sb.append(", z=");
		sb.append(z);
		sb.append("]");

		return sb.toString();
	}

	@Override
	public SVector3f clone()
	{
		return new SVector3f(x, y, z);
	}

	public static int compare(SVector3f o1, SVector3f o2)
	{
		int res = Float.compare(o2.y, o1.y);
		if (res == 0) res = Float.compare(o2.x, o1.x);
		if (res == 0) res = Float.compare(o2.z, o1.z);

		return res;
	}

	@Override
	public int compareTo(SVector3f o)
	{
		return compare(this, o);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		result = prime * result + Float.floatToIntBits(z);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		SVector3f other = (SVector3f) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x)) return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y)) return false;
		if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z)) return false;
		return true;
	}
}
