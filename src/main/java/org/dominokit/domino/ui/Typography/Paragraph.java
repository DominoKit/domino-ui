package org.dominokit.domino.ui.Typography;

import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import elemental2.dom.HTMLParagraphElement;
import elemental2.dom.Node;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.p;

public class Paragraph implements IsElement<HTMLParagraphElement>{

    private HTMLParagraphElement element=p().asElement();
    private Color colorStyle;
    private String alignment= Styles.align_left;

    public Paragraph(){

    }

    public Paragraph(String text){
        element.textContent=text;
    }

    public static Paragraph create(){
        return new Paragraph();
    }

    public static Paragraph create(String text){
        return new Paragraph(text);
    }

    public Paragraph setText(String text){
        element.textContent=text;
        return this;
    }

    public Paragraph lead(){
        element.classList.add(Styles.LEAD);
        return this;
    }

    public Paragraph setColor(Color color){
        if(nonNull(colorStyle))
            element.classList.remove(color.getStyle());

        this.colorStyle=color;
        element.classList.add(colorStyle.getStyle());
        return this;
    }

    public Paragraph appendContent(Node content){
        element.appendChild(content);
        return this;
    }

    @Override
    public HTMLParagraphElement asElement() {
        return element;
    }

    public Paragraph bold() {
        element.classList.remove(Styles.font_bold);
        element.classList.add(Styles.font_bold);
        return this;
    }

    public Paragraph italic() {
        element.classList.remove(Styles.font_italic);
        element.classList.add(Styles.font_italic);
        return this;
    }

    public Paragraph underLine() {
        element.classList.remove(Styles.font_under_line);
        element.classList.add(Styles.font_under_line);
        return this;
    }

    public Paragraph overLine() {
        element.classList.remove(Styles.font_over_line);
        element.classList.add(Styles.font_over_line);
        return this;
    }

    public Paragraph lineThrough() {
        element.classList.remove(Styles.font_line_through);
        element.classList.add(Styles.font_line_through);
        return this;
    }

    public Paragraph alignLeft(){
        return align(Styles.align_left);
    }

    public Paragraph alignRight(){
        return align(Styles.align_right);
    }

    public Paragraph alignCenter(){
        return align(Styles.align_center);
    }

    public Paragraph alignJustify(){
        return align(Styles.align_justify);
    }

    private Paragraph align(String alignment){
        element.classList.remove(this.alignment);
        element.classList.add(alignment);
        this.alignment=alignment;
        return this;
    }
}
