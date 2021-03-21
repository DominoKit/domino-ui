package org.dominokit.domino.ui.Typography;

import elemental2.dom.HTMLParagraphElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.p;

/**
 * A wrapper component for <strong>p</strong> HTML tag
 */
public class Paragraph extends BaseDominoElement<HTMLParagraphElement, Paragraph> {

    private final DominoElement<HTMLParagraphElement> element = DominoElement.of(p());
    private Color colorStyle;
    private String alignment = Styles.align_left;

    public Paragraph() {
        this(null);
    }

    public Paragraph(String text) {
        if (nonNull(text)) {
            setText(text);
        }
        init(this);
    }

    /**
     * @return new instance with empty text
     */
    public static Paragraph create() {
        return new Paragraph();
    }

    /**
     * @param text the value of the paragraph
     * @return new instance with empty text
     */
    public static Paragraph create(String text) {
        return new Paragraph(text);
    }

    /**
     * Sets the value of the paragraph
     *
     * @param text the value of the paragraph
     * @return same instnace
     */
    public Paragraph setText(String text) {
        element.setTextContent(text);
        return this;
    }

    /**
     * Sets the paragraph to have larger fonts on big screens.
     *
     * @return same instance
     */
    public Paragraph lead() {
        element.style().add(Styles.LEAD);
        return this;
    }

    /**
     * Sets the font color
     *
     * @param color the {@link Color}
     * @return same instance
     */
    public Paragraph setColor(Color color) {
        if (nonNull(colorStyle))
            element.style().remove(color.getStyle());

        this.colorStyle = color;
        element.style().add(colorStyle.getStyle());
        return this;
    }

    /**
     * @deprecated use {@link #appendChild(Node)}
     */
    @Deprecated
    public Paragraph appendContent(Node content) {
        element.appendChild(content);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLParagraphElement element() {
        return element.element();
    }

    /**
     * Sets the font to bold
     *
     * @return same instance
     */
    public Paragraph bold() {
        element.style().remove(Styles.font_bold);
        element.style().add(Styles.font_bold);
        return this;
    }

    /**
     * Sets the font to italic
     *
     * @return same instance
     */
    public Paragraph italic() {
        element.style().remove(Styles.font_italic);
        element.style().add(Styles.font_italic);
        return this;
    }

    /**
     * Sets the font to underline
     *
     * @return same instance
     */
    public Paragraph underLine() {
        element.style().remove(Styles.font_under_line);
        element.style().add(Styles.font_under_line);
        return this;
    }

    /**
     * Sets the font to overline
     *
     * @return same instance
     */
    public Paragraph overLine() {
        element.style().remove(Styles.font_over_line);
        element.style().add(Styles.font_over_line);
        return this;
    }

    /**
     * Sets the font to line through
     *
     * @return same instance
     */
    public Paragraph lineThrough() {
        element.style().remove(Styles.font_line_through);
        element.style().add(Styles.font_line_through);
        return this;
    }

    /**
     * Aligns the text to the left
     *
     * @return same instance
     */
    public Paragraph alignLeft() {
        return align(Styles.align_left);
    }

    /**
     * Aligns the text to the right
     *
     * @return same instance
     */
    public Paragraph alignRight() {
        return align(Styles.align_right);
    }

    /**
     * Aligns the text to the center
     *
     * @return same instance
     */
    public Paragraph alignCenter() {
        return align(Styles.align_center);
    }

    /**
     * Aligns the text to justify
     *
     * @return same instance
     */
    public Paragraph alignJustify() {
        return align(Styles.align_justify);
    }

    private Paragraph align(String alignment) {
        element.style().remove(this.alignment);
        element.style().add(alignment);
        this.alignment = alignment;
        return this;
    }
}
