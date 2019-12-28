//package org.sheepy.lily.core.action;
//
//import java.util.List;
//
//import org.sheepy.lily.core.api.action.IActionHandler;
//import org.sheepy.lily.core.model.action.Action;
//
//public class ActionHandlerRegistry
//{
//	private List<IActionHandler> handlers = null;
//
//	public IActionHandler getHandler(Action action)
//	{
//		if (handlers == null)
//		{
//			handlers = IActionHandler.HANDLERS;
//		}
//
//		for (final IActionHandler handler : handlers)
//		{
//			if (handler.getSupportedAction() == action.eClass()
//					|| handler.getSupportedAction().isSuperTypeOf(action.eClass()))
//			{
//				return handler;
//			}
//		}
//		return null;
//	}
//}
