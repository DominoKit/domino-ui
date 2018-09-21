package org.dominokit.domino.ui.utils;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "window", namespace = JsPackage.GLOBAL)
public class DominoDom {
  public static DominoDocument document;
  public static DominoWindow window;

}
