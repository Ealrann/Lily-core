package org.sheepy.common.api.resource;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public interface IResourceLoaderListener
{
	void postLoad(Collection<ILoadStatus> statusList);
	
	interface ILoadStatus
	{
		enum EStatusType
		{
			SUCCESS,
			ERROR_NO_EPACKAGE,
			ERROR_FILE_NOT_FOUND
		}
		
		
		EStatusType getType();

		URI getUri();
		Resource getResource();
		
		String getMessage();
	}
}
