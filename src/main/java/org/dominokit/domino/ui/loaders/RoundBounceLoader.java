package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class RoundBounceLoader implements IsLoader{

    private HTMLDivElement loadingText=div().css("waitMe_text").style("color:#555").textContent("Loading...").asElement();

    private final HTMLDivElement element = div()
            .css("waitMe")
            .style("background: rgba(255, 255, 255, 0.9);")
            .add(div()
                    .css("waitMe_content")
                    .style("margin-top: -48px;")
                    .add(div()
                            .css("waitMe_progress", "roundBounce")
                            .style("")
                            .add(div().css("waitMe_progress_elem1").style("background-color:#555;").asElement())
                            .add(div().css("waitMe_progress_elem2").style("background-color:#555;").asElement())
                            .add(div().css("waitMe_progress_elem3").style("background-color:#555;").asElement())
                            .add(div().css("waitMe_progress_elem4").style("background-color:#555;").asElement())
                            .add(div().css("waitMe_progress_elem5").style("background-color:#555;").asElement())
                            .add(div().css("waitMe_progress_elem6").style("background-color:#555;").asElement())
                            .add(div().css("waitMe_progress_elem7").style("background-color:#555;").asElement())
                            .add(div().css("waitMe_progress_elem8").style("background-color:#555;").asElement())
                            .add(div().css("waitMe_progress_elem9").style("background-color:#555;").asElement())
                            .add(div().css("waitMe_progress_elem10").style("background-color:#555;").asElement())
                            .add(div().css("waitMe_progress_elem11").style("background-color:#555;").asElement())
                            .add(div().css("waitMe_progress_elem12").style("background-color:#555;").asElement())
                            .asElement())
                    .add(loadingText)
                    .asElement()
            )
            .asElement();

    public static RoundBounceLoader create(){
        return new RoundBounceLoader();
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
