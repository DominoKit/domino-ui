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
package org.dominokit.domino.ui.shaded.cards;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.shaded.cards.CardStyles.*;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.*;
import org.dominokit.domino.ui.shaded.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.shaded.collapsible.Collapsible;
import org.dominokit.domino.ui.shaded.grid.flex.FlexAlign;
import org.dominokit.domino.ui.shaded.grid.flex.FlexItem;
import org.dominokit.domino.ui.shaded.grid.flex.FlexLayout;
import org.dominokit.domino.ui.shaded.icons.BaseIcon;
import org.dominokit.domino.ui.shaded.icons.HardwareIcons;
import org.dominokit.domino.ui.shaded.icons.Icons;
import org.dominokit.domino.ui.shaded.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.shaded.style.Color;
import org.dominokit.domino.ui.shaded.style.Style;
import org.dominokit.domino.ui.shaded.style.Styles;
import org.dominokit.domino.ui.shaded.utils.BaseDominoElement;
import org.dominokit.domino.ui.shaded.utils.DominoElement;
import org.dominokit.domino.ui.shaded.utils.DominoUIConfig;
import org.dominokit.domino.ui.shaded.utils.HasBackground;
import org.dominokit.domino.ui.shaded.utils.TextNode;
import org.jboss.elemento.EventType;
import org.jboss.elemento.HtmlContentBuilder;
import org.jboss.elemento.IsElement;

/**
 * A component provides a content container.
 *
 * <p>A card has two main sub-containers, header and body; the header provides title and description
 * for the card with customizable header actions to perform specific operations while the body
 * provides a container for custom content.
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link CardStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Card.create("Card Title", "Description text here...")
 *             .appendChild(TextNode.of(SAMPLE_CONTENT))
 *             .addHeaderAction(Icons.ALL.more_vert(), (event) -&gt; {
 *                 DomGlobal.console.info("More action selected");
 *             })
 * </pre>
 *
 * @see BaseDominoElement
 * @see HasBackground
 */
@Deprecated
public class Card extends BaseDominoElement<HTMLDivElement, Card> implements HasBackground<Card> {

  private final FlexItem<HTMLDivElement> logoContainer;
  private final DominoElement<HTMLDivElement> root = DominoElement.div().addCss(CARD);
  private final DominoElement<HTMLDivElement> header = DominoElement.div().addCss(HEADER);
  private final DominoElement<HTMLHeadingElement> headerTitle = DominoElement.of(h(2));
  private final DominoElement<HTMLElement> headerDescription = DominoElement.of(small());
  private final DominoElement<HTMLUListElement> headerBar =
      DominoElement.of(ul()).addCss(HEADER_ACTIONS);
  private final DominoElement<HTMLDivElement> body =
      DominoElement.div()
          .addCss(BODY)
          .setCollapseStrategy(
              DominoUIConfig.INSTANCE.getDefaultCardCollapseStrategySupplier().get());

  private final Text title = TextNode.empty();
  private final Text description = TextNode.empty();
  private boolean collapsible = false;
  private HTMLLIElement collapseAction;
  private BaseIcon<?> collapseIcon;
  private Color headerBackground;
  private Color bodyBackground;
  private HtmlContentBuilder<HTMLAnchorElement> collapseAnchor;

  public Card() {
    headerTitle.appendChild(title).appendChild(headerDescription);

    logoContainer = FlexItem.create().css("logo").hide();
    header.appendChild(
        FlexLayout.create()
            .appendChild(logoContainer.setAlignSelf(FlexAlign.CENTER))
            .appendChild(
                FlexItem.create()
                    .setAlignSelf(FlexAlign.CENTER)
                    .setFlexGrow(1)
                    .appendChild(headerTitle))
            .appendChild(FlexItem.create().appendChild(headerBar)));

    root.appendChild(header).appendChild(body);

    headerDescription.appendChild(description);

    body.getCollapsible()
        .addHideHandler(
            () -> {
              if (collapsible) {
                collapseIcon.element().textContent = Icons.ALL.keyboard_arrow_down().getName();
              }
            });

    body.getCollapsible()
        .addShowHandler(
            () -> {
              if (collapsible) {
                collapseIcon.element().textContent = Icons.ALL.keyboard_arrow_up().getName();
              }
            });

    init(this);
  }

