package org.dominokit.domino.ui.chips;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLImageElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.span;

public class Chip implements IsElement<HTMLDivElement>, HasSelectionHandler<Chip>, HasDeselectionHandler<Chip>,
        Switchable<Chip>, HasRemoveHandler<Chip>, HasClickHandler<Chip> {

    private HTMLDivElement element = div().css("chip").asElement();
    private HTMLDivElement textContainer = div().css("chip-value").asElement();
    private HTMLDivElement leftAddonContainer = div().css("chip-addon").asElement();
    private HTMLDivElement removeIconContainer = div().css("chip-remove").asElement();
    private ColorScheme colorScheme = ColorScheme.INDIGO;
    private Color borderColor;
    private HTMLElement removeIcon = Icons.ALL.close().asElement();
    private List<SelectionHandler> selectionHandlers = new ArrayList<>();
    private List<DeselectionHandler> deselectionHandlers = new ArrayList<>();
    private List<RemoveHandler> removeHandlers = new ArrayList<>();
    private boolean selected;
    private boolean enabled;
    private HTMLElement leftAddon;
    private boolean selectable;
    private List<ClickHandler> clickHandlers = new ArrayList<>();
    private Color leftBackground;

    public Chip(String value) {
        element.appendChild(leftAddonContainer);
        element.appendChild(textContainer);
        element.appendChild(removeIconContainer);
        setColorScheme(colorScheme);
        setRemoveIcon(removeIcon);
        setRemovable(false);
        setBorderColor(Color.INDIGO);
        setValue(value);
        element.addEventListener("click", evt -> {
            if (selectable) {
                toggle();
            } else {
                clickHandlers.forEach(ClickHandler::onClick);
            }
            evt.stopPropagation();
        });
    }

    public static Chip create() {
        return create("");
    }

    public static Chip create(String value) {
        return new Chip(value);
    }

    public Chip select() {
        this.selected = true;
        Style.of(element).replaceClass(getColor(), getDarkerColor());
        Style.of(removeIcon).css(getDarkerColor());
        selectionHandlers.forEach(SelectionHandler::onSelection);
        return this;
    }

    public Chip deselect() {
        this.selected = false;
        Style.of(element).replaceClass(getDarkerColor(), getColor());
        Style.of(removeIcon).removeClass(getDarkerColor());
        deselectionHandlers.forEach(DeselectionHandler::onDeselection);
        return this;
    }

    public Chip toggle() {
        if (selected) {
            deselect();
        } else {
            select();
        }
        return this;
    }

    public Chip setRemoveIcon(HTMLElement removeIcon) {
        this.removeIcon = removeIcon;
        ElementUtil.clear(removeIconContainer);
        removeIconContainer.appendChild(removeIcon);
        removeIcon.addEventListener("click", evt -> {
            remove();
            evt.stopPropagation();
        });
        return this;
    }

    public Chip remove() {
        element.remove();
        removeHandlers.forEach(RemoveHandler::onRemove);
        return this;
    }

    public Chip setRemoveIcon(IsElement removeIcon) {
        return setRemoveIcon(removeIcon.asElement());
    }

    public Chip setColorScheme(ColorScheme colorScheme) {
        if (nonNull(this.colorScheme)) {
            element.classList.remove(getColor());
            removeIcon.classList.remove(getColor());
        }
        this.colorScheme = colorScheme;
        element.classList.add(getColor());
        removeIcon.classList.add(getColor());
        setBorderColor(colorScheme.color());
        return this;
    }

    private String getDarkerColor() {
        return colorScheme.darker_4().getBackground();
    }

    private String getColor() {
        return this.colorScheme.color().getBackground();
    }

    public Chip setRemovable(boolean removable) {
        if (removable) {
            Style.of(removeIconContainer).setDisplay("block");
        } else {
            Style.of(removeIconContainer).setDisplay("none");
        }
        return this;
    }

    public Chip setValue(String value) {
        textContainer.textContent = value;
        return this;
    }

    public Chip setLeftIcon(Icon icon) {
        setLeftAddon(icon.asElement());
        return this;
    }

    public Chip setLeftImg(HTMLImageElement imageElement) {
        setLeftAddon(imageElement);
        return this;
    }

    public Chip setLeftLetter(String text) {
        setLeftAddon(span().textContent(text).asElement());
        return this;
    }

    private void setLeftAddon(HTMLElement leftAddon) {
        this.leftAddon = leftAddon;
        ElementUtil.clear(leftAddonContainer);
        leftAddonContainer.appendChild(leftAddon);
        updateLeftAddonBackground();
    }

    public Chip setLeftBackground(Color leftBackground) {
        this.leftBackground = leftBackground;
        updateLeftAddonBackground();
        return this;
    }

    private void updateLeftAddonBackground() {
        if (nonNull(leftAddon) && nonNull(leftBackground)) {
            Style.of(leftAddon).css(leftBackground.getBackground());
        }
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    @Override
    public Chip addSelectionHandler(SelectionHandler selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    @Override
    public Chip addDeselectionHandler(DeselectionHandler deselectionHandler) {
        deselectionHandlers.add(deselectionHandler);
        return this;
    }

    @Override
    public Chip enable() {
        this.enabled = true;
        element.removeAttribute("disabled");
        removeIconContainer.removeAttribute("disabled");
        return this;
    }

    @Override
    public Chip disable() {
        this.enabled = false;
        element.setAttribute("disabled", "disabled");
        removeIconContainer.setAttribute("disabled", "disabled");
        return this;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public Chip addRemoveHandler(RemoveHandler removeHandler) {
        removeHandlers.add(removeHandler);
        return this;
    }

    public Chip setSelectable(boolean selectable) {
        this.selectable = selectable;
        return this;
    }

    @Override
    public Chip addClickHandler(ClickHandler clickHandler) {
        clickHandlers.add(clickHandler);
        return this;
    }

    public Chip setBorderColor(Color borderColor) {
        if (nonNull(this.borderColor)) {
            Style.of(element).removeProperty("border-color");
        }
        this.borderColor = borderColor;
        Style.of(element).setBorderColor(borderColor.getHex());
        return this;
    }

    public Chip removeLeftAddon() {
        ElementUtil.clear(leftAddonContainer);
        return this;
    }

    public Style<HTMLDivElement, Chip> style() {
        return Style.of(this);
    }

    public String getValue() {
        return textContainer.textContent;
    }

    public HTMLDivElement getTextContainer() {
        return textContainer;
    }

    public HTMLDivElement getLeftAddonContainer() {
        return leftAddonContainer;
    }

    public HTMLDivElement getRemoveIconContainer() {
        return removeIconContainer;
    }

    public HTMLElement getRemoveIcon() {
        return removeIcon;
    }

    public HTMLElement getLeftAddon() {
        return leftAddon;
    }
}
