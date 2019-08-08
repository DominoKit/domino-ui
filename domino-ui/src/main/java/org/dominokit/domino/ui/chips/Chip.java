package org.dominokit.domino.ui.chips;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLImageElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.chips.ChipStyles.*;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.span;

public class Chip extends BaseDominoElement<HTMLDivElement, Chip> implements HasSelectionHandler<Chip, String>, HasDeselectionHandler<Chip>,
        Switchable<Chip>, HasRemoveHandler<Chip> {

    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css(CHIP));
    private HTMLDivElement textContainer = div().css(CHIP_VALUE).asElement();
    private HTMLDivElement leftAddonContainer = div().css(CHIP_ADDON).asElement();
    private HTMLDivElement removeIconContainer = div().css(CHIP_REMOVE).asElement();
    private ColorScheme colorScheme = ColorScheme.INDIGO;
    private Color color = Color.INDIGO;
    private Color borderColor;
    private DominoElement<HTMLElement> removeIcon = DominoElement.of(Icons.ALL.close().asElement());
    private List<SelectionHandler<String>> selectionHandlers = new ArrayList<>();
    private List<DeselectionHandler> deselectionHandlers = new ArrayList<>();
    private List<RemoveHandler> removeHandlers = new ArrayList<>();
    private boolean selected;
    private boolean enabled;
    private HTMLElement leftAddon;
    private boolean selectable;
    private boolean removable;
    private Color leftBackground;
    private Theme.ThemeChangeHandler themeListener = (oldTheme, newTheme) -> style.setBorderColor(newTheme.getScheme().color().getHex());

    public Chip(String value) {
        element.appendChild(leftAddonContainer);
        element.appendChild(textContainer);
        element.appendChild(removeIconContainer);
        element.setAttribute("tabindex", "0");
        setColorScheme(colorScheme);
        setRemoveIcon(removeIcon);
        setRemovable(false);
        setBorderColor(Color.INDIGO);
        setValue(value);
        KeyboardEvents.listenOn(element).onEnter(evt -> {
            if(removable) {
               remove();
              }else if(selectable) {
                  toggleSelect();
              }
            evt.stopPropagation();
        });
        element.addEventListener("click", evt -> {
            if (selectable) {
                toggleSelect();
            }
            evt.stopPropagation();
        });
        init(this);
    }

    public static Chip create() {
        return create("");
    }

    public static Chip create(String value) {
        return new Chip(value);
    }

    public Chip select() {
        this.selected = true;
        Style.of(element).replaceCss(getBackgroundStyle(), getDarkerColor());
        Style.of(removeIcon).add(getDarkerColor());
        selectionHandlers.forEach(selectionHandler -> selectionHandler.onSelection(getValue()));
        return this;
    }

    public Chip deselect() {
        this.selected = false;
        Style.of(element).replaceCss(getDarkerColor(), getBackgroundStyle());
        Style.of(removeIcon).remove(getDarkerColor());
        deselectionHandlers.forEach(DeselectionHandler::onDeselection);
        return this;
    }

    public Chip toggleSelect() {
        if (selected) {
            deselect();
        } else {
            select();
        }
        return this;
    }

    public Chip setRemoveIcon(HTMLElement removeIcon) {
        this.removeIcon = DominoElement.of(removeIcon);
        ElementUtil.clear(removeIconContainer);
        removeIconContainer.appendChild(removeIcon);
        removeIcon.addEventListener("click", evt -> {
            remove();
            evt.stopPropagation();
        });
        return this;
    }

    public Chip remove() {
        return remove(false);
    }

    public Chip remove(boolean silent) {
        element.remove();
        if (!silent)
            removeHandlers.forEach(RemoveHandler::onRemove);
        return this;
    }

    public Chip setRemoveIcon(IsElement removeIcon) {
        return setRemoveIcon(removeIcon.asElement());
    }

    public Chip setColorScheme(ColorScheme colorScheme) {
        removeCurrentBackground();

        this.colorScheme = colorScheme;
        this.color = colorScheme.color();
        applyColor();
        return this;
    }

    public void applyColor() {
        element.style().add(this.color.getBackground());
        removeIcon.style().add(this.color.getBackground());
        setBorderColor(this.color);
    }

    public void removeCurrentBackground() {
        if (nonNull(this.colorScheme)) {
            element.style().remove(getBackgroundStyle());
            removeIcon.style().remove(getBackgroundStyle());
        }

        if (nonNull(this.color)) {
            element.style().remove(color.getBackground());
            removeIcon.style().remove(color.getBackground());
        }
    }

    public Chip setColor(Color color) {
        if (nonNull(this.colorScheme)) {
            element.style().remove(getBackgroundStyle());
            removeIcon.style().remove(getBackgroundStyle());
        }

        if (nonNull(this.color)) {
            element.style().remove(color.getBackground());
            removeIcon.style().remove(color.getBackground());
        }
        this.color = color;
        applyColor();
        return this;
    }

    private boolean hasColor() {
        return nonNull(this.colorScheme) || nonNull(color);
    }

    private String getDarkerColor() {
        return colorScheme.darker_4().getBackground();
    }

    private String getBackgroundStyle() {
        return this.color.getBackground();
    }

    public Chip setRemovable(boolean removable) {
        this.removable = removable;
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

    public Chip setLeftIcon(BaseIcon<?> icon) {
        setLeftAddon(icon.asElement());
        return this;
    }

    public Chip setLeftImg(HTMLImageElement imageElement) {
        setLeftAddon(imageElement);
        return this;
    }

    public Chip setLeftImg(IsElement<HTMLImageElement> imageElement) {
        return setLeftImg(imageElement.asElement());
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
            Style.of(leftAddon).add(leftBackground.getBackground());
        }
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }

    @Override
    public Chip addSelectionHandler(SelectionHandler<String> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    @Override
    public Chip addDeselectionHandler(DeselectionHandler deselectionHandler) {
        deselectionHandlers.add(deselectionHandler);
        return this;
    }

    @Override
    public Chip removeSelectionHandler(SelectionHandler<String> selectionHandler) {
        selectionHandlers.remove(selectionHandler);
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

    public Chip setBorderColor(Color borderColor) {
        if (Color.THEME.equals(color)) {
            Theme.addThemeChangeHandler(themeListener);
        } else {
            Theme.removeThemeChangeHandler(themeListener);
        }

        this.borderColor = borderColor;
        Style.of(element).setBorderColor(borderColor.getHex());
        return this;
    }

    public Chip removeLeftAddon() {
        ElementUtil.clear(leftAddonContainer);
        return this;
    }

    public String getValue() {
        return textContainer.textContent;
    }

    public DominoElement<HTMLDivElement> getTextContainer() {
        return DominoElement.of(textContainer);
    }

    public DominoElement<HTMLDivElement> getLeftAddonContainer() {
        return DominoElement.of(leftAddonContainer);
    }

    public DominoElement<HTMLDivElement> getRemoveIconContainer() {
        return DominoElement.of(removeIconContainer);
    }

    public DominoElement<HTMLElement> getRemoveIcon() {
        return DominoElement.of(removeIcon);
    }

    public DominoElement<HTMLElement> getLeftAddon() {
        return DominoElement.of(leftAddon);
    }
}
