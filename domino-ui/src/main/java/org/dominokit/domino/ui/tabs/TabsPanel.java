package org.dominokit.domino.ui.tabs;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.ul;

public class TabsPanel extends BaseDominoElement<HTMLDivElement, TabsPanel> implements IsElement<HTMLDivElement> {

    private HTMLDivElement element = div().element();
    private DominoElement<HTMLUListElement> tabsList = DominoElement.of(ul()
            .css(TabStyles.NAV, TabStyles.NAV_TABS, TabStyles.NAV_TABS_RIGHT)
            .attr("role", "tablist"));
    private HTMLElement tabsContent = div()
            .css(TabStyles.TAB_CONTENT)
            .element();
    private Tab activeTab;
    private Color tabsColor;
    private Transition transition;
    private List<Tab> tabs = new ArrayList<>();
    private Color background;
    private boolean autoActivate = true;

    private final List<Consumer<Tab>> closeHandlers = new ArrayList<>();
    private final List<Tab.ActivationHandler> activationHandlers = new ArrayList<>();

    public TabsPanel() {
        element.appendChild(tabsList.element());
        element.appendChild(tabsContent);
        init(this);
        setBackgroundColor(Color.WHITE);
        setColor(Color.BLUE);
    }

    public static TabsPanel create() {
        return new TabsPanel();
    }

    public TabsPanel insertAt(int index, Tab tab) {
        if (index >= 0 && index <= tabs.size()) {
            if (nonNull(tab)) {
                tabs.add(index, tab);
                if (isNull(activeTab) && autoActivate) {
                    this.activeTab = tab;
                    activateTab(this.activeTab);
                } else {
                    if (tab.isActive()) {
                        activateTab(tab);
                        this.activeTab = tab;
                    }
                }
                if (index == tabs.size() - 1) {
                    tabsList.appendChild(tab.element());
                    tabsContent.appendChild(tab.getContentContainer().element());
                } else {
                    tabsList.insertBefore(tab, tabs.get(index + 1));
                    tabsContent.insertBefore(tab.getContentContainer().element(), tabs.get(index + 1).getContentContainer().element());
                }

                tab.getClickableElement().addEventListener("click", evt -> activateTab(tab));
                tab.setParent(this);
            }
            return this;
        }

        throw new IndexOutOfBoundsException("invalid index for tab insert! Index is [" + index + "], acceptable range is [0 - " + tabs.size() + "]");
    }

    public TabsPanel appendChild(Tab tab) {
        insertAt(tabs.size(), tab);
        return this;
    }

    public void activateTab(int index) {
        if (!tabs.isEmpty() && index < tabs.size() && index >= 0) {
            activateTab(tabs.get(index));
        } else {
            throw new IndexOutOfBoundsException("provided index of [" + index + "] is not within current tabs of size [" + tabs.size() + "].");
        }
    }

    public void deActivateTab(int index) {
        if (!tabs.isEmpty() && index < tabs.size() && index >= 0) {
            deActivateTab(tabs.get(index));
        } else {
            throw new IndexOutOfBoundsException("provided index of [" + index + "] is not within current tabs of size [" + tabs.size() + "].");
        }
    }

    public void activateTab(Tab tab) {
        activateTab(tab, false);
    }

    public void activateTab(Tab tab, boolean silent) {
        if (nonNull(tab) && tabs.contains(tab)) {
            if (nonNull(activeTab)) {
                deActivateTab(activeTab);
            }
            if (!tab.isActive()) {
                activeTab = tab;
                activeTab.activate();
                if (!silent) {
                    activationHandlers.forEach(handler -> handler.onActiveStateChanged(tab, true));
                }
                if (nonNull(transition)) {
                    Animation.create(activeTab.getContentContainer())
                            .transition(transition)
                            .animate();
                }
            }
        }
    }

    public void deActivateTab(Tab tab) {
        deActivateTab(tab, false);
    }

    public void deActivateTab(Tab tab, boolean silent) {
        if (nonNull(tab) && tabs.contains(tab)) {
            if (tab.isActive()) {
                tab.deActivate(silent);
                if (!silent) {
                    activationHandlers.forEach(handler -> handler.onActiveStateChanged(tab, false));
                }
                if (nonNull(transition)) {
                    Animation.create(activeTab.getContentContainer())
                            .transition(transition)
                            .animate();
                }
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
    public HTMLDivElement element() {
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
        Style.of(contentContainer).add(TabStyles.TAB_CONTENT);
        this.tabsContent = contentContainer;
        return this;
    }

    public TabsPanel setContentContainer(IsElement<?> contentContainer) {
        return setContentContainer(contentContainer.element());
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
            deActivateTab(tab);
            this.activeTab = null;
        }

        tabs.remove(tab);
        tab.removeTab();

        tab.setParent(null);

        closeHandlers.forEach(closeHandler -> closeHandler.accept(tab));

    }

    public TabsPanel addCloseHandler(Consumer<Tab> closeHandler) {
        if (nonNull(closeHandler)) {
            this.closeHandlers.add(closeHandler);
        }
        return this;
    }

    public TabsPanel removeCloseHandler(Consumer<Tab> closeHandler) {
        if (nonNull(closeHandler)) {
            this.closeHandlers.remove(closeHandler);
        }
        return this;
    }

    public TabsPanel addActivationHandler(Tab.ActivationHandler activationHandler) {
        if (nonNull(activationHandler)) {
            this.activationHandlers.add(activationHandler);
        }
        return this;
    }

    public TabsPanel removeActivationHandler(Tab.ActivationHandler activationHandler) {
        if (nonNull(activationHandler)) {
            this.activationHandlers.remove(activationHandler);
        }
        return this;
    }

    public TabsPanel activateByKey(String key) {
        return activateByKey(key, false);
    }

    public TabsPanel activateByKey(String key, boolean silent) {
        tabs.stream().filter(tab -> tab.getKey().equalsIgnoreCase(key))
                .findFirst()
                .ifPresent(tab -> activateTab(tab, silent));
        return this;
    }

    public boolean isAutoActivate() {
        return autoActivate;
    }

    public TabsPanel setAutoActivate(boolean autoActivate) {
        this.autoActivate = autoActivate;
        return this;
    }

    public TabsPanel setTabsAlign(TabsAlign align) {
        this.tabsList.css(align.getAlign());
        return this;
    }
}
