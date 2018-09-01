package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

@Templated
public abstract class RoundBounceLoader extends DominoElement<HTMLDivElement, RoundBounceLoader> implements IsElement<HTMLDivElement>, IsLoader{

    @DataElement
    HTMLDivElement loadingText;

    @PostConstruct
    void init(){
        init(this);
    }

    public static RoundBounceLoader create(){
        return new Templated_RoundBounceLoader();
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
