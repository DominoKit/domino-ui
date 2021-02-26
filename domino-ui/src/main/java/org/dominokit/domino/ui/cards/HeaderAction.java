package org.dominokit.domino.ui.cards;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.cards.CardStyles.ACTION_ICON;
import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.li;

/**
 * A component for header action of the {@link Card}.
 * <p>
 * This component has icon and event listener to be called when the action gets executed.
 *
 * @see BaseDominoElement
 * @see Card
 * @see Card#addHeaderAction(HeaderAction)
 */
public class HeaderAction extends BaseDominoElement<HTMLLIElement, HeaderAction> {

    private final HTMLLIElement element = li().element();
    private final HTMLAnchorElement anchorElement = a().element();
    private final BaseIcon<?> icon;

    /**
     * Creates header action with icon and event listener
     *
     * @param icon          the {@link BaseIcon} of the action
     * @param eventListener The {@link EventListener} to be called when execute the action
     * @return new instance
     */
    public static HeaderAction create(BaseIcon<?> icon, EventListener eventListener) {
        return new HeaderAction(icon, eventListener);
    }

    /**
     * Creates header action with icon
     *
     * @param icon the {@link BaseIcon} of the action
     * @return new instance
     */
    public static HeaderAction create(BaseIcon<?> icon) {
        return new HeaderAction(icon);
    }

    public HeaderAction(BaseIcon<?> icon) {
        this.icon = icon;
        this.icon.clickable()
                .styler(style -> style.add(Styles.pull_right, ACTION_ICON));
        anchorElement.appendChild(this.icon.element());
        element.appendChild(anchorElement);
        init(this);
    }

    public HeaderAction(BaseIcon<?> icon, EventListener eventListener) {
        this(icon);
        anchorElement.addEventListener("click", eventListener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLLIElement element() {
        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement getClickableElement() {
        return anchorElement;
    }

    /**
     * @return The action {@link BaseIcon}
     */
    public BaseIcon<?> getIcon() {
        return icon;
    }
}
