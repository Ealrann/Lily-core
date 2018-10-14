package org.sheepy.common.api.adapter.impl;

import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.sheepy.common.api.adapter.ISheepyAdapter;
import org.sheepy.common.api.adapter.ISheepyAdapterFactory;
import org.sheepy.common.api.adapter.ISheepyAdapterWrapper;
import org.sheepy.common.api.util.ClassHierarchyIterator;
import org.sheepy.common.api.util.SingletonUtil;

public abstract class SheepyAdapterWrapper implements ISheepyAdapterWrapper
{
	protected final Class<? extends ISheepyAdapter> classifier;
	private final EClass targetEClass;
	private final boolean singleton;

	private ISheepyAdapter reference = null;
	private final HashMap<EObject, ISheepyAdapter> adapterMap = new HashMap<>();

	public SheepyAdapterWrapper(Class<? extends ISheepyAdapter> classifier, EClass targetEClass)
	{
		this.classifier = classifier;
		this.targetEClass = targetEClass;
		singleton = SingletonUtil.isSingleton(classifier);
	}

	@Override
	public ISheepyAdapter adapt(EObject target, ISheepyAdapterFactory adapterFactory)
	{
		if (singleton)
		{
			if (reference == null)
			{
				reference = createNewAdapter(target, adapterFactory);
			}
			reference.setTarget(target);
			return reference;
		}
		else
		{
			ISheepyAdapter res = adapterMap.get(target);
			if (res == null)
			{
				res = createNewAdapter(target, adapterFactory);
				adapterMap.put(target, res);
				target.eAdapters().add(res);
			}
			return res;
		}
	}

	protected ISheepyAdapter createNewAdapter(EObject target, ISheepyAdapterFactory adapterFactory)
	{
		final ISheepyAdapter res = instanciateNew();
		res.setAdapterFactory(adapterFactory);
		return res;
	}

	@Override
	public boolean isAdapterForType(Class<? extends ISheepyAdapter> type)
	{
		final ClassHierarchyIterator iterator = new ClassHierarchyIterator(classifier);
		while (iterator.hasNext())
		{
			final Class<?> current = iterator.next();
			if (current == type)
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean isDefaultAdapter()
	{
		return false;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return targetEClass == EcorePackage.Literals.EOBJECT || targetEClass.isSuperTypeOf(eClass);
	}

	protected abstract ISheepyAdapter instanciateNew();
}
