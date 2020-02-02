package org.dominokit.domino.ui.grid;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class GridLayout extends BaseDominoElement<HTMLDivElement, GridLayout> {

    private HTMLDivElement element = div()
            .css(GridStyles.LAYOUT_GRID).element();

    private final HTMLDivElement contentElement = div().css(GridStyles.LAYOUT_CONTENT).element();
    private final HTMLDivElement headerElement = div().css(GridStyles.LAYOUT_HEADER).element();
    private final HTMLDivElement footerElement = div().css(GridStyles.LAYOUT_FOOTER).element();
    private final HTMLDivElement leftElement = div().css(GridStyles.LAYOUT_LEFT).element();
    private final HTMLDivElement rightElement = div().css(GridStyles.LAYOUT_RIGHT).element();

    private GridLayoutEditor editor = new GridLayoutEditor();

    public GridLayout() {
        element.appendChild(contentElement);
        init(this);
        updateGridLayout();
    }

    private void updateGridLayout() {
        style.setProperty("grid-template-areas", editor.gridAreasAsString());
    }

    public static GridLayout create() {
        return new GridLayout();
    }

    public GridLayout setGap(String gap) {
        style.setProperty("grid-gap", gap);
        return this;
    }


    public GridLayout setHeaderSpan(SectionSpan sectionSpan) {
        editor.addHeader(sectionSpan);
        element.appendChild(headerElement);
        updateGridLayout();

        return this;
    }

    public GridLayout hideHeader() {
        editor.removeHeader();
        headerElement.remove();
        updateGridLayout();

        return this;
    }

    public GridLayout setRightSpan(SectionSpan sectionSpan, boolean spanUp, boolean spanDown) {
        editor.addRight(sectionSpan, spanUp, spanDown);

        element.appendChild(rightElement);
        updateGridLayout();
        return this;
    }

    private boolean hasFooter() {
        return nonNull(footerElement.parentNode);
    }

    public GridLayout hideRight() {
        editor.removeRight();
        rightElement.remove();
        updateGridLayout();

        return this;
    }


    public GridLayout setLeftSpan(SectionSpan sectionSpan, boolean spanUp, boolean spanDown) {
        editor.addLeft(sectionSpan, spanUp, spanDown);

        element.appendChild(leftElement);
        updateGridLayout();
        return this;
    }

    public GridLayout hideLeft() {
        editor.removeLeft();

        leftElement.remove();
        updateGridLayout();

        return this;
    }


    public GridLayout setFooterSpan(SectionSpan sectionSpan) {
        editor.addFooter(sectionSpan);
        element.appendChild(footerElement);
        updateGridLayout();

        return this;
    }

    public GridLayout hideFooter() {
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
    public HTMLDivElement element() {
        return element;
    }

    public DominoElement<HTMLDivElement> getContentElement() {
        return DominoElement.of(contentElement);
    }

    public DominoElement<HTMLDivElement> getHeaderElement() {
        return DominoElement.of(headerElement);
    }

    public DominoElement<HTMLDivElement> getFooterElement() {
        return DominoElement.of(footerElement);
    }

    public DominoElement<HTMLDivElement> getLeftElement() {
        return DominoElement.of(leftElement);
    }

    public DominoElement<HTMLDivElement> getRightElement() {
        return DominoElement.of(rightElement);
    }
}
