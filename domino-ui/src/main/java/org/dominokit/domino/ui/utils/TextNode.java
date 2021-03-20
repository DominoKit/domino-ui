package org.dominokit.domino.ui.utils;

import elemental2.dom.DomGlobal;
import elemental2.dom.Text;

import static java.util.Objects.isNull;

/**
 * A static factory class to create DOM text nodes
 */
public class TextNode {

    /**
     *
     * @return new empty {@link Text} node
     */
    public static Text empty() {
        return DomGlobal.document.createTextNode("");
    }

    /**
     *
     * @param content String content of the node
     * @return new {@link Text} node with the provided text content
     */
    public static Text of(String content) {
        if (isNull(content) || content.isEmpty()) {
            return empty();
        }
        return DomGlobal.document.createTextNode(content);
    }
}
