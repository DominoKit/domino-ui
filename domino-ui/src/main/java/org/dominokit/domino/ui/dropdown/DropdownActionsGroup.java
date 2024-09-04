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
package org.dominokit.domino.ui.dropdown;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.li;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/**
 * A component represents A group of actions to be added to the {@link DropDownMenu}
 *
 * <p>This component provides grouping facility to group a list of actions and a title for them
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link DropDownStyles}
 *
 * <p>For example:
 *
 * <pre>
 *      DropdownActionsGroup.create("America")
 *         .appendChild(DropdownAction.create("United States of America"))
 *         .appendChild(DropdownAction.create("Brazil"))
 *         .appendChild(DropdownAction.create("Argentina"));
 * </pre>
 *
 * @param <T> The value type of the actions inside the group
 * @see BaseDominoElement
 * @see DropDownMenu
 * @see DropdownAction
 */
public class DropdownActionsGroup<T>
    extends BaseDominoElement<HTMLLIElement, DropdownActionsGroup<T>> {
  private final DominoElement<HTMLLIElement> element =
      DominoElement.of(li()).css(DropDownStyles.DROPDOWN_HEADER);
  private final List<DropdownAction<T>> actions = new ArrayList<>();
  private DropDownMenu menu;

  public DropdownActionsGroup(Node titleElement) {
    element.addEventListener(
        "click",
        evt -> {
          evt.preventDefault();
          evt.stopPropagation();
        });
    element.appendChild(titleElement);
    init(this);
  }

  /**
   * Creates an empty group with a text {@code title}
   *
   * @param title the title of the group
   * @param <T> the value type of the actions inside the group
   * @return new instance
   */
  public static <T> DropdownActionsGroup<T> create(String title) {
    return create(document.createTextNode(title));
  }

  /**
   * Creates an empty group with an element {@code title}
   *
   * @param titleElement the title {@link Node} of the group
   * @param <T> the value type of the actions inside the group
   * @return new instance
   */
  public static <T> DropdownActionsGroup<T> create(Node titleElement) {
    return new DropdownActionsGroup<>(titleElement);
  }

  /**
   * Creates an empty group with an element {@code title}
   *
   * @param titleElement the title {@link HTMLElement} of the group
   * @param <T> the value type of the actions inside the group
   * @return new instance
   */
  public static <T> DropdownActionsGroup<T> create(HTMLElement titleElement) {
    return create((Node) titleElement);
  }

  /**
   * Creates an empty group with an element {@code title}
   *
   * @param titleElement the title {@link IsElement} of the group
   * @param <T> the value type of the actions inside the group
   * @return new instance
   */
  public static <T> DropdownActionsGroup<T> create(IsElement<?> titleElement) {
    return create(titleElement.element());
  }

  /**
   * Adds action to the group
   *
   * @param action the {@link DropdownAction} to add
   * @return same instance
   */
  public DropdownActionsGroup<T> appendChild(DropdownAction<T> action) {
    actions.add(action);
    addActionToMenu(action);
    return this;
  }

  /** @return All the actions of the group */
  public List<DropdownAction<T>> getActions() {
    return actions;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return element.element();
  }

  boolean isAllHidden() {
    return actions.stream().allMatch(DropdownAction::isCollapsed);
  }

  /**
   * Appends this group to a {@code menu}, this will add all the actions to the menu without the
   * title
   *
   * @param menu the menu to bind to
   */
  public void bindTo(DropDownMenu menu) {
    this.menu = menu;
    for (DropdownAction<T> action : actions) {
      addActionToMenu(action);
    }
  }

  private void addActionToMenu(DropdownAction<T> action) {
    if (nonNull(menu)) {
      action.addHideListener(this::changeVisibility);
      action.addShowListener(this::changeVisibility);
      menu.appendChild(action);
    }
  }

  void changeVisibility() {
    if (isAllHidden()) {
      hide();
    } else {
      show();
    }
  }
}
