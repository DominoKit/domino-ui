package org.dominokit.domino.ui.utils;

import elemental2.dom.CSSStyleDeclaration;
import elemental2.dom.Element;
import elemental2.dom.Window;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Extending {@link Window} to add functionality missing from elemental2
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "window")
public class DominoWindow extends Window {
    /**
     * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/getComputedStyle">MDN getComputedStyle</a>
     * @param element {@link Element}
     * @return the {@link CSSStyleDeclaration}
     */
    public native CSSStyleDeclaration getComputedStyle(Element element);
}
