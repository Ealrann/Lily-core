import org.logoce.lmf.core.api.extender.IAdapterProvider;
import org.sheepy.lily.core.allocation.test.Extenders;

open module org.sheepy.lily.core.allocation.test
{
	requires org.sheepy.lily.core.allocation;
	requires org.junit.jupiter.api;

	provides IAdapterProvider with Extenders;
}

