package org.dominokit.domino.ui.layout;


import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLParagraphElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

public class EmptyState extends BaseDominoElement<HTMLDivElement, EmptyState> {

    private HTMLDivElement element = div().css("empty-state", Styles.align_center, Styles.vertical_center).element();
    private HTMLDivElement iconContainer = div().element();
    private HTMLHeadingElement titleContainer = h(4).element();
    private HTMLParagraphElement descriptionContainer = p().element();
    private Color iconColor;
    private Color titleColor;
    private Color descriptionColor;

    public EmptyState(BaseIcon<?> icon) {
        iconContainer.appendChild(icon.element());
        element.appendChild(iconContainer);
        element.appendChild(titleContainer);
        element.appendChild(descriptionContainer);
        init(this);
    }

    public static EmptyState create(BaseIcon<?> icon) {
        return new EmptyState(icon);
    }

    public EmptyState setTitle(String title) {
        titleContainer.textContent = title;
        return this;
    }

    public EmptyState setDescription(String description) {
        descriptionContainer.textContent = description;
        return this;
    }

    public EmptyState setIconColor(Color iconColor) {
        if (nonNull(this.iconColor)) {
            Style.of(iconContainer).remove(this.iconColor.getStyle());
        }
        this.iconColor = iconColor;
        Style.of(iconContainer).add(iconColor.getStyle());
        return this;
    }

    public EmptyState setTitleColor(Color titleColor) {
        if (nonNull(this.titleColor)) {
            Style.of(titleContainer).remove(this.titleColor.getStyle());
        }
        this.titleColor = titleColor;
        Style.of(titleContainer).add(titleColor.getStyle());
        return this;
    }

    public EmptyState setDescriptionColor(Color descriptionColor) {
        if (nonNull(this.descriptionColor)) {
            Style.of(descriptionContainer).remove(this.descriptionColor.getStyle());
        }
        this.descriptionColor = descriptionColor;
        Style.of(descriptionContainer).add(descriptionColor.getStyle());
        return this;
    }

    public DominoElement<HTMLDivElement> getIconContainer() {
        return DominoElement.of(iconContainer);
    }

    public DominoElement<HTMLHeadingElement> getTitleContainer() {
        return DominoElement.of(titleContainer);
    }

    public DominoElement<HTMLParagraphElement> getDescriptionContainer() {
        return DominoElement.of(descriptionContainer);
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }
}