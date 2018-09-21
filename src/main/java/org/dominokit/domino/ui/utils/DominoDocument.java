package org.dominokit.domino.ui.utils;

import elemental2.dom.Element;
import elemental2.dom.HTMLDocument;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class DominoDocument extends HTMLDocument {
    public Element activeElement;
    public native void execCommand(String aCommandName, boolean aShowDefaultUI, String aValueArgument);
    public native void execCommand(String aCommandName);
}
