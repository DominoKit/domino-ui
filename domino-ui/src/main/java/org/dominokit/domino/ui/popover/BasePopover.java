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

import static org.dominokit.domino.ui.collapsible.Collapsible.DUI_COLLAPSED;

import elemental2.dom.*;
import java.util.Objects;
import jsinterop.base.Js;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.ZIndexConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.FollowOnScroll;
import org.dominokit.domino.ui.utils.IsPopup;

public abstract class BasePopover<T extends BasePopover<T>>
    extends BaseDominoElement<HTMLDivElement, T>
    implements IsPopup<T>,
        PopoverStyles,
        FollowOnScroll.ScrollFollower,
        HasComponentConfig<ZIndexConfig> {
  protected final Element targetElement;
  protected final EventListener closeAllListener;
  private DivElement root;
  private DivElement wrapper;
  private DivElement arrow;
  private DivElement header;
  private DivElement body;

  private DropDirection popupPosition = DropDirection.BEST_MIDDLE_UP_DOWN;

  private boolean closeOthers = true;
  protected final EventListener closeListener;
  private final FollowOnScroll followOnScroll;

  public BasePopover(Element target) {
    this.targetElement = target;
    root =
        div()
            .addCss(dui_popover)
            .appendChild(
                wrapper =
                    div()
                        .addCss(dui_popover_wrapper)
                        .appendChild(arrow = div().addCss(dui_popover_arrow))
                        .appendChild(header = div().addCss(dui_popover_header))
                        .appendChild(body = div().addCss(dui_popover_body)));

    init((T) this);
    followOnScroll = new FollowOnScroll(targetElement, this);

    closeListener = getCloseListener();
    root.addEventListener(
        EventType.click.getName(),
        evt -> {
          evt.preventDefault();
          evt.stopPropagation();
        });
    elementOf(targetElement).onDetached(mutationRecord -> close());

    onDetached(
        mutationRecord -> {
          body().removeEventListener(EventType.keydown.getName(), closeListener);
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
  }

  protected abstract EventListener getCloseListener();

  /** {@inheritDoc} */
  @Override
  public T expand() {
    if (isEnabled()) {
      if (closeOthers) {
        closeOthers(getDominoId());
      }
      doOpen();
      getConfig().getZindexManager().onPopupOpen(this);
      triggerExpandListeners((T) this);
    }
    return (T) this;
  }

  public T open() {
    return expand();
  }

  protected void doOpen() {
    body().appendChild(root.element());
    super.expand();
    doPosition();
    if (!isCloseOnScroll()) {
      followOnScroll.start();
    }
  }

  private void doPosition() {
    doPosition(this.popupPosition);
  }

  protected void doPosition(DropDirection position) {
    popupPosition.position(root.element(), targetElement);
  }

  /** Closes the popover */
  public T close() {
    collapse();
    return (T) this;
  }

  protected abstract T closeOthers(String sourceId);

  protected void doClose() {
    followOnScroll.stop();
    element().remove();
    body().removeEventListener(EventType.keydown.getName(), closeListener);
    getConfig().getZindexManager().onPopupClose(this);
    triggerCollapseListeners((T) this);
  }

  @Override
  public boolean isModal() {
    return false;
  }

  @Override
  public boolean isAutoClose() {
    return true;
  }

  /**
   * Closes the popover and remove it completely from the target element so it will not be shown
   * again
   */
  public void discard() {
    close();
  }

  /**
   * Sets the position of the popover related to the target element
   *
   * @param position the {@link DropDirection}
   * @return same instance
   */
  public T setPosition(DropDirection position) {
    this.popupPosition.cleanup(this.element());
    this.popupPosition = position;
    return (T) this;
  }

  /**
   * Sets if other popovers should be closed when open this one
   *
   * @param closeOthers true to close all popovers when this on is opened, false otherwise
   * @return same instance
   */
  public T setCloseOthers(boolean closeOthers) {
    this.closeOthers = closeOthers;
    return (T) this;
  }

  public DivElement getArrowElement() {
    return arrow;
  }

  public T withArrow(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, arrow);
    return (T) this;
  }

  public DivElement getHeaderElement() {
    return header;
  }

  public T withHeader(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, header);
    return (T) this;
  }

  public DivElement getBody() {
    return body;
  }

  public T withBody(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, body);
    return (T) this;
  }

  @Override
  protected HTMLElement getAppendTarget() {
    return body.element();
  }

  /**
   * Sets if the popover should be closed if scrolling
   *
   * @param closeOnScroll true to close on scroll, false otherwise
   * @return same instance
   */
  public T closeOnScroll(boolean closeOnScroll) {
    setAttribute("d-close-on-scroll", closeOnScroll);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** @return true if close on scrolling, false otherwise */
  public boolean isCloseOnScroll() {
    return hasAttribute("d-close-on-scroll")
        && getAttribute("d-close-on-scroll").equalsIgnoreCase("true");
  }

  @Override
  public boolean isFollowerOpen() {
    return isAttached();
  }

  @Override
  public void positionFollower() {
    doPosition();
  }
}
