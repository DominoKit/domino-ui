package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

@Templated
public abstract class RotatePlaneLoader implements IsElement<HTMLDivElement>, IsLoader{

    @DataElement
    HTMLDivElement loadingText;

    public static RotatePlaneLoader create(){
        return new Templated_RotatePlaneLoader();
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
