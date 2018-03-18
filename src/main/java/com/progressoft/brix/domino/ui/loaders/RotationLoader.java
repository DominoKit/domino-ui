package com.progressoft.brix.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

@Templated
public abstract class RotationLoader implements IsElement<HTMLDivElement>, IsLoader{

    @DataElement
    HTMLDivElement loadingText;

    public static RotationLoader create(){
        return new Templated_RotationLoader();
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
