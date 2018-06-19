package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.section;

public class Content implements IsElement<HTMLElement>{

    private HTMLDivElement contentContainer=div().css("content-panel").asElement();
    private HTMLElement element=section()
            .css("content")
            .add(contentContainer)
            .asElement();

    public static Content create(){
        return new Content();
    }

    public HTMLDivElement getContentContainer() {
        return contentContainer;
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }
}
