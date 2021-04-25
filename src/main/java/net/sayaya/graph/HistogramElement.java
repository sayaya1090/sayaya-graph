package net.sayaya.graph;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import net.sayaya.d3.D3;
import net.sayaya.d3.Selection;
import org.jboss.elemento.ElementBuilder;
import org.jboss.elemento.IsElement;

public class HistogramElement implements IsElement<HTMLElement> {
	public static HistogramElement build(int width, int height) {
		return new HistogramElement(width, height);
	}
	private int width = 300;
	private int height = 250;
	private int marginTop = 20;
	private int marginBottom = 30;
	private int marginLeft = 40;
	private int marginRight = 20;
	private int tick = 40;
	private String color = "steelblue";
	private Selection svg;
	private HistogramElement(int width, int height) {
		svg = D3.create("svg").attr("viewBox", new Object[]{0, 0, width*5, height*5});
	}

	@Override
	public HTMLElement element() {
		return svg.node();
	}
}
