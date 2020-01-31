package org.dominokit.domino.ui.tree;

import elemental2.dom.*;
import elemental2.dom.EventListener;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.*;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.elemento.Elements.*;

public class TreeItem<T> extends WavesElement<HTMLLIElement, TreeItem<T>> implements ParentTreeItem<TreeItem<T>>, CanActivate, CanDeactivate, HasClickableElement {

    private String title;
    private HTMLLIElement element;
    private DominoElement<HTMLAnchorElement> anchorElement;
    private List<TreeItem<T>> subItems = new LinkedList<>();
    private TreeItem<T> activeTreeItem;
    private ParentTreeItem<TreeItem<T>> parent;
    private Collapsible collapsible;

    private HTMLUListElement childrenContainer;
    private BaseIcon<?> icon;
    private BaseIcon<?> activeIcon;
    private BaseIcon<?> originalIcon;
    private HTMLElement titleElement;

    private BaseIcon<?> expandIcon;

    private T value;

    private int nextLevel = 1;

    private ToggleTarget toggleTarget = ToggleTarget.ANY;
    private DominoElement<HTMLElement> toggleContainer = DominoElement.of(span()
            .css("tree-tgl-icn")
    );
    private DominoElement<HTMLElement> indicatorContainer = DominoElement.of(span()
            .css("tree-indicator")
    );

    public TreeItem(String title, BaseIcon<?> icon) {
        this.title = title;
        setIcon(icon);
        this.titleElement = span()
                .css("title")
                .textContent(title).element();
        this.anchorElement = DominoElement.of(a()
                .add(this.icon)
                .add(div()
                        .css(Styles.ellipsis_text)
                        .style("margin-top: 2px;")
                        .add(titleElement)
                )
                .add(toggleContainer
                        .appendChild(Icons.ALL.plus_mdi()
                                .size18()
                                .css("tree-tgl-collapsed")
                                .clickable()
                                .addClickListener(evt -> {
                                    evt.stopPropagation();
                                    toggle();
                                    activateItem();
                                })
                        )
                        .appendChild(Icons.ALL.minus_mdi()
                                .size18()
                                .css("tree-tgl-expanded")
                                .clickable()
                                .addClickListener(evt -> {
                                    evt.stopPropagation();
                                    toggle();
                                    activateItem();
                                })
                        )
                )
                .add(indicatorContainer)
        );
        init();
    }

    public TreeItem(String title) {
        this(title, Icons.ALL.folder().styler(style -> style.setProperty("visibility", "hidden")));
    }

    public TreeItem(BaseIcon<?> icon) {
        setIcon(icon);
        this.anchorElement = DominoElement.of(a()
                .add(this.icon));
        init();
    }

    public TreeItem(String title, T value) {
        this(title);
        this.value = value;
    }

    public TreeItem(String title, BaseIcon<?> icon, T value) {
        this(title, icon);
        this.value = value;
    }

    public TreeItem(BaseIcon<?> icon, T value) {
        this(icon);
        this.value = value;
    }

    public static TreeItem<String> create(String title) {
        TreeItem<String> treeItem = new TreeItem<>(title);
        treeItem.value = title;
        return treeItem;
    }

    public static TreeItem<String> create(String title, BaseIcon<?> icon) {
        TreeItem<String> treeItem = new TreeItem<>(title, icon);
        treeItem.value = title;
        return treeItem;
    }

    public static TreeItem<String> create(BaseIcon<?> icon) {
        TreeItem<String> treeItem = new TreeItem<>(icon);
        treeItem.value = "";
        return treeItem;
    }

    public static <T> TreeItem<T> create(String title, T value) {
        return new TreeItem<>(title, value);
    }

    public static <T> TreeItem<T> create(String title, BaseIcon<?> icon, T value) {
        return new TreeItem<>(title, icon, value);
    }

    public static <T> TreeItem<T> create(BaseIcon<?> icon, T value) {
        return new TreeItem<>(icon, value);
    }

    private void init() {
        this.element = li().element();
        this.element.appendChild(anchorElement.element());
        childrenContainer = ul().css("ml-tree").element();
        element().appendChild(childrenContainer);
        collapsible = Collapsible.create(childrenContainer)
                .addHideHandler(() -> {
                    Style.of(anchorElement).remove("toggled");
                    restoreIcon();
                })
                .addShowHandler(() -> {
                    Style.of(anchorElement).add("toggled");
                    replaceIcon(expandIcon);
                })
                .hide();
        anchorElement.addEventListener("click", evt -> {
            if (ToggleTarget.ANY.equals(this.toggleTarget) && isParent()) {
                toggle();
            }
            activateItem();
        });
        init(this);
        setToggleTarget(ToggleTarget.ANY);
        setWaveColor(WaveColor.THEME);
        applyWaveStyle(WaveStyle.BLOCK);
    }

