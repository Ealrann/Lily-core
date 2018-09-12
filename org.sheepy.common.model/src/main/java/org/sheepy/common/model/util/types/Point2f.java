package org.sheepy.common.model.util.types;

public class Point2f implements Cloneable, Comparable<Point2f>
{
	public float x;
	public float y;

	
	public static final Point2f ZERO_POINT = new Point2f(0, 0);
	
	public Point2f()
	{
		x = 0;
		y = 0;
	}

	public Point2f(float x, float y)
	{
		this.x = x;
		this.y = y;
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

	public float length()
	{
		return (float) Math.sqrt(x * x + y * y);
	}

	public void normalize()
	{
		float length = length();
		if (length > 0.)
		{
			x /= length;
			y /= length;
		}
	}
	
	public float computeOrientationToDegrees()
	{
		float orientation = (float) Math.acos(-y);
		if (x < 0)
			orientation *= -1;

		orientation = (float) Math.toDegrees(orientation);

		return orientation;
	}
	
	public float computeOrientationToRadians()
	{
		float orientation = (float) Math.acos(-y);
		if (x < 0)
			orientation *= -1;

		return orientation;
	}

	public float getXProjection(Point2f vector, float yTarget)
	{
		// C'est pas trop cool cette simplification ?
		return x + (((yTarget - y) / vector.y) * vector.x);
	}

	public float getYProjection(Point2f vector, float xTarget)
	{
		// Bien sûr que oui !!
		return y + (((xTarget - x) / vector.x) * vector.y);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("PointF [x=");
		sb.append(x);
		sb.append(", y=");
		sb.append(y);
		sb.append("]");
		
		return sb.toString();
	}

	@Override
	public Point2f clone()
	{
		return new Point2f(x, y);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
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
		Point2f other = (Point2f) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}

	public static int compare(Point2f o1, Point2f o2)
	{
		int res = Float.compare(o2.y, o1.y);
		
		if(res == 0)
			res = Float.compare(o2.x, o1.x);
		
		return res;
	}

	@Override
	public int compareTo(Point2f o)
	{
		return compare(this, o);
	}
}
