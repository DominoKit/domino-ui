package com.progressoft.brix.domino.ui.progress;

import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class Progress implements IsElement<HTMLDivElement>{

    private HTMLDivElement element=div().css("progress").asElement();


    public static Progress create(){
        return new Progress();
    }

    public Progress addBar(ProgressBar bar){
        element.appendChild(bar.asElement());
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
