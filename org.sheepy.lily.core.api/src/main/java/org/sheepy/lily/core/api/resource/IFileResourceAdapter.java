package org.sheepy.lily.core.api.resource;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.application.FileResource;

public interface IFileResourceAdapter extends IAdapter
{
	ByteBuffer allocByteBuffer(FileResource resource);
}
