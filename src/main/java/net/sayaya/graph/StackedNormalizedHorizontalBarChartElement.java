package net.sayaya.graph;

import elemental2.dom.HTMLElement;
import lombok.Data;
import lombok.experimental.Accessors;
import net.sayaya.d3.D3;
import net.sayaya.d3.Selection;
import org.jboss.elemento.IsElement;

import java.util.List;
import java.util.Map;

public class StackedNormalizedHorizontalBarChartElement implements IsElement<HTMLElement> {
	public static StackedNormalizedHorizontalBarChartElement build(int width, int height) {
		return new StackedNormalizedHorizontalBarChartElement(width, height);
	}
	private int width;
	private int height;
	private int marginTop = 20;
	private int marginBottom = 30;
	private int marginLeft = 40;
	private int marginRight = 20;
	private final Selection svg;
	private final Selection content;
	private final Selection top;
	private final Selection left;
	public StackedNormalizedHorizontalBarChartElement(int width, int height) {
		this.width = width;
		this.height = height;
		svg = D3.create("svg").attr("width", width).attr("height", height).attr("viewBox", new Object[]{0, 0, width, height});

		content = svg.append("g").selectAll("g")
				.data(null).enter()
				.append("g").attr("fill", "A");

		top = svg.append("g").attr("transform", "translate(0, " + marginTop + ")");
		left = svg.append("g").attr("transform", "translate(" + marginLeft + ", 0)");
	}
	public StackedNormalizedHorizontalBarChartElement values(List<Series> values) {
		return this;
	}
	@Override
	public HTMLElement element() {
		return null;
	}

	@Data
	@Accessors(fluent=true)
	public final static class Series {
		private String label;
		private Map<String, Double> value;
	}
}
