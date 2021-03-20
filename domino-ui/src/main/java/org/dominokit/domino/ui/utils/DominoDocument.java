package org.dominokit.domino.ui.utils;

import elemental2.dom.Element;
import elemental2.dom.HTMLDocument;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Extending {@link HTMLDocument} to add functionality missing from elemental2
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class DominoDocument extends HTMLDocument {
    /**
     * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/activeElement">MDN activeElement</a>
     */
    public Element activeElement;

    /**
     * @deprecated this is deprecated in MDN
     * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/execCommand">MDN execCommand</a>
     * @param aCommandName String
     * @param aShowDefaultUI boolean
     * @param aValueArgument String
     */
    @Deprecated
    public native void execCommand(String aCommandName, boolean aShowDefaultUI, String aValueArgument);

    /**
     * @deprecated this is deprecated in MDN
     * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/execCommand">MDN execCommand</a>
     * @param aCommandName String
     */
    @Deprecated
    public native void execCommand(String aCommandName);
}
