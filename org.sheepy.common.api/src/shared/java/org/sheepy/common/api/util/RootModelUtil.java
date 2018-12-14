package org.sheepy.common.api.util;

import java.util.Iterator;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.sheepy.common.model.root.LObject;

public class RootModelUtil
{
	public static TreeIterator<LObject> eAllContents(LObject unit)
	{
		return new AbstractTreeIterator<LObject>(unit, false)
		{
			private static final long serialVersionUID = 1L;

			@Override
			public Iterator<LObject> getChildren(Object object)
			{
				return ((LObject) object).lContents().iterator();
			}
		};
	}
}
