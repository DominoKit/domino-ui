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
import static org.dominokit.domino.ui.popover.PopupPosition.TOP;
import static org.dominokit.domino.ui.popover.TooltipStyles.*;
import static org.jboss.elemento.Elements.div;

import elemental2.dom.*;
import java.util.Optional;
import java.util.function.Consumer;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementObserver;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

/**
 * A component for showing a content when hovering over a target element
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link TooltipStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Tooltip.create(element, "Tooltip on top").position(PopupPosition.TOP);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class Tooltip extends BaseDominoElement<HTMLDivElement, Tooltip> {

  private final DominoElement<HTMLDivElement> element =
      DominoElement.of(div().css(TOOLTIP).attr("role", "tooltip"));
  private final DominoElement<HTMLDivElement> arrowElement =
      DominoElement.of(div().css(TOOLTIP_ARROW));
  private final DominoElement<HTMLDivElement> innerElement =
      DominoElement.of(div().css(TOOLTIP_INNER));
  private PopupPosition popupPosition = TOP;
  private final EventListener showToolTipListener;
  private final Consumer<Tooltip> removeHandler;
  private final EventListener removeToolTipListener;
  private Optional<ElementObserver> elementObserver = Optional.empty();

  public Tooltip(HTMLElement targetElement, String text) {
    this(targetElement, DomGlobal.document.createTextNode(text));
  }

  public Tooltip(HTMLElement targetElement, Node content) {
    element.appendChild(arrowElement);
    element.appendChild(innerElement);
    innerElement.appendChild(content);

    element.addCss(popupPosition.getDirectionClass());

    showToolTipListener =
        evt -> {
          evt.stopPropagation();
          document.body.appendChild(element.element());
          element.removeCss("fade", "in");
          element.addCss("fade", "in");
          popupPosition.position(element.element(), targetElement);
          position(popupPosition);
          elementObserver.ifPresent(ElementObserver::remove);
          elementObserver = ElementUtil.onDetach(targetElement, mutationRecord -> remove());
        };
    removeToolTipListener = evt -> element.remove();
    targetElement.addEventListener(EventType.mouseenter.getName(), showToolTipListener);

    targetElement.addEventListener(EventType.mouseleave.getName(), removeToolTipListener);
    init(this);

    removeHandler =
        tooltip -> {
          targetElement.removeEventListener(EventType.mouseenter.getName(), showToolTipListener);
          targetElement.removeEventListener(EventType.mouseleave.getName(), removeToolTipListener);
          elementObserver.ifPresent(ElementObserver::remove);
        };
  }

  /** {@inheritDoc} */
  @Override
  public Tooltip hide() {
    element.remove();
    return this;
  }

  /** Removes the tooltip */
  public void detach() {
    removeHandler.accept(this);
    remove();
  }

  /**
   * Creates new instance with text content
   *
   * @param target the target element
   * @param text the text content
   * @return new instance
   */
  public static Tooltip create(HTMLElement target, String text) {
    return new Tooltip(target, text);
  }

  /**
   * Creates new instance with element content
   *
   * @param target the target element
   * @param content the {@link Node} content
   * @return new instance
   */
  public static Tooltip create(HTMLElement target, Node content) {
    return new Tooltip(target, content);
  }

  /**
   * Creates new instance with text content
   *
   * @param element the target element
   * @param text the text content
   * @return new instance
   */
  public static Tooltip create(IsElement<?> element, String text) {
    return new Tooltip(element.element(), text);
  }

  /**
   * Creates new instance with element content
   *
   * @param element the target element
   * @param content the {@link Node} content
   * @return new instance
   */
  public static Tooltip create(IsElement<?> element, Node content) {
    return new Tooltip(element.element(), content);
  }

  /**
   * Positions the tooltip in a new position
   *
   * @param position the {@link PopupPosition}
   * @return same instance
   */
  public Tooltip position(PopupPosition position) {
    this.element.removeCss(popupPosition.getDirectionClass());
    this.popupPosition = position;
    this.element.addCss(popupPosition.getDirectionClass());

    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /** @return the arrow element */
  public DominoElement<HTMLDivElement> getArrowElement() {
    return arrowElement;
  }

  /** @return the inner container element */
  public DominoElement<HTMLDivElement> getInnerElement() {
    return innerElement;
  }

  /** @return the current {@link PopupPosition} */
  public PopupPosition getPopupPosition() {
    return popupPosition;
  }

  /** {@inheritDoc} */
  @Override
  public Tooltip setContent(Node content) {
    innerElement.clearElement();
    innerElement.appendChild(content);
    return this;
  }
}
