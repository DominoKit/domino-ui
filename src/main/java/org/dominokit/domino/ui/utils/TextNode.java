package org.dominokit.domino.ui.utils;

import elemental2.dom.DomGlobal;
import elemental2.dom.Text;

import static java.util.Objects.isNull;

public class TextNode {

    public static Text empty() {
        return DomGlobal.document.createTextNode("");
    }

    public static Text of(String content) {
        if (isNull(content) || content.isEmpty()) {
            return empty();
        }
        return DomGlobal.document.createTextNode(content);
    }
}
