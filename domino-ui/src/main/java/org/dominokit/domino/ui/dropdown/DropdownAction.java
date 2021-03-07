package org.dominokit.domino.ui.dropdown;


import elemental2.core.JsRegExp;
import elemental2.core.JsString;
import elemental2.dom.DomGlobal;
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
import static org.jboss.elemento.Elements.*;

/**
 * A component which describes a drop down action
 * <p>
 * This component provides a representation of each {@link DropDownMenu} element
 * <p>
 * Customize the component can be done by overwriting classes provided by {@link DropDownStyles}
 *
 * <p>For example: </p>
 * <pre>
 *     DropdownAction.create("action 1");
 * </pre>
 *
 * @param <T> The value of this action which can be any object
 * @see BaseDominoElement
 * @see DropDownMenu
 * @see HasSelectionHandler
 * @see HasBackground
 */
public class DropdownAction<T> extends BaseDominoElement<HTMLLIElement, DropdownAction<T>> implements HasSelectionHandler<DropdownAction<T>, T>, HasBackground<DropdownAction<T>> {

    private static final String IGNORE_CASE_FLAG = "ig";

    private final HTMLLIElement liElement = li().element();
    private final T value;
    private final DominoElement<HTMLElement> content = DominoElement.of(span());
    private HTMLAnchorElement aElement;
    private final List<SelectionHandler<T>> selectionHandlers = new ArrayList<>();
    private final List<FocusHandler<T>> focusHandlers = new ArrayList<>();
    private boolean autoClose = true;
    private Color background;
    private boolean filteredOut = false;
    private boolean excludeFromSearchResults = false;
    public static final JsRegExp REPLACER_REGEX = new JsRegExp("[-\\/\\\\^$*+?.()|[\\]{}]", "g");

    public DropdownAction(T value, String displayValue) {
        this(value, displayValue, null);
    }

    public DropdownAction(T value, String displayValue, BaseIcon<?> icon) {
        this.value = value;
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
        aElement.addEventListener("focus", evt -> {
            evt.stopPropagation();
            focusHandlers.forEach(focusHandler -> focusHandler.onFocus(this));
        });
    }

    /**
     * Creates an action with text value
     *
     * @param content the value as text
     * @return new instance
     */
    public static DropdownAction<String> create(String content) {
        return create(content, content);
    }

    /**
     * Creates an action with {@code T} as a value, {@code displayValue} to be shown, and an icon
     *
     * @param value the value object
     * @param displayValue the display value text
     * @param icon the icon
     * @param <T> the type of the value
     * @return new instance
     */
    public static <T> DropdownAction<T> create(T value, String displayValue, BaseIcon<?> icon) {
        return new DropdownAction<>(value, displayValue, icon);
    }

    /**
     * Creates an action with {@code T} as a value and a {@code displayValue} to be shown
     *
     * @param value the value object
     * @param displayValue the display value text
     * @param <T> the type of the value
     * @return new instance
     */
    public static <T> DropdownAction<T> create(T value, String displayValue) {
        return new DropdownAction<>(value, displayValue);
    }

    /**
     * Creates an action with {@code T} as a value and a content {@link HTMLElement}
     *
     * @param value the value object
     * @param content The content of the action as {@link HTMLElement}
     * @param <T> the type of the value
     * @return new instance
     */
    public static <T> DropdownAction<T> create(T value, HTMLElement content) {
        return new DropdownAction<>(value, content);
    }

    /**
     * Focuses the action
     *
     * @return same instance
     */
    public DropdownAction<T> focus() {
        aElement.focus();
        return this;
    }

