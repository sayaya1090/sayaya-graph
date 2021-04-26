package net.sayaya.graph;

import elemental2.dom.HTMLElement;
import net.sayaya.d3.D3;
import net.sayaya.d3.Selection;
import org.jboss.elemento.IsElement;

public class StackedNormalizedHorizontalBarChartElement implements IsElement<HTMLElement> {
	public static StackedNormalizedHorizontalBarChartElement build(int width, int height) {
		return new StackedNormalizedHorizontalBarChartElement(width, height);
	}
	private int width;
	private int height;
	private final Selection svg;
	public StackedNormalizedHorizontalBarChartElement(int width, int height) {
		this.width = width;
		this.height = height;
		svg = D3.create("svg").attr("width", width).attr("height", height).attr("viewBox", new Object[]{0, 0, width, height});
		svg.append("g")
		   .selectAll("g")
		   .data(null).enter()
		   .append("g").attr("fill", "A");
		//content = svg.append("g").attr("fill", color);
		//bottom = svg.append("g").attr("transform", "translate(0, " + (height - marginBottom) + ")");
		//left = svg.append("g").attr("transform", "translate(" + marginLeft + ", 0)");
	}
	@Override
	public HTMLElement element() {
		return null;
	}
}
