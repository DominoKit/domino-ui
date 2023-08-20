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

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLImageElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.ImageElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.*;

/** CardHeader class. */
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
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
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
   * Constructor for CardHeader.
   *
   * @param title a {@link java.lang.String} object
   */
  public CardHeader(String title) {
    this();
    setTitle(title);
  }

  /**
   * Constructor for CardHeader.
   *
   * @param title a {@link java.lang.String} object
   * @param description a {@link java.lang.String} object
   */
  public CardHeader(String title, String description) {
    this(title);
    setDescription(description);
  }

  /**
   * Getter for the field <code>mainHeader</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getMainHeader() {
    return mainHeader.get();
  }

  /**
   * withMainHeader.
   *
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withMainHeader() {
    mainHeader.get();
    return this;
  }

  /**
   * withMainHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withMainHeader(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(this, mainHeader.get());
    return this;
  }

  /**
   * Getter for the field <code>subHeader</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getSubHeader() {
    return subHeader.get();
  }

  /**
   * withSubHeader.
   *
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withSubHeader() {
    subHeader.get();
    return this;
  }

  /**
   * withSubHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withSubHeader(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(this, subHeader.get());
    return this;
  }

  /**
   * Setter for the field <code>title</code>.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader setTitle(String title) {
    mainTitle.get().setTextContent(title);
    return this;
  }

  /**
   * Setter for the field <code>description</code>.
   *
   * @param text a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader setDescription(String text) {
    description.get().setTextContent(text);
    return this;
  }

  /**
   * getTitleElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getTitleElement() {
    return title.get();
  }

  /**
   * withTitle.
   *
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withTitle() {
    title.get();
    return this;
  }

  /**
   * withTitle.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withTitle(ChildHandler<CardHeader, DivElement> handler) {
    handler.apply(this, title.get());
    return this;
  }

  /**
   * getMainTitleElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.HeadingElement} object
   */
  public HeadingElement getMainTitleElement() {
    return mainTitle.get();
  }

  /**
   * withMainTitle.
   *
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withMainTitle() {
    mainTitle.get();
    return this;
  }

  /**
   * withMainTitle.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withMainTitle(String title) {
    setTitle(title);
    return this;
  }

  /**
   * withMainTitle.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withMainTitle(ChildHandler<CardHeader, HeadingElement> handler) {
    handler.apply(this, mainTitle.get());
    return this;
  }

  /**
   * getDescriptionElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SmallElement} object
   */
  public SmallElement getDescriptionElement() {
    return description.get();
  }

  /**
   * withDescription.
   *
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withDescription() {
    description.get();
    return this;
  }

  /**
   * withDescription.
   *
   * @param description a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withDescription(String description) {
    setDescription(description);
    return this;
  }

  /**
   * withDescription.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withDescription(ChildHandler<CardHeader, SmallElement> handler) {
    handler.apply(this, description.get());
    return this;
  }

  /**
   * Setter for the field <code>logo</code>.
   *
   * @param img a {@link elemental2.dom.HTMLImageElement} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader setLogo(HTMLImageElement img) {
    return setLogo(ImageElement.of(img));
  }

  /**
   * Setter for the field <code>logo</code>.
   *
   * @param img a {@link org.dominokit.domino.ui.elements.ImageElement} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader setLogo(ImageElement img) {
    logo.remove();
    logo = LazyChild.of(img.addCss(dui_card_logo), mainHeader);
    logo.get();
    return this;
  }

  /**
   * Getter for the field <code>logo</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ImageElement} object
   */
  public ImageElement getLogo() {
    return logo.get();
  }

  /**
   * withLogo.
   *
   * @param img a {@link elemental2.dom.HTMLImageElement} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withLogo(HTMLImageElement img) {
    return setLogo(img);
  }

  /**
   * withLogo.
   *
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withLogo() {
    logo.get();
    return this;
  }

  /**
   * withLogo.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withLogo(ChildHandler<CardHeader, ImageElement> handler) {
    handler.apply(this, logo.get());
    return this;
  }

  /**
   * setIcon.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader setIcon(Icon<?> icon) {
    cardIcon.remove();
    cardIcon = LazyChild.of(icon.addCss(dui_card_icon), mainHeader);
    cardIcon.get();
    return this;
  }

  /**
   * getIcon.
   *
   * @return a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public Icon<?> getIcon() {
    return cardIcon.get();
  }

  /**
   * withIcon.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withIcon(Icon<?> icon) {
    setIcon(icon);
    return this;
  }

  /**
   * withIcon.
   *
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withIcon() {
    cardIcon.get();
    return this;
  }

  /**
   * withIcon.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader withIcon(ChildHandler<CardHeader, Icon<?>> handler) {
    handler.apply(this, cardIcon.get());
    return this;
  }

  /**
   * appendChild.
   *
   * @param postfixAddOn a {@link org.dominokit.domino.ui.utils.PostfixAddOn} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader appendChild(PostfixAddOn<?> postfixAddOn) {
    mainHeader.get().appendChild(postfixAddOn);
    return this;
  }

  /**
   * appendChild.
   *
   * @param prefixAddOn a {@link org.dominokit.domino.ui.utils.PrefixAddOn} object
   * @return a {@link org.dominokit.domino.ui.cards.CardHeader} object
   */
  public CardHeader appendChild(PrefixAddOn<?> prefixAddOn) {
    mainHeader.get().appendChild(prefixAddOn);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
