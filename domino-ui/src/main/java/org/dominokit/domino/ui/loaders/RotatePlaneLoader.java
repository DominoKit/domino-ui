package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.dominokit.domino.ui.loaders.LoaderStyles.*;
import static org.jboss.gwt.elemento.core.Elements.div;

public class RotatePlaneLoader extends BaseLoader<RotatePlaneLoader> implements IsElement<HTMLDivElement> {

    private HTMLDivElement progress1 = div().css(WAIT_ME_PROGRESS_ELEM_1).style("background-color:#555").element();

    private HTMLDivElement loader = div()
            .css(WAIT_ME_PROGRESS)
            .css(LoaderStyles.ROTATEPLANE)
            .add(progress1)
            .element();

    private HTMLDivElement content = div()
            .css(WAIT_ME_CONTENT)
            .css(Styles.vertical_center)
            .add(loader)
            .add(loadingText)
            .element();

    private HTMLDivElement element = div()
            .css(WAIT_ME)
            .style("background: rgba(255, 255, 255, 0.9);")
            .add(content)
            .element();

    public RotatePlaneLoader() {
        init(this);
    }

    public static RotatePlaneLoader create() {
        return new RotatePlaneLoader();
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
    public DominoElement<HTMLDivElement> getContentElement() {
        return DominoElement.of(content);
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }
}
