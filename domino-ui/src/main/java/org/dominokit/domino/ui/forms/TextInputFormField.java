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
        extends CountableInputFormField<T, E, V>
        implements HasPostfix<T>,
        HasPrefix<T> {

    protected final LazyChild<DominoElement<HTMLDivElement>> prefixElement;
    protected final LazyChild<DominoElement<HTMLDivElement>> postfixElement;

    public TextInputFormField() {
        prefixElement = LazyChild.of(DominoElement.div().addCss(FIELD_PREFIX), wrapperElement);
        postfixElement = LazyChild.of(DominoElement.div().addCss(FIELD_POSTFIX), wrapperElement);
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

    @Override
    public String getName() {
        return getInputElement().element().name;
    }

    @Override
    public T setName(String name) {
        getInputElement().element().name = name;
        return (T) this;
    }
}
