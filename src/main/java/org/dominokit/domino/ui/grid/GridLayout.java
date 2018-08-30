package org.dominokit.domino.ui.grid;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class GridLayout implements IsElement<HTMLDivElement> {

    private HTMLDivElement element = div()
            .css("layout-grid").asElement();

    private final HTMLDivElement contentElement = div().css("layout-content").asElement();
    private final HTMLDivElement headerElement = div().css("layout-header").asElement();
    private final HTMLDivElement footerElement = div().css("layout-footer").asElement();
    private final HTMLDivElement leftElement = div().css("layout-left").asElement();
    private final HTMLDivElement rightElement = div().css("layout-right").asElement();

    private GridLayoutEditor editor = new GridLayoutEditor();

    public GridLayout() {
        element.appendChild(contentElement);
        updateGridLayout();
    }

    private void updateGridLayout() {
        Style.of(element).setProperty("grid-template-areas", editor.gridAreasAsString());
    }

    public static GridLayout create() {
        return new GridLayout();
    }

    public GridLayout setGap(String gap) {
        Style.of(element).setProperty("grid-gap", gap);
        return this;
    }

    public GridLayout addHeader() {
        return addHeader(SectionSpan._1);
    }

    public GridLayout addHeader(SectionSpan sectionSpan) {
        editor.addHeader(sectionSpan);
        element.appendChild(headerElement);
        updateGridLayout();

        return this;
    }

    public GridLayout removeHeader() {
        editor.removeHeader();
        headerElement.remove();
        updateGridLayout();

        return this;
    }

    public GridLayout addRight() {
        return addRight(SectionSpan._3, false, false);
    }

    public GridLayout addRight(SectionSpan sectionSpan, boolean spanUp, boolean spanDown) {
        editor.addRight(sectionSpan, spanUp, spanDown);

        element.appendChild(rightElement);
        updateGridLayout();
        return this;
    }

    private boolean hasFooter() {
        return nonNull(footerElement.parentNode);
    }

    public GridLayout removeRight() {
        editor.removeRight();
        rightElement.remove();
        updateGridLayout();

        return this;
    }

    public GridLayout addLeft() {
        return addLeft(SectionSpan._3, false, false);
    }

    public GridLayout addLeft(SectionSpan sectionSpan, boolean spanUp, boolean spanDown) {
        editor.addLeft(sectionSpan, spanUp, spanDown);

        element.appendChild(leftElement);
        updateGridLayout();
        return this;
    }

    public GridLayout removeLeft() {
        editor.removeLeft();

        leftElement.remove();
        updateGridLayout();

        return this;
    }

    public GridLayout addFooter() {
        return addFooter(SectionSpan._1);
    }

    public GridLayout addFooter(SectionSpan sectionSpan) {
        editor.addFooter(sectionSpan);
        element.appendChild(footerElement);
        updateGridLayout();

        return this;
    }

    public GridLayout removeFooter() {
        editor.removeFooter();
        footerElement.remove();
        updateGridLayout();

        return this;
    }


    private boolean hasHeader() {
        return nonNull(headerElement.parentNode);
    }

    private boolean hasLeft() {
        return nonNull(leftElement.parentNode);
    }

    private boolean hasRight() {
        return nonNull(rightElement.parentNode);
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    public HTMLDivElement getContentElement() {
        return contentElement;
    }

    public HTMLDivElement getHeaderElement() {
        return headerElement;
    }

    public HTMLDivElement getFooterElement() {
        return footerElement;
    }

    public HTMLDivElement getLeftElement() {
        return leftElement;
    }

    public HTMLDivElement getRightElement() {
        return rightElement;
    }

    public Style<HTMLDivElement, GridLayout> style(){
        return Style.of(this);
    }
}
