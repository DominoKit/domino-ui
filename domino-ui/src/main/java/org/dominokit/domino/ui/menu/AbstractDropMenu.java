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
package org.dominokit.domino.ui.menu;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.menu.direction.BestSideUpDownDropDirection;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.menu.direction.MiddleOfScreenDropDirection;
import org.dominokit.domino.ui.menu.direction.MouseBestFitDirection;
import org.dominokit.domino.ui.modals.ModalBackDrop;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.AppendStrategy;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.PopupsCloser;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

/**
 * An extended implementation of the {@link AbstractMenu} that allow the menu to be used as a
 * dropdown menu or a context menu. {@inheritDoc}
 */
public class AbstractDropMenu<V, T extends AbstractDropMenu<V, T>> extends AbstractMenu<V, T> {

  private boolean smallScreen;
  private DropDirection dropDirection = new BestSideUpDownDropDirection();
  private DropDirection contextMenuDropDirection = new MouseBestFitDirection();
  private DropDirection smallScreenDropDirection = new MiddleOfScreenDropDirection();
  private DropDirection effectiveDropDirection = dropDirection;
  private HTMLElement targetElement;
  private HTMLElement appendTarget = document.body;
  private AppendStrategy appendStrategy = AppendStrategy.LAST;

  private final List<CloseHandler> closeHandlers = new ArrayList<>();
  private final List<OpenHandler> openHandlers = new ArrayList<>();

  private AbstractDropMenu<V, ?> currentOpen;
  private AbstractMenu<V, ?> parent;
  private AbstractMenuItem<V, ?> parentItem;
  private EventListener openListener =
      evt -> {
        evt.stopPropagation();
        evt.preventDefault();
        getEffectiveDropDirection().init(evt);
        open();
      };
  private final FlexItem<HTMLDivElement> backArrowContainer =
      FlexItem.create().setOrder(0).css("back-arrow-icon");
  private boolean contextMenu = false;
  private boolean useSmallScreensDirection = true;

  public AbstractDropMenu() {
    this.setAttribute("domino-ui-root-menu", true)
        .setAttribute(PopupsCloser.DOMINO_UI_AUTO_CLOSABLE, true)
        .css("drop-menu");
    menuElement.elevate(Elevation.LEVEL_1);
    MediaQuery.addOnMediumAndDownListener(() -> this.smallScreen = true);
    MediaQuery.addOnLargeAndUpListener(
        () -> {
          this.smallScreen = false;
          headContainer.toggleDisplay(headerVisible);
        });

    keyboardNavigation
        .registerNavigationHandler(
            "ArrowLeft",
            (event, item) -> {
              if (nonNull(getParentItem())) {
                getParentItem().focus();
                this.close();
              }
            })
        .onFocus(
            item -> {
              if (isOpened()) {
                item.focus();
              }
            })
        .onEscape(this::close);

    backArrowContainer.appendChild(
        Icons.ALL
            .keyboard_backspace()
            .clickable()
            .addClickListener(this::backToParent)
            .addEventListener("touchend", this::backToParent)
            .addEventListener("touchstart", Event::stopPropagation));

    menuHeader.leftAddOnsContainer.appendChild(backArrowContainer);
  }

  private void backToParent(Event evt) {
    evt.stopPropagation();
    evt.preventDefault();

    this.close();
    if (nonNull(parent)) {

      if (parent instanceof AbstractDropMenu<?, ?>) {
        AbstractDropMenu<V, ?> parentDropMenu = (AbstractDropMenu<V, ?>) this.parent;
        parentDropMenu.open(true);
      }
    }
  }

  /** @return True if the menu is opened, false otherwise */
  public boolean isOpened() {
    return element.isAttached();
  }

  /**
   * Opens the menu with a boolean to indicate if the first element should be focused
   *
   * @param focus true to focus the first element
   */
  public void open(boolean focus) {
    if (isOpened()) {
      getEffectiveDropDirection().position(element.element(), getTargetElement());
    } else {
      closeOthers();
      searchBox.clearSearch();
      onAttached(
          mutationRecord -> {
            getEffectiveDropDirection().position(element.element(), getTargetElement());
            if (focus) {
              focus();
            }
            element.setCssProperty("z-index", ModalBackDrop.getNextZIndex() + 10 + "");
            openHandlers.forEach(OpenHandler::onOpen);
            DominoElement.of(getTargetElement()).onDetached(targetDetach -> close());
            DominoElement.of(getAppendTarget()).onDetached(targetDetach -> close());
          });

      appendStrategy.onAppend(getAppendTarget(), element.element());
      onDetached(record -> close());
      if (smallScreen && nonNull(parent) && parent instanceof AbstractDropMenu) {
        parent.hide();
        headContainer.show();
      }
      show();
    }
  }

