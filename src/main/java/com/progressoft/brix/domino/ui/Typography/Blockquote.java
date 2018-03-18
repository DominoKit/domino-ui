package com.progressoft.brix.domino.ui.Typography;

import com.progressoft.brix.domino.ui.style.Styles;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import elemental2.dom.Text;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.blockquote;

public class Blockquote implements IsElement<HTMLElement>{

    private HTMLElement element=blockquote().css(Styles.m_b_25).asElement();
    private Paragraph paragraph=Paragraph.create();
    private HTMLElement footer;

    public Blockquote(){
        element.appendChild(paragraph.asElement());
    }

    public Blockquote(String text){
        this.paragraph.setText(text);
        element.appendChild(paragraph.asElement());
    }

    public Blockquote(Paragraph paragraph) {
        this.paragraph=paragraph;
        element.appendChild(paragraph.asElement());
    }

    public static Blockquote create(){
        return new Blockquote();
    }

    public static Blockquote create(String text){
        return new Blockquote(text);
    }

    public static Blockquote create(Paragraph paragraph){
        return new Blockquote(paragraph);
    }

    public Blockquote setText(String text){
        paragraph.setText(text);
        return this;
    }

    public Blockquote setFooterContent(Node content){
        if(nonNull(footer))
            footer.remove();

        footer=Elements.footer().add(content).asElement();
        element.appendChild(footer);

        return this;
    }

    public Blockquote setFooterText(String text){
        return setFooterContent(new Text(text));
    }

    public Blockquote reverse(){
        element.classList.remove(Styles.BLOCKQUOTE_REVERSE);
        element.classList.add(Styles.BLOCKQUOTE_REVERSE);
        return this;
    }

    public Blockquote appendFooterContent(Node content){
        if(isNull(footer))
            setFooterContent(content);
        else
            footer.appendChild(content);

        return this;
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }
}
