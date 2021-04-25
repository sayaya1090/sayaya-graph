package net.sayaya.d3;

import elemental2.core.JsArray;
import jsinterop.annotations.*;
import jsinterop.base.Js;

@JsType(namespace = JsPackage.GLOBAL)
public class Bin extends JsArray<Object> {
	public native ThresholdFunction thresholds(int size);
	public native ThresholdFunction thresholds(Double[] thresholds);
	public static Object x0(Object bin) {
		return Js.asPropertyMap(bin).get("x0");
	}
	public static Object x1(Object bin) {
		return Js.asPropertyMap(bin).get("x1");
	}

	@FunctionalInterface
	@JsFunction
	public interface ThresholdFunction {
		Bin[] apply(Object[] values);
	}
}
