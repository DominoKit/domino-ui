package org.dominokit.domino.ui.button.group;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.Sizable;
import org.jboss.gwt.elemento.core.IsElement;

import static org.dominokit.domino.ui.button.group.ButtonsGroup.BTN_GROUP;

public class JustifiedGroup extends DominoElement<HTMLElement, JustifiedGroup> implements IsElement<HTMLElement>, IsGroup<HTMLElement>, Sizable<JustifiedGroup> {

    private ButtonsGroup group = ButtonsGroup.create();

    public static JustifiedGroup create() {
        return new JustifiedGroup();
    }

    private JustifiedGroup() {
        group.asElement().classList.add(BTN_GROUP + "-justified");
        init(this);
    }

    /**
     * @deprecated use {@link #appendChild(Button)}
     * @param button
     * @return
     */
    @Deprecated
    @Override
    public HTMLElement addButton(Button button) {
        return appendChild(button);
    }

    /**
     * @deprecated use {@link #appendChild(DropdownButton)}
     * @param dropDown
     * @return
     */
    @Override
    public HTMLElement addDropDown(DropdownButton dropDown) {
        return appendChild(dropDown);
    }

    @Override
    public HTMLElement appendChild(Button button) {
        HTMLElement justify = button.asElement();
        group.asElement().appendChild(justify);
        return justify;
    }

    @Override
    public HTMLElement appendChild(DropdownButton dropDown) {
        HTMLElement justify = dropDown.asElement();
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

    public Style<HTMLElement, JustifiedGroup> style(){
        return Style.of(this);
    }
}
