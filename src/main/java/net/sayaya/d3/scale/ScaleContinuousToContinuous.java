package net.sayaya.d3.scale;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL)
public abstract class ScaleContinuousToContinuous extends Scale {
	public native ScaleContinuousToContinuous domain(Object[] param);
	public native ScaleContinuousToContinuous range(Object[] param);
	public native ScaleContinuousToContinuous nice();
}
