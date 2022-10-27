package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLAnchorElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.DominoElement;

public class LinkButton extends BaseButton<HTMLAnchorElement, LinkButton> {

    /**
     * creates a Button without a text and with {@link Elevation#LEVEL_1}
     */
    public LinkButton() {
    }

    /**
     * @param text String, the button text
     */
    public LinkButton(String text) {
        super(text);
    }

    /**
     * @param icon The button icon
     */
    public LinkButton(BaseIcon<?> icon) {
        super(icon);
    }

    public LinkButton(String text, BaseIcon<?> icon) {
        super(text, icon);
    }

    /**
     * creats a Button using {@link Button#Button()}
     *
     * @return new Button instance
     */
    public static LinkButton create() {
        return new LinkButton();
    }

    /**
     * create a button using {@link Button#Button(String)}
     *
     * @param text String button text
     * @return new Button instance
     */
    public static LinkButton create(String text) {
        return new LinkButton(text);
    }

    /**
     * creates a Button with an icon by calling {@link Button#Button(BaseIcon)}
     *
     * @param icon {@link BaseIcon}, the button icon
     * @return new Button instance
     */
    public static LinkButton create(BaseIcon<?> icon) {
        return new LinkButton(icon);
    }

    /**
     * creates a Button with an icon by calling {@link LinkButton#LinkButton(BaseIcon)}
     *
     * @param icon {@link BaseIcon}, the button icon
     * @return new Button instance
     */
    public static LinkButton create(String text, BaseIcon<?> icon) {
        return new LinkButton(text, icon);
    }

    @Override
    protected DominoElement<HTMLAnchorElement> createButtonElement() {
        return DominoElement.a();
    }
}