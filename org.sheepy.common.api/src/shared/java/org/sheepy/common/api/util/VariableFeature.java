package org.sheepy.common.api.util;

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EAttribute;

public class VariableFeature
{
	public String nsURI;
	public String className;
	public String featureName;

	public String definition;

	public VariableFeature(String def)
	{
		this.definition = def;
		String[] split = def.split(Pattern.quote("#"));
		nsURI = split[0];
		className = split[1];
		featureName = split[2];
	}

	public VariableFeature(EAttribute attribute)
	{
		featureName = attribute.getName();
		className = attribute.getEContainingClass().getName();
		nsURI = attribute.getEContainingClass().getEPackage().getNsURI();

		definition = String.format("%s#%s#%s", nsURI, className, featureName);
	}
}
