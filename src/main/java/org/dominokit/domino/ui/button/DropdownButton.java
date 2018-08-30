package org.dominokit.domino.ui.button;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.StyleType;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;

public class DropdownButton extends BaseButton<DropdownButton> {

    private HTMLElement caret = Elements.span().css("caret").asElement();
    private HTMLElement groupElement = ButtonsGroup.create().asElement();
    private HTMLUListElement actionsElement = Elements.ul().css("dropdown-menu").asElement();
    private Color background;
    private boolean touchMoved;

    public DropdownButton(String content) {
        super(content);
    }

    private DropDownPosition position = DropDownPosition.BOTTOM_RIGHT;

    public DropdownButton(String content, StyleType type) {
        super(content, type);
    }

    public DropdownButton(String content, Color background) {
        super(content);
        setBackground(background);
    }

    public DropdownButton(Icon icon, StyleType type) {
        super(icon, type);
    }

    public DropdownButton(Icon icon) {
        super(icon);
    }

    public DropdownButton() {
        groupElement.appendChild(asDropDown(groupElement));
        asElement().appendChild(caret);
        groupElement.appendChild(actionsElement);
        addHideListener();
    }

    private void addHideListener() {
        EventListener listener = this::closeAllGroups;
        document.addEventListener("click", listener);
        document.addEventListener("touchend", evt -> {
            if (!touchMoved) {
                closeAllGroups(evt);
            }
            touchMoved = false;
        });
        document.addEventListener("touchmove", evt -> this.touchMoved = true);
    }

    private void closeAllGroups(Event evt) {
        HTMLElement element = Js.uncheckedCast(evt.target);
        if (!groupElement.contains(element)) {
            closeAllGroups();
        }
    }

    private HTMLElement asDropDown( HTMLElement groupElement) {
        HTMLElement buttonElement = asElement();
        buttonElement.classList.add("dropdown-toggle");
        buttonElement.setAttribute("data-toggle", "dropdown");
        buttonElement.setAttribute("aria-haspopup", true);
        buttonElement.setAttribute("aria-expanded", true);
        buttonElement.setAttribute("type", "button");
        addClickListener(evt -> {
            closeAllGroups();
            open(groupElement);
            evt.stopPropagation();
        });
        return buttonElement;
    }

    private void closeAllGroups() {
        NodeList<Element> elementsByName = document.body.querySelectorAll(".btn-group.open");
        for (int i = 0; i < elementsByName.length; i++) {
            Element item = elementsByName.item(i);
            if (isOpened(item)) {
                close(item);
            }
        }
    }

    private boolean isOpened(Element item) {
        return item.classList.contains("open");
    }

    private void open(HTMLElement groupElement) {
        groupElement.classList.add("open");
        position.position(actionsElement, groupElement);
    }

    private void close(Element item) {
        item.classList.remove("open");
    }

    public DropdownButton addAction(DropdownAction action) {
        action.addSelectionHandler(() -> close(groupElement));
        actionsElement.appendChild(action.asElement());
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return groupElement;
    }

    public DropdownButton separator() {
        Separator separator = new Separator();
        actionsElement.appendChild(separator.asElement());
        return this;
    }

    public DropdownButton hideCaret() {
        if (isCaretAdded())
            caret.remove();
        return this;
    }

    public DropdownButton showCaret() {
        if (!isCaretAdded())
            asElement().appendChild(caret);
        return this;
    }

    private boolean isCaretAdded() {
        return asElement().contains(caret);
    }

    @Override
    public DropdownButton setBackground(Color background) {
        if (nonNull(this.background))
            asElement().classList.remove(this.background.getBackground());
        asElement().classList.add(background.getBackground());
        this.background = background;
        return this;
    }

    public DropdownButton linkify() {
        groupElement.classList.add("link");
        linkify();
        return this;
    }

    public DropdownButton delinkify() {
        groupElement.classList.remove("link");
        deLinkify();
        return this;
    }

    public DropdownButton setPosition(DropDownPosition position) {
        this.position = position;
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

    private class Separator implements IsElement<HTMLLIElement> {

        private HTMLLIElement separator = Elements.li().attr("role", "separator").css("divider").asElement();

        @Override
        public HTMLLIElement asElement() {
            return separator;
        }
    }

    public Style<HTMLElement, DropdownButton> style() {
        return Style.of(this);
    }
}
