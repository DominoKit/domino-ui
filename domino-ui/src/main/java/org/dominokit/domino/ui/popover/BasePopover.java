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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.collapsible.Collapsible.DUI_COLLAPSED;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.*;
import java.util.Objects;
import java.util.function.Supplier;
import jsinterop.base.Js;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.PopoverConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.menu.direction.DropDirectionContext;
import org.dominokit.domino.ui.utils.*;

/**
 * The base class for creating popovers in the Domino UI framework. Popovers are small overlays that
 * can be displayed next to an HTML element and often contain additional information or actions.
 * This class provides the core functionality for creating and managing popovers.
 *
 * <p>Usage Example:
 *
 * <pre>
 * // Create a new popover attached to an HTML element
 * Element targetElement = document.getElementById("popover-target");
 * BasePopover&lt;MyPopover&gt; popover = new MyPopover(targetElement);
 *
 * // Customize the popover
 * popover.withHeader(header -&gt; header.setTextContent("Popover Header"));
 * popover.withBody(body -&gt; body.setTextContent("Popover Content"));
 *
 * // Show the popover
 * popover.expand();
 * </pre>
 *
 * @param <T> The type of the popover class that extends {@code BasePopover}.
 * @see BaseDominoElement
 */
public abstract class BasePopover<T extends BasePopover<T>>
    extends BaseDominoElement<HTMLDivElement, T>
    implements IsPopup<T>,
        PopoverStyles,
        FollowOnScroll.ScrollFollower,
        HasComponentConfig<PopoverConfig> {
  protected final DominoElement<Element> targetElement;
  protected final EventListener closeAllListener;
  private DivElement root;
  private DivElement wrapper;
  private DivElement arrow;
  private DivElement header;
  private DivElement body;

  private DropDirection popupPosition;

  private boolean closeOthers = true;
  protected final EventListener closeListener;
  private final FollowOnScroll followOnScroll;
  private Supplier<Boolean> openCondition = () -> true;
  private EventListener lostFocusListener;
  private boolean closeOnBlur;
  private PopoverConfig ownConfig;
  private int openDelay;
  protected DelayedExecution delayedExecution;

  /**
   * Constructs a new BasePopover associated with the provided target element. BasePopover is the
   * base class for creating popovers in the Domino UI framework.
   *
   * @param target The HTML element to which the popover will be attached.
   */
  public BasePopover(Element target) {
    this.targetElement = elementOf(target);
    root =
        div()
            .addCss(dui_popover)
            .setAttribute("dui-position-x-offset", "9")
            .appendChild(
                wrapper =
                    div()
                        .addCss(dui_popover_wrapper)
                        .appendChild(arrow = div().addCss(dui_popover_arrow))
                        .appendChild(header = div().addCss(dui_popover_header))
                        .appendChild(body = div().addCss(dui_popover_body)));

    init((T) this);
    this.popupPosition = getConfig().getDefaultPopoverDropDirection();
    this.closeOnBlur = getConfig().closeOnBlur();
    this.openDelay = getConfig().openDelay();

    followOnScroll = new FollowOnScroll(targetElement.element(), this);

    closeListener = getCloseListener();
    root.addEventListener(
        EventType.click.getName(),
        evt -> {
          evt.preventDefault();
          evt.stopPropagation();
        });
    targetElement.onDetached(
        mutationRecord -> {
          close();
          DomGlobal.document.body.removeEventListener("blur", lostFocusListener, true);
        });

    onDetached(
        mutationRecord -> {
          body().removeEventListener(EventType.keydown.getName(), closeListener);
          DomGlobal.document.body.removeEventListener("blur", lostFocusListener, true);
          close();
        });
    addCollapseListener(this::doClose);
    closeAllListener =
        evt -> {
          CustomEvent<String> event = Js.uncheckedCast(evt);
          if (!Objects.equals(event.detail, getDominoId())) {
            close();
          }
        };
    setAttribute(DUI_COLLAPSED, "true");
    lostFocusListener =
        evt -> {
          if (isCloseOnBlur()) {
            DomGlobal.setTimeout(
                p0 -> {
                  Element e = DomGlobal.document.activeElement;
                  if (!(targetElement.contains(e)
                      || e.equals(targetElement)
                      || this.element().contains(e)
                      || e.equals(this.element()))) {
                    close();
                  }
                },
                0);
          }
        };
  }

  @Override
  public PopoverConfig getOwnConfig() {
    return ownConfig;
  }

  public T setOwnConfig(PopoverConfig ownConfig) {
    this.ownConfig = ownConfig;
    return (T) this;
  }

  /** @return delay in milliseconds before showing the popover. */
  public int getOpenDelay() {
    return openDelay;
  }

  /**
   * @param openDelay milliseconds to wait before showing the popover.
   * @return same component instance
   */
  public T setOpenDelay(int openDelay) {
    this.openDelay = openDelay;
    return (T) this;
  }

  /**
   * Gets the EventListener responsible for closing the popover when certain events occur.
   *
   * <p>Subclasses should override this method to provide a custom EventListener that defines the
   * popover's close behavior.
   *
   * @return The EventListener for closing the popover.
   */
  protected abstract EventListener getCloseListener();

  /**
   * Expands the popover, displaying it on the screen.
   *
   * @return The current instance of the popover.
   */
  @Override
  public T expand() {
    if (isEnabled() && (isNull(openCondition.get()) || openCondition.get())) {
      if (closeOthers) {
        closeOthers(getDominoId());
      }
      doOpen();
      getConfig().getZindexManager().onPopupOpen(this);
      triggerOpenListeners((T) this);
    }
    return (T) this;
  }

  /**
   * Opens the popover, making it visible on the screen.
   *
   * @return The instance of the popover after opening.
   */
  public T open() {
    return expand();
  }

  /**
   * Internal method to perform the opening of the popover. It appends the popover's root element to
   * the body, positions the popover, and starts monitoring for scroll events (if applicable).
   */
  protected void doOpen() {
    if (getOpenDelay() > 0) {
      if (nonNull(this.delayedExecution)) {
        this.delayedExecution.cancel();
      }
      this.delayedExecution = DelayedExecution.execute(this::openPopover, getOpenDelay());
    } else {
      openPopover();
    }
  }

  private void openPopover() {
    body().appendChild(root.element());
    super.expand();
    doPosition();
    if (!isCloseOnScroll()) {
      followOnScroll.start();
    }
    DomGlobal.document.body.addEventListener("blur", lostFocusListener, true);
  }

  /** Positions the popover element based on the specified or default drop direction. */
  private void doPosition() {
    doPosition(this.popupPosition);
  }

  /**
   * Positions the popover element based on the provided drop direction.
   *
   * @param position The drop direction to position the popover.
   */
  protected void doPosition(DropDirection position) {
    popupPosition.position(DropDirectionContext.of(root.element(), targetElement.element()));
  }

  /**
   * Closes the popover, hiding it from view.
   *
   * @return The instance of the popover after closing.
   */
  public T close() {
    collapse();
    return (T) this;
  }

  /**
   * Closes other popovers that are currently open, except for the one with the specified source ID.
   *
   * @param sourceId The unique identifier of the popover to exclude from closing others.
   * @return The instance of the popover after closing others.
   */
  protected abstract T closeOthers(String sourceId);

  /**
   * Internal method to perform the closing of the popover. It stops monitoring scroll events,
   * removes the popover element, and triggers collapse listeners.
   */
  protected void doClose() {
    followOnScroll.stop();
    element().remove();
    body().removeEventListener(EventType.keydown.getName(), closeListener);
    getConfig().getZindexManager().onPopupClose(this);
    triggerCloseListeners((T) this);
    if (nonNull(this.delayedExecution)) {
      this.delayedExecution.cancel();
    }
  }

  /**
   * {@inheritDoc} Returns whether the popover is modal. Popovers are not modal by default.
   *
   * @return {@code false} since popovers are not modal by default.
   */
  @Override
  public boolean isModal() {
    return false;
  }

  /**
   * {@inheritDoc} Returns whether the popover should automatically close. Popovers are set to close
   * automatically by default.
   *
   * @return {@code true} since popovers are set to close automatically by default.
   */
  @Override
  public boolean isAutoClose() {
    return true;
  }

  /**
   * Discards the popover by closing it. This method is equivalent to calling the {@link #close()}
   * method. It is provided for convenience to explicitly indicate the intention to discard the
   * popover.
   */
  public void discard() {
    close();
  }

  /**
   * Sets the position of the popover relative to its target element.
   *
   * @param position The desired position of the popover.
   * @return The current instance of the popover.
   */
  public T setPosition(DropDirection position) {
    this.popupPosition.cleanup(this.element());
    this.popupPosition = position;
    if (isAttached()) {
      doPosition();
    }
    return (T) this;
  }

  public DropDirection getPopupPosition() {
    return popupPosition;
  }

  /**
   * Specifies whether the popover should automatically close when other popovers are opened.
   *
   * @param closeOthers {@code true} to close other popovers, {@code false} to keep them open.
   * @return The current instance of the popover.
   */
  public T setCloseOthers(boolean closeOthers) {
    this.closeOthers = closeOthers;
    return (T) this;
  }

  /**
   * Gets the element representing the arrow of the popover.
   *
   * @return The arrow element of the popover.
   */
  public DivElement getArrowElement() {
    return arrow;
  }

  /**
   * Sets the content of the popover's arrow element.
   *
   * @param handler A function to customize the arrow element.
   * @return The current instance of the popover.
   */
  public T withArrow(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, arrow);
    return (T) this;
  }

  /**
   * Gets the element representing the header of the popover.
   *
   * @return The header element of the popover.
   */
  public DivElement getHeaderElement() {
    return header;
  }

  /**
   * Sets the content of the popover's header element.
   *
   * @param handler A function to customize the header element.
   * @return The current instance of the popover.
   */
  public T withHeader(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, header);
    return (T) this;
  }

  /**
   * Gets the body element of the popover.
   *
   * @return The body element of the popover.
   */
  public DivElement getBody() {
    return body;
  }

  /**
   * Sets the content of the popover's body element.
   *
   * @param handler A function to customize the body element.
   * @return The current instance of the popover.
   */
  public T withBody(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, body);
    return (T) this;
  }

  /**
   * Gets the HTML element to which the popover's content should be appended.
   *
   * @return The HTML element to which the popover's content should be appended.
   */
  @Override
  public HTMLElement getAppendTarget() {
    return body.element();
  }

  /**
   * Sets whether the popover should be closed automatically when the user scrolls the page.
   *
   * @param closeOnScroll {@code true} to enable automatic closing on page scroll, {@code false}
   *     otherwise.
   * @return The updated instance of the popover.
   */
  public T closeOnScroll(boolean closeOnScroll) {
    setAttribute("d-close-on-scroll", closeOnScroll);
    return (T) this;
  }

  /**
   * Sets a condition supplier that determines whether the popover should be opened. The popover
   * will only open if the condition provided by the supplier evaluates to {@code true}.
   *
   * @param openCondition The supplier that provides the open condition.
   * @return The updated instance of the popover.
   */
  public T setOpenCondition(Supplier<Boolean> openCondition) {
    this.openCondition = openCondition;
    return (T) this;
  }

  /**
   * Checks if the popover should be closed when the user clicks outside of it (loses focus).
   *
   * @return {@code true} if the popover should be closed on blur, {@code false} otherwise.
   */
  public boolean isCloseOnBlur() {
    return closeOnBlur;
  }

  /**
   * Specifies whether the popover should automatically close when the user clicks outside of it.
   *
   * @param closeOnBlur {@code true} to close on blur, {@code false} to keep it open.
   * @return The current instance of the popover.
   */
  public T setCloseOnBlur(boolean closeOnBlur) {
    this.closeOnBlur = closeOnBlur;
    return (T) this;
  }

  @Override
  public ZIndexLayer getZIndexLayer() {
    return targetElement.getZIndexLayer();
  }

  /**
   * Gets the DOM element representing the popover.
   *
   * @return The DOM element of the popover.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * Checks if the popover should automatically close when the user scrolls the page.
   *
   * @return {@code true} if the popover should close on page scroll, {@code false} otherwise.
   */
  public boolean isCloseOnScroll() {
    return hasAttribute("d-close-on-scroll")
        && getAttribute("d-close-on-scroll").equalsIgnoreCase("true");
  }

  /**
   * Checks if the follower (popover) is currently open.
   *
   * @return {@code true} if the follower is open, {@code false} otherwise.
   */
  @Override
  public boolean isFollowerOpen() {
    return isAttached();
  }

  /** Positions the follower (popover) relative to its target element. */
  @Override
  public void positionFollower() {
    doPosition();
  }
}
