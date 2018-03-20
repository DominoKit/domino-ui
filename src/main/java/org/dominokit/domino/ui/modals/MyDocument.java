package org.dominokit.domino.ui.modals;

import elemental2.dom.Element;
import elemental2.dom.HTMLDocument;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class MyDocument extends HTMLDocument {
    public Element activeElement;
}
