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
package org.dominokit.domino.ui.button;

import static org.dominokit.domino.ui.button.ButtonStyles.dui_fab;
import static org.dominokit.domino.ui.button.ButtonStyles.dui_fab_action;
import static org.dominokit.domino.ui.button.ButtonStyles.dui_fab_actions;
import static org.dominokit.domino.ui.button.ButtonStyles.dui_fab_button;
import static org.dominokit.domino.ui.button.ButtonStyles.dui_fab_expanded;
import static org.dominokit.domino.ui.utils.Domino.div;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.dominokit.domino.ui.style.BooleanCssClass;

/**
 * A floating action button that can optionally expose additional actions.
 *
 * <p>When no actions are added, the primary button behaves like a normal {@link Button}. When one
 * or more actions are added, clicking the primary button toggles the action list.
 */
public class Fab extends BaseDominoElement<HTMLDivElement, Fab> implements HasClickableElement {

  private final DivElement root;
  private final Button button;
  private DivElement actions;
  private boolean expanded;

  /** Creates an empty standalone FAB. */
  public Fab() {
    root = div().addCss(dui_fab);
    button = Button.create().addCss(dui_fab_button);
    button.addClickListener(event -> {
      if (hasActions()) {
        toggle();
      }
    });
    root.appendChild(button);
    init(this);
  }

  /** Creates a standalone FAB with an icon. */
  public Fab(Icon<?> icon) {
    this();
    button.setIcon(icon);
  }

  /** Creates a standalone FAB with text and an icon. */
  public Fab(String text, Icon<?> icon) {
    this();
    button.setText(text).setIcon(icon);
  }

  /** Creates an empty standalone FAB. */
  public static Fab create() {
    return new Fab();
  }

  /** Creates a standalone FAB with an icon. */
  public static Fab create(Icon<?> icon) {
    return new Fab(icon);
  }

  /** Creates a standalone FAB with text and an icon. */
  public static Fab create(String text, Icon<?> icon) {
    return new Fab(text, icon);
  }

  /**
   * Returns the primary button owned by this FAB.
   *
   * @return the primary button
   */
  public Button getButton() {
    return button;
  }

  /**
   * Adds an action button to this FAB.
   *
   * @param action the button to expose as an action
   * @return this FAB
   */
  public Fab addAction(BaseButton<?, ?> action) {
    initializeActions();
    action.addCss(dui_fab_action);
    actions.appendChild(action.element());
    return this;
  }

  /** Adds multiple action buttons to this FAB. */
  public Fab addAction(BaseButton<?, ?>... actions) {
    for (BaseButton<?, ?> action : actions) {
      addAction(action);
    }
    return this;
  }

  /** Expands or collapses the action list when actions are present. */
  public Fab setExpanded(boolean expanded) {
    if (!hasActions()) {
      return this;
    }
    this.expanded = expanded;
    addCss(BooleanCssClass.of(dui_fab_expanded, expanded));
    if (expanded) {
      actions.removeAttribute("hidden");
    } else {
      actions.setAttribute("hidden", true);
    }
    button.setAriaExpanded(expanded);
    return this;
  }

  /** Toggles the action list when actions are present. */
  public Fab toggle() {
    return setExpanded(!expanded);
  }

  /** Returns whether the action list is expanded. */
  public boolean isExpanded() {
    return expanded;
  }

  /** Applies customization to the primary button. */
  public Fab withButton(ChildHandler<Fab, Button> handler) {
    handler.apply(this, button);
    return this;
  }

  private boolean hasActions() {
    return actions != null && actions.element().hasChildNodes();
  }

  private void initializeActions() {
    if (actions != null) {
      return;
    }

    actions = div().addCss(dui_fab_actions);
    actions.setAttribute("hidden", true);
    root.insertBefore(actions.element(), button.element());
    button
        .setAriaHasPopup(true)
        .setAriaControls(actions.getDominoId())
        .setAriaExpanded(false);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  @Override
  public HTMLElement getClickableElement() {
    return button.element();
  }
}
