package org.dominokit.domino.ui.button;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.style.WaveStyle;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.nonNull;

public class IconButton extends Button {

    private Icon icon;
    private String content;

    public IconButton(Icon icon) {
        setIcon(icon);
    }

    public IconButton(Icon icon, StyleType type) {
        this(icon);
        setButtonType(type);
    }

    public static IconButton create(Icon icon) {
        return new IconButton(icon);
    }

    private static IconButton create(Icon icon, StyleType type) {
        return new IconButton(icon, type);
    }

    public static IconButton createDefault(Icon icon) {
        return create(icon, StyleType.DEFAULT);
    }

    public static IconButton createPrimary(Icon icon) {
        return create(icon, StyleType.PRIMARY);
    }

    public static IconButton createSuccess(Icon icon) {
        return create(icon, StyleType.SUCCESS);
    }

    public static IconButton createInfo(Icon icon) {
        return create(icon, StyleType.INFO);
    }

    public static IconButton createWarning(Icon icon) {
        return create(icon, StyleType.WARNING);
    }

    public static IconButton createDanger(Icon icon) {
        return create(icon, StyleType.DANGER);
    }

    public IconButton setIcon(Icon icon) {
        if (nonNull(this.icon)) {
            buttonElement.textContent = "";
            this.icon.asElement().remove();
            buttonElement.appendChild(icon.asElement());
            buttonElement.appendChild(Elements.span().textContent(content).asElement());
        } else {
            buttonElement.appendChild(icon.asElement());
        }
        this.icon = icon;
        return this;
    }

    public IconButton circle(CircleSize size) {
        buttonElement.classList.add(size.getStyle());
        applyCircleWaves();
        return this;
    }

    private void applyCircleWaves() {
        applyWaveStyle(WaveStyle.CIRCLE);
        applyWaveStyle(WaveStyle.FLOAT);
    }

    @Override
    public IconButton setContent(String content) {
        this.content = content;
        buttonElement.textContent = "";
        buttonElement.appendChild(icon.asElement());
        buttonElement.appendChild(Elements.span().textContent(content).asElement());
        return this;
    }

}
