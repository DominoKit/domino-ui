package org.dominokit.domino.ui.utils;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "window", namespace = JsPackage.GLOBAL)
public class MyDom {
  public static MyDocument document;
}
