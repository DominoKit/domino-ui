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
import org.dominokit.domino.ui.collapsible.CollapseDuration;
import org.dominokit.domino.ui.dialogs.ModalBackDrop;
import org.dominokit.domino.ui.events.EventType;
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
   * create.
   *
   * @param target a {@link elemental2.dom.Element} object
   * @param text a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.popover.Tooltip} object
   */
  public static Tooltip create(Element target, String text) {
    return new Tooltip(target, elements.text(text));
  }

  /**
   * create.
   *
   * @param target a {@link org.dominokit.domino.ui.IsElement} object
   * @param text a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.popover.Tooltip} object
   */
  public static Tooltip create(IsElement<? extends Element> target, String text) {
    return new Tooltip(target.element(), elements.text(text));
  }

  /**
   * create.
   *
   * @param target a {@link elemental2.dom.Element} object
   * @param content a {@link elemental2.dom.Node} object
   * @return a {@link org.dominokit.domino.ui.popover.Tooltip} object
   */
  public static Tooltip create(Element target, Node content) {
    return new Tooltip(target, content);
  }

  /**
   * create.
   *
   * @param target a {@link org.dominokit.domino.ui.IsElement} object
   * @param content a {@link elemental2.dom.Node} object
   * @return a {@link org.dominokit.domino.ui.popover.Tooltip} object
   */
  public static Tooltip create(IsElement<? extends Element> target, Node content) {
    return new Tooltip(target.element(), content);
  }

  /**
   * Constructor for Tooltip.
   *
   * @param target a {@link elemental2.dom.Element} object
   * @param content a {@link elemental2.dom.Node} object
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
    targetElement.addEventListener(EventType.mouseenter.getName(), showListener, false);
    targetElement.addEventListener(EventType.mouseleave.getName(), closeListener, false);
    removeHandler =
        tooltip -> {
          targetElement.removeEventListener(EventType.mouseenter.getName(), showListener);
          targetElement.removeEventListener(EventType.mouseleave.getName(), closeListener);
        };
    setCollapseStrategy(
        new AnimationCollapseStrategy(
            Transition.FADE_IN, Transition.FADE_OUT, CollapseDuration._300ms));
    addCollapseListener(() -> removeEventListener(DUI_REMOVE_TOOLTIPS, closeAllListener));
  }

  /** {@inheritDoc} */
  @Override
  protected EventListener getCloseListener() {
    return evt -> closeOthers("");
  }

  /** {@inheritDoc} */
  @Override
  protected Tooltip closeOthers(String sourceId) {
    ModalBackDrop.INSTANCE.closeTooltips(sourceId);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  protected void doOpen() {
    super.doOpen();
    addEventListener(DUI_REMOVE_TOOLTIPS, closeAllListener);
    if (closeOnEscape) {
      body().onKeyDown(keyEvents -> keyEvents.onEscape(closeListener));
    }
  }

  /** Removes the tooltip */
  public void detach() {
    removeHandler.accept(this);
    remove();
  }
}
