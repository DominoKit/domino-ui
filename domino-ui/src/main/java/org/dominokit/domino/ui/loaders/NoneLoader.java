package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.dominokit.domino.ui.loaders.LoaderStyles.WAIT_ME;
import static org.dominokit.domino.ui.loaders.LoaderStyles.WAIT_ME_CONTENT;
import static org.jboss.gwt.elemento.core.Elements.div;

public class NoneLoader extends BaseLoader<NoneLoader> implements IsElement<HTMLDivElement> {

    private HTMLDivElement content = div()
            .css(WAIT_ME_CONTENT)
            .css(Styles.vertical_center)
            .style("margin-top: -18px;")
            .add(loadingText)
            .asElement();

    private HTMLDivElement element = div()
            .css(WAIT_ME)
            .style("background: rgba(255, 255, 255, 0.9);")
            .add(content)
            .asElement();

    public NoneLoader() {
        init(this);
    }

    public static NoneLoader create() {
        return new NoneLoader();
    }

    @Override
    public void setLoadingText(String text) {
        loadingText.textContent = text;
    }

    @Override
    public void setSize(String width, String height) {
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
