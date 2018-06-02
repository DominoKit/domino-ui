package org.dominokit.domino.ui.button;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HasContent;
import org.dominokit.domino.ui.utils.Justifiable;
import org.jboss.gwt.elemento.core.Elements;

import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;

public class DropdownButton implements Justifiable, HasContent<DropdownButton>, HasBackground<DropdownButton> {

    private HTMLElement caret = Elements.span().css("caret").asElement();
    private HTMLElement groupElement = ButtonsGroup.create().asElement();
    private HTMLUListElement actionsElement = Elements.ul().css("dropdown-menu").asElement();
    private List<Justifiable> items = new LinkedList<>();
    private Button button;
    private Color background;

    public DropdownButton(String content, StyleType type) {
        this(Button.create(content).setButtonType(type));
    }

    public DropdownButton(String content, Color background) {
        this(Button.create(content).setBackground(background));
    }

    public DropdownButton(String content) {
        this(Button.create(content));
    }

    public DropdownButton(Icon icon, StyleType type) {
        this(IconButton.create(icon).setButtonType(type));
    }

    public DropdownButton(Icon icon) {
        this(IconButton.create(icon));
    }

    public DropdownButton(Button button) {
        this.button = button;
        addHideListener();
        groupElement.appendChild(asDropDown(this.button.asElement(), groupElement));
        this.button.asElement().appendChild(caret);
        groupElement.appendChild(actionsElement);
    }

    private void addHideListener() {
        DomGlobal.window.addEventListener("click", evt -> {
            HTMLElement element = Js.cast(evt.target);
            if (!element.classList.contains("btn"))
                closeAllGroups();
        });
    }

    private HTMLElement asDropDown(HTMLElement buttonElement, HTMLElement groupElement) {
        buttonElement.classList.add("dropdown-toggle");
        buttonElement.setAttribute("data-toggle", "dropdown");
        buttonElement.setAttribute("aria-haspopup", true);
        buttonElement.setAttribute("aria-expanded", true);
        buttonElement.setAttribute("type", "button");
        buttonElement.addEventListener("click", event -> {
            closeAllGroups();
            open(groupElement);
            event.stopPropagation();
        });
        return buttonElement;
    }

    private void closeAllGroups() {
        NodeList<Element> elementsByName = DomGlobal.document.body.getElementsByClassName(groupElement.className);
        for (int i = 0; i < elementsByName.length; i++) {
            Element item = elementsByName.item(i);
            if (isOpened(item))
                close(item);
        }
    }

    private boolean isOpened(Element item) {
        return item.classList.contains("open");
    }

    private void open(HTMLElement groupElement) {
        groupElement.classList.add("open");
    }

    private void close(Element item) {
        item.classList.remove("open");
    }

    public DropdownButton addAction(DropdownAction action) {
        items.add(action);
        actionsElement.appendChild(action.asElement());
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return groupElement;
    }

    public DropdownButton separator() {
        JustifiableSeparator justifiableSeparator = new JustifiableSeparator();
        items.add(justifiableSeparator);
        actionsElement.appendChild(justifiableSeparator.asElement());
        return this;
    }

    @Override
    public HTMLElement justify() {
        Button button = Button.create(this.button.asElement().textContent);

        for (String style : this.button.asElement().classList.asList()) {
            button.asElement().classList.add(style);
        }

        DropdownButton cloneDropdownButton = new DropdownButton(button);
        for (Justifiable item : items) {
            cloneDropdownButton.actionsElement.appendChild(item.justify());
        }
        return cloneDropdownButton.asElement();
    }

    @Override
    public DropdownButton setContent(String content) {
        button.setContent(content);
        return this;
    }

    public DropdownButton dropup() {
        groupElement.classList.add("dropup");
        return this;
    }

    public DropdownButton dropdown() {
        groupElement.classList.remove("dropup");
        return this;
    }

    public DropdownButton hideCaret() {
        if (isCaretAdded())
            caret.remove();
        return this;
    }

    public DropdownButton showCaret() {
        if (!isCaretAdded())
            button.asElement().appendChild(caret);
        return this;
    }

    private boolean isCaretAdded() {
        return button.asElement().contains(caret);
    }

    @Override
    public DropdownButton setBackground(Color background) {
        if (nonNull(this.background))
            button.asElement().classList.remove(this.background.getBackground());
        button.asElement().classList.add(background.getBackground());
        this.background = background;
        return this;
    }

    public static DropdownButton create(String content) {
        return new DropdownButton(content);
    }

    public static DropdownButton create(String content, Color background) {
        return new DropdownButton(content, background);
    }

    public static DropdownButton create(String content, StyleType type) {
        return new DropdownButton(content, type);
    }

    public static DropdownButton createDefault(String content) {
        return create(content, StyleType.DEFAULT);
    }

    public static DropdownButton createPrimary(String content) {
        return create(content, StyleType.PRIMARY);
    }

    public static DropdownButton createSuccess(String content) {
        return create(content, StyleType.SUCCESS);
    }

    public static DropdownButton createInfo(String content) {
        return create(content, StyleType.INFO);
    }

    public static DropdownButton createWarning(String content) {
        return create(content, StyleType.WARNING);
    }

    public static DropdownButton createDanger(String content) {
        return create(content, StyleType.DANGER);
    }

    public static DropdownButton create(Icon icon, StyleType type) {
        return new DropdownButton(icon, type);
    }

    public static DropdownButton create(Icon icon) {
        return new DropdownButton(icon);
    }

    public static DropdownButton createDefault(Icon icon) {
        return create(icon, StyleType.DEFAULT);
    }

    public static DropdownButton createPrimary(Icon icon) {
        return create(icon, StyleType.PRIMARY);
    }

    public static DropdownButton createSuccess(Icon icon) {
        return create(icon, StyleType.SUCCESS);
    }

    public static DropdownButton createInfo(Icon icon) {
        return create(icon, StyleType.INFO);
    }

    public static DropdownButton createWarning(Icon icon) {
        return create(icon, StyleType.WARNING);
    }

    public static DropdownButton createDanger(Icon icon) {
        return create(icon, StyleType.DANGER);
    }

    public HTMLElement getCaret() {
        return caret;
    }

    public HTMLUListElement getActionsElement() {
        return actionsElement;
    }

    public Button getButton() {
        return button;
    }

    private class JustifiableSeparator implements Justifiable {

        private HTMLLIElement separator = Elements.li().attr("role", "separator").css("divider").asElement();

        @Override
        public HTMLElement justify() {
            return (HTMLElement) separator.cloneNode(true);
        }

        @Override
        public HTMLElement asElement() {
            return separator;
        }
    }
}
