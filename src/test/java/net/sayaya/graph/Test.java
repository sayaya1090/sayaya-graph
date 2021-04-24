package net.sayaya.graph;

import com.google.gwt.core.client.EntryPoint;
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import net.sayaya.graph.scale.Scale;
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
		int width = 300;
		int height = 250;
		int marginTop = 20;
		int marginBottom = 30;
		int marginLeft = 40;
		int marginRight = 20;
		int tick = 40;
		Double[] data = new Double[] {5.1, 4.9, 8.6, 6.2, 5.1, 7.1, 6.7, 6.1, 5.0, 5.0, 5.2, 7.9, 11.1, 5.9, 5.5, 5.6, 6.5, 7.7, 5.7, 6.7};
		String color = "steelblue";
		Selection svg = D3.create("svg").attr("viewBox", new Object[]{0, 0, width*5, height*5});
		Bin[] bins = D3.bin().thresholds(tick).apply(data);
		Scale x = D3.scaleLinear()
				.domain(new Object[] {Bin.x0(bins[0]), Bin.x1(bins[bins.length-1])})
				.range(new Object[]{marginLeft, width-marginRight});
		Scale y = D3.scaleLinear()
				.domain(new Object[] {0, D3.max(bins, bin->Js.asArray(bin).length)}).nice()
				.range(new Object[]{height-marginBottom, marginTop});

		svg.append("g").attr("fill", color)
				.selectAll("rect")
				.data(bins)
				.join("rect")
					.attr("x", (D3.Function<Object, Double>) bin -> 1.0 + (Double)x.call(x, Bin.x1(bin)))
					.attr("width", (D3.Function<Object, Double>) bin -> Math.max(0, (Double)x.call(x, Bin.x1(bin))-(Double)x.call(x, Bin.x0(bin))-1))
					.attr("y",  (D3.Function<Object, Double>) bin -> (Double)y.call(y,  Js.asArray(bin).length))
					.attr("height",  (D3.Function<Object, Double>) bin ->(Double)y.call(y, 0) -  (Double)y.call(y, Js.asArray(bin).length));
		Axis xAxis = D3.axisBottom(x).ticks(width / tick).tickSizeOuter(0);

		svg.append("g")
				.attr("transform", "translate(0, " + (height - marginBottom) + ")")
				.call(xAxis)
				.append("text")
					.attr("x", width - marginRight)
					.attr("y", -4)
					.attr("fill", "currentColor")
					.attr("font-weight", "bold")
					.attr("text-anchor", "end")
					.text("Unemployment (%)");

		content.add(svg.node());

	}
}
