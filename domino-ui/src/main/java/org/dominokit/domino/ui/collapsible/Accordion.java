package org.dominokit.domino.ui.collapsible;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class Accordion extends BaseDominoElement<HTMLDivElement, Accordion> {

    private final DominoElement<HTMLDivElement> element = DominoElement.of(div().css(CollapsibleStyles.PANEL_GROUP));
    private List<AccordionPanel> panels = new LinkedList<>();
    private boolean multiOpen = false;
    private Color headerColor;
    private Color bodyColor;

    public Accordion() {
        init(this);
    }

    public static Accordion create() {
        return new Accordion();
    }

    public Accordion appendChild(AccordionPanel panel) {
        return appendChild(panel, true);
    }

    public Accordion appendChild(AccordionPanel panel, boolean overrideColors) {
        panels.add(panel);
        if (overrideColors) {
            if (nonNull(headerColor)) {
                panel.setHeaderBackground(headerColor);
            }

            if (nonNull(bodyColor)) {
                panel.setBodyBackground(bodyColor);
            }
        }
        element.appendChild(panel);
        DominoElement.of(panel.getClickableElement()).addClickListener(evt -> {
            if (!multiOpen) {
                List<AccordionPanel> accordionPanels = otherPanels(panel);
                accordionPanels.forEach(accordionPanel -> {
                    if (!accordionPanel.isHidden()) {
                        accordionPanel.hide();
                    }
                });
                if (panel.isHidden()) {
                    panel.show();
                }
            } else {
                panel.toggleDisplay();
            }
        });
        return this;
    }

    private List<AccordionPanel> otherPanels(AccordionPanel exclude) {
        List<AccordionPanel> newList = new ArrayList<>(panels);
        newList.remove(exclude);
        return newList;
    }

    public Accordion multiOpen() {
        this.multiOpen = true;
        return this;
    }

    public Accordion primary() {
        return setHeaderBackground(Color.BLUE);
    }

    public Accordion success() {
        return setHeaderBackground(Color.GREEN);
    }

    public Accordion warning() {
        return setHeaderBackground(Color.ORANGE);
    }

    public Accordion danger() {
        return setHeaderBackground(Color.RED);
    }

    public Accordion primaryFull() {
        setHeaderBackground(Color.BLUE);
        setBodyBackground(Color.BLUE);

        return this;
    }

    public Accordion successFull() {
        setHeaderBackground(Color.GREEN);
        setBodyBackground(Color.GREEN);

        return this;
    }

    public Accordion warningFull() {
        setHeaderBackground(Color.ORANGE);
        setBodyBackground(Color.ORANGE);

        return this;
    }

    public Accordion dangerFull() {
        setHeaderBackground(Color.RED);
        setBodyBackground(Color.RED);

        return this;
    }

    public Accordion setHeaderBackground(Color color) {
        panels.forEach(p -> p.setHeaderBackground(color));
        this.headerColor = color;
        return this;
    }

    public Accordion setBodyBackground(Color color) {
        panels.forEach(p -> p.setBodyBackground(color));
        this.bodyColor = color;
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }

    public List<AccordionPanel> getPanels() {
        return panels;
    }

}
