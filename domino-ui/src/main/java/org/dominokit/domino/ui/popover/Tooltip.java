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
import static org.dominokit.domino.ui.dialogs.ModalBackDrop.DUI_REMOVE_TOOLTIPS;

import elemental2.dom.Element;
import elemental2.dom.EventListener;
import elemental2.dom.MouseEvent;
import elemental2.dom.Node;
import java.util.function.Consumer;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.AnimationCollapseStrategy;
import org.dominokit.domino.ui.collapsible.CollapsibleDuration;
import org.dominokit.domino.ui.dialogs.ModalBackDrop;
import org.dominokit.domino.ui.events.EventType;

/**
 * Represents a Tooltip which is a brief, informative message that appears when a user interacts
 * with an element in a graphical user interface (GUI). Tooltips are usually initiated in one of two
 * ways: through a mouse-hover gesture or through a keyboard-hover gesture.
 *
 * <p>Usage example:
 *
 * <pre>
 * Tooltip.create(element, "This is a tooltip");
 * </pre>
 */
public class Tooltip extends BasePopover<Tooltip> {

  static {
    document.body.addEventListener(
        EventType.click.getName(),
        element -> {
          ModalBackDrop.INSTANCE.closeTooltips("");
        });
  }

  private final EventListener showListener;
  private final Consumer<Tooltip> removeHandler;
  private boolean closeOnEscape = true;

  /**
   * Creates a tooltip with the specified target element and text.
   *
   * @param target The target element.
   * @param text The text of the tooltip.
   * @return The created tooltip.
   */
  public static Tooltip create(Element target, String text) {
    return new Tooltip(target, elements.text(text));
  }

  /**
   * Creates a tooltip with the specified target element and text.
   *
   * @param target The target element.
   * @param text The text of the tooltip.
   * @return The created tooltip.
   */
  public static Tooltip create(IsElement<? extends Element> target, String text) {
    return new Tooltip(target.element(), elements.text(text));
  }

  /**
   * Creates a tooltip with the specified target element and content node.
   *
   * @param target The target element.
   * @param content The content node of the tooltip.
   * @return The created tooltip.
   */
  public static Tooltip create(Element target, Node content) {
    return new Tooltip(target, content);
  }

  /**
   * Creates a tooltip with the specified target element and content node.
   *
   * @param target The target element.
   * @param content The content node of the tooltip.
   * @return The created tooltip.
   */
  public static Tooltip create(IsElement<? extends Element> target, Node content) {
    return new Tooltip(target.element(), content);
  }

  /**
   * Constructor for creating a tooltip with the specified target element and content node.
   *
   * @param target The target element.
   * @param content The content node of the tooltip.
   */
  public Tooltip(Element target, Node content) {
    super(target);
    setAttribute("dui-tooltip", true);
    addCss(dui_tooltip);
    appendChild(content);
    showListener =
        evt -> {
          MouseEvent mouseEvent = Js.uncheckedCast(evt);
          evt.stopPropagation();
          if (mouseEvent.buttons == 0) {
            expand();
          }
        };
    addEventListener("click", closeListener);
    targetElement.addEventListener(EventType.mouseenter.getName(), showListener, false);
    //    targetElement.addEventListener(EventType.mouseleave.getName(), closeListener, false);
    removeHandler =
        tooltip -> {
          targetElement.removeEventListener(EventType.mouseenter.getName(), showListener);
          //          targetElement.removeEventListener(EventType.mouseleave.getName(),
          // closeListener);
        };
    setCollapseStrategy(
        new AnimationCollapseStrategy(
            Transition.FADE_IN, Transition.FADE_OUT, CollapsibleDuration._300ms));
    addCollapseListener(() -> removeEventListener(DUI_REMOVE_TOOLTIPS, closeAllListener));
  }

  /**
   * Retrieves the event listener responsible for closing the tooltip.
   *
   * @return An {@link EventListener} for the close event.
   */
  @Override
  protected EventListener getCloseListener() {
    return evt -> closeOthers("");
  }

  /**
   * Closes other tooltips, excluding the tooltip identified by the provided source ID.
   *
   * @param sourceId The ID of the tooltip that should remain open.
   * @return The current tooltip instance.
   */
  @Override
  protected Tooltip closeOthers(String sourceId) {
    ModalBackDrop.INSTANCE.closeTooltips(sourceId);
    return this;
  }

  /** Performs the actions required to open this tooltip. */
  @Override
  protected void doOpen() {
    super.doOpen();
    addEventListener(DUI_REMOVE_TOOLTIPS, closeAllListener);
    if (closeOnEscape) {
      body().onKeyDown(keyEvents -> keyEvents.onEscape(closeListener));
    }
  }

  /** Detaches the tooltip from the DOM. */
  public void detach() {
    removeHandler.accept(this);
    remove();
  }
}
