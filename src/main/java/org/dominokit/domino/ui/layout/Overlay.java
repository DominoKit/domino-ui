package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

@Templated
public abstract class Overlay extends DominoElement<HTMLDivElement, Overlay> implements IsElement<HTMLDivElement>{

    @PostConstruct
    void init(){
        init(this);
    }

    public static Overlay create(){
        return new Templated_Overlay();
    }
}
