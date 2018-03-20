package org.dominokit.domino.ui.button.group;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.utils.Sizable;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.dominokit.domino.ui.button.group.ButtonsGroup.BTN_GROUP;

public class JustifiedGroup implements IsElement<HTMLElement>, IsGroup<HTMLElement>, Sizable<JustifiedGroup> {

    private ButtonsGroup group = ButtonsGroup.create();

    public static JustifiedGroup create() {
        return new JustifiedGroup();
    }

    private JustifiedGroup() {
        group.asElement().classList.add(BTN_GROUP + "-justified");
    }

    @Override
    public HTMLElement addButton(Button button) {
        HTMLElement justify = button.justify();
        group.asElement().appendChild(justify);
        return justify;
    }

    @Override
    public HTMLElement addDropDown(DropdownButton dropDown) {
        HTMLElement justify = dropDown.justify();
        group.asElement().appendChild(justify);
        return justify;
    }

    @Override
    public IsGroup<HTMLElement> verticalAlign() {
        group.verticalAlign();
        return this;
    }

    @Override
    public IsGroup<HTMLElement> horizontalAlign() {
        group.horizontalAlign();
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return group.asElement();
    }

    @Override
    public JustifiedGroup large() {
        group.large();
        return this;
    }

    @Override
    public JustifiedGroup small() {
        group.small();
        return this;
    }

    @Override
    public JustifiedGroup xSmall() {
        group.xSmall();
        return this;
    }
}
