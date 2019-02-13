package org.dominokit.domino.ui.tabs;

import elemental2.dom.*;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Tab extends BaseDominoElement<HTMLLIElement, Tab> implements HasClickableElement {

    private HTMLAnchorElement clickableElement = a().asElement();
    private DominoElement<HTMLLIElement> tab = DominoElement.of(li().attr("role", "presentation").add(clickableElement));
    private DominoElement<HTMLDivElement> contentContainer = DominoElement.of(div().attr("role", "tabpanel").css("tab-pane", "fade"));
    private boolean active;

    public Tab(String text) {
        this(null, text);
    }

    public Tab(BaseIcon<?> icon) {
        this(icon, null);
    }

    public Tab(BaseIcon<?> icon, String text) {
        if (nonNull(icon)) {
            clickableElement.appendChild(icon.asElement());
        }
        if (nonNull(text)) {
            clickableElement.appendChild(span().add(TextNode.of(text)).asElement());
        }
        init(this);
        withWaves();
    }

    public static Tab create(String text) {
        return new Tab(text);
    }

    public static Tab create(BaseIcon<?> icon) {
        return new Tab(icon);
    }

    public static Tab create(BaseIcon<?> icon, String text) {
        return new Tab(icon, text);
    }

    public DominoElement<HTMLLIElement> getTab() {
        return DominoElement.of(tab);
    }

    public DominoElement<HTMLDivElement> getContentContainer() {
        return DominoElement.of(contentContainer);
    }

    /**
     * @deprecated use {@link #appendChild(Node)}
     */
    @Deprecated
    public Tab appendContent(Node content) {
        return appendChild(content);
    }


    public Tab appendChild(Node content) {
        contentContainer.appendChild(content);
        return this;
    }

    public Tab appendChild(IsElement content) {
        return appendChild(content.asElement());
    }


    public Tab activate() {
        tab.style().add("active");
        contentContainer.style().add("in", "active");
        this.active = true;
        return this;
    }

    public Tab deActivate() {
        tab.style().remove("active");
        contentContainer.style().remove("in", "active");
        this.active = false;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return clickableElement;
    }

    @Override
    public HTMLLIElement asElement() {
        return tab.asElement();
    }
}
