package net.sayaya.d3;

import elemental2.dom.Element;
import jsinterop.annotations.*;
import net.sayaya.d3.scale.*;

@JsType(namespace = JsPackage.GLOBAL, name="d3")
public class D3 {
	public static native Selection create(String tag);
	public static native Selection select(Element elem);
	public native Selection selectAll(String tag);
	public static native ScaleLinear scaleLinear();

	public static native Axis axisLeft(Scale scale);
	public static native Axis axisRight(Scale scale);
	public static native Axis axisBottom(Scale scale);
	public static native Axis axisTop(Scale scale);

	public static native Bin bin();

	public static native Object max(Object[] objs);
	public static native Object max(Object[] objs, Function<?, ?> func);
	public static native Object min(Object[] objs);
	public static native Object min(Object[] objs, Function<?, ?> func);

	public static native Color color(String color);
	@FunctionalInterface
	@JsFunction
	public interface Function<T, U> {
		U apply(T t);
	}
}
