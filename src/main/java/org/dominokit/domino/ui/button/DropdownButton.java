package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HasContent;
import org.dominokit.domino.ui.utils.Justifiable;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.nonNull;

public class DropdownButton extends DominoElement<DropdownButton> implements Justifiable, HasContent<DropdownButton>, HasBackground<DropdownButton> {

    private HTMLElement caret = Elements.span().css("caret").asElement();
    private HTMLElement groupElement = ButtonsGroup.create().asElement();
    private DropDownMenu dropDownMenu;
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
        dropDownMenu = DropDownMenu.create(groupElement);
        groupElement.appendChild(asDropDown(button));
        this.button.asElement().appendChild(caret);
        initCollapsible(this);
    }

    private HTMLElement asDropDown(Button button) {
        HTMLElement buttonElement = button.asElement();
        buttonElement.classList.add("dropdown-toggle");
        buttonElement.setAttribute("data-toggle", "dropdown");
        buttonElement.setAttribute("aria-haspopup", true);
        buttonElement.setAttribute("aria-expanded", true);
        buttonElement.setAttribute("type", "button");
        button.addClickListener(evt -> {
            dropDownMenu.closeAllMenus();
            open();
            evt.stopPropagation();
        });
        return buttonElement;
    }

    private void open() {
        dropDownMenu.open();
    }

    public DropdownButton addAction(DropdownAction action) {
        dropDownMenu.addAction(action);
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return groupElement;
    }

    public DropdownButton separator() {
        dropDownMenu.separator();
        return this;
    }

    @Override
    public HTMLElement justify() {
        return asElement();
    }

    @Override
    public DropdownButton setContent(String content) {
        button.setContent(content);
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

    public DropdownButton linkify() {
        groupElement.classList.add("link");
        button.linkify();
        return this;
    }

    public DropdownButton delinkify() {
        groupElement.classList.remove("link");
        button.delinkify();
        return this;
    }

    public DropdownButton setPosition(DropDownPosition position) {
        dropDownMenu.setPosition(position);
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

    public DropDownMenu getDropDownMenu() {
        return dropDownMenu;
    }

    public Button getButton() {
        return button;
    }

}