  protected DropDirection getEffectiveDropDirection() {
    if (isUseSmallScreensDirection() && smallScreen) {
      return smallScreenDropDirection;
    } else {
      if (isContextMenu()) {
        return contextMenuDropDirection;
      } else {
        return dropDirection;
      }
    }
  }

  private void closeOthers() {
    if (this.hasAttribute("domino-sub-menu")
        && Boolean.parseBoolean(this.getAttribute("domino-sub-menu"))) {
      return;
    }
    PopupsCloser.close();
  }

  private void focus() {
    getFocusElement().focus();
  }

  /**
   * @return the {@link HTMLElement} that triggers this menu to open, and which the positioning of
   *     the menu will be based on.
   */
  public HTMLElement getTargetElement() {
    if (isNull(targetElement)) {
      setTargetElement(DominoElement.body());
    }
    return targetElement;
  }

  /**
   * @param targetElement The {@link IsElement} that triggers this menu to open, and which the
   *     positioning of the menu will be based on.
   * @return same menu instance
   */
  public T setTargetElement(IsElement<?> targetElement) {
    return (T) setTargetElement(targetElement.element());
  }

  /**
   * @param targetElement The {@link HTMLElement} that triggers this menu to open, and which the
   *     positioning of the menu will be based on.
   * @return same menu instance
   */
  public T setTargetElement(HTMLElement targetElement) {
    if (nonNull(this.targetElement)) {
      this.targetElement.removeEventListener(
          isContextMenu() ? EventType.contextmenu.getName() : EventType.click.getName(),
          openListener);
    }
    this.targetElement = targetElement;
    applyTargetListeners();
    return (T) this;
  }

  /** @return the {@link HTMLElement} to which the menu will be appended to when opened. */
  public HTMLElement getAppendTarget() {
    return appendTarget;
  }

  /**
   * set the {@link HTMLElement} to which the menu will be appended to when opened.
   *
   * @param appendTarget {@link HTMLElement}
   * @return same menu instance
   */
  public T setAppendTarget(HTMLElement appendTarget) {
    if (isNull(appendTarget)) {
      this.appendTarget = document.body;
    } else {
      this.appendTarget = appendTarget;
    }
    return (T) this;
  }

  /**
   * Opens the menu
   *
   * @return same menu instance
   */
  public T open() {
    open(true);
    return (T) this;
  }

  /**
   * Opens a sub menu that has this menu as its parent
   *
   * @param dropMenu {@link AbstractDropMenu} to open
   * @return same menu instance
   */
  public T openSubMenu(AbstractDropMenu<V, ?> dropMenu) {
    if (nonNull(currentOpen)) {
      currentOpen.close();
    }
    dropMenu.open();
    this.currentOpen = dropMenu;
    return (T) this;
  }

  /**
   * Close the menu
   *
   * @return same menu instance
   */
  public T close() {
    if (isOpened()) {
      this.remove();
      getTargetElement().focus();
      searchBox.clearSearch();
      menuItems.forEach(
          menuItem -> {
            if (menuItem instanceof AbstractDropMenuItem<?, ?>) {
              AbstractDropMenuItem<V, ?> dropMenuItem = (AbstractDropMenuItem<V, ?>) menuItem;
              dropMenuItem.onParentClosed();
            }
          });
      closeHandlers.forEach(CloseHandler::onClose);
      if (smallScreen && nonNull(parent) && parent instanceof AbstractDropMenu) {
        parent.show();
      }
    }
    return (T) this;
  }

  /** @return The current {@link DropDirection} of the menu */
  public DropDirection getDropDirection() {
    return dropDirection;
  }

  /**
   * Sets the {@link DropDirection} of the menu
   *
   * @param dropDirection {@link DropDirection}
   * @return same menu instance
   */
  public T setDropDirection(DropDirection dropDirection) {
    if (effectiveDropDirection.equals(this.dropDirection)) {
      this.dropDirection = dropDirection;
      this.effectiveDropDirection = this.dropDirection;
    } else {
      this.dropDirection = dropDirection;
    }
    return (T) this;
  }

