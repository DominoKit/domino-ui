package org.dominokit.domino.ui.cards;

import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.*;
import org.dominokit.domino.ui.code.Code;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
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
public abstract class Card implements IsElement<HTMLDivElement>, HasBackground<Card> {

    private Text title = new Text("");
    private Text description = new Text("");

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
    private boolean collapsed = false;
    private Icon collapseIcon;

    public static Card create() {
        Templated_Card templated_basicCard = new Templated_Card();
        templated_basicCard.asElement().removeChild(templated_basicCard.header);
        return templated_basicCard;
    }

    public static Card create(String title) {
        Templated_Card templated_basicCard = new Templated_Card();
        templated_basicCard.setTitle(title);
        templated_basicCard.headerTitle.removeChild(templated_basicCard.headerDescription);
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

    public static Card createCodeCard(String codeBlock) {
        return Card.create("Source Code")
                .setCollapsible()
                .collapse()
                .appendContent(Code.block(codeBlock).asElement());
    }

    public static Card createCodeCard(ExternalTextResource codeResource) {
        Code.Block block = Code.block();
        try {
            codeResource.getText(new ResourceCallback<TextResource>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("could not load code from external resource", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    block.setCode(resource.getText());
                }
            });
        } catch (ResourceException e) {
            DomGlobal.console.error("could not load code from external resource", e);
        }
        return Card.create("Source Code")
                .setCollapsible()
                .collapse()
                .appendContent(block.asElement());
    }

    @PostConstruct
    void init() {
        headerTitle.insertBefore(title, headerDescription);
        headerDescription.appendChild(description);
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
        }
        getBody().style.display = "none";
        this.collapsed = true;
        return this;
    }

    public Card expand() {
        if (collapsible) {
            collapseIcon.asElement().textContent = Icons.ALL.keyboard_arrow_up().getName();
        }
        getBody().style.display = "block";
        this.collapsed = false;
        return this;
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

}