  /**
   * Creates new card instance with hiding the header
   *
   * @return new instance with no header
   */
  public static Card create() {
    Card card = new Card();
    card.header.hide();
    return card;
  }

  /**
   * Creates new card instance with {@code title}.
   *
   * @param title the title of the header
   * @return new instance
   */
  public static Card create(String title) {
    Card card = new Card();
    card.setTitle(title);
    return card;
  }

  /**
   * Creates new card instance with {@code title} and {@code description}
   *
   * @param title the title of the header
   * @param description the description of the header
   * @return new instance
   */
  public static Card create(String title, String description) {
    Card card = new Card();
    card.setTitle(title);
    card.setDescription(description);
    return card;
  }

  /**
   * Profile is a special case of a card which has {@code margin-bottom} to {@code 0px} and @link
   * Color#THEME} as a background
   *
   * @param name the title of the header of the profile
   * @param info the description of the header of the profile
   * @return new instance
   * @see Card#create(String, String)
   */
  public static Card createProfile(String name, String info) {
    Card profileCard = Card.create(name, info);
    profileCard.style().setMarginBottom("0px");
    profileCard.setBackground(Color.THEME);
    return profileCard;
  }

  /**
   * Sets the title of the card
   *
   * @param titleText the title of the header
   * @return same instance
   */
  public Card setTitle(String titleText) {
    title.textContent = titleText;
    if (nonNull(titleText) && !titleText.isEmpty()) {
      header.show();
    }
    return this;
  }

  /**
   * Sets the description of the card
   *
   * @param descriptionText the description of the header
   * @return same instance
   */
  public Card setDescription(String descriptionText) {
    description.textContent = descriptionText;
    if (nonNull(descriptionText) && !descriptionText.isEmpty()) {
      header.show();
    }
    return this;
  }

  /**
   * Adds new element to the description element inside the header
   *
   * @param node the element to be added
   * @return same instance
   */
  public Card appendDescriptionChild(Node node) {
    headerDescription.appendChild(node);
    if (nonNull(node)) {
      header.show();
    }
    return this;
  }

  /**
   * Same as {@link Card#appendDescriptionChild(Node)} but takes {@link IsElement}
   *
   * @param element the element to append
   * @return same instance
   */
  public Card appendDescriptionChild(IsElement<?> element) {
    return appendDescriptionChild(element.element());
  }

