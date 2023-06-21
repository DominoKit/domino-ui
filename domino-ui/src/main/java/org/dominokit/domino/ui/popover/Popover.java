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

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.AnimationCollapseStrategy;
import org.dominokit.domino.ui.collapsible.CollapseDuration;
import org.dominokit.domino.ui.dialogs.ModalBackDrop;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A component for showing content on top of another element in different locations.
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link
 * org.dominokit.domino.ui.popover.PopoverStyles}
 *
 * @see BaseDominoElement
 * @author vegegoku
 * @version $Id: $Id
 */
public class Popover extends BasePopover<Popover> {

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
   * create.
   *
   * @param target a {@link elemental2.dom.HTMLElement} object
   * @return a {@link org.dominokit.domino.ui.popover.Popover} object
   */
  public static Popover create(HTMLElement target) {
    return new Popover(target);
  }

  /**
   * create.
   *
   * @param target a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.popover.Popover} object
   */
  public static Popover create(IsElement<? extends HTMLElement> target) {
    return new Popover(target.element());
  }

  /**
   * Constructor for Popover.
   *
   * @param target a {@link elemental2.dom.HTMLElement} object
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
            Transition.FADE_IN, Transition.FADE_OUT, CollapseDuration._300ms));

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

  /** {@inheritDoc} */
  @Override
  protected EventListener getCloseListener() {
    return evt -> closeOthers("");
  }

  /** {@inheritDoc} */
  @Override
  protected void doOpen() {
    super.doOpen();
    addEventListener(DUI_REMOVE_POPOVERS, closeAllListener);
    if (closeOnEscape) {
      body().onKeyDown(keyEvents -> keyEvents.onEscape(closeListener));
    }
  }

  /**
   * detach.
   *
   * @return a {@link org.dominokit.domino.ui.popover.Popover} object
   */
  public Popover detach() {
    targetElement.removeEventListener(EventType.click.getName(), showListener);
    document.removeEventListener(EventType.click.getName(), closeListener);
    return this;
  }

  /**
   * Sets if the popover should be closed if escape key is pressed
   *
   * @param closeOnEscape true to close on escape, false otherwise
   * @return same instance
   */
  public Popover closeOnEscape(boolean closeOnEscape) {
    this.closeOnEscape = closeOnEscape;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  protected Popover closeOthers(String sourceId) {
    ModalBackDrop.INSTANCE.closePopovers(sourceId);
    return this;
  }

  /** {@inheritDoc} */
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
   * isOpenOnClick.
   *
   * @return a boolean
   */
  public boolean isOpenOnClick() {
    return openOnClick;
  }

  /**
   * Setter for the field <code>openOnClick</code>.
   *
   * @param openOnClick a boolean
   * @return a {@link org.dominokit.domino.ui.popover.Popover} object
   */
  public Popover setOpenOnClick(boolean openOnClick) {
    this.openOnClick = openOnClick;
    return this;
  }

  /**
   * Setter for the field <code>modal</code>.
   *
   * @param modal a boolean
   * @return a {@link org.dominokit.domino.ui.popover.Popover} object
   */
  public Popover setModal(boolean modal) {
    this.modal = modal;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isModal() {
    return modal;
  }
}
