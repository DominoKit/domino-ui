package org.dominokit.domino.ui.cards;

import elemental2.dom.*;
import org.dominokit.domino.ui.code.Code;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.HasBackground;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Card implements IsElement<HTMLDivElement>, HasBackground<Card> {

    private Text title = new Text("");
    private Text description = new Text("");

    private HTMLElement headerDescription=small().asElement();
    private HTMLElement headerTitle=h(2).add(headerDescription).asElement();
    private HTMLUListElement headerBar=ul().css("header-dropdown", "m-r--5").asElement();

    private HTMLDivElement header= div().add(headerTitle).add(headerBar).css("header").asElement();
    private HTMLDivElement body= div().css("body").asElement();
    private HTMLDivElement element=div().add(header).add(body).css("card").asElement();


    private boolean collapsible = false;
    private HTMLLIElement collapseAction;
    private boolean collapsed = false;
    private Icon collapseIcon;

    public Card() {
        headerTitle.insertBefore(title, headerDescription);
        headerDescription.appendChild(description);
    }

    public static Card create() {
        Card card = new Card();
        card.asElement().removeChild(card.header);
        return card;
    }

    public static Card create(String title) {
        Card card = new Card();
        card.setTitle(title);
        card.headerTitle.removeChild(card.headerDescription);
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
        profileCard.asElement().style.marginBottom = CSSProperties.MarginBottomUnionType.of(0);
        profileCard.setBackground(Color.THEME);

        return profileCard;
    }

    public static Card createCodeCard(String codeBlock) {
        return Card.create("Source Code")
                .setCollapsible()
                .collapse()
                .appendContent(Code.block(codeBlock).asElement());
    }

    public Card setTitle(String titleText) {
        title.textContent = titleText;
        return this;
    }

    public Card setDescription(String descriptionText) {
        description.textContent = descriptionText;
        return this;
    }

    public Card appendDescriptionContent(Node content) {
        headerDescription.appendChild(content);
        return this;
    }

    public Card appendContent(Node content) {
        getBody().appendChild(content);
        return this;
    }

    public HTMLUListElement getHeaderBar() {
        return headerBar;
    }

    public HTMLDivElement getBody() {
        return body;
    }

    public Card setHeaderBackground(Color background) {
        header.classList.add(background.getBackground());
        return this;
    }

    public Card setBodyBackground(Color background) {
        body.classList.add(background.getBackground());
        return this;
    }

    @Override
    public Card setBackground(Color background) {
        setHeaderBackground(background);
        setBodyBackground(background);
        return this;
    }

    public HTMLDivElement getHeader() {
        return header;
    }

    public HTMLElement getHeaderTitle() {
        return headerTitle;
    }

    public HTMLElement getHeaderDescription() {
        return headerDescription;
    }

    public static HTMLLIElement createIcon(Icon icon) {
        return li().add(
                a().add(icon.asElement()))
                .asElement();
    }

    public Card addHeaderAction(Icon icon, EventListener eventListener) {
        HTMLLIElement actionItem = createHeaderAction(icon);
        actionItem.addEventListener("click", eventListener);

        putAction(actionItem);

        return this;
    }

    private void putAction(HTMLLIElement actionItem) {
        if (nonNull(collapseAction) && collapsible) {
            headerBar.insertBefore(actionItem, collapseAction);
        } else {
            headerBar.appendChild(actionItem);
        }
    }

    private HTMLLIElement createHeaderAction(Icon icon) {
        return li().add(
                a().add(icon.asElement()))
                .asElement();
    }

    public Card setCollapsible() {

        collapseIcon = Icons.ALL.keyboard_arrow_up();
        if (isNull(collapseAction)) {
            collapseAction = createHeaderAction(collapseIcon);
        }
        collapseAction.addEventListener("click", evt -> {
            if (collapsible)
                if (collapsed) {
                    expand();
                } else {
                    collapse();
                }
        });

        putAction(collapseAction);

        this.collapsible = true;

        return this;
    }

    public Card collapse() {
        if (collapsible) {
            collapseIcon.asElement().textContent = Icons.ALL.keyboard_arrow_down().getName();
            getBody().style.display = "none";
            this.collapsed = true;
        }
        return this;
    }

    public Card expand() {
        if (collapsible) {
            collapseIcon.asElement().textContent = Icons.ALL.keyboard_arrow_up().getName();
            getBody().style.display = "block";
            this.collapsed = false;
        }

        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