  /**
   * Adds element to the body of the card
   *
   * @param content the element to add
   * @return same instance
   */
  public Card appendChild(Node content) {
    getBody().appendChild(content);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Card appendChild(IsElement<?> element) {
    getBody().appendChild(element.element());
    return this;
  }

  /**
   * Sets the background {@link Color} of the header
   *
   * @param headerBackground a {@link Color} to set as a background to the header
   * @return same instance
   */
  public Card setHeaderBackground(Color headerBackground) {
    if (nonNull(headerBackground)) {
      if (nonNull(this.headerBackground)) {
        header.removeCss(this.headerBackground.getBackground());
      }
      this.headerBackground = headerBackground;
      header.addCss(headerBackground.getBackground());
    }
    return this;
  }

  /**
   * Sets the background {@link Color} of the body
   *
   * @param bodyBackground a {@link Color} to set as a background to the body
   * @return same instance
   */
  public Card setBodyBackground(Color bodyBackground) {
    if (nonNull(bodyBackground)) {
      if (nonNull(this.bodyBackground)) {
        body.removeCss(this.bodyBackground.getBackground());
      }
      this.bodyBackground = bodyBackground;
      body.addCss(bodyBackground.getBackground());
    }
    return this;
  }

  /**
   * Removes spaces inside the card and fit the body to its content, check {@link
   * CardStyles#FIT_CONTENT}
   *
   * @return same instance
   */
  public Card fitContent() {
    style().addCss(FIT_CONTENT);
    return this;
  }

  /**
   * Sets a default padding to the body of the card
   *
   * @return same instance
   */
  public Card unFitContent() {
    removeCss(FIT_CONTENT);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Card setBackground(Color background) {
    setHeaderBackground(background);
    setBodyBackground(background);
    return this;
  }

  /** @return The header element */
  public DominoElement<HTMLDivElement> getHeader() {
    return header;
  }

  /** @return The header actions container */
  public DominoElement<HTMLUListElement> getHeaderBar() {
    return headerBar;
  }

  /** @return The body element */
  public DominoElement<HTMLDivElement> getBody() {
    return body;
  }

  /** @return The header title element */
  public DominoElement<HTMLHeadingElement> getHeaderTitle() {
    return headerTitle;
  }

  /** @return The header description element */
  public DominoElement<HTMLElement> getHeaderDescription() {
    return headerDescription;
  }

  /**
   * Adds new header action to card header passing the {@code icon} and the {@code eventListener}.
   *
   * @param icon the header action {@link BaseIcon}
   * @param eventListener A {@link EventListener} to listen to the action
   * @return same instance
   */
  public Card addHeaderAction(BaseIcon<?> icon, EventListener eventListener) {
    HTMLLIElement actionItem = createHeaderAction(icon);
    actionItem.addEventListener("click", eventListener);

    putAction(actionItem);

    return this;
  }

  /**
   * Adds new {@link HeaderAction}
   *
   * @param headerAction A {@link HeaderAction} to be added to the card
   * @return same instance
   */
  public Card addHeaderAction(HeaderAction headerAction) {
    putAction(headerAction.element());
    return this;
  }

  private void putAction(HTMLLIElement actionItem) {
    if (nonNull(collapseAction) && collapsible) {
      headerBar.insertBefore(actionItem, collapseAction);
    } else {
      headerBar.appendChild(actionItem);
    }
    header.show();
  }

  private HTMLLIElement createHeaderAction(BaseIcon<?> icon) {
    return li().add(
            collapseAnchor =
                a().attr("tabindex", "0")
                    .attr("aria-expanded", "true")
                    .attr("href", "#")
                    .on(EventType.click, Event::preventDefault)
                    .add(icon.clickable().addCss(Styles.pull_right, ACTION_ICON)))
        .element();
  }

  /**
   * Enables the ability to hide/show the body by adding header action to the card. This method will
   * set the header action icon to {@link HardwareIcons#keyboard_arrow_up()} and adds a listener to
   * hide and show the body.
   *
   * @return same instance
   */
  public Card setCollapsible() {
    collapseIcon = Icons.ALL.keyboard_arrow_up();

    collapseIcon.setAttribute("tabindex", "0");

    if (isNull(collapseAction)) {
      collapseAction = createHeaderAction(collapseIcon);
    }

    KeyboardEvents.listenOnKeyDown(collapseAction).onEnter(evt -> switchVisibility());

    collapseAction.addEventListener("click", evt -> switchVisibility());

    putAction(collapseAction);

    this.collapsible = true;

    header.show();

    return this;
  }

  private void switchVisibility() {
    if (collapsible) {
      if (body.getCollapsible().isCollapsed()) {
        expand();
        collapseAnchor.element().setAttribute("aria-expanded", "true");
      } else {
        collapse();
        collapseAnchor.element().setAttribute("aria-expanded", "false");
      }
    }
  }

  /**
   * Change the visibility of the body based on its current state; expand if collapsed or collapse
   * if expanded
   *
   * @return same instance
   */
  public Card toggle() {
    if (body.getCollapsible().isCollapsed()) {
      expand();
    } else {
      collapse();
    }
    return this;
  }

  /**
   * Show the body
   *
   * @return same instance
   */
  public Card expand() {
    body.getCollapsible().show();
    removeCss("dom-ui-collapsed");
    return this;
  }

  /**
   * Hide the body
   *
   * @return same instance
   */
  public Card collapse() {
    body.getCollapsible().hide();
    addCss("dom-ui-collapsed");
    return this;
  }

  /**
   * Checks if the body is hidden
   *
   * @return true if the body is hidden, false otherwise
   */
  public boolean isCollapsed() {
    return body.getCollapsible().isCollapsed();
  }

  /**
   * Adds listener to be called when the body gets expanded. The {@code listener} will be called
   * everytime the body gets expanded.
   *
   * @param listener the {@link Collapsible.ShowHandler} to be added
   * @return same instance
   */
  public Card addExpandListener(Collapsible.ShowHandler listener) {
    body.addShowListener(listener);
    return this;
  }

  /**
   * Removes expand listener.
   *
   * @param listener the {@link Collapsible.ShowHandler} to be removed
   * @return same instance
   */
  public Card removeExpandListener(Collapsible.ShowHandler listener) {
    body.removeShowListener(listener);
    return this;
  }

  /**
   * Adds listener to be called when the body gets collapsed. The {@code listener} will be called
   * everytime the body gets collapsed.
   *
   * @param listener the {@link Collapsible.HideHandler} to add
   * @return same instance
   */
  public Card addCollapseListener(Collapsible.HideHandler listener) {
    body.addHideListener(listener);
    return this;
  }

  /**
   * Removes collapse listener.
   *
   * @param listener the {@link Collapsible.HideHandler} to be removed
   * @return same instance
   */
  public Card removeCollapseListener(Collapsible.HideHandler listener) {
    body.removeHideListener(listener);
    return this;
  }

  /**
   * Sets the padding of the body, the {@code padding} value will be the same as CSS defines it.
   *
   * <p>For example:
   *
   * <pre>
   *     card.setBodyPadding("2px 1px 2px 1px")
   * </pre>
   *
   * @param padding the padding to set
   * @return same instance
   */
  public Card setBodyPadding(String padding) {
    body.style().setPadding(padding);
    return this;
  }

  /**
   * Sets the left padding of the body
   *
   * @param padding the padding to set
   * @return same instance
   */
  public Card setBodyPaddingLeft(String padding) {
    body.style().setPaddingLeft(padding);
    return this;
  }

  /**
   * Sets the right padding of the body
   *
   * @param padding the padding to set
   * @return same instance
   */
  public Card setBodyPaddingRight(String padding) {
    body.style().setPaddingRight(padding);
    return this;
  }

  /**
   * Sets the top padding of the body
   *
   * @param padding the padding to set
   * @return same instance
   */
  public Card setBodyPaddingTop(String padding) {
    body.style().setPaddingTop(padding);
    return this;
  }

  /**
   * Sets the bottom padding of the body
   *
   * @param padding the padding to set
   * @return same instance
   */
  public Card setBodyPaddingBottom(String padding) {
    body.style().setPaddingBottom(padding);
    return this;
  }

  /**
   * Sets the header logo, this will removes the previous logo if set.
   *
   * @param node the element to be set in the logo container,if null logo container become hidden
   * @return same instance
   */
  public Card setHeaderLogo(Node node) {
    if (nonNull(node)) {
      logoContainer.clearElement().appendChild(node).show();
      header.show();
    } else {
      removeHeaderLogo();
    }
    return this;
  }

  /**
   * Removes the card header logo and hides its container
   *
   * @return same instance
   */
  public Card removeHeaderLogo() {
    logoContainer.clearElement().hide();
    return this;
  }

  /**
   * Same as {@link Card#setHeaderLogo(Node)} but accepts {@link IsElement}
   *
   * @param element the element to be set in the logo container,if null it will hide the logo
   *     container
   * @return same instance
   */
  public Card setHeaderLogo(IsElement<?> element) {
    if (nonNull(element)) {
      setHeaderLogo(element.element());
    } else {
      setHeaderLogo((Node) null);
    }
    return this;
  }

  /**
   * Show the header
   *
   * @return same instance
   */
  public Card showHeader() {
    return setHeaderVisible(true);
  }

  /**
   * Hide the header
   *
   * @return same instance
   */
  public Card hideHeader() {
    return setHeaderVisible(false);
  }

  /**
   * Sets the header visibility
   *
   * @param headerVisible true to show the header, false otherwise
   * @return same instance
   */
  public Card setHeaderVisible(boolean headerVisible) {
    this.header.toggleDisplay(headerVisible);
    return this;
  }

  /** @return the collapse icon element */
  public BaseIcon<?> getCollapseIcon() {
    return collapseIcon;
  }

  /** @return The {@link Style} of the body */
  public Style<HTMLDivElement, DominoElement<HTMLDivElement>> bodyStyle() {
    return body.style();
  }

  /**
   * Clears the body element
   *
   * @return same instance
   */
  public Card clearBody() {
    getBody().clearElement();
    return this;
  }

  /**
   * Set the card body collapse strategy
   *
   * @return same instance
   */
  public Card setBodyCollapseStrategy(CollapseStrategy strategy) {
    getBody().setCollapseStrategy(strategy);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
