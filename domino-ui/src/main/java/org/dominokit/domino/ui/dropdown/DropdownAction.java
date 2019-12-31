package org.dominokit.domino.ui.dropdown;


import elemental2.core.JsRegExp;
import elemental2.core.JsString;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class DropdownAction<T> extends BaseDominoElement<HTMLLIElement, DropdownAction<T>> implements HasSelectionHandler<DropdownAction<T>, T>, HasBackground<DropdownAction<T>> {

    private static final String IGNORE_CASE_FLAG = "ig";

    private HTMLLIElement liElement = li().element();
    private T value;
    private BaseIcon<?> icon;
    private DominoElement<HTMLElement> content = DominoElement.of(span());
    private HTMLAnchorElement aElement;
    private List<SelectionHandler<T>> selectionHandlers = new ArrayList<>();
    private List<FocusHandler<T>> focusHandlers = new ArrayList<>();
    private boolean autoClose = true;
    private Color background;

    public DropdownAction(T value, String displayValue) {
        this(value, displayValue, null);
    }

    public DropdownAction(T value, String displayValue, BaseIcon<?> icon) {
        this.value = value;
        this.icon = icon;
        init();
        if (nonNull(icon)) {
            aElement.appendChild(icon.element());
        }
        this.content.setTextContent(displayValue);
        aElement.appendChild(this.content.element());
        init(this);
    }

    public DropdownAction(T value, HTMLElement content) {
        this.value = value;
        this.content.appendChild(content);
        init();
        aElement.appendChild(this.content.element());
        init(this);
    }

    private void init() {
        aElement = a()
                .attr("tabindex", "0")
                .element();
        liElement.appendChild(aElement);

        liElement.setAttribute("role", "option");
        liElement.addEventListener("click", evt -> {
            evt.stopPropagation();
            select();
            evt.preventDefault();
        });
        aElement.addEventListener("focus", evt -> focusHandlers.forEach(focusHandler -> focusHandler.onFocus(this)));
    }

    public static DropdownAction<String> create(String content) {
        return create(content, content);
    }

    public static <T> DropdownAction<T> create(T value, String displayValue, BaseIcon<?> icon) {
        return new DropdownAction<>(value, displayValue, icon);
    }

    public static <T> DropdownAction<T> create(T value, String displayValue) {
        return new DropdownAction<>(value, displayValue);
    }

    public static <T> DropdownAction<T> create(T value, HTMLElement content) {
        return new DropdownAction<>(value, content);
    }

    public DropdownAction<T> focus() {
        aElement.focus();
        return this;
    }

    public DropdownAction<T> select() {
        selectionHandlers.forEach(handler -> handler.onSelection(getValue()));
        return this;
    }

    @Override
    public HTMLLIElement element() {
        return liElement;
    }

    @Override
    public DropdownAction<T> addSelectionHandler(SelectionHandler<T> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    @Override
    public DropdownAction<T> removeSelectionHandler(SelectionHandler<T> selectionHandler) {
        selectionHandlers.remove(selectionHandler);
        return this;
    }

    public T getValue() {
        return value;
    }

    public HTMLElement getContent() {
        return content.element();
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return aElement;
    }

    public DropdownAction<T> setDisplayValue(String displayValue) {
        this.content.clearElement()
                .appendChild(span()
                        .textContent(displayValue));
        return this;
    }

    public DropdownAction<T> setDisplayValue(BaseIcon<?> icon, String displayValue) {
        this.content.clearElement()
                .appendChild(icon)
                .appendChild(TextNode.of(displayValue));

        return this;
    }

    public DropdownAction<T> setDisplayValue(HTMLElement content) {
        this.content.clearElement()
                .appendChild(content);
        return this;
    }

    public DropdownAction<T> addFocusHandler(FocusHandler<T> focusHandler) {
        focusHandlers.add(focusHandler);
        return this;
    }

    public boolean isAutoClose() {
        return autoClose;
    }

    public DropdownAction<T> setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
        return this;
    }

    @Override
    public DropdownAction<T> setBackground(Color background) {
        if (nonNull(background)) {
            if (nonNull(this.background)) {
                DominoElement.of(getClickableElement())
                        .removeCss(this.background.getBackground());
                if (nonNull(content)) {
                    DominoElement.of(content).removeCss(this.background.getBackground());
                }
            }
            DominoElement.of(getClickableElement()).addCss(background.getBackground());
            if (nonNull(content)) {
                DominoElement.of(content).addCss(background.getBackground());
            }
            this.background = background;
        }
        return this;
    }

    public void highlight(String displayValue, Color highlightColor) {
        if (nonNull(this.content)) {
            String innerHTML = this.content.getTextContent();
            JsRegExp regExp = new JsRegExp(displayValue, IGNORE_CASE_FLAG);
            innerHTML = new JsString(innerHTML).replace(regExp, (valueToReplace, p1) -> {
                if (nonNull(highlightColor)) {
                    return "<strong class=\"" + highlightColor.getStyle() + "\">" + valueToReplace + "</strong>";
                }
                return "<strong>" + valueToReplace + "</strong>";
            });
            innerHtml(this.content.element(), new SafeHtmlBuilder().appendHtmlConstant(innerHTML).toSafeHtml());
        }
    }

    @FunctionalInterface
    public interface FocusHandler<T> {
        void onFocus(DropdownAction<T> dropdownAction);
    }
}
