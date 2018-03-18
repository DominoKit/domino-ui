package com.progressoft.brix.domino.ui.style;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Waves {

    @JsMethod(namespace = "Waves")
    public static native void init();
}