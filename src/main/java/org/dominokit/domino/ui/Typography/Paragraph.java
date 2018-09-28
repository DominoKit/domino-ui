package org.dominokit.domino.ui.Typography;

import elemental2.dom.HTMLParagraphElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.p;

public class Paragraph extends BaseDominoElement<HTMLParagraphElement, Paragraph> {

    private DominoElement<HTMLParagraphElement> element = DominoElement.of(p());
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

    public static Paragraph create() {
        return new Paragraph();
    }

    public static Paragraph create(String text) {
        return new Paragraph(text);
    }

    public Paragraph setText(String text) {
        element.setTextContent(text);
        return this;
    }

    public Paragraph lead() {
        element.style().add(Styles.LEAD);
        return this;
    }

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

    @Override
    public HTMLParagraphElement asElement() {
        return element.asElement();
    }

    public Paragraph bold() {
        element.style().remove(Styles.font_bold);
        element.style().add(Styles.font_bold);
        return this;
    }

    public Paragraph italic() {
        element.style().remove(Styles.font_italic);
        element.style().add(Styles.font_italic);
        return this;
    }

    public Paragraph underLine() {
        element.style().remove(Styles.font_under_line);
        element.style().add(Styles.font_under_line);
        return this;
    }

    public Paragraph overLine() {
        element.style().remove(Styles.font_over_line);
        element.style().add(Styles.font_over_line);
        return this;
    }

    public Paragraph lineThrough() {
        element.style().remove(Styles.font_line_through);
        element.style().add(Styles.font_line_through);
        return this;
    }

    public Paragraph alignLeft() {
        return align(Styles.align_left);
    }

    public Paragraph alignRight() {
        return align(Styles.align_right);
    }

    public Paragraph alignCenter() {
        return align(Styles.align_center);
    }

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
