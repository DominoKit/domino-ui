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
package org.dominokit.domino.ui.menu;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.li;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasDeselectionHandler;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

/**
 * The base implementation for {@link AbstractMenu} items
 *
 * @param <V> The type of the menu item value
 * @param <T> The type of the class extending from this class
 */
public class AbstractMenuItem<V, T extends AbstractMenuItem<V, T>>
    extends BaseDominoElement<HTMLLIElement, T>
    implements HasSelectionHandler<T, T>, HasDeselectionHandler<T> {

  private final DominoElement<HTMLLIElement> root = DominoElement.of(li().css("menu-item"));
  private final DominoElement<HTMLAnchorElement> linkElement =
      DominoElement.of(a())
          .setAttribute("tabindex", "0")
          .setAttribute("aria-expanded", "true")
          .setAttribute("href", "#");
  private final FlexItem<HTMLDivElement> contentContainer = FlexItem.create();
  private final FlexLayout mainContainer = FlexLayout.create().css("menu-item-cntnr");
  private final FlexLayout leftAddOnsContainer = FlexLayout.create().css("ddi-left-addon");
  private final FlexItem<HTMLDivElement> contentElement = FlexItem.create().css("ddi-content");
  private final FlexLayout rightAddOnsContainer = FlexLayout.create().css("ddi-right-addon");

  protected AbstractMenu<V, ?> parent;

  private final List<HasSelectionHandler.SelectionHandler<T>> selectionHandlers = new ArrayList<>();
  private final List<HasDeselectionHandler.DeselectionHandler> deselectionHandlers =
      new ArrayList<>();
  private String key;
  private V value;

  public AbstractMenuItem() {
    init((T) this);
    mainContainer
        .setGap("4px")
        .appendChild(FlexItem.create().appendChild(leftAddOnsContainer))
        .appendChild(contentElement.setFlexGrow(1))
        .appendChild(FlexItem.create().appendChild(rightAddOnsContainer));
    contentContainer.appendChild(mainContainer);
    root.appendChild(linkElement.appendChild(contentContainer));
    addEventsListener(
        evt -> {
          evt.stopPropagation();
          evt.preventDefault();
          select();
          parent.onItemSelected(this);
        },
        EventType.touchstart.getName(),
        EventType.touchend.getName(),
        EventType.click.getName());
  }

  /**
   * Adds an element as an add-on to the left
   *
   * @param addOn {@link FlexItem}
   * @return same menu item instance
   */
  public T addLeftAddOn(FlexItem<?> addOn) {
    leftAddOnsContainer.appendChild(addOn);
    return (T) this;
  }

  /**
   * Adds an element as an add-on to the right
   *
   * @param addOn {@link FlexItem}
   * @return same menu item instance
   */
  public T addRightAddOn(FlexItem<?> addOn) {
    rightAddOnsContainer.appendChild(addOn);
    return (T) this;
  }

  /** @return The {@link FlexItem} of the main content conatiner */
  public FlexItem<HTMLDivElement> getContentElement() {
    return contentElement;
  }

  /**
   * Appends a {@link Node} to the contentElement
   *
   * @param node {@link Node} to be appended to the component
   * @return same menu item instance
   */
  @Override
  public T appendChild(Node node) {
    contentElement.appendChild(node);
    return (T) this;
  }

  /**
   * Appends a {@link IsElement} to the contentElement
   *
   * @param element {@link IsElement} to be appended to the component
   * @return same menu item instance
   */
  @Override
  public T appendChild(IsElement<?> element) {
    contentElement.appendChild(element);
    return (T) this;
  }

  /**
   * Apply a search token matching on the menu item
   *
   * @param token String search text
   * @param caseSensitive boolean, true if the search is case-sensitive
   * @return boolean, true if the menu item match the search token, false if not
   */
  public boolean onSearch(String token, boolean caseSensitive) {
    if (isNull(token) || token.isEmpty()) {
      this.show();
    } else {
      hide();
    }
    return false;
  }

  /**
   * Selects the menu item and trigger the select handlers
   *
   * @return same menu item instance
   */
  public T select() {
    return select(false);
  }

  /**
   * Deselects the menu item and trigger the selection handlers
   *
   * @return same menu item instance
   */
  public T deselect() {
    return deselect(false);
  }

  /**
   * Selects the menu item with the option to trigger/disable the select handlers
   *
   * @param silent boolean, true to avoid triggering the select handlers.
   * @return same menu item instance
   */
  public T select(boolean silent) {
    if (!isDisabled()) {
      setAttribute("selected", true);
      if (!silent) {
        selectionHandlers.forEach(handler -> handler.onSelection((T) this));
      }
    }
    return (T) this;
  }

  /**
   * Deselect the menu item with the option to trigger/disable the select handlers
   *
   * @param silent boolean, true to avoid triggering the select handlers.
   * @return same menu item instance
   */
  public T deselect(boolean silent) {
    if (!isDisabled()) {
      setAttribute("selected", false);
      if (!silent) {
        deselectionHandlers.forEach(DeselectionHandler::onDeselection);
      }
    }
    return (T) this;
  }

  /** @return boolean, true if the menu item is selected */
  public boolean isSelected() {
    return Optional.ofNullable(getAttribute("selected")).map(Boolean::parseBoolean).orElse(false);
  }

  /** {@inheritDoc} */
  @Override
  public T addSelectionHandler(HasSelectionHandler.SelectionHandler<T> selectionHandler) {
    if (nonNull(selectionHandler)) {
      selectionHandlers.add(selectionHandler);
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T removeSelectionHandler(HasSelectionHandler.SelectionHandler<T> selectionHandler) {
    if (nonNull(selectionHandler)) {
      selectionHandlers.remove(selectionHandler);
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T addDeselectionHandler(DeselectionHandler deselectionHandler) {
    if (nonNull(deselectionHandler)) {
      deselectionHandlers.add(deselectionHandler);
    }
    return (T) this;
  }

  /**
   * Force focus on the menu item
   *
   * @return same menu item instance
   */
  public T focus() {
    getClickableElement().focus();
    return (T) this;
  }

  void setParent(AbstractMenu<V, ?> menu) {
    this.parent = menu;
  }

  /** @return String unique key of the menu item */
  public String getKey() {
    return key;
  }

  /**
   * @param key String unique key of the menu item
   * @return String menu iten unique key
   */
  public T setKey(String key) {
    this.key = key;
    return (T) this;
  }

  /** @return the value of the menu item */
  public V getValue() {
    return value;
  }

  /**
   * @param value the value of the meu item
   * @return same menu item instance
   */
  public T setValue(V value) {
    this.value = value;
    return (T) this;
  }

  /** @return boolean, true if this item has a sub-menu, false if not */
  public boolean hasMenu() {
    return false;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement getClickableElement() {
    return linkElement.element();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return root.element();
  }
}
