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
package org.dominokit.domino.ui.dialogs;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.ZIndexConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.i18n.DialogLabels;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.*;

/**
 * AbstractDialog class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class AbstractDialog<T extends AbstractDialog<T>>
    extends BaseDominoElement<HTMLDivElement, T>
    implements DialogStyles, IsPopup<T>, HasComponentConfig<ZIndexConfig> {
  protected final DivElement modalElement;
  protected LazyChild<DivElement> headerElement;
  protected LazyChild<Icon<?>> panelIcon = NullLazyChild.of();
  protected DivElement contentElement;
  protected DivElement bodyElement;
  protected LazyChild<DivElement> contentHeader;
  protected LazyChild<DivElement> contentFooter;
  protected DivElement element;
  private boolean autoClose = true;
  private Element firstFocusElement;
  private Element lastFocusElement;
  private Element activeElementBeforeOpen;
  private List<Element> focusElements = new ArrayList<>();
  private boolean open = false;
  private boolean modal = false;
  private boolean autoFocus = true;
  private boolean autoAppendAndRemove = true;

  private SwapCssClass stretchWidthCss = SwapCssClass.of(DialogSize.MEDIUM.getWidthStyle());
  private SwapCssClass stretchHeightCss = SwapCssClass.of(DialogSize.MEDIUM.getHeightStyle());
  private SwapCssClass dialogType = SwapCssClass.of(DialogType.DEFAULT.style);

  private Transition openTransition = Transition.FADE_IN;
  private Transition closeTransition = Transition.FADE_OUT;
  private int transitionDuration = 100;
  private boolean animate = true;

  private Animation openAnimation;
  private Animation closeAnimation;

  protected DialogLabels labels = DominoUIConfig.CONFIG.getDominoUILabels();

  /** Constructor for AbstractDialog. */
  public AbstractDialog() {
    element =
        div()
            .addCss(dui_modal_box, dui_hidden)
            .appendChild(
                modalElement =
                    div()
                        .addCss(dui_modal)
                        .appendChild(
                            contentElement =
                                div()
                                    .addCss(dui_dialog_content)
                                    .appendChild(bodyElement = div().addCss(dui_dialog_body))));
    init((T) this);

    headerElement =
        LazyChild.of(div().addCss(dui_dialog_header).setAttribute("role", "tab"), modalElement);

    contentHeader = LazyChild.of(div().addCss(dui_dialog_content_header), contentElement);
    contentFooter = LazyChild.of(div().addCss(dui_dialog_footer), contentElement);
    setStretchWidth(DialogSize.MEDIUM);
    setStretchHeight(DialogSize.MEDIUM);
    addTabIndexHandler();

    openAnimation = Animation.create(element);
    closeAnimation = Animation.create(element);

    modalElement.addClickListener(Event::stopPropagation);

    modalElement.addClickListener(
        evt -> {
          evt.stopPropagation();
          PopupsCloser.close();
        });
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
                    initFocusElements(element());
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

  /**
   * Getter for the field <code>openTransition</code>.
   *
   * @return a {@link org.dominokit.domino.ui.animations.Transition} object
   */
  public Transition getOpenTransition() {
    return openTransition;
  }

  /**
   * Setter for the field <code>openTransition</code>.
   *
   * @param openTransition a {@link org.dominokit.domino.ui.animations.Transition} object
   * @return a T object
   */
  public T setOpenTransition(Transition openTransition) {
    this.openTransition = openTransition;
    return (T) this;
  }

  /**
   * Getter for the field <code>closeTransition</code>.
   *
   * @return a {@link org.dominokit.domino.ui.animations.Transition} object
   */
  public Transition getCloseTransition() {
    return closeTransition;
  }

  /**
   * Setter for the field <code>closeTransition</code>.
   *
   * @param closeTransition a {@link org.dominokit.domino.ui.animations.Transition} object
   * @return a T object
   */
  public T setCloseTransition(Transition closeTransition) {
    this.closeTransition = closeTransition;
    return (T) this;
  }

  /**
   * Getter for the field <code>transitionDuration</code>.
   *
   * @return a int
   */
  public int getTransitionDuration() {
    return transitionDuration;
  }

  /**
   * Setter for the field <code>transitionDuration</code>.
   *
   * @param transitionDuration a int
   * @return a T object
   */
  public T setTransitionDuration(int transitionDuration) {
    this.transitionDuration = transitionDuration;
    return (T) this;
  }

  /**
   * isAnimate.
   *
   * @return a boolean
   */
  public boolean isAnimate() {
    return animate;
  }

  /**
   * Setter for the field <code>animate</code>.
   *
   * @param animate a boolean
   * @return a T object
   */
  public T setAnimate(boolean animate) {
    this.animate = animate;
    return (T) this;
  }

  /**
   * {@inheritDoc}
   *
   * @param autoClose a boolean
   * @return a T object
   */
  public T setAutoClose(boolean autoClose) {
    this.autoClose = autoClose;
    return (T) this;
  }

  /**
   * {@inheritDoc}
   *
   * @param autoAppendAndRemove a boolean
   * @return a T object
   */
  public T setAutoAppendAndRemove(boolean autoAppendAndRemove) {
    this.autoAppendAndRemove = autoAppendAndRemove;
    return (T) this;
  }

  /**
   * {@inheritDoc}
   *
   * @return a T object
   */
  public T open() {
    if (isEnabled()) {
      if (animate) {
        openAnimation
            .transition(openTransition)
            .duration(transitionDuration)
            .beforeStart(element -> doOpen())
            .animate();
      } else {
        doOpen();
      }
    }
    return (T) this;
  }

  private void doOpen() {
    element.removeCssProperty("z-index");
    if (autoAppendAndRemove) {
      element().remove();
      document.body.appendChild(element());
    }
    initFocusElements(contentElement.element());
    activeElementBeforeOpen = DominoDom.document.activeElement;
    getConfig().getZindexManager().onPopupOpen(this);
    element.removeCss(dui_hidden);
    if (nonNull(firstFocusElement) && isAutoFocus()) {
      firstFocusElement.focus();
      if (!Objects.equals(DominoDom.document.activeElement, firstFocusElement)) {
        if (nonNull(lastFocusElement)) {
          lastFocusElement.focus();
        }
      }
    }
    triggerExpandListeners((T) this);
    this.open = true;
  }

  private void initFocusElements(HTMLElement element) {
    NodeList<Element> elementNodeList =
        element.querySelectorAll(
            "a[href], area[href], input:not([disabled]), select:not([disabled]), textarea:not([disabled]), button:not([disabled]), [tabindex=\"0\"]");
    List<Element> elements = elementNodeList.asList();

    if (elements.size() > 0) {
      focusElements = elements;
      firstFocusElement = focusElements.get(0);
      lastFocusElement = elements.get(elements.size() - 1);
    } else {
      lastFocusElement = contentElement.element();
    }
  }

  /**
   * {@inheritDoc}
   *
   * @return a T object
   */
  public T close() {
    if (this.open) {
      if (animate) {
        closeAnimation
            .transition(closeTransition)
            .duration(transitionDuration)
            .callback(element -> doClose())
            .animate();
      } else {
        doClose();
      }
    }
    return (T) this;
  }

  private void doClose() {
    element.addCss(dui_hidden);
    if (nonNull(activeElementBeforeOpen)) {
      activeElementBeforeOpen.focus();
    }
    if (autoAppendAndRemove) {
      element.remove();
    }
    this.open = false;
    getConfig().getZindexManager().onPopupClose(this);
    triggerCollapseListeners((T) this);
  }

  /**
   * isAutoClose.
   *
   * @return boolean
   * @see #setAutoClose(boolean)
   */
  public boolean isAutoClose() {
    return autoClose;
  }

  /**
   * setStretchWidth.
   *
   * @param size {@link org.dominokit.domino.ui.dialogs.DialogSize}
   * @return same Dialog instance
   */
  public T setStretchWidth(IsDialogWidth size) {
    addCss(stretchWidthCss.replaceWith(size.getWidthStyle()));
    return (T) this;
  }

  /**
   * setStretchHeight.
   *
   * @param size {@link org.dominokit.domino.ui.dialogs.DialogSize}
   * @return same Dialog instance
   */
  public T setStretchHeight(IsDialogHeight size) {
    addCss(stretchHeightCss.replaceWith(size.getHeightStyle()));
    return (T) this;
  }

  /**
   * setType.
   *
   * @param type {@link org.dominokit.domino.ui.dialogs.DialogType}
   * @return same Dialog instance
   */
  public T setType(DialogType type) {
    addCss(dialogType.replaceWith(type.style));
    return (T) this;
  }

  /** @return boolean, true if this modal will show an overlay to block the content behind it. */
  /**
   * isModal.
   *
   * @return a boolean
   */
  public boolean isModal() {
    return modal;
  }

  /**
   * Setter for the field <code>modal</code>.
   *
   * @param modal boolean,true to make this modal show an overlay to block the content behind it
   *     when it is open
   * @return same dialog instance
   */
  public T setModal(boolean modal) {
    this.modal = modal;
    return (T) this;
  }

  /** @return boolean, true if the modal should auto-focus first focusable element when opened. */
  /**
   * isAutoFocus.
   *
   * @return a boolean
   */
  public boolean isAutoFocus() {
    return autoFocus;
  }

  /**
   * Setter for the field <code>autoFocus</code>.
   *
   * @param autoFocus boolean, true if the modal should auto-focus first focusable element when
   *     opened.
   * @return same dialog instance
   */
  public T setAutoFocus(boolean autoFocus) {
    this.autoFocus = autoFocus;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement getAppendTarget() {
    return bodyElement.element();
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLElement getStyleTarget() {
    return modalElement.element();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /**
   * appendChild.
   *
   * @param element a {@link org.dominokit.domino.ui.utils.HeaderContent} object
   * @return a T object
   */
  public T appendChild(HeaderContent<?> element) {
    contentHeader.get().appendChild(element);
    return (T) this;
  }

  /**
   * appendChild.
   *
   * @param element a {@link org.dominokit.domino.ui.utils.FooterContent} object
   * @return a T object
   */
  public T appendChild(FooterContent<?> element) {
    contentFooter.get().appendChild(element);
    return (T) this;
  }

  /**
   * withHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a T object
   */
  public T withHeader(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, headerElement.get());
    return (T) this;
  }

  /**
   * getHeader.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getHeader() {
    return headerElement.get();
  }

  /**
   * setIcon.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a T object
   */
  public T setIcon(Icon<?> icon) {
    panelIcon.remove();
    panelIcon = LazyChild.of(icon.addCss(dui_dialog_icon), headerElement);
    panelIcon.get();
    return (T) this;
  }

  /**
   * withIcon.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a T object
   */
  public T withIcon(Icon<?> icon) {
    return setIcon(icon);
  }

  /**
   * getContentBody.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getContentBody() {
    return bodyElement;
  }

  /**
   * withContentBody.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a T object
   */
  public T withContentBody(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, bodyElement);
    return (T) this;
  }

  /**
   * Getter for the field <code>contentElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getContentElement() {
    return contentElement;
  }

  /**
   * withContentElement.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a T object
   */
  public T withContentElement(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, contentElement);
    return (T) this;
  }

  /**
   * Getter for the field <code>contentHeader</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getContentHeader() {
    return contentHeader.get();
  }

  /**
   * withContentHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a T object
   */
  public T withContentHeader(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, contentHeader.get());
    return (T) this;
  }

  /**
   * withContentHeader.
   *
   * @return a T object
   */
  public T withContentHeader() {
    contentHeader.get();
    return (T) this;
  }

  /**
   * Getter for the field <code>contentFooter</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getContentFooter() {
    return contentFooter.get();
  }

  /**
   * withContentFooter.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a T object
   */
  public T withContentFooter(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, contentFooter.get());
    return (T) this;
  }

  /**
   * withContentFooter.
   *
   * @return a T object
   */
  public T withContentFooter() {
    contentFooter.get();
    return (T) this;
  }

  /** A function to implement a listener to be called when open the dialog */
  @FunctionalInterface
  public interface OpenHandler {
    void onOpen();
  }

  /** An interface to implement handlers for closing a dialog */
  @FunctionalInterface
  public interface CloseHandler {
    /** Will be called when the dialog is closed */
    void onClose();
  }
}
