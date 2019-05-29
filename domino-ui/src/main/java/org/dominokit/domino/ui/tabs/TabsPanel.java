package org.dominokit.domino.ui.tabs;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.ul;

public class TabsPanel extends BaseDominoElement<HTMLDivElement, TabsPanel> implements IsElement<HTMLDivElement> {

    private HTMLDivElement element = div().asElement();
    private DominoElement<HTMLUListElement> tabsList = DominoElement.of(ul().css("nav", "nav-tabs", "nav-tabs-right").attr("role", "tablist"));
    private HTMLElement tabsContent = div().css("tab-content").asElement();
    private Tab activeTab;
    private Color tabsColor;
    private Transition transition;
    private List<Tab> tabs = new ArrayList<>();
    private Color background;

    public TabsPanel() {
        element.appendChild(tabsList.asElement());
        element.appendChild(tabsContent);
        init(this);
        setBackgroundColor(Color.WHITE);
        setColor(Color.BLUE);
    }

    public static TabsPanel create() {
        return new TabsPanel();
    }

    /**
     * @deprecated use {@link #appendChild(Tab)}
     */
    @Deprecated
    public TabsPanel addTab(Tab tab) {
        return appendChild(tab);
    }

    public TabsPanel appendChild(Tab tab) {
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
            tabsList.appendChild(tab.asElement());
            tabsContent.appendChild(tab.getContentContainer().asElement());
            tab.getClickableElement().addEventListener("click", evt -> activateTab(tab));
            tab.setParent(this);
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
            if (nonNull(activeTab)) {
                activeTab.deActivate();
            }
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
        if (nonNull(this.tabsColor)) {
            tabsList.style().remove(tabsColor.getStyle());
        }
        tabsList.style().add(color.getStyle());
        this.tabsColor = color;
        return this;
    }

    public TabsPanel setBackgroundColor(Color background) {
        if (nonNull(this.background)) {
            tabsList.style().remove(this.background.getBackground());
        }
        tabsList.style().add(background.getBackground());
        this.background = background;
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

    public TabsPanel setContentContainer(HTMLElement contentContainer) {
        if (element.contains(tabsContent)) {
            tabsContent.remove();
        }
        Style.of(contentContainer).add("tab-content");
        this.tabsContent = contentContainer;
        return this;
    }

    public TabsPanel setContentContainer(IsElement contentContainer) {
        return setContentContainer(contentContainer.asElement());
    }

    public DominoElement<HTMLElement> getTabsContent() {
        return DominoElement.of(tabsContent);
    }

    public Tab getActiveTab() {
        return activeTab;
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    public void closeTab(Tab tab) {
        int tabIndex = tabs.indexOf(tab);
        if (tabs.size() > 1) {
            if (tab.isActive()) {
                if (tabIndex > 0) {
                    activateTab(tabIndex - 1);
                } else {
                    activateTab(tabIndex + 1);
                }
            }
        } else {
            tab.deActivate();
            this.activeTab = null;
        }

        tabs.remove(tab);
        tab.remove();
        tab.setParent(null);
    }
}
