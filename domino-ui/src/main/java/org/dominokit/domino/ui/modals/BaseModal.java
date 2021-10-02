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
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoDom;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.Switchable;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

/**
 * A base implementaton for components to show a pop-up
 *
 * @param <T> the type of the component extending from this class
 */
public abstract class BaseModal<T extends IsElement<HTMLDivElement>>
    extends BaseDominoElement<HTMLDivElement, T> implements IsModalDialog<T>, Switchable<T> {

  private List<OpenHandler> openHandlers = new ArrayList<>();
  private List<CloseHandler> closeHandlers = new ArrayList<>();
  static int Z_INDEX = 1040;

  /** a component that contains the modal elements */
  public static class Modal implements IsElement<HTMLDivElement> {

    private final HTMLDivElement root;
    private final HTMLDivElement modalDialog;
    private final HTMLDivElement modalHeader;
    private final HTMLHeadingElement modalTitle;
    private final HTMLDivElement modalBody;
    private final HTMLDivElement modalContent;
    private final HTMLDivElement modalFooter;

    /** */
    public Modal() {
      this.root =
          div()
              .css("modal", "fade")
              .apply(e -> e.tabIndex = -1)
              .attr("role", "dialog")
              .add(
                  modalDialog =
                      div()
                          .css("modal-dialog")
                          .apply(e -> e.tabIndex = -1)
                          .attr("role", "document")
                          .add(
                              modalContent =
                                  div()
                                      .css("modal-content")
                                      .add(
                                          modalHeader =
                                              div()
                                                  .css("modal-header")
                                                  .add(
                                                      modalTitle =
                                                          h(4).css("modal-title").element())
                                                  .element())
                                      .add(modalBody = div().css("modal-body").element())
                                      .add(modalFooter = div().css("modal-footer").element())
                                      .element())
                          .element())
              .element();
      setVisible(root, false);
    }

    /** {@inheritDoc} */
    @Override
    public HTMLDivElement element() {
      return root;
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
     * @return the {@link HTMLDivElement} that contains the the header and the body wrapped as
     *     {@link DominoElement}
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
  private Text headerText = DomGlobal.document.createTextNode("");
  private boolean open = false;
  private boolean disabled = false;
  private boolean autoAppendAndRemove = true;
  private boolean modal = true;

  public BaseModal() {
    modalElement = new Modal();
    modalElement.getModalHeader().hide();
    modalElement.getModalTitle().appendChild(headerText);

    addTabIndexHandler();
  }

  /** @param title String modal header title */
  public BaseModal(String title) {
    this();
    showHeader();
    modalElement.modalTitle.textContent = title;
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
      addBackdrop();
      style().addCss(ModalStyles.IN);
      style().setDisplay("block");
      if (nonNull(firstFocusElement)) {
        firstFocusElement.focus();
        if (!Objects.equals(DominoDom.document.activeElement, firstFocusElement)) {
          if (nonNull(lastFocusElement)) {
            lastFocusElement.focus();
          }
        }
      }
      openHandlers.forEach(OpenHandler::onOpen);
      this.open = true;
      ModalBackDrop.push(this);
    }
    return (T) this;
  }

  private void addBackdrop() {
    if (modal) {
      if (ModalBackDrop.openedModalsCount() <= 0
          || !DominoElement.of(ModalBackDrop.INSTANCE).isAttached()) {
        document.body.appendChild(ModalBackDrop.INSTANCE);
        DominoElement.of(document.body).addCss(ModalStyles.MODAL_OPEN);
      } else {
        Z_INDEX = Z_INDEX + 10;
        ModalBackDrop.INSTANCE.style.setProperty("z-index", Z_INDEX + "");
        element().style.setProperty("z-index", (Z_INDEX + 10) + "");
      }
    }
  }

  private void removeBackDrop() {
    if (modal) {
      if (ModalBackDrop.openedModalsCount() < 1 || ModalBackDrop.allOpenedNotModals()) {
        ModalBackDrop.INSTANCE.remove();
        DominoElement.of(document.body).removeCss(ModalStyles.MODAL_OPEN);
      } else {
        Z_INDEX = Z_INDEX - 10;
        ModalBackDrop.INSTANCE.style.setProperty("z-index", Z_INDEX + "");
        element().style.setProperty("z-index", (Z_INDEX + 10) + "");
      }
    }
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
      lastFocusElement = modalElement.modalContent;
    }
  }

  /** {@inheritDoc} */
  @Override
  public T close() {
    if (this.open) {
      element().classList.remove(ModalStyles.IN);
      element().style.display = "none";
      if (nonNull(activeElementBeforeOpen)) {
        activeElementBeforeOpen.focus();
      }
      if (autoAppendAndRemove) {
        element().remove();
      }
      this.open = false;
      if (ModalBackDrop.contains(this)) {
        ModalBackDrop.popModal(this);
      }
      removeBackDrop();
      closeHandlers.forEach(CloseHandler::onClose);
    }
    return (T) this;
  }

  /**
   * @see #setAutoClose(boolean)
   * @return boolean
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
    Style.of(modalElement.modalDialog).addCss(Styles.vertical_center);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T deCenterVertically() {
    Style.of(modalElement.modalDialog).removeCss(Styles.vertical_center);
    return (T) this;
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
}
