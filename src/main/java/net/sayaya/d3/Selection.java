package net.sayaya.d3;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.*;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Selection extends D3 {
	public native Selection append(String tag);
	public native Selection join(String tag);
	public native Selection enter();
	public native Selection text(String text);
	public native Selection attr(String attr, Object value);
	public native Selection style(String attr, Object value);
	public native Selection call(D3 obj);
	public native Selection data(Bin[] bins);
	public native void remove();
	public native Selection clone();
	public native HTMLElement node();
}