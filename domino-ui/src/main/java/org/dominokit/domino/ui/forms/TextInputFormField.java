package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.forms.validations.MaxLengthValidator;
import org.dominokit.domino.ui.forms.validations.MinLengthValidator;
import org.dominokit.domino.ui.utils.*;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.forms.FormsStyles.*;

public abstract class TextInputFormField<T extends InputFormField<T, E, V>, E extends HTMLInputElement, V>
        extends InputFormField<T, E, V>
        implements HasCounter<T>,
        HasMinMaxLength<T>,
        HasPlaceHolder<T>,
        HasPostfix<T>,
        HasPrefix<T> {

    protected final LazyChild<DominoElement<HTMLElement>> counterElement;
    protected CountFormatter countFormatter = (count, maxCount) -> count + "/" + maxCount;
    private MinLengthValidator<T> minLengthValidator;
    private MaxLengthValidator<T> maxLengthValidator;

    protected final LazyChild<DominoElement<HTMLDivElement>> prefixElement;
    protected final LazyChild<DominoElement<HTMLDivElement>> postfixElement;

    public TextInputFormField() {
        prefixElement = LazyChild.of(DominoElement.div().addCss(FIELD_PREFIX), wrapperElement);
        postfixElement = LazyChild.of(DominoElement.div().addCss(FIELD_POSTFIX), wrapperElement);
        counterElement = LazyChild.of(DominoElement.span().addCss(FIELD_COUNTER), wrapperElement);
    }

    @Override
    public T updateCounter(int count, int maxCount) {
        if (maxCount > 0) {
            counterElement.get().setTextContent(countFormatter.format(count, getMaxCount()));
            minLengthValidator = new MinLengthValidator<>(this);
            maxLengthValidator = new MaxLengthValidator<>(this);
        }
        return (T) this;
    }

    public T setCountFormatter(CountFormatter formatter) {
        this.countFormatter = formatter;
        if (counterElement.isInitialized()) {
            updateCounter(getLength(), getMaxCount());
        }
        return (T) this;
    }

    @Override
    public int getMaxLength() {
        if (getInputElement().hasAttribute(MAX_LENGTH)) {
            return Integer.parseInt(getInputElement().getAttribute(MAX_LENGTH));
        }
        return -1;
    }

    @Override
    public T setMaxLength(int maxLength) {
        if (maxLength < 0) {
            counterElement.remove();
            getInputElement().removeAttribute(MAX_LENGTH);
            removeValidator(maxLengthValidator);
        } else {
            counterElement.get();
            getInputElement().setAttribute(MAX_LENGTH, maxLength);
            updateCounter(getLength(), getMaxCount());
            addValidator(maxLengthValidator);
        }
        return (T) this;
    }

    @Override
    public int getLength() {
        String stringValue = getStringValue();
        if (nonNull(stringValue)) {
            return getStringValue().length();
        }
        return 0;
    }

    @Override
    public int getMinLength() {
        if (getInputElement().hasAttribute(MIN_LENGTH)) {
            return Integer.parseInt(getInputElement().getAttribute(MIN_LENGTH));
        }
        return -1;
    }

    @Override
    public T setMinLength(int minLength) {
        if (minLength < 0) {
            counterElement.remove();
            getInputElement().removeAttribute(MIN_LENGTH);
            removeValidator(minLengthValidator);
        } else {
            counterElement.get();
            getInputElement().setAttribute("minlength", minLength);
            updateCounter(getLength(), getMaxCount());
            addValidator(minLengthValidator);
        }
        getInputElement().setAttribute(MIN_LENGTH, minLength);
        return (T) this;
    }

    @Override
    public int getMaxCount() {
        return getMaxLength();
    }

    @Override
    public String getPlaceholder() {
        return getInputElement().getAttribute("placeholder");
    }

    @Override
    public T setPlaceholder(String placeholder) {
        getInputElement().setAttribute("placeholder", placeholder);
        return (T) this;
    }

    @Override
    public T setPostfix(String postfix) {
        postfixElement.get().setTextContent(postfix);
        return (T) this;
    }

    @Override
    public String getPostfix() {
        if (postfixElement.isInitialized()) {
            return postfixElement.get().getTextContent();
        }
        return "";
    }

    @Override
    public T setPrefix(String prefix) {
        prefixElement.get().setTextContent(prefix);
        return (T) this;
    }

    @Override
    public String getPrefix() {
        if (prefixElement.isInitialized()) {
            return prefixElement.get().getTextContent();
        }
        return "";
    }

    public DominoElement<HTMLElement> getCounterElement() {
        return counterElement.get();
    }

    public T withCounterElement() {
        counterElement.get();
        return (T) this;
    }

    public T withCounterElement(ChildHandler<T, DominoElement<HTMLElement>> handler) {
        handler.apply((T) this, counterElement.get());
        return (T) this;
    }

    public DominoElement<HTMLDivElement> getPrefixElement() {
        return prefixElement.get();
    }

    public DominoElement<HTMLDivElement> getPostfixElement() {
        return postfixElement.get();
    }

    public T withPrefixElement() {
        prefixElement.get();
        return (T) this;
    }

    public T withPrefixElement(ChildHandler<T, DominoElement<HTMLDivElement>> handler) {
        handler.apply((T) this, prefixElement.get());
        return (T) this;
    }

    public T withPostfixElement() {
        postfixElement.get();
        return (T) this;
    }

    public T withPostfixElement(ChildHandler<T, DominoElement<HTMLDivElement>> handler) {
        handler.apply((T) this, postfixElement.get());
        return (T) this;
    }
}
