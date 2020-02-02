package org.dominokit.domino.ui.progress;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class Progress extends BaseDominoElement<HTMLDivElement, Progress> {

    private HTMLDivElement element=div().css(ProgressStyles.progress).element();

    public Progress() {
        init(this);
    }

    public static Progress create(){
        return new Progress();
    }

    /**
     * @deprecated use {@link #appendChild(ProgressBar)}
     */
    @Deprecated
    public Progress addBar(ProgressBar bar){
       return appendChild(bar);
    }

    public Progress appendChild(ProgressBar bar){
        element.appendChild(bar.element());
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }

}
