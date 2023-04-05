/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.cards;

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLImageElement;
import java.util.HashSet;
import java.util.Set;

import org.dominokit.domino.ui.config.CardConfig;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.ImageElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.utils.*;
import org.dominokit.domino.ui.IsElement;

public class Card extends BaseDominoElement<HTMLDivElement, Card>
    implements CardStyles, CollapsibleElement<Card>, HasComponentConfig<CardConfig> {

  private DivElement element;
  private DivElement body;

  private LazyChild<CardHeader> header;

  private Set<CollapseHandler<Card>> collapseHandlers = new HashSet<>();
  private Set<ExpandHandler<Card>> expandHandlers = new HashSet<>();
  private LazyChild<PostfixAddOn<? extends Element>> collapseElement = NullLazyChild.of();

  private final ToggleIcon<?, ?> collapseIcon;

  public static Card create() {
    return new Card();
  }
  public static Card create(String title) {
    return new Card(title);
  }

  public static Card create(String title, String description) {
    return new Card(title, description);
  }

  public Card(String title){
    this();
    setTitle(title);
  }
  public Card(String title, String description){
    this(title);
    setDescription(description);
  }
  public Card() {
    element =
        div()
            .addCss(card)
            .appendChild(
                body =
                    div()
                        .addCss(card_body)
                        .setCollapseStrategy(
                            getConfig().getDefaultCardCollapseStrategySupplier().get()));
    header = LazyChild.of(CardHeader.create(), element);
    collapseIcon = getConfig().getCardCollapseExpandIcon().get();

    init(this);
  }

  public CardHeader getHeader() {
    return header.get();
  }

  public Card withHeader(ChildHandler<Card, CardHeader> handler) {
    handler.apply(this, header.get());
    return this;
  }

  public Card withHeader() {
    header.get();
    return this;
  }

  public DivElement getSubHeader() {
    return header.get().getSubHeader();
  }

  public Card withSubHeader() {
    header.get().getSubHeader();
    return this;
  }

  public Card withSubHeader(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(header.get(), header.get().getSubHeader());
    return this;
  }

  public Card setTitle(String title) {
    header.get().setTitle(title);
    return this;
  }

  public Card setDescription(String text) {
    header.get().setDescription(text);
    return this;
  }

  public DivElement getTitleElement() {
    return header.get().getTitleElement();
  }

  public Card withTitle() {
    header.get().withTitle();
    return this;
  }

  public Card withTitle(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(header.get(), header.get().getTitleElement());
    return this;
  }

  public HeadingElement getMainTitleElement() {
    return header.get().getMainTitleElement();
  }

  public Card withMainTitle() {
    header.get().withMainTitle();
    return this;
  }

  public Card withMainTitle(String title) {
    header.get().setTitle(title);
    return this;
  }

  public Card withMainTitle(
      ChildHandler<CardHeader, HeadingElement> handler) {
    handler.apply(header.get(), header.get().getMainTitleElement());
    return this;
  }

  public SmallElement getDescriptionElement() {
    return header.get().getDescriptionElement();
  }

  public Card withDescription() {
    header.get().withDescription();
    return this;
  }

  public Card withDescription(String description) {
    header.get().setDescription(description);
    return this;
  }

  public Card withDescription(ChildHandler<CardHeader, SmallElement> handler) {
    handler.apply(header.get(), header.get().getDescriptionElement());
    return this;
  }

  public DivElement getBody() {
    return body;
  }

  public Card withBody(ChildHandler<Card, DivElement> handler) {
    handler.apply(this, body);
    return this;
  }

  public Card setLogo(HTMLImageElement img) {
    header.get().setLogo(img);
    return this;
  }

  public Card setLogo(IsElement<HTMLImageElement> img) {
    header.get().setLogo(img.element());
    return this;
  }

  public ImageElement getLogo() {
    return header.get().getLogo();
  }

  public Card withLogo(HTMLImageElement img) {
    header.get().setLogo(img);
    return this;
  }

  public Card withLogo(IsElement<HTMLImageElement> img) {
    header.get().setLogo(img.element());
    return this;
  }

  public Card withLogo() {
    header.get().withLogo();
    return this;
  }

  public Card withLogo(ChildHandler<CardHeader, ImageElement> handler) {
    handler.apply(header.get(), header.get().getLogo());
    return this;
  }

  public Card setIcon(Icon<?> icon) {
    header.get().setIcon(icon);
    return this;
  }

  public Icon<?> getIcon() {
    return header.get().getIcon();
  }

  public Card withIcon(Icon<?> icon) {
    setIcon(icon);
    return this;
  }

  public Card withIcon() {
    header.get().withIcon();
    return this;
  }

  public Card withIcon(ChildHandler<CardHeader, Icon<?>> handler) {
    handler.apply(header.get(), header.get().getIcon());
    return this;
  }

  public Card appendChild(PostfixAddOn<?> utility) {
    header.get().appendChild(utility);
    return this;
  }

  public Card withUtility(PostfixAddOn<?> utility) {
    header.get().appendChild(utility);
    return this;
  }

  @Override
  public Card setCollapsible(boolean collapsible) {
    collapseElement.remove();
    if (collapsible) {
      header
          .get()
          .withMainHeader(
              (header, mainHeader) -> {
                collapseElement =
                    LazyChild.of(
                        PostfixAddOn.of(collapseIcon.clickable())
                            .addCss(card_utility, dui_order_last)
                            .setAttribute("tabindex", "0"),
                        mainHeader);
                collapseElement.whenInitialized(
                    () -> {
                      collapseElement.element().addClickListener(evt -> toggleCollapse());
                      collapseElement.element().onKeyDown(keyEvents -> keyEvents.onEnter(evt -> toggleCollapse()));
                    });
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
  public Card toggleCollapse() {
    toggleCollapse(!isCollapsed());
    return this;
  }

  @Override
  public Card toggleCollapse(boolean collapse) {
    if (collapse) {
      collapse();
    } else {
      expand();
    }
    return this;
  }

  @Override
  public Card expand() {
    body.getCollapsible().expand();
    collapseIcon.toggle();
    expandHandlers.forEach(handler -> handler.onExpanded(this));
    return this;
  }

  @Override
  public Card collapse() {
    body.getCollapsible().collapse();
    collapseIcon.toggle();
    collapseHandlers.forEach(handler -> handler.onCollapsed(this));
    return this;
  }

  @Override
  public Set<CollapseHandler<Card>> getCollapseHandlers() {
    return this.collapseHandlers;
  }

  @Override
  public Set<ExpandHandler<Card>> getExpandHandlers() {
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
