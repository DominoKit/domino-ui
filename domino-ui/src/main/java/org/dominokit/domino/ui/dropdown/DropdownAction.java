package org.dominokit.domino.ui.dropdown;


import elemental2.core.JsRegExp;
import elemental2.core.JsString;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class DropdownAction extends BaseDominoElement<HTMLLIElement, DropdownAction> implements HasSelectionHandler<DropdownAction, String>, HasBackground<DropdownAction> {

    private static final String IGNORE_CASE_FLAG = "ig";

    private HTMLLIElement liElement = li().asElement();
    private String value;
    private BaseIcon<?> icon;
    private HTMLElement content;
    private HTMLAnchorElement aElement;
    private List<SelectionHandler<String>> selectionHandlers = new ArrayList<>();
    private List<FocusHandler> focusHandlers = new ArrayList<>();
    private boolean autoClose = true;
    private Color background;
    private HTMLElement valueNode;

    public DropdownAction(String value, String displayValue) {
        this(value, null, displayValue);
    }

    public DropdownAction(String value, BaseIcon<?> icon, String displayValue) {
        this.value = value;
        this.icon = icon;
        init();
        if (nonNull(icon))
            aElement.appendChild(icon.asElement());
        valueNode = span()
                .textContent(displayValue)
                .asElement();
        aElement.appendChild(valueNode);
        init(this);
    }

    public DropdownAction(String value, HTMLElement content) {
        this.value = value;
        this.content = content;
        init();
        aElement.appendChild(content);
        init(this);
    }

    private void init() {
        aElement = a()
                .attr("tabindex", "0")
                .asElement();
        liElement.appendChild(aElement);

        liElement.setAttribute("role", "option");
        liElement.addEventListener("click", evt -> {
            evt.stopPropagation();
            select();
            evt.preventDefault();
        });
        aElement.addEventListener("focus", evt -> focusHandlers.forEach(focusHandler -> focusHandler.onFocus(this)));
    }

    public static DropdownAction create(String content) {
        return create(content, content);
    }

    public static DropdownAction create(String value, String displayValue) {
        return new DropdownAction(value, displayValue);
    }

    public static DropdownAction create(String value, BaseIcon<?> icon, String displayValue) {
        return new DropdownAction(value, icon, displayValue);
    }

    public static DropdownAction create(String value, HTMLElement content) {
        return new DropdownAction(value, content);
    }

    public DropdownAction focus() {
        aElement.focus();
        return this;
    }

    public DropdownAction select() {
        selectionHandlers.forEach(handler -> handler.onSelection(getValue()));
        return this;
    }

    @Override
    public HTMLLIElement asElement() {
        return liElement;
    }

    @Override
    public DropdownAction addSelectionHandler(SelectionHandler<String> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    @Override
    public DropdownAction removeSelectionHandler(SelectionHandler<String> selectionHandler) {
        selectionHandlers.remove(selectionHandler);
        return this;
    }

    public String getValue() {
        return value;
    }

    public Node getContent() {
        return content;
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return aElement;
    }

    public DropdownAction setDisplayValue(String displayValue) {
        DominoElement.of(aElement).clearElement()
                .appendChild(TextNode.of(displayValue));
        return this;
    }

    public DropdownAction setDisplayValue(BaseIcon<?> icon, String displayValue) {
        DominoElement.of(aElement).clearElement()
                .appendChild(icon.asElement())
                .appendChild(TextNode.of(displayValue));
        return this;
    }

    public DropdownAction setDisplayValue(HTMLElement content) {
        this.content = content;
        DominoElement.of(aElement).clearElement()
                .appendChild(content);
        return this;
    }

    public DropdownAction addFocusHandler(FocusHandler focusHandler) {
        focusHandlers.add(focusHandler);
        return this;
    }

    public boolean isAutoClose() {
        return autoClose;
    }

    public DropdownAction setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
        return this;
    }

    @Override
    public DropdownAction setBackground(Color background) {
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

    public void highlight(String value, Color highlightColor) {
        if (nonNull(valueNode)) {
            String innerHTML = valueNode.textContent;
            JsRegExp regExp = new JsRegExp(value, IGNORE_CASE_FLAG);
            innerHTML = new JsString(innerHTML).replace(regExp, (valueToReplace, p1) -> {
                if (nonNull(highlightColor)) {
                    return "<strong class=\"" + highlightColor.getStyle() + "\">" + valueToReplace + "</strong>";
                }
                return "<strong>" + valueToReplace + "</strong>";
            });
            innerHtml(valueNode, new SafeHtmlBuilder().appendHtmlConstant(innerHTML).toSafeHtml());
        }
    }

    @FunctionalInterface
    public interface FocusHandler {
        void onFocus(DropdownAction dropdownAction);
    }
}
