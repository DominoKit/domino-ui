package org.dominokit.domino.ui.button.group;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonStyles;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.Sizable;

/**
 * to be removed
 */
@Deprecated
public class JustifiedGroup extends BaseDominoElement<HTMLElement, JustifiedGroup> implements IsGroup<JustifiedGroup>, Sizable<JustifiedGroup> {

    private ButtonsGroup group = ButtonsGroup.create();

    public static JustifiedGroup create() {
        return new JustifiedGroup();
    }

    private JustifiedGroup() {
        group.style().add(ButtonStyles.JUSTIFIED);
        init(this);
    }

    @Override
    public JustifiedGroup appendChild(Button button) {
        group.appendChild(button);
        return this;
    }

    @Override
    public JustifiedGroup appendChild(DropdownButton dropDown) {
        group.appendChild(dropDown);
        return this;
    }

    @Override
    public JustifiedGroup verticalAlign() {
        group.verticalAlign();
        return this;
    }

    @Override
    public JustifiedGroup horizontalAlign() {
        group.horizontalAlign();
        return this;
    }

    @Override
    public HTMLElement element() {
        return group.element();
    }

    @Override
    public JustifiedGroup large() {
        group.large();
        return this;
    }

    @Override
    public JustifiedGroup medium() {
        group.medium();
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
