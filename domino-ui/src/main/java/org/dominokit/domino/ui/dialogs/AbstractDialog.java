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
import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.DisplayCss.dui_hidden;
import static org.dominokit.domino.ui.utils.Domino.div;

import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.KeyboardEvent;
import elemental2.dom.NodeList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.ZIndexConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.i18n.DialogLabels;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoDom;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.HeaderContent;
import org.dominokit.domino.ui.utils.IsPopup;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.NullLazyChild;
import org.dominokit.domino.ui.utils.PopupsCloser;
import org.dominokit.domino.ui.utils.Unit;

/**
 * The AbstractDialog class is the base class for creating dialog boxes in the Domino-UI framework.
 * It provides various customization options and utility methods for creating and managing dialog
 * boxes.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * AbstractDialog dialog = new AbstractDialog()
 *     .setTitle("Example Dialog")
 *     .appendChild(new Text("This is a sample dialog box."))
 *     .setAutoClose(true)
 *     .open();
 * </pre>
 *
 * @param <T> The concrete subclass of the <b>AbstractDialog</b>.
 * @see DialogStyles
 * @see IsPopup
 * @see HasComponentConfig
 * @see DialogLabels
 * @see Transition
 * @see ZIndexConfig
 * @see BaseDominoElement
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
  private Element defaultFocusElement;
  private Element activeElementBeforeOpen;
  private List<Element> focusElements = new ArrayList<>();
  private boolean open = false;
  private boolean modal = false;
  private boolean autoFocus = true;
  private boolean autoAppendAndRemove = true;

  private SwapCssClass stretchWidthCss = SwapCssClass.of(DialogSize.MEDIUM.getWidthStyle());
  private SwapCssClass stretchHeightCss = SwapCssClass.of(DialogSize.MEDIUM.getHeightStyle());

  private Transition openTransition = Transition.FADE_IN;
  private Transition closeTransition = Transition.FADE_OUT;
  private int transitionDuration = 100;
  private boolean animate = true;

  private Animation openAnimation;
  private Animation closeAnimation;

  protected DialogLabels labels = DominoUIConfig.CONFIG.getDominoUILabels();

  /** Constructs a new instance of {@code AbstractDialog}. */
  public AbstractDialog() {
    element =
        div()
            .setZIndexLayer(ZIndexLayer.Z_LAYER_3)
            .addCss(dui_modal_box, dui_hidden)
            .appendChild(
                modalElement =
                    div()
                        .addCss(dui_dialog)
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

    modalElement.addClickListener(
        evt -> {
          evt.stopPropagation();
          ModalBackDrop.INSTANCE.closePopovers("");
          PopupsCloser.close();
        });
  }

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
   * Gets the transition used when opening the dialog.
   *
   * @return The open transition.
   */
  public Transition getOpenTransition() {
    return openTransition;
  }

  /**
   * Sets the transition used when opening the dialog.
   *
   * @param openTransition The open transition to set.
   * @return This dialog instance for method chaining.
   */
  public T setOpenTransition(Transition openTransition) {
    this.openTransition = openTransition;
    return (T) this;
  }

  /**
   * Gets the transition used when closing the dialog.
   *
   * @return The close transition.
   */
  public Transition getCloseTransition() {
    return closeTransition;
  }

  /**
   * Sets the transition used when closing the dialog.
   *
   * @param closeTransition The close transition to set.
   * @return This dialog instance for method chaining.
   */
  public T setCloseTransition(Transition closeTransition) {
    this.closeTransition = closeTransition;
    return (T) this;
  }

  /**
   * Gets the duration of the open/close animation transition in milliseconds.
   *
   * @return The transition duration in milliseconds.
   */
  public int getTransitionDuration() {
    return transitionDuration;
  }

  /**
   * Sets the duration of the open/close animation transition in milliseconds.
   *
   * @param transitionDuration The transition duration in milliseconds to set.
   * @return This dialog instance for method chaining.
   */
  public T setTransitionDuration(int transitionDuration) {
    this.transitionDuration = transitionDuration;
    return (T) this;
  }

  /**
   * Checks if animations are enabled for opening and closing the dialog.
   *
   * @return {@code true} if animations are enabled, {@code false} otherwise.
   */
  public boolean isAnimate() {
    return animate;
  }

  /**
   * Enables or disables animations for opening and closing the dialog.
   *
   * @param animate {@code true} to enable animations, {@code false} to disable.
   * @return This dialog instance for method chaining.
   */
  public T setAnimate(boolean animate) {
    this.animate = animate;
    return (T) this;
  }

  /**
   * Enables or disables the automatic closing of the dialog when clicking outside of it.
   *
   * @param autoClose {@code true} to enable auto-closing, {@code false} to disable.
   * @return This dialog instance for method chaining.
   */
  public T setAutoClose(boolean autoClose) {
    this.autoClose = autoClose;
    return (T) this;
  }

  /**
   * Enables or disables the automatic appending and removing of the dialog element to/from the
   * document body.
   *
   * @param autoAppendAndRemove {@code true} to enable auto-append and auto-remove, {@code false} to
   *     disable.
   * @return This dialog instance for method chaining.
   */
  public T setAutoAppendAndRemove(boolean autoAppendAndRemove) {
    this.autoAppendAndRemove = autoAppendAndRemove;
    return (T) this;
  }

  /**
   * Opens the dialog box, making it visible to the user.
   *
   * @return This dialog instance for method chaining.
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
    element.setCssProperty("top", Unit.px.of(window.pageYOffset));
    if (autoAppendAndRemove) {
      element().remove();
      document.body.appendChild(element());
    }
    initFocusElements(contentElement.element());
    activeElementBeforeOpen = DominoDom.document.activeElement;
    getConfig().getZindexManager().onPopupOpen(this);
    element.removeCss(dui_hidden);
    updateFocus();
    triggerOpenListeners((T) this);
    this.open = true;
  }

  private void updateFocus() {
    if (isAutoFocus()) {
      if (nonNull(getDefaultFocusElement())) {
        getDefaultFocusElement().focus();
        if (!Objects.equals(DominoDom.document.activeElement, getDefaultFocusElement())) {
          findAndFocus();
        }
      } else {
        findAndFocus();
      }
    }
  }

  private void findAndFocus() {
    if (nonNull(firstFocusElement)) {
      firstFocusElement.focus();
      if (!Objects.equals(DominoDom.document.activeElement, firstFocusElement)) {
        if (nonNull(lastFocusElement)) {
          lastFocusElement.focus();
        }
      }
    }
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
   * Closes the dialog box, making it invisible to the user.
   *
   * @return This dialog instance for method chaining.
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
    triggerCloseListeners((T) this);
  }

  /**
   * Checks if the dialog is set to automatically close when clicking outside of it.
   *
   * @return {@code true} if auto-close is enabled, {@code false} otherwise.
   */
  public boolean isAutoClose() {
    return autoClose;
  }

  /**
   * Sets the width of the dialog to stretch according to the specified size.
   *
   * @param size The dialog width size.
   * @return This dialog instance for method chaining.
   */
  public T setStretchWidth(IsDialogWidth size) {
    addCss(stretchWidthCss.replaceWith(size.getWidthStyle()));
    return (T) this;
  }

  /**
   * Sets the height of the dialog to stretch according to the specified size.
   *
   * @param size The dialog height size.
   * @return This dialog instance for method chaining.
   */
  public T setStretchHeight(IsDialogHeight size) {
    addCss(stretchHeightCss.replaceWith(size.getHeightStyle()));
    return (T) this;
  }

  /**
   * @dominokit-site-ignore
   * @deprecated use {@link #addCss(org.dominokit.domino.ui.style.CssClass...)} with {@link
   *     DialogType} or the styles from {@link DialogStyles} setType.
   * @param type {@link org.dominokit.domino.ui.dialogs.DialogType}
   * @return same Dialog instance
   */
  @Deprecated
  public T setType(DialogType type) {
    addCss(type);
    return (T) this;
  }

  /**
   * Checks if the dialog is modal, i.e., if it blocks interactions with the rest of the page.
   *
   * @return {@code true} if the dialog is modal, {@code false} otherwise.
   */
  public boolean isModal() {
    return modal;
  }

  /**
   * Sets whether the dialog should be modal, blocking interactions with the rest of the page.
   *
   * @param modal {@code true} to make the dialog modal, {@code false} otherwise.
   * @return This dialog instance for method chaining.
   */
  public T setModal(boolean modal) {
    this.modal = modal;
    return (T) this;
  }

  /**
   * Checks if the dialog is set to automatically focus on the first focusable element when opened.
   *
   * @return {@code true} if auto-focus is enabled, {@code false} otherwise.
   */
  public boolean isAutoFocus() {
    return autoFocus;
  }

  /**
   * Sets whether the dialog should automatically focus on the first focusable element when opened.
   *
   * @param autoFocus {@code true} to enable auto-focus, {@code false} to disable.
   * @return This dialog instance for method chaining.
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
   * Appends a child element to the dialog's header.
   *
   * @param element The child element to append.
   * @return This dialog instance for method chaining.
   */
  public T appendChild(HeaderContent<?> element) {
    contentHeader.get().appendChild(element);
    return (T) this;
  }

  public T appendChild(HeaderContent<?>... elements) {
    Arrays.stream(elements).forEach(this::appendChild);
    return (T) this;
  }

  /**
   * Appends a child element to the dialog's footer.
   *
   * @param element The child element to append.
   * @return This dialog instance for method chaining.
   */
  public T appendChild(FooterContent<?> element) {
    contentFooter.get().appendChild(element);
    return (T) this;
  }

  public T appendChild(FooterContent<?>... elements) {
    Arrays.stream(elements).forEach(this::appendChild);
    return (T) this;
  }

  /**
   * Gets the modal element of the dialog, which is the overlay behind the content.
   *
   * @return The modal element.
   */
  public DivElement getModalElement() {
    return modalElement;
  }

  /**
   * Allows customization of the dialog's header using a {@code ChildHandler}.
   *
   * @param handler The handler for customizing the header.
   * @return This dialog instance for method chaining.
   */
  public T withHeader(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, headerElement.get());
    return (T) this;
  }

  /**
   * Gets the header element of the dialog.
   *
   * @return The header element.
   */
  public DivElement getHeader() {
    return headerElement.get();
  }

  /**
   * Sets the icon for the dialog panel.
   *
   * @param icon The icon to set.
   * @return This dialog instance for method chaining.
   */
  public T setIcon(Icon<?> icon) {
    panelIcon.remove();
    panelIcon = LazyChild.of(icon.addCss(dui_dialog_icon), headerElement);
    panelIcon.get();
    return (T) this;
  }

  /**
   * Allows customization of the dialog's content body using a {@code ChildHandler}.
   *
   * @param handler The handler for customizing the content body.
   * @return This dialog instance for method chaining.
   */
  public T withContentBody(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, bodyElement);
    return (T) this;
  }

  /**
   * Gets the body element of the dialog.
   *
   * @return The body element.
   */
  public DivElement getContentBody() {
    return bodyElement;
  }

  /**
   * Allows customization of the dialog's content element using a {@code ChildHandler}.
   *
   * @param handler The handler for customizing the content element.
   * @return This dialog instance for method chaining.
   */
  public T withContentElement(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, contentElement);
    return (T) this;
  }

  /**
   * Gets the content element of the dialog.
   *
   * @return The content element.
   */
  public DivElement getContentElement() {
    return contentElement;
  }

  /**
   * Allows customization of the dialog's content header using a {@code ChildHandler}.
   *
   * @param handler The handler for customizing the content header.
   * @return This dialog instance for method chaining.
   */
  public T withContentHeader(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, contentHeader.get());
    return (T) this;
  }

  /**
   * Gets the content header element of the dialog.
   *
   * @return The content header element.
   */
  public DivElement getContentHeader() {
    return contentHeader.get();
  }

  /**
   * Allows customization of the dialog's content footer using a {@code ChildHandler}.
   *
   * @param handler The handler for customizing the content footer.
   * @return This dialog instance for method chaining.
   */
  public T withContentFooter(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, contentFooter.get());
    return (T) this;
  }

  /**
   * Gets the content footer element of the dialog.
   *
   * @return The content footer element.
   */
  public DivElement getContentFooter() {
    return contentFooter.get();
  }

  /**
   * Gets the default element to focus on when the dialog is opened.
   *
   * @return The default focus element.
   */
  public Element getDefaultFocusElement() {
    return defaultFocusElement;
  }

  /**
   * Sets the default element to focus on when the dialog is opened.
   *
   * @param defaultFocusElement The default focus element to set.
   * @return This dialog instance for method chaining.
   */
  public T setDefaultFocusElement(Element defaultFocusElement) {
    this.defaultFocusElement = defaultFocusElement;
    return (T) this;
  }

  /**
   * Sets the default element to focus on when the dialog is opened.
   *
   * @param defaultFocusElement The default focus element to set.
   * @return This dialog instance for method chaining.
   */
  public T setDefaultFocusElement(IsElement<?> defaultFocusElement) {
    this.defaultFocusElement = defaultFocusElement.element();
    return (T) this;
  }

  @Override
  public void resetZIndexLayer() {
    // Dialogs should never rest their base layer.;
  }

  /**
   * Checks if the dialog is currently open.
   *
   * @return {@code true} if the dialog is open, {@code false} otherwise.
   */
  public boolean isOpen() {
    return this.open;
  }

  @Override
  public boolean incrementsZIndex() {
    return true;
  }

  /** A functional interface for handling dialog open events. */
  @FunctionalInterface
  public interface OpenHandler {
    /** Handles the dialog open event. */
    void onOpen();
  }

  /** A functional interface for handling dialog close events. */
  @FunctionalInterface
  public interface CloseHandler {
    /** Handles the dialog close event. */
    void onClose();
  }
}
