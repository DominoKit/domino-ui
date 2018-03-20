package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.Templated;

@Templated
public abstract class Overlay implements IsElement<HTMLDivElement>{

    public static Overlay create(){
        return new Templated_Overlay();
    }
}
