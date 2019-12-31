package org.dominokit.domino.ui.Typography;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLQuoteElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.blockquote;
import static org.jboss.gwt.elemento.core.Elements.footer;

public class Blockquote extends BaseDominoElement<HTMLElement, Blockquote> {

    private DominoElement<HTMLQuoteElement> element = DominoElement.of(blockquote().css(Styles.m_b_25));
    private Paragraph paragraph = Paragraph.create();
    private DominoElement<HTMLElement> footer;

    public Blockquote() {
        element.appendChild(paragraph);
        init(this);
    }

    public Blockquote(String text) {
        this.paragraph.setText(text);
        element.appendChild(paragraph);
        init(this);
    }

    public Blockquote(Paragraph paragraph) {
        this.paragraph = paragraph;
        element.appendChild(paragraph);
        init(this);
    }

    public static Blockquote create() {
        return new Blockquote();
    }

    public static Blockquote create(String text) {
        return new Blockquote(text);
    }

    public static Blockquote create(Paragraph paragraph) {
        return new Blockquote(paragraph);
    }

    public Blockquote setText(String text) {
        paragraph.setText(text);
        return this;
    }

    public Blockquote setFooterContent(Node content) {
        if (nonNull(footer))
            footer.remove();

        footer = DominoElement.of(footer().add(content));
        element.appendChild(footer);
        return this;
    }

    public Blockquote setFooterText(String text) {
        return setFooterContent(TextNode.of(text));
    }

    public Blockquote reverse() {
        element.style().remove(Styles.BLOCKQUOTE_REVERSE);
        element.style().add(Styles.BLOCKQUOTE_REVERSE);
        return this;
    }

    /**
     * @deprecated use {@link #appendFooterChild(Node)}
     */
    @Deprecated
    public Blockquote appendFooterContent(Node content) {
        return appendFooterChild(content);
    }

    public Blockquote appendFooterChild(Node content) {
        if (isNull(footer))
            setFooterContent(content);
        else
            footer.appendChild(content);

        return this;
    }

    public Blockquote appendFooterChild(IsElement content) {
        return appendFooterChild(content.element());
    }

    @Override
    public HTMLElement element() {
        return element.element();
    }
}
