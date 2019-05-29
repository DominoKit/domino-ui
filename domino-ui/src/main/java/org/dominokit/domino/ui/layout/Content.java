package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.section;

public class Content extends BaseDominoElement<HTMLElement, Content> {

    HTMLDivElement contentContainer;
    HTMLElement section;

    public Content() {
        contentContainer = div().css(LayoutStyles.CONTENT_PANEL).asElement();
        section = section()
                .css(LayoutStyles.CONTENT)
                .add(contentContainer)
                .asElement();
        init(this);
    }

    public static Content create(){
        return new Content();
    }

    @Override
    public HTMLElement asElement() {
        return section;
    }
}
