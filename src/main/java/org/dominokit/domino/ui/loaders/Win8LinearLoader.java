package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class Win8LinearLoader implements IsLoader{

    private HTMLDivElement loadingText = div().css("waitMe_text").style("color:#555").textContent("Loading...").asElement();

    private final HTMLDivElement element = div()
            .css("waitMe")
            .style("background: rgba(255, 255, 255, 0.9);")
            .add(div()
                    .css("waitMe_content")
                    .style("margin-top: -21px;")
                    .add(div()
                            .css("waitMe_progress", "win8_linear")
                            .style("")
                            .add(div().css("waitMe_progress_elem1").add(div().style("background-color:#555;")))
                            .add(div().css("waitMe_progress_elem2").add(div().style("background-color:#555;")))
                            .add(div().css("waitMe_progress_elem3").add(div().style("background-color:#555;")))
                            .add(div().css("waitMe_progress_elem4").add(div().style("background-color:#555;")))
                            .add(div().css("waitMe_progress_elem5").add(div().style("background-color:#555;")))
                            .asElement())
                    .add(loadingText)
                    .asElement()
            )
            .asElement();

    public static Win8LinearLoader create() {
        return new Win8LinearLoader();
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
