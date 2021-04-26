package net.sayaya.graph;

import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import net.sayaya.d3.Axis;
import net.sayaya.d3.Bin;
import net.sayaya.d3.D3;
import net.sayaya.d3.Selection;
import net.sayaya.d3.scale.Scale;
import org.jboss.elemento.IsElement;

public class HistogramElement implements IsElement<HTMLElement> {
	public static HistogramElement build(int width, int height) {
		return new HistogramElement(width, height);
	}
	private int width;
	private int height;
	private int marginTop = 20;
	private int marginBottom = 30;
	private int marginLeft = 40;
	private int marginRight = 20;
	private int tick = 40;
	private String color = "steelblue";
	private final Selection svg;
	private final Selection content;
	private final Selection bottom;
	private final Selection left;
	private Bin[] bins;
	private Scale x, y;
	private Axis axisX, axisY;
	private HistogramElement(int width, int height) {
		this.width = width;
		this.height = height;
		svg = D3.create("svg").attr("width", width).attr("height", height).attr("viewBox", new Object[]{0, 0, width, height});
		content = svg.append("g").attr("fill", color);
		bottom = svg.append("g").attr("transform", "translate(0, " + (height - marginBottom) + ")");
		left = svg.append("g").attr("transform", "translate(" + marginLeft + ", 0)");
	}
	public HistogramElement data(Double[] values) {
		bins = D3.bin().thresholds(tick).apply(values);
		x = D3.scaleLinear()
					.domain(new Object[] {bins[0].x0, bins[bins.length-1].x1})
					.range(new Object[]{marginLeft, width-marginRight});
		y = D3.scaleLinear()
			  .domain(new Object[] {0, D3.max(bins, bin-> Js.asArray(bin).length)}).nice()
			  .range(new Object[]{height-marginBottom, marginTop});
		content.selectAll("rect")
			   .data(bins)
			   .join("rect")
			   .attr("x", (D3.Function<Bin, Double>) bin -> 1.0 + (Double)x.call(x, bin.x1))
			   .attr("width", (D3.Function<Bin, Double>) bin -> Math.max(0, (Double)x.call(x, bin.x1)-(Double)x.call(x, bin.x0)-1))
			   .attr("y",  (D3.Function<Bin, Double>) bin -> (Double)y.call(y,  bin.length))
			   .attr("height",  (D3.Function<Bin, Double>) bin ->(Double)y.call(y, 0) -  (Double)y.call(y, bin.length));
		axisX = D3.axisBottom(x).ticks(width / tick).tickSizeOuter(0);
		axisY = D3.axisLeft(y).ticks(height / 40);
		bottom.call(axisX)
			  .append("text")
			  .attr("x", width - marginRight)
			  .attr("y", -4)
			  .attr("fill", "currentColor")
			  .attr("font-weight", "bold")
			  .attr("text-anchor", "end")
			  .text("Unemployment (%)");
		left.call(axisY)
			.selectAll(".tick:last-of-type text").clone()
			.attr("x", 4)
			.attr("font-weight", "bold")
			.attr("text-anchor", "start")
			.text("Counties")
			.selectAll(".domain").remove();
		return this;
	}
	@Override
	public HTMLElement element() {
		return svg.node();
	}
}
