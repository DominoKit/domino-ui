package com.progressoft.brix.domino.ui.collapsible;

import com.progressoft.brix.domino.ui.icons.Icon;
import com.progressoft.brix.domino.ui.style.Color;
import com.progressoft.brix.domino.ui.utils.HasClickableElement;
import com.progressoft.brix.domino.ui.utils.IsCollapsible;
import elemental2.dom.*;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class AccordionPanel implements IsElement<HTMLDivElement>, IsCollapsible<AccordionPanel>, HasClickableElement {

    private HTMLDivElement element = div().css("panel panel-primary").asElement();
    private HTMLDivElement headerElement = div().css("panel-heading").attr("role", "tab").asElement();
    private HTMLHeadingElement headingElement = h(4).css("panel-title").asElement();
    private HTMLAnchorElement clickablElement = a().attr("role", "button").asElement();
    private HTMLDivElement collapsibleElement = div().css("panel-collapse").asElement();
    private Collapsible collapsible = Collapsible.create(collapsibleElement);
    private HTMLDivElement bodyElement = div().css("panel-body").asElement();
    private String panelStyle = "panel-primary";
    private Icon panelIcon;

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
    }

    public AccordionPanel setTitle(String title){
        clickablElement.textContent=title;
        return this;
    }

    public AccordionPanel setContent(Node content){
        bodyElement.textContent="";
       return appendContent(content);
    }

    public AccordionPanel appendContent(Node content){
        bodyElement.appendChild(content);
        return this;
    }

    @Override
    public AccordionPanel collapse() {
        collapsible.collapse();
        return this;
    }

    @Override
    public AccordionPanel expand() {
        collapsible.expand();
        return this;
    }

    @Override
    public AccordionPanel toggle() {
        collapsible.toggle();
        return this;
    }

    @Override
    public boolean isCollapsed() {
        return collapsible.isCollapsed();
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    @Override
    public HTMLElement getClickableElement() {
        return clickablElement;
    }

    public AccordionPanel primary(){
        return applyStyle("panel-primary");
    }

    public AccordionPanel success(){
        return applyStyle("panel-success");
    }

    public AccordionPanel warning(){
        return applyStyle("panel-warning");
    }

    public AccordionPanel danger(){
        return applyStyle("panel-danger");
    }

    public AccordionPanel setColor(Color color){
        return applyStyle("panel-"+color.getStyle());
    }

    AccordionPanel applyStyle(String style){
        element.classList.remove(panelStyle);
        panelStyle=style;
        element.classList.add(panelStyle);
        return this;
    }

    public AccordionPanel setIcon(Icon icon){
        if(nonNull(this.panelIcon)){
            panelIcon.asElement().remove();
        }

        panelIcon=icon;
        clickablElement.insertBefore(icon.asElement(), clickablElement.firstChild);

        return this;
    }

    public HTMLDivElement getBody() {
        return bodyElement;
    }
}
