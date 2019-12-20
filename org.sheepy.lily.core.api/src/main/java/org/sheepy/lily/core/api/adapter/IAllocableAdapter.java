package org.sheepy.lily.core.api.adapter;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

public interface IAllocableAdapter<T extends IAllocationContext> extends IAllocable<T>, IAdapter
{}
