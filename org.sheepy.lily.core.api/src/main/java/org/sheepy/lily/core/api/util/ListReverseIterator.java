package org.sheepy.lily.core.api.util;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class ListReverseIterator<T> implements Iterator<T>
{
	private final ListIterator<T> iterator;

	public ListReverseIterator(List<T> list)
	{
		iterator = list.listIterator(list.size());
	}

	@Override
	public boolean hasNext()
	{
		return iterator.hasPrevious();
	}

	@Override
	public T next()
	{
		return iterator.previous();
	}
}
