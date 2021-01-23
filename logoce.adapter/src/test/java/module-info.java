import org.logoce.adapter.test.Adapters;
import org.logoce.extender.api.IAdapterProvider;

open module logoce.adapter.test {
	requires logoce.adapter;

	requires org.junit.jupiter.api;

	provides IAdapterProvider with Adapters;
}
