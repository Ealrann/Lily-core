package org.sheepy.lily.core.allocation.operator.internal;

import org.sheepy.lily.core.allocation.treeiterator.AllocationTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

public interface ILayer<T extends AllocationTreeIterator<T>>
{
	IAllocationContext context();
	boolean done();
	OperationWrapper<T> get();
	void next();
	void close();
}
