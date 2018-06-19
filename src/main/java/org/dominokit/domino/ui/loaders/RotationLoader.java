package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class RotationLoader implements IsLoader{

    private HTMLDivElement loadingText=div().css("waitMe_text").style("color:#555").textContent("Loading...").asElement();

    private final HTMLDivElement element = div()
            .css("waitMe")
            .style("background: rgba(255, 255, 255, 0.9);")
            .add(div()
                    .css("waitMe_content")
                    .style("margin-top: -48px;")
                    .add(div()
                            .css("waitMe_progress", "rotation")
                            .style("")
                            .add(div().css("waitMe_progress_elem1").style("border-color:#555;").asElement())
                            .asElement())
                    .add(loadingText)
                    .asElement()
            )
            .asElement();

    public static RotationLoader create(){
        return new RotationLoader();
    }

    @Override
    public void setLoadingText(String text) {
        loadingText.textContent=text;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
