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
package org.dominokit.domino.ui.modals;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.AnimationCollapseStrategy;
import org.dominokit.domino.ui.collapsible.CollapseDuration;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

/**
 * A base implementation for components to show a pop-up
 *
 * @param <T> the type of the component extending from this class
 */
public abstract class BaseModal<T extends IsElement<HTMLDivElement>>
    extends BaseDominoElement<HTMLDivElement, T>
    implements IsModalDialog<T>, Switchable<T>, IsPopup<T> {

  private final List<OpenHandler> openHandlers = new ArrayList<>();
  private final List<CloseHandler> closeHandlers = new ArrayList<>();

  /** a component that contains the modal elements */
  public static class Modal implements IsElement<HTMLDivElement> {

    private final DominoElement<HTMLDivElement> root;
    private final DominoElement<HTMLDivElement> modalDialog;
    private final FlexLayout modalContent;
    private final FlexItem<HTMLDivElement> modalHeader;
    private final DominoElement<HTMLHeadingElement> modalTitle;
    private final FlexItem<HTMLDivElement> modalBody;
    private final FlexItem<HTMLDivElement> modalFooter;

    /** */
    public Modal() {
      root = DominoElement.div().setTabIndex(-1).css("modal").setAttribute("role", "dialog");
      modalDialog =
          DominoElement.div().setTabIndex(-1).css("modal-dialog").setAttribute("role", "document");
      modalContent =
          FlexLayout.create().setDirection(FlexDirection.TOP_TO_BOTTOM).css("modal-content");
      modalHeader = FlexItem.create().css("modal-header");
      modalTitle = DominoElement.of(h(4)).css("modal-title");
      modalBody = FlexItem.create().setFlexGrow(1).css("modal-body");
      modalFooter = FlexItem.create().css("modal-footer");

      root.appendChild(
          modalDialog.appendChild(
              modalContent
                  .appendChild(modalHeader.appendChild(modalTitle))
                  .appendChild(modalBody)
                  .appendChild(modalFooter)));

      root.hide();
    }

    /** {@inheritDoc} */
    @Override
    public HTMLDivElement element() {
      return root.element();
    }

    /**
     * @return the {@link HTMLHeadingElement} that contains the title text wrapped as {@link
     *     DominoElement}
     */
    public DominoElement<HTMLHeadingElement> getModalTitle() {
      return DominoElement.of(modalTitle);
    }

    /** @return the {@link HTMLDivElement} of the modal body wrapped as a {@link DominoElement} */
    public DominoElement<HTMLDivElement> getModalBody() {
      return DominoElement.of(modalBody);
    }

    /**
     * @return the {@link HTMLDivElement} that contains the header and the body wrapped as {@link
     *     DominoElement}
     */
    public DominoElement<HTMLDivElement> getModalDialog() {
      return DominoElement.of(modalDialog);
    }

    /**
     * @return the {@link HTMLDivElement} that has content container inside the modal body wrapped
     *     as {@link DominoElement}
     */
    public DominoElement<HTMLDivElement> getModalContent() {
      return DominoElement.of(modalContent);
    }

    /** @return the {@link HTMLDivElement} footer element wrapped as {@link DominoElement} */
    public DominoElement<HTMLDivElement> getModalFooter() {
      return DominoElement.of(modalFooter);
    }

    /**
     * @return the {@link HTMLDivElement} that contains the heading element that contains the title
     *     text wrapped as {@link DominoElement}
     */
    public DominoElement<HTMLDivElement> getModalHeader() {
      return DominoElement.of(modalHeader);
    }

    public void setMinWidth(String width) {
      modalDialog.setMinWidth(width);
      modalContent.setMinWidth(width);
    }

    public void setMinWidth(String width, boolean important) {
      modalDialog.setMinWidth(width, important);
      modalContent.setMinWidth(width, important);
    }

    public void setMinHeight(String height) {
      modalDialog.setMinHeight(height);
      modalContent.setMinHeight(height);
    }

    public void setMinHeight(String height, boolean important) {
      modalDialog.setMinHeight(height, important);
      modalContent.setMinHeight(height, important);
    }

    public void setWidth(String width) {
      modalDialog.setWidth(width);
      modalContent.setWidth(width);
    }

    public void setWidth(String width, boolean important) {
      modalDialog.setWidth(width, important);
      modalContent.setWidth(width, important);
    }

    public void setMaxWidth(String width) {
      modalDialog.setMaxWidth(width);
      modalContent.setMaxWidth(width);
    }

    public void setMaxWidth(String width, boolean important) {
      modalDialog.setMaxWidth(width, important);
      modalContent.setMaxWidth(width, important);
    }

    public void setMaxHeight(String height) {
      modalDialog.setMaxHeight(height);
      modalContent.setMaxHeight(height);
    }

    public void setMaxHeight(String height, boolean important) {
      modalDialog.setMaxHeight(height, important);
      modalContent.setMaxHeight(height, important);
    }
  }

  protected Modal modalElement;

  private boolean autoClose = true;

  private ModalSize modalSize;
  private ModalType modalType;

  private Color color;

  private Element firstFocusElement;
  private Element lastFocusElement;
  private Element activeElementBeforeOpen;
  private List<Element> focusElements = new ArrayList<>();
  private final Text headerText = DomGlobal.document.createTextNode("");
  private boolean open = false;
  private boolean disabled = false;
  private boolean autoAppendAndRemove = true;
  private boolean modal = true;
  private boolean autoFocus = true;

  public BaseModal() {
    modalElement = new Modal();
    modalElement.getModalHeader().hide();
    modalElement.getModalTitle().appendChild(headerText);

    addTabIndexHandler();
    setCollapseStrategy(
        new AnimationCollapseStrategy(
            Transition.FADE_IN, Transition.FADE_OUT, CollapseDuration._200ms));
    addHideListener(this::doClose);
  }

  /** @param title String modal header title */
  public BaseModal(String title) {
    this();
    showHeader();
    modalElement.modalTitle.setTextContent(title);
  }

  /** Force the tab to navigate inside the modal dialog only */
  void addTabIndexHandler() {
    element()
        .addEventListener(
            EventType.keydown.getName(),
            evt -> {
              if (evt instanceof KeyboardEvent) {
                KeyboardEvent keyboardEvent = (KeyboardEvent) evt;
                switch (keyboardEvent.code) {
                  case "Tab":
                    initFocusElements();
                    if (focusElements.size() <= 1) {
                      evt.preventDefault();
                    }
                    if (keyboardEvent.shiftKey) {
                      handleBackwardTab(evt);
                    } else {
                      handleForwardTab(evt);
                    }
                    if (!focusElements.contains(DominoDom.document.activeElement)
                        && nonNull(firstFocusElement)) {
                      firstFocusElement.focus();
                    }
                    break;
                  case "Escape":
                    if (isAutoClose()) {
                      close();
                    }
                    break;
                  default:
                    break;
                }
              }
            });
  }

  private void handleBackwardTab(Event evt) {
    if (DominoDom.document.activeElement.equals(firstFocusElement)) {
      evt.preventDefault();
      lastFocusElement.focus();
    }
  }

  private void handleForwardTab(Event evt) {
    if (DominoDom.document.activeElement.equals(lastFocusElement)) {
      evt.preventDefault();
      firstFocusElement.focus();
    }
  }

  /** Appends to the Modal body {@inheritDoc} */
  @Override
  public T appendChild(Node content) {
    modalElement.modalBody.appendChild(content);
    return (T) this;
  }

  /** Appends to the Modal body {@inheritDoc} */
  @Override
  public T appendChild(IsElement<?> content) {
    return appendChild(content.element());
  }

  /** Appends to the Modal body {@inheritDoc} */
  @Override
  public T appendFooterChild(Node content) {
    modalElement.modalFooter.appendChild(content);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T appendFooterChild(IsElement<?> content) {
    return appendFooterChild(content.element());
  }

  /** {@inheritDoc} */
  @Override
  public T large() {
    return setSize(ModalSize.LARGE);
  }

  /** {@inheritDoc} */
  @Override
  public T small() {
    return setSize(ModalSize.SMALL);
  }

  /**
   * @param size {@link org.dominokit.domino.ui.modals.IsModalDialog.ModalSize}
   * @return same Dialog instance
   */
  public T setSize(ModalSize size) {
    DominoElement<HTMLDivElement> modalElement = DominoElement.of(this.modalElement);
    if (nonNull(modalSize)) {
      modalElement.removeCss(modalSize.style);
    }
    modalElement.addCss(size.style);
    this.modalSize = size;
    return (T) this;
  }

  /**
   * @param type {@link org.dominokit.domino.ui.modals.IsModalDialog.ModalType}
   * @return same dialog instance
   */
  public T setType(ModalType type) {
    DominoElement<HTMLDivElement> modalElement = DominoElement.of(this.modalElement);
    if (nonNull(modalType)) {
      modalElement.removeCss(modalType.style);
    }
    modalElement.addCss(type.style);
    this.modalType = type;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setModalColor(Color color) {
    if (nonNull(this.color)) {
      modalElement.getModalContent().removeCss(this.color.getStyle());
    }
    modalElement.getModalContent().addCss(color.getStyle());
    this.color = color;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setAutoClose(boolean autoClose) {
    this.autoClose = autoClose;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T open() {
    if (isEnabled()) {
      removeCssProperty("z-index");
      if (autoAppendAndRemove) {
        element().remove();
        document.body.appendChild(element());
      }
      initFocusElements();
      activeElementBeforeOpen = DominoDom.document.activeElement;
      config().getZindexManager().onPopupOpen(this);
      if (nonNull(firstFocusElement) && isAutoFocus()) {
        firstFocusElement.focus();
        if (!Objects.equals(DominoDom.document.activeElement, firstFocusElement)) {
          if (nonNull(lastFocusElement)) {
            lastFocusElement.focus();
          }
        }
      }
      openHandlers.forEach(OpenHandler::onOpen);
      this.open = true;
      show();
    }
    return (T) this;
  }

  private void initFocusElements() {
    NodeList<Element> elementNodeList =
        element()
            .querySelectorAll(
                "a[href], area[href], input:not([disabled]), select:not([disabled]), textarea:not([disabled]), button:not([disabled]), [tabindex=\"0\"]");
    List<Element> elements = elementNodeList.asList();

    if (elements.size() > 0) {
      focusElements = elements;
      firstFocusElement = focusElements.get(0);
      lastFocusElement = elements.get(elements.size() - 1);
    } else {
      lastFocusElement = modalElement.modalContent.element();
    }
  }

  /** {@inheritDoc} */
  @Override
  public T close() {
    if (this.open && !isCollapsed()) {
      hide();
    } else {
      doClose();
    }
    ModalBackDrop.showHideBodyScrolls();
    return (T) this;
  }

  private void doClose() {
    if (nonNull(activeElementBeforeOpen)) {
      activeElementBeforeOpen.focus();
    }
    if (autoAppendAndRemove) {
      element().remove();
    }
    this.open = false;
    config().getZindexManager().onPopupClose(this);
    closeHandlers.forEach(CloseHandler::onClose);
  }

  /**
   * @return boolean
   * @see #setAutoClose(boolean)
   */
  public boolean isAutoClose() {
    return autoClose;
  }

  /** {@inheritDoc} */
  @Override
  public T hideFooter() {
    modalElement.getModalFooter().style().setDisplay("none");
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T showFooter() {
    modalElement.getModalFooter().style().setDisplay("block");
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T hideHeader() {
    modalElement.getModalHeader().hide();
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T showHeader() {
    modalElement.getModalHeader().show();
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T hideTitle() {
    modalElement.getModalTitle().hide();
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T showTitle() {
    modalElement.getModalTitle().show();
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setTitle(String title) {
    showHeader();
    headerText.textContent = title;
    getHeaderElement().clearElement();
    getHeaderElement().appendChild(headerText);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLDivElement> getDialogElement() {
    return DominoElement.of(modalElement.modalDialog);
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLDivElement> getContentElement() {
    return DominoElement.of(modalElement.modalContent);
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLHeadingElement> getHeaderElement() {
    return DominoElement.of(modalElement.modalTitle);
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLDivElement> getHeaderContainerElement() {
    return DominoElement.of(modalElement.modalHeader);
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLDivElement> getBodyElement() {
    return DominoElement.of(modalElement.modalBody);
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLDivElement> getFooterElement() {
    return DominoElement.of(modalElement.modalFooter);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return modalElement.element();
  }

  /** {@inheritDoc} */
  @Override
  public T addOpenListener(OpenHandler openHandler) {
    this.openHandlers.add(openHandler);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T addCloseListener(CloseHandler closeHandler) {
    this.closeHandlers.add(closeHandler);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T removeOpenHandler(OpenHandler openHandler) {
    this.openHandlers.remove(openHandler);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T removeCloseHandler(CloseHandler closeHandler) {
    this.closeHandlers.remove(closeHandler);
    return (T) this;
  }

  /** @return boolean, true if the modal is currently open */
  public boolean isOpen() {
    return open;
  }

  /** {@inheritDoc} */
  @Override
  public T enable() {
    this.disabled = false;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T disable() {
    this.disabled = true;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return !disabled;
  }

  /** {@inheritDoc} */
  @Override
  public T setAutoAppendAndRemove(boolean autoAppendAndRemove) {
    this.autoAppendAndRemove = autoAppendAndRemove;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T centerVertically() {
    modalElement.root.addCss(ModalStyles.CENTER);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T deCenterVertically() {
    modalElement.root.removeCss(ModalStyles.CENTER);
    return (T) this;
  }

  @Override
  public boolean isCenteredVertically() {
    return modalElement.root.containsCss(ModalStyles.CENTER);
  }

  /** {@inheritDoc} */
  @Override
  public boolean getAutoAppendAndRemove() {
    return this.autoAppendAndRemove;
  }

  /** @return boolean, true if this modal will show an overlay to block the content behind it. */
  public boolean isModal() {
    return modal;
  }

  /**
   * @param modal boolean,true to make this modal show an overlay to block the content behind it
   *     when it is open
   * @return same dialog instance
   */
  public T setModal(boolean modal) {
    this.modal = modal;
    return (T) this;
  }

  /** @return boolean, true if the modal should auto-focus first focusable element when opened. */
  public boolean isAutoFocus() {
    return autoFocus;
  }

  /**
   * @param autoFocus boolean, true if the modal should auto-focus first focusable element when
   *     opened.
   * @return same dialog instance
   */
  public T setAutoFocus(boolean autoFocus) {
    this.autoFocus = autoFocus;
    return (T) this;
  }

  @Override
  public T setWidth(String width) {
    super.setWidth(width);
    modalElement.setWidth(width);
    return (T) this;
  }

  @Override
  public T setWidth(String width, boolean important) {
    super.setWidth(width, important);
    modalElement.setWidth(width, important);
    return (T) this;
  }

  @Override
  public T setMaxWidth(String width) {
    super.setMaxWidth(width);
    modalElement.setMaxWidth(width);
    return (T) this;
  }

  @Override
  public T setMaxWidth(String width, boolean important) {
    super.setMaxWidth(width, important);
    modalElement.setMaxWidth(width, important);
    return (T) this;
  }

  @Override
  public T setMaxHeight(String height) {
    super.setMaxHeight(height);
    modalElement.setMaxHeight(height);
    return (T) this;
  }

  @Override
  public T setMaxHeight(String height, boolean important) {
    super.setMaxHeight(height, important);
    modalElement.setMaxHeight(height, important);
    return (T) this;
  }

  @Override
  public T setMinWidth(String width) {
    super.setMinWidth(width);
    modalElement.setMinWidth(width);
    return (T) this;
  }

  @Override
  public T setMinWidth(String width, boolean important) {
    super.setMinWidth(width, important);
    modalElement.setMinWidth(width, important);
    return (T) this;
  }

  @Override
  public T setMinHeight(String height) {
    super.setMinHeight(height);
    modalElement.setMinHeight(height);
    return (T) this;
  }

  @Override
  public T setMinHeight(String height, boolean important) {
    super.setMinHeight(height, important);
    modalElement.setMinHeight(height, important);
    return (T) this;
  }
}
