package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.jboss.elemento.Elements.aside;
import static org.jboss.elemento.Elements.section;

/**
 * The component that contains the left pabel and right panel of the {@link Layout}
 */
public class Section extends BaseDominoElement<HTMLElement, Section> {

    HTMLElement section;
    HTMLElement leftSide;
    HTMLElement rightSide;

    /**
     *
     */
    public Section() {
        leftSide = aside()
                .id("leftsidebar")
                .css(LayoutStyles.SIDEBAR)
                .element();

        rightSide = aside()
                .id("rightsidebar")
                .css(LayoutStyles.RIGHT_SIDEBAR)
                .css(LayoutStyles.OVERLAY_OPEN)
                .style("height: calc(100vh - 70px); overflow-y: scroll;")
                .element();

        section = section()
                .add(leftSide)
                .add(rightSide)
                .element();

        init(this);
    }

    /**
     *
     * @return new Section component
     */
    public static Section create() {
        return new Section();
    }

    /**
     *
     * @return the left panel {@link HTMLElement} wrapped as {@link DominoElement}
     */
    public DominoElement<HTMLElement> getLeftSide() {
        return DominoElement.of(leftSide);
    }


    /**
     *
     * @return the right panel {@link HTMLElement} wrapped as {@link DominoElement}
     */
    public DominoElement<HTMLElement> getRightSide() {
        return DominoElement.of(rightSide);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return section;
    }
}
