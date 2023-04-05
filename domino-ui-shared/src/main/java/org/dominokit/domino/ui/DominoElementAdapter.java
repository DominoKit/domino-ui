package org.dominokit.domino.ui;

import elemental2.dom.CSSStyleDeclaration;
import elemental2.dom.Element;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Element", namespace = JsPackage.GLOBAL)
public class DominoElementAdapter extends Element {
    public CSSStyleDeclaration style;
    public int tabIndex;
}
