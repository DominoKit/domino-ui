package org.dominokit.domino.ui.preloaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

@Templated
public abstract class Preloader extends BaseDominoElement<HTMLDivElement, Preloader> implements IsElement<HTMLDivElement> {

    @DataElement
    HTMLDivElement spinnerLayer;

    private Size size=Size.large;
    private Color color=Color.RED;

    @PostConstruct
    void init(){
        init(this);
    }

    public static Preloader create(){
        return new Templated_Preloader();
    }

    public Preloader setSize(Size size){
        style().remove(this.size.style);
        this.size=size;
        style().add(this.size.style);
        return this;
    }


    public Preloader setColor(Color color){
        spinnerLayer.classList.remove(this.color.getStyle().replace("col-","pl-"));
        this.color=color;
        spinnerLayer.classList.add(this.color.getStyle().replace("col-","pl-"));
        return this;
    }

    public Preloader stop(){
        asElement().remove();
        return this;
    }

    public enum Size{
        xLarge("pl-size-xl"),
        large("pl-size-l"),
        medium("pl-size-md"),
        small("pl-size-sm"),
        xSmall("pl-size-xs");

        private String style;

        Size(String style) {
            this.style = style;
        }
    }
}
