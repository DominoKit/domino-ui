package org.dominokit.domino.ui.masking;

import elemental2.dom.HTMLInputElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "HTMLInputElement")
public class HTMLInputElementWithSelection extends HTMLInputElement {
    public int selectionStart;
    public int selectionEnd;
}
