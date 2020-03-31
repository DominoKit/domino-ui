package org.dominokit.domino.ui.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.search.Search;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.style.Unit;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ParentTreeItem;
import org.jboss.elemento.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

public class Tree<T> extends BaseDominoElement<HTMLDivElement, Tree<T>> implements ParentTreeItem<TreeItem<T>>, IsElement<HTMLDivElement> {

    private HTMLElement title = span().css("title").element();
    private ToggleTarget toggleTarget = ToggleTarget.ANY;

    private HTMLLIElement header = li()
            .css("header")
            .css("menu-header")
            .add(title)
            .element();

    private HTMLUListElement root = ul()
            .add(header)
            .css("list")
            .element();

    private HTMLDivElement menu = div().style("overflow-x: hidden")
            .css("menu")
            .add(root)
            .element();


    private final int nextLevel = 1;

    private TreeItem<T> activeTreeItem;

    private boolean autoCollapse = true;
    private List<TreeItem<T>> subItems = new ArrayList<>();
    private boolean autoExpandFound;
    private ColorScheme colorScheme;
    private Search search;
    private Icon searchIcon;
    private Icon collapseAllIcon;
    private Icon expandAllIcon;

    private T value;

    private final List<ItemClickListener<T>> itemsClickListeners = new ArrayList<>();

    public Tree() {
        this("");
    }

    public Tree(String treeTitle) {
        init(this);
        if (isNull(treeTitle) || treeTitle.trim().isEmpty()) {
            DominoElement.of(header)
                    .hide();
        }
        title.textContent = treeTitle;
    }

    public Tree(String treeTitle, T value) {
        this(treeTitle);
        this.value = value;
    }

    public Tree(T value) {
        this("");
        this.value = value;
    }

    public static Tree<String> create(String title) {
        Tree<String> tree = new Tree<>(title);
        return tree;
    }

    public static Tree<String> create() {
        Tree<String> tree = new Tree<>();
        DominoElement.of(tree.header)
                .hide();
        return tree;
    }

    public static <T> Tree<T> create(String title, T value) {
        Tree<T> tree = new Tree<>(title, value);
        return tree;
    }

    public static <T> Tree<T> create(T value) {
        Tree<T> tree = new Tree<>(value);
        return tree;
    }

    public Tree<T> appendChild(TreeItem<T> treeItem) {
        root.appendChild(treeItem.element());
        treeItem.setParent(this);
        treeItem.setLevel(nextLevel);
        treeItem.setToggleTarget(this.toggleTarget);
        this.subItems.add(treeItem);
        return this;
    }

    public Tree<T> addSeparator() {
        root.appendChild(li()
                .css("gap")
                .css("separator")
                .add(a())
                .element());
        return this;
    }

    public Tree<T> addGap() {
        root.appendChild(li()
                .css("gap")
                .add(a())
                .element());
        return this;
    }

    public Tree<T> setToggleTarget(ToggleTarget toggleTarget) {
        if (nonNull(toggleTarget)) {
            subItems.forEach(item -> item.setToggleTarget(toggleTarget));
            this.toggleTarget = toggleTarget;
        }
        return this;
    }

    public Tree setColorScheme(ColorScheme colorScheme) {
        if (nonNull(this.colorScheme)) {
            style.remove(colorScheme.color().getBackground());
            DominoElement.of(header).style().remove(this.colorScheme.darker_3().getBackground());
        }
        this.colorScheme = colorScheme;

        style.add(colorScheme.color().getBackground());
        DominoElement.of(header).style().add(this.colorScheme.darker_3().getBackground());

        return this;
    }


    @Override
    public TreeItem<T> getActiveItem() {
        return activeTreeItem;
    }

    @Override
    public void setActiveItem(TreeItem<T> activeItem) {
        setActiveItem(activeItem, false);
    }

    @Override
    public void setActiveItem(TreeItem<T> activeItem, boolean silent) {
        if (nonNull(this.activeTreeItem) && !this.activeTreeItem.equals(activeItem)) {
            this.activeTreeItem.deactivate();
        }

        this.activeTreeItem = activeItem;
        this.activeTreeItem.activate();
        if (!silent) {
            onTreeItemClicked(activeItem);
        }
    }

    public DominoElement<HTMLLIElement> getHeader() {
        return DominoElement.of(header);
    }

    public DominoElement<HTMLUListElement> getRoot() {
        return DominoElement.of(root);
    }

    public DominoElement<HTMLElement> getTitle() {
        return DominoElement.of(title);
    }

    public Tree<T> autoHeight() {
        root.style.height = CSSProperties.HeightUnionType.of("calc(100vh - 83px)");
        element().style.height = CSSProperties.HeightUnionType.of("calc(100vh - 70px)");
        return this;
    }

    public Tree<T> autoHeight(int offset) {
        root.style.height = CSSProperties.HeightUnionType.of("calc(100vh - " + offset + 13 + "px)");
        element().style.height = CSSProperties.HeightUnionType.of("calc(100vh - " + offset + "px)");
        return this;
    }

