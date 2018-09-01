package org.dominokit.domino.ui.collapsible;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.IsCollapsible;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class AccordionPanel extends DominoElement<HTMLDivElement, AccordionPanel> implements IsElement<HTMLDivElement>, IsCollapsible<AccordionPanel> {

    private HTMLDivElement element = div().css("panel panel-primary").asElement();
    private HTMLDivElement headerElement = div().css("panel-heading").attr("role", "tab").asElement();
    private HTMLHeadingElement headingElement = h(4).css("panel-title").asElement();
    private HTMLAnchorElement clickablElement = a().attr("role", "button").asElement();
    private HTMLDivElement collapsibleElement = div().css("panel-collapse").asElement();
    private Collapsible collapsible;
    private HTMLDivElement bodyElement = div().css("panel-body").asElement();
    private String panelStyle = "panel-primary";
    private Icon panelIcon;
    private int duration = 1;

    public AccordionPanel(String title) {
        clickablElement.textContent = title;
        init();
    }

    public AccordionPanel(String title, Node content) {
        clickablElement.textContent = title;
        bodyElement.appendChild(content);
        init();
    }

    public static AccordionPanel create(String title) {
        return new AccordionPanel(title);
    }

    public static AccordionPanel create(String title, Node content) {
        return new AccordionPanel(title, content);
    }

    private void init() {
        element.appendChild(headerElement);
        headerElement.appendChild(headingElement);
        headingElement.appendChild(clickablElement);
        collapsibleElement.appendChild(bodyElement);
        element.appendChild(collapsibleElement);
        collapsible = Collapsible.create(collapsibleElement);

    }

    public AccordionPanel setTitle(String title) {
        clickablElement.textContent = title;
        return this;
    }

    public AccordionPanel setContent(Node content) {
        bodyElement.textContent = "";
        return appendChild(content);
    }

    /**
     * @deprecated use {@link #appendChild(Node)}
     * @param content
     * @return
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
        return element;
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
        element.classList.remove(panelStyle);
        panelStyle = style;
        element.classList.add(panelStyle);
        return this;
    }

    public AccordionPanel setIcon(Icon icon) {
        if (nonNull(this.panelIcon)) {
            panelIcon.asElement().remove();
        }

        panelIcon = icon;
        clickablElement.insertBefore(icon.asElement(), clickablElement.firstChild);

        return this;
    }

    public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getBody() {
        return DominoElement.of(bodyElement);
    }

    @Override
    public DominoElement<HTMLAnchorElement, IsElement<HTMLAnchorElement>> getClickableElement() {
        return DominoElement.of(clickablElement);
    }

    @Override
    public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getCollapsibleElement() {
        return DominoElement.of(collapsibleElement);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
