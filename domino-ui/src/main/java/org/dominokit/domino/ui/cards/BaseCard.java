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
import static org.dominokit.domino.ui.style.SpacingCss.dui_order_last;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.Node;
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
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.CollapsibleElement;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.NullLazyChild;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PostfixElement;
import org.dominokit.domino.ui.utils.PrefixElement;
import org.dominokit.domino.ui.utils.PrimaryAddOnElement;

public abstract class BaseCard<C extends BaseCard<C>> extends BaseDominoElement<HTMLDivElement, C>
    implements CardStyles, CollapsibleElement<C>, HasComponentConfig<CardConfig> {
  private DivElement element;
  private DivElement content;
  private DivElement body;

  private LazyChild<CardHeader> header;
  private LazyChild<DivElement> contentHeader;
  private LazyChild<DivElement> contentFooter;

  private Set<CollapseHandler<C>> collapseHandlers = new HashSet<>();
  private Set<ExpandHandler<C>> expandHandlers = new HashSet<>();
  private LazyChild<PostfixAddOn<? extends Element>> collapseElement = NullLazyChild.of();

  private final ToggleIcon<?, ?> collapseIcon;

  /**
   * Creates a card with title in the header
   *
   * @param title The card title text
   */
  public BaseCard(String title) {
    this(text(title));
  }

  /**
   * Creates a card with title in the header
   *
   * @param title The card title node
   */
  public BaseCard(Node title) {
    this();
    setTitle(title);
  }

  /**
   * Creates a card with the title in the header and a description below the title
   *
   * @param title The card title text
   * @param description The card description text
   */
  public BaseCard(String title, String description) {
    this(text(title), description);
  }

  /**
   * Creates a card with the title in the header and a description below the title
   *
   * @param title The card title node
   * @param description The card description text
   */
  public BaseCard(Node title, String description) {
    this(title);
    setDescription(description);
  }

  /** Creates an empty Card without a header. */
  public BaseCard() {
    element =
        div()
            .addCss(dui_card)
            .appendChild(
                content =
                    div().addCss(dui_card_content).appendChild(body = div().addCss(dui_card_body)));
    header = LazyChild.ofInsertFirst(CardHeader.create(), element);
    contentHeader = LazyChild.ofInsertFirst(div().addCss(dui_card_content_header), () -> content);
    contentFooter = LazyChild.of(div().addCss(dui_card_content_footer), () -> content);
    collapseIcon = getConfig().getCardCollapseExpandIcon().get();

    init((C) this);
    onInit();
  }

  protected void onInit() {}

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
  public C withHeader(ChildHandler<C, CardHeader> handler) {
    handler.apply((C) this, header.get());
    return (C) this;
  }

  /**
   * Initialize the card header and append it to the card if not already initialized.
   *
   * @return same Card instance
   */
  public C withHeader() {
    header.get();
    return (C) this;
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
  public C withSubHeader() {
    header.get().getSubHeader();
    return (C) this;
  }

  /**
   * Use to apply customization to the card sub-header, this will initialize both the CardHeader and
   * the sub-header and append them if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customization
   * @return same Card instance
   */
  public C withSubHeader(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(header.get(), header.get().getSubHeader());
    return (C) this;
  }

  /**
   * Sets the card title, this will initialize and append the card header if not yet initialized.
   *
   * @param title The card title text
   * @return same Card instance
   */
  public C setTitle(String title) {
    return setTitle(text(title));
  }

  /**
   * Sets the card title, this will initialize and append the card header if not yet initialized.
   *
   * @param title The card title text
   * @return same Card instance
   */
  public C setTitle(Node title) {
    header.get().setTitle(title);
    return (C) this;
  }

  /**
   * Sets the card description, this will initialize and append the card header if not yet
   * initialized.
   *
   * @param text The card description text
   * @return same Card instance
   */
  public C setDescription(String text) {
    header.get().setDescription(text);
    return (C) this;
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
  public C withTitle() {
    header.get().withTitle();
    return (C) this;
  }

  /**
   * Use to apply customization on the Card title element without breaking the fluent API chain.
   * This will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public C withTitle(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(header.get(), header.get().getTitleElement());
    return (C) this;
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
  public C withMainTitle() {
    header.get().withMainTitle();
    return (C) this;
  }

  /**
   * Sets the card main title. This will initialize and append the card header if not yet
   * initialized.
   *
   * @param title The card main title text
   * @return same Card instance
   */
  public C withMainTitle(String title) {
    header.get().setTitle(title);
    return (C) this;
  }

  /**
   * Use to apply customization on the Card main title element without breaking the fluent API
   * chain. This will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public C withMainTitle(ChildHandler<CardHeader, HeadingElement> handler) {
    handler.apply(header.get(), header.get().getMainTitleElement());
    return (C) this;
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
  public C withDescription() {
    header.get().withDescription();
    return (C) this;
  }

  /**
   * Sets the card description This will initialize and append the card header if not yet
   * initialized.
   *
   * @return same Card instance
   */
  public C withDescription(String description) {
    header.get().setDescription(description);
    return (C) this;
  }

  /**
   * Use to apply customization on the Card description element without breaking the fluent API
   * chain. This will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public C withDescription(ChildHandler<CardHeader, SmallElement> handler) {
    handler.apply(header.get(), header.get().getDescriptionElement());
    return (C) this;
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
  public C withBody(ChildHandler<C, DivElement> handler) {
    handler.apply((C) this, body);
    return (C) this;
  }

  /**
   * @return The main content container of this card. It contains the content header, body, and
   *     content footer sections.
   */
  public DivElement getContent() {
    return content;
  }

  /**
   * Use to apply customization on the main content container without breaking the fluent API chain.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public C withContent(ChildHandler<C, DivElement> handler) {
    handler.apply((C) this, content);
    return (C) this;
  }

  /**
   * Calling this will initialize and append the content header if it is not already initialized.
   * The section is hidden by CSS while it is empty.
   *
   * @return The content header element.
   */
  public DivElement getContentHeader() {
    return contentHeader.get();
  }

  /**
   * Use to apply customization on the content header without breaking the fluent API chain.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public C withContentHeader(ChildHandler<C, DivElement> handler) {
    handler.apply((C) this, contentHeader.get());
    return (C) this;
  }

  /**
   * Initialize and append the content header if it is not already initialized.
   *
   * @return same Card instance
   */
  public C withContentHeader() {
    contentHeader.get();
    return (C) this;
  }

  /**
   * Calling this will initialize and append the content footer if it is not already initialized.
   * The section is hidden by CSS while it is empty.
   *
   * @return The content footer element.
   */
  public DivElement getContentFooter() {
    return contentFooter.get();
  }

  /**
   * Use to apply customization on the content footer without breaking the fluent API chain.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public C withContentFooter(ChildHandler<C, DivElement> handler) {
    handler.apply((C) this, contentFooter.get());
    return (C) this;
  }

  /**
   * Initialize and append the content footer if it is not already initialized.
   *
   * @return same Card instance
   */
  public C withContentFooter() {
    contentFooter.get();
    return (C) this;
  }

  /**
   * Sets the card logo This will initialize and append the card header if not yet initialized.
   *
   * @param img The {@link elemental2.dom.HTMLImageElement} to be used as card logo.
   * @return same Card instance
   */
  public C setLogo(HTMLImageElement img) {
    header.get().setLogo(img);
    return (C) this;
  }

  /**
   * Sets the card logo This will initialize and append the card header if not yet initialized.
   *
   * @param img The {@link ImageElement} to be used as card logo.
   * @return same Card instance
   */
  public C setLogo(ImageElement img) {
    header.get().setLogo(img);
    return (C) this;
  }

  /**
   * Sets the card logo This will initialize and append the card header if not yet initialized.
   *
   * @param img a {@link org.dominokit.domino.ui.IsElement} to be used as card logo.
   * @return same Card instance
   */
  public C setLogo(IsElement<HTMLImageElement> img) {
    header.get().setLogo(img.element());
    return (C) this;
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
  public C withLogo(HTMLImageElement img) {
    header.get().setLogo(img);
    return (C) this;
  }

  /**
   * Sets the card logo This will initialize and append the card header if not yet initialized.
   *
   * @param img a {@link org.dominokit.domino.ui.IsElement} to be used as card logo.
   * @return same Card instance
   */
  public C withLogo(IsElement<HTMLImageElement> img) {
    header.get().setLogo(img.element());
    return (C) this;
  }

  /**
   * This will initialize and append the card header if not yet initialized.
   *
   * @return same Card instance
   */
  public C withLogo() {
    header.get().withLogo();
    return (C) this;
  }

  /**
   * Use to apply customization on the Card logo element without breaking the fluent API chain. This
   * will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public C withLogo(ChildHandler<CardHeader, ImageElement> handler) {
    handler.apply(header.get(), header.get().getLogo());
    return (C) this;
  }

  /**
   * Sets the card icon, card icon fits between the logo and the title. This will initialize and
   * append the card header if not yet initialized.
   *
   * @param icon a {@link Icon} to be used as card logo.
   * @return same Card instance
   */
  public C setIcon(Icon<?> icon) {
    header.get().setIcon(icon);
    return (C) this;
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
  public C withIcon(Icon<?> icon) {
    setIcon(icon);
    return (C) this;
  }

  /**
   * This will initialize and append the card header if not yet initialized.
   *
   * @return same Card instance
   */
  public C withIcon() {
    header.get().withIcon();
    return (C) this;
  }

  /**
   * Use to apply customization on the Card icon element without breaking the fluent API chain. This
   * will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public C withIcon(ChildHandler<CardHeader, Icon<?>> handler) {
    handler.apply(header.get(), header.get().getIcon());
    return (C) this;
  }

  @Override
  public PostfixElement getPostfixElement() {
    return header.get().getPostfixElement();
  }

  @Override
  public PrefixElement getPrefixElement() {
    return header.get().getPrefixElement();
  }

  @Override
  public PrimaryAddOnElement getPrimaryAddonsElement() {
    return header.get().getPrimaryAddonsElement();
  }

  /**
   * Appends an element to the right side of the card header.
   *
   * @param postfix A {@link org.dominokit.domino.ui.utils.PostfixAddOn} wrapped element
   * @return same card instance
   */
  public C withUtility(PostfixAddOn<?> postfix) {
    getPostfixElement().appendChild(postfix);
    return (C) this;
  }

  /**
   * Changes the position of the CardHeader to be at the top or bottom of the card.
   *
   * @param headerPosition The {@link org.dominokit.domino.ui.cards.HeaderPosition}
   * @return same card instance
   */
  public C setHeaderPosition(HeaderPosition headerPosition) {
    addCss(BooleanCssClass.of(dui_card_header_bottom, HeaderPosition.BOTTOM == headerPosition));
    if (nonNull(collapseIcon) && collapseIcon instanceof ToggleMdiIcon) {
      if (HeaderPosition.BOTTOM == headerPosition) {
        ((ToggleMdiIcon) collapseIcon).flipV();
      }
    }
    return (C) this;
  }

  /**
   * Toggle the card collapsible feature, collapsible card will show a collapse action button in the
   * card header, clicking the action will toggle the card content collapse state.
   *
   * @param collapsible boolean, <b>true</b> to enable card content collapse feature, <b>false</b>
   *     disable the card content collapse feature.
   * @return same card instance
   */
  @Override
  public C setCollapsible(boolean collapsible) {
    collapseElement.remove();
    if (collapsible) {
      content.setCollapseStrategy(getConfig().getDefaultCardCollapseStrategySupplier().get());
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
                      collapseIcon
                          .setAttribute("aria-label", "Toggle card")
                          .setAttribute("aria-controls", content.getDominoId())
                          .setAttribute("aria-expanded", !isCollapsed());
                      collapseElement.element().addClickListener(evt -> toggleCollapse());
                      collapseElement
                          .element()
                          .onKeyDown(keyEvents -> keyEvents.onEnter(evt -> toggleCollapse()));
                    });
              });
      collapseElement.get();
    } else {
      collapseElement.remove();
      content.getCollapsible().getStrategy().cleanup(content.element());
    }
    content.addCollapseListener(
        () -> {
          collapseIcon.setAttribute("aria-expanded", false);
          collapseHandlers.forEach(handler -> handler.onCollapsed((C) BaseCard.this));
        });
    content.addExpandListener(
        () -> {
          collapseIcon.setAttribute("aria-expanded", true);
          expandHandlers.forEach(handler -> handler.onExpanded((C) BaseCard.this));
        });

    return (C) this;
  }

  /**
   * @return boolean, <b>true</b> if the card content is collapsed, <b>false</b> if the card content
   *     expanded.
   */
  @Override
  public boolean isCollapsed() {
    return content.isCollapsed();
  }

  /**
   * Toggle the card content collapse state, if collapsed it will be expanded, if expanded it will
   * be collapsed.
   *
   * @return same card instance
   */
  @Override
  public C toggleCollapse() {
    toggleCollapse(!isCollapsed());
    return (C) this;
  }

  /**
   * Toggle the card content collapse state based on provided flag.
   *
   * @param collapse boolean, <b>true</b> collapses the card content, <b>false</b> expands the card
   *     content
   * @return same card instance
   */
  @Override
  public C toggleCollapse(boolean collapse) {
    if (collapse) {
      collapse();
    } else {
      expand();
    }
    return (C) this;
  }

  /**
   * Expands the card content if collapsed.
   *
   * @return same card instance
   */
  @Override
  public C expand() {
    content.getCollapsible().expand();
    collapseIcon.toggle();
    collapseIcon.setAttribute("aria-expanded", true);
    expandHandlers.forEach(handler -> handler.onExpanded((C) this));
    removeCss(() -> "dui-collapsed");
    return (C) this;
  }

  /**
   * Collapses the card content if expanded.
   *
   * @return same card instance
   */
  @Override
  public C collapse() {
    content.getCollapsible().collapse();
    collapseIcon.toggle();
    collapseIcon.setAttribute("aria-expanded", false);
    collapseHandlers.forEach(handler -> handler.onCollapsed((C) this));
    addCss(() -> "dui-collapsed");
    return (C) this;
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   */
  @Override
  public Set<CollapseHandler<C>> getCollapseHandlers() {
    return this.collapseHandlers;
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   */
  @Override
  public Set<ExpandHandler<C>> getExpandHandlers() {
    return this.expandHandlers;
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   */
  @Override
  public HTMLElement getAppendTarget() {
    return body.element();
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
