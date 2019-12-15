package org.sheepy.lily.core.api.view;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.application.IView;

public interface IViewAdapter<T extends IView> extends IAdapter
{
	IEngine buildEngine(T view);
}
