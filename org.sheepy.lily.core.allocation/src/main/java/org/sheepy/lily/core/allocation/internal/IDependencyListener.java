package org.sheepy.lily.core.allocation.internal;

public interface IDependencyListener
{
	enum EChangeNature
	{
		Dirty,
		Allocated,
		Free
	}

	void onChange(EChangeNature changeNature);
}
