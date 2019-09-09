package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.style.Styles;

public class DropdownButton extends BaseButton<DropdownButton> {

    private Icon caretIcon = Icons.ALL.keyboard_arrow_down();
    private ButtonsGroup groupElement = ButtonsGroup.create();
    private DropDownMenu dropDownMenu;

    public DropdownButton(String content, StyleType type) {
        super(content, type);
        initDropDown();
    }

    public DropdownButton(String content, Color background) {
        super(content, background);
        initDropDown();
    }

    public DropdownButton(String content) {
        super(content);
        initDropDown();
    }

    public DropdownButton(BaseIcon<?> icon, StyleType type) {
        super(icon, type);
        initDropDown();
    }

    public DropdownButton(BaseIcon<?> icon) {
        super(icon);
        initDropDown();
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

    public static DropdownButton create(BaseIcon<?> icon, StyleType type) {
        return new DropdownButton(icon, type);
    }

    public static DropdownButton create(BaseIcon<?> icon) {
        return new DropdownButton(icon);
    }

    public static DropdownButton createDefault(BaseIcon<?> icon) {
        return create(icon, StyleType.DEFAULT);
    }

    public static DropdownButton createPrimary(BaseIcon<?> icon) {
        return create(icon, StyleType.PRIMARY);
    }

    public static DropdownButton createSuccess(BaseIcon<?> icon) {
        return create(icon, StyleType.SUCCESS);
    }

    public static DropdownButton createInfo(BaseIcon<?> icon) {
        return create(icon, StyleType.INFO);
    }

    public static DropdownButton createWarning(BaseIcon<?> icon) {
        return create(icon, StyleType.WARNING);
    }

    public static DropdownButton createDanger(BaseIcon<?> icon) {
        return create(icon, StyleType.DANGER);
    }

    private void initDropDown() {
        buttonElement.style().add(ButtonStyles.BUTTON_DROPDOWN);
        dropDownMenu = DropDownMenu.create(groupElement);
        groupElement.appendChild(asDropDown());
        caretIcon.addCss(Styles.pull_right);
        buttonElement.appendChild(caretIcon);
        init(this);
        elevate(Elevation.LEVEL_1);
    }

    private HTMLElement asDropDown() {
        buttonElement.style().add(ButtonStyles.DROPDOWN_TOGGLE);
        buttonElement.setAttribute("data-toggle", "dropdown");
        buttonElement.setAttribute("aria-haspopup", true);
        buttonElement.setAttribute("aria-expanded", true);
        buttonElement.setAttribute("type", "button");
        addClickListener(evt -> {
            DropDownMenu.closeAllMenus();
            open();
            evt.stopPropagation();
        });
        return buttonElement.asElement();
    }

    private void open() {
        dropDownMenu.open();
    }

    /**
     * @deprecated use {@link #appendChild(DropdownAction)}
     */
    @Deprecated
    public DropdownButton addAction(DropdownAction action) {
        return appendChild(action);
    }

    public DropdownButton appendChild(DropdownAction action) {
        dropDownMenu.addAction(action);
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return groupElement.asElement();
    }

    public DropdownButton separator() {
        dropDownMenu.separator();
        return this;
    }


    public DropdownButton hideCaret() {
        caretIcon.hide();
        return this;
    }

    public DropdownButton showCaret() {
        caretIcon.show();
        return this;
    }

    public DropdownButton linkify() {
        groupElement.style().add(ButtonStyles.LINK);
        super.linkify();
        return this;
    }

    public DropdownButton delinkify() {
        groupElement.style().remove(ButtonStyles.LINK);
        super.deLinkify();
        return this;
    }

    @Override
    public DropdownButton bordered() {
        groupElement.addCss(ButtonStyles.BTN_GROUP_BORDERED);
        return super.bordered();
    }

    @Override
    public DropdownButton nonBordered() {
        groupElement.removeCss(ButtonStyles.BTN_GROUP_BORDERED);
        return super.nonBordered();
    }

    public DropdownButton setPosition(DropDownPosition position) {
        dropDownMenu.setPosition(position);
        return this;
    }

    public Icon getCaretIcon() {
        return caretIcon;
    }

    public DropDownMenu getDropDownMenu() {
        return dropDownMenu;
    }

}
