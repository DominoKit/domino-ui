package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

@Templated
public abstract class Content extends DominoElement<HTMLElement, Content> implements IsElement<HTMLElement>{

    @DataElement
    HTMLDivElement contentContainer;

    @PostConstruct
    void init(){
        init(this);
    }

    public static Content create(){
        return new Templated_Content();
    }
}
