package org.dominokit.domino.ui.collapsible;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;

public class Accordion implements IsElement<HTMLDivElement> {

    private final HTMLDivElement element = div().css("panel-group").asElement();
    private List<AccordionPanel> panels = new LinkedList<>();
    private boolean multiOpen = false;


    public static Accordion create() {
        return new Accordion();
    }

    public Accordion addPanel(AccordionPanel panel) {
        panels.add(panel);
        element.appendChild(panel.asElement());
        panel.getClickableElement().addEventListener("click", evt -> {
            if(!multiOpen) {
                List<AccordionPanel> accordionPanels = otherPanels(panel);
                accordionPanels.forEach(accordionPanel -> {
                    if(!accordionPanel.isCollapsed()) {
                        accordionPanel.collapse();
                    }
                });
                if(panel.isCollapsed()) {
                    panel.expand();
                }
            }else{
                panel.toggle();
            }
        });
        return this;
    }

    private List<AccordionPanel> otherPanels(AccordionPanel exclude){
        List<AccordionPanel> newList = new ArrayList<>(panels);
        newList.remove(exclude);
        return newList;
    }

    public Accordion multiOpen(){
        this.multiOpen=true;
        return this;
    }

    public Accordion primary(){
        return applyStyle("panel-primary");
    }

    public Accordion success(){
        return applyStyle("panel-success");
    }

    public Accordion warning(){
        return applyStyle("panel-warning");
    }

    public Accordion danger(){
        return applyStyle("panel-danger");
    }

    public Accordion setColor(Color color){
        return applyStyle(color.getStyle());
    }

    private Accordion applyStyle(String style) {
        panels.forEach(p-> p.applyStyle(style));
        return this;
    }

    public Accordion fullBody(){
        element.classList.add("full-body");
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
    
    public List<AccordionPanel> getPanels() {
    	return panels;
    }
    
}
