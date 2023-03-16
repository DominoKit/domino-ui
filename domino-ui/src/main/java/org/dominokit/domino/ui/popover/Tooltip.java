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

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.MouseEvent;
import elemental2.dom.Node;
import jsinterop.base.Js;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.AnimationCollapseStrategy;
import org.dominokit.domino.ui.collapsible.CollapseDuration;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

import java.util.function.Consumer;

/**
 * A component for showing content on top of another element in different locations.
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link PopoverStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Popover.create(element, "Popover", Paragraph.create("This is a popover"));
 * </pre>
 *
 * @see BaseDominoElement
 */
public class Tooltip extends BasePopover<Tooltip>{

  private final EventListener showListener;
  private final Consumer<Tooltip> removeHandler;
  private boolean closeOnEscape = true;
  public static Tooltip create(HTMLElement target, String text){
    return new Tooltip(target, TextNode.of(text));
  }

  public static Tooltip create(IsElement<? extends HTMLElement> target, String text){
    return new Tooltip(target.element(), TextNode.of(text));
  }
  public static Tooltip create(HTMLElement target, Node content){
    return new Tooltip(target, content);
  }
  public static Tooltip create(IsElement<? extends HTMLElement> target, Node content){
    return new Tooltip(target.element(), content);
  }

  public Tooltip(HTMLElement target, Node content) {
    super(target);
    addCss(dui_tooltip);
    appendChild(content);
    showListener =
            evt -> {
              MouseEvent mouseEvent = Js.uncheckedCast(evt);
              evt.stopPropagation();
              if (mouseEvent.buttons == 0) {
                show();
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
  }

  @Override
  protected void doOpen() {
    super.doOpen();
    if (closeOnEscape) {
      body().onKeyDown(keyEvents -> keyEvents.onEscape(closeListener));
    }
  }

  /**
   * Removes the tooltip
   */
  public void detach() {
    removeHandler.accept(this);
    remove();
  }
}