package org.dominokit.domino.ui.tabs;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasClickableElement;
import elemental2.dom.*;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Tab implements HasClickableElement{

    private HTMLAnchorElement clickableElement=a().asElement();
    private HTMLLIElement tab=li().attr("role","presentation").add(clickableElement).asElement();
    private HTMLDivElement contentContainer =div().attr("role","tabpanel").css("tab-pane", "fade").asElement();
    private boolean active;

    public Tab(String text) {
        this(null, text);
    }

    public Tab(Icon icon) {
        this(icon, null);
    }

    public Tab(Icon icon, String text) {
        if(nonNull(icon)) {
            clickableElement.appendChild(icon.asElement());
        }
        if(nonNull(text)) {
            clickableElement.appendChild(new Text(text));
        }
    }

    public static Tab create(String text){
        return new Tab(text);
    }

    public static Tab create(Icon icon){
        return new Tab(icon);
    }

    public static Tab create(Icon icon, String text){
        return new Tab(icon, text);
    }

    public DominoElement<HTMLLIElement> getTab() {
        return DominoElement.of(tab);
    }

    public DominoElement<HTMLDivElement> getContentContainer() {
        return DominoElement.of(contentContainer);
    }

    /**
     * @deprecated use {@link #appendChild(Node)}
     * @param content
     * @return
     */
    @Deprecated
    public Tab appendContent(Node content){
        return appendChild(content);
    }


    public Tab appendChild(Node content){
        contentContainer.appendChild(content);
        return this;
    }

    public Tab appendChild(IsElement content){
        return appendChild(content.asElement());
    }


    public Tab activate(){
        tab.classList.add("active");
        contentContainer.classList.add("in");
        contentContainer.classList.add("active");
        this.active=true;
        return this;
    }

    public Tab deActivate(){
        tab.classList.remove("active");
        contentContainer.classList.remove("in");
        contentContainer.classList.remove("active");
        this.active=false;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return clickableElement;
    }
}
