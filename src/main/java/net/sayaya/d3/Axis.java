package net.sayaya.d3;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public final class Axis extends D3 {
	public native Axis ticks(double tick);
	public native Axis tickSize(double tick);
	public native Axis tickArguments(Object arg);
	public native Axis tickValues(Object[] ticks);
	public native Axis tickFormat(Object arg);
	public native Axis tickSizeOuter(double tickSizeOuter);
}
