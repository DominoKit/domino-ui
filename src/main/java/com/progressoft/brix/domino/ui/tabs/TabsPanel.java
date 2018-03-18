package com.progressoft.brix.domino.ui.tabs;

import com.progressoft.brix.domino.ui.animations.Animation;
import com.progressoft.brix.domino.ui.animations.Transition;
import com.progressoft.brix.domino.ui.style.Color;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLUListElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.Objects;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.ul;

public class TabsPanel implements IsElement<HTMLDivElement> {

    private HTMLDivElement element = div().asElement();
    private HTMLUListElement tabsList = ul().css("nav", "nav-tabs", "nav-tabs-right").attr("role", "tablist")
            .asElement();
    private HTMLDivElement tabsContent = div().css("tab-content").asElement();
    private Tab activeTab;
    private Color tabsColor = Color.BLUE;
    private Transition transition;

    public TabsPanel() {
        element.appendChild(tabsList);
        element.appendChild(tabsContent);
    }

    public static TabsPanel create() {
        return new TabsPanel();
    }

    public TabsPanel addTab(Tab tab) {
        if (nonNull(tab)) {
            if (Objects.isNull(activeTab)) {
                this.activeTab = tab;
                this.activeTab.activate();
            } else {
                if (tab.isActive()) {
                    activateTab(tab);
                }
            }
            tabsList.appendChild(tab.getTab());
            tabsContent.appendChild(tab.getContentContainer());
            tab.getClickableElement().addEventListener("click", evt -> activateTab(tab));
        }

        return this;
    }

    private void activateTab(Tab tab) {
        activeTab.deActivate();
        activeTab = tab;
        activeTab.activate();

        if (nonNull(transition)) {
            Animation.create(activeTab.getContentContainer())
                    .transition(transition)
                    .animate();
        }
    }

    public TabsPanel setColor(Color color) {
        tabsList.classList.remove("tab-" + tabsColor.getStyle());
        tabsList.classList.add("tab-" + color.getStyle());
        this.tabsColor = color;
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    public TabsPanel setTransition(Transition transition) {
        this.transition = transition;
        return this;
    }
}
