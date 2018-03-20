package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

@Templated
public abstract class Section implements IsElement<HTMLElement> {
    @DataElement
    HTMLElement leftSide;

    @DataElement
    HTMLElement rightSide;

    public static Section create(){
        return new Templated_Section();
    }
}
