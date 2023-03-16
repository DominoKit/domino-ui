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
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLImageElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.utils.*;

public class CardHeader extends BaseDominoElement<HTMLDivElement, CardHeader> {

  private DominoElement<HTMLDivElement> element;
  private LazyChild<DominoElement<HTMLDivElement>> mainHeader;
  private LazyChild<DominoElement<HTMLDivElement>> subHeader;
  private LazyChild<DominoElement<HTMLDivElement>> title;
  private LazyChild<DominoElement<HTMLHeadingElement>> mainTitle;
  private LazyChild<DominoElement<HTMLElement>> description;

  private LazyChild<DominoElement<HTMLImageElement>> logo = NullLazyChild.of();
  private LazyChild<BaseIcon<?>> cardIcon = NullLazyChild.of();

  public static CardHeader create() {
    return new CardHeader();
  }

  CardHeader() {
    element = div().addCss(card_header);
    mainHeader =
        LazyChild.of(div().addCss(card_main_header), element)
            .whenInitialized(
                () ->
                    mainHeader
                        .element()
                        .appendChild(div().addCss(dui_card_header_filler)));
    subHeader = LazyChild.of(div().addCss(card_sub_header), element);
    title = LazyChild.of(div().addCss(card_title), mainHeader);
    mainTitle = LazyChild.of(h(2).addCss(card_main_title), title);
    description = LazyChild.of(small().addCss(card_description), mainTitle);

    init(this);
  }

  public CardHeader(String title) {
    this();
    setTitle(title);
  }

  public CardHeader(String title, String description) {
    this(title);
    setDescription(description);
  }

  public DominoElement<HTMLDivElement> getMainHeader() {
    return mainHeader.get();
  }

  public CardHeader withMainHeader() {
    mainHeader.get();
    return this;
  }

  public CardHeader withMainHeader(
      ChildHandler<CardHeader, DominoElement<HTMLDivElement>> handler) {
    handler.apply(this, mainHeader.get());
    return this;
  }

  public DominoElement<HTMLDivElement> getSubHeader() {
    return subHeader.get();
  }

  public CardHeader withSubHeader() {
    subHeader.get();
    return this;
  }

  public CardHeader withSubHeader(ChildHandler<CardHeader, DominoElement<HTMLDivElement>> handler) {
    handler.apply(this, subHeader.get());
    return this;
  }

  public CardHeader setTitle(String title) {
    mainTitle.get().setTextContent(title);
    return this;
  }

  public CardHeader setDescription(String text) {
    description.get().setTextContent(text);
    return this;
  }

  public DominoElement<HTMLDivElement> getTitleElement() {
    return title.get();
  }

  public CardHeader withTitle() {
    title.get();
    return this;
  }

  public CardHeader withTitle(ChildHandler<CardHeader, DominoElement<HTMLDivElement>> handler) {
    handler.apply(this, title.get());
    return this;
  }

  public DominoElement<HTMLHeadingElement> getMainTitleElement() {
    return mainTitle.get();
  }

  public CardHeader withMainTitle() {
    mainTitle.get();
    return this;
  }

  public CardHeader withMainTitle(String title) {
    setTitle(title);
    return this;
  }

  public CardHeader withMainTitle(
      ChildHandler<CardHeader, DominoElement<HTMLHeadingElement>> handler) {
    handler.apply(this, mainTitle.get());
    return this;
  }

  public DominoElement<HTMLElement> getDescriptionElement() {
    return description.get();
  }

  public CardHeader withDescription() {
    description.get();
    return this;
  }

  public CardHeader withDescription(String description) {
    setDescription(description);
    return this;
  }

  public CardHeader withDescription(ChildHandler<CardHeader, DominoElement<HTMLElement>> handler) {
    handler.apply(this, description.get());
    return this;
  }

  public CardHeader setLogo(HTMLImageElement img) {
    logo.remove();
    logo = LazyChild.of(elementOf(img).addCss(card_logo), mainHeader);
    logo.get();
    return this;
  }

  public DominoElement<HTMLImageElement> getLogo() {
    return logo.get();
  }

  public CardHeader withLogo(HTMLImageElement img) {
    setLogo(img);
    return this;
  }

  public CardHeader withLogo() {
    logo.get();
    return this;
  }

  public CardHeader withLogo(ChildHandler<CardHeader, DominoElement<HTMLImageElement>> handler) {
    handler.apply(this, logo.get());
    return this;
  }

  public CardHeader setIcon(BaseIcon<?> icon) {
    cardIcon.remove();
    cardIcon = LazyChild.of(icon.addCss(card_icon), mainHeader);
    cardIcon.get();
    return this;
  }

  public BaseIcon<?> getIcon() {
    return cardIcon.get();
  }

  public CardHeader withIcon(BaseIcon<?> icon) {
    setIcon(icon);
    return this;
  }

  public CardHeader withIcon() {
    cardIcon.get();
    return this;
  }

  public CardHeader withIcon(ChildHandler<CardHeader, BaseIcon<?>> handler) {
    handler.apply(this, cardIcon.get());
    return this;
  }

  public CardHeader appendChild(UtilityElement<?> utility) {
    mainHeader.get().appendChild(utility.addCss(card_utility));
    return this;
  }

  public CardHeader withUtility(UtilityElement<?> utility) {
    return appendChild(utility);
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