    public Tree<T> enableSearch() {
        search = Search.create(true)
                .styler(style -> style.setHeight(Unit.px.of(40)))
                .onSearch(Tree.this::filter)
                .onClose(this::clearFilter);

        searchIcon = Icons.ALL.search()
                .style()
                .setMarginBottom("0px")
                .setMarginTop("0px")
                .add(Styles.pull_right)
                .setProperty("cursor", "pointer")
                .get();

        this.header.appendChild(search.element());
        this.header.appendChild(searchIcon.element());
        searchIcon.element().addEventListener("click", evt -> search.open());

        return this;
    }

    public Tree<T> enableFolding() {
        collapseAllIcon = Icons.ALL.fullscreen_exit()
                .style()
                .setMarginBottom("0px")
                .setMarginTop("0px")
                .add(Styles.pull_right)
                .setProperty("cursor", "pointer")
                .get();

        collapseAllIcon.element().addEventListener("click", evt -> collapseAll());


        expandAllIcon = Icons.ALL.fullscreen()
                .style()
                .setMarginBottom("0px")
                .setMarginTop("0px")
                .add(Styles.pull_right)
                .setProperty("cursor", "pointer")
                .get();

        expandAllIcon.element().addEventListener("click", evt -> expandAll());

        header.appendChild(expandAllIcon.element());
        header.appendChild(collapseAllIcon.element());
        return this;
    }

    public void expandAll() {
        getSubItems().forEach(TreeItem::expandAll);
    }

    public void collapseAll() {
        getSubItems().forEach(TreeItem::collapseAll);
    }

    public void deactivateAll() {
        getSubItems().forEach(TreeItem::deactivate);
    }

    public Tree<T> autoExpandFound() {
        this.autoExpandFound = true;
        return this;
    }

    @Override
    public boolean isAutoExpandFound() {
        return autoExpandFound;
    }

    public void setAutoExpandFound(boolean autoExpandFound) {
        this.autoExpandFound = autoExpandFound;
    }

    public void clearFilter() {
        subItems.forEach(TreeItem::clearFilter);
    }

    public void filter(String searchToken) {
        subItems.forEach(treeItem -> treeItem.filter(searchToken));
    }

    @Override
    public Tree<T> getTreeRoot() {
        return this;
    }

    public Tree<T> setAutoCollapse(boolean autoCollapse) {
        this.autoCollapse = autoCollapse;
        return this;
    }

    public Tree<T> setTitle(String title) {
        getTitle().setTextContent(title);
        if (getHeader().isHidden()) {
            getHeader().show();
        }
        return this;
    }

    public boolean isAutoCollapse() {
        return autoCollapse;
    }

    @Override
    public List<TreeItem<T>> getSubItems() {
        return new ArrayList<>(subItems);
    }

    public ParentTreeItem expand(boolean expandParent) {
        return this;
    }

    public ParentTreeItem expand() {
        return this;
    }

    @Override
    public Optional<TreeItem<T>> getParent() {
        return Optional.empty();
    }

    @Override
    public void activate() {

    }

    @Override
    public void activate(boolean activateParent) {

    }

    public Search getSearch() {
        return search;
    }

    public Icon getSearchIcon() {
        return searchIcon;
    }

    public Icon getCollapseAllIcon() {
        return collapseAllIcon;
    }

    public Icon getExpandAllIcon() {
        return expandAllIcon;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Tree<T> addItemClickListener(ItemClickListener<T> itemClickListener) {
        this.itemsClickListeners.add(itemClickListener);
        return this;
    }

    public Tree<T> removeItemClickListener(ItemClickListener<T> itemClickListener) {
        this.itemsClickListeners.remove(itemClickListener);
        return this;
    }

    void onTreeItemClicked(TreeItem<T> treeItem) {
        this.itemsClickListeners.forEach(itemClickListener -> itemClickListener.onTreeItemClicked(treeItem));
    }

    public List<TreeItem<T>> getActivePath() {
        List<TreeItem<T>> activeItems = new ArrayList<>();
        TreeItem<T> activeItem = getActiveItem();
        while (nonNull(activeItem)) {
            activeItems.add(activeItem);
            activeItem = activeItem.getActiveItem();
        }

        return activeItems;
    }

    public List<T> getActivePathValues() {
        List<T> activeValues = new ArrayList<>();
        TreeItem<T> activeItem = getActiveItem();
        while (nonNull(activeItem)) {
            activeValues.add(activeItem.getValue());
            activeItem = activeItem.getActiveItem();
        }

        return activeValues;
    }

    @Override
    public void removeItem(TreeItem<T> item) {
        subItems.remove(item);
        item.remove();
    }

    @Override
    public HTMLDivElement element() {
        return menu;
    }

    public interface ItemClickListener<T> {
        void onTreeItemClicked(TreeItem<T> treeItem);
    }
}
