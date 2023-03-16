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
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.AnimationCollapseStrategy;
import org.dominokit.domino.ui.collapsible.CollapseDuration;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

import static elemental2.dom.DomGlobal.document;

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
public class Popover extends BasePopover<Popover>{

  private final EventListener showListener;
  private boolean closeOnEscape = true;
  public static Popover create(HTMLElement target){
    return new Popover(target);
  }
  public static Popover create(IsElement<? extends HTMLElement> target){
    return new Popover(target.element());
  }

  public Popover(HTMLElement target) {
    super(target);
    showListener =
            evt -> {
              evt.stopPropagation();
              show();
            };
    target.addEventListener(EventType.click.getName(), showListener);
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

  public Popover detach(){
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
}
