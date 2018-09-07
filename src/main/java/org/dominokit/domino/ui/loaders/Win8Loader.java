package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

@Templated
public abstract class Win8Loader extends BaseDominoElement<HTMLDivElement, Win8Loader> implements IsLoader, IsElement<HTMLDivElement>{

    @DataElement
    HTMLDivElement loadingText;

    @PostConstruct
    void init(){
        init(this);
    }

    public static Win8Loader create(){
        return new Templated_Win8Loader();
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
