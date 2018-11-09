package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;


@Templated
public abstract class BounceLoader extends BaseLoader<BounceLoader> implements IsElement<HTMLDivElement> {

    @DataElement
    HTMLDivElement loadingText;

    @DataElement
    HTMLDivElement progress1;

    @DataElement
    HTMLDivElement progress2;

    @DataElement
    HTMLDivElement progress3;

    @PostConstruct
    void init() {
        init(this);
    }

    public static BounceLoader create() {
        return new Templated_BounceLoader();
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
        });
    }

    @Override
    public void removeLoadingText() {
        onAttached(mutationRecord -> loadingText.remove());
    }
}
