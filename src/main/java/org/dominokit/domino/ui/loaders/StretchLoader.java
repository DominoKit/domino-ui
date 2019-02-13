package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

@Templated
public abstract class StretchLoader extends BaseLoader<StretchLoader> implements IsElement<HTMLDivElement> {

    @DataElement
    HTMLDivElement loadingText;

    @DataElement
    HTMLDivElement progress1;

    @DataElement
    HTMLDivElement progress2;

    @DataElement
    HTMLDivElement progress3;

    @DataElement
    HTMLDivElement progress4;

    @DataElement
    HTMLDivElement progress5;

    @PostConstruct
    void init() {
        init(this);
    }

    public static StretchLoader create() {
        return new Templated_StretchLoader();
    }

    @Override
    public void setLoadingText(String text) {
        loadingText.textContent = text;
    }

    @Override
    public void setSize(String width, String height) {
        onAttached(mutationRecord -> {
            Style.of(progress1).setWidth(width).setHeight(height);
            Style.of(progress2).setWidth(width).setHeight(height);
            Style.of(progress3).setWidth(width).setHeight(height);
            Style.of(progress4).setWidth(width).setHeight(height);
            Style.of(progress5).setWidth(width).setHeight(height);
        });
    }

    @Override
    public void removeLoadingText() {
        onAttached(mutationRecord -> loadingText.remove());
    }
}
