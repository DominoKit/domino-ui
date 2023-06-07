package org.dominokit.domino.ui.tree;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PostfixAddOn;

import static java.util.Objects.nonNull;

public class TreeHeader extends BaseDominoElement<HTMLDivElement, TreeHeader> implements TreeStyles {

    private final DivElement element;
    private final DivElement content;
    private LazyChild<Icon<?>> headerIcon;
    private final LazyChild<SpanElement> textElement;

    public static TreeHeader create() {
       return new TreeHeader();
    }

    public static TreeHeader create(Icon<?> icon) {
        return new TreeHeader(icon);
    }

    public static TreeHeader create(String title) {
        return new TreeHeader(title);
    }

    public static TreeHeader create(Icon<?> icon, String title) {
        return new TreeHeader(icon, title);
    }

    public TreeHeader() {
        element = div()
                .addCss(dui_tree_header)
                .appendChild(content = div()
                        .addCss(dui_tree_item_content)
                        .appendChild(div().addCss(dui_tree_item_filler))
                );
        textElement = LazyChild.of(span().addCss(dui_tree_header_item, dui_tree_item_text), content);
        init(this);
    }

    public TreeHeader(Icon<?> icon) {
        this();
        setIcon(icon);
    }

    public TreeHeader(String title) {
        this();
        setTitle(title);
    }

    public TreeHeader(Icon<?> icon, String title) {
        this();
        setIcon(icon);
        setTitle(title);
    }

    public TreeHeader setTitle(String title){
        textElement.get().setTextContent(title);
        return this;
    }

    public TreeHeader setIcon(Icon<?> icon){
        if(nonNull(headerIcon) && headerIcon.isInitialized()){
            headerIcon.remove();
        }

        headerIcon = LazyChild.of(icon.addCss(dui_tree_header_item, dui_tree_item_icon), content);
        headerIcon.get();
        return this;
    }

    public TreeHeader appendChild(PostfixAddOn<?> postfixAddOn){
        if(nonNull(postfixAddOn)){
            postfixAddOn.addCss(dui_tree_header_item);
            content.appendChild(postfixAddOn);
        }
        return this;
    }

    public TreeHeader withContent(ChildHandler<TreeHeader, DivElement> handler){
        handler.apply(this, content);
        return this;
    }

    public DivElement getContent(){
        return content;
    }

    public TreeHeader withTitle(ChildHandler<TreeHeader, SpanElement> handler){
        handler.apply(this, textElement.get());
        return this;
    }

    public TreeHeader withTitle(){
        textElement.get();
        return this;
    }
    public SpanElement getTitle(){
        return textElement.get();
    }

    @Override
    protected HTMLElement getAppendTarget() {
        return content.element();
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
