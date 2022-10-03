package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.menu.MenuStyles.*;

public class SimpleSelectOption<V> extends SelectOption<V> {

    private DominoElement<HTMLElement> descriptionElement;
    private DominoElement<HTMLElement> textElement;

    public static <V> SimpleSelectOption<V> create(V value, String key, String text) {
        return new SimpleSelectOption<>(value, key, text);
    }

    public static <V> SimpleSelectOption<V> create(V value) {
        return new SimpleSelectOption<>(value, String.valueOf(value), String.valueOf(value));
    }

    public static <V> SimpleSelectOption<V> create(V value, String key, String text, String description) {
        return new SimpleSelectOption<>(value, key, text, description);
    }

    public SimpleSelectOption(V value, String key, String text) {
        setKey(key);
        setValue(value);
        if (nonNull(text) && !text.isEmpty()) {
            textElement = DominoElement.span().addCss(MENU_ITEM_BODY).setTextContent(text);
            appendChild(textElement);
        }
    }

    public SimpleSelectOption(V value, String key, String text, String description) {
        this(value, key, text);
        if (nonNull(description) && !description.isEmpty()) {
            descriptionElement = DominoElement.small().addCss(MENU_ITEM_HINT).setTextContent(text);
            textElement.appendChild(descriptionElement);
        }
    }

    /**
     * @return The description element
     */
    public DominoElement<HTMLElement> getDescriptionElement() {
        return descriptionElement;
    }

    /**
     * @return the main text element
     */
    public DominoElement<HTMLElement> getTextElement() {
        return textElement;
    }

    /**
     * match the search token with both the text and description of the menu item
     *
     * @param token         String search text
     * @param caseSensitive boolean, true if the search is case-sensitive
     * @return boolean, true if the item matches the search
     */
    @Override
    public boolean onSearch(String token, boolean caseSensitive) {
        if (isNull(token) || token.isEmpty()) {
            this.show();
            return true;
        }
        if (containsToken(token, caseSensitive)) {
            if (this.isCollapsed()) {
                this.show();
            }
            return true;
        }
        if (this.isExpanded()) {
            this.hide();
        }
        return false;
    }

    private boolean containsToken(String token, boolean caseSensitive) {
        String textContent =
                Arrays.asList(Optional.ofNullable(textElement), Optional.ofNullable(descriptionElement))
                        .stream()
                        .filter(Optional::isPresent)
                        .map(element -> element.get().getTextContent())
                        .collect(Collectors.joining(" "));
        if (isNull(textContent) || textContent.isEmpty()) {
            return false;
        }
        if (caseSensitive) {
            return textContent.contains(token);
        }
        return textContent.toLowerCase().contains(token.toLowerCase());
    }


    /**
     * Adds an element as an add-on to the left
     *
     * @param addOn {@link FlexItem}
     * @return same menu item instance
     */
    public SimpleSelectOption<V> addLeftAddOn(IsElement<?> addOn) {
        if (nonNull(addOn)) {
            linkElement.appendChild(DominoElement.of(addOn).addCss(MENU_ITEM_ICON));
        }
        return this;
    }

    /**
     * Adds an element as an add-on to the right
     *
     * @param addOn {@link FlexItem}
     * @return same menu item instance
     */
    public SimpleSelectOption<V> addRightAddOn(IsElement<?> addOn) {
        if (nonNull(addOn)) {
            linkElement.appendChild(DominoElement.of(addOn).addCss(MENU_ITEM_UTILITY));
        }
        return this;
    }
}
