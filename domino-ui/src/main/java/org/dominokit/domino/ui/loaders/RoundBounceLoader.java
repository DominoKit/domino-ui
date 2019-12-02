package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.dominokit.domino.ui.loaders.LoaderStyles.*;
import static org.jboss.gwt.elemento.core.Elements.div;

public class RoundBounceLoader extends BaseLoader<RoundBounceLoader> implements IsElement<HTMLDivElement> {

    private HTMLDivElement progress1 = div().css(WAIT_ME_PROGRESS_ELEM_1).style("background-color:#555;").element();
    private HTMLDivElement progress2 = div().css(WAIT_ME_PROGRESS_ELEM_2).style("background-color:#555;").element();
    private HTMLDivElement progress3 = div().css(WAIT_ME_PROGRESS_ELEM_3).style("background-color:#555;").element();
    private HTMLDivElement progress4 = div().css(WAIT_ME_PROGRESS_ELEM_4).style("background-color:#555;").element();
    private HTMLDivElement progress5 = div().css(WAIT_ME_PROGRESS_ELEM_5).style("background-color:#555;").element();
    private HTMLDivElement progress6 = div().css(WAIT_ME_PROGRESS_ELEM_6).style("background-color:#555;").element();
    private HTMLDivElement progress7 = div().css(WAIT_ME_PROGRESS_ELEM_7).style("background-color:#555;").element();
    private HTMLDivElement progress8 = div().css(WAIT_ME_PROGRESS_ELEM_8).style("background-color:#555;").element();
    private HTMLDivElement progress9 = div().css(WAIT_ME_PROGRESS_ELEM_9).style("background-color:#555;").element();
    private HTMLDivElement progress10 = div().css(WAIT_ME_PROGRESS_ELEM_10).style("background-color:#555;").element();
    private HTMLDivElement progress11 = div().css(WAIT_ME_PROGRESS_ELEM_11).style("background-color:#555;").element();
    private HTMLDivElement progress12 = div().css(WAIT_ME_PROGRESS_ELEM_12).style("background-color:#555;").element();

    private HTMLDivElement loader = div()
            .css(WAIT_ME_PROGRESS)
            .css(ROUND_BOUNCE)
            .add(progress1)
            .add(progress2)
            .add(progress3)
            .add(progress4)
            .add(progress5)
            .add(progress6)
            .add(progress7)
            .add(progress8)
            .add(progress9)
            .add(progress10)
            .add(progress11)
            .add(progress12)
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

    public RoundBounceLoader() {
        init(this);
    }

    public static RoundBounceLoader create() {
        return new RoundBounceLoader();
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