    private void activateItem() {
        if (nonNull(TreeItem.this.getActiveItem())) {
            TreeItem.this.activeTreeItem.deactivate();
            TreeItem.this.activeTreeItem = null;
        }
        parent.setActiveItem(TreeItem.this);
    }

    public TreeItem<T> appendChild(TreeItem<T> treeItem) {
        this.subItems.add(treeItem);
        childrenContainer.appendChild(treeItem.element());
        Style.of(anchorElement).add("tree-toggle");
        treeItem.parent = this;
        treeItem.setLevel(nextLevel);
        Style.of(treeItem).add("tree-leaf");
        Style.of(this.element()).remove("tree-leaf");
        treeItem.setToggleTarget(this.toggleTarget);
        this.style.add("tree-item-parent");
        return this;
    }

    public TreeItem<T> addSeparator() {
        childrenContainer.appendChild(li().css("separator")
                .add(a())
                .element());
        return this;
    }

    public TreeItem<T> setToggleTarget(ToggleTarget toggleTarget) {
        if (nonNull(toggleTarget)) {
            if (nonNull(this.toggleTarget)) {
                this.removeCss(this.toggleTarget.getStyle());
            }

            this.toggleTarget = toggleTarget;
            this.css(this.toggleTarget.getStyle());
            if (ToggleTarget.ICON.equals(toggleTarget)) {
                if (nonNull(icon)) {
                    icon.setClickable(true);
                }
            } else {
                if (nonNull(icon)) {
                    icon.setClickable(false);
                }
            }

            subItems.forEach(item -> item.setToggleTarget(toggleTarget));
        }
        return this;
    }

    private void toggle() {
        if (isParent()) {
            collapsible.toggleDisplay();
        }
    }

    public TreeItem<T> show() {
        return show(false);
    }

    public TreeItem<T> show(boolean expandParent) {
        if (isParent()) {
            collapsible.show();
        }
        if (expandParent && nonNull(parent)) {
            parent.expand(expandParent);
        }
        return this;
    }

    @Override
    public ParentTreeItem expand() {
        return show();
    }

    public TreeItem<T> expand(boolean expandParent) {
        return show(expandParent);
    }

    public TreeItem<T> hide() {
        if (isParent()) {
            collapsible.hide();
        }
        return this;
    }

    public TreeItem<T> toggleDisplay() {
        if (isParent()) {
            collapsible.toggleDisplay();
        }
        return this;
    }

    @Override
    public boolean isHidden() {
        return collapsible.isHidden();
    }

    @Override
    public TreeItem<T> addHideHandler(Collapsible.HideCompletedHandler handler) {
        collapsible.addHideHandler(handler);
        return this;
    }

    @Override
    public TreeItem<T> removeHideHandler(Collapsible.HideCompletedHandler handler) {
        collapsible.removeHideHandler(handler);
        return this;
    }

    @Override
    public TreeItem<T> addShowHandler(Collapsible.ShowCompletedHandler handler) {
        collapsible.addShowHandler(handler);
        return this;
    }

    @Override
    public TreeItem<T> removeShowHandler(Collapsible.ShowCompletedHandler handler) {
        collapsible.removeShowHandler(handler);
        return this;
    }

    @Override
    public HTMLLIElement element() {
        return element;
    }

    @Override
    public TreeItem<T> getActiveItem() {
        return activeTreeItem;
    }

    @Override
    public Tree getTreeRoot() {
        return parent.getTreeRoot();
    }

