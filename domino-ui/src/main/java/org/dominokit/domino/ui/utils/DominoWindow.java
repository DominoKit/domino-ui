package org.dominokit.domino.ui.utils;

import elemental2.dom.CSSStyleDeclaration;
import elemental2.dom.Element;
import elemental2.dom.Window;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "window")
public class DominoWindow extends Window {
    public native CSSStyleDeclaration getComputedStyle(Element element);
}
