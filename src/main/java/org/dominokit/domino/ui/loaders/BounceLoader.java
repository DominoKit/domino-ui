package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.jboss.gwt.elemento.core.IsElement;

import static org.dominokit.domino.ui.loaders.LoaderStyles.*;
import static org.jboss.gwt.elemento.core.Elements.div;

public class BounceLoader extends BaseLoader<BounceLoader> implements IsElement<HTMLDivElement> {

    private HTMLDivElement progress1 = div().css(WAIT_ME_PROGRESS_ELEM_1).style("background-color:#555;").asElement();
    private HTMLDivElement progress2 = div().css(WAIT_ME_PROGRESS_ELEM_2).style("background-color:#555;").asElement();
    private HTMLDivElement progress3 = div().css(WAIT_ME_PROGRESS_ELEM_3).style("background-color:#555;").asElement();

    private HTMLDivElement loader = div()
            .css(WAIT_ME_PROGRESS)
            .css(BOUNCE)
            .add(progress1)
            .add(progress2)
            .add(progress3)
            .asElement();

    private final HTMLDivElement element = div()
            .css(WAIT_ME)
            .style("background: rgba(255, 255, 255, 0.9);")
            .add(div()
                    .css(WAIT_ME_CONTENT)
                    .css(Styles.vertical_center)
                    .add(loader)
                    .add(loadingText)
            )
            .asElement();

    public BounceLoader() {
        init(this);
    }

    public static BounceLoader create() {
        return new BounceLoader();
    }

    @Override
    public void setLoadingText(String text) {
        loadingText.textContent = text;
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

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}