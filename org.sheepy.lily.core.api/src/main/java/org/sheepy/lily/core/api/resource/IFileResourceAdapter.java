package org.sheepy.lily.core.api.resource;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.resource.FileResource;

import java.nio.ByteBuffer;

public interface IFileResourceAdapter extends IExtender
{
	ByteBuffer allocByteBuffer(FileResource resource);
}
