package com.progressoft.brix.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

@Templated
public abstract class StretchLoader implements IsElement<HTMLDivElement>, IsLoader{

    @DataElement
    HTMLDivElement loadingText;

    public static StretchLoader create(){
        return new Templated_StretchLoader();
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
