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
package org.dominokit.domino.ui.button;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.button.ButtonStyles.dui_button;
import static org.dominokit.domino.ui.button.ButtonStyles.dui_button_body;
import static org.dominokit.domino.ui.button.ButtonStyles.dui_button_icon;
import static org.dominokit.domino.ui.button.ButtonStyles.dui_button_reversed;
import static org.dominokit.domino.ui.button.ButtonStyles.dui_button_text;

import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.BaseElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.WaveStyle;
import org.dominokit.domino.ui.style.WavesElement;
import org.dominokit.domino.ui.utils.AcceptDisable;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A base component to implement buttons
 *
 * <p>this class provides commons functionality and methods used in different implementations of a
 * button
 *
 * @param <B> The button subclass being wrapped
 */
public abstract class BaseButton<E extends HTMLElement, B extends BaseButton<E, B>>
    extends WavesElement<HTMLElement, B>
    implements HasClickableElement, AcceptDisable<B>, IsButton<B> {

  private DivElement bodyElement;
  private LazyChild<SpanElement> textElement;
  private LazyChild<Icon<?>> iconElement;

  /** The default element that represent the button HTMLElement. */
  protected final BaseElement<E, ?> buttonElement;

  /** creates a button */
  protected BaseButton() {
    buttonElement =
        createButtonElement()
            .addClickListener(Event::stopPropagation)
            .addCss(dui_button)
            .appendChild(bodyElement = div().addCss(dui_button_body));
    textElement = LazyChild.of(span().addCss(dui_button_text), bodyElement);
    init((B) this);
  }

  /**
   * createButtonElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.BaseElement} object
   */
  protected abstract BaseElement<E, ?> createButtonElement();

  /**
   * creates a button with text
   *
   * @param text String text
   */
  protected BaseButton(String text) {
    this();
    setText(text);
  }

  /**
   * Constructor for BaseButton.
   *
   * @param text a {@link java.lang.String} object
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  protected BaseButton(String text, Icon<?> icon) {
    this();
    setText(text);
    setIcon(icon);
  }

  /**
   * creates a button with an icon
   *
   * @param icon {@link org.dominokit.domino.ui.icons.Icon}
   */
  protected BaseButton(Icon<?> icon) {
    this();
    setIcon(icon);
  }

  /** @hidden {@inheritDoc} */
  @Override
  public Element getAppendTarget() {
    return bodyElement.element();
  }

  /**
   * Update the button text
   *
   * @return an instance of B implementation extending from BaseButton
   */
  @Override
  public B setTextContent(String text) {
    return setText(text);
  }

  /**
   * Update the button text
   *
   * @return an instance of B implementation extending from BaseButton
   */
  public B setText(String text) {
    textElement.get().setTextContent(text);
    return (B) this;
  }

  /**
   * {@inheritDoc}
   *
   * @return the element that will receive click events when click listeners ar added to this
   *     component
   */
  @Override
  public HTMLElement getClickableElement() {
    return element();
  }

  /**
   * changes the button to a circle button by applying <code>dui_circle</code> css style
   *
   * @return same Button instance.
   */
  public B circle() {
    buttonElement.addCss(ButtonStyles.dui_circle);
    applyCircleWaves();
    return (B) this;
  }

  /**
   * sets the button icon replacing the current icon.
   *
   * @param icon the new {@link org.dominokit.domino.ui.icons.Icon}
   * @return same instance
   */
  public B setIcon(Icon<?> icon) {
    if (nonNull(iconElement)) {
      iconElement.remove();
    }
    iconElement = LazyChild.of(icon.addCss(dui_button_icon), bodyElement);
    iconElement.get();
    return (B) this;
  }

  /**
   * This will automatically initialize the button text element and append to the button if it was
   * not initialized yet.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SpanElement} that holds the button text.
   */
  public SpanElement getTextElement() {
    return textElement.get();
  }

  /**
   * Use this to apply customizations to the button text element without breaking the fluent API
   * chain this will initialize the text element and append it to the button if it was not yet
   * initialized.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} to apply the customization
   * @return same button instance
   */
  public B withTextElement(ChildHandler<B, SpanElement> handler) {
    handler.apply((B) this, textElement.get());
    return (B) this;
  }

  /**
   * This will initialize the text element and append it to the button if it was not yet
   * initialized.
   *
   * @return same button instance
   */
  public B withTextElement() {
    textElement.get();
    return (B) this;
  }

  /**
   * Use this to apply customizations to the button icon element without breaking the fluent API
   * chain this will initialize the icon element and append it to the button if it was not yet
   * initialized.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} to apply the customization
   * @return same button instance
   */
  public B withIconElement(ChildHandler<B, Icon<?>> handler) {
    if (nonNull(iconElement)) {
      handler.apply((B) this, iconElement.get());
    }
    return (B) this;
  }

  /**
   * This will initialize the icon element and append it to the button if it was not yet
   * initialized.
   *
   * @return same button instance
   */
  public B withIconElement() {
    if (nonNull(iconElement)) {
      iconElement.get();
    }
    return (B) this;
  }

  /**
   * Use this to apply customizations to the button body element without breaking the fluent API
   * chain
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} to apply the customization
   * @return same button instance
   */
  public B withBodyElement(ChildHandler<B, DivElement> handler) {
    handler.apply((B) this, bodyElement);
    return (B) this;
  }

  /**
   * Reverse the order of the button icon and text
   *
   * @param reversed <b>true</b> to order text to the left and icon to the right, <b>false</b> icon
   *     to the right and text to the left
   * @return same button instance
   */
  public B setReversed(boolean reversed) {
    addCss(BooleanCssClass.of(dui_button_reversed, reversed));
    return (B) this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return buttonElement.element();
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public B asButton() {
    return (B) this;
  }

  private void applyCircleWaves() {
    setWaveStyle(WaveStyle.CIRCLE);
    setWaveStyle(WaveStyle.FLOAT);
  }
}
