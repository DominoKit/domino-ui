package org.dominokit.domino.ui.tabs;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
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
    private List<Tab> tabs = new ArrayList<>();

    public TabsPanel() {
        element.appendChild(tabsList);
        element.appendChild(tabsContent);
    }

    public static TabsPanel create() {
        return new TabsPanel();
    }

    public TabsPanel addTab(Tab tab) {
        if (nonNull(tab)) {
            tabs.add(tab);
            if (isNull(activeTab)) {
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

    public void activateTab(int index) {
        if (!tabs.isEmpty() && index < tabs.size() && index >= 0) {
            activateTab(tabs.get(index));
        } else {
            throw new IndexOutOfBoundsException("provided index of [" + index + "] is not within current tabs of size [" + tabs.size() + "].");
        }
    }

    public void activateTab(Tab tab) {
        if (nonNull(tab) && tabs.contains(tab)) {
            activeTab.deActivate();
            activeTab = tab;
            activeTab.activate();

            if (nonNull(transition)) {
                Animation.create(activeTab.getContentContainer())
                        .transition(transition)
                        .animate();
            }
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

    public Tab getActiveTab() {
        return activeTab;
    }

    public List<Tab> getTabs() {
        return tabs;
    }
}
