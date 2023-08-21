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

import static java.util.Objects.nonNull;

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLImageElement;
import java.util.HashSet;
import java.util.Set;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.config.CardConfig;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.ImageElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;

/** Card class. */
public class Card extends BaseDominoElement<HTMLDivElement, Card>
    implements CardStyles, CollapsibleElement<Card>, HasComponentConfig<CardConfig> {
  private DivElement element;
  private DivElement body;

  private LazyChild<CardHeader> header;

  private Set<CollapseHandler<Card>> collapseHandlers = new HashSet<>();
  private Set<ExpandHandler<Card>> expandHandlers = new HashSet<>();
  private LazyChild<PostfixAddOn<? extends Element>> collapseElement = NullLazyChild.of();

  private final ToggleIcon<?, ?> collapseIcon;

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public static Card create() {
    return new Card();
  }

  /**
   * create.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public static Card create(String title) {
    return new Card(title);
  }

  /**
   * create.
   *
   * @param title a {@link java.lang.String} object
   * @param description a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public static Card create(String title, String description) {
    return new Card(title, description);
  }

  /**
   * Constructor for Card.
   *
   * @param title a {@link java.lang.String} object
   */
  public Card(String title) {
    this();
    setTitle(title);
  }

  /**
   * Constructor for Card.
   *
   * @param title a {@link java.lang.String} object
   * @param description a {@link java.lang.String} object
   */
  public Card(String title, String description) {
    this(title);
    setDescription(description);
  }

  /** Constructor for Card. */
  public Card() {
    element = div().addCss(dui_card).appendChild(body = div().addCss(dui_card_body));
    header = LazyChild.of(CardHeader.create(), element);
    collapseIcon = getConfig().getCardCollapseExpandIcon().get();

    init(this);
  }

  /**
   * Getter for the field <code>header</code>.
   *
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader getHeader() {
    return header.get();
  }

  /**
   * withHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withHeader(ChildHandler<Card, CardHeader> handler) {
    handler.apply(this, header.get());
    return this;
  }

  /**
   * withHeader.
   *
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withHeader() {
    header.get();
    return this;
  }

  /**
   * getSubHeader.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getSubHeader() {
    return header.get().getSubHeader();
  }

  /**
   * withSubHeader.
   *
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withSubHeader() {
    header.get().getSubHeader();
    return this;
  }

  /**
   * withSubHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withSubHeader(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(header.get(), header.get().getSubHeader());
    return this;
  }

  /**
   * setTitle.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card setTitle(String title) {
    header.get().setTitle(title);
    return this;
  }

  /**
   * setDescription.
   *
   * @param text a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card setDescription(String text) {
    header.get().setDescription(text);
    return this;
  }

  /**
   * getTitleElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getTitleElement() {
    return header.get().getTitleElement();
  }

  /**
   * withTitle.
   *
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withTitle() {
    header.get().withTitle();
    return this;
  }

  /**
   * withTitle.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withTitle(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(header.get(), header.get().getTitleElement());
    return this;
  }

  /**
   * getMainTitleElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.HeadingElement} object
   */
  public HeadingElement getMainTitleElement() {
    return header.get().getMainTitleElement();
  }

  /**
   * withMainTitle.
   *
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withMainTitle() {
    header.get().withMainTitle();
    return this;
  }

  /**
   * withMainTitle.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withMainTitle(String title) {
    header.get().setTitle(title);
    return this;
  }

  /**
   * withMainTitle.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withMainTitle(ChildHandler<CardHeader, HeadingElement> handler) {
    handler.apply(header.get(), header.get().getMainTitleElement());
    return this;
  }

  /**
   * getDescriptionElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SmallElement} object
   */
  public SmallElement getDescriptionElement() {
    return header.get().getDescriptionElement();
  }

  /**
   * withDescription.
   *
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withDescription() {
    header.get().withDescription();
    return this;
  }

  /**
   * withDescription.
   *
   * @param description a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withDescription(String description) {
    header.get().setDescription(description);
    return this;
  }

  /**
   * withDescription.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withDescription(ChildHandler<CardHeader, SmallElement> handler) {
    handler.apply(header.get(), header.get().getDescriptionElement());
    return this;
  }

  /**
   * Getter for the field <code>body</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getBody() {
    return body;
  }

  /**
   * withBody.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withBody(ChildHandler<Card, DivElement> handler) {
    handler.apply(this, body);
    return this;
  }

  /**
   * setLogo.
   *
   * @param img a {@link elemental2.dom.HTMLImageElement} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card setLogo(HTMLImageElement img) {
    header.get().setLogo(img);
    return this;
  }

  /**
   * setLogo.
   *
   * @param img a {@link org.dominokit.domino.ui.elements.ImageElement} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card setLogo(ImageElement img) {
    header.get().setLogo(img);
    return this;
  }

  /**
   * setLogo.
   *
   * @param img a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card setLogo(IsElement<HTMLImageElement> img) {
    header.get().setLogo(img.element());
    return this;
  }

  /**
   * getLogo.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ImageElement} object
   */
  public ImageElement getLogo() {
    return header.get().getLogo();
  }

  /**
   * withLogo.
   *
   * @param img a {@link elemental2.dom.HTMLImageElement} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withLogo(HTMLImageElement img) {
    header.get().setLogo(img);
    return this;
  }

  /**
   * withLogo.
   *
   * @param img a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withLogo(IsElement<HTMLImageElement> img) {
    header.get().setLogo(img.element());
    return this;
  }

  /**
   * withLogo.
   *
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withLogo() {
    header.get().withLogo();
    return this;
  }

  /**
   * withLogo.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withLogo(ChildHandler<CardHeader, ImageElement> handler) {
    handler.apply(header.get(), header.get().getLogo());
    return this;
  }

  /**
   * setIcon.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card setIcon(Icon<?> icon) {
    header.get().setIcon(icon);
    return this;
  }

  /**
   * getIcon.
   *
   * @return a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public Icon<?> getIcon() {
    return header.get().getIcon();
  }

  /**
   * withIcon.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withIcon(Icon<?> icon) {
    setIcon(icon);
    return this;
  }

  /**
   * withIcon.
   *
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withIcon() {
    header.get().withIcon();
    return this;
  }

  /**
   * withIcon.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withIcon(ChildHandler<CardHeader, Icon<?>> handler) {
    handler.apply(header.get(), header.get().getIcon());
    return this;
  }

  /**
   * appendChild.
   *
   * @param utility a {@link org.dominokit.domino.ui.utils.PostfixAddOn} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card appendChild(PostfixAddOn<?> utility) {
    header.get().appendChild(utility);
    return this;
  }

  /**
   * withUtility.
   *
   * @param utility a {@link org.dominokit.domino.ui.utils.PostfixAddOn} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card withUtility(PostfixAddOn<?> utility) {
    header.get().appendChild(utility);
    return this;
  }

  /**
   * setHeaderPosition.
   *
   * @param headerPosition a {@link org.dominokit.domino.ui.cards.HeaderPosition} object
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public Card setHeaderPosition(HeaderPosition headerPosition) {
    addCss(BooleanCssClass.of(dui_card_header_bottom, HeaderPosition.BOTTOM == headerPosition));
    if (nonNull(collapseIcon) && collapseIcon instanceof ToggleMdiIcon) {
      if (HeaderPosition.BOTTOM == headerPosition) {
        ((ToggleMdiIcon) collapseIcon).flipV();
      }
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Card setCollapsible(boolean collapsible) {
    collapseElement.remove();
    if (collapsible) {
      body.setCollapseStrategy(getConfig().getDefaultCardCollapseStrategySupplier().get());
      header
          .get()
          .withMainHeader(
              (header, mainHeader) -> {
                collapseElement =
                    LazyChild.of(
                        PostfixAddOn.of(collapseIcon.clickable())
                            .addCss(dui_order_last)
                            .setAttribute("tabindex", "0"),
                        mainHeader);
                collapseElement.whenInitialized(
                    () -> {
                      collapseElement.element().addClickListener(evt -> toggleCollapse());
                      collapseElement
                          .element()
                          .onKeyDown(keyEvents -> keyEvents.onEnter(evt -> toggleCollapse()));
                    });
              });
      collapseElement.get();
    } else {
      collapseElement.remove();
      body.getCollapsible().getStrategy().cleanup(body.element());
    }
    body.addCollapseListener(
        () -> collapseHandlers.forEach(handler -> handler.onCollapsed(Card.this)));
    body.addExpandListener(() -> expandHandlers.forEach(handler -> handler.onExpanded(Card.this)));

    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isCollapsed() {
    return body.isCollapsed();
  }

  /** {@inheritDoc} */
  @Override
  public Card toggleCollapse() {
    toggleCollapse(!isCollapsed());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Card toggleCollapse(boolean collapse) {
    if (collapse) {
      collapse();
    } else {
      expand();
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Card expand() {
    body.getCollapsible().expand();
    collapseIcon.toggle();
    expandHandlers.forEach(handler -> handler.onExpanded(this));
    removeCss(() -> "dui-collapsed");
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Card collapse() {
    body.getCollapsible().collapse();
    collapseIcon.toggle();
    collapseHandlers.forEach(handler -> handler.onCollapsed(this));
    addCss(() -> "dui-collapsed");
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Set<CollapseHandler<Card>> getCollapseHandlers() {
    return this.collapseHandlers;
  }

  /** {@inheritDoc} */
  @Override
  public Set<ExpandHandler<Card>> getExpandHandlers() {
    return this.expandHandlers;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement getAppendTarget() {
    return body.element();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
