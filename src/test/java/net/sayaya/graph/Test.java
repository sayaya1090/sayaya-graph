package net.sayaya.graph;

import com.google.gwt.core.client.EntryPoint;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import net.sayaya.d3.Axis;
import net.sayaya.d3.Bin;
import net.sayaya.d3.D3;
import net.sayaya.d3.Selection;
import net.sayaya.d3.scale.Scale;
import org.jboss.elemento.Elements;
import org.jboss.elemento.HtmlContentBuilder;

import static org.jboss.elemento.Elements.div;

public class Test implements EntryPoint {
	private final HtmlContentBuilder<HTMLDivElement> content = div();
	@Override
	public void onModuleLoad() {
		Elements.body().add(content);
		testFunction();
		testHistogram();
	}

	private void testFunction() {
		DomGlobal.console.log(D3.max(new Double[] {1.0, 2.0}));
	}
	private void testHistogram() {
		Double[] data = new Double[] {5.1, 4.9, 8.6, 6.2, 5.1, 7.1, 6.7, 6.1, 5.0, 5.0, 5.2, 7.9, 11.1, 5.9, 5.5, 5.6, 6.5, 7.7, 5.7, 6.7};
		content.add(HistogramElement.build(300, 250).data(data));
	}
}
