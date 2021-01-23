package org.sheepy.lily.core.api.resource;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.core.model.resource.FileResource;

import java.nio.ByteBuffer;

public interface IFileResourceAdapter extends IAdapter
{
	ByteBuffer allocByteBuffer(FileResource resource);
}
