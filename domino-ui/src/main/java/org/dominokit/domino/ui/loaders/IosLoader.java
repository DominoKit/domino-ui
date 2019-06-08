package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.dominokit.domino.ui.loaders.LoaderStyles.*;
import static org.jboss.gwt.elemento.core.Elements.div;

public class IosLoader extends BaseLoader<IosLoader> implements IsElement<HTMLDivElement> {

    private HTMLDivElement progress1 = div().css(WAIT_ME_PROGRESS_ELEM_1).style("background-color:#555").asElement();
    private HTMLDivElement progress2 = div().css(WAIT_ME_PROGRESS_ELEM_2).style("background-color:#555").asElement();
    private HTMLDivElement progress3 = div().css(WAIT_ME_PROGRESS_ELEM_3).style("background-color:#555").asElement();
    private HTMLDivElement progress4 = div().css(WAIT_ME_PROGRESS_ELEM_4).style("background-color:#555").asElement();
    private HTMLDivElement progress5 = div().css(WAIT_ME_PROGRESS_ELEM_5).style("background-color:#555").asElement();
    private HTMLDivElement progress6 = div().css(WAIT_ME_PROGRESS_ELEM_6).style("background-color:#555").asElement();
    private HTMLDivElement progress7 = div().css(WAIT_ME_PROGRESS_ELEM_7).style("background-color:#555").asElement();
    private HTMLDivElement progress8 = div().css(WAIT_ME_PROGRESS_ELEM_8).style("background-color:#555").asElement();
    private HTMLDivElement progress9 = div().css(WAIT_ME_PROGRESS_ELEM_9).style("background-color:#555").asElement();
    private HTMLDivElement progress10 = div().css(WAIT_ME_PROGRESS_ELEM_10).style("background-color:#555").asElement();
    private HTMLDivElement progress11 = div().css(WAIT_ME_PROGRESS_ELEM_11).style("background-color:#555").asElement();
    private HTMLDivElement progress12 = div().css(WAIT_ME_PROGRESS_ELEM_12).style("background-color:#555").asElement();

    private HTMLDivElement loader = div()
            .css(WAIT_ME_PROGRESS)
            .css(IOS)
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
            .asElement();

    private HTMLDivElement content = div()
            .css(WAIT_ME_CONTENT)
            .css(Styles.vertical_center)
            .add(div()
                    .add(loader)
                    .add(loadingText)
            ).asElement();

    private HTMLDivElement element = div()
            .css(WAIT_ME)
            .style("background: rgba(255, 255, 255, 0.9);")
            .add(content)
            .asElement();

    public IosLoader() {
        init(this);
    }

    public static IosLoader create() {
        return new IosLoader();
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
    public HTMLDivElement asElement() {
        return element;
    }
}
