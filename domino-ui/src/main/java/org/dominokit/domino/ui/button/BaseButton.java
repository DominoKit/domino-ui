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

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.*;
import org.dominokit.domino.ui.utils.*;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.button.ButtonStyles.*;

/**
 * A base component to implement buttons
 *
 * <p>this class provides commons functionality and methods used in different implementations of a
 * button
 *
 * @param <B> The button subclass being wrapped
 */
public abstract class BaseButton<E extends HTMLElement, B extends BaseButton<E, B>> extends WavesElement<HTMLElement, B>
        implements HasClickableElement, Sizable<B>, AcceptDisable<B>, IsButton<B> {


    private SwapCssClass sizeCssClass = SwapCssClass.of(GenericCss.dui_medium);

    private DominoElement<HTMLDivElement> bodyElement;
    private LazyChild<DominoElement<HTMLElement>> textElement;
    private LazyChild<BaseIcon<?>> iconElement;

    /**
     * The default element that represent the button HTMLElement.
     */
    protected final DominoElement<E> buttonElement;

    /**
     * creates a button with default size {@link ButtonSize#MEDIUM}
     */
    protected BaseButton() {
        buttonElement = createButtonElement().addCss(dui_button)
                .appendChild(bodyElement = DominoElement.div().addCss(dui_button_body));
        textElement = LazyChild.of(DominoElement.span().addCss(dui_button_text, dui_flex_grow), bodyElement);
        init((B) this);
    }

    protected abstract DominoElement<E> createButtonElement();

    /**
     * creates a button with text and default size {@link ButtonSize#MEDIUM}
     *
     * @param text String text
     */
    protected BaseButton(String text) {
        this();
        setText(text);
    }

    protected BaseButton(String text, BaseIcon<?> icon) {
        this();
        setText(text);
        setIcon(icon);
    }

    /**
     * creates a button with an icon and default size {@link ButtonSize#MEDIUM}
     *
     * @param icon {@link BaseIcon}
     */
    protected BaseButton(BaseIcon<?> icon) {
        this();
        setIcon(icon);
    }

    /**
     * @param text String, the new text
     * @return same instance
     */
    @Override
    public B setTextContent(String text) {
        return setText(text);
    }

    public B setText(String text) {
        textElement.get().setTextContent(text);
        return (B) this;
    }

    /**
     * change the size of the button
     *
     * @param size {@link ButtonSize}
     * @return same instance
     */
    public B setSize(ButtonSize size) {
        if (nonNull(size)) {
            addCss(sizeCssClass.replaceWith(size.getStyle()));
        }
        return (B) this;
    }

    /**
     * return the clickable {@link HTMLElement} of this component, which the component button element.
     *
     * @return {@link HTMLElement} of this button instance
     */
    @Override
    public HTMLElement getClickableElement() {
        return element();
    }

    /**
     * change the button size to {@link ButtonSize#LARGE}
     *
     * @return same instance
     */
    @Override
    public B large() {
        setSize(ButtonSize.LARGE);
        return (B) this;
    }

    /**
     * change the button size to {@link ButtonSize#MEDIUM}
     *
     * @return same instance
     */
    @Override
    public B medium() {
        setSize(ButtonSize.MEDIUM);
        return (B) this;
    }

    /**
     * change the button size to {@link ButtonSize#SMALL}
     *
     * @return same instance
     */
    @Override
    public B small() {
        setSize(ButtonSize.SMALL);
        return (B) this;
    }

    /**
     * change the button size to {@link ButtonSize#XSMALL}
     *
     * @return same instance
     */
    @Override
    public B xSmall() {
        setSize(ButtonSize.XSMALL);
        return (B) this;
    }

    /**
     * changes the button to a circle button by applying {@link ButtonStyles#dui_circle}
     *
     * @return same instance
     */
    public B circle() {
        buttonElement.addCss(ButtonStyles.dui_circle);
        applyCircleWaves();
        return (B) this;
    }

    /**
     * sets the button icon replacing the current icon.
     *
     * @param icon the new {@link BaseIcon}
     * @return same instance
     */
    public B setIcon(BaseIcon<?> icon) {
        if (nonNull(iconElement)) {
            iconElement.remove();
        }
        iconElement = LazyChild.of(icon.addCss(dui_button_icon), bodyElement);
        iconElement.get();
        return (B) this;
    }

    public DominoElement<HTMLElement> getTextElement(){
        return textElement.get();
    }

    public B withTextElement(ChildHandler<B, DominoElement<HTMLElement>> handler){
        handler.apply((B)this, textElement.get());
        return (B) this;
    }

    public B withTextElement(){
        textElement.get();
        return (B) this;
    }

    public B withIconElement(ChildHandler<B, BaseIcon<?>> handler){
        if(nonNull(iconElement)) {
            handler.apply((B) this, iconElement.get());
        }
        return (B) this;
    }

    public B withIconElement(){
        if(nonNull(iconElement)) {
            iconElement.get();
        }
        return (B) this;
    }

    public B setReversed(boolean reversed){
        addCss(BooleanCssClass.of(dui_button_reversed, reversed));
        return (B) this;
    }

    @Override
    public HTMLElement element() {
        return buttonElement.element();
    }

    @Override
    public B asButton() {
        return (B) this;
    }

    private void applyCircleWaves() {
        applyWaveStyle(WaveStyle.CIRCLE);
        applyWaveStyle(WaveStyle.FLOAT);
    }
}
