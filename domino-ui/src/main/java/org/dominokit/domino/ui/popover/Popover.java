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
package org.dominokit.domino.ui.popover;

import static elemental2.dom.DomGlobal.document;
import static org.dominokit.domino.ui.dialogs.ModalBackDrop.DUI_REMOVE_POPOVERS;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.AnimationCollapseStrategy;
import org.dominokit.domino.ui.collapsible.CollapsibleDuration;
import org.dominokit.domino.ui.dialogs.ModalBackDrop;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.menu.direction.DropDirection;

/**
 * The `Popover` class represents a pop-up dialog or tooltip that can be associated with an HTML
 * element. It provides options to control its behavior, such as opening on click, closing on
 * escape, and positioning.
 *
 * <p>Usage Example:
 *
 * <pre>
 * HTMLElement targetElement = document.getElementById("targetElement");
 * Popover popover = Popover.create(targetElement)
 *         .setOpenOnClick(true)    // Open the popover on click
 *         .setCloseOnEscape(true)  // Close the popover when pressing the "Escape" key
 *         .setModal(false);        // Make the popover non-modal
 * </pre>
 */
public class Popover extends BasePopover<Popover> {

  /** Static initialization block to add a global click event listener for closing popovers. */
  static {
    document.body.addEventListener(
        EventType.click.getName(),
        element -> {
          ModalBackDrop.INSTANCE.closePopovers("");
        });
  }

  private final EventListener showListener;
  private boolean openOnClick = true;
  private boolean closeOnEscape = true;
  private boolean asDialog = false;
  private final DropDirection dialog = DropDirection.MIDDLE_SCREEN;
  private boolean modal = false;

  /**
   * Creates a new `Popover` instance for the specified HTML element target.
   *
   * @param target The HTML element to associate the popover with.
   * @return A new `Popover` instance.
   */
  public static Popover create(HTMLElement target) {
    return new Popover(target);
  }

  /**
   * Creates a new `Popover` instance for the specified IsElement target.
   *
   * @param target The IsElement target to associate the popover with.
   * @return A new `Popover` instance.
   */
  public static Popover create(IsElement<? extends HTMLElement> target) {
    return new Popover(target.element());
  }

  /**
   * Creates a new `Popover` instance for the specified HTML element target.
   *
   * @param target The HTML element to associate the popover with.
   */
  public Popover(HTMLElement target) {
    super(target);
    showListener =
        evt -> {
          evt.stopPropagation();
          if (openOnClick) {
            expand();
          }
        };
    target.addEventListener(EventType.click.getName(), showListener);
    setCollapseStrategy(
        new AnimationCollapseStrategy(
            Transition.FADE_IN, Transition.FADE_OUT, CollapsibleDuration._300ms));

    MediaQuery.addOnSmallAndDownListener(
        () -> {
          this.asDialog = true;
        });
    MediaQuery.addOnMediumAndUpListener(
        () -> {
          this.asDialog = false;
        });
    addCollapseListener(() -> removeEventListener(DUI_REMOVE_POPOVERS, closeAllListener));
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns an event listener that is responsible for closing other popovers when this popover
   * is clicked. It prevents the event from propagating to higher levels, ensuring that only this
   * popover is closed.
   *
   * @return The event listener for closing other popovers.
   */
  @Override
  protected EventListener getCloseListener() {
    return evt -> closeOthers("");
  }

  /**
   * {@inheritDoc}
   *
   * <p>Performs the necessary actions when opening this popover. This method is called when the
   * popover is expanded, and it ensures that the popover is correctly positioned and responds to
   * events like closing on escape key press. It also adds an event listener to close all other
   * popovers if this popover is opened.
   */
  @Override
  protected void doOpen() {
    super.doOpen();
    addEventListener(DUI_REMOVE_POPOVERS, closeAllListener);
    if (closeOnEscape) {
      body().onKeyDown(keyEvents -> keyEvents.onEscape(closeListener));
    }
  }

  /**
   * Detaches the `Popover` from its associated target element and removes event listeners.
   *
   * @return The detached `Popover` instance.
   */
  public Popover detach() {
    targetElement.removeEventListener(EventType.click.getName(), showListener);
    document.removeEventListener(EventType.click.getName(), closeListener);
    return this;
  }

  /**
   * Sets whether the `Popover` should close when the "Escape" key is pressed.
   *
   * @param closeOnEscape {@code true} to close on "Escape" key press, {@code false} otherwise.
   * @return The updated `Popover` instance.
   */
  public Popover closeOnEscape(boolean closeOnEscape) {
    this.closeOnEscape = closeOnEscape;
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Closes other popovers by calling the `closePopovers` method of `ModalBackDrop.INSTANCE` with
   * the specified source ID. This method allows closing other popovers that might be open when this
   * popover is triggered.
   *
   * @param sourceId The source ID for identifying the origin of the close action.
   * @return This `Popover` instance.
   */
  @Override
  protected Popover closeOthers(String sourceId) {
    ModalBackDrop.INSTANCE.closePopovers(sourceId);
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Positions the popover element based on the current state of the `asDialog` property. If
   * `asDialog` is set to `true`, it positions the popover using the dialog layout by calling
   * `dialog.position`. Otherwise, it performs the default positioning by calling
   * `super.doPosition(position)`.
   *
   * @param position The `DropDirection` indicating the positioning of the popover.
   */
  @Override
  protected void doPosition(DropDirection position) {
    if (asDialog) {
      dialog.position(this.element(), targetElement);
    } else {
      dialog.cleanup(this.element());
      super.doPosition(position);
    }
  }

  /**
   * Checks if the `Popover` opens on a click event.
   *
   * @return {@code true} if the `Popover` opens on click, {@code false} otherwise.
   */
  public boolean isOpenOnClick() {
    return openOnClick;
  }

  /**
   * Sets whether the `Popover` should open on a click event.
   *
   * @param openOnClick {@code true} to open on click, {@code false} otherwise.
   * @return The updated `Popover` instance.
   */
  public Popover setOpenOnClick(boolean openOnClick) {
    this.openOnClick = openOnClick;
    return this;
  }

  /**
   * Sets whether the `Popover` should be modal (blocks interactions with other elements) or
   * non-modal.
   *
   * @param modal {@code true} for modal, {@code false} for non-modal.
   * @return The updated `Popover` instance.
   */
  public Popover setModal(boolean modal) {
    this.modal = modal;
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Determines whether this popover is displayed as a modal dialog. If the popover is modal, it
   * will prevent interactions with elements behind it while open.
   *
   * @return {@code true} if the popover is modal, {@code false} otherwise.
   */
  @Override
  public boolean isModal() {
    return modal;
  }
}
