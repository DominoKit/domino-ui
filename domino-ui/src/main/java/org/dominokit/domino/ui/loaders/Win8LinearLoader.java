package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

import static org.dominokit.domino.ui.loaders.LoaderStyles.*;
import static org.jboss.elemento.Elements.div;

public class Win8LinearLoader extends BaseLoader<Win8LinearLoader> implements IsElement<HTMLDivElement> {

    private HTMLDivElement progress1 = div().css(WAIT_ME_PROGRESS_ELEM_1)
            .add(div().style("background-color:#555"))
            .element();
    private HTMLDivElement progress2 = div().css(WAIT_ME_PROGRESS_ELEM_2)
            .add(div().style("background-color:#555"))
            .element();
    private HTMLDivElement progress3 = div().css(WAIT_ME_PROGRESS_ELEM_3)
            .add(div().style("background-color:#555"))
            .element();
    private HTMLDivElement progress4 = div().css(WAIT_ME_PROGRESS_ELEM_4)
            .add(div().style("background-color:#555"))
            .element();
    private HTMLDivElement progress5 = div().css(WAIT_ME_PROGRESS_ELEM_5)
            .add(div().style("background-color:#555"))
            .element();

    private HTMLDivElement loader = div()
            .css(WAIT_ME_PROGRESS)
            .css(WIN_8_LINEAR)
            .add(progress1)
            .add(progress2)
            .add(progress3)
            .add(progress4)
            .add(progress5)
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

    public Win8LinearLoader() {
        init(this);
    }

    public static Win8LinearLoader create() {
        return new Win8LinearLoader();
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
