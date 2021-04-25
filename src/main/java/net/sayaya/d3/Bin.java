package net.sayaya.d3;

import elemental2.core.JsArray;
import jsinterop.annotations.*;
import jsinterop.base.Js;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Array")
public class Bin extends JsArray<Object> {
	public Double x0;
	public Double x1;
	public native ThresholdFunction thresholds(int size);
	public native ThresholdFunction thresholds(Double[] thresholds);

	@FunctionalInterface
	@JsFunction
	public interface ThresholdFunction {
		Bin[] apply(Object[] values);
	}
}
