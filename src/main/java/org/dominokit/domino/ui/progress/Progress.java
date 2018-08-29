package org.dominokit.domino.ui.progress;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class Progress extends DominoElement<Progress> implements IsElement<HTMLDivElement>{

    private HTMLDivElement element=div().css("progress").asElement();

    public Progress() {
        initCollapsible(this);
    }

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

    public Style<HTMLDivElement, Progress> style(){
        return Style.of(this);
    }
}
