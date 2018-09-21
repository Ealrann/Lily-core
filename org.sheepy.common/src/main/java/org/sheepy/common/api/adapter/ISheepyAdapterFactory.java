package org.sheepy.common.api.adapter;

import org.sheepy.common.model.types.SObject;

public interface ISheepyAdapterFactory
{

	<T extends ISheepyAdapter> T adapt(SObject lilyObject, Class<T> classifier);
	
	//TODO pour un adapter stateless, doit se comporter comme le adapt (car creer un nouveau
	// adapter stateless ne peut jamais être utile)
	// Pour un adapter singleton : doit en creer un nouveau.
	<T extends ISheepyAdapter> T adaptNew(SObject lilyObject, Class<T> classifier);
	
}
