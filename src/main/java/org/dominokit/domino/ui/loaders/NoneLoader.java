package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class NoneLoader implements IsLoader {

    private HTMLDivElement loadingText = div().css("waitMe_text").style("color:#555;").asElement();

    private HTMLDivElement element = div()
            .css("waitMe")
            .style("background: rgba(255, 255, 255, 0.9);")
            .add(div()
                    .css("waitMe_content")
                    .style("margin-top: -18px;")
                    .add(loadingText)
            )
            .asElement();

    public static NoneLoader create() {
        return new NoneLoader();
    }

    @Override
    public void setLoadingText(String text) {
        loadingText.textContent = text;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
