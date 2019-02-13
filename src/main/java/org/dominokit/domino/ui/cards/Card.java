package org.dominokit.domino.ui.cards;

import elemental2.dom.*;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.cards.CardStyles.*;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Card extends BaseDominoElement<HTMLDivElement, Card> implements HasBackground<Card> {

    private DominoElement<HTMLDivElement> root = DominoElement.div().addCss(CARD);
    private DominoElement<HTMLDivElement> header = DominoElement.div().addCss(HEADER);
    private DominoElement<HTMLHeadingElement> headerTitle = DominoElement.of(h(2));
    private DominoElement<HTMLElement> headerDescription = DominoElement.of(small());
    private DominoElement<HTMLUListElement> headerBar = DominoElement.of(ul()).addCss(HEADER_ACTIONS);
    private DominoElement<HTMLDivElement> body = DominoElement.div().addCss(BODY);

    private Text title = TextNode.empty();
    private Text description = TextNode.empty();
    private boolean collapsible = false;
    private HTMLLIElement collapseAction;
    private BaseIcon collapseIcon;
    private Collapsible bodyCollapsible;

    public Card() {
        headerTitle
                .appendChild(title)
                .appendChild(headerDescription);

        header.appendChild(headerTitle)
                .appendChild(headerBar);

        root.appendChild(header)
                .appendChild(body);

        headerDescription.appendChild(description);
        bodyCollapsible = Collapsible.create(body);

        bodyCollapsible.addHideHandler(() -> {
            if (collapsible) {
                collapseIcon.asElement().textContent = Icons.ALL.keyboard_arrow_down().getName();
            }
        });

        bodyCollapsible.addShowHandler(() -> {
            if (collapsible) {
                collapseIcon.asElement().textContent = Icons.ALL.keyboard_arrow_up().getName();
            }
        });

        init(this);
    }

    public static Card create() {
        Card card = new Card();
        card.removeChild(card.header.asElement());
        return card;
    }

    public static Card create(String title) {
        Card card = new Card();
        card.setTitle(title);
        return card;
    }

    public static Card create(String title, String description) {
        Card card = new Card();
        card.setTitle(title);
        card.setDescription(description);
        return card;
    }

    public static Card createProfile(String name, String info) {
        Card profileCard = Card.create(name, info);
        profileCard.style().setMarginBottom("0px");
        profileCard.setBackground(Color.THEME);
        return profileCard;
    }

    public Card setTitle(String titleText) {
        title.textContent = titleText;
        return this;
    }

    public Card setDescription(String descriptionText) {
        description.textContent = descriptionText;
        return this;
    }


    public Card appendDescriptionChild(Node node) {
        headerDescription.appendChild(node);
        return this;
    }

    public Card appendDescriptionChild(IsElement element) {
        return appendDescriptionChild(element.asElement());
    }


    public Card appendChild(Node content) {
        getBody().appendChild(content);
        return this;
    }

    public Card appendChild(IsElement element) {
        getBody().appendChild(element.asElement());
        return this;
    }

    public Card setHeaderBackground(Color background) {
        header.style().add(background.getBackground());
        return this;
    }

    public Card setBodyBackground(Color background) {
        body.style().add(background.getBackground());
        return this;
    }

    public Card fitContent() {
        style.add(FIT_CONTENT);
        return this;
    }

    public Card unFitContent() {
        style.remove(FIT_CONTENT);
        return this;
    }

    @Override
    public Card setBackground(Color background) {
        setHeaderBackground(background);
        setBodyBackground(background);
        return this;
    }

    public DominoElement<HTMLDivElement> getHeader() {
        return header;
    }

    public DominoElement<HTMLUListElement> getHeaderBar() {
        return headerBar;
    }

    public DominoElement<HTMLDivElement> getBody() {
        return body;
    }

    public DominoElement<HTMLHeadingElement> getHeaderTitle() {
        return headerTitle;
    }

    public DominoElement<HTMLElement> getHeaderDescription() {
        return headerDescription;
    }

    public static HTMLLIElement createIcon(BaseIcon<?> icon) {
        return li().add(
                a().add(icon))
                .asElement();
    }

    public Card addHeaderAction(BaseIcon<?> icon, EventListener eventListener) {
        HTMLLIElement actionItem = createHeaderAction(icon);
        actionItem.addEventListener("click", eventListener);

        putAction(actionItem);

        return this;
    }

    public Card addHeaderAction(HeaderAction headerAction) {
        putAction(headerAction.asElement());
        return this;
    }

    private void putAction(HTMLLIElement actionItem) {
        if (nonNull(collapseAction) && collapsible) {
            headerBar.insertBefore(actionItem, collapseAction);
        } else {
            headerBar.appendChild(actionItem);
        }
    }

    private HTMLLIElement createHeaderAction(BaseIcon<?> icon) {
        return li().add(a()
                .add(icon
                        .clickable()
                        .styler(style -> style
                                .add(Styles.pull_right, ACTION_ICON))))
                .asElement();
    }

    public Card setCollapsible() {
        collapseIcon = Icons.ALL.keyboard_arrow_up();
        if (isNull(collapseAction)) {
            collapseAction = createHeaderAction(collapseIcon);
        }
        collapseAction.addEventListener("click", evt -> {
            if (collapsible) {
                if (bodyCollapsible.isHidden()) {
                    show();
                } else {
                    hide();
                }
            }
        });

        putAction(collapseAction);

        this.collapsible = true;

        return this;
    }

    /**
     * @return T
     * @deprecated use {@link #hide()}
     */
    @Deprecated
    public Card collapse() {
        return hide();
    }

    /**
     * @return T
     * @deprecated use {@link #show()}
     */
    @Deprecated
    public Card expand() {
        return show();
    }


    public Card toggle() {
        if (isHidden()) {
            show();
        } else {
            hide();
        }
        return this;
    }

    @Override
    public Card show() {
        bodyCollapsible.show();
        return this;
    }

    @Override
    public Card hide() {
        bodyCollapsible.hide();
        return this;
    }

    @Override
    public boolean isHidden() {
        return bodyCollapsible.isHidden();
    }

    public Card setBodyPadding(String padding) {
        body.style().setPadding(padding);
        return this;
    }

    public Card setBodyPaddingLeft(String padding) {
        body.style().setPaddingLeft(padding);
        return this;
    }

    public Card setBodyPaddingRight(String padding) {
        body.style().setPaddingRight(padding);
        return this;
    }

    public Card setBodyPaddingTop(String padding) {
        body.style().setPaddingTop(padding);
        return this;
    }

    public Card setBodyPaddingBottom(String padding) {
        body.style().setPaddingBottom(padding);
        return this;
    }

    public Style<HTMLDivElement, DominoElement<HTMLDivElement>> bodyStyle() {
        return body.style();
    }

    public Card clearBody() {
        getBody().clearElement();
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return root.asElement();
    }
}
