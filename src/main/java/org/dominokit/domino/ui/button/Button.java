package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.StyleType;

public class Button extends BaseButton<Button> {

    public Button() {
        init(this);
    }

    public Button(String content) {
        this();
        setContent(content);
    }

    public Button(String content, StyleType type) {
        this(content);
        setButtonType(type);
    }

    public Button(Icon icon) {
        super(icon);
        init(this);
    }

    public Button(Icon icon, StyleType type) {
        this(icon);
        setButtonType(type);
    }

    private static Button create(String content, StyleType type) {
        return new Button(content, type);
    }

    public static Button create() {
        return new Button();
    }

    public static Button create(String content) {
        return new Button(content);
    }

    public static Button createDefault(String content) {
        return create(content, StyleType.DEFAULT);
    }

    public static Button createPrimary(String content) {
        return create(content, StyleType.PRIMARY);
    }

    public static Button createSuccess(String content) {
        return create(content, StyleType.SUCCESS);
    }

    public static Button createInfo(String content) {
        return create(content, StyleType.INFO);
    }

    public static Button createWarning(String content) {
        return create(content, StyleType.WARNING);
    }

    public static Button createDanger(String content) {
        return create(content, StyleType.DANGER);
    }

    public static Button create(Icon icon) {
        return new Button(icon);
    }

    private static Button create(Icon icon, StyleType type) {
        return new Button(icon, type);
    }

    public static Button createDefault(Icon icon) {
        return create(icon, StyleType.DEFAULT);
    }

    public static Button createPrimary(Icon icon) {
        return create(icon, StyleType.PRIMARY);
    }

    public static Button createSuccess(Icon icon) {
        return create(icon, StyleType.SUCCESS);
    }

    public static Button createInfo(Icon icon) {
        return create(icon, StyleType.INFO);
    }

    public static Button createWarning(Icon icon) {
        return create(icon, StyleType.WARNING);
    }

    public static Button createDanger(Icon icon) {
        return create(icon, StyleType.DANGER);
    }

    @Override
    public HTMLElement asElement() {
        return buttonElement;
    }
}