  /**
   * Adds a close handler to be called when the menu is closed
   *
   * @param closeHandler The {@link CloseHandler} to add
   * @return same instance
   */
  public T addCloseHandler(CloseHandler closeHandler) {
    closeHandlers.add(closeHandler);
    return (T) this;
  }

  /**
   * Removes a close handler
   *
   * @param closeHandler The {@link CloseHandler} to remove
   * @return same instance
   */
  public T removeCloseHandler(CloseHandler closeHandler) {
    closeHandlers.remove(closeHandler);
    return (T) this;
  }

  /**
   * Adds an open handler to be called when the menu is opened
   *
   * @param openHandler The {@link OpenHandler} to add
   * @return same instance
   */
  public T addOpenHandler(OpenHandler openHandler) {
    openHandlers.add(openHandler);
    return (T) this;
  }

  /**
   * Removes an open handler
   *
   * @param openHandler The {@link OpenHandler} to remove
   * @return same instance
   */
  public T removeOpenHandler(OpenHandler openHandler) {
    openHandlers.remove(openHandler);
    return (T) this;
  }

  void setParent(AbstractMenu<V, ?> parent) {
    this.parent = parent;
  }

  /** @return the parent {@link AbstractDropMenu} of the menu */
  public AbstractMenu<?, ?> getParent() {
    return (T) parent;
  }

  void setParentItem(AbstractMenuItem<V, ?> parentItem) {
    this.parentItem = parentItem;
  }

  /** @return the {@link AbstractMenuItem} that opens the menu */
  public AbstractMenuItem<V, ?> getParentItem() {
    return parentItem;
  }

  /** {@inheritDoc} */
  @Override
  public boolean onSearch(String token) {
    this.menuItems.forEach(
        menuItem -> {
          if (menuItem instanceof AbstractDropMenuItem<?, ?>) {
            ((AbstractDropMenuItem<V, ?>) menuItem).closeSubMenu();
          }
        });
    return super.onSearch(token);
  }

  /** @return boolean, true if the menu is a context menu that will open on right click */
  public boolean isContextMenu() {
    return contextMenu;
  }

  /**
   * Set the menu as a context menu that will open when the target element got a right click instead
   * of a click
   *
   * @param contextMenu booleanm true to make the menu a context menu
   * @return same menu instance
   */
  public T setContextMenu(boolean contextMenu) {
    this.contextMenu = contextMenu;
    if (nonNull(targetElement)) {
      applyTargetListeners();
    }
    return (T) this;
  }

  private void applyTargetListeners() {
    if (isContextMenu()) {
      getTargetElement().removeEventListener(EventType.click.getName(), openListener);
      getTargetElement().addEventListener(EventType.contextmenu.getName(), openListener);
    } else {
      getTargetElement().removeEventListener(EventType.contextmenu.getName(), openListener);
      getTargetElement().addEventListener(EventType.click.getName(), openListener);
    }
  }

  @Override
  protected void onItemSelected(AbstractMenuItem<V, ?> item) {
    if (nonNull(parent)) {
      parent.onItemSelected(item);
    } else {
      super.onItemSelected(item);
    }
  }

  /**
   * @return boolean, tru if use of small screens drop direction to the middle of screen is used or
   *     else false
   */
  public boolean isUseSmallScreensDirection() {
    return useSmallScreensDirection;
  }

  /**
   * @param useSmallScreensDropDirection boolean, true to allow the switch to small screen middle of
   *     screen position, false to use the provided menu drop direction
   * @return same menu instance
   */
  public T setUseSmallScreensDirection(boolean useSmallScreensDropDirection) {
    this.useSmallScreensDirection = useSmallScreensDropDirection;
    if (!useSmallScreensDropDirection && getEffectiveDropDirection() == smallScreenDropDirection) {
      this.effectiveDropDirection = dropDirection;
    }
    return (T) this;
  }

  /** A handler that will be called when closing the menu */
  @FunctionalInterface
  public interface CloseHandler {
    /** Will be called when the menu is closed */
    void onClose();
  }

  /** A handler that will be called when opening the menu */
  @FunctionalInterface
  public interface OpenHandler {
    /** Will be called when the menu is opened */
    void onOpen();
  }
}
