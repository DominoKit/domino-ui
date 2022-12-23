package org.dominokit.domino.ui.cards;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLImageElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.IsElement;

import java.util.HashSet;
import java.util.Set;

import static org.dominokit.domino.ui.cards.CardStyles.*;

public class CardBox extends BaseDominoElement<HTMLDivElement, CardBox> implements CardStyles, CollapsibleElement<CardBox> {

    private DominoElement<HTMLDivElement> element;
    private DominoElement<HTMLDivElement> body;

    private LazyChild<CardHeader> header;

    private Set<CollapseHandler<CardBox>> collapseHandlers = new HashSet<>();
    private Set<ExpandHandler<CardBox>> expandHandlers = new HashSet<>();
    private LazyChild<UtilityElement<? extends HTMLElement>> collapseElement = NullLazyChild.of();

    private final BaseIcon<?> collapseIcon;


    public static CardBox create() {
        return new CardBox();
    }

    public CardBox() {
        element = DominoElement.div()
                .addCss(card)
                .appendChild(body = DominoElement.div()
                        .addCss(card_body)
                        .setCollapseStrategy(DominoUIConfig.CONFIG.getDefaultCardCollapseStrategySupplier().get())
                );
        header = LazyChild.of(CardHeader.create(), element);
        collapseIcon = DominoUIConfig.CONFIG.getCardCollapseIcon();

        init(this);
    }

    public CardHeader getHeader() {
        return header.get();
    }

    public CardBox withHeader(ChildHandler<CardBox, CardHeader> handler) {
        handler.apply(this, header.get());
        return this;
    }

    public CardBox withHeader() {
        header.get();
        return this;
    }

    public DominoElement<HTMLDivElement> getSubHeader() {
        return header.get().getSubHeader();
    }

    public CardBox withSubHeader() {
        header.get().getSubHeader();
        return this;
    }

    public CardBox withSubHeader(ChildHandler<CardHeader, DominoElement<HTMLDivElement>> handler) {
        handler.apply(header.get(), header.get().getSubHeader());
        return this;
    }

    public CardBox setTitle(String title) {
        header.get().setTitle(title);
        return this;
    }

    public CardBox setDescription(String text) {
        header.get().setDescription(text);
        return this;
    }

    public DominoElement<HTMLDivElement> getTitleElement() {
        return header.get().getTitleElement();
    }

    public CardBox withTitle() {
        header.get().withTitle();
        return this;
    }

    public CardBox withTitle(ChildHandler<CardHeader, DominoElement<HTMLDivElement>> handler) {
        handler.apply(header.get(), header.get().getTitleElement());
        return this;
    }

    public DominoElement<HTMLHeadingElement> getMainTitleElement() {
        return header.get().getMainTitleElement();
    }

    public CardBox withMainTitle() {
        header.get().withMainTitle();
        return this;
    }

    public CardBox withMainTitle(String title) {
        header.get().setTitle(title);
        return this;
    }

    public CardBox withMainTitle(ChildHandler<CardHeader, DominoElement<HTMLHeadingElement>> handler) {
        handler.apply(header.get(), header.get().getMainTitleElement());
        return this;
    }

    public DominoElement<HTMLElement> getDescriptionElement() {
        return header.get().getDescriptionElement();
    }

    public CardBox withDescription() {
        header.get().withDescription();
        return this;
    }

    public CardBox withDescription(String description) {
        header.get().setDescription(description);
        return this;
    }

    public CardBox withDescription(ChildHandler<CardHeader, DominoElement<HTMLElement>> handler) {
        handler.apply(header.get(), header.get().getDescriptionElement());
        return this;
    }

    public DominoElement<HTMLDivElement> getBody() {
        return body;
    }

    public CardBox withBody(ChildHandler<CardBox, DominoElement<HTMLDivElement>> handler) {
        handler.apply(this, body);
        return this;
    }

    public CardBox setLogo(HTMLImageElement img) {
        header.get().setLogo(img);
        return this;
    }

    public CardBox setLogo(IsElement<HTMLImageElement> img) {
        header.get().setLogo(img.element());
        return this;
    }

    public DominoElement<HTMLImageElement> getLogo() {
        return header.get().getLogo();
    }

    public CardBox withLogo(HTMLImageElement img) {
        header.get().setLogo(img);
        return this;
    }

    public CardBox withLogo(IsElement<HTMLImageElement> img) {
        header.get().setLogo(img.element());
        return this;
    }

    public CardBox withLogo() {
        header.get().withLogo();
        return this;
    }

    public CardBox withLogo(ChildHandler<CardHeader, DominoElement<HTMLImageElement>> handler) {
        handler.apply(header.get(), header.get().getLogo());
        return this;
    }

    public CardBox setIcon(BaseIcon<?> icon) {
        header.get().setIcon(icon);
        return this;
    }

    public BaseIcon<?> getIcon() {
        return header.get().getIcon();
    }

    public CardBox withIcon(BaseIcon<?> icon) {
        setIcon(icon);
        return this;
    }

    public CardBox withIcon() {
        header.get().withIcon();
        return this;
    }

    public CardBox withIcon(ChildHandler<CardHeader, BaseIcon<?>> handler) {
        handler.apply(header.get(), header.get().getIcon());
        return this;
    }

    public CardBox appendChild(UtilityElement<?> utility) {
        header.get().appendChild(utility);
        return this;
    }

    public CardBox withUtility(UtilityElement<?> utility) {
        header.get().withUtility(utility);
        return this;
    }

    @Override
    public CardBox setCollapsible(boolean collapsible) {
        collapseElement.remove();
        if (collapsible) {
            header.get().withMainHeader((header, mainHeader) -> {
                collapseElement = LazyChild.of(UtilityElement.of(collapseIcon.clickable())
                                .addCss(card_utility, dui_order_last)
                                .setAttribute("tabindex", "0")
                        , mainHeader);
                collapseElement.whenInitialized(() -> {
                            collapseElement.element()
                                    .addClickListener(evt -> toggleCollapse());
                            KeyboardEvents.listenOnKeyDown(collapseElement.element())
                                    .onEnter(evt -> toggleCollapse());
                        }
                );
            });
            collapseElement.get();
        } else {
            collapseElement.remove();
        }
        return this;
    }

    @Override
    public boolean isCollapsed() {
        return body.isCollapsed();
    }

    @Override
    public CardBox toggleCollapse() {
        toggleCollapse(!isCollapsed());
        return this;
    }

    @Override
    public CardBox toggleCollapse(boolean collapse) {
        if (collapse) {
            collapse();
        } else {
            expand();
        }
        return this;
    }

    @Override
    public CardBox expand() {
        body.getCollapsible().show();
        collapseIcon.changeTo(DominoUIConfig.CONFIG.getCardCollapseIcon());
        expandHandlers.forEach(handler -> handler.onExpanded(this));
        return this;
    }

    @Override
    public CardBox collapse() {
        body.getCollapsible().hide();
        collapseIcon.changeTo(DominoUIConfig.CONFIG.getCardExpandIcon());
        collapseHandlers.forEach(handler -> handler.onCollapsed(this));
        return this;
    }

    @Override
    public Set<CollapseHandler<CardBox>> getCollapseHandlers() {
        return this.collapseHandlers;
    }

    @Override
    public Set<ExpandHandler<CardBox>> getExpandHandlers() {
        return this.expandHandlers;
    }

    @Override
    protected HTMLElement getAppendTarget() {
        return body.element();
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
