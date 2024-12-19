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

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.CustomEvent;
import elemental2.dom.CustomEventInit;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.ZIndexConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PopupsCloser;

/**
 * Represents the backdrop for modals to show overlays that blocks the content behind a modal
 * dialog.
 *
 * <p>This class provides functionalities to manage and handle popovers, tooltips, and modals
 * backdrop in the UI, it can track the overlay across the page and all opened modals and it adjust
 * its position whenever a modal is opened or closed
 *
 * @see HasComponentConfig
 * @see BaseDominoElement
 */
public class ModalBackDrop extends BaseDominoElement<HTMLDivElement, ModalBackDrop>
    implements HasComponentConfig<ZIndexConfig> {

  public static final String DUI_REMOVE_POPOVERS = "dui-remove-popovers";
  public static final String DUI_REMOVE_TOOLTIPS = "dui-remove-tooltips";

  public static final ModalBackDrop INSTANCE = new ModalBackDrop();

  private CssClass dui_dialog_backdrop = () -> "dui-dialog-backdrop";

  private DivElement element;

  /** Private constructor to ensure singleton pattern. */
  private ModalBackDrop() {
    element = div();
    element.addCss(dui_dialog_backdrop);
    element
        .addEventListener(
            EventType.click,
            event -> {
              PopupsCloser.close();
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
        .addEventListener(
            EventType.scroll,
            event -> {
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

  /**
   * Closes all popovers without a specific selection attribute.
   *
   * @param sourceId The ID of the source element that triggers the closure.
   */
  public void closePopovers(String sourceId) {
    closePopovers(sourceId, null);
  }

  /**
   * Closes all tooltips associated with a given source ID.
   *
   * @param sourceId The ID of the source element that triggers the closure.
   */
  public void closeTooltips(String sourceId) {
    body()
        .querySelectorAll(".dui-tooltip")
        .forEach(
            e -> {
              if (!e.getDominoId().equalsIgnoreCase(sourceId)) {
                e.remove();
              }
              e.dispatchEvent(closeTooltipEvent(sourceId));
            });
  }

  /**
   * Closes popovers based on the selection attribute.
   *
   * @param sourceId The ID of the source element that triggers the closure.
   * @param selectAttribute The attribute to select which popovers to close.
   */
  public void closePopovers(String sourceId, String selectAttribute) {
    body().querySelectorAll(".dui-popover").stream()
        .filter(
            e ->
                isNull(selectAttribute)
                    || selectAttribute.isEmpty()
                    || e.hasAttribute(selectAttribute))
        .forEach(
            e -> {
              e.dispatchEvent(closePopoversEvent(sourceId));
            });
  }

  private static CustomEvent<String> closePopoversEvent(String sourceId) {
    CustomEventInit initOptions = CustomEventInit.create();
    initOptions.setDetail(sourceId);
    return new CustomEvent<>(DUI_REMOVE_POPOVERS, initOptions);
  }

  private static CustomEvent<String> closeTooltipEvent(String sourceId) {
    CustomEventInit initOptions = CustomEventInit.create();
    initOptions.setDetail(sourceId);
    return new CustomEvent<>(DUI_REMOVE_TOOLTIPS, initOptions);
  }

  /** Closes popovers on scroll event. */
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
