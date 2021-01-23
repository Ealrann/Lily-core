import org.logoce.adapter.impl.AdapterHandleFactory;
import org.logoce.extender.ext.IAdapterHandleFactory;

module logoce.adapter {
	requires transitive logoce.extender;
	requires transitive logoce.notification;

	exports org.logoce.adapter.api;

	provides IAdapterHandleFactory with AdapterHandleFactory;
}
