package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

@Templated
public abstract class Content implements IsElement<HTMLElement>{

    @DataElement
    HTMLDivElement contentContainer;

    public static Content create(){
        return new Templated_Content();
    }
}
