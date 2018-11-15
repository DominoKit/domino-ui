package org.dominokit.domino.ui.utils;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class NumberFormat {
    public native String format(Double number);
}
