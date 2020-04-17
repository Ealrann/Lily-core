package org.sheepy.lily.core.api.extender;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface IExtenderHandleFactory
{
	Class<? extends Annotation> describedBy();
	<E extends IExtender> IExtenderHandleBuilder<E> newBuilder(IExtenderDescriptor<E> descriptor);

	List<IExtenderHandleFactory> FACTORIES = StreamSupport.stream(ServiceLoader.load(IExtenderHandleFactory.class)
																			   .spliterator(), false)
														  .collect(Collectors.toUnmodifiableList());
}
