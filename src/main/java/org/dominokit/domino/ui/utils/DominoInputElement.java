package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLInputElement;
import org.jboss.gwt.elemento.core.IsElement;

public class DominoInputElement<E extends HTMLInputElement,T extends IsElement<E>> extends DominoElement<E,T> {

    public DominoInputElement<E,T> setValue(String value){
        asElement().value = value;
        return this;
    }

    public String getValue(){
        return asElement().value;
    }

    public DominoInputElement<E,T> focus(){
        asElement().focus();
        return this;
    }

}
