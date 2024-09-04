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
package org.dominokit.domino.ui.modals;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import java.util.List;
import jsinterop.base.Js;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.jboss.elemento.EventType;

/**
 * A utility class to show overlays that blocks the content behind a modal dialog.
 *
 * <p>this class can track the overlay across the page and all opened modals and it adjust its
 * position whenever a modal is opened or closed
 */
@Deprecated
public class ModalBackDrop extends BaseDominoElement<HTMLDivElement, ModalBackDrop> {

  public static final ModalBackDrop INSTANCE = new ModalBackDrop();

  /** The single instance of the overlay backdrop element */
  private DominoElement<HTMLDivElement> element;

  private ModalBackDrop() {
    element = DominoElement.div();
    init(this);
    element
        .css(ModalStyles.MODAL_BACKDROP)
        .css(ModalStyles.FADE)
        .css(ModalStyles.IN)
        .setTabIndex(-1)
        .addEventListener(
            "scroll",
            evt -> {
              evt.preventDefault();
              evt.stopPropagation();
            })
        .addEventListener(
            EventType.click,
            event -> {
              event.preventDefault();
              event.stopPropagation();
              if (element.isEqualNode(Js.uncheckedCast(event.target))) {
                closeCurrentOpen();
              }
            })
        .addEventListener(
            EventType.keypress,
            event -> {
              if (element.isEqualNode(Js.uncheckedCast(event.target))) {
                closeCurrentOpen();
              }
            });
  }

  private void closeCurrentOpen() {
    DominoUIConfig.INSTANCE
        .getZindexManager()
        .getTopLevelModal()
        .ifPresent(
            popup -> {
              if (popup.isAutoClose()) {
                popup.close();
              } else {
                popup.stealFocus();
              }
            });
  }

  /** Close all currently open {@link Popover}s */
  public void closePopovers() {
    DominoElement.body().querySelectorAll(".popover").forEach(BaseDominoElement::remove);
  }

  /** Automatically close all {@link Popover}s when the page is scrolled */
  public void onScrollClosePopovers() {
    DominoElement.body()
        .querySelectorAll(".popover[d-close-on-scroll='true']")
        .forEach(BaseDominoElement::remove);
  }

  public void showHideBodyScrolls() {
    List<DominoElement<HTMLElement>> openedDialogs =
        DominoElement.body()
            .querySelectorAll(
                ".modal.fade.in:not([class*='window']), .modal.fade.in.window.maximized");
    if (openedDialogs.isEmpty()) {
      DominoElement.body().removeCss(ModalStyles.MODAL_OPEN);
    } else {
      if (!DominoElement.body().containsCss(ModalStyles.MODAL_OPEN)) {
        DominoElement.body().addCss(ModalStyles.MODAL_OPEN);
      }
    }
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
