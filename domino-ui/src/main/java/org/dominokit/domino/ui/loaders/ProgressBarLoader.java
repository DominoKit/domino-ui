package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.dominokit.domino.ui.loaders.LoaderStyles.*;
import static org.jboss.gwt.elemento.core.Elements.div;

public class ProgressBarLoader extends BaseLoader<ProgressBarLoader> implements IsElement<HTMLDivElement> {

    private HTMLDivElement progress1 = div().css(WAIT_ME_PROGRESS_ELEM_1).style("background-color:#000").element();

    private HTMLDivElement loader = div()
            .css(WAIT_ME_PROGRESS)
            .css(PROGRESS_BAR)
            .add(progress1)
            .element();

    private HTMLDivElement content = div()
            .css(WAIT_ME_CONTENT)
            .css(Styles.vertical_center)
            .css(VERTICAL)
            .add(loader)
            .add(loadingText)
            .element();

    private HTMLDivElement element = div()
            .css(WAIT_ME)
            .style("background: rgba(255, 255, 255, 0.7);")
            .add(content)
            .element();

    public ProgressBarLoader() {
        init(this);
    }

    public static ProgressBarLoader create() {
        return new ProgressBarLoader();
    }

    @Override
    public void setLoadingText(String text) {
        loadingText.textContent = text;
    }

    @Override
    public void setSize(String width, String height) {
        onAttached(mutationRecord -> Style.of(loader).setWidth(width).setHeight(height));
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
