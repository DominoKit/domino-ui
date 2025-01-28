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
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_order_last;

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

/**
 * A container component to host other components and elements that provide some extended features
 * like, collapsible body, feature rich header that comes with logo area, title, description and
 * actions toolbar and more.
 *
 * @see BaseDominoElement
 */
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
   * factory method to create an empty card without a header
   *
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public static Card create() {
    return new Card();
  }

  /**
   * Factory method to create a card with a title in the header
   *
   * @param title The card title text.
   * @return new Card instance
   */
  public static Card create(String title) {
    return new Card(title);
  }

  /**
   * Factory method to create a card with a title in the header and a description below the title
   *
   * @param title The card title text
   * @param description The card description text
   * @return new Card instance
   */
  public static Card create(String title, String description) {
    return new Card(title, description);
  }

  /**
   * Creates a card with title in the header
   *
   * @param title The card title text
   */
  public Card(String title) {
    this();
    setTitle(title);
  }

  /**
   * Creates a card with the title in the header and a description below the title
   *
   * @param title The card title text
   * @param description The card description text
   */
  public Card(String title, String description) {
    this(title);
    setDescription(description);
  }

  /** Creates an empty Card without a header. */
  public Card() {
    element = div().addCss(dui_card).appendChild(body = div().addCss(dui_card_body));
    header = LazyChild.of(CardHeader.create(), element);
    collapseIcon = getConfig().getCardCollapseExpandIcon().get();

    init(this);
  }

  /**
   * Calling this will assume the Header is needed to for customization and will initialize the
   * header and append it to the card if not already initialized.
   *
   * @return This {@link org.dominokit.domino.ui.cards.CardHeader} component instance for this card
   */
  public CardHeader getHeader() {
    return header.get();
  }

  /**
   * Use this to apply customization to the header of this card instance, this will initialize the
   * card header and append it to the card if not already initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations
   * @return same Card instance
   */
  public Card withHeader(ChildHandler<Card, CardHeader> handler) {
    handler.apply(this, header.get());
    return this;
  }

  /**
   * Initialize the card header and append it to the card if not already initialized.
   *
   * @return same Card instance
   */
  public Card withHeader() {
    header.get();
    return this;
  }

  /**
   * Calling this will assume the Header is needed to for customization and will initialize the
   * header and append it to the card if not already initialized. And will also initialize and
   * append the sub-header to the card header if not already initialized.
   *
   * @return The {@link org.dominokit.domino.ui.elements.DivElement} that represent this card
   *     sub-header, sub-header is part of the card header.
   */
  public DivElement getSubHeader() {
    return header.get().getSubHeader();
  }

  /**
   * Calling this will assume the Header is needed to for customization and will initialize the
   * header and append it to the card if not already initialized. And will also initialize and
   * append the sub-header to the card header if not already initialized.
   *
   * @return same Card instance
   */
  public Card withSubHeader() {
    header.get().getSubHeader();
    return this;
  }

  /**
   * Use to apply customization to the card sub-header, this will initialize both the CardHeader and
   * the sub-header and append them if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customization
   * @return same Card instance
   */
  public Card withSubHeader(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(header.get(), header.get().getSubHeader());
    return this;
  }

  /**
   * Sets the card title, this will initialize and append the card header if not yet initialized.
   *
   * @param title The card title text
   * @return same Card instance
   */
  public Card setTitle(String title) {
    header.get().setTitle(title);
    return this;
  }

  /**
   * Sets the card description, this will initialize and append the card header if not yet
   * initialized.
   *
   * @param text The card description text
   * @return same Card instance
   */
  public Card setDescription(String text) {
    header.get().setDescription(text);
    return this;
  }

  /**
   * This will initialize and append the card header if not yet initialized.
   *
   * @return The {@link org.dominokit.domino.ui.elements.DivElement} that holds both the card title
   *     and description.
   */
  public DivElement getTitleElement() {
    return header.get().getTitleElement();
  }

  /**
   * This will initialize and append the card header if not yet initialized.
   *
   * @return same Card instance
   */
  public Card withTitle() {
    header.get().withTitle();
    return this;
  }

  /**
   * Use to apply customization on the Card title element without breaking the fluent API chain.
   * This will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public Card withTitle(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(header.get(), header.get().getTitleElement());
    return this;
  }

  /**
   * This will initialize and append the card header if not yet initialized.
   *
   * @return The {@link org.dominokit.domino.ui.elements.HeadingElement} that holds the card main
   *     title text
   */
  public HeadingElement getMainTitleElement() {
    return header.get().getMainTitleElement();
  }

  /**
   * This will initialize and append the card header if not yet initialized.
   *
   * @return same Card instance
   */
  public Card withMainTitle() {
    header.get().withMainTitle();
    return this;
  }

  /**
   * Sets the card main title. This will initialize and append the card header if not yet
   * initialized.
   *
   * @param title The card main title text
   * @return same Card instance
   */
  public Card withMainTitle(String title) {
    header.get().setTitle(title);
    return this;
  }

  /**
   * Use to apply customization on the Card main title element without breaking the fluent API
   * chain. This will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public Card withMainTitle(ChildHandler<CardHeader, HeadingElement> handler) {
    handler.apply(header.get(), header.get().getMainTitleElement());
    return this;
  }

  /**
   * This will initialize and append the card header if not yet initialized.
   *
   * @return The element that represent the card description.
   */
  public SmallElement getDescriptionElement() {
    return header.get().getDescriptionElement();
  }

  /**
   * This will initialize and append the card header if not yet initialized.
   *
   * @return same Card instance
   */
  public Card withDescription() {
    header.get().withDescription();
    return this;
  }

  /**
   * Sets the card description This will initialize and append the card header if not yet
   * initialized.
   *
   * @return same Card instance
   */
  public Card withDescription(String description) {
    header.get().setDescription(description);
    return this;
  }

  /**
   * Use to apply customization on the Card description element without breaking the fluent API
   * chain. This will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public Card withDescription(ChildHandler<CardHeader, SmallElement> handler) {
    handler.apply(header.get(), header.get().getDescriptionElement());
    return this;
  }

  /**
   * @return The {@link org.dominokit.domino.ui.elements.DivElement} that is the card body element.
   */
  public DivElement getBody() {
    return body;
  }

  /**
   * Use to apply customization on the Card body element without breaking the fluent API chain.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public Card withBody(ChildHandler<Card, DivElement> handler) {
    handler.apply(this, body);
    return this;
  }

  /**
   * Sets the card logo This will initialize and append the card header if not yet initialized.
   *
   * @param img The {@link elemental2.dom.HTMLImageElement} to be used as card logo.
   * @return same Card instance
   */
  public Card setLogo(HTMLImageElement img) {
    header.get().setLogo(img);
    return this;
  }

  /**
   * Sets the card logo This will initialize and append the card header if not yet initialized.
   *
   * @param img The {@link ImageElement} to be used as card logo.
   * @return same Card instance
   */
  public Card setLogo(ImageElement img) {
    header.get().setLogo(img);
    return this;
  }

  /**
   * Sets the card logo This will initialize and append the card header if not yet initialized.
   *
   * @param img a {@link org.dominokit.domino.ui.IsElement} to be used as card logo.
   * @return same Card instance
   */
  public Card setLogo(IsElement<HTMLImageElement> img) {
    header.get().setLogo(img.element());
    return this;
  }

  /**
   * This will initialize and append the card header if not yet initialized.
   *
   * @return The {@link ImageElement} that represent the card logo.
   */
  public ImageElement getLogo() {
    return header.get().getLogo();
  }

  /**
   * Sets the card logo This will initialize and append the card header if not yet initialized.
   *
   * @param img a {@link HTMLImageElement} to be used as card logo.
   * @return same Card instance
   */
  public Card withLogo(HTMLImageElement img) {
    header.get().setLogo(img);
    return this;
  }

  /**
   * Sets the card logo This will initialize and append the card header if not yet initialized.
   *
   * @param img a {@link org.dominokit.domino.ui.IsElement} to be used as card logo.
   * @return same Card instance
   */
  public Card withLogo(IsElement<HTMLImageElement> img) {
    header.get().setLogo(img.element());
    return this;
  }

  /**
   * This will initialize and append the card header if not yet initialized.
   *
   * @return same Card instance
   */
  public Card withLogo() {
    header.get().withLogo();
    return this;
  }

  /**
   * Use to apply customization on the Card logo element without breaking the fluent API chain. This
   * will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public Card withLogo(ChildHandler<CardHeader, ImageElement> handler) {
    handler.apply(header.get(), header.get().getLogo());
    return this;
  }

  /**
   * Sets the card icon, card icon fits between the logo and the title. This will initialize and
   * append the card header if not yet initialized.
   *
   * @param icon a {@link Icon} to be used as card logo.
   * @return same Card instance
   */
  public Card setIcon(Icon<?> icon) {
    header.get().setIcon(icon);
    return this;
  }

  /**
   * This will initialize and append the card header if not yet initialized.
   *
   * @return The {@link Icon} of this card instance
   */
  public Icon<?> getIcon() {
    return header.get().getIcon();
  }

  /**
   * Sets the card icon, card icon fits between the logo and the title. This will initialize and
   * append the card header if not yet initialized.
   *
   * @param icon a {@link Icon} to be used as card icon.
   * @return same Card instance
   */
  public Card withIcon(Icon<?> icon) {
    setIcon(icon);
    return this;
  }

  /**
   * This will initialize and append the card header if not yet initialized.
   *
   * @return same Card instance
   */
  public Card withIcon() {
    header.get().withIcon();
    return this;
  }

  /**
   * Use to apply customization on the Card icon element without breaking the fluent API chain. This
   * will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public Card withIcon(ChildHandler<CardHeader, Icon<?>> handler) {
    handler.apply(header.get(), header.get().getIcon());
    return this;
  }

  /**
   * Appends an element to the right side of the card header.
   *
   * @param postfix A {@link org.dominokit.domino.ui.utils.PostfixAddOn} wrapped element
   * @return same card instance
   */
  public Card appendChild(PostfixAddOn<?> postfix) {
    getPostfixElement().appendChild(postfix);
    return this;
  }

  /**
   * Appends an element to the left side of the card header, between the logo and the title.
   *
   * @param prefix A {@link org.dominokit.domino.ui.utils.PrefixAddOn} wrapped element
   * @return same card instance
   */
  public Card appendChild(PrefixAddOn<?> prefix) {
    getPrefixElement().appendChild(prefix);
    return this;
  }

  @Override
  public PostfixElement getPostfixElement() {
    return header.get().getPostfixElement();
  }

  @Override
  public PrefixElement getPrefixElement() {
    return header.get().getPrefixElement();
  }

  /**
   * Appends an element to the right side of the card header.
   *
   * @param postfix A {@link org.dominokit.domino.ui.utils.PostfixAddOn} wrapped element
   * @return same card instance
   */
  public Card withUtility(PostfixAddOn<?> postfix) {
    getPostfixElement().appendChild(postfix);
    return this;
  }

  /**
   * Changes the position of the CardHeader to be at the top or bottom of the card.
   *
   * @param headerPosition The {@link org.dominokit.domino.ui.cards.HeaderPosition}
   * @return same card instance
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

  /**
   * Toggle the card collapsible feature, collapsible card will show a collapse action button in the
   * card header, clicking the action will toggle the card body collapse state.
   *
   * @param collapsible boolean, <b>true</b> to enable card body collapse feature, <b>false</b>
   *     disable the card body collapse feature.
   * @return same card instance
   */
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

  /**
   * @return boolean, <b>true</b> if the card body is collapsed, <b>false</b> if the card body
   *     expanded.
   */
  @Override
  public boolean isCollapsed() {
    return body.isCollapsed();
  }

  /**
   * Toggle the card body collapse state, if collapsed it will be expanded, if expanded it will be
   * collapsed.
   *
   * @return same card instance
   */
  @Override
  public Card toggleCollapse() {
    toggleCollapse(!isCollapsed());
    return this;
  }

  /**
   * Toggle the card body collapse state based on provided flag.
   *
   * @param collapse boolean, <b>true</b> collapses the card body, <b>false</b> expands the card
   *     body
   * @return same card instance
   */
  @Override
  public Card toggleCollapse(boolean collapse) {
    if (collapse) {
      collapse();
    } else {
      expand();
    }
    return this;
  }

  /**
   * Expands the card body if collapsed.
   *
   * @return same card instance
   */
  @Override
  public Card expand() {
    body.getCollapsible().expand();
    collapseIcon.toggle();
    expandHandlers.forEach(handler -> handler.onExpanded(this));
    removeCss(() -> "dui-collapsed");
    return this;
  }

  /**
   * Collapses the card body if expanded.
   *
   * @return same card instance
   */
  @Override
  public Card collapse() {
    body.getCollapsible().collapse();
    collapseIcon.toggle();
    collapseHandlers.forEach(handler -> handler.onCollapsed(this));
    addCss(() -> "dui-collapsed");
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public Set<CollapseHandler<Card>> getCollapseHandlers() {
    return this.collapseHandlers;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public Set<ExpandHandler<Card>> getExpandHandlers() {
    return this.expandHandlers;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLElement getAppendTarget() {
    return body.element();
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
