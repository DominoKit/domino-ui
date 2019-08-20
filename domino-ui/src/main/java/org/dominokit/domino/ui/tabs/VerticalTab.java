package org.dominokit.domino.ui.tabs;

import elemental2.dom.*;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.*;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.*;

public class VerticalTab extends WavesElement<HTMLDivElement, VerticalTab> implements HasClickableElement {

    private String title;
    private FlexItem element;
    private HTMLAnchorElement anchorElement;

    private BaseIcon<?> icon;
    private HTMLElement titleElement;
    private DominoElement<HTMLDivElement> contentContainer = DominoElement.of(div()
            .attr("role", "tabpanel")
            .css("tab-pane", "fade"));
    private boolean active;
    private DominoElement<HTMLDivElement> iconContainer = DominoElement.div();
    private DominoElement<HTMLDivElement> textContainer = DominoElement.div()
            .styler(style -> style.setMarginTop(Unit.px.of(2)));

    public VerticalTab(String title, BaseIcon<?> icon) {
        this.title = title;
        setIcon(icon);
        this.titleElement = span().css("title").textContent(title).asElement();
        this.anchorElement = a()
                .add(iconContainer.appendChild(this.icon))
                .add(textContainer.appendChild(titleElement)).asElement();
        init();
    }

    public VerticalTab(String title) {
        this.title = title;
        this.titleElement = span().css("title").textContent(title).asElement();
        this.anchorElement = a()
                .add(iconContainer)
                .add(textContainer.appendChild(titleElement)).asElement();
        init();
    }

    public VerticalTab(BaseIcon<?> icon) {
        setIcon(icon);
        this.anchorElement = a()
                .add(iconContainer.appendChild(this.icon))
                .add(textContainer)
                .asElement();
        init();
    }

    public static VerticalTab create(String title) {
        return new VerticalTab(title);
    }

    public static VerticalTab create(String title, BaseIcon<?> icon) {
        return new VerticalTab(title, icon);
    }

    public static VerticalTab create(BaseIcon<?> icon) {
        return new VerticalTab(icon);
    }

    private void init() {
        this.element = FlexItem.create();
        this.element.appendChild(anchorElement);
        init(this);
        setWaveColor(WaveColor.THEME);
        applyWaveStyle(WaveStyle.BLOCK);
    }

    public DominoElement<HTMLDivElement> getContentContainer() {
        return DominoElement.of(contentContainer);
    }

    public VerticalTab activate() {
        Style.of(asElement()).add("active");
        contentContainer.style().add("in", "active");
        this.active = true;
        return this;
    }

    public VerticalTab deactivate() {
        Style.of(asElement()).remove("active");
        contentContainer.style().remove("in", "active");
        this.active = false;
        return this;
    }

    public VerticalTab appendChild(Node content) {
        contentContainer.appendChild(content);
        return this;
    }

    public VerticalTab setTitle(String title){
        titleElement.textContent = title;
        return this;
    }

    public VerticalTab appendChild(IsElement content) {
        return appendChild(content.asElement());
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return anchorElement;
    }

    public VerticalTab setIcon(BaseIcon<?> icon) {
        this.icon = icon;
        iconContainer.clearElement();
        iconContainer.appendChild(icon);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public boolean isActive() {
        return active;
    }

    public DominoElement<HTMLElement> getTitleElement() {
        return DominoElement.of(titleElement);
    }

    @Override
    public HTMLElement getWavesElement() {
        return anchorElement;
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }

}
