package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

@Templated
public abstract class RoundBounceLoader extends BaseLoader<RoundBounceLoader> implements IsElement<HTMLDivElement> {

    @DataElement
    HTMLDivElement loadingText;

    @DataElement
    HTMLDivElement loader;

    @PostConstruct
    void init(){
        init(this);
    }

    public static RoundBounceLoader create(){
        return new Templated_RoundBounceLoader();
    }

    @Override
    public void setLoadingText(String text) {
        loadingText.textContent=text;
    }

    @Override
    public void setSize(String width, String height) {
        onAttached(mutationRecord -> {
            Style.of(loader).setWidth(width).setHeight(height);
        });
    }

    @Override
    public void removeLoadingText() {
        onAttached(mutationRecord -> loadingText.remove());
    }
}
