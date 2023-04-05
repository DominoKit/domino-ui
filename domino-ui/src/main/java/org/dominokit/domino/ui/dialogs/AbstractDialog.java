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
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.i18n.DialogLabels;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.*;
import org.dominokit.domino.ui.events.EventType;

public class AbstractDialog<T extends AbstractDialog<T>>
    extends BaseDominoElement<HTMLDivElement, T> implements DialogStyles, IsPopup<T>, HasComponentConfig<ZIndexConfig> {
  protected final DivElement modalElement;
  protected LazyChild<DivElement> headerElement;
  protected LazyChild<SpanElement> titleElement;
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
  private boolean modal = true;
  private boolean autoFocus = true;
  private boolean autoAppendAndRemove = true;
  static int Z_INDEX = 1040;

  private SwapCssClass stretchWidthCss = SwapCssClass.of(DialogSize.MEDIUM.widthStyle);
  private SwapCssClass stretchHeightCss = SwapCssClass.of(DialogSize.MEDIUM.heightStyle);
  private SwapCssClass dialogType = SwapCssClass.of(DialogType.DEFAULT.style);

  private Transition openTransition = Transition.FADE_IN;
  private Transition closeTransition = Transition.FADE_OUT;
  private int transitionDuration = 500;

  private boolean animate = true;

  private Animation openAnimation;
  private Animation closeAnimation;

  protected DialogLabels labels = DominoUIConfig.CONFIG.getDominoUILabels();

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
                                    .appendChild(
                                        bodyElement =
                                            div().addCss(dui_dialog_body))));
    init((T) this);

    headerElement =
        LazyChild.of(
            div().addCss(dui_dialog_header).setAttribute("role", "tab"),
            modalElement);

    titleElement = LazyChild.of(span().addCss(dui_dialog_title), headerElement);
    contentHeader =
        LazyChild.of(div().addCss(dui_dialog_content_header), contentElement);
    contentFooter = LazyChild.of(div().addCss(dui_dialog_footer), contentElement);
    setStretchWidth(DialogSize.MEDIUM);
    setStretchHeight(DialogSize.MEDIUM);
    addTabIndexHandler();

    openAnimation = Animation.create(element);
    closeAnimation = Animation.create(element);

    modalElement.addClickListener(Event::stopPropagation);

    element.addClickListener(
        evt -> {
          evt.stopPropagation();
          if (isAutoClose()) {
            close();
          }
        });
  }

  public AbstractDialog(String title) {
    this();
    setTitle(title);
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

  public Transition getOpenTransition() {
    return openTransition;
  }

  public T setOpenTransition(Transition openTransition) {
    this.openTransition = openTransition;
    return (T) this;
  }

  public Transition getCloseTransition() {
    return closeTransition;
  }

  public T setCloseTransition(Transition closeTransition) {
    this.closeTransition = closeTransition;
    return (T) this;
  }

  public int getTransitionDuration() {
    return transitionDuration;
  }

  public T setTransitionDuration(int transitionDuration) {
    this.transitionDuration = transitionDuration;
    return (T) this;
  }

  public boolean isAnimate() {
    return animate;
  }

  public T setAnimate(boolean animate) {
    this.animate = animate;
    return (T) this;
  }

  /** {@inheritDoc} */
  public T setAutoClose(boolean autoClose) {
    this.autoClose = autoClose;
    return (T) this;
  }

  /** {@inheritDoc} */
  public T setAutoAppendAndRemove(boolean autoAppendAndRemove) {
    this.autoAppendAndRemove = autoAppendAndRemove;
    return (T) this;
  }

  /** {@inheritDoc} */
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
    initFocusElements();
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
    triggerExpandListeners((T)this);
    this.open = true;
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
      lastFocusElement = contentElement.element();
    }
  }

  /** {@inheritDoc} */
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
    triggerCollapseListeners((T)this);
  }

  /**
   * @return boolean
   * @see #setAutoClose(boolean)
   */
  public boolean isAutoClose() {
    return autoClose;
  }

  /**
   * @param size {@link DialogSize}
   * @return same Dialog instance
   */
  public T setStretchWidth(DialogSize size) {
    addCss(stretchWidthCss.replaceWith(size.widthStyle));
    return (T) this;
  }

  /**
   * @param size {@link DialogSize}
   * @return same Dialog instance
   */
  public T setStretchHeight(DialogSize size) {
    addCss(stretchHeightCss.replaceWith(size.heightStyle));
    return (T) this;
  }

  /**
   * @param type {@link DialogType}
   * @return same Dialog instance
   */
  public T setType(DialogType type) {
    addCss(dialogType.replaceWith(type.style));
    return (T) this;
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
  protected HTMLElement getAppendTarget() {
    return bodyElement.element();
  }

  @Override
  protected HTMLElement getStyleTarget() {
    return modalElement.element();
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  public T appendChild(PostfixAddOn<?> element) {
    headerElement.get().appendChild(element.addCss(dui_dialog_utility));
    return (T) this;
  }

  public T appendChild(Header<?> element) {
    contentHeader.get().appendChild(element);
    return (T) this;
  }

  public T appendChild(Footer<?> element) {
    contentFooter.get().appendChild(element);
    return (T) this;
  }

  /**
   * Change the panel header title.
   *
   * @param title String, the accordion panel header title
   * @return same AccordionPanel instance
   */
  public T setTitle(String title) {
    titleElement.get().setTextContent(title);
    return (T) this;
  }

  /**
   * Change the panel header title.
   *
   * @param title String, the accordion panel header title
   * @return same AccordionPanel instance
   */
  public T withTitle(String title) {
    return setTitle(title);
  }

  public T withTitleElement(ChildHandler<T, SpanElement> handler) {
    handler.apply((T) this, titleElement.get());
    return (T) this;
  }

  public SpanElement getTitleElement() {
    return titleElement.get();
  }

  public T withHeaderElement(ChildHandler<T,  DivElement> handler) {
    handler.apply((T) this, headerElement.get());
    return (T) this;
  }

  public  DivElement getHeaderElement() {
    return headerElement.get();
  }

  public T setIcon(Icon<?> icon) {
    panelIcon.remove();
    panelIcon = LazyChild.of(icon.addCss(dui_dialog_icon), headerElement);
    panelIcon.get();
    return (T) this;
  }

  public T withIcon(Icon<?> icon) {
    return setIcon(icon);
  }

  public  DivElement getContentBody() {
    return bodyElement;
  }

  public T withContentBody(ChildHandler<T,  DivElement> handler) {
    handler.apply((T) this, bodyElement);
    return (T) this;
  }

  public  DivElement getContentElement() {
    return contentElement;
  }

  public T withContentElement(ChildHandler<T,  DivElement> handler) {
    handler.apply((T) this, contentElement);
    return (T) this;
  }

  public  DivElement getContentHeader() {
    return contentHeader.get();
  }

  public T withContentHeader(ChildHandler<T,  DivElement> handler) {
    handler.apply((T) this, contentHeader.get());
    return (T) this;
  }

  public T withContentHeader() {
    contentHeader.get();
    return (T) this;
  }

  public  DivElement getContentFooter() {
    return contentFooter.get();
  }

  public T withContentFooter(ChildHandler<T,  DivElement> handler) {
    handler.apply((T) this, contentFooter.get());
    return (T) this;
  }

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
