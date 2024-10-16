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

import static org.dominokit.domino.ui.cards.CardStyles.*;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLImageElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.ImageElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.*;

/**
 * The component is used as {@link Card} header
 *
 * @see BaseDominoElement
 */
public class CardHeader extends BaseDominoElement<HTMLDivElement, CardHeader> {

  private DivElement element;
  private LazyChild<DivElement> mainHeader;
  private LazyChild<DivElement> subHeader;
  private LazyChild<DivElement> title;
  private LazyChild<HeadingElement> mainTitle;
  private LazyChild<SmallElement> description;

  private LazyChild<ImageElement> logo = NullLazyChild.of();
  private LazyChild<Icon<?>> cardIcon = NullLazyChild.of();

  /**
   * Factory method to create empty CardHeader.
   *
   * @return new {@link org.dominokit.domino.ui.cards.CardHeader} instance
   */
  public static CardHeader create() {
    return new CardHeader();
  }

  CardHeader() {
    element = div().addCss(dui_card_header);
    mainHeader =
        LazyChild.of(div().addCss(dui_card_main_header), element)
            .whenInitialized(
                () -> mainHeader.element().appendChild(div().addCss(dui_card_header_filler)));
    subHeader = LazyChild.of(div().addCss(dui_card_sub_header), element);
    title = LazyChild.of(div().addCss(dui_card_title), mainHeader);
    mainTitle = LazyChild.of(h(2).addCss(dui_card_main_title), title);
    description = LazyChild.of(small().addCss(dui_card_description), mainTitle);

    init(this);
  }

  /**
   * Creates a CardHeader with a title.
   *
   * @param title The card header title text
   */
  public CardHeader(String title) {
    this();
    setTitle(title);
  }

  /**
   * Creates a CardHeader with a title and description.
   *
   * @param title The card header title text
   * @param description The card header description text
   */
  public CardHeader(String title, String description) {
    this(title);
    setDescription(description);
  }

  /**
   * This will initialize the CardHeader main container if not yet initialized.
   *
   * @return The {@link org.dominokit.domino.ui.elements.DivElement} representing the CardHeader
   *     main container.
   */
  public DivElement getMainHeader() {
    return mainHeader.get();
  }

  /**
   * This will initialize the CardHeader main container if not yet initialized.
   *
   * @return same CardHeader instance
   */
  public CardHeader withMainHeader() {
    mainHeader.get();
    return this;
  }

  /**
   * Use to apply customization on the CardHeader main container element without breaking the fluent
   * API chain. This will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same CardHeader instance
   */
  public CardHeader withMainHeader(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(this, mainHeader.get());
    return this;
  }

  /**
   * This will initialize the CardHeader sub-header container if not yet initialized.
   *
   * @return The {@link org.dominokit.domino.ui.elements.DivElement} representing the Card
   *     sub-header container
   */
  public DivElement getSubHeader() {
    return subHeader.get();
  }

  /**
   * This will initialize the CardHeader sub-header container if not yet initialized.
   *
   * @return same CardHeader instance
   */
  public CardHeader withSubHeader() {
    subHeader.get();
    return this;
  }

  /**
   * Use to apply customization on the Card sub-header container element without breaking the fluent
   * API chain. This will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same CardHeader instance
   */
  public CardHeader withSubHeader(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(this, subHeader.get());
    return this;
  }

  /**
   * Sets the CardHeader title, this will initialize and append the main header container if not yet
   * initialized.
   *
   * @param title The CardHeader title text
   * @return same CardHeader instance
   */
  public CardHeader setTitle(String title) {
    mainTitle.get().setTextContent(title);
    return this;
  }

  /**
   * Sets the CardHeader description, this will initialize and append the description container if
   * not yet initialized.
   *
   * @param text The CardHeader description text
   * @return same CardHeader instance
   */
  public CardHeader setDescription(String text) {
    description.get().setTextContent(text);
    return this;
  }

  /**
   * this will initialize and append the CardHeader title container if not yet initialized.
   * getTitleElement.
   *
   * @return The {@link org.dominokit.domino.ui.elements.DivElement} of the CardHeader title.
   */
  public DivElement getTitleElement() {
    return title.get();
  }

  /**
   * This will initialize and append the CardHeader title container if not yet initialized.
   *
   * @return same CardHeader instance
   */
  public CardHeader withTitle() {
    title.get();
    return this;
  }

  /**
   * Use to apply customization on the CardHeader title element without breaking the fluent API
   * chain. This will initialize and append the card title element if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same CardHeader instance
   */
  public CardHeader withTitle(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(this, title.get());
    return this;
  }

  /**
   * This will initialize and append the CardHeader main title container if not yet initialized.
   *
   * @return The {@link org.dominokit.domino.ui.elements.HeadingElement} of the CardHeader main
   *     title
   */
  public HeadingElement getMainTitleElement() {
    return mainTitle.get();
  }

  /**
   * This will initialize and append the CardHeader main title container if not yet initialized.
   *
   * @return same CardHeader instance
   */
  public CardHeader withMainTitle() {
    mainTitle.get();
    return this;
  }

  /**
   * Sets the CardHeader main title. This will initialize and append the card header main title
   * element if not yet initialized.
   *
   * @param title The card main title text
   * @return same CardHeader instance
   */
  public CardHeader withMainTitle(String title) {
    setTitle(title);
    return this;
  }

  /**
   * Use to apply customization on the CardHeader main title element without breaking the fluent API
   * chain. This will initialize and append the card header if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same CardHeader instance
   */
  public CardHeader withMainTitle(ChildHandler<CardHeader, HeadingElement> handler) {
    handler.apply(this, mainTitle.get());
    return this;
  }

