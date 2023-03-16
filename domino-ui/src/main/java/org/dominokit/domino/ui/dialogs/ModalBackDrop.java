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
package org.dominokit.domino.ui.dialogs;

import elemental2.dom.CustomEvent;
import elemental2.dom.CustomEventInit;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.ZIndexConfig;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.jboss.elemento.EventType;

import java.util.List;

/**
 * A utility class to show overlays that blocks the content behind a modal dialog.
 *
 * <p>this class can track the overlay across the page and all opened modals and it adjust its
 * position whenever a modal is opened or closed
 */
public class ModalBackDrop extends BaseDominoElement<HTMLDivElement, ModalBackDrop> implements HasComponentConfig<ZIndexConfig> {

    public static final String DUI_REMOVE_POPOVERS = "dui-remove-popovers";

  public static final ModalBackDrop INSTANCE = new ModalBackDrop();
  private CssClass dui_dialog_backdrop = () -> "dui-dialog-backdrop";

  /** The single instance of the overlay backdrop element */
  private DominoElement<HTMLDivElement> element;

  private ModalBackDrop() {
    element = div();
      element.addCss(dui_dialog_backdrop);
      element.addEventListener(
                    EventType.click,
                    event -> {
                      if (ModalBackDrop.INSTANCE.isEqualNode(Js.uncheckedCast(event.target))) {
                        closeCurrentOpen();
                      }
                    })
            .addEventListener(
                    EventType.keypress,
                    event -> {
                      if (ModalBackDrop.INSTANCE.isEqualNode(Js.uncheckedCast(event.target))) {
                        closeCurrentOpen();
                      }
                    })
            .addEventListener(EventType.scroll, event -> {
              event.preventDefault();
              event.stopPropagation();
            });
      init(this);
  }

  private void closeCurrentOpen() {
      getConfig()
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
  public void closePopovers(String sourceId) {
    body().querySelectorAll(".dui-popover").forEach(e-> e.dispatchEvent(makeCloseEvent(sourceId)));
  }

    private static CustomEvent<String> makeCloseEvent(String sourceId){
        CustomEventInit initOptions= CustomEventInit.create();
        initOptions.setDetail(sourceId);
        return new CustomEvent<>(DUI_REMOVE_POPOVERS, initOptions);
    }

  /** Automatically close all {@link Popover}s when the page is scrolled */
  public void onScrollClosePopovers() {
    body()
        .querySelectorAll(".dui-popover[d-close-on-scroll='true']")
        .forEach(BaseDominoElement::remove);
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
