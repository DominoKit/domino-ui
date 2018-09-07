package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

@Templated
public abstract class TimerLoader extends BaseDominoElement<HTMLDivElement, TimerLoader> implements IsLoader, IsElement<HTMLDivElement> {

    @DataElement
    HTMLDivElement loadingText;

    @PostConstruct
    void init(){
        init(this);
    }

    public static TimerLoader create(){
        return new Templated_TimerLoader();
    }

    @Override
    public HTMLDivElement getElement() {
        return this.asElement();
    }

    @Override
    public void setLoadingText(String text) {
        loadingText.textContent=text;
    }
}
