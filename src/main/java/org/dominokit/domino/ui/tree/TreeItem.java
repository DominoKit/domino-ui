package org.dominokit.domino.ui.tree;

import elemental2.dom.*;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.WaveColor;
import org.dominokit.domino.ui.style.WaveStyle;
import org.dominokit.domino.ui.style.WavesElement;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.EventType;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class TreeItem extends WavesElement<HTMLLIElement, TreeItem> implements ParentTreeItem<TreeItem>, CanActivate, CanDeactivate, HasClickableElement {

    private String title;
    private HTMLLIElement element;
    private DominoElement<HTMLAnchorElement> anchorElement;
    private List<TreeItem> subItems = new LinkedList<>();
    private TreeItem activeTreeItem;
    private ParentTreeItem<TreeItem> parent;
    private Collapsible collapsible;

    private HTMLUListElement childrenContainer;
    private BaseIcon<?> icon;
    private BaseIcon<?> activeIcon;
    private BaseIcon<?> originalIcon;
    private HTMLElement titleElement;

    private BaseIcon<?> expandIcon;

    public TreeItem(String title, BaseIcon<?> icon) {
        this.title = title;
        setIcon(icon);
        this.titleElement = span().css("title").textContent(title).asElement();
        this.anchorElement = DominoElement.of(a()
                .add(this.icon)
                .add(div().style("margin-top: 2px;").add(titleElement)));
        init();
    }

    public TreeItem(String title) {
        this.title = title;
        this.titleElement = span().css("title").textContent(title).asElement();
        this.anchorElement = DominoElement.of(a()
                .add(div().style("margin-top: 2px;").add(titleElement)));
        init();
    }

    public TreeItem(BaseIcon<?> icon) {
        setIcon(icon);
        this.anchorElement = DominoElement.of(a()
                .add(this.icon));
        init();
    }

    public static TreeItem create(String title) {
        return new TreeItem(title);
    }

    public static TreeItem create(String title, BaseIcon<?> icon) {
        return new TreeItem(title, icon);
    }

    public static TreeItem create(BaseIcon<?> icon) {
        return new TreeItem(icon);
    }

    /**
     * @deprecated use {@link #appendChild(TreeItem)}
     */
    @Deprecated
    public TreeItem addTreeItem(TreeItem treeItem) {
        return appendChild(treeItem);
    }

    public TreeItem appendChild(TreeItem treeItem) {
        this.subItems.add(treeItem);
        childrenContainer.appendChild(treeItem.asElement());
        Style.of(anchorElement).add("tree-toggle");
        treeItem.parent = this;
        Style.of(treeItem).add("tree-leaf");
        Style.of(this.asElement()).remove("tree-leaf");
        return this;
    }

    public TreeItem addSeparator() {
        childrenContainer.appendChild(li().css("separator")
                .add(a())
                .asElement());
        return this;
    }

    private void init() {
        this.element = li().asElement();
        this.element.appendChild(anchorElement.asElement());
        childrenContainer = ul().css("ml-tree").asElement();
        asElement().appendChild(childrenContainer);
        collapsible = Collapsible.create(childrenContainer)
                .addCollapseHandler(() -> {
                    Style.of(anchorElement).remove("toggled");
                    restoreIcon();
                })
                .addExpandHandler(() -> {
                    Style.of(anchorElement).add("toggled");
                    replaceIcon(expandIcon);
                })
                .collapse();
        anchorElement.addEventListener("click", evt -> {
            if (isParent()) {
                collapsible.toggleDisplay();
            }
            parent.setActiveItem(TreeItem.this);
        });
        init(this);
        setWaveColor(WaveColor.THEME);
        applyWaveStyle(WaveStyle.BLOCK);
    }

    public TreeItem expand() {
        return expand(false);
    }

    public TreeItem expand(boolean expandParent) {
        if (isParent()) {
            collapsible.expand();
        }
        if (expandParent && nonNull(parent)) {
            parent.expand(expandParent);
        }
        return this;
    }

    public TreeItem collapse() {
        if (isParent()) {
            collapsible.collapse();
        }
        return this;
    }

    public TreeItem toggleDisplay() {
        if (isParent()) {
            collapsible.toggleDisplay();
        }
        return this;
    }

    @Override
    public HTMLLIElement asElement() {
        return element;
    }

    @Override
    public TreeItem getActiveItem() {
        return activeTreeItem;
    }

    @Override
    public Tree getTreeRoot() {
        return parent.getTreeRoot();
    }

    @Override
    public void setActiveItem(TreeItem activeItem) {
        if (nonNull(activeItem)) {
            if (nonNull(this.activeTreeItem) && !this.activeTreeItem.equals(activeItem)) {
                this.activeTreeItem.deactivate();
            }
            this.activeTreeItem = activeItem;
            this.activeTreeItem.activate();
            parent.setActiveItem(this);
        }
    }

    @Override
    public void activate() {
        activate(false);
    }

    @Override
    public void activate(boolean activateParent) {
        Style.of(asElement()).add("active");
        if (isNull(expandIcon) || collapsible.isCollapsed() || !isParent()) {
            replaceIcon(this.activeIcon);
        }


        if (activateParent && nonNull(parent)) {
            parent.setActiveItem(this);

        }
    }

    private void replaceIcon(BaseIcon<?> newIcon) {
        if (nonNull(newIcon)) {
            anchorElement.insertFirst(newIcon);
            if (nonNull(icon)) {
                icon.remove();
            }
            this.icon = newIcon;
        }
    }

    @Override
    public void deactivate() {
        Style.of(asElement()).remove("active");
        if (isNull(expandIcon) || collapsible.isCollapsed() || !isParent()) {
            restoreIcon();
        }
        if (isParent()) {
            subItems.forEach(TreeItem::deactivate);
            if (getTreeRoot().isAutoCollapse()) {
                collapsible.collapse();
            }
        }
    }

    private void restoreIcon() {
        if (nonNull(originalIcon)) {
            icon.remove();
            anchorElement.insertFirst(originalIcon);
            this.icon = originalIcon;
        } else {
            if (nonNull(icon)) {
                icon.remove();
            }
        }
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return anchorElement.asElement();
    }

    public TreeItem addClickListener(EventListener listener) {
        getClickableElement().addEventListener(EventType.click.getName(), listener);
        return this;
    }

    public TreeItem setIcon(BaseIcon<?> icon) {
        this.icon = icon;
        this.originalIcon = icon.copy();
        return this;
    }

    public TreeItem setActiveIcon(BaseIcon<?> activeIcon) {
        this.activeIcon = activeIcon;
        return this;
    }

    public TreeItem setExpandIcon(BaseIcon<?> expandIcon) {
        this.expandIcon = expandIcon;
        return this;
    }

    boolean isParent() {
        return !subItems.isEmpty();
    }

    void setParent(ParentTreeItem<TreeItem> parentMenu) {
        this.parent = parentMenu;
    }

    public String getTitle() {
        return title;
    }

    public boolean filter(String searchToken) {

        boolean found;
        if (isParent()) {
            found = title.toLowerCase().contains(searchToken.toLowerCase()) | filterChildren(searchToken);
        } else {
            found = title.toLowerCase().contains(searchToken.toLowerCase());
        }

        if (found) {
            Style.of(element).removeProperty("display");
            if (isParent() && isAutoExpandFound() && collapsible.isCollapsed()) {
                collapsible.expand();
            }
            return true;
        } else {
            Style.of(element).setDisplay("none");
            return false;
        }
    }

    @Override
    public boolean isAutoExpandFound() {
        return parent.isAutoExpandFound();
    }

    public void clearFilter() {
        Style.of(element).removeProperty("display");
        subItems.forEach(TreeItem::clearFilter);
    }

    public boolean filterChildren(String searchToken) {
        return subItems.stream().filter(treeItem -> treeItem.filter(searchToken)).collect(Collectors.toList()).size() > 0;
    }

    public void collapseAll() {
        if (isParent() && !collapsible.isCollapsed()) {
            collapse();
            subItems.forEach(TreeItem::collapseAll);
        }
    }

    public void expandAll() {
        if (isParent() && collapsible.isCollapsed()) {
            expand();
            subItems.forEach(TreeItem::expandAll);
        }
    }

    @Override
    public HTMLElement getWavesElement() {
        return anchorElement.asElement();
    }
}
