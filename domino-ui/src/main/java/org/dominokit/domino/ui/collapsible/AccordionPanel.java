package org.dominokit.domino.ui.collapsible;

import elemental2.dom.*;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.IsCollapsible;
import org.jboss.elemento.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

public class AccordionPanel extends BaseDominoElement<HTMLDivElement, AccordionPanel> implements IsCollapsible<AccordionPanel> {

    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css(CollapsibleStyles.PANEL))
            .elevate(Elevation.LEVEL_1);
    private DominoElement<HTMLDivElement> headerElement = DominoElement.of(div().css(CollapsibleStyles.PANEL_HEADING)
            .attr("role", "tab"));
    private DominoElement<HTMLHeadingElement> headingElement = DominoElement.of(h(4).css(CollapsibleStyles.PANEL_TITLE));
    private DominoElement<HTMLAnchorElement> clickableElement = DominoElement.of(a()
            .attr("role", "button"));
    private DominoElement<HTMLDivElement> collapsibleElement = DominoElement.of(div()
            .css(CollapsibleStyles.PANEL_COLLAPSE));
    private DominoElement<HTMLDivElement> bodyElement = DominoElement.of(div().css(CollapsibleStyles.PANEL_BODY));
    private Color headerColor;
    private Color bodyColor;
    private BaseIcon<?> panelIcon;

    public AccordionPanel(String title) {
        clickableElement.setTextContent(title);
        init();
    }

    public AccordionPanel(String title, Node content) {
        clickableElement.setTextContent(title);
        bodyElement.appendChild(content);
        init();
    }

    public static AccordionPanel create(String title) {
        return new AccordionPanel(title);
    }

    public static AccordionPanel create(String title, Node content) {
        return new AccordionPanel(title, content);
    }

    public static AccordionPanel create(String title, IsElement<?> content) {
        return new AccordionPanel(title, content.element());
    }

    private void init() {
        element.appendChild(headerElement);
        headerElement.appendChild(headingElement);
        headingElement.appendChild(clickableElement);
        collapsibleElement.appendChild(bodyElement);
        element.appendChild(collapsibleElement);
        init(this);
        hide();
    }

    public AccordionPanel setTitle(String title) {
        clickableElement.setTextContent(title);
        return this;
    }

    public AccordionPanel setContent(Node content) {
        bodyElement.setTextContent("");
        return appendChild(content);
    }

    public AccordionPanel appendChild(Node content) {
        bodyElement.appendChild(content);
        return this;
    }

    public AccordionPanel appendChild(IsElement<?> content) {
        return appendChild(content.element());
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    public AccordionPanel primary() {
        return setHeaderBackground(Color.BLUE);
    }

    public AccordionPanel success() {
        return setHeaderBackground(Color.GREEN);
    }

    public AccordionPanel warning() {
        return setHeaderBackground(Color.ORANGE);
    }

    public AccordionPanel danger() {
        return setHeaderBackground(Color.RED);
    }

    public AccordionPanel primaryFull() {
        setHeaderBackground(Color.BLUE);
        setBodyBackground(Color.BLUE);
        return this;
    }

    public AccordionPanel successFull() {
        setHeaderBackground(Color.GREEN);
        setBodyBackground(Color.GREEN);
        return this;
    }

    public AccordionPanel warningFull() {
        setHeaderBackground(Color.ORANGE);
        setBodyBackground(Color.ORANGE);
        return this;
    }

    public AccordionPanel dangerFull() {
        setHeaderBackground(Color.RED);
        setBodyBackground(Color.RED);
        return this;
    }

    public AccordionPanel setHeaderBackground(Color color) {
        if(nonNull(this.headerColor)){
            getHeaderElement().style().remove(this.headerColor.getBackground());
        }
        getHeaderElement().style().add(color.getBackground());

        this.headerColor = color;

        return this;
    }

    public AccordionPanel setBodyBackground(Color color) {
        if(nonNull(this.bodyColor)){
            getBodyElement().style().remove(this.bodyColor.getBackground());
        }
        getBodyElement().style().add(color.getBackground());

        this.bodyColor = color;

        return this;
    }

    public AccordionPanel setIcon(BaseIcon<?> icon) {
        if (nonNull(this.panelIcon)) {
            panelIcon.remove();
        }

        panelIcon = icon;
        clickableElement.insertFirst(icon);

        return this;
    }

    public DominoElement<HTMLDivElement> getBody() {
        return DominoElement.of(bodyElement);
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return clickableElement.element();
    }

    @Override
    public HTMLDivElement getCollapsibleElement() {
        return collapsibleElement.element();
    }

    public DominoElement<HTMLDivElement> getHeaderElement() {
        return headerElement;
    }

    public DominoElement<HTMLHeadingElement> getHeadingElement() {
        return headingElement;
    }

    public DominoElement<HTMLDivElement> getBodyElement() {
        return bodyElement;
    }

    public BaseIcon<?> getPanelIcon() {
        return panelIcon;
    }

    public Color getHeaderColor() {
        return headerColor;
    }

    public Color getBodyColor() {
        return bodyColor;
    }
}