  /**
   * This will initialize and append the card header description element if not yet initialized.
   *
   * @return The {@link org.dominokit.domino.ui.elements.SmallElement} of the CardHeader description
   */
  public SmallElement getDescriptionElement() {
    return description.get();
  }

  /**
   * This will initialize and append the card header description element if not yet initialized.
   *
   * @return same CardHeader instance
   */
  public CardHeader withDescription() {
    description.get();
    return this;
  }

  /**
   * Sets the CardHeader description. This will initialize and append the card header description
   * element if not yet initialized.
   *
   * @param description The CardHeader description text
   * @return same CardHeader instance
   */
  public CardHeader withDescription(String description) {
    setDescription(description);
    return this;
  }

  /**
   * Use to apply customization on the CardHeader description element without breaking the fluent
   * API chain. This will initialize and append the card header description element if not yet
   * initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same CardHeader instance
   */
  public CardHeader withDescription(ChildHandler<CardHeader, SmallElement> handler) {
    handler.apply(this, description.get());
    return this;
  }

  /**
   * Sets the CardHeader logo This will initialize and append the card header logo element if not
   * yet initialized.
   *
   * @param img The {@link elemental2.dom.HTMLImageElement} to be used as CardHeader logo.
   * @return same CardHeader instance
   */
  public CardHeader setLogo(HTMLImageElement img) {
    return setLogo(ImageElement.of(img));
  }

  /**
   * Sets the CardHeader logo This will initialize and append the card header logo element if not
   * yet initialized.
   *
   * @param img The {@link ImageElement} to be used as CardHeader logo.
   * @return same CardHeader instance
   */
  public CardHeader setLogo(ImageElement img) {
    logo.remove();
    logo = LazyChild.of(img.addCss(dui_card_logo), mainHeader);
    logo.get();
    return this;
  }

  /**
   * This will initialize and append the card header logo element if not yet initialized.
   *
   * @return The {@link ImageElement} of the CardHeader logo
   */
  public ImageElement getLogo() {
    return logo.get();
  }

  /**
   * Sets the CardHeader logo This will initialize and append the card header logo element if not
   * yet initialized.
   *
   * @param img The {@link HTMLImageElement} to be used as CardHeader logo.
   * @return same CardHeader instance
   */
  public CardHeader withLogo(HTMLImageElement img) {
    return setLogo(img);
  }

  /**
   * This will initialize and append the card header logo element if not yet initialized.
   *
   * @return same CardHeader instance
   */
  public CardHeader withLogo() {
    logo.get();
    return this;
  }

  /**
   * Use to apply customization on the CardHeader logo element without breaking the fluent API
   * chain. This will initialize and append the card header logo element if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same CardHeader instance
   */
  public CardHeader withLogo(ChildHandler<CardHeader, ImageElement> handler) {
    handler.apply(this, logo.get());
    return this;
  }

  /**
   * Sets the CardHeader icon, CardHeader icon fits between the logo and the title. This will
   * initialize and append the card header icon if not yet initialized.
   *
   * @param icon a {@link Icon} to be used as card logo.
   * @return same Card instance
   */
  public CardHeader setIcon(Icon<?> icon) {
    cardIcon.remove();
    cardIcon = LazyChild.of(icon.addCss(dui_card_icon), mainHeader);
    cardIcon.get();
    return this;
  }

  /**
   * This will initialize and append the card header icon if not yet initialized.
   *
   * @return The {@link Icon} of this CardHeader instance
   */
  public Icon<?> getIcon() {
    return cardIcon.get();
  }

  /**
   * Sets the card header icon, card header icon fits between the logo and the title. This will
   * initialize and append the card header icon if not yet initialized.
   *
   * @param icon a {@link Icon} to be used as card header icon.
   * @return same CardHeader instance
   */
  public CardHeader withIcon(Icon<?> icon) {
    setIcon(icon);
    return this;
  }

  /**
   * This will initialize and append the card header icon if not yet initialized.
   *
   * @return same CardHeader instance
   */
  public CardHeader withIcon() {
    cardIcon.get();
    return this;
  }

  /**
   * Use to apply customization on the CardHeader icon element without breaking the fluent API
   * chain. This will initialize and append the card header icon element if not yet initialized.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations.
   * @return same Card instance
   */
  public CardHeader withIcon(ChildHandler<CardHeader, Icon<?>> handler) {
    handler.apply(this, cardIcon.get());
    return this;
  }

  /**
   * Appends an element to the right side of the card header.
   *
   * @param postfixAddOn A {@link org.dominokit.domino.ui.utils.PostfixAddOn} wrapped element
   * @return same CardHeader instance
   */
  public CardHeader appendChild(PostfixAddOn<?> postfixAddOn) {
    getPostfixElement().appendChild(postfixAddOn);
    return this;
  }

  /**
   * Appends an element to the left side of the card header, between the logo and the title.
   *
   * @param prefixAddOn A {@link org.dominokit.domino.ui.utils.PrefixAddOn} wrapped element
   * @return same card instance
   */
  public CardHeader appendChild(PrefixAddOn<?> prefixAddOn) {
    getPrefixElement().appendChild(prefixAddOn);
    return this;
  }

  @Override
  public PostfixElement getPostfixElement() {
    return PostfixElement.of(mainHeader.get().element());
  }

  @Override
  public PrefixElement getPrefixElement() {
    return PrefixElement.of(mainHeader.get().element());
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
