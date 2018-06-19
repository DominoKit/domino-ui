package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.aside;
import static org.jboss.gwt.elemento.core.Elements.section;

public class Section implements IsElement<HTMLElement> {

    private HTMLElement leftSide=aside()
            .attr("id", "leftsidebar")
            .css("sidebar")
            .asElement();

    private HTMLElement rightSide=aside()
            .attr("id", "rightsidebar")
            .css("right-sidebar", "overlay-open")
            .style("right: 0px !important; height: calc(vh - 70px); overflow-y: scroll;")
            .asElement();

    private HTMLElement element=section()
            .add(leftSide)
            .add(rightSide)
            .asElement();

    public static Section create(){
        return new Section();
    }

    public HTMLElement getLeftSide() {
        return leftSide;
    }

    public HTMLElement getRightSide() {
        return rightSide;
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }
}
