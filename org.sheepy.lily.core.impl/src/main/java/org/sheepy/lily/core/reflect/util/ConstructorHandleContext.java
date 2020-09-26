package org.sheepy.lily.core.reflect.util;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

public record ConstructorHandleContext(MethodHandle methodHandle, Class<?> container,
									   MethodHandles.Lookup privateLookup) {}
