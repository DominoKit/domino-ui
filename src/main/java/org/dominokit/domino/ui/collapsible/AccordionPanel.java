package org.dominokit.domino.ui.collapsible;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.IsCollapsible;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class AccordionPanel extends BaseDominoElement<HTMLDivElement, AccordionPanel> implements IsCollapsible<AccordionPanel> {

    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css("panel"));
    private DominoElement<HTMLDivElement> headerElement = DominoElement.of(div().css("panel-heading").attr("role", "tab"));
    private DominoElement<HTMLHeadingElement> headingElement = DominoElement.of(h(4).css("panel-title"));
    private DominoElement<HTMLAnchorElement> clickableElement = DominoElement.of(a().attr("role", "button"));
    private DominoElement<HTMLDivElement> collapsibleElement = DominoElement.of(div().css("panel-collapse"));
    private DominoElement<HTMLDivElement> bodyElement = DominoElement.of(div().css("panel-body"));
    private String panelStyle = "panel-primary";
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

    public static AccordionPanel create(String title, IsElement content) {
        return new AccordionPanel(title, content.asElement());
    }

    private void init() {
        element.appendChild(headerElement);
        headerElement.appendChild(headingElement);
        headingElement.appendChild(clickableElement);
        collapsibleElement.appendChild(bodyElement);
        element.appendChild(collapsibleElement);
        init(this);
        collapse();
    }

    public AccordionPanel setTitle(String title) {
        clickableElement.setTextContent(title);
        return this;
    }

    public AccordionPanel setContent(Node content) {
        bodyElement.setTextContent("");
        return appendChild(content);
    }

    /**
     * @deprecated use {@link #appendChild(Node)}
     */
    @Deprecated
    public AccordionPanel appendContent(Node content) {
        bodyElement.appendChild(content);
        return this;
    }

    public AccordionPanel appendChild(Node content) {
        bodyElement.appendChild(content);
        return this;
    }

    public AccordionPanel appendChild(IsElement content) {
        return appendChild(content.asElement());
    }


    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }


    public AccordionPanel primary() {
        return applyStyle("panel-primary");
    }

    public AccordionPanel success() {
        return applyStyle("panel-success");
    }

    public AccordionPanel warning() {
        return applyStyle("panel-warning");
    }

    public AccordionPanel danger() {
        return applyStyle("panel-danger");
    }

    public AccordionPanel setColor(Color color) {
        return applyStyle(color.getStyle());
    }

    AccordionPanel applyStyle(String style) {
        element.style().remove(panelStyle);
        panelStyle = style;
        element.style().add(panelStyle);
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
        return clickableElement.asElement();
    }

    @Override
    public HTMLDivElement getCollapsibleElement() {
        return collapsibleElement.asElement();
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
}
