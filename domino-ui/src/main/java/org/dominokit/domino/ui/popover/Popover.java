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
import static org.dominokit.domino.ui.popover.PopoverStyles.*;
import static org.dominokit.domino.ui.popover.PopupPosition.TOP;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.h;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.AnimationCollapseStrategy;
import org.dominokit.domino.ui.collapsible.CollapseDuration;
import org.dominokit.domino.ui.datepicker.DateBox;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.modals.ModalBackDrop;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.timepicker.TimeBox;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

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
 * @see Switchable
 */
public class Popover extends BaseDominoElement<HTMLDivElement, Popover>
    implements Switchable<Popover> {

  private final Text headerText;
  private final HTMLElement targetElement;

  private final DominoElement<HTMLDivElement> element =
      DominoElement.of(div())
          .css(POPOVER)
          .attr("role", "tooltip")
          .style("display: block;")
          .elevate(Elevation.LEVEL_1);
  private final DominoElement<HTMLHeadingElement> headingElement =
      DominoElement.of(h(3)).css(POPOVER_TITLE);
  private final DominoElement<HTMLDivElement> contentElement =
      DominoElement.of(div()).css(POPOVER_CONTENT);

  private PopupPosition popupPosition = TOP;

  private boolean closeOthers = true;
  private final EventListener showListener;
  private final EventListener closeListener;
  private boolean disabled = false;
  private String positionClass;
  private boolean closeOnEscape = true;
  private boolean closeOnScroll = true;

  private final List<OpenHandler> openHandlers = new ArrayList<>();
  private final List<CloseHandler> closeHandlers = new ArrayList<>();

  static {
    document.body.addEventListener(EventType.click.getName(), element -> Popover.closeAll());
  }

  public Popover(HTMLElement target, String title, Node content) {
    this.targetElement = target;
    DominoElement<HTMLDivElement> arrowElement = DominoElement.of(div()).css(ARROW);
    element.appendChild(arrowElement);
    element.appendChild(headingElement);
    element.appendChild(contentElement);
    headerText = TextNode.of(title);
    headingElement.appendChild(headerText);
    contentElement.appendChild(content);
    showListener =
        evt -> {
          evt.stopPropagation();
          show();
        };
    target.addEventListener(EventType.click.getName(), showListener);
    closeListener = evt -> closeAll();
    element.addEventListener(EventType.click.getName(), Event::stopPropagation);
    ElementUtil.onDetach(
        targetElement,
        mutationRecord -> {
          close();
        });
    init(this);
    onDetached(
        mutationRecord ->
            document.body.removeEventListener(EventType.keydown.getName(), closeListener));
    setCollapseStrategy(
        new AnimationCollapseStrategy(
            Transition.FADE_IN, Transition.FADE_OUT, CollapseDuration._300ms));
    addHideListener(this::doClose);
  }

  /** {@inheritDoc} */
  @Override
  public Popover show() {
    if (isEnabled()) {
      if (closeOthers) {
        closeAll();
      }
      open();
      element.style().setZIndex(ModalBackDrop.getNextZIndex());
      ModalBackDrop.push(this);
      openHandlers.forEach(OpenHandler::onOpen);
    }

    return this;
  }

  private static void closeAll() {
    ModalBackDrop.closePopovers();
  }

  private void open() {
    document.body.appendChild(element.element());
    super.show();
    popupPosition.position(element.element(), targetElement);
    position(popupPosition);

    if (closeOnEscape) {
      KeyboardEvents.listenOnKeyDown(document.body).onEscape(closeListener);
    }
  }

  /** Closes the popover */
  public void close() {
    hide();
  }

  private void doClose() {
    element().remove();
    document.body.removeEventListener(EventType.keydown.getName(), closeListener);
    ModalBackDrop.popPopOver();
    closeHandlers.forEach(CloseHandler::onClose);
  }

  /**
   * Closes the popover and remove it completely from the target element so it will not be shown
   * again
   */
  public void discard() {
    close();
    targetElement.removeEventListener(EventType.click.getName(), showListener);
    document.removeEventListener(EventType.click.getName(), closeListener);
  }

  /**
   * Creates new instance hidden and with no paddings by default; this is helpful for pickers inside
   * {@link TimeBox} and {@link DateBox}
   *
   * @param target the target element
   * @param content the {@link Node} content
   * @return new instance
   */
  public static Popover createPicker(HTMLElement target, Node content) {
    Popover popover = new Popover(target, "", content);
    popover.getHeadingElement().setDisplay("none");
    popover.getContentElement().setCssProperty("padding", "0px");

    return popover;
  }

  /**
   * Same as {@link Popover#createPicker(HTMLElement, Node)} but with wrapper {@link IsElement}
   *
   * @param target the target element
   * @param content the {@link IsElement} content
   * @return new instance
   */
  public static Popover createPicker(IsElement<?> target, IsElement<?> content) {
    Popover popover = new Popover(target.element(), "", content.element());
    popover.getHeadingElement().setDisplay("none");
    popover.getContentElement().setCssProperty("padding", "0px");

    return popover;
  }

  /**
   * Creates new instance for target with title and content
   *
   * @param target the target element
   * @param title the title of the popover
   * @param content the content {@link Node}
   * @return new instance
   */
  public static Popover create(HTMLElement target, String title, Node content) {
    return new Popover(target, title, content);
  }

  /**
   * Creates new instance for target with title and content
   *
   * @param target the target element
   * @param title the title of the popover
   * @param content the content {@link Node}
   * @return new instance
   */
  public static Popover create(HTMLElement target, String title, IsElement<?> content) {
    return new Popover(target, title, content.element());
  }

  /**
   * Creates new instance for target with title and content
   *
   * @param target the target element
   * @param title the title of the popover
   * @param content the content {@link Node}
   * @return new instance
   */
  public static Popover create(IsElement<?> target, String title, Node content) {
    return new Popover(target.element(), title, content);
  }

  /**
   * Creates new instance for target with title and content
   *
   * @param target the target element
   * @param title the title of the popover
   * @param content the content {@link IsElement}
   * @return new instance
   */
  public static Popover create(IsElement<?> target, String title, IsElement<?> content) {
    return new Popover(target.element(), title, content.element());
  }

  /**
   * Sets the position of the popover related to the target element
   *
   * @param position the {@link PopupPosition}
   * @return same instance
   */
  public Popover position(PopupPosition position) {
    this.element.removeCss(this.positionClass);
    this.popupPosition = position;
    this.positionClass = position.getDirectionClass();
    this.element.addCss(this.positionClass);

    return this;
  }

  /**
   * Sets if other popovers should be closed when open this one
   *
   * @param closeOthers true to close all popovers when this on is opened, false otherwise
   * @return same instance
   */
  public Popover setCloseOthers(boolean closeOthers) {
    this.closeOthers = closeOthers;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Popover enable() {
    this.disabled = false;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Popover disable() {
    this.disabled = true;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return !disabled;
  }

  /** @return The heading element */
  public DominoElement<HTMLHeadingElement> getHeadingElement() {
    return headingElement;
  }

  /** Use {@link Popover#closeOnEscape(boolean)} instead */
  @Deprecated
  public Popover closeOnEscp(boolean closeOnEscp) {
    return closeOnEscape(closeOnEscp);
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

  /**
   * Sets if the popover should be closed if scrolling
   *
   * @param closeOnScroll true to close on scroll, false otherwise
   * @return same instance
   */
  public Popover closeOnScroll(boolean closeOnScroll) {
    setAttribute("d-close-on-scroll", closeOnScroll);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /** @return the content element */
  public DominoElement<HTMLDivElement> getContentElement() {
    return contentElement;
  }

  /** @return The header text */
  public Text getHeaderText() {
    return headerText;
  }

  /** @return true if close on scrolling, false otherwise */
  public boolean isCloseOnScroll() {
    return hasAttribute("d-close-on-scroll")
        && getAttribute("d-close-on-scroll").equalsIgnoreCase("true");
  }

  /**
   * Adds an open handler to be called when the popover is opened
   *
   * @param openHandler the {@link OpenHandler}
   * @return same instance
   */
  public Popover addOpenListener(OpenHandler openHandler) {
    this.openHandlers.add(openHandler);
    return this;
  }

  /**
   * Adds a close handler to be called when the popover is closed
   *
   * @param closeHandler the {@link CloseHandler}
   * @return same instance
   */
  public Popover addCloseListener(CloseHandler closeHandler) {
    this.closeHandlers.add(closeHandler);
    return this;
  }

  /**
   * Removes an open handler
   *
   * @param openHandler the {@link OpenHandler} to remove
   * @return same instance
   */
  public Popover removeOpenHandler(OpenHandler openHandler) {
    this.openHandlers.remove(openHandler);
    return this;
  }

  /**
   * Removes a close handler
   *
   * @param closeHandler the {@link CloseHandler} to remove
   * @return same instance
   */
  public Popover removeCloseHandler(CloseHandler closeHandler) {
    this.closeHandlers.remove(closeHandler);
    return this;
  }

  /** A handler to be called when opening the popover */
  @FunctionalInterface
  public interface OpenHandler {
    void onOpen();
  }

  /** A handler to be called when closing the popover */
  @FunctionalInterface
  public interface CloseHandler {
    void onClose();
  }
}
