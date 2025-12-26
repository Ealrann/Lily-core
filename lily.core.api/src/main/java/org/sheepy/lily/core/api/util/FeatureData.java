package org.sheepy.lily.core.api.util;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Lightweight descriptor for a structural feature identified by
 * <code>"model#group#feature"</code>.
 * <p>
 * In the LMF-based stack the {@code model} part typically matches
 * {@code domain + "." + name} of the owning LMCore {@code MetaModel}
 * (for example {@code "org.sheepy.lily.core.model.Variable"}).
 */
public class FeatureData
{
	public final String nsURI;
	public final String className;
	public final String featureName;
	public final String definition;

	public FeatureData(final String def)
	{
		definition = Objects.requireNonNull(def, "def");

		final var split = def.split(Pattern.quote("#"), 3);
		if (split.length != 3)
		{
			throw new IllegalArgumentException(
					"Invalid feature definition '%s', expected '<model>#<class>#<feature>'".formatted(def));
		}

		nsURI = split[0];
		className = split[1];
		featureName = split[2];
	}

	public FeatureData(final String nsURI, final String className, final String featureName)
	{
		this.nsURI = Objects.requireNonNull(nsURI, "nsURI");
		this.className = Objects.requireNonNull(className, "className");
		this.featureName = Objects.requireNonNull(featureName, "featureName");
		definition = nsURI + "#" + className + "#" + featureName;
	}
}

