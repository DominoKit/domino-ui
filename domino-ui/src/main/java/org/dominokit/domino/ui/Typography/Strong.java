package org.dominokit.domino.ui.Typography;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.elemento.Elements.strong;

/**
 * A wrapper component for <strong>strong</strong> HTML tag
 */
public class Strong extends BaseDominoElement<HTMLElement, Strong> {

    private final HTMLElement element = strong().element();

    public Strong(String text) {
        element.textContent = text;
        init(this);
    }

    /**
     * Creates new instance with text
     *
     * @param text the value
     * @return new instance
     */
    public static Strong of(String text) {
        return new Strong(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return element;
    }
}