    @Override
    public Optional<TreeItem<T>> getParent() {
        if (parent instanceof TreeItem) {
            return Optional.of((TreeItem<T>) parent);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void setActiveItem(TreeItem<T> activeItem) {
        setActiveItem(activeItem, false);
    }

    @Override
    public void setActiveItem(TreeItem<T> activeItem, boolean silent) {
        if (nonNull(activeItem)) {
            if (nonNull(this.activeTreeItem) && !this.activeTreeItem.equals(activeItem)) {
                this.activeTreeItem.deactivate();
            }
            this.activeTreeItem = activeItem;
            this.activeTreeItem.activate();
            parent.setActiveItem(this, true);
            if (!silent) {
                getTreeRoot().onTreeItemClicked(activeItem);
            }
        }
    }

    public List<TreeItem<T>> getPath() {
        List<TreeItem<T>> items = new ArrayList<>();
        items.add(this);
        Optional<TreeItem<T>> parent = getParent();

        while (parent.isPresent()) {
            items.add(parent.get());
            parent = parent.get().getParent();
        }

        Collections.reverse(items);

        return items;
    }

    public List<T> getPathValues() {
        List<T> values = new ArrayList<>();
        values.add(this.getValue());
        Optional<TreeItem<T>> parent = getParent();

        while (parent.isPresent()) {
            values.add(parent.get().getValue());
            parent = parent.get().getParent();
        }

        Collections.reverse(values);

        return values;
    }

    @Override
    public void activate() {
        activate(false);
    }

    @Override
    public void activate(boolean activateParent) {
        Style.of(element()).add("active");
        if (isNull(expandIcon) || collapsible.isHidden() || !isParent()) {
            replaceIcon(this.activeIcon);
        }

        if (activateParent && nonNull(parent)) {
            parent.setActiveItem(this);
        }
    }

    private void replaceIcon(BaseIcon<?> newIcon) {
        if (nonNull(newIcon)) {
            if (nonNull(icon)) {
                icon.remove();
            }
            anchorElement.insertFirst(newIcon);
            this.icon = newIcon;
        }
    }

    @Override
    public void deactivate() {
        Style.of(element()).remove("active");
        if (isNull(expandIcon) || collapsible.isHidden() || !isParent()) {
            restoreIcon();
        }
        if (isParent()) {
            subItems.forEach(TreeItem::deactivate);
            if (getTreeRoot().isAutoCollapse()) {
                collapsible.hide();
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
        return anchorElement.element();
    }

    public TreeItem<T> addClickListener(EventListener listener) {
        getClickableElement().addEventListener(EventType.click.getName(), listener);
        return this;
    }

    public TreeItem<T> setIcon(BaseIcon<?> icon) {
        this.icon = icon;
        this.originalIcon = icon.copy();
        if (icon.element().style.visibility.equals("hidden")) {
            this.originalIcon.styler(style -> style.setProperty("visibility", "hidden"));
        }
        this.originalIcon
                .addClickListener(evt -> {
                    if (ToggleTarget.ICON.equals(this.toggleTarget)) {
                        evt.stopPropagation();
                        toggle();
                    }
                    activateItem();
                });
        return this;
    }

    public TreeItem<T> setActiveIcon(BaseIcon<?> activeIcon) {
        this.activeIcon = this.activeIcon;
        return this;
    }

    public TreeItem<T> setExpandIcon(BaseIcon<?> expandIcon) {
        this.expandIcon = expandIcon;
        return this;
    }

    boolean isParent() {
        return !subItems.isEmpty();
    }

    void setParent(ParentTreeItem<TreeItem<T>> parentMenu) {
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
            if (isParent() && isAutoExpandFound() && collapsible.isHidden()) {
                collapsible.show();
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
        if (isParent() && !collapsible.isHidden()) {
            hide();
            subItems.forEach(TreeItem::collapseAll);
        }
    }

    public void expandAll() {
        if (isParent() && collapsible.isHidden()) {
            show();
            subItems.forEach(TreeItem::expandAll);
        }
    }

    public void setLevel(int level) {
        this.nextLevel = level + 1;
        if (isParent()) {
            subItems.forEach(treeItem -> treeItem.setLevel(nextLevel));
        }
        anchorElement.style().setPaddingLeft(px.of(nextLevel * 15));
    }

    @Override
    public HTMLElement getWavesElement() {
        return anchorElement.element();
    }

    public boolean isLeaf() {
        return subItems.isEmpty();
    }

    /**
     * Returns the list of all sub {@link TreeItem}
     *
     * @return
     */
    @Override
    public List<TreeItem<T>> getSubItems() {
        return subItems;
    }

    public void select() {
        this.show(true).activate(true);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public void removeItem(TreeItem<T> item) {
        subItems.remove(item);
        item.remove();
    }

    public TreeItem<T> remove() {
        if (parent.getSubItems().contains(this)) {
            parent.removeItem(this);
            if (parent.getSubItems().isEmpty() && parent instanceof TreeItem) {
                ((TreeItem<T>) parent).style.remove("tree-item-parent");
            }
        }
        return super.remove();
    }

    public TreeItem<T> setIndicatorContent(Node indicatorContent) {
        indicatorContainer.clearElement();
        if (nonNull(indicatorContent)) {
            indicatorContainer.appendChild(indicatorContent);
        }
        return this;
    }

    public TreeItem<T> setIndicatorContent(IsElement<?> element) {
        setIndicatorContent(element.element());
        return this;
    }

    public TreeItem<T> clearIndicator() {
        indicatorContainer.clearElement();
        return this;
    }

    @Override
    public Collapsible getCollapsible() {
        return collapsible;
    }

    public DominoElement<HTMLElement> getIndicatorContainer() {
        return indicatorContainer;
    }
}
