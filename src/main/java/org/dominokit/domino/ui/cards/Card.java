package org.dominokit.domino.ui.cards;

import elemental2.dom.*;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.li;

@Templated
public abstract class Card extends BaseDominoElement<HTMLDivElement, Card> implements HasBackground<Card>, IsElement<HTMLDivElement> {

    private Text title = DomGlobal.document.createTextNode("");
    private Text description = DomGlobal.document.createTextNode("");

    @DataElement
    HTMLDivElement header;

    @DataElement
    HTMLElement headerTitle;

    @DataElement
    HTMLElement headerDescription;

    @DataElement
    HTMLUListElement headerBar;

    @DataElement
    HTMLDivElement body;

    private boolean collapsible = false;
    private HTMLLIElement collapseAction;
    private Icon collapseIcon;
    private Collapsible bodyCollapsible;
    private int collapseDuration = 1;
    private boolean collapsed = false;

    public static Card create() {
        Templated_Card templated_basicCard = new Templated_Card();
        templated_basicCard.asElement().removeChild(templated_basicCard.header);
        return templated_basicCard;
    }

    public static Card create(String title) {
        Templated_Card templated_basicCard = new Templated_Card();
        templated_basicCard.setTitle(title);
        return templated_basicCard;
    }

    public static Card create(String title, String description) {
        Templated_Card templated_basicCard = new Templated_Card();
        templated_basicCard.setTitle(title);
        templated_basicCard.setDescription(description);
        return templated_basicCard;
    }

    public static Card createProfile(String name, String info) {
        Card profileCard = Card.create(name, info);
        profileCard.asElement().style.marginBottom = CSSProperties.MarginBottomUnionType.of(0);
        profileCard.setBackground(Color.THEME);
        return profileCard;
    }

    @PostConstruct
    void init() {
        headerTitle.insertBefore(title, headerDescription);
        headerDescription.appendChild(description);
        bodyCollapsible = Collapsible.create(body);
        if (collapsed) {
            bodyCollapsible.collapse();
        }

        bodyCollapsible.addCollapseHandler(() -> {
            if (collapsible) {
                collapseIcon.asElement().textContent = Icons.ALL.keyboard_arrow_down().getName();
            }
        });

        bodyCollapsible.addExpandHandler(() -> {
            if (collapsible) {
                collapseIcon.asElement().textContent = Icons.ALL.keyboard_arrow_up().getName();
            }
        });

        init(this);
    }

    public Card setTitle(String titleText) {
        title.textContent = titleText;
        return this;
    }

    public Card setDescription(String descriptionText) {
        description.textContent = descriptionText;
        return this;
    }


    /**
     * @deprecated use {@link #appendDescriptionChild(Node)}
     */
    @Deprecated
    public Card appendDescriptionContent(Node content) {
        headerDescription.appendChild(content);
        return this;
    }

    public Card appendDescriptionChild(Node node) {
        headerDescription.appendChild(node);
        return this;
    }

    public Card appendDescriptionChild(IsElement element) {
        return appendDescriptionChild(element.asElement());
    }

    /**
     * @deprecated use {@link #appendChild(IsElement)}
     */
    @Deprecated
    public Card appendContent(Node content) {
        getBody().appendChild(content);
        return this;
    }

    /**
     * @deprecated use {@link #appendChild(Node)}
     */
    @Deprecated
    public Card appendContent(IsElement element) {
        getBody().appendChild(element.asElement());
        return this;
    }

    public Card appendChild(Node content) {
        getBody().appendChild(content);
        return this;
    }

    public Card appendChild(IsElement element) {
        getBody().appendChild(element.asElement());
        return this;
    }

    public DominoElement<HTMLUListElement> getHeaderBar() {
        return DominoElement.of(headerBar);
    }

    public DominoElement<HTMLDivElement> getBody() {
        return DominoElement.of(body);
    }

    public Card setHeaderBackground(Color background) {
        Style.of(header).add(background.getBackground());
        return this;
    }

    public Card setBodyBackground(Color background) {
        Style.of(body).add(background.getBackground());
        return this;
    }

    @Override
    public Card setBackground(Color background) {
        setHeaderBackground(background);
        setBodyBackground(background);
        return this;
    }

    public DominoElement<HTMLDivElement> getHeader() {
        return DominoElement.of(header);
    }

    public DominoElement<HTMLElement> getHeaderTitle() {
        return DominoElement.of(headerTitle);
    }

    public DominoElement<HTMLElement> getHeaderDescription() {
        return DominoElement.of(headerDescription);
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
            if (collapsible) {
                if (bodyCollapsible.isCollapsed()) {
                    expand();
                } else {
                    collapse();
                }
            }
        });

        putAction(collapseAction);

        this.collapsible = true;

        return this;
    }

    public Card collapse() {
        bodyCollapsible.collapse();
        return this;
    }

    public Card expand() {
        bodyCollapsible.expand();
        return this;
    }


    public Card toggle() {
        if (this.collapsed) {
            expand();
        } else {
            collapse();
        }
        return this;
    }

    public boolean isCollapsed() {
        return bodyCollapsible.isCollapsed();
    }

    public Card setBodyPadding(String padding) {
        Style.of(body).setPadding(padding);
        return this;
    }

    public Card setBodyPaddingLeft(String padding) {
        Style.of(body).setPaddingLeft(padding);
        return this;
    }

    public Card setBodyPaddingRight(String padding) {
        Style.of(body).setPaddingRight(padding);
        return this;
    }

    public Card setBodyPaddingTop(String padding) {
        Style.of(body).setPaddingTop(padding);
        return this;
    }

    public Card setBodyPaddingBottom(String padding) {
        Style.of(body).setPaddingBottom(padding);
        return this;
    }

    public Style<HTMLDivElement, Card> style() {
        return Style.of(this);
    }

    public Style<HTMLDivElement, IsElement<HTMLDivElement>> bodyStyle() {
        return Style.of(body);
    }

    public Card setCollapseDuration(int collapseDuration) {
        this.collapseDuration = collapseDuration;
        return this;
    }

    public Card clearBody() {
        getBody().clearElement();
        return this;
    }
}