    /**
     * Selects the action, this will trigger all the selection handlers
     *
     * @return same instance
     */
    public DropdownAction<T> select() {
        selectionHandlers.forEach(handler -> handler.onSelection(getValue()));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLLIElement element() {
        return liElement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DropdownAction<T> addSelectionHandler(SelectionHandler<T> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DropdownAction<T> removeSelectionHandler(SelectionHandler<T> selectionHandler) {
        selectionHandlers.remove(selectionHandler);
        return this;
    }

    /**
     * @return The current value of the action
     */
    public T getValue() {
        return value;
    }

    /**
     * @return The content element of the action
     */
    public HTMLElement getContent() {
        return content.element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLAnchorElement getClickableElement() {
        return aElement;
    }

    /**
     * Sets the display value of the action as text
     *
     * @param displayValue the text that will be shown as a content
     * @return same instance
     */
    public DropdownAction<T> setDisplayValue(String displayValue) {
        this.content.clearElement()
                .appendChild(span()
                        .textContent(displayValue));
        return this;
    }

    /**
     * Sets the display value of the action as text along with an icon
     *
     * @param icon the icon
     * @param displayValue the display text
     * @return same instance
     */
    public DropdownAction<T> setDisplayValue(BaseIcon<?> icon, String displayValue) {
        this.content.clearElement()
                .appendChild(icon)
                .appendChild(TextNode.of(displayValue));

        return this;
    }

    /**
     * Sets the display value of the action as an element
     *
     * @param content the {@link HTMLElement}
     * @return same instance
     */
    public DropdownAction<T> setDisplayValue(HTMLElement content) {
        this.content.clearElement()
                .appendChild(content);
        return this;
    }

    /**
     * Adds focus handler that will be called when the action gets focused
     *
     * @param focusHandler the {@link FocusHandler} to add
     * @return same instance
     */
    public DropdownAction<T> addFocusHandler(FocusHandler<T> focusHandler) {
        focusHandlers.add(focusHandler);
        return this;
    }

    /**
     * @return True if the selecting the action will close the menu automatically, false otherwise
     */
    public boolean isAutoClose() {
        return autoClose;
    }

    /**
     * Sets if selecting the action will close the menu automatically
     *
     * @param autoClose True if the selecting the action will close the menu automatically, false otherwise
     * @return same instance
     */
    public DropdownAction<T> setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
        return this;
    }

    /**
     * Hides the action as it does not comply with the provided search criteria
     *
     * @return same instance
     */
    public DropdownAction<T> filter() {
        this.hide();
        this.setFilteredOut(true);
        return this;
    }

    /**
     * Shows the action as it does comply with the provided search criteria
     *
     * @return same instance
     */
    public DropdownAction<T> deFilter() {
        this.show();
        this.setFilteredOut(false);
        return this;
    }

    /**
     * @return True if the actions does not comply with the search criteria and it is filtered out, false otherwise
     */
    public boolean isFilteredOut() {
        return filteredOut;
    }

    void setFilteredOut(boolean filteredOut) {
        this.filteredOut = filteredOut;
    }

    /**
     * @return True if this action is not included in the search and will be hidden if the search provided, false otherwise
     */
    public boolean isExcludeFromSearchResults() {
        return excludeFromSearchResults;
    }

    /**
     * Sets if this action is not included in the search and will be hidden if the search provided
     *
     * @param excludeFromSearchResults True if this action is not included in the search and will be hidden if the search provided, false otherwise
     * @return same instance
     */
    public DropdownAction<T> setExcludeFromSearchResults(boolean excludeFromSearchResults) {
        this.excludeFromSearchResults = excludeFromSearchResults;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DropdownAction<T> setBackground(Color background) {
        if (nonNull(background)) {
            if (nonNull(this.background)) {
                DominoElement.of(getClickableElement())
                        .removeCss(this.background.getBackground());
                DominoElement.of(content).removeCss(this.background.getBackground());
            }
            DominoElement.of(getClickableElement()).addCss(background.getBackground());
            DominoElement.of(content).addCss(background.getBackground());
            this.background = background;
        }
        return this;
    }

    /**
     * Highlights the {@code displayValue} with a color which indicates that it complies with the search criteria
     *
     * @param displayValue the match value
     * @param highlightColor the highlight {@link Color}
     */
    public void highlight(String displayValue, Color highlightColor) {
        String innerHTML = this.content.getTextContent();
        String escapedSearchValue = new JsString(displayValue).replace(REPLACER_REGEX, "\\$&");

        JsRegExp regExp = new JsRegExp(escapedSearchValue, IGNORE_CASE_FLAG);
        innerHTML = new JsString(innerHTML).replace(regExp, (valueToReplace, p1) -> {
            if (nonNull(highlightColor)) {
                return "<strong class=\"" + highlightColor.getStyle() + "\">" + valueToReplace + "</strong>";
            }
            return "<strong>" + valueToReplace + "</strong>";
        });
        innerHtml(this.content.element(), new SafeHtmlBuilder().appendHtmlConstant(innerHTML).toSafeHtml());
    }

    /**
     * A handler that will be called when the element gets focused
     * @param <T> the value type of the action
     */
    @FunctionalInterface
    public interface FocusHandler<T> {
        /**
         * Will be called when the element gets focused
         * @param dropdownAction the action that gets focused
         */
        void onFocus(DropdownAction<T> dropdownAction);
    }
}
