package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class BounceLoader implements IsLoader {

    private HTMLDivElement loadingText = div()
            .css("waitMe_text")
            .style("color:#555;")
            .textContent("Loading...")
            .asElement();

    private final HTMLDivElement element = div()
            .css("waitMe")
            .style("background: rgba(255, 255, 255, 0.9);")
            .add(div()
                    .css("waitMe_content")
                    .style("margin-top: -28px;")
                    .add(div().css("waitMe_progress", "bounce")
                            .style("")
                            .add(div().css("waitMe_progress_elem1").style("background-color:#555;"))
                            .add(div().css("waitMe_progress_elem2").style("background-color:#555;"))
                            .add(div().css("waitMe_progress_elem3").style("background-color:#555;"))
                    )
                    .add(loadingText)
            )
            .asElement();

    public static BounceLoader create() {
        return new BounceLoader();
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
